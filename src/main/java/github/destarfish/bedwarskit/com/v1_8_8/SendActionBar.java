



/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class SendActionBar {
    public static void sendActionBar(Player player, String message) {
        if (player == null) {
            return;
        }
        if (message == null) {
            return;
        }
        io.github.bedwarsrel.com.v1_8_r3.ActionBar.sendActionBar(player, message);
    }
}