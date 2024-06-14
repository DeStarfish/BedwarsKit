








/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class PluginState {
    private static final List<Listener> regListners = new ArrayList<>();
    private static final String pluginVersion = "1.9.9";
    private static final int spigotId = 105616;
    //    public static String consolePrefixColored = "&b" + pluginName + " &7>>";
    public static String consolePrefixColored = "[" + pluginName + "]";
    public static String consolePrefix = "[" + pluginName + "]";
    private static boolean isDebug = false;
    private static boolean isLastestVersion = false;
    private static String lastestVersion = "(Waitting to set...)";
    private static String language;
    private static String country;
    private static String formatLanguage;
    private static boolean bungeeEnabled;
    private static String serverVersion;
    private static boolean alwaysHaveAGoal;

    public static void toggleAlwayHaveGoal() {
        alwaysHaveAGoal = !alwaysHaveAGoal;
    }

    public static boolean isAlwaysHaveAGoal() {
        return alwaysHaveAGoal;
    }

    public static String getLastestVersion() {
        return lastestVersion;
    }

    public static void addRegListners(Listener listener) {
        regListners.add(listener);
    }

    public static List<Listener> getRegListners() {
        return regListners;
    }

    public static String getPluginVersion() {
        return pluginVersion;
    }

    public static String getConsolePrefix() {
        return consolePrefix;
    }

    public static String getConsolePrefixColored() {
        return consolePrefixColored;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static void toggleDebug() {
        isDebug = !isDebug;
    }

    public static boolean isLastestVersion() {
        return isLastestVersion;
    }

    public static void setLastestVersion(String setTo) {
        lastestVersion = setTo;
    }

    public static void setIsLastestVersion(boolean setTo) {
        isLastestVersion = setTo;
    }

    public static int getSpigotId() {
        return spigotId;
    }

    public static String getLanguage() {
        return language;
    }

    public static void setLanguage(String setTo) {
        language = setTo;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String setTo) {
        country = setTo;
    }

    public static String getFormatLanguage() {
        return formatLanguage;
    }

    public static void setformatLanguage(String setTo) {
        formatLanguage = setTo;
    }

    public static boolean isBungeeEnabled() {
        return bungeeEnabled;
    }

    public static void setBungeeEnabled(boolean setTo) {
        bungeeEnabled = setTo;
    }

    public static String getServerVersion() {
        return serverVersion;
    }

    public static void setServerVersion(String setTo) {
        serverVersion = setTo;
    }
}
