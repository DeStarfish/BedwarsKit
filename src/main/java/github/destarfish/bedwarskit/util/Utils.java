














/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class Utils {
    private static final String className = Utils.class.getSimpleName();
    private static final String mean2v2 = "2v2";
    private static final String mean4v4 = "4v4";
    private static final String meanAuto = "auto";

    public static String isInMode(Game game) {

        if (isBungeeEnabled()) {
            if (Objects.equals(bungeeMode, mean2v2)) {
                return mean2v2;
            } else if (Objects.equals(bungeeMode, mean4v4)) {
                return mean4v4;
            } else if (Objects.equals(bungeeMode, meanAuto)) {

                Collection<Team> teams = game.getTeams().values();
                int teamSize = teams.size();

                if (teamSize > 4) {
                    return mean2v2;
                } else {
                    return mean4v4;
                }
            } else {
                if (isDebug()) {
                    le(className,
                            "[isBungeeMode] error while get worldMode for "
                                    + game.getName()
                                    + " -> bungeeMode is not"
                                    + mean2v2 + " or "
                                    + mean4v4 + " or "
                                    + meanAuto + " or "
                                    + ", returned " + mean2v2);
                }
                return mean2v2;
            }
        } else {

            if (game == null) {
                return mean2v2;
            }

            if (game.getRegion() == null) {
                return mean2v2;
            }
            Region region = game.getRegion();
            if (region == null) {
                return mean2v2;
            }

            World world = region.getWorld();
            String worldName = world.getName();

            if (worldMode_autoJudge) {

                Collection<Team> teams = game.getTeams().values();
                int teamSize = teams.size();

                if (teamSize > 4) {
                    return mean2v2;
                } else {
                    return mean4v4;
                }

            } else {

                if (gameWorld4v4.contains(worldName)) {
                    return mean4v4;
                } else {
                    return mean2v2;
                }
            }
        }
    }
}
