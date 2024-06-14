



















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlayerTeleport implements Listener {
    private static final float resFallDis = 0.0f;
    private static final GameMode survival = GameMode.SURVIVAL;

    @EventHandler(priority = EventPriority.HIGH)
    public void on(PlayerTeleportEvent event) {
        Player player = event.getPlayer();

        if (player == null || !player.isOnline()) {
            return;
        }

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        boolean inInGame = game != null;

        PlayerTeleportEvent.TeleportCause enderpearl = PlayerTeleportEvent.TeleportCause.ENDER_PEARL;

        Location goTo = event.getTo();

        if (noPearlDamage && inInGame && event.getCause() == enderpearl) {
            if (noPearlDamage_tpSound) {
                SoundPlayer.ENDERMAN_TELEPORT(player, 1);
            }
            event.setCancelled(true);
            player.setFallDistance(resFallDis);
            player.teleport(goTo);
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void on(PlayerChangedWorldEvent event) {
        BedwarsKit plugin = BedwarsKit.getInstance();
        if (isBungeeEnabled()) {
            return;
        }
        try {
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (event.getPlayer() == null || !event.getPlayer().isOnline()) {
                        return;
                    }

                    Player player = event.getPlayer();

                    boolean playerIsInLobby = player.getWorld().getName().contains(lobbyWorld);

                    if (playerIsInLobby) {
                        if (player.getGameMode() != survival) {
                            player.setGameMode(survival);
                        }
                    }
                }
            }.runTaskLater(plugin, 20L);
        } catch (IllegalPluginAccessException ignored) {
        }
    }
}
