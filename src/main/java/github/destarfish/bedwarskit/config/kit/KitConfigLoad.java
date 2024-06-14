
























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class KitConfigLoad implements IConfigLoader {
    private final String className = getClass().getSimpleName();
    private final BedwarsKit plugin = BedwarsKit.getInstance();
    private final String fileName = "kit.yml";

    private static void loadKits() {
        KitDefault.loadKit();
        KitNone.loadKit();
        KitDefaultLess.loadKit();
        KitKangaroo.loadKit();
    }

    private void sendError(String path) {
        er(fileName, path, vauleIsNull);
    }

    public void loadConfig() {

        final String use_config_version = "1.9.9";

        if (isDebug()) {
            le(className, "[State] loading " + fileName + "(" + use_config_version + ")");
        }

        final File file = new File(plugin.getDataFolder(), fileName);

        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }

        checkAndRenameConfig(file, use_config_version);

        final FileConfiguration c = YamlConfiguration.loadConfiguration(file);

        try {
            applyConfig(c);
        } catch (Exception e) {
            le(className, e);
        }

        if (isDebug()) {
            le(className, "[State] " + finishLoadConfig);
        }

        loadKits();
        loadKitMenuItem();
    }

    private void applyConfig(FileConfiguration c) {
        String path;

        path = path_kitEnable;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            kitEnable = c.getBoolean(path);
        }

        path = path_meanSelKitSucc;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanSelKitSucc = c.getString(path);
        }

        path = path_meanSelKitSucc;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanSelKitSucc = c.getString(path);
        }

        path = path_defaultKit;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            defaultKit = c.getString(path);
        }

        path = path_kitMenuTitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            kitMenuTitle = c.getString(path);
        }

        path = path_kitMenuRow;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            kitMenuRow = c.getInt(path);
        }

        path = path_kitMenuItemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            kitMenuItemName = c.getString(path);
        }

        path = path_kitMenuItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            kitMenuItemType = Material.getMaterial(c.getString(path));
        }

        path = path_kitMenuItemAmount;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            kitMenuItemAmount = c.getInt(path);
        }

        path = path_kitMenuItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            kitMenuItemType = Material.getMaterial(c.getString(path));
        }

        path = path_kitForce;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            kitForce = c.getBoolean(path);
        }

        path = path_kitForceKit;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            kitForceKit = c.getString(path);
        }

        path = path_kitMenuItemGive;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            kitMenuItemGive = c.getBoolean(path);
        }

        applyKitDefaultConfig(c);
        applyKitDefaultLessConfig(c);
        applyKitNoneConfig(c);
        applyKitKangarooConfig(c);
    }

    private void applyKitKangarooConfig(FileConfiguration c) {
        String path;
        path = path_KitKangarooItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            KitKangarooItemType = Material.getMaterial(c.getString(path));
        }

        path = path_KitKangarooItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangarooItemSlot = c.getInt(path);
        }

        path = path_KitKangarooItemAmount;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangarooItemAmount = c.getInt(path);
        }

        path = path_KitKangarooItemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangarooItemName = c.getString(path);
        }

        path = path_KitKangarooItemLore;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (KitKangarooItemLore == null) {
                KitKangarooItemLore = new ArrayList<>(10);
            } else {
                KitKangarooItemLore.clear();
            }
            KitKangarooItemLore.addAll(c.getStringList(path));
        }

        path = path_KitKangarooName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangarooName = c.getString(path);
        }

        path = path_KitKangarooName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangarooName = c.getString(path);
        }

        path = path_KitKangaroo_boost_fallDistane_resetOnGround;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangaroo_boost_fallDistane_resetOnGround = c.getBoolean(path);
        }

        path = path_KitKangaroo_boost_cooldown;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangaroo_boost_cooldown = c.getInt(path);
        }

        path = path_KitKangaroo_boost_multiply;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangaroo_boost_multiply = c.getDouble(path);
        }

        path = path_KitKangaroo_boost_jumpX;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangaroo_boost_jumpX = c.getDouble(path);
        }

        path = path_KitKangaroo_boost_jumpY;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangaroo_boost_jumpY = c.getDouble(path);
        }

        path = path_KitKangaroo_boost_fallDistane;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitKangaroo_boost_fallDistane = (float) c.getDouble(path);
        }
    }

    private void applyKitNoneConfig(FileConfiguration c) {
        String path;
        path = path_KitNoneItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            KitNoneItemType = Material.getMaterial(c.getString(path));
        }

        path = path_KitNoneItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitNoneItemSlot = c.getInt(path);
        }

        path = path_KitNoneItemAmount;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitNoneItemAmount = c.getInt(path);
        }

        path = path_KitNoneItemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitNoneItemName = c.getString(path);
        }

        path = path_KitNoneItemLore;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (KitNoneItemLore == null) {
                KitNoneItemLore = new ArrayList<>(10);
            } else {
                KitNoneItemLore.clear();
            }
            KitNoneItemLore.addAll(c.getStringList(path));
        }

        path = path_KitNoneName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitNoneName = c.getString(path);
        }

        path = path_KitNoneName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitNoneName = c.getString(path);
        }
    }

    private void applyKitDefaultLessConfig(FileConfiguration c) {
        String path;
        path = path_KitDefaultLessItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            KitDefaultLessItemType = Material.getMaterial(c.getString(path));
        }

        path = path_KitDefaultLessItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultLessItemSlot = c.getInt(path);
        }


        path = path_KitDefaultLessItemAmount;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultLessItemAmount = c.getInt(path);
        }

        path = path_KitDefaultLessItemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultLessItemName = c.getString(path);
        }

        path = path_KitDefaultLessItemLore;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (KitDefaultLessItemLore == null) {
                KitDefaultLessItemLore = new ArrayList<>(10);
            } else {
                KitDefaultLessItemLore.clear();
            }
            KitDefaultLessItemLore.addAll(c.getStringList(path));
        }

        path = path_KitDefaultLessName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultLessName = c.getString(path);
        }

        path = path_KitDefaultLessName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultLessName = c.getString(path);
        }

        path = path_KitDefaultLess_Boost_GiveSpeed_enable;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultLess_Boost_GiveSpeed_enable = c.getBoolean(path);
        }

        path = path_KitDefaultLess_Boost_GiveSpeed_level;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultLess_Boost_GiveSpeed_level = c.getInt(path);
        }
    }

    private void applyKitDefaultConfig(FileConfiguration c) {
        String path;
        path = path_KitDefaultItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            KitDefaultItemType = Material.getMaterial(c.getString(path));
        }

        path = path_KitDefaultItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultItemSlot = c.getInt(path);
        }

        path = path_KitDefaultItemAmount;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultItemAmount = c.getInt(path);
        }

        path = path_KitDefaultItemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultItemName = c.getString(path);
        }

        path = path_KitDefaultItemLore;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (KitDefaultItemLore == null) {
                KitDefaultItemLore = new ArrayList<>(10);
            } else {
                KitDefaultItemLore.clear();
            }
            KitDefaultItemLore.addAll(c.getStringList(path));
        }

        path = path_KitDefaultName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultName = c.getString(path);
        }

        path = path_KitDefaultName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefaultName = c.getString(path);
        }

        path = path_KitDefault_Boost_GiveSpeed_enable;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefault_Boost_GiveSpeed_enable = c.getBoolean(path);
        }

        path = path_KitDefault_Boost_GiveSpeed_level;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            KitDefault_Boost_GiveSpeed_level = c.getInt(path);
        }
    }

}
