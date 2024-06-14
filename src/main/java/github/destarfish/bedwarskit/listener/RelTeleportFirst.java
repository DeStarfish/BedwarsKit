















public class RelTeleportFirst implements Listener {
    private final String className = RelTeleportFirst.class.getSimpleName();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(PlayerTeleportEvent event) {

        boolean funDisabled = !teleportAlwayKeepDirection;

        if (funDisabled) {
            return;
        }

        Player player = event.getPlayer();

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        if (game == null) {
            return;
        }

        Location playerLoc = player.getLocation();
        Vector playerDire = playerLoc.getDirection();
        Location to = event.getTo();

        if (to.getDirection() != playerDire) {

            if (isDebug()) {
                le(className, "[State] toDire != playerDire, setting dire for " + player.getName());
            }
            to.setDirection(playerDire);
        }


    }
}
