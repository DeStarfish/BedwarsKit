
























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class KitKangaroo {
    private static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static final ItemStack wood_sword = new ItemStack(GetMaterial.WOOD_SWORD());
    private static final ItemStack wood_pickaxe = new ItemStack(GetMaterial.WOOD_PICKAXE());
    private static final ItemStack wood_axe = new ItemStack(GetMaterial.WOOD_AXE());
    public static ItemStack kitItemInMenu;
    private static Material helmetItemType;
    private static Material chestItemType;
    private static Material legItemType;
    private static Material bootItemType;
    private static int helmetItemAmount;
    private static int chestItemAmount;
    private static int legItemAmount;
    private static int bootItemAmount;
    private static ItemStack helmetItem;
    private static ItemStack chestItem;
    private static ItemStack legItem;
    private static ItemStack bootItem;
    private static boolean listenerStateOk = false;

    public static void loadKit() {

        if (!listenerStateOk) {
            PluginManager pm = Bukkit.getPluginManager();
            pm.registerEvents(new KitKangarooListener(), plugin);
            listenerStateOk = true;
        }

        kitItemInMenu = new ItemStack(KitKangarooItemType, KitKangarooItemAmount);
        ItemMeta kitItemMeta = kitItemInMenu.getItemMeta();

        List<String> lore = new ArrayList<>(8);

        if (KitKangarooItemLore != null) {
            for (String s : KitKangarooItemLore) {
                lore.add(t(s));
            }
        }

        kitItemMeta.setLore(lore);

        kitItemMeta.setDisplayName(t(KitKangarooItemName));

        kitItemInMenu.setItemMeta(kitItemMeta);

        helmetItemAmount = 1;
        chestItemAmount = 1;
        legItemAmount = 1;
        bootItemAmount = 1;

        helmetItemType = Material.LEATHER_HELMET;
        chestItemType = Material.LEATHER_CHESTPLATE;
        legItemType = Material.LEATHER_LEGGINGS;
        bootItemType = Material.LEATHER_BOOTS;
    }

    public static void setKit(UUID uuid) {

        Player player = Bukkit.getPlayer(uuid);
        if (player == null) {
            return;
        }

        player.setAllowFlight(true);

        helmetItem = new ItemStack(helmetItemType, helmetItemAmount);
        chestItem = new ItemStack(chestItemType, chestItemAmount);
        legItem = new ItemStack(legItemType, legItemAmount);
        bootItem = new ItemStack(bootItemType, bootItemAmount);

        PlayerInventory pi = player.getInventory();
        if (pi == null) {
            return;
        }
        pi.setHelmet(helmetItem);
        pi.setChestplate(chestItem);
        pi.setLeggings(legItem);
        pi.setBoots(bootItem);

        pi.addItem(wood_sword);
        pi.addItem(wood_pickaxe);
        pi.addItem(wood_axe);

        applyKitBoost(player);
    }

    public static void applyKitBoost(Player player) {
        GameManager gameManager = BedwarsRel.getInstance().getGameManager();
        PlayerInventory playerInventory = player.getInventory();

        if (gameManager == null) {
            return;
        }

        Game game = gameManager.getGameOfPlayer(player);
        if (game == null) {
            return;
        }

        for (ItemStack itemStack : playerInventory.getArmorContents()) {
            if (itemStack.getType() == null) {
                return;
            }

            if (itemStack.getType().toString().contains("LEATHER")) {
                if (kitBase_coloredLeatherArmor) {
                    String playerteam = game.getPlayerTeam(player).getColor().name();

                    LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmetItem.getItemMeta();
                    LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestItem.getItemMeta();
                    LeatherArmorMeta leggingsMeta = (LeatherArmorMeta) legItem.getItemMeta();
                    LeatherArmorMeta bootsMeta = (LeatherArmorMeta) bootItem.getItemMeta();

                    setColorByTeam(playerteam, color -> {
                        helmetMeta.setColor(color);
                        chestplateMeta.setColor(color);
                        leggingsMeta.setColor(color);
                        bootsMeta.setColor(color);
                    });
                    helmetItem.setItemMeta(helmetMeta);
                    chestItem.setItemMeta(chestplateMeta);
                    legItem.setItemMeta(leggingsMeta);
                    bootItem.setItemMeta(bootsMeta);

                }
                player.getInventory().setHelmet(helmetItem);
                player.getInventory().setChestplate(chestItem);
                player.getInventory().setLeggings(legItem);
                player.getInventory().setBoots(bootItem);
            }
        }
    }
}
