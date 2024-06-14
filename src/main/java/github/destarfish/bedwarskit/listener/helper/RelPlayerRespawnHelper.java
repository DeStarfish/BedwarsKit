






















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelPlayerRespawnHelper {
    private static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static final ItemStack chain1 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
    private static final ItemStack chain2 = new ItemStack(Material.CHAINMAIL_BOOTS);
    private static final ItemStack iron1 = new ItemStack(Material.IRON_LEGGINGS);
    private static final ItemStack iron2 = new ItemStack(Material.IRON_BOOTS);
    private static final ItemStack dm1 = new ItemStack(Material.DIAMOND_LEGGINGS);
    private static final ItemStack dm2 = new ItemStack(Material.DIAMOND_BOOTS);
    private static final GameMode survival = GameMode.SURVIVAL;

    public static void playerRespawn(Player player, long delay) {

        UUID playerUUID = player.getUniqueId();
        player.setGameMode(survival);

        new BukkitRunnable() {
            @Override
            public void run() {
                PlayerInventory pi = player.getInventory();

                if (kitEnable) {
                    if (kitForce) {
                        applykitforce(playerUUID, kitForceKit);
                    } else {
                        applykit(playerUUID);
                    }
                }

                if (startKitCompass) {
                    ItemStack compass = new ItemStack(Material.COMPASS);
                    if (!Objects.equals(compassDisplayName, "")) {
                        ItemMeta meta = compass.getItemMeta();
                        meta.setDisplayName(t(compassDisplayName));
                        compass.setItemMeta(meta);
                    }
                    pi.addItem(compass);
                }

                if (hasArmorChain(playerUUID)) {
                    if (!hasArmorIron(playerUUID) && !hasArmorDiamond(playerUUID)) {
                        pi.setLeggings(chain1);
                        pi.setBoots(chain2);
                    }
                }
                if (hasArmorIron(playerUUID)) {
                    if (!hasArmorChain(playerUUID)) {
                        pi.setLeggings(iron1);
                        pi.setBoots(iron2);
                    }
                }
                if (hasArmorDiamond(playerUUID)) {
                    pi.setLeggings(dm1);
                    pi.setBoots(dm2);
                }

                player.setHealth(player.getMaxHealth());

                removeRespawningPlayer(playerUUID);

            }
        }.runTaskLater(plugin, delay);
    }
}
