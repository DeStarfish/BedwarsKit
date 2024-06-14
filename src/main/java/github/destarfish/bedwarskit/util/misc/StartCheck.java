








/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class StartCheck {
    public static void checkUpdate(int resId) {
        new UpdateChecker(JavaPlugin.getPlugin(BedwarsKit.class), resId).getVersion(version ->
        {
            setLastestVersion(version);
            setIsLastestVersion(getPluginVersion().equals(version));

            if (!isLastestVersion()) {
                if (update_tip != null && !update_tip.isEmpty()) {
                    showUpdateInfo();
                }
            }
        });
    }
}
