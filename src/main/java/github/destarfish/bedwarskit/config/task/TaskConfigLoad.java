

















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class TaskConfigLoad implements IConfigLoader {
    private final String className = getClass().getSimpleName();
    private final BedwarsKit plugin = BedwarsKit.getInstance();
    private final String fileName = "task.yml";

    private void sendError(String path) {
        er(fileName, path, vauleIsNull);
    }

    public void loadConfig() {

        final String use_config_version = "1.9.8";

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

        path = path_gametask;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask = c.getBoolean(path);
        }

        applySpawnTimerConfig(c);

        applyTaskFinalBattleConfig(c);

        applyTaskIronConfig(c);
        applyTaskGoldConfig(c);
        applyTaskDiamondConfig(c);
        applyTaskEmeraldConfig(c);

        applyTaskHealthSetConfig(c);

    }

    private void applyTaskHealthSetConfig(FileConfiguration c) {
        String path;

        path = path_gametask_time_healthset1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_time_healthset1 = c.getInt(path);
        }

        path = path_gametask_time_healthset2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_time_healthset2 = c.getInt(path);
        }

        path = path_gametask_time_healthset3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_time_healthset3 = c.getInt(path);
        }

        path = path_gametask_time_healthset4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_time_healthset4 = c.getInt(path);
        }

        path = path_gametask_name_healthset1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_healthset1 = c.getString(path);
        }

        path = path_gametask_name_healthset2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_healthset2 = c.getString(path);
        }

        path = path_gametask_name_healthset3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_healthset3 = c.getString(path);
        }


        path = path_gametask_name_healthset4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_healthset4 = c.getString(path);
        }


        path = path_gametask_mess_healthset1_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset1_chat = c.getString(path);
        }

        path = path_gametask_mess_healthset1_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset1_title = c.getString(path);
        }

        path = path_gametask_mess_healthset1_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset1_subtitle = c.getString(path);
        }

        path = path_gametask_mess_healthset1_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset1_actionbar = c.getString(path);
        }
        path = path_gametask_mess_healthset2_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset2_chat = c.getString(path);
        }

        path = path_gametask_mess_healthset2_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset2_title = c.getString(path);
        }

        path = path_gametask_mess_healthset2_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset2_subtitle = c.getString(path);
        }

        path = path_gametask_mess_healthset2_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset2_actionbar = c.getString(path);
        }
        path = path_gametask_mess_healthset3_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset3_chat = c.getString(path);
        }

        path = path_gametask_mess_healthset3_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset3_title = c.getString(path);
        }

        path = path_gametask_mess_healthset3_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset3_subtitle = c.getString(path);
        }

        path = path_gametask_mess_healthset3_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset3_actionbar = c.getString(path);
        }

        path = path_gametask_mess_healthset4_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset4_chat = c.getString(path);
        }

        path = path_gametask_mess_healthset4_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset4_title = c.getString(path);
        }

        path = path_gametask_mess_healthset4_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset4_subtitle = c.getString(path);
        }

        path = path_gametask_mess_healthset4_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_healthset4_actionbar = c.getString(path);
        }

        path = path_gametask_healthset_1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_healthset_1 = c.getDouble(path);
        }
        path = path_gametask_healthset_2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_healthset_2 = c.getDouble(path);
        }

        path = path_gametask_healthset_3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_healthset_3 = c.getDouble(path);
        }

        path = path_gametask_healthset_4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_healthset_4 = c.getDouble(path);
        }
    }

    private void applyTaskFinalBattleConfig(FileConfiguration c) {
        String path;
        path = path_gametask_finalbattle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_finalbattle = c.getBoolean(path);
        }

        path = path_gametask_finalbattle_boundaries_time;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_finalbattle_boundaries_time = c.getLong(path);
        }

        path = path_gametask_finalbattle_boundaries_size;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_finalbattle_boundaries_size = c.getLong(path);
        }

        path = path_gametask_finalbattle_time;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_finalbattle_time = c.getInt(path);
        }

        path = path_gametask_name_finalbattle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_finalbattle = c.getString(path);
        }

        path = path_gametask_mess_finalbattle_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_finalbattle_chat = c.getString(path);
        }

        path = path_gametask_mess_finalbattle_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_finalbattle_title = c.getString(path);
        }

        path = path_gametask_mess_finalbattle_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_finalbattle_subtitle = c.getString(path);
        }

        path = path_gametask_mess_finalbattle_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_finalbattle_actionbar = c.getString(path);
        }

        path = path_gametask_finalbattle_boundaries_warnidis;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_finalbattle_boundaries_warnidis = c.getInt(path);
        }

        path = path_gametask_finalbattle_boundaries_damagebuffer;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_finalbattle_boundaries_damagebuffer = c.getDouble(path);
        }

        path = path_gametask_finalbattle_boundaries_damage;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_finalbattle_boundaries_damage = c.getDouble(path);
        }
    }

    private void applyTaskIronConfig(FileConfiguration c) {
        String path;

        path = path_gametask_spawntime_tasks_iron1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_iron1 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_iron2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_iron2 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_iron3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_iron3 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_iron4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_iron4 = c.getInt(path);
        }

        path = path_gametask_name_iron1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_iron1 = c.getString(path);
        }

        path = path_gametask_name_iron2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_iron2 = c.getString(path);
        }

        path = path_gametask_name_iron3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_iron3 = c.getString(path);
        }

        path = path_gametask_name_iron4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_iron4 = c.getString(path);
        }

        path = path_gametask_mess_iron1_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron1_chat = c.getString(path);
        }

        path = path_gametask_mess_iron1_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron1_title = c.getString(path);
        }

        path = path_gametask_mess_iron1_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron1_subtitle = c.getString(path);
        }

        path = path_gametask_mess_iron1_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron1_actionbar = c.getString(path);
        }
        path = path_gametask_mess_iron2_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron2_chat = c.getString(path);
        }

        path = path_gametask_mess_iron2_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron2_title = c.getString(path);
        }

        path = path_gametask_mess_iron2_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron2_subtitle = c.getString(path);
        }

        path = path_gametask_mess_iron2_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron2_actionbar = c.getString(path);
        }

        path = path_gametask_mess_iron3_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron3_chat = c.getString(path);
        }

        path = path_gametask_mess_iron3_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron3_title = c.getString(path);
        }

        path = path_gametask_mess_iron3_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron3_subtitle = c.getString(path);
        }

        path = path_gametask_mess_iron3_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron3_actionbar = c.getString(path);
        }

        path = path_gametask_mess_iron4_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron4_chat = c.getString(path);
        }

        path = path_gametask_mess_iron4_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron4_title = c.getString(path);
        }

        path = path_gametask_mess_iron4_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron4_subtitle = c.getString(path);
        }

        path = path_gametask_mess_iron4_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_iron4_actionbar = c.getString(path);
        }
    }

    private void applyTaskGoldConfig(FileConfiguration c) {
        String path;

        path = path_gametask_spawntime_tasks_gold1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_gold1 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_gold2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_gold2 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_gold3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_gold3 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_gold4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_gold4 = c.getInt(path);
        }

        path = path_gametask_name_gold1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_gold1 = c.getString(path);
        }

        path = path_gametask_name_gold2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_gold2 = c.getString(path);
        }

        path = path_gametask_name_gold3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_gold3 = c.getString(path);
        }

        path = path_gametask_name_gold4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_gold4 = c.getString(path);
        }

        path = path_gametask_mess_gold1_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold1_chat = c.getString(path);
        }

        path = path_gametask_mess_gold1_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold1_title = c.getString(path);
        }

        path = path_gametask_mess_gold1_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold1_subtitle = c.getString(path);
        }

        path = path_gametask_mess_gold1_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold1_actionbar = c.getString(path);
        }
        path = path_gametask_mess_gold2_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold2_chat = c.getString(path);
        }

        path = path_gametask_mess_gold2_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold2_title = c.getString(path);
        }

        path = path_gametask_mess_gold2_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold2_subtitle = c.getString(path);
        }

        path = path_gametask_mess_gold2_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold2_actionbar = c.getString(path);
        }

        path = path_gametask_mess_gold3_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold3_chat = c.getString(path);
        }

        path = path_gametask_mess_gold3_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold3_title = c.getString(path);
        }

        path = path_gametask_mess_gold3_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold3_subtitle = c.getString(path);
        }

        path = path_gametask_mess_gold3_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold3_actionbar = c.getString(path);
        }

        path = path_gametask_mess_gold4_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold4_chat = c.getString(path);
        }

        path = path_gametask_mess_gold4_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold4_title = c.getString(path);
        }

        path = path_gametask_mess_gold4_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold4_subtitle = c.getString(path);
        }

        path = path_gametask_mess_gold4_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_gold4_actionbar = c.getString(path);
        }
    }

    private void applyTaskDiamondConfig(FileConfiguration c) {
        String path;

        path = path_gametask_spawntime_tasks_diamond1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_diamond1 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_diamond2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_diamond2 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_diamond3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_diamond3 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_diamond4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_diamond4 = c.getInt(path);
        }

        path = path_gametask_name_diamond1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_diamond1 = c.getString(path);
        }

        path = path_gametask_name_diamond2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_diamond2 = c.getString(path);
        }

        path = path_gametask_name_diamond3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_diamond3 = c.getString(path);
        }

        path = path_gametask_name_diamond4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_diamond4 = c.getString(path);
        }

        path = path_gametask_mess_diamond1_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond1_chat = c.getString(path);
        }

        path = path_gametask_mess_diamond1_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond1_title = c.getString(path);
        }

        path = path_gametask_mess_diamond1_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond1_subtitle = c.getString(path);
        }

        path = path_gametask_mess_diamond1_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond1_actionbar = c.getString(path);
        }
        path = path_gametask_mess_diamond2_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond2_chat = c.getString(path);
        }

        path = path_gametask_mess_diamond2_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond2_title = c.getString(path);
        }

        path = path_gametask_mess_diamond2_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond2_subtitle = c.getString(path);
        }

        path = path_gametask_mess_diamond2_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond2_actionbar = c.getString(path);
        }

        path = path_gametask_mess_diamond3_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond3_chat = c.getString(path);
        }

        path = path_gametask_mess_diamond3_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond3_title = c.getString(path);
        }

        path = path_gametask_mess_diamond3_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond3_subtitle = c.getString(path);
        }

        path = path_gametask_mess_diamond3_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond3_actionbar = c.getString(path);
        }

        path = path_gametask_mess_diamond4_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond4_chat = c.getString(path);
        }

        path = path_gametask_mess_diamond4_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond4_title = c.getString(path);
        }

        path = path_gametask_mess_diamond4_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond4_subtitle = c.getString(path);
        }

        path = path_gametask_mess_diamond4_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_diamond4_actionbar = c.getString(path);
        }
    }

    private void applyTaskEmeraldConfig(FileConfiguration c) {
        String path;

        path = path_gametask_spawntime_tasks_emerald1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_emerald1 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_emerald2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_emerald2 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_emerald3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_emerald3 = c.getInt(path);
        }

        path = path_gametask_spawntime_tasks_emerald4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_tasks_emerald4 = c.getInt(path);
        }

        path = path_gametask_name_emerald1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_emerald1 = c.getString(path);
        }

        path = path_gametask_name_emerald2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_emerald2 = c.getString(path);
        }

        path = path_gametask_name_emerald3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_emerald3 = c.getString(path);
        }

        path = path_gametask_name_emerald4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_name_emerald4 = c.getString(path);
        }

        path = path_gametask_mess_emerald1_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald1_chat = c.getString(path);
        }

        path = path_gametask_mess_emerald1_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald1_title = c.getString(path);
        }

        path = path_gametask_mess_emerald1_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald1_subtitle = c.getString(path);
        }

        path = path_gametask_mess_emerald1_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald1_actionbar = c.getString(path);
        }
        path = path_gametask_mess_emerald2_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald2_chat = c.getString(path);
        }

        path = path_gametask_mess_emerald2_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald2_title = c.getString(path);
        }

        path = path_gametask_mess_emerald2_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald2_subtitle = c.getString(path);
        }

        path = path_gametask_mess_emerald2_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald2_actionbar = c.getString(path);
        }

        path = path_gametask_mess_emerald3_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald3_chat = c.getString(path);
        }

        path = path_gametask_mess_emerald3_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald3_title = c.getString(path);
        }

        path = path_gametask_mess_emerald3_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald3_subtitle = c.getString(path);
        }

        path = path_gametask_mess_emerald3_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald3_actionbar = c.getString(path);
        }

        path = path_gametask_mess_emerald4_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald4_chat = c.getString(path);
        }

        path = path_gametask_mess_emerald4_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald4_title = c.getString(path);
        }

        path = path_gametask_mess_emerald4_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald4_subtitle = c.getString(path);
        }

        path = path_gametask_mess_emerald4_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_mess_emerald4_actionbar = c.getString(path);
        }
    }

    private void applySpawnTimerConfig(FileConfiguration c) {
        String path;
        path = path_gametask_spawntime;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime = c.getBoolean(path);
        }

        if (gametask_spawntime) {
            applySpawnTimeIronConfig(c);
            applySpawnTimeGoldConfig(c);
            applySpawnTimeDiamondConfig(c);
            applySpawnTimeEmeraldConfig(c);
        }
    }

    private void applySpawnTimeEmeraldConfig(FileConfiguration c) {
        String path;
        path = path_gametask_spawntime_emerald_base;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_emerald_base = c.getInt(path);
        }

        path = path_gametask_spawntime_emerald_1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_emerald_1 = c.getInt(path);
        }

        path = path_gametask_spawntime_emerald_2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_emerald_2 = c.getInt(path);
        }

        path = path_gametask_spawntime_emerald_3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_emerald_3 = c.getInt(path);
        }

        path = path_gametask_spawntime_emerald_4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_emerald_4 = c.getInt(path);
        }
    }

    private void applySpawnTimeDiamondConfig(FileConfiguration c) {
        String path;
        path = path_gametask_spawntime_diamond_base;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_diamond_base = c.getInt(path);
        }

        path = path_gametask_spawntime_diamond_1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_diamond_1 = c.getInt(path);
        }

        path = path_gametask_spawntime_diamond_2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_diamond_2 = c.getInt(path);
        }

        path = path_gametask_spawntime_diamond_3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_diamond_3 = c.getInt(path);
        }

        path = path_gametask_spawntime_diamond_4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_diamond_4 = c.getInt(path);
        }
    }

    private void applySpawnTimeGoldConfig(FileConfiguration c) {
        String path;
        path = path_gametask_spawntime_gold_base;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_gold_base = c.getInt(path);
        }

        path = path_gametask_spawntime_gold_1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_gold_1 = c.getInt(path);
        }

        path = path_gametask_spawntime_gold_2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_gold_2 = c.getInt(path);
        }

        path = path_gametask_spawntime_gold_3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_gold_3 = c.getInt(path);
        }

        path = path_gametask_spawntime_gold_4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_gold_4 = c.getInt(path);
        }
    }

    private void applySpawnTimeIronConfig(FileConfiguration c) {
        String path;
        path = path_gametask_spawntime_iron_base;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_iron_base = c.getInt(path);
        }

        path = path_gametask_spawntime_iron_1;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_iron_1 = c.getInt(path);
        }

        path = path_gametask_spawntime_iron_2;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_iron_2 = c.getInt(path);
        }

        path = path_gametask_spawntime_iron_3;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_iron_3 = c.getInt(path);
        }

        path = path_gametask_spawntime_iron_4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gametask_spawntime_iron_4 = c.getInt(path);
        }
    }
}