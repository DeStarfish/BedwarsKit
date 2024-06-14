











/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelAlwayPickup implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void on(PlayerPickupItemEvent event) {

        if (!relFix_cantPickupItems) {
            return;
        }

        Player player = event.getPlayer();

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        boolean isInGame = game != null && game.getPlayers().contains(player);

        if (!isInGame) {
            return;
        }

        if (event.isCancelled()) {
            event.setCancelled(false);
        }


    }
}
