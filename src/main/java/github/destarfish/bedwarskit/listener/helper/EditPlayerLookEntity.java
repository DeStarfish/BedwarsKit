


















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class EditPlayerLookEntity {
    private static final String className = EditPlayerLookEntity.class.getSimpleName();
    private static final String entityInfoItemName = "&fLeft Edit Mode &r(";
    private static final String entitySetNameLevelShop = "&fSetNameTo: %name% &r(";
    private static final String entitySetNameItemShop = "&fSetNameTo: %name% &r(";
    private static final String entityRemoveNameItemName = "&fRemoveName &r(";
    private static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static final String suffix = ")";

    public static void runTask(Player player) {

        if (isDebug()) {
            le(className, "[State] runTask for " + player.getName());
        }

        if (player == null || !player.isOnline() || !isEditPlayer(player.getUniqueId())) {
            return;
        }

        UUID playerUUID = player.getUniqueId();

        new BukkitRunnable() {
            final ItemStack itemStack = new ItemStack(Material.AIR);
            ItemMeta itemMeta;
            String newDisplayName;

            @Override
            public void run() {

                if (isDebug()) {
                    le(className, "[State] taskUpdating for " + player.getName());
                }

                if (!player.isOnline()) {
                    cancel();
                }

                PlayerInventory pi = player.getInventory();

                String itemO = plugin.getItemO();

                if (pi == null) {
                    cancel();
                    return;
                }

                pi.remove(Material.PAPER);
                pi.remove(Material.NAME_TAG);
                pi.remove(Material.REDSTONE);
                pi.remove(Material.ITEM_FRAME);

                if (!isEditPlayer(playerUUID)) {
                    pi.remove(Material.PAPER);
                    pi.remove(Material.NAME_TAG);
                    pi.remove(Material.REDSTONE);
                    pi.remove(Material.ITEM_FRAME);
                    cancel();
                }

                itemStack.setType(Material.PAPER);
                itemMeta = itemStack.getItemMeta();
                newDisplayName = entityInfoItemName + itemO + suffix;
                itemMeta.setDisplayName(newDisplayName);
                itemStack.setItemMeta(itemMeta);
                pi.setItem(8, itemStack);

                itemStack.setType(Material.NAME_TAG);
                if (levelupShopOpenModeEntityName != null) {
                    itemMeta = itemStack.getItemMeta();
                    newDisplayName = t(entitySetNameLevelShop.replace("%name%", itemShopEntityName) + itemO + suffix);
                    itemMeta.setDisplayName(newDisplayName);
                    itemStack.setItemMeta(itemMeta);
                    pi.setItem(1, itemStack);
                }

                itemStack.setType(Material.ITEM_FRAME);
                if (itemShopEntityName != null) {
                    itemMeta = itemStack.getItemMeta();
                    newDisplayName = t(entitySetNameItemShop.replace("%name%", itemShopEntityName) + itemO + suffix);
                    itemMeta.setDisplayName(newDisplayName);
                    itemStack.setItemMeta(itemMeta);
                    pi.setItem(0, itemStack);
                }

                itemStack.setType(Material.REDSTONE);
                itemMeta = itemStack.getItemMeta();
                newDisplayName = t(entityRemoveNameItemName + itemO + suffix);
                itemMeta.setDisplayName(newDisplayName);
                itemStack.setItemMeta(itemMeta);
                pi.setItem(2, itemStack);
            }
        }.runTaskTimer(plugin, 0L, 20L);
    }
}
