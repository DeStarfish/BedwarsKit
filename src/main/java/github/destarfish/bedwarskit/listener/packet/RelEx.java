

/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelEx {

    private static boolean stateOk = false;

    public static void setUpPacketListener() {
        if (stateOk) {
            return;
        }

        stateOk = true;

//        BedwarsKit plugin = BedwarsKit.getInstance();
//
//        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();
//
//        protocolManager.addPacketListener(new PacketAdapter(plugin, ListenerPriority.HIGHEST,
//                PacketType.Play.Server.ENTITY_TELEPORT
//        ) {
//            @Override
//            public void onPacketSending(PacketEvent event) {
//            }
//        });
    }
}