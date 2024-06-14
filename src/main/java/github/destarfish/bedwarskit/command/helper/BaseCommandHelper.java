














/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class BaseCommandHelper {
    public static void showPluginInfo(Player sender) {
        BedwarsKit plugin = BedwarsKit.getInstance();
        PluginDescriptionFile file = plugin.getDescription();
        String author = file.getAuthors().get(0);

        sender.sendMessage(green + msgline);
        sender.sendMessage(" ");
        sender.sendMessage(white + pluginName + " " + aqua + getPluginVersion());
        sender.sendMessage(" ");
        sender.sendMessage(white + meanAuthor + ": " + yellow + author);
        sender.sendMessage(" ");
        sender.sendMessage(green + msgline);
    }

    public static void showPluginInfo(CommandSender sender) {
        BedwarsKit plugin = BedwarsKit.getInstance();
        PluginDescriptionFile file = plugin.getDescription();
        String author = file.getAuthors().get(0);

        sender.sendMessage(green + msgline);
        sender.sendMessage(" ");
        sender.sendMessage(white + pluginName + " " + aqua + getPluginVersion());
        sender.sendMessage(" ");
        sender.sendMessage(white + meanAuthor + ": " + yellow + author);
        sender.sendMessage(" ");
        sender.sendMessage(green + msgline);
    }

    public static void showFallBackHelpMsg(CommandSender sender) {
        sender.sendMessage(" ");
        sender.sendMessage(white + pluginName + " " + aqua + "Commands:");
        sender.sendMessage(" ");
        sender.sendMessage(" " + white + "/bwk" + yellow + " Display this help information.");
        sender.sendMessage(" " + white + "/bwk reload" + yellow + " Reload configuration file.");
        sender.sendMessage(" ");
    }

    public static void showUpdateInfo(Player player) {
        String lastestVersion = PluginState.getLastestVersion();
        for (String s : update_tip) {
            String willSend = s
                    .replace("%newVersion%", lastestVersion);
            sendMessage(player, willSend);
        }
    }

    public static void showUpdateInfo() {
        String lastestVersion = PluginState.getLastestVersion();
        for (String s : update_tip) {
            String willSend = t(s
                    .replace("%newVersion%", lastestVersion)
            );
            l(willSend);
        }
    }
}
