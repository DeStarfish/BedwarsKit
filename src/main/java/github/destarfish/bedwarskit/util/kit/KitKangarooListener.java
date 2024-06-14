




























public class KitKangarooListener implements Listener {
    public final BedwarsKit plugin = BedwarsKit.getInstance();
    public final GameMode survival = GameMode.SURVIVAL;

    @EventHandler
    public void on(PlayerMoveEvent event) {

        boolean funDisabled = !KitKangaroo_boost_fallDistane_resetOnGround;

        if (funDisabled) {
            return;
        }

        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        GameMode current = player.getGameMode();
        if (current != survival) {
            return;
        }

        BedwarsRel bedwarsRel = BedwarsRel.getInstance();
        if (bedwarsRel == null) {

            removeFromList(player);
            return;
        }
        GameManager gameManager = bedwarsRel.getGameManager();
        if (gameManager == null) {

            removeFromList(player);
            return;
        }

        Game game = gameManager.getGameOfPlayer(player);
        if (game == null) {

            removeFromList(player);
            return;
        }
        GameCycle gameCycle = game.getCycle();
        if (gameCycle.isEndGameRunning() || game.getState() != GameState.RUNNING) {

            return;
        }

        if (!getPlayerKit(playerUUID).equals(kitNameKangaroo)) {
            return;
        }

        Location playerLoc = player.getLocation().clone();
        playerLoc.setY(-2.0f);
        Block block = playerLoc.getBlock();

        if (block != null) {
            if (block.getType() != Material.AIR) {
                player.setFallDistance(KitKangaroo_boost_fallDistane);
            }
        }
    }

    @EventHandler
    public void on(final PlayerToggleFlightEvent event) {

        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        GameMode current = player.getGameMode();
        if (current != survival) {
            return;
        }

        BedwarsRel bedwarsRel = BedwarsRel.getInstance();
        if (bedwarsRel == null) {
            removeFromList(player);
            return;
        }
        GameManager gameManager = bedwarsRel.getGameManager();
        if (gameManager == null) {
            removeFromList(player);
            return;
        }

        Game game = gameManager.getGameOfPlayer(player);
        if (game == null) {
            removeFromList(player);
            return;
        }

        GameCycle gameCycle = game.getCycle();
        if (gameCycle.isEndGameRunning() || game.getState() != GameState.RUNNING) {
            return;
        }


        if (!getPlayerKit(playerUUID).equals(kitNameKangaroo)) {
            return;
        }

        event.setCancelled(true);
        player.setAllowFlight(false);
        player.setFlying(false);

        if (player.getLevel() <= 0) {


            Location location = player.getLocation();
            Vector direction = location.getDirection();

            player.setVelocity(direction.multiply(KitKangaroo_boost_multiply).setY(KitKangaroo_boost_jumpY).setX(KitKangaroo_boost_jumpX));

            player.setLevel(KitKangaroo_boost_cooldown);
            SoundPlayer.ZOMBIE_INFECT(player, 1);

            startCooldownTimer(player);

        }
    }

    public void startCooldownTimer(Player player) {
        new BukkitRunnable() {
            @Override
            public void run() {

                BedwarsRel bedwarsRel = BedwarsRel.getInstance();
                if (bedwarsRel == null) {
                    cancel();
                    removeFromList(player);
                    return;
                }
                GameManager gameManager = bedwarsRel.getGameManager();
                if (gameManager == null) {
                    cancel();
                    removeFromList(player);
                    return;
                }

                Game game = gameManager.getGameOfPlayer(player);
                if (game == null) {
                    cancel();
                    removeFromList(player);
                    return;
                }
                GameCycle gameCycle = game.getCycle();
                if (gameCycle.isEndGameRunning() || game.getState() != GameState.RUNNING) {
                    cancel();
                    removeFromList(player);
                    return;
                }

                if (player.getLevel() > 0) {
                    player.setLevel(player.getLevel() - 1);
                    player.setFallDistance(KitKangaroo_boost_fallDistane);
                }


                if (player.getLevel() <= 0) {

                    if (isDebug()) {
                        player.sendMessage(green + "cooldown remove!");
                    }
                    SoundPlayer.CHICKEN_EGG_POP(player, 1);
                    player.setAllowFlight(true);
                    cancel();
                    removeFromList(player);
                }
            }
        }.runTaskTimer(plugin, 0, 20);
    }

    private void removeFromList(Player player) {
        player.setLevel(0);
    }
}
