

















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class ResConfigLoad implements IConfigLoader {
    private final String className = getClass().getSimpleName();
    private final BedwarsKit plugin = BedwarsKit.getInstance();
    private final String fileName = "floating_font.yml";

    private void sendError(String path) {
        er(fileName, path, vauleIsNull);
    }

    public void loadConfig() {

        final String use_config_version = "1.9.8";

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

    }

    private void applyConfig(FileConfiguration c) {

        String path;

        path = path_resBlock_spinSpeed;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            long willSet = c.getLong(path);
            if (willSet < 1) {
                willSet = 1;
            }
            resBlock_spinSpeed = willSet;
        }

        applyBlockEmeraldConfig(c);
        applyBlockDiamondConfig(c);
        applyBlockGoldConfig(c);
        applyBlockIronConfig(c);
    }


    private void applyBlockIronConfig(FileConfiguration c) {
        String path;
        path = path_resBlock_Iron;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Iron = c.getBoolean(path);
        }

        path = path_resBlock_yawPerTick;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_yawPerTick = (float) c.getDouble(path);
        }

        path = path_resBlock_Iron_isSmall;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Iron_isSmall = c.getBoolean(path);
        }

        path = path_resBlock_Iron_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Iron_y = c.getDouble(path);
        }

        path = path_resText1_Iron;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText1_Iron = c.getString(path);
        }

        path = path_resText2_Iron;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText2_Iron = c.getString(path);
        }

        path = path_resText3_Iron;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText3_Iron = c.getString(path);
        }

        path = path_resText1_Iron_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText1_Iron_y = c.getDouble(path);
        }

        path = path_resText2_Iron_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText2_Iron_y = c.getDouble(path);
        }

        path = path_resText3_Iron_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText3_Iron_y = c.getDouble(path);
        }
    }

    private void applyBlockGoldConfig(FileConfiguration c) {
        String path;
        path = path_resBlock_Gold;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Gold = c.getBoolean(path);
        }

        path = path_resBlock_yawPerTick;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_yawPerTick = (float) c.getDouble(path);
        }

        path = path_resBlock_Gold_isSmall;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Gold_isSmall = c.getBoolean(path);
        }

        path = path_resBlock_Gold_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Gold_y = c.getDouble(path);
        }

        path = path_resText1_Gold;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText1_Gold = c.getString(path);
        }

        path = path_resText2_Gold;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText2_Gold = c.getString(path);
        }

        path = path_resText3_Gold;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText3_Gold = c.getString(path);
        }

        path = path_resText1_Gold_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText1_Gold_y = c.getDouble(path);
        }

        path = path_resText2_Gold_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText2_Gold_y = c.getDouble(path);
        }

        path = path_resText3_Gold_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText3_Gold_y = c.getDouble(path);
        }
    }

    private void applyBlockDiamondConfig(FileConfiguration c) {
        String path;
        path = path_resBlock_Diamond;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Diamond = c.getBoolean(path);
        }

        path = path_resBlock_yawPerTick;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_yawPerTick = (float) c.getDouble(path);
        }

        path = path_resBlock_Diamond_isSmall;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Diamond_isSmall = c.getBoolean(path);
        }

        path = path_resBlock_Diamond_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Diamond_y = c.getDouble(path);
        }

        path = path_resText1_Diamond;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText1_Diamond = c.getString(path);
        }

        path = path_resText2_Diamond;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText2_Diamond = c.getString(path);
        }

        path = path_resText3_Diamond;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText3_Diamond = c.getString(path);
        }

        path = path_resText1_Diamond_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText1_Diamond_y = c.getDouble(path);
        }

        path = path_resText2_Diamond_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText2_Diamond_y = c.getDouble(path);
        }

        path = path_resText3_Diamond_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText3_Diamond_y = c.getDouble(path);
        }
    }

    private void applyBlockEmeraldConfig(FileConfiguration c) {
        String path;
        path = path_resBlock_Emerald;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Emerald = c.getBoolean(path);
        }

        path = path_resBlock_yawPerTick;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_yawPerTick = (float) c.getDouble(path);
        }

        path = path_resBlock_Emerald_isSmall;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Emerald_isSmall = c.getBoolean(path);
        }

        path = path_resBlock_Emerald_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resBlock_Emerald_y = c.getDouble(path);
        }

        path = path_resText1_Emerald;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText1_Emerald = c.getString(path);
        }

        path = path_resText2_Emerald;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText2_Emerald = c.getString(path);
        }

        path = path_resText3_Emerald;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText3_Emerald = c.getString(path);
        }

        path = path_resText1_Emerald_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText1_Emerald_y = c.getDouble(path);
        }

        path = path_resText2_Emerald_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText2_Emerald_y = c.getDouble(path);
        }

        path = path_resText3_Emerald_y;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resText3_Emerald_y = c.getDouble(path);
        }
    }
}