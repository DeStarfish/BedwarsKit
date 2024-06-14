





/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class StringMgr {

    public static final String msgline = "\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d\u003d";
    public static final String pluginName = "\u0042\u0065\u0064\u0077\u0061\u0072\u0073\u004b\u0069\u0074";
    public static String meanCommandRegSucc = "meanCommandRegSucc";
    public static String meanConfigLoadSucc = "meanConfigLoadSucc";
    public static String meanCommandRegNow = "meanCommandRegNow";
    public static String meanConfigLoadNow = "meanConfigLoadNow";

    public static String pluginDisable = "pluginDisable";
    public static String meanAuthor = "meanAuthor";
    public static String meanDebugDisable = "meanDebugDisable";
    public static String meanDebugEnable = "meanDebugEnable";
    public static String vauleIsWrong = "vauleIsWrong";
    public static String vauleIsNull = "vauleIsNull";
    public static String cantFoundSupport = "cantFoundSupport";
    public static String needIsWrong = "needIsWrong";
    public static String relConfigIsChange_tryToSave = "relConfigIsChange_tryToSave";
    public static String relConfigIsChange_Saved = "relConfigIsChange_Saved";
    public static String meanInvalidInventoryType = "meanInvalidInventoryType";
    public static List<String> update_tip = new ArrayList<>();
    public static String meanFoundNewVersion = "meanFoundNewVersion";
    public static String finishLoadConfig = "finishLoadConfig";

    public static void loadCurrentLang(String language) {

        meanDebugDisable = "&bBedwarsKit &7>>&f Debug Disabled";
        meanDebugEnable = "&bBedwarsKit &7>>&f Debug Enabled";
        vauleIsWrong = " vaule is wrong ";
        vauleIsNull = " vaule is null ";
        cantFoundSupport = "can't found support for this version: ";
        needIsWrong = "&e%target% is on but BedwarsRel's Config -> %path% is wrong, setting...";
        relConfigIsChange_tryToSave = "&eBedwarsRel's Config is changed, saving...";
        relConfigIsChange_Saved = "&aBedwarsRel's Config is saved.";
        meanInvalidInventoryType = "Invalid InventoryType: {type}";
        meanFoundNewVersion = "Found a new version";
        finishLoadConfig = "Config loaded";

        pluginDisable = "Disabled.";

        if (Objects.equals("zh", language)) {
            meanAuthor = "\u4f5c\u8005";
        } else {
            meanAuthor = "Author";
        }

        meanConfigLoadNow = "Config loading in progress";
        meanConfigLoadSucc = "&aConfig loaded";
        meanCommandRegNow = "Command registration in progress";
        meanCommandRegSucc = "&aCommand registered";

        update_tip.add("&a ================================");
        update_tip.add("&f ");
        update_tip.add("&f BedwarsKit &b" + meanFoundNewVersion + "!" + " &7(%newVersion%)");
        update_tip.add("&f ");
        update_tip.add("&f You can download here: https://www.spigotmc.org/resources/bedwarskit.105616/");
        update_tip.add(" ");
        update_tip.add("&a ================================");

    }
}
