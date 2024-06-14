





/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelArmorColor {
    public static Color
            red,
            blue,
            green,
            yellow,
            aqua,
            gray,
            pink,
            white,
            orange;

    public static void applyArmorColor() {
        red = Color.fromRGB(armorColor_RED_red, armorColor_RED_green, armorColor_RED_blue);
        blue = Color.fromRGB(armorColor_BLUE_red, armorColor_BLUE_green, armorColor_BLUE_blue);
        green = Color.fromRGB(armorColor_GREEN_red, armorColor_GREEN_green, armorColor_GREEN_blue);
        yellow = Color.fromRGB(armorColor_YELLOW_red, armorColor_YELLOW_green, armorColor_YELLOW_blue);
        aqua = Color.fromRGB(armorColor_AQUA_red, armorColor_AQUA_green, armorColor_AQUA_blue);
        gray = Color.fromRGB(armorColor_GRAY_red, armorColor_GRAY_green, armorColor_GRAY_blue);
        pink = Color.fromRGB(armorColor_PINK_red, armorColor_PINK_green, armorColor_PINK_blue);
        white = Color.fromRGB(armorColor_WHITE_red, armorColor_WHITE_green, armorColor_WHITE_blue);
        orange = Color.fromRGB(armorColor_ORANGE_red, armorColor_ORANGE_green, armorColor_ORANGE_blue);
    }
}