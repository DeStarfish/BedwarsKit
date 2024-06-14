











/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class KitNone {
    public static ItemStack kitItemInMenu;

    public static void loadKit() {
        kitItemInMenu = new ItemStack(KitNoneItemType, KitNoneItemAmount);
        ItemMeta kitItemMeta = kitItemInMenu.getItemMeta();
        List<String> lore = new ArrayList<>(8);

        if (KitNoneItemLore != null) {
            for (String s : KitNoneItemLore) {
                lore.add(t(s));
            }
        }

        kitItemMeta.setLore(lore);

        kitItemMeta.setDisplayName(t(KitNoneItemName));

        kitItemInMenu.setItemMeta(kitItemMeta);
    }

    public static void setKit(UUID ignored) {
    }
}
