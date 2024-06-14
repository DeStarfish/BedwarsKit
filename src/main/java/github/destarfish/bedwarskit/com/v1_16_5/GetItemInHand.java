






/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class GetItemInHand {
    private static final Material air = Material.AIR;

    public static ItemStack getItemInHand(Player player) {
        if (player == null) {
            return null;
        }
        PlayerInventory pi = player.getInventory();
        ItemStack itemInOffHand = pi.getItemInOffHand();
        if (itemInOffHand.getType() != air) {
            return itemInOffHand;
        }
        player.setArrowsInBody(0);
        return getItemInMainHand(pi);
    }

    public static ItemStack getItemInMainHand(PlayerInventory pi) {
        if (pi == null) {
            return null;
        }
        return pi.getItemInMainHand();
    }
}
