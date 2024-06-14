






















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class LevelConfigLoad implements IConfigLoader {
    private final String className = getClass().getSimpleName();
    private final BedwarsKit plugin = BedwarsKit.getInstance();

    private final String fileName = "upgrade_shop.yml";

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

        if (getLoadErrors().isEmpty()) {
            loadLevelUpInv();
        } else {
            l("&cAn error occurred during loading. Skiping load shopMenu");
        }
    }

    private void applyConfig(FileConfiguration c) {

        applyLevelUpConfig(c);

    }

    private void applyLevelUpConfig(FileConfiguration c) {
        String path;

        applyLevelupCost(c);
        applyLevelUpMessConfig(c);
        applyLevelUpItemName(c);


        path = path_levelupShop;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelupShop = c.getBoolean(path);
        }

        path = path_levelupShopOpenMode;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelupShopOpenMode = c.getString(path);
        }

        path = path_levelupShopOpenModeEntityName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelupShopOpenModeEntityName = c.getString(path);
        }

        path = path_paneItemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            paneItemName = c.getString(path);
        }

        path = path_paneItemLore;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (paneItemLore == null) {
                paneItemLore = new ArrayList<>(48);
            } else {
                paneItemLore.clear();
            }
            paneItemLore.addAll(c.getStringList(path));
        }

        path = path_levelupresItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            levelupresItemType = Material.getMaterial(c.getString(path));
        }

        path = path_levelupresItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelupresItemSlot = c.getInt(path);
        }

        path = path_levelupresItemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelupresItemName = c.getString(path);
        }

        path = path_levelUpShopInvTitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelUpShopInvTitle = c.getString(path);
        }

        path = path_giveProtEnchList;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (giveProtEnchList == null) {
                giveProtEnchList = new ArrayList<>(4);
            } else {
                giveProtEnchList.clear();
            }
            giveProtEnchList.addAll(c.getStringList(path));
        }

        path = path_giveSharpEnchList;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (giveSharpEnchList == null) {
                giveSharpEnchList = new ArrayList<>(4);
            } else {
                giveSharpEnchList.clear();
            }
            giveSharpEnchList.addAll(c.getStringList(path));
        }

        path = path_levelupsharpItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            levelupsharpItemType = Material.getMaterial(c.getString(path));
        }

        path = path_levelupsharpItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelupsharpItemSlot = c.getInt(path);
        }

        path = path_levelupprotItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            levelupprotItemType = Material.getMaterial(c.getString(path));
        }

        path = path_levelupprotItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelupprotItemSlot = c.getInt(path);
        }

        path = path_teamEnchItemName_sharp2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_sharp2 = c.getString(path);
        }

        path = path_teamEnchItemName_sharp3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_sharp3 = c.getString(path);
        }

        path = path_teamEnchItemName_sharp4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_sharp4 = c.getString(path);
        }

        path = path_teamEnchantMaxCost;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchantMaxCost = c.getString(path);
        }

        path = path_teamEnchItemName_sharpMax;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_sharpMax = c.getString(path);
        }

        path = path_teamEnchItemName_protMax;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_protMax = c.getString(path);
        }

        path = path_leveluphasteItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            leveluphasteItemType = Material.getMaterial(c.getString(path));
        }

        path = path_leveluphasteItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            leveluphasteItemSlot = c.getInt(path);
        }

        path = path_teamEffItemName_haste1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEffItemName_haste1 = c.getString(path);
        }

        path = path_teamEffItemName_haste2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEffItemName_haste2 = c.getString(path);
        }

        path = path_teamEffItemName_haste3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEffItemName_haste3 = c.getString(path);
        }

        path = path_teamEffItemName_hasteMax;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEffItemName_hasteMax = c.getString(path);
        }

        path = path_leveluphealItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            leveluphealItemType = Material.getMaterial(c.getString(path));
        }

        path = path_leveluphealItemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            leveluphealItemSlot = c.getInt(path);
        }

        path = path_teamEffItemName_healMax;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEffItemName_healMax = c.getString(path);
        }

        path = path_messLevelUphaste1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUphaste1 = c.getString(path);
        }

        path = path_messLevelUphaste2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUphaste2 = c.getString(path);
        }

        path = path_messLevelUphaste3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUphaste3 = c.getString(path);
        }

        path = path_messLevelUpheal1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpheal1 = c.getString(path);
        }

        path = path_teamEffItemName_heal1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEffItemName_heal1 = c.getString(path);
        }

        path = path_itemShopEntityName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            itemShopEntityName = c.getString(path);
        }

        path = path_openShopOnCustomEntityName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            openShopOnCustomEntityName = c.getBoolean(path);
        }

        path = path_teamEff_heal_dis;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEff_heal_dis = c.getInt(path);
        }

        path = path_levelupShopDelayOpen;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            levelupShopDelayOpen = c.getBoolean(path);
        }

        path = path_levelupItemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            levelupItemType = Material.getMaterial(c.getString(path));
        }
        applyLevelUpItemName(c);

    }

    private void applyLevelUpItemName(FileConfiguration c) {
        String path;
        path = path_teamEnchItemName_sharp1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_sharp1 = c.getString(path);
        }

        path = path_teamEnchItemName_prot1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_prot1 = c.getString(path);
        }

        path = path_teamEnchItemName_prot2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_prot2 = c.getString(path);
        }

        path = path_teamEnchItemName_prot3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_prot3 = c.getString(path);
        }

        path = path_teamEnchItemName_prot4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teamEnchItemName_prot4 = c.getString(path);
        }
    }

    private void applyLevelupCost(FileConfiguration c) {
        applylevelupCost2v2(c);
        applylevelupCost4v4(c);
    }

    private void applylevelupCost2v2(FileConfiguration c) {
        String path;
        path = path_sharp1Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            sharp1Cost2v2 = c.getInt(path);
        }

        path = path_sharp2Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            sharp2Cost2v2 = c.getInt(path);
        }

        path = path_sharp3Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            sharp3Cost2v2 = c.getInt(path);
        }

        path = path_sharp4Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            sharp4Cost2v2 = c.getInt(path);
        }

        path = path_prot1Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            prot1Cost2v2 = c.getInt(path);
        }

        path = path_prot2Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            prot2Cost2v2 = c.getInt(path);
        }

        path = path_prot3Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            prot3Cost2v2 = c.getInt(path);
        }

        path = path_prot4Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            prot4Cost2v2 = c.getInt(path);
        }


        path = path_haste1Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            haste1Cost2v2 = c.getInt(path);
        }

        path = path_haste2Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            haste2Cost2v2 = c.getInt(path);
        }

        path = path_haste3Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            haste3Cost2v2 = c.getInt(path);
        }

        path = path_heal1Cost2v2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            heal1Cost2v2 = c.getInt(path);
        }
    }

    private void applylevelupCost4v4(FileConfiguration c) {
        String path;
        path = path_sharp1Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            sharp1Cost4v4 = c.getInt(path);
        }

        path = path_sharp2Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            sharp2Cost4v4 = c.getInt(path);
        }

        path = path_sharp3Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            sharp3Cost4v4 = c.getInt(path);
        }

        path = path_sharp4Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            sharp4Cost4v4 = c.getInt(path);
        }

        path = path_prot1Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            prot1Cost4v4 = c.getInt(path);
        }

        path = path_prot2Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            prot2Cost4v4 = c.getInt(path);
        }

        path = path_prot3Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            prot3Cost4v4 = c.getInt(path);
        }

        path = path_prot4Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            prot4Cost4v4 = c.getInt(path);
        }


        path = path_haste1Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            haste1Cost4v4 = c.getInt(path);
        }

        path = path_haste2Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            haste2Cost4v4 = c.getInt(path);
        }

        path = path_haste3Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            haste3Cost4v4 = c.getInt(path);
        }

        path = path_heal1Cost4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            heal1Cost4v4 = c.getInt(path);
        }
    }


    private void applyLevelUpMessConfig(FileConfiguration c) {
        String path;
        path = path_messLevelUpFailed;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpFailed = c.getString(path);
        }

        path = path_messLevelUpsharp1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpsharp1 = c.getString(path);
        }

        path = path_messLevelUpsharp2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpsharp2 = c.getString(path);
        }

        path = path_messLevelUpsharp3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpsharp3 = c.getString(path);
        }

        path = path_messLevelUpsharp4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpsharp4 = c.getString(path);
        }
        path = path_messLevelUpprot1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpprot1 = c.getString(path);
        }

        path = path_messLevelUpprot2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpprot2 = c.getString(path);
        }

        path = path_messLevelUpprot3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpprot3 = c.getString(path);
        }

        path = path_messLevelUpprot4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            messLevelUpprot4 = c.getString(path);
        }
    }
}