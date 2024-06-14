































/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelClick implements Listener {
    private static final String className = RelClick.class.getSimpleName();
    private static final GameState waiting = GameState.WAITING;
    private static final GameState running = GameState.RUNNING;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final PlayerInteractEvent event) {
        if (event.getPlayer() == null) {
            return;
        }

        Player player = event.getPlayer();
        if (!player.isOnline()) {
            return;
        }

        if (BedwarsRel.getInstance() == null) {
            return;
        }
        BedwarsRel bedwarsRel = BedwarsRel.getInstance();

        if (bedwarsRel.getGameManager() == null) {
            return;
        }
        GameManager gameManager = bedwarsRel.getGameManager();

        if (gameManager.getGameOfPlayer(player) == null) {
            return;
        }
        Game game = gameManager.getGameOfPlayer(player);

        if (game == null) {
            return;
        }

        GameCycle cycle = game.getCycle();
        if (noInteractWhileEndGame) {
            if (cycle.isEndGameRunning()) {
                event.setCancelled(true);
                if (isDebug()) {
                    le(className, "[Warning] silent return : cycle.isEndGameRunning");
                }
                return;
            }
        }


        ItemStack item = getItemInHand(player);
        if (item == null) {
            return;
        }

        if (item.getItemMeta() == null) {
            return;
        }

        if (game.getState() == running) {
            onGameClick(event, game, item, player);
            return;
        }

        if (game.getState() == waiting) {
            onLobbyClick(event, game, item, player);
            return;
        }
    }

    @EventHandler
    public void on(final PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();

        if (player == null || !player.isOnline()) {
            return;
        }

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        if (game == null) {
            return;
        }

        GameCycle cycle = game.getCycle();
        if (noInteractWhileEndGame) {
            if (cycle.isEndGameRunning()) {
                event.setCancelled(true);
                if (isDebug()) {
                    le(className, "[Warning] silent return : cycle.isEndGameRunning");
                }
                return;
            }
        }

        UUID playerUUID = player.getUniqueId();

        if (levelupShop) {
            if (BedwarsRel.getInstance() == null) {
                return;
            }
            GameManager gameManager = BedwarsRel.getInstance().getGameManager();
            if (gameManager == null) {
                return;
            }

            String worldMode = Utils.isInMode(game);

            if (Objects.equals(LevelConfigHandler.levelupShopOpenMode, "click on entity")) {
                if (!isEditPlayer(playerUUID)) {
                    if (event.getRightClicked().getCustomName() != null) {
                        if (event.getRightClicked().getCustomName().equals(t(LevelConfigHandler.levelupShopOpenModeEntityName))) {
                            if (Objects.equals(worldMode, "2v2")) {
                                openShop2v2(player, game);
                            } else if (Objects.equals(worldMode, "4v4")) {
                                openShop4v4(player, game);
                            }
                        }
                    }
                }
            }
        }
    }
}