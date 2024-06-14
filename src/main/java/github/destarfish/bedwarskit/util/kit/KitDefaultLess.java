
























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class KitDefaultLess {
    public static final int maxEffectTime = 999999;
    private static final ItemStack stone_sword = new ItemStack(Material.STONE_SWORD);
    private static final ItemStack wood_pickaxe = new ItemStack(GetMaterial.WOOD_PICKAXE());
    private static final ItemStack wood_axe = new ItemStack(GetMaterial.WOOD_AXE());
    public static ItemStack kitItemInMenu;
    private static Material helmetItemType;
    private static Material chestItemType;
    private static int helmetItemAmount;
    private static int chestItemAmount;
    private static ItemStack helmetItem;
    private static ItemStack chestItem;

    public static void loadKit() {

        kitItemInMenu = new ItemStack(KitDefaultLessItemType, KitDefaultLessItemAmount);
        ItemMeta kitItemMeta = kitItemInMenu.getItemMeta();

        List<String> lore = new ArrayList<>(8);

        if (KitDefaultLessItemLore != null) {
            for (String s : KitDefaultLessItemLore) {
                lore.add(t(s));
            }
        }

        kitItemMeta.setLore(lore);

        kitItemMeta.setDisplayName(t(KitDefaultLessItemName));

        kitItemInMenu.setItemMeta(kitItemMeta);

        helmetItemAmount = 1;
        chestItemAmount = 1;

        helmetItemType = Material.LEATHER_HELMET;
        chestItemType = Material.LEATHER_CHESTPLATE;
    }

    public static void setKit(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        helmetItem = new ItemStack(helmetItemType, helmetItemAmount);
        chestItem = new ItemStack(chestItemType, chestItemAmount);
        PlayerInventory pi = player.getInventory();
        pi.setHelmet(helmetItem);
        pi.setChestplate(chestItem);

        pi.addItem(stone_sword);
        pi.addItem(wood_pickaxe);
        pi.addItem(wood_axe);

        applyKitBoost(player);
    }

    public static void applyKitBoost(Player player) {
        GameManager gameManager = BedwarsRel.getInstance().getGameManager();
        PlayerInventory playerInventory = player.getInventory();
        if (KitDefaultLess_Boost_GiveSpeed_enable) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, maxEffectTime, KitDefault_Boost_GiveSpeed_level), true);
        }
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

                    setColorByTeam(playerteam, color -> {
                        helmetMeta.setColor(color);
                        chestplateMeta.setColor(color);
                    });
                    helmetItem.setItemMeta(helmetMeta);
                    chestItem.setItemMeta(chestplateMeta);

                }
                player.getInventory().setHelmet(helmetItem);
                player.getInventory().setChestplate(chestItem);
            }
        }
    }
}
