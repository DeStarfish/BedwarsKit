



















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelConfigLoad implements IConfigLoader {
    private final String className = getClass().getSimpleName();
    private final String reason = vauleIsNull;

    private void sendError(String path) {
        er(className, path, reason);
    }

    public void loadConfig() {
        FileConfiguration c = BedwarsRel.getInstance().getConfig();

        try {
            applyConfig(c);
        } catch (Exception e) {
            le(className, e);
        }

        if (isDebug()) {
            l("<" + className + "> " + finishLoadConfig);
        }

    }

    private void applyConfig(FileConfiguration c) {
        String path;
        boolean isChangeRelCfg = false;

        path = path_shoutPrefix;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            shoutPrefix = c.getStringList(path).get(0);
        }

        if (preventLoadWorld) {
            path = path_die_on_void;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                if (c.getBoolean(path) == true) {
                    c.set(path, false);
                    if (!Objects.equals(needIsWrong, "")) {

                        String willSend = needIsWrong
                                .replace("%target%", "preventLoadWorld")
                                .replace("%path%", path);
                        l(willSend);
                    }
                    isChangeRelCfg = true;
                }
            }
            path = path_allow_crafting;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                if (c.getBoolean(path) == true) {
                    c.set(path, false);
                    if (!Objects.equals(needIsWrong, "")) {

                        String willSend = needIsWrong
                                .replace("%target%", "preventLoadWorld")
                                .replace("%path%", path);
                        l(willSend);
                    }
                    isChangeRelCfg = true;
                }
            }

            path = path_spectation_enabled;
            if (c.get(path) != null) {
                if (c.getBoolean(path) == false) {
                    c.set(path, true);
                    if (!Objects.equals(needIsWrong, "")) {
                        String willSend = needIsWrong
                                .replace("%target%", "preventLoadWorld")
                                .replace("%path%", path);
                        l(willSend);
                    }
                    isChangeRelCfg = true;
                }
            }
        }

        if (killfb_oneHealthKill) {
            path = path_keep_inventory_on_death;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                if (c.getBoolean(path) == false) {
                    c.set(path, true);
                    if (!Objects.equals(needIsWrong, "")) {
                        String willSend = needIsWrong
                                .replace("%target%", "killfb_oneHealthKill")
                                .replace("%path%", path);
                        l(willSend);
                    }
                    isChangeRelCfg = true;
                }
            }
        }


        if (isChangeRelCfg) {
            if (!Objects.equals(relConfigIsChange_tryToSave, "")) {
                l(relConfigIsChange_tryToSave);
            }
            BedwarsRel.getInstance().saveConfig();
            if (!Objects.equals(relConfigIsChange_Saved, "")) {
                l(relConfigIsChange_Saved);
            }
        }
    }
}