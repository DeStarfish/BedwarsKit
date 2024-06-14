


























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlaceBlockCorrect implements Listener {
    private static final GameState running = GameState.RUNNING;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            Player player = event.getPlayer();
            Block block = event.getClickedBlock();
            Location blockLocation = block.getLocation();

            if (BedwarsRel.getInstance() == null) {
                return;
            }

            BedwarsRel bedwarsRel = BedwarsRel.getInstance();

            if (bedwarsRel.getGameManager() == null) {
                return;
            }
            GameManager gameManager = bedwarsRel.getGameManager();

            Game game = gameManager.getGameOfPlayer(player);

            if (game == null) {
                return;
            }

            if (block.getType().toString().contains("CHEST")) {
                return;
            }

            ItemStack itemInHand = getItemInHand(player);

            if (itemInHand == null || !itemInHand.getType().isBlock() || itemInHand.getType() == Material.AIR) {
                return;
            }


            if (placeCorrect_resourceSpawner) {

                if (game.getState() == running) {
                    for (ResourceSpawner rs :
                            game.getResourceSpawners()) {
                        Location spawnerLocation = rs.getLocation();
                        double distance = spawnerLocation.distance(blockLocation);

                        if (distance <= placeCorrect_ResSpawner_dis) {

                            event.setCancelled(true);

                            if (!Objects.equals(placeCorrect_resourceSpawner_mess_chat, "")) {
                                sendMessage(player, placeCorrect_resourceSpawner_mess_chat);
                            }
                            if (!Objects.equals(placeCorrect_resourceSpawner_mess_title, "")) {
                                String titleReal = placeCorrect_resourceSpawner_mess_title;
                                if (!Objects.equals(placeCorrect_resourceSpawner_mess_subtitle, "")) {
                                    String subtitleReal = placeCorrect_resourceSpawner_mess_subtitle;

                                    sendTitle(player, titleReal, subtitleReal);
                                }
                            } else if (!Objects.equals(placeCorrect_resourceSpawner_mess_subtitle, "")) {
                                String titleReal = " ";
                                String subtitleReal = placeCorrect_resourceSpawner_mess_subtitle;

                                sendTitle(player, titleReal, subtitleReal);
                            }
                            if (!Objects.equals(placeCorrect_resourceSpawner_mess_actionbar, "")) {
                                SendActionBar.sendActionBar(player, placeCorrect_resourceSpawner_mess_actionbar);
                            }
                            return;
                        }
                    }
                }
            }

            if (placeCorrect_playerSpawnLoc) {
                if (game.getState() == running) {
                    for (Team team : game.getPlayingTeams()) {
                        Location teamspawnLocation = team.getSpawnLocation();
                        double distance = teamspawnLocation.distance(blockLocation);

                        if (distance <= LevelConfigHandler.placeCorrect_PlayerSpawnLoc_dis) {

                            event.setCancelled(true);

                            if (!placeCorrect_playerSpawnLoc_mess_chat.isEmpty()) {
                                sendMessage(player, placeCorrect_playerSpawnLoc_mess_chat);
                            }
                            if (!placeCorrect_playerSpawnLoc_mess_title.isEmpty()) {
                                String titleReal = placeCorrect_playerSpawnLoc_mess_title;
                                if (!placeCorrect_playerSpawnLoc_mess_subtitle.isEmpty()) {
                                    String subtitleReal = t(placeCorrect_playerSpawnLoc_mess_subtitle);

                                    sendTitle(player, titleReal, subtitleReal);
                                }
                            } else if (!placeCorrect_playerSpawnLoc_mess_subtitle.isEmpty()) {
                                String titleReal = " ";
                                String subtitleReal = t(placeCorrect_playerSpawnLoc_mess_subtitle);

                                sendTitle(player, titleReal, subtitleReal);
                            }
                            if (!placeCorrect_playerSpawnLoc_mess_actionbar.isEmpty()) {
                                sendActionBar(player, placeCorrect_playerSpawnLoc_mess_actionbar);
                            }
                            return;
                        }
                    }
                }
            }
        }
    }


    @EventHandler(priority = EventPriority.HIGH)
    public void on(final BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();
        Location blockLocation = block.getLocation();

        if (BedwarsRel.getInstance() == null) {
            return;
        }

        BedwarsRel bedwarsRel = BedwarsRel.getInstance();

        if (bedwarsRel.getGameManager() == null) {
            return;
        }
        GameManager gameManager = bedwarsRel.getGameManager();

        Game game = gameManager.getGameByLocation(blockLocation);

        if (game == null) {
            return;
        }

        if (placeCorrect_resourceSpawner) {

            if (game.getState() == running) {
                for (ResourceSpawner rs :
                        game.getResourceSpawners()) {
                    Location spawnerLocation = rs.getLocation();
                    double distance = spawnerLocation.distance(blockLocation);

                    if (distance <= placeCorrect_ResSpawner_dis) {

                        event.setCancelled(true);

                        return;
                    }
                }
            }
        }

        if (placeCorrect_playerSpawnLoc) {
            if (game.getState() == running) {
                for (Team team : game.getPlayingTeams()) {
                    Location teamspawnLocation = team.getSpawnLocation();
                    double distance = teamspawnLocation.distance(blockLocation);

                    if (distance <= LevelConfigHandler.placeCorrect_PlayerSpawnLoc_dis) {

                        event.setCancelled(true);

                        return;
                    }
                }
            }
        }
    }
}