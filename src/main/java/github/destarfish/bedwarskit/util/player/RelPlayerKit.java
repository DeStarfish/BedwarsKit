















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelPlayerKit {
    public static final String kitNameKangaroo = "kangaroo";
    public static final String kitNameDefault = "default";
    public static final String kitNameNone = "none";
    public static final String kitNameDefaultLess = "defaultless";
    private static final String className = RelPlayerKit.class.getSimpleName();
    private static final ConcurrentHashMap<UUID, String> playerKitList;

    static {
        playerKitList = new ConcurrentHashMap<>(101);
    }

    public static ConcurrentHashMap<UUID, String> getPlayerKitList() {
        return playerKitList;
    }

    public static void applykit(UUID uuid) {
        if (kitEnable) {
            String kit = playerKitList.get(uuid);
            if (kit != null) {
                pdKit(uuid, kit);
            }
        } else {
            if (isDebug()) {
                le(className, "error while applykit -> kitenable == false");
            }
        }
    }

    public static void applykitforce(UUID uuid, String kit) {
        if (kitEnable) {
            pdKit(uuid, kit);
        } else {
            if (isDebug()) {
                le(className, "error while applykitforce -> kitenable == false");
            }
        }
    }

    private static void pdKit(UUID uuid, String kit) {
        switch (kit.toLowerCase()) {
            case kitNameDefault: {
                KitDefault.setKit(uuid);
            }
            break;
            case kitNameDefaultLess: {
                KitDefaultLess.setKit(uuid);
            }
            break;
            case kitNameKangaroo: {
                KitKangaroo.setKit(uuid);
            }
            break;
            case kitNameNone: {
                KitNone.setKit(uuid);
            }
            break;
            default: {
                sendError(kit);
            }
            break;
        }
    }

    public static boolean isSelectedKit(UUID playerUUID, Material itemType) {
        boolean isSelected = false;

        if (itemType == KitDefaultItemType) {
            setPlayerKit(playerUUID, kitNameDefault);
            isSelected = true;
        } else if (itemType == KitNoneItemType) {
            setPlayerKit(playerUUID, kitNameNone);
            isSelected = true;

        } else if (itemType == KitDefaultLessItemType) {
            setPlayerKit(playerUUID, kitNameDefaultLess);
            isSelected = true;

        } else if (itemType == KitKangarooItemType) {
            setPlayerKit(playerUUID, kitNameKangaroo);
            isSelected = true;

        }
        return isSelected;
    }

    public static String getPlayerKit(UUID uuid) {
        return playerKitList.get(uuid);
    }

    public static void setPlayerKit(UUID uuid, String kit) {
        playerKitList.put(uuid, kit);
    }

    private static void sendError(String kit) {
        le(className, "pdkit" + " error: " + "kit" + StringMgr.vauleIsWrong + ": " + kit);
    }

}
