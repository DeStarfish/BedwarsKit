




public final class KitHelper {
    public static boolean kitBase_coloredLeatherArmor = true;

    public static void setColorByTeam(String playerteam, TeamColorCallback callback) {
        switch (playerteam) {
            case RelColor_Red: {
                callback.setColor(red);
            }
            break;
            case RelColor_Blue: {
                callback.setColor(blue);
            }
            break;
            case RelColor_Green: {
                callback.setColor(green);
            }
            break;
            case RelColor_Yellow: {
                callback.setColor(yellow);
            }
            break;
            case RelColor_White: {
                callback.setColor(white);
            }
            break;
            case RelColor_Aqua: {
                callback.setColor(aqua);
            }
            break;
            case RelColor_Pink: {
                callback.setColor(pink);
            }
            break;
            case RelColor_Gray: {
                callback.setColor(gray);
            }
            break;
            case RelColor_Orange: {
                callback.setColor(orange);
            }
            break;
            default: {
            }
            break;
        }
    }
}
