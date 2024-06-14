















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class KitMenu {
    private static final int perRow = 9;
    public static ItemStack kitMenuItem;
    private static Inventory kitMenu;

    public static void openMenu(Player player) {
        player.openInventory(kitMenu);
    }

    public static void loadKitMenu() {
        kitMenu = Bukkit.getServer().createInventory(null,
                kitMenuRow * perRow,
                kitMenuTitle
        );

        ItemStack Default = KitDefault.kitItemInMenu;
        kitMenu.setItem(KitDefaultItemSlot, Default);

        ItemStack None = KitNone.kitItemInMenu;
        kitMenu.setItem(KitNoneItemSlot, None);

        ItemStack Defaultless = KitDefaultLess.kitItemInMenu;
        kitMenu.setItem(KitDefaultLessItemSlot, Defaultless);

        ItemStack Kangaroo = KitKangaroo.kitItemInMenu;
        kitMenu.setItem(KitKangarooItemSlot, Kangaroo);
    }

    public static void loadKitMenuItem() {

        kitMenuItem = new ItemStack(kitMenuItemType, kitMenuItemAmount);

        ItemMeta meta = kitMenuItem.getItemMeta();
        meta.setDisplayName(t(kitMenuItemName));
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

        kitMenuItem.setItemMeta(meta);

        loadKitMenu();
    }
}
