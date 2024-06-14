








public final class SendTitleHelper {
    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        ProtocolManager pm = ProtocolLibrary.getProtocolManager();

        if (title != null || subtitle != null) {
            PacketContainer titlesAnimPacket = pm.createPacket(PacketType.Play.Server.SET_TITLES_ANIMATION);
            titlesAnimPacket.getIntegers().write(0, fadeIn);
            titlesAnimPacket.getIntegers().write(1, stay);
            titlesAnimPacket.getIntegers().write(2, fadeOut);
            pm.sendServerPacket(player, titlesAnimPacket);
        }

        if (title != null) {
            PacketContainer titlePacket = pm.createPacket(PacketType.Play.Server.SET_TITLE_TEXT);
            WrappedChatComponent titleReal = WrappedChatComponent.fromText(title);
            titlePacket.getChatComponents().write(0, titleReal);
            pm.sendServerPacket(player, titlePacket);
        }

        if (subtitle != null) {
            PacketContainer subtitlePacket = pm.createPacket(PacketType.Play.Server.SET_SUBTITLE_TEXT);
            WrappedChatComponent subTitleReal = WrappedChatComponent.fromText(subtitle);
            subtitlePacket.getChatComponents().write(0, subTitleReal);
            pm.sendServerPacket(player, subtitlePacket);
        }
    }

    public static void sendTitle(Player player, String title, String subtitle) {
        ProtocolManager pm = ProtocolLibrary.getProtocolManager();

        if (title != null) {
            PacketContainer titlePacket = pm.createPacket(PacketType.Play.Server.SET_TITLE_TEXT);
            WrappedChatComponent titleReal = WrappedChatComponent.fromText(title);
            titlePacket.getChatComponents().write(0, titleReal);
            pm.sendServerPacket(player, titlePacket);
        }

        if (subtitle != null) {
            PacketContainer subtitlePacket = pm.createPacket(PacketType.Play.Server.SET_SUBTITLE_TEXT);
            WrappedChatComponent subTitleReal = WrappedChatComponent.fromText(subtitle);
            subtitlePacket.getChatComponents().write(0, subTitleReal);
            pm.sendServerPacket(player, subtitlePacket);
        }
    }
}
