




















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelSwapSlot implements Listener {
    private final Material compass = GetMaterial.COMPASS();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(PlayerItemHeldEvent event) {

        if (!holdCompassMess) {
            return;
        }

        Player player = event.getPlayer();

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        boolean isInGame = game != null && game.isInGame(player);

        if (!isInGame) {
            return;
        }

        PlayerInventory pi = player.getInventory();
        ItemStack item = pi.getItem(event.getPreviousSlot());
        if (item != null) {

            Material itemType = item.getType();
            if (itemType == compass) {

                ItemMeta meta = item.getItemMeta();
                if (Objects.equals(compassDisplayName, "null")) {
                    meta.setDisplayName(null);
                } else {
                    meta.setDisplayName(t(compassDisplayName));
                }
                item.setItemMeta(meta);

                sendLeaveCompassMess(player);
                return;
            }
        }
        ItemStack to = pi.getItem(event.getNewSlot());
        if (to != null) {

            Material type = to.getType();
            if (type == compass) {

                ItemMeta meta = to.getItemMeta();
                if (Objects.equals(holdCompassDisplayName, "null")) {
                    meta.setDisplayName(null);
                } else {
                    meta.setDisplayName(t(holdCompassDisplayName));
                }
                to.setItemMeta(meta);

                sendLeaveCompassMess(player);
                return;
            }
        }
    }
}
