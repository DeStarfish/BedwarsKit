
















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelDropWatcher implements Listener {
    private final Material compass = GetMaterial.COMPASS();

    @EventHandler(priority = EventPriority.MONITOR)
    public void on(PlayerDropItemEvent event) {

        if (!holdCompassMess) {
            return;
        }

        if (event.isCancelled()) {
            return;
        }

        Player player = event.getPlayer();

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        if (game == null) {
            return;
        }

        boolean playerIsSpec = game.isSpectator(player);

        if (playerIsSpec) {
            return;
        }

        Item itemObj = event.getItemDrop();

        if (itemObj == null) {
            return;
        }

        ItemStack item = itemObj.getItemStack();
        if (item == null) {
            return;
        }

        Material itemType = item.getType();
        if (itemType == compass) {
            sendLeaveCompassMess(player);
        }


    }
}
