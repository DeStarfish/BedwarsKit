







































/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class MainConfigLoad implements IConfigLoader {
    private final String className = getClass().getSimpleName();
    private final Random random = new SecureRandom();
    private final BedwarsKit plugin = BedwarsKit.getInstance();
    private final String fileName = "config.yml";
    private boolean updateCheckAlready;
    private RelConfigLoad relConfigLoad;
    private LangConfigLoad langConfigLoad;
    private KitConfigLoad kitConfigLoad;
    private ScbConfigLoad scbConfigLoad;
    private TaskConfigLoad taskConfigLoad;
    private ResConfigLoad resConfigLoad;
    private LevelConfigLoad levelConfigLoad;

    public MainConfigLoad(BedwarsKit ignored) {
    }

    private void sendError(String path) {
        er(fileName, path, vauleIsNull);
    }

    private void oncheckUpdate() {
        if (updateCheckAlready) {
            return;
        }
        long l = random.nextInt(30) + 10;
        new BukkitRunnable() {
            @Override
            public void run() {
                checkUpdate(getSpigotId());
                updateCheckAlready = true;
            }
        }.runTaskLater(plugin, l);
    }

    public void loadConfig(CommandSender sender, boolean firstload) {

        clearErrors();
        if (isDebug()) {
            l("Cleared all config load error.");
        }

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

        String path;
        path = path_messreloadnow;

        if (c.get(path) == null) {
            messreloadnow = t("&b" + pluginName + " &7>> &eReloading configuration file");
            sendError(path);
        } else {
            messreloadnow = c.getString(path);
        }

        path = path_messreloadsucc;

        if (c.get(path) == null) {
            messreloadsucc = t("&b" + pluginName + " &7>> &aSuccessfully reloaded configuration file");
            sendError(path);
        } else {
            messreloadsucc = c.getString(path);
        }

        if (firstload) {

            if (langConfigLoad == null) {
                langConfigLoad = new LangConfigLoad();
            }
            langConfigLoad.loadConfig();
        } else {
            if (sender != null) {
                sender.sendMessage(t(messreloadnow));
            }
        }

        if (firstload) {
            if (c.get(path_update_checker) == null) {
                sendError(path_update_checker);
                oncheckUpdate();
            } else {
                boolean update_checker = c.getBoolean(path_update_checker);
                if (update_checker) {
                    oncheckUpdate();
                }
            }
        }


        try {
            applyConfig(c);
        } catch (Exception e) {
            le(className, e);
        }

        if (isDebug()) {
            le(className, "[State] " + finishLoadConfig);
        }

        if (relConfigLoad == null) {
            relConfigLoad = new RelConfigLoad();
        }

        relConfigLoad.loadConfig();

        if (kitConfigLoad == null) {
            kitConfigLoad = new KitConfigLoad();
        }
        kitConfigLoad.loadConfig();

        if (taskConfigLoad == null) {
            taskConfigLoad = new TaskConfigLoad();
        }
        taskConfigLoad.loadConfig();

        if (resConfigLoad == null) {
            resConfigLoad = new ResConfigLoad();
        }
        resConfigLoad.loadConfig();

        if (scbConfigLoad == null) {
            scbConfigLoad = new ScbConfigLoad();
        }
        scbConfigLoad.loadConfig();

        if (levelConfigLoad == null) {
            levelConfigLoad = new LevelConfigLoad();
        }
        levelConfigLoad.loadConfig();


        if (!getLoadErrors().isEmpty()) {
            String s1 = "&eAn error occurred during loading config, Enter '/bwk ed' to view all specific paths.";
            String s2 = "&eIgnoring and continuing may result in errors.";
            l(s1);
            l(s2);
            if (sender instanceof Player) {
                sendMessage(sender, s1);
                sendMessage(sender, s2);
            }

            if (firstload) {
                long l = random.nextInt(30) + 10;
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        l("&c&l[ERROR] =================== [ERROR]");
                        l("&cAn error occurred during loading config.");
                        l("&cIgnoring and continuing may result in errors.");
                        l("&cEnter '/bwk ed' to view all specific paths.");
                        l("&c&l[ERROR] =================== [ERROR]");
                    }
                }.runTaskLater(plugin, l);
            }
        }

        if (!firstload) {
            if (sender != null) {
                sender.sendMessage(t(messreloadsucc));
            }
        }


    }

    public void loadConfig() {
    }

    private void applyConfig(FileConfiguration c) {

        String path;

        path = path_update_reportOp;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            update_reportOp = c.getBoolean(path);
        }

        path = path_teleportAlwayKeepDirection;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            teleportAlwayKeepDirection = c.getBoolean(path);
        }


        path = path_worldMode_autoJudge;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            worldMode_autoJudge = c.getBoolean(path);
        }

        path = path_noPearlDamage;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noPearlDamage = c.getBoolean(path);
        }

        path = path_killfb_oneHealthKill;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            killfb_oneHealthKill = c.getBoolean(path);
        }

        path = path_killfb_oneHealthKill_itemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            killfb_oneHealthKill_itemType = Material.getMaterial(c.getString(path));
        }

        path = path_killfb_oneHealthKill_itemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            killfb_oneHealthKill_itemName = c.getString(path);
        }

        applyNoPearlDamageConfig(c);
        applyRejoinConfig(c);

        path = path_joinServer_mess;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            joinServer_mess = c.getString(path);
        }

        path = path_leaveServer_mess;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            leaveServer_mess = c.getString(path);
        }

        path = path_startKitCompass;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            startKitCompass = c.getBoolean(path);
        }

        applyAntiDropConfig(c);

        applyNoItemBreakConfig(c);

        path = path_cleanBottle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            cleanBottle = c.getBoolean(path);
        }

        applyDeathGameModeConfig(c);

        applyNoHungerConfig(c);

        applyGiveBackPriceConfig(c);

        applyUpgradeArmorConfig(c);

        applyMeanConfig(c);

        applyBasicConfig(c);

        applyBreakTitleConfig(c);

        applyDamageFeedBackConfig(c);

        applyStartMessConfig(c);

        applyGameOverConfig(c);

        applyMapProtectConfig(c);

        path = path_cleanBed;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            cleanBed = c.getBoolean(path);
        }

        applyPreventLoadWorldConfig(c);

        path = path_cleanHostileOnStart;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            cleanHostileOnStart = c.getBoolean(path);
        }


        path = path_noInteractWhileEndGame;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noInteractWhileEndGame = c.getBoolean(path);
        }

        applyKillFeedBackConfig(c);

        applyTabConfig(c);

        applyDieOutGameConfig(c);

        applyLobbyJoinTeamConfig(c);

        applyHoldCompassConfig(c);

        applyRelFixConfig(c);

        path = path_noEndermanGriefing;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noEndermanGriefing = c.getBoolean(path);
        }

        path = path_noWoodSwordDropWhenNothaveSword;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noWoodSwordDropWhenNothaveSword = c.getBoolean(path);
        }

        path = path_noWoodAxeDropWhenNothaveAxe;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noWoodAxeDropWhenNothaveAxe = c.getBoolean(path);
        }

        path = path_noWoodPickaxeDropWhenNothavePickaxe;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noWoodPickaxeDropWhenNothavePickaxe = c.getBoolean(path);
        }

        applyResourceSplitConfig(c);

        applyarmorColor(c);

        applyNoOpenInvConfig(c);
    }

    private void applyResourceSplitConfig(FileConfiguration c) {
        String path;
        path = path_resourceSplit;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resourceSplit = c.getBoolean(path);
        }

        path = path_resourceSplitDis;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            resourceSplitDis = c.getDouble(path);
        }

    }

    private void applyNoItemBreakConfig(FileConfiguration c) {
        String path;
        path = path_noItemBreak;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noItemBreak = c.getBoolean(path);
        }

        path = path_nobreakList;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (nobreakList == null) {
                nobreakList = new ArrayList<>(48);
            } else {
                nobreakList.clear();
            }
            nobreakList.addAll(c.getStringList(path));
        }

    }

    private void applyRelFixConfig(FileConfiguration c) {
        String path;
        path = path_relFix_creativeCantToggleFly;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relFix_creativeCantToggleFly = c.getBoolean(path);
        }

        path = path_relFix_cantPickupItems;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relFix_cantPickupItems = c.getBoolean(path);
        }
    }

    private void applyHoldCompassConfig(FileConfiguration c) {
        String path;

        path = path_compassDisplayName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            compassDisplayName = c.getString(path);
        }

        path = path_holdCompassDisplayName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            holdCompassDisplayName = c.getString(path);
        }

        path = path_leaveHoldCompass_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            leaveHoldCompass_mess_actionbar = c.getString(path);
        }

        path = path_holdCompass_mess_enable;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            holdCompassMess = c.getBoolean(path);
        }

        path = path_holdCompass_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            holdCompass_mess_actionBar = c.getString(path);
        }

        path = path_holdCompassNotFound_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            holdCompassNotFound_mess_actionBar = c.getString(path);
        }
    }

    private void applyMeanConfig(FileConfiguration c) {
        String path;
        path = path_meanIron;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanIron = c.getString(path);
        }

        path = path_meanGold;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanGold = c.getString(path);
        }

        path = path_meanDiamond;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanDiamond = c.getString(path);
        }

        path = path_meanEmerlad;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanEmerlad = c.getString(path);
        }

        path = path_meanSecond;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            meanSecond = c.getString(path);
        }
    }

    private void applyLobbyJoinTeamConfig(FileConfiguration c) {
        String path;

        path = path_lobbyLeaveTeam;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            lobbyLeaveTeam = c.getBoolean(path);
        }

        path = path_lobbyJoinTeam_changeItemColor;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            lobbyJoinTeam_changeItemColor = c.getBoolean(path);
        }

        path = path_lobbyJoinTeam_mess_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            lobbyJoinTeam_mess_chat = c.getString(path);
        }

        path = path_lobbyJoinTeam_mess_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            lobbyJoinTeam_mess_title = c.getString(path);
        }

        path = path_lobbyJoinTeam_mess_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            lobbyJoinTeam_mess_subtitle = c.getString(path);
        }

        path = path_lobbyJoinTeam_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            lobbyJoinTeam_mess_actionbar = c.getString(path);
        }
    }

    private void applyDieOutGameConfig(FileConfiguration c) {
        String path;
        path = path_dieOutGameItem_playAgain;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            dieOutGameItem_playAgain = c.getBoolean(path);
        }

        if (dieOutGameItem_playAgain) {
            applyDieOutGameItemConfig(c);

            path = path_dieOutGameItem_playAgain_clickSendCommand;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                dieOutGameItem_playAgain_clickSendCommand = c.getString(path);
            }
        }

    }

    private void applyDieOutGameItemConfig(FileConfiguration c) {
        String path;
        path = path_dieOutGameItem_playAgain_itemSlot;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            dieOutGameItem_playAgain_itemSlot = c.getInt(path);
        }

        path = path_dieOutGameItem_playAgain_itemName;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            dieOutGameItem_playAgain_itemName = c.getString(path);
        }

        path = path_dieOutGameItem_playAgain_itemType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            dieOutGameItem_playAgain_itemType = Material.getMaterial(c.getString(path));
        }
    }

    private void applyNoPearlDamageConfig(FileConfiguration c) {
        String path;
        path = path_noPearlDamage_tpSound;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noPearlDamage_tpSound = c.getBoolean(path);
        }
    }

    private void applyRejoinConfig(FileConfiguration c) {
        String path;

        path = path_rejoin;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            rejoin = c.getBoolean(path);
        }

        if (rejoin) {
            path = path_rejoin_mess;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                rejoin_mess = c.getString(path);
            }
        } else {
            RelRejoinHandler rejoinHandler = BedwarsKit.getInstance().getRejoinHandler();
            if (!rejoinHandler.listIsEmpty()) {
                rejoinHandler.clearAllPlayer();
                l("[Rejoin] rejoin is disabled, all rejoin data cleared");
            }
        }
    }


    private void applyTabConfig(FileConfiguration c) {
        String path;
        path = path_tab;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            tab = c.getBoolean(path);
        }

        path = path_tab_is_multiLine;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            tab_is_multiLine = c.getBoolean(path);
        }

        if (tab_is_multiLine) {
            path = path_tab_headList;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                if (tab_headList == null) {
                    tab_headList = new ArrayList<>();
                } else {
                    tab_headList.clear();
                }
                tab_headList.addAll(c.getStringList(path));
            }
            path = path_tab_footList;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                if (tab_footList == null) {
                    tab_footList = new ArrayList<>();
                } else {
                    tab_footList.clear();
                }
                tab_footList.addAll(c.getStringList(path));
            }
        } else {
            path = path_tab_head;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                tab_head = c.getString(path);
            }

            path = path_tab_foot;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                tab_foot = c.getString(path);
            }
        }
    }

    private void applyNoOpenInvConfig(FileConfiguration c) {
        String path;
        path = path_noOpenInventory;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noOpenInventory = c.getBoolean(path);
        }

        if (noOpenInventory) {

            path = path_noOpenInventoryTypeList;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                if (!c.getStringList(path).isEmpty()) {
                    List<String> loadList = c.getStringList(path);

                    noOpenInventoryTypeList = Collections.newSetFromMap(new ConcurrentHashMap<>());

                    boolean loadListCatchError = false;
                    for (String s : loadList) {
                        String listNew = s.toUpperCase();
                        try {
                            InventoryType type = InventoryType.valueOf(listNew);
                            noOpenInventoryTypeList.add(type);
                        } catch (IllegalArgumentException e) {
                            loadListCatchError = true;
                        }
                    }

                    if (loadListCatchError) {
                        sendError(path);
                    }
                }
            }
        }
    }

    private void applyKillFeedBackConfig(FileConfiguration c) {
        String path;
        path = path_killfb_sendmess_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            killfb_mess_chat = c.getString(path);
        }

        path = path_killfb_sendmess_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            killfb_mess_title = c.getString(path);
        }

        path = path_killfb_sendmess_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            killfb_mess_subtitle = c.getString(path);
        }

        path = path_killfb_sendmess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            killfb_mess_actionbar = c.getString(path);
        }

        path = path_killSeizeResource;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            killSeizeResource = c.getBoolean(path);
        }

        if (killSeizeResource) {
            path = path_killSeizeResource_mess_chat;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                killSeizeResource_mess_chat = c.getString(path);
            }
        }
    }

    private void applyPreventLoadWorldConfig(FileConfiguration c) {
        String path;
        path = path_preventLoadWorld;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            preventLoadWorld = c.getBoolean(path);
        }

        path = path_preventLoadWorldMode;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            preventLoadWorldMode = c.getString(path);
        }

        path = path_preventloadworldMode_before_animfix;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            preventLoadWorldMode_before_animFix = c.getBoolean(path);
        }
    }

    private void applyMapProtectConfig(FileConfiguration c) {
        String path;

        path = path_breakCorrect_notInGame;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakCorrect_notInGame = c.getBoolean(path);
        }

        if (breakCorrect_notInGame) {
            path = path_breakCorrect_notInGame_OpBypass;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                breakCorrect_notInGame_OpBypass = c.getBoolean(path);
            }
        }

        path = path_placeCorrect_notInGame;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_notInGame = c.getBoolean(path);
        }

        if (placeCorrect_notInGame) {
            path = path_placeCorrect_notInGame_OpBypass;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                placeCorrect_notInGame_OpBypass = c.getBoolean(path);
            }
        }

        path = path_placeCorrect_ResSpawner;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_resourceSpawner = c.getBoolean(path);
        }

        if (placeCorrect_resourceSpawner) {
            applyMapProtectResLoc(c);
        }

        path = path_placeCorrect_PlayerSpawnLoc;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_playerSpawnLoc = c.getBoolean(path);
        }

        if (placeCorrect_playerSpawnLoc) {
            applyMapProtectPlayerSpawnConfig(c);
        }
    }

    private void applyMapProtectResLoc(FileConfiguration c) {
        String path;

        placeCorrect_ResSpawner_dis = c.getInt(path_placeCorrect_resSpawner_dis);

        path = path_placeCorrect_PlayerSpawnLoc_mess_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_playerSpawnLoc_mess_chat = c.getString(path);
        }

        path = path_placeCorrect_PlayerSpawnLoc_mess_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_playerSpawnLoc_mess_title = c.getString(path);
        }

        path = path_placeCorrect_PlayerSpawnLoc_mess_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_playerSpawnLoc_mess_subtitle = c.getString(path);
        }

        path = path_placeCorrect_PlayerSpawnLoc_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_playerSpawnLoc_mess_actionbar = c.getString(path);
        }
    }

    private void applyMapProtectPlayerSpawnConfig(FileConfiguration c) {
        String path;


        LevelConfigHandler.placeCorrect_PlayerSpawnLoc_dis = c.getInt(path_placeCorrect_playerSpawnLoc_dis);

        path = path_placeCorrect_ResSpawner_mess_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_resourceSpawner_mess_chat = c.getString(path);
        }

        path = path_placeCorrect_ResSpawner_mess_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_resourceSpawner_mess_title = c.getString(path);
        }

        path = path_placeCorrect_ResSpawner_mess_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_resourceSpawner_mess_subtitle = c.getString(path);
        }

        path = path_placeCorrect_ResSpawner_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            placeCorrect_resourceSpawner_mess_actionbar = c.getString(path);
        }
    }

    private void applyGameOverConfig(FileConfiguration c) {
        String path;
        path = path_gameOver_mess_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gameOver_mess_chat = c.getString(path);
        }

        path = path_gameOver_mess_topKills_format;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            gameOver_mess_topKills_format = c.getString(path);
        }


        path = path_dieOut_mess_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            dieOut_mess_chat = c.getString(path);
        }

        path = path_dieOut_mess_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            dieOut_mess_title = c.getString(path);
        }

        path = path_dieOut_mess_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            dieOut_mess_subtitle = c.getString(path);
        }

        path = path_dieOut_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            dieOut_mess_actionbar = c.getString(path);
        }
    }

    private void applyStartMessConfig(FileConfiguration c) {
        String path;
        path = path_startmess_all_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            startmess_all_chat = c.getString(path);
        }

        path = path_startmess_all_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            startmess_all_title = c.getString(path);
        }

        path = path_startmess_all_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            startmess_all_subtitle = c.getString(path);
        }

        path = path_startmess_all_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            startmess_all_actionbar = c.getString(path);
        }
    }

    private void applyDamageFeedBackConfig(FileConfiguration c) {
        String path;
        path = path_damagefb_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            damagefb_mess_actionbar = c.getString(path);
        }

        path = path_damagefb_mess_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            damagefb_mess_chat = c.getString(path);
        }

        path = path_damagefb_mess_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            damagefb_mess_title = c.getString(path);
        }

        path = path_damagefb_mess_subTitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            damagefb_mess_subTitle = c.getString(path);
        }

        path = path_damagefb_blood;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            damagefb_blood = c.getBoolean(path);
        }

        path = path_damagefb_bloodMode;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            damagefb_bloodMode = c.getString(path);
        }

        path = path_damagefb_mess_actionbar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            damagefb_mess_actionbar = c.getString(path);
        }
        damagefb_mess_actionbar = c.getString(path_damagefb_mess_actionbar);


        path = path_damagefb_bloodType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            damagefb_bloodType = Material.getMaterial(c.getString(path));
        }
    }

    private void applyDeathGameModeConfig(FileConfiguration c) {
        String path;

        path = path_deathGameMode;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            deathGameMode = c.getBoolean(path);
        }

        path = path_deathGameMode_tpto;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            deathGameMode_tpto = c.getString(path);
        }

        path = path_respawnDelay;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnDelay = c.getInt(path);
        }

        path = path_deathGameMode_instantRepsawn;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            deathGameMode_instantRepsawn = c.getBoolean(path);
        }

        path = path_respawn_mess_title;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnTitle = c.getString(path);
        }

        path = path_respawn_mess_subtitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnSubTitle = c.getString(path);
        }

        path = path_respawn_mess_chat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnChat = c.getString(path);
        }

        path = path_respawn_mess_actionBar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnActionBar = c.getString(path);
        }

        path = path_respawnSuccTitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnSuccTitle = c.getString(path);
        }

        path = path_respawnSuccSubTitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnSuccSubTitle = c.getString(path);
        }

        path = path_respawnSuccChat;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnSuccChat = c.getString(path);
        }

        path = path_respawnSuccActionBar;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            respawnSuccActionBar = c.getString(path);
        }
    }

    private void applyBreakTitleConfig(FileConfiguration c) {
        String path;

        path = path_breakTitle;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakTitle = c.getBoolean(path);
        }

        if (breakTitle) {
            applyBreakTitleMessConfig(c);
        }

    }

    private void applyBreakTitleMessConfig(FileConfiguration c) {
        String path;
        path = path_breakTitleAll;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakTitleAll = c.getString(path);
        }

        path = path_breakSubTitleAll;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakSubTitleAll = c.getString(path);
        }

        path = path_breakTitleBreakPlayer;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakTitleBreakPlayer = c.getString(path);
        }

        path = path_breakSubTitleBreakPlayer;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakSubTitleBreakPlayer = c.getString(path);
        }

        path = path_breakTitleBreakTeam;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakTitleBreakTeam = c.getString(path);
        }

        path = path_breakSubTitleBreakTeam;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakSubTitleBreakTeam = c.getString(path);
        }

        path = path_breakSubTitleBreakTeam;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            breakSubTitleBreakTeam = c.getString(path);
        }
    }

    private void applyUpgradeArmorConfig(FileConfiguration c) {
        String path;
        path = path_upToChainArmor;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            upToChainArmor = Material.getMaterial(c.getString(path));
        }

        path = path_upToIronArmor;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            upToIronArmor = Material.getMaterial(c.getString(path));
        }

        path = path_upToDiamondArmor;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            upToDiamondArmor = Material.getMaterial(c.getString(path));
        }
    }

    private void applyAntiDropConfig(FileConfiguration c) {
        String path;

        path = path_antiItemDrop;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            antiDrop = c.getBoolean(path);
        }

        if (antiDrop) {

            path = path_antiDropList;
            if (c.get(path) == null) {
                sendError(path);
            } else {
                if (antiDropList == null) {
                    antiDropList = new ArrayList<>(4);
                } else {
                    antiDropList.clear();
                }
                antiDropList.addAll(c.getStringList(path));
            }
        }

    }

    private void applyGiveBackPriceConfig(FileConfiguration c) {
        String path;

        path = path_chainPrice;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            chainPrice = c.getInt(path);
        }

        path = path_ironPrice;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            ironPrice = c.getInt(path);
        }

        path = path_diamondPrice;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            diamondPrice = c.getInt(path);
        }

        path = path_chainPriceType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            chainPriceType = Material.getMaterial(c.getString(path));
        }

        path = path_ironPriceType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            ironPriceType = Material.getMaterial(c.getString(path));
        }

        path = path_diamondPriceType;
        if (c.get(path) == null || Material.getMaterial(c.getString(path)) == null) {
            sendError(path);
        } else {
            diamondPriceType = Material.getMaterial(c.getString(path));
        }
    }

    private void applyNoHungerConfig(FileConfiguration c) {
        String path;
        path = path_noHunger;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            noHunger = c.getBoolean(path);
        }

        path = path_maxFoodLevel;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            maxFoodLevel = c.getInt(path);
        }
    }

    private void applyBasicConfig(FileConfiguration c) {
        String path;

        path = path_bungeeMode;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            bungeeMode = c.getString(path);
        }

        path = path_JudgeTeamByColor;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            JudgeTeamByColor = c.getBoolean(path);
        }

        path = path_rushWorld4v4;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            if (gameWorld4v4 == null) {
                gameWorld4v4 = new HashSet<>();
            } else {
                gameWorld4v4.clear();
            }
            gameWorld4v4.addAll(c.getStringList(path));
        }

        path = path_lobbyWorld;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            lobbyWorld = c.getString(path);
        }

        applyRelTeamColorConfig(c);
    }

    private void applyRelTeamColorConfig(FileConfiguration c) {
        String path;

        path = path_relTeamName_Red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_Red = c.getString(path);
        }

        path = path_relTeamName_Blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_Blue = c.getString(path);
        }

        path = path_relTeamName_Green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_Green = c.getString(path);
        }

        path = path_relTeamName_Yellow;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_Yellow = c.getString(path);
        }

        path = path_relTeamName_Aqua;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_Aqua = c.getString(path);
        }

        path = path_relTeamName_White;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_White = c.getString(path);
        }

        path = path_relTeamName_Gray;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_Gray = c.getString(path);
        }

        path = path_relTeamName_Pink;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_Pink = c.getString(path);
        }

        path = path_relTeamName_Orange;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            relTeamName_Orange = c.getString(path);
        }
    }

    private void applyarmorColor(FileConfiguration c) {
        String path;

        // RED
        path = path_armorColor_RED_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_RED_red = c.getInt(path);
        }

        path = path_armorColor_RED_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_RED_green = c.getInt(path);
        }

        path = path_armorColor_RED_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_RED_blue = c.getInt(path);
        }

        // BLUE
        path = path_armorColor_BLUE_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_BLUE_red = c.getInt(path);
        }

        path = path_armorColor_BLUE_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_BLUE_green = c.getInt(path);
        }

        path = path_armorColor_BLUE_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_BLUE_blue = c.getInt(path);
        }

        // GREEN
        path = path_armorColor_GREEN_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_GREEN_red = c.getInt(path);
        }

        path = path_armorColor_GREEN_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_GREEN_green = c.getInt(path);
        }

        path = path_armorColor_GREEN_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_GREEN_blue = c.getInt(path);
        }
        // YELLOW
        path = path_armorColor_YELLOW_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_YELLOW_red = c.getInt(path);
        }

        path = path_armorColor_YELLOW_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_YELLOW_green = c.getInt(path);
        }

        path = path_armorColor_YELLOW_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_YELLOW_blue = c.getInt(path);
        }

        // PINK
        path = path_armorColor_PINK_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_PINK_red = c.getInt(path);
        }

        path = path_armorColor_PINK_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_PINK_green = c.getInt(path);
        }

        path = path_armorColor_PINK_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_PINK_blue = c.getInt(path);
        }
        // AQUA
        path = path_armorColor_AQUA_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_AQUA_red = c.getInt(path);
        }

        path = path_armorColor_AQUA_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_AQUA_green = c.getInt(path);
        }

        path = path_armorColor_AQUA_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_AQUA_blue = c.getInt(path);
        }

        // WHITE
        path = path_armorColor_WHITE_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_WHITE_red = c.getInt(path);
        }

        path = path_armorColor_WHITE_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_WHITE_green = c.getInt(path);
        }

        path = path_armorColor_WHITE_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_WHITE_blue = c.getInt(path);
        }

        // GRAY
        path = path_armorColor_GRAY_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_GRAY_red = c.getInt(path);
        }

        path = path_armorColor_GRAY_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_GRAY_green = c.getInt(path);
        }

        path = path_armorColor_GRAY_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_GRAY_blue = c.getInt(path);
        }

        // ORANGE
        path = path_armorColor_ORANGE_red;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_ORANGE_red = c.getInt(path);
        }

        path = path_armorColor_ORANGE_green;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_ORANGE_green = c.getInt(path);
        }

        path = path_armorColor_ORANGE_blue;
        if (c.get(path) == null) {
            sendError(path);
        } else {
            armorColor_ORANGE_blue = c.getInt(path);
        }

        applyArmorColor();
    }
}