












/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class PlayerUtil {
    private static final Material diamond = Material.DIAMOND;

    public static boolean isHaveDiamond(HumanEntity player, int exAmount) {
        PlayerInventory pi = player.getInventory();
        boolean haveDiamond = false;
        int totalDiamondAmount = 0;

        ItemStack[] items = pi.getContents();
        for (ItemStack item : items) {
            if (item != null) {
                if (totalDiamondAmount < exAmount && item.getType() == diamond) {
                    haveDiamond = true;
                    totalDiamondAmount += item.getAmount();
                }
            }
        }

        return haveDiamond && totalDiamondAmount >= exAmount;
    }

    public static boolean isRemovedDiamond(HumanEntity player, int exAmount) {
        PlayerInventory pi = player.getInventory();
        int remainingAmountToRemove = exAmount;

        HashMap<Integer, ? extends ItemStack> diamondSlots = pi.all(diamond);
        for (ItemStack item : diamondSlots.values()) {
            int currentAmount = item.getAmount();
            if (currentAmount <= remainingAmountToRemove) {
                remainingAmountToRemove -= currentAmount;
                pi.removeItem(item);
            } else {
                item.setAmount(currentAmount - remainingAmountToRemove);
                remainingAmountToRemove = 0;
                break;
            }
        }

        return remainingAmountToRemove == 0;
    }

    public static void sendMessage(Player player, String message) {
        player.sendMessage(t(message));
    }

    public static void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(t(message));
    }

    public static void sendMessageC(Player player, String message) {
        player.sendMessage(t("&bBedwarsKit &7>> &r" + message));
    }

    public static void sendMessageC(CommandSender sender, String message) {
        sender.sendMessage(t("&bBedwarsKit &7>> &r" + message));
    }
}
