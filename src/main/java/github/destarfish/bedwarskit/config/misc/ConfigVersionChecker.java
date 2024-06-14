











/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class ConfigVersionChecker {
    private static final BedwarsKit plugin = BedwarsKit.getInstance();

    public static void checkAndRenameConfig(File configFile, String expectedVersion) {

        if (!configFile.exists()) {
            l("config file not exists: " + configFile.getName() + ", saving new...");
            plugin.saveResource(configFile.getName(), false);
            return;
        }

        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        String currentVersion = config.getString("config-version", "");

        if (currentVersion.equals(expectedVersion)) {
            if (isDebug()) {
                l(configFile.getName() + " Config Version Match.");
            }
        } else {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_M_d_H_m_s");
            String timeStamp = dateFormat.format(new Date());

            String newFileName = "_old_" + timeStamp;
            File renamedFile = new File(configFile.getParent(), configFile.getName().replaceFirst("\\.yml$", "") + newFileName + ".yml");

            boolean success = configFile.renameTo(renamedFile);

            if (success) {
                l("The configuration file &f{orgName}&r has been renamed to: &e{newName}"
                        .replace("{orgName}", configFile.getName())
                        .replace("{newName}", renamedFile.getName())
                );
                l("Config &f{orgName} &rDoes not match the current version, saving a new one...&r"
                        .replace("{orgName}", configFile.getName())
                        .replace("{exVersion}", expectedVersion)
                );
                plugin.saveResource(configFile.getName(), false);
            } else {
                l(configFile.getName() + "  rename failed.");
            }
        }
    }
}
