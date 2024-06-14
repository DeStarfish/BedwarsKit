


















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class ScbConfigLoad implements IConfigLoader {
    private final String className = getClass().getSimpleName();
    private final BedwarsKit plugin = BedwarsKit.getInstance();

    private final String fileName = "scoreboard.yml";

    private void sendError(String path) {
        er(fileName, path, vauleIsNull);
    }

    public void loadConfig() {

        final String use_config_version = "1.9.9";

        if (isDebug()) {
            le(className, "[State] loading " + fileName + "(" + use_config_version + ")");
        }

        final File file = new File(plugin.getDataFolder(), fileName);

        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }

        checkAndRenameConfig(file, use_config_version);

        final FileConfiguration c = YamlConfiguration.loadConfiguration(file);

        try {
            applyConfig(c);
        } catch (Exception e) {
            le(className, e);
        }

        if (isDebug()) {
            le(className, "[State] " + finishLoadConfig);
        }

    }

    private void applyConfig(FileConfiguration c) {

        String path;

        applyMeanConfig(c);

        applyScb2v2Config(c);

        applyScb4v4Config(c);


//        path = path_health_display;
//        if (c.get(path) == null) {
//            sendError(path);
//        } else {
//            health_display = c.getBoolean(path);
//        }
//
//        path = path_health_displaySlot;
//        if (c.get(path) == null || DisplaySlot.valueOf(c.getString(path)) == null) {
//            sendError(path);
//        } else {
//            health_displaySlot = DisplaySlot.valueOf(c.getString(path));
//        }

    }

    private void applyMeanConfig(FileConfiguration c) {
        String path;
        path = path_meanTeamStat_Alive;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanTeamStat_Alive = c.getString(path);
        }

        path = path_meanTeamStat_Dead;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanTeamStat_Dead = c.getString(path);
        }

        path = path_meanBedStat_Yes;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanBedStat_Yes = c.getString(path);
        }

        path = path_meanBedStat_No;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanBedStat_No = c.getString(path);
        }

        path = path_TeamStat_BedYes;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanTeamStat_BedYes = c.getString(path);
        }

        path = path_meanTeamStat_None;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanTeamStat_None = c.getString(path);
        }

        path = path_meanTeamStat_BedNo;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanTeamStat_BedNo = c.getString(path);
        }

        path = path_meanServerIp;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanServerIp = c.getString(path);
        }

        path = path_meanYou;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanYou = c.getString(path);
        }

        path = path_meanNotYou;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanNotYou = c.getString(path);
        }

        path = path_meanBedwars;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanBedwars = c.getString(path);
        }

        path = path_mean2v2Mode;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            mean2v2Mode = c.getString(path);
        }

        path = path_mean4v4Mode;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            mean4v4Mode = c.getString(path);
        }

        path = path_meanGameEnd;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanGameEnd = c.getString(path);
        }
    }

    private void applyScb2v2Config(FileConfiguration c) {
        String path;
        path = path_ScoreBoard2v2Title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Title = c.getString(path);
        }

        path = path_ScoreBoard2v2Line01;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line01 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line02;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line02 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line03;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line03 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line04;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line04 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line05;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line05 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line06;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line06 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line07;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line07 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line08;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line08 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line09;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line09 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line10;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line10 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line11;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line11 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line12;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line12 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line13;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line13 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line14;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line14 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line15;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line15 = c.getString(path);
        }

        path = path_ScoreBoard2v2Line16;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard2v2Line16 = c.getString(path);
        }

        ScoreBoard2v2Line = new HashMap<>(18);
        ScoreBoard2v2Line.put(100, ScoreBoard2v2Title);
        ScoreBoard2v2Line.put(16, ScoreBoard2v2Line01);
        ScoreBoard2v2Line.put(15, ScoreBoard2v2Line02);
        ScoreBoard2v2Line.put(14, ScoreBoard2v2Line03);
        ScoreBoard2v2Line.put(13, ScoreBoard2v2Line04);
        ScoreBoard2v2Line.put(12, ScoreBoard2v2Line05);
        ScoreBoard2v2Line.put(11, ScoreBoard2v2Line06);
        ScoreBoard2v2Line.put(10, ScoreBoard2v2Line07);
        ScoreBoard2v2Line.put(9, ScoreBoard2v2Line08);
        ScoreBoard2v2Line.put(8, ScoreBoard2v2Line09);
        ScoreBoard2v2Line.put(7, ScoreBoard2v2Line10);
        ScoreBoard2v2Line.put(6, ScoreBoard2v2Line11);
        ScoreBoard2v2Line.put(5, ScoreBoard2v2Line12);
        ScoreBoard2v2Line.put(4, ScoreBoard2v2Line13);
        ScoreBoard2v2Line.put(3, ScoreBoard2v2Line14);
        ScoreBoard2v2Line.put(2, ScoreBoard2v2Line15);
        ScoreBoard2v2Line.put(1, ScoreBoard2v2Line16);

        ScoreBoard2v2StartTitle = " ";
    }

    private void applyScb4v4Config(FileConfiguration c) {
        String path;
        path = path_ScoreBoard4v4Title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Title = c.getString(path);
        }

        path = path_ScoreBoard4v4Line01;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line01 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line02;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line02 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line03;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line03 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line04;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line04 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line05;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line05 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line06;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line06 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line07;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line07 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line08;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line08 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line09;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line09 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line10;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line10 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line11;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line11 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line12;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line12 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line13;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line13 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line14;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line14 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line15;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line15 = c.getString(path);
        }

        path = path_ScoreBoard4v4Line16;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ScoreBoard4v4Line16 = c.getString(path);
        }

        ScoreBoard4v4Line = new HashMap<>(18);
        ScoreBoard4v4Line.put(100, ScoreBoard4v4Title);
        ScoreBoard4v4Line.put(16, ScoreBoard4v4Line01);
        ScoreBoard4v4Line.put(15, ScoreBoard4v4Line02);
        ScoreBoard4v4Line.put(14, ScoreBoard4v4Line03);
        ScoreBoard4v4Line.put(13, ScoreBoard4v4Line04);
        ScoreBoard4v4Line.put(12, ScoreBoard4v4Line05);
        ScoreBoard4v4Line.put(11, ScoreBoard4v4Line06);
        ScoreBoard4v4Line.put(10, ScoreBoard4v4Line07);
        ScoreBoard4v4Line.put(9, ScoreBoard4v4Line08);
        ScoreBoard4v4Line.put(8, ScoreBoard4v4Line09);
        ScoreBoard4v4Line.put(7, ScoreBoard4v4Line10);
        ScoreBoard4v4Line.put(6, ScoreBoard4v4Line11);
        ScoreBoard4v4Line.put(5, ScoreBoard4v4Line12);
        ScoreBoard4v4Line.put(4, ScoreBoard4v4Line13);
        ScoreBoard4v4Line.put(3, ScoreBoard4v4Line14);
        ScoreBoard4v4Line.put(2, ScoreBoard4v4Line15);
        ScoreBoard4v4Line.put(1, ScoreBoard4v4Line16);

        ScoreBoard4v4StartTitle = " ";
    }
}