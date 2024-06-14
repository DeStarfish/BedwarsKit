



























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelOpenShop implements Listener {
    private static final String className = RelOpenShop.class.getSimpleName();
    private static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static final String clickOnEntityName = "click on entity";

    public static void openShop(Player player, long delay) {

        if (player == null) {
            return;
        }

        if (!player.isOnline() || player.isDead() || player.isSleeping()) {

            if (isDebug()) {
                le(className, "[Waring] silent return : openShop for " + player.getName());
            }
            return;
        }

        GameManager gameManager = BedwarsRel.getInstance().getGameManager();
        if (gameManager == null) {
            if (isDebug()) {
                le(className, "[Waring] silent return : gameManager == null");
            }
            return;
        }

        Game game = gameManager.getGameOfPlayer(player);

        if (game == null) {
            if (isDebug()) {
                le(className, "[Waring] silent return : game == null");
            }
            return;
        }


        if (game.getState() != GameState.RUNNING) {
            if (isDebug()) {
                le(className, "[Waring] silent return : game.getState() != GameState.RUNNING");
            }
            return;
        }


        if (game.getCycle().isEndGameRunning()) {
            String itemO = plugin.getItemO();
            sendActionBar(player, "&f&l" + itemO + " &c&lYou can't open shop while game end! " + "&f&l" + itemO);
            if (isDebug()) {
                le(className, "[Waring] return " + player.getName() + ": game.getCycle().isEndGameRunning()");
            }
            return;
        }

        String worldMode = Utils.isInMode(game);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (worldMode.equals("2v2")) {
                    openShop2v2(player, game);
                } else if (worldMode.equals("4v4")) {
                    openShop4v4(player, game);
                }
            }
        }.runTaskLater(plugin, delay);
    }


    @EventHandler(priority = EventPriority.HIGH)
    public void on(final BedwarsOpenShopEvent event) {

        boolean playerIsNotReal = !(event.getPlayer() instanceof Player);

        if (playerIsNotReal) {
            return;
        }

        Player player = (Player) event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        if (isEditPlayer(playerUUID)) {
            event.setCancelled(true);
            String itemO = plugin.getItemO();
            sendActionBar(player, "&f&l" + itemO + " &c&lYou can't open shop while in edit mode! " + "&f&l" + itemO);
            if (isDebug()) {
                le(className, "[Waring] return " + player.getName() + ": isEditGamePlayer(playerUUID)");
            }
            return;
        }

        Game game = event.getGame();
        boolean playerIsInSpMode = player.getGameMode() == GameMode.SPECTATOR;
        if (game == null || game.isSpectator(player) || playerIsInSpMode) {
            event.setCancelled(true);
            if (isDebug()) {
                le(className, "[Waring] silent return : (game == null || game.isSpectator(player) || player.getGameMode() == GameMode.SPECTATOR) = true");
            }
            return;
        }

        if (levelupShop) {
            if (event.getEntity().getCustomName() != null) {
                if (LevelConfigHandler.levelupShopOpenMode.equals(clickOnEntityName)) {
                    if (event.getEntity().getCustomName().equals(t(LevelConfigHandler.levelupShopOpenMode))) {
                        event.setCancelled(true);
                        if (isDebug()) {
                            le(className, "[Waring] silent return : (event.getEntity().getCustomName().equals(levelupShopOpenMode) = true");
                        }
                        return;
                    }
                }
            }
        }

        if (LevelConfigHandler.openShopOnCustomEntityName) {
            if (event.getEntity().getCustomName() == null) {
                event.setCancelled(true);
            } else {
                if (event.getEntity().getCustomName().equals(t(LevelConfigHandler.itemShopEntityName))) {
                    game.openNewItemShop(player);
                } else {
                    event.setCancelled(true);
                }
            }
        }

    }

}
