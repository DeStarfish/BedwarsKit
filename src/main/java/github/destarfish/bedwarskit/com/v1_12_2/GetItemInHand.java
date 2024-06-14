




/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class GetItemInHand {

    public static ItemStack getItemInHand(Player player) {
        ItemStack itemInOffHand = player.getInventory().getItemInOffHand();
        if (itemInOffHand != null) {
            return itemInOffHand;
        }
        return getItemInMainHand(player);
    }

    public static ItemStack getItemInMainHand(Player player) {
        return player.getInventory().getItemInMainHand();
    }
}
