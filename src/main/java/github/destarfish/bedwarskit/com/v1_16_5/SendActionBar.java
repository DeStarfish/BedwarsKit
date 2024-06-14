






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
        ChatMessageType type = ChatMessageType.ACTION_BAR;
        BaseComponent[] text = TextComponent.fromLegacyText(message);
        player.spigot().sendMessage(type, text);
    }
}