




























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlayerLeave implements Listener {
    private static final float resFallDis = 0.0f;
    private static final Material air = Material.AIR;
    private static final BedwarsKit plugin = BedwarsKit.getInstance();

    @EventHandler
    public void on(final BedwarsPlayerLeaveEvent event) {
        Player player = event.getPlayer();

        Game game = event.getGame();

        if (game != null) {
            Team team = game.getPlayerTeam(player);

            PlayerInventory pi = player.getInventory();
            for (ItemStack item : pi.getContents()) {
                if (item != null) {
                    item.setType(air);
                }
            }
            for (ItemStack item : pi.getArmorContents()) {
                if (item != null) {
                    item.setType(air);
                }
            }

            UUID playerUUID = player.getUniqueId();
            if (game.getState() == GameState.RUNNING && !game.getCycle().isEndGameRunning()) {
                RelCurrentStat.onPlayerLeave(playerUUID, game);
            }

            player.setFallDistance(resFallDis);

            removeRespawningPlayer(playerUUID);

            if (team == null || team.isDead(game)) {

                removeArmorChain(playerUUID);
                removeArmorIron(playerUUID);
                removeArmorDiamond(playerUUID);
                removePlayerStat(playerUUID);

            } else {

                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (game.getState() != GameState.RUNNING) {

                            removeArmorChain(playerUUID);
                            removeArmorIron(playerUUID);
                            removeArmorDiamond(playerUUID);
                            removePlayerStat(playerUUID);
                            removePlayerIsOut(playerUUID);
                            cancel();
                        }
                    }
                }.runTaskTimer(plugin, 20L, 20L);
            }

        }
    }


    @EventHandler
    public void on(final PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        removePlayerIsOut(playerUUID);
        removeRespawningPlayer(playerUUID);

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        if (game != null) {
            RelRejoinHandler rejoinHandler = BedwarsKit.getInstance().getRejoinHandler();
            rejoinHandler.onPlayerLeave(player, game);
        }

        if (Objects.equals(leaveServer_mess, "null")) {
            event.setQuitMessage(null);
        } else if (!Objects.equals(leaveServer_mess, "")) {
            event.setQuitMessage(t(leaveServer_mess.replace("%player%", player.getName())));
        }
    }

}