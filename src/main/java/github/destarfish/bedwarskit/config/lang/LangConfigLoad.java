


















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class LangConfigLoad implements IConfigLoader {
    private final String className = getClass().getSimpleName();
    private final BedwarsKit plugin = BedwarsKit.getInstance();
    private final String fileName = "lang.yml";

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
            le(className, "[State] " + StringMgr.finishLoadConfig);
        }

    }

    private void applyConfig(FileConfiguration c) {

        String path;

        path = path_command_help;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (command_help == null) {
                command_help = new ArrayList<>();
            } else {
                command_help.clear();
            }

            command_help.addAll(c.getStringList(path));
        }

        path = path_relConfigIsChange_tryToSave;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relConfigIsChange_tryToSave = c.getString(path);
        }

        path = path_relConfigIsChange_Saved;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relConfigIsChange_Saved = c.getString(path);
        }

        path = path_meanRegExListener;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanRegExListener = c.getString(path);
        }

        path = path_meanRegExListenerSucc;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanRegExListenerSucc = c.getString(path);
        }

        path = path_meanCommandIsPlayerOnly;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanCommandIsPlayerOnly = c.getString(path);
        }

        path = path_meanEditGameToggleToTrue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanEditGameToggleToTrue = c.getString(path);
        }

        path = path_meanEditGameToggleToFalse;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanEditGameToggleToFalse = c.getString(path);
        }

        path = path_meanEntityNameSetTo;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanEntityNameSetTo = c.getString(path);
        }

        path = path_meanEntityNameRemove;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanEntityNameRemove = c.getString(path);
        }
    }
}