
















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
final class ScbHelper {

    static Map<Integer, String> getTaskMap(String gameName) {
        Map<Integer, String> taskMap = new HashMap<>(50);

        if (gametask_spawntime_tasks_iron1 > 0 && TaskIron1.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskIron1.getTaskTimeLeft(gameName), gametask_name_iron1);
        }
        if (gametask_spawntime_tasks_iron2 > 0 && TaskIron2.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskIron2.getTaskTimeLeft(gameName), gametask_name_iron2);
        }
        if (gametask_spawntime_tasks_iron3 > 0 && TaskIron3.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskIron3.getTaskTimeLeft(gameName), gametask_name_iron3);
        }
        if (gametask_spawntime_tasks_iron4 > 0 && TaskIron4.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskIron4.getTaskTimeLeft(gameName), gametask_name_iron4);
        }

        if (gametask_spawntime_tasks_gold1 > 0 && TaskGold1.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskGold1.getTaskTimeLeft(gameName), gametask_name_gold1);
        }
        if (gametask_spawntime_tasks_gold2 > 0 && TaskGold2.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskGold2.getTaskTimeLeft(gameName), gametask_name_gold2);
        }
        if (gametask_spawntime_tasks_gold3 > 0 && TaskGold3.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskGold3.getTaskTimeLeft(gameName), gametask_name_gold3);
        }
        if (gametask_spawntime_tasks_gold4 > 0 && TaskGold4.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskGold4.getTaskTimeLeft(gameName), gametask_name_gold4);
        }

        if (gametask_spawntime_tasks_diamond1 > 0 && TaskDiamond1.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskDiamond1.getTaskTimeLeft(gameName), gametask_name_diamond1);
        }
        if (gametask_spawntime_tasks_diamond2 > 0 && TaskDiamond2.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskDiamond2.getTaskTimeLeft(gameName), gametask_name_diamond2);
        }
        if (gametask_spawntime_tasks_diamond3 > 0 && TaskDiamond3.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskDiamond3.getTaskTimeLeft(gameName), gametask_name_diamond3);
        }
        if (gametask_spawntime_tasks_diamond4 > 0 && TaskDiamond4.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskDiamond4.getTaskTimeLeft(gameName), gametask_name_diamond4);
        }
        if (gametask_spawntime_tasks_emerald1 > 0 && TaskEmerald1.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskEmerald1.getTaskTimeLeft(gameName), gametask_name_emerald1);
        }
        if (gametask_spawntime_tasks_emerald2 > 0 && TaskEmerald2.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskEmerald2.getTaskTimeLeft(gameName), gametask_name_emerald2);
        }
        if (gametask_spawntime_tasks_emerald3 > 0 && TaskEmerald3.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskEmerald3.getTaskTimeLeft(gameName), gametask_name_emerald3);
        }
        if (gametask_spawntime_tasks_emerald4 > 0 && TaskEmerald4.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskEmerald4.getTaskTimeLeft(gameName), gametask_name_emerald4);
        }

        if (gametask_time_healthset1 > 0 && TaskHealthSet1.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskHealthSet1.getTaskTimeLeft(gameName), gametask_name_healthset1);
        }
        if (gametask_time_healthset2 > 0 && TaskHealthSet2.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskHealthSet2.getTaskTimeLeft(gameName), gametask_name_healthset2);
        }
        if (gametask_time_healthset3 > 0 && TaskHealthSet3.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskHealthSet3.getTaskTimeLeft(gameName), gametask_name_healthset3);
        }
        if (gametask_time_healthset4 > 0 && TaskHealthSet4.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskHealthSet4.getTaskTimeLeft(gameName), gametask_name_healthset4);
        }

        if (gametask_finalbattle_time > 0 && TaskFinalBattle.getTaskTimeLeft(gameName) > 0) {
            taskMap.put(TaskFinalBattle.getTaskTimeLeft(gameName), gametask_name_finalbattle);
        }

        return taskMap;
    }

    static void setGameScoreBoard(Game game) {
        Scoreboard scoreboard = game.getScoreboard();
        for (Player player : game.getPlayers()) {
            player.setScoreboard(scoreboard);
        }
    }
}
