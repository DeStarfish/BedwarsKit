









public final class SendTitleHelper {
    public static void sendTitle(Player player, String title, String subtitle, int fadeInTime, int stayTime, int fadeOutTime) {
if (title != null) {
    io.github.bedwarsrel.com.v1_8_r3.Title.showTitle(player, title, fadeInTime, stayTime, fadeOutTime);
}
if (subtitle != null) {
            io.github.bedwarsrel.com.v1_8_r3.Title.showSubTitle(player, subtitle, fadeInTime, stayTime, fadeOutTime);
        }
    }

    public static void sendTitle(Player player, String title, String subtitle) {

        ProtocolManager mgr = ProtocolLibrary.getProtocolManager();
        if (title != null) {
            PacketContainer titlePacket = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.TITLE);
            titlePacket.getTitleActions().write(0, EnumWrappers.TitleAction.TITLE);
            titlePacket.getChatComponents().write(0, WrappedChatComponent.fromText(title));
            mgr.sendServerPacket(player, titlePacket);
        }
        if (subtitle != null) {
            PacketContainer subtitlePacket = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.TITLE);
            subtitlePacket.getTitleActions().write(0, EnumWrappers.TitleAction.SUBTITLE);
            subtitlePacket.getChatComponents().write(0, WrappedChatComponent.fromText(subtitle));
            mgr.sendServerPacket(player, subtitlePacket);
        }
    }
}
