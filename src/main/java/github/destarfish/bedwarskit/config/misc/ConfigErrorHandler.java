













/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class ConfigErrorHandler {
    private static final Logger l = Bukkit.getLogger();

    private static final Set<String> loadErrors = new HashSet<>();

    public static Set<String> getLoadErrors() {
        return loadErrors;
    }

    public static void showAllError(CommandSender sender) {

        if (loadErrors.isEmpty()) {
            sendMessageC(sender, "&fThere are no loading configuration errors to display.");
            return;
        }
        lc("&e======= &fBedwarsKit All Config Error &e=======");

        lc("&b[fileName]&r Cant load &b[path]&r -> [cause]");

        for (String s : loadErrors) {
            String willSend = s
                    .replace("<", "&b<")
                    .replace(".yml>", ".yml>&r")
                    .replace("load '", "load '&b")
                    .replace("' ->", "&r' ->");
            lc(willSend);
        }

        lc("&e======= &fBedwarsKit All Config Error End &e=======");

        if (sender instanceof Player) {
            sendMessage(sender, "&aAll paths has print at console.");
        }

    }

    public static void addToErrors(String s) {
        if (s == null) {
            return;
        }
        loadErrors.add(s);
    }

    public static void clearErrors() {
        loadErrors.clear();
    }

    public static void er(String name, String path, String cause) {
        addToErrors("<" + name + "> " + "Cant load '" + path + "' -> " + cause);
    }
}
