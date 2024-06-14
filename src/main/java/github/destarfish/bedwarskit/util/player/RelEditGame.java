























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelEditGame {
    private static final Set<UUID> editPlayers = Collections.newSetFromMap(new ConcurrentHashMap<>());

    private static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static boolean listenerStateOK = false;

    public static void addEditPlayer(UUID uuid) {
        Player player = Bukkit.getPlayer(uuid);
        editPlayers.add(uuid);
        runTask(player);
    }

    public static boolean isEditPlayer(UUID uuid) {
        return editPlayers.contains(uuid);
    }

    public static void removeEditPlayer(UUID uuid) {
        editPlayers.remove(uuid);
        try {
            new BukkitRunnable() {
                @Override
                public void run() {
                    Player player = Bukkit.getPlayer(uuid);
                    if (player.isOnline()) {
                        PlayerInventory pi = player.getInventory();
                        pi.remove(Material.PAPER);
                        pi.remove(Material.NAME_TAG);
                        pi.remove(Material.REDSTONE);
                        pi.remove(Material.ITEM_FRAME);
                    }
                }
            }.runTaskLater(plugin, 40L);
        } catch (IllegalPluginAccessException ignored) {
        }

    }

    public static void toggleEdit(Player player) {
        if (!player.isOp()) {
            return;
        }

        UUID playerUUID = player.getUniqueId();
        if (isEditPlayer(playerUUID)) {
            removeEditPlayer(playerUUID);
        } else {
            if (!listenerStateOK) {
                l(yellow + meanRegExListener);
                PluginManager pluginManager = Bukkit.getPluginManager();
                pluginManager.registerEvents(new RelEditPlayerClick(), plugin);
                l(green + meanRegExListenerSucc);
                listenerStateOK = true;
            }
            addEditPlayer(playerUUID);
        }

        if (isEditPlayer(playerUUID)) {
            sendMessage(player, meanEditGameToggleToTrue);
        } else {
            sendMessage(player, meanEditGameToggleToFalse);
        }
    }
}
