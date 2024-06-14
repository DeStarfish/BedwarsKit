










/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class MessSender {
    private static final ConsoleCommandSender console = Bukkit.getConsoleSender();
    private static final Logger l = Bukkit.getLogger();
    private static final String consolePrefix = PluginState.getConsolePrefix();
    private static final String consolePrefixColored = PluginState.getConsolePrefixColored();

    public static void l(String string) {
        console.sendMessage(t(consolePrefixColored + " " + string));
    }

    public static void lc(String string) {
        console.sendMessage(t(string));
    }

    public static void cl(String string) {
        console.sendMessage(t(consolePrefix + " " + string));
    }

    public static void le(String name, String casue) {
        l.warning(t(consolePrefix + " " + name + " " + casue));
    }

    public static void le(String className, Exception exception) {
        exception.printStackTrace();
    }

    public static void consoleSendCommand(String command) {
        Bukkit.dispatchCommand(console, command);
    }

    public static void sendMessage(CommandSender sender, String mess) {
        sender.sendMessage(t(mess));
    }
}
