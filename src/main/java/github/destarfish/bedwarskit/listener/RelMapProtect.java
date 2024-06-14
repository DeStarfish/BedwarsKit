
















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelMapProtect implements Listener {
    private static final GameState running = GameState.RUNNING;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block == null) {
            return;
        }

        GameManager gm = BedwarsRel.getInstance().getGameManager();
        Player player = event.getPlayer();
        if (player == null || !player.isOnline()) {
            return;
        }

        Game game = gm.getGameOfPlayer(player);
        if (game != null) {
            GameCycle cycle = game.getCycle();

            boolean playerNotInGame = !game.isInGame(player);

            if (playerNotInGame || cycle.isEndGameRunning()) {
                event.setCancelled(true);
                return;
            }
        }

        if (breakCorrect_notInGame) {
            if (breakCorrect_notInGame_OpBypass) {
                if (!player.isOp()) {
                    String worldName = player.getWorld().getName();
                    for (Game list : gm.getGames()) {
                        if (list.getRegion().getWorld().getName().equals(worldName) && list.getState() != running) {

                            event.setCancelled(true);
                            break;
                        }
                    }
                }
            } else {
                String worldName = player.getWorld().getName();
                for (Game list : gm.getGames()) {
                    if (list.getRegion().getWorld().getName().equals(worldName) && list.getState() != running) {

                        event.setCancelled(true);

                        break;
                    }
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if (player == null || !player.isOnline()) {
            return;
        }

        GameManager gm = BedwarsRel.getInstance().getGameManager();
        Game game = gm.getGameOfPlayer(player);
        if (game != null) {
            GameCycle cycle = game.getCycle();

            boolean playerNotInGame = !game.isInGame(player);

            if (playerNotInGame || cycle.isEndGameRunning()) {
                event.setCancelled(true);
                return;
            }
        }

        Block block = event.getBlock();
        if (block == null) {
            return;
        }

        if (placeCorrect_notInGame) {
            if (placeCorrect_notInGame_OpBypass) {
                if (!player.isOp()) {
                    String worldName = player.getWorld().getName();
                    for (Game list : gm.getGames()) {
                        if (list.getRegion().getWorld().getName().equals(worldName) && list.getState() != running) {

                            event.setCancelled(true);
                            break;
                        }
                    }
                }
            } else {
                String worldName = player.getWorld().getName();
                for (Game list : gm.getGames()) {
                    if (list.getRegion().getWorld().getName().equals(worldName) && list.getState() != running) {

                        event.setCancelled(true);
                        break;
                    }
                }
            }
        }
    }
}

