






/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class GetItemInHand {
    public static @Nullable ItemStack getItemInHand(Player player) {
        if (player == null) {
            return null;
        }
        return player.getInventory().getItemInHand();
    }
}
