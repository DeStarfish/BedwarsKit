














/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class SendTab {
    private static final String className = SendTab.class.getSimpleName();

    private static void sendTabData(Player player, List<String> header, List<String> footer) {
        try {
            PacketContainer packet = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER);

            StringBuilder headerBuilder = new StringBuilder();
            for (int i = 0; i < header.size(); i++) {
                headerBuilder.append(header.get(i));
                if (i < header.size() - 1) {
                    headerBuilder.append("\n");
                }
            }

            StringBuilder footerBuilder = new StringBuilder();
            for (int i = 0; i < footer.size(); i++) {
                footerBuilder.append(footer.get(i));
                if (i < footer.size() - 1) {
                    footerBuilder.append("\n");
                }
            }

            packet.getChatComponents().write(0, WrappedChatComponent.fromText(headerBuilder.toString()));
            packet.getChatComponents().write(1, WrappedChatComponent.fromText(footerBuilder.toString()));

            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packet);
        } catch (Exception e) {
            le(className, e);
        }
    }

    private static void sendTabData(Player player, String header, String footer) {
        try {
            PacketContainer packet = ProtocolLibrary.getProtocolManager().createPacket(PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER);

            packet.getChatComponents().write(0, WrappedChatComponent.fromText(header));
            packet.getChatComponents().write(1, WrappedChatComponent.fromText(footer));

            ProtocolLibrary.getProtocolManager().sendServerPacket(player, packet);
        } catch (Exception e) {
            le(className, e);
        }
    }

    public static void sendTab(Player player) {
        if (tab_is_multiLine) {
            List<String> headerList = new ArrayList<>(20);
            List<String> footerList = new ArrayList<>(20);
            for (String s : tab_headList) {
                headerList.add(t(s));
            }
            for (String s : tab_footList) {
                footerList.add(t(s));
            }
            sendTabData(player, headerList, footerList);
        } else {
            String head;
            String foot;
            head = t(tab_head);
            foot = t(tab_foot);
            sendTabData(player, head, foot);
        }
    }
}
