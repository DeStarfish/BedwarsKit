

/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class MathUtil {

    public static double roundToOneDecimalPlace(double value) {
        return Math.round(value * 10) / 10.0;
    }

    public static String formatTime(int seconds) {
        return String.format("%d:%02d", seconds / 60, seconds % 60);
    }
}
