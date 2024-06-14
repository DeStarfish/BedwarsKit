








/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class StartMetrics {
    private static final String className = StartMetrics.class.getSimpleName();

    public static void startMetrics() {
        try {
            BedwarsKit plugin = BedwarsKit.getInstance();
            Metrics metrics = new Metrics(plugin, 20914);

            metrics.addCustomChart(new Metrics.SimplePie("java_version", () -> System.getProperty("java.version")));

            metrics.addCustomChart(new Metrics.SimplePie("minecraft_version", () -> plugin.getServer().getVersion()));
            metrics.addCustomChart(new Metrics.SimplePie("online_mode", () -> String.valueOf(plugin.getServer().getOnlineMode())));
            metrics.addCustomChart(new Metrics.SimplePie("bungeecord_enabled", () -> String.valueOf(isBungeeEnabled())));
            metrics.addCustomChart(new Metrics.SimplePie("plugin_version", PluginState::getPluginVersion));

        } catch (Exception e) {
            le(className, e);
        }
    }
}
