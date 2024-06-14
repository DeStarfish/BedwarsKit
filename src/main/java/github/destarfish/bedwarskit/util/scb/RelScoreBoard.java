






























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelScoreBoard {
    private final String className = getClass().getSimpleName();
    private final Material bed_block = GetMaterial.BED_BLOCK();

    public RelScoreBoard(BedwarsKit ignored) {
    }

    public void updateScoreBoard(Game game) {

        if (game.getState() == GameState.WAITING) {
            ScbHelper.setGameScoreBoard(game);
            return;
        }

        if (game.getState() != GameState.RUNNING) {
            return;
        }

        String gameName = game.getName();

        if (gameName == null) {
            le(className, "updateScoreBoard for " + game.getRegion().getWorld().getName() + " : game.getName is null");
            return;
        }

        BedwarsKit plugin = BedwarsKit.getInstance();
        Map<Integer, String> taskMap = getTaskMap(gameName);

        Region region = game.getRegion();
        String regionName = game.getRegionName();

        World world = region.getWorld();
        String worldname = world.getName();

        int gameTimeleft = game.getTimeLeft();
        String timeleft_s = "" + gameTimeleft;

        String formatTimeLeft = formatTime(gameTimeleft);

        String lastTask;
        String lastTaskTimeLeft;

        if (taskMap.isEmpty()) {
            int minValue = 0;
            lastTaskTimeLeft = minValue + t(formatTime(gameTimeleft));
            String minTaskName = t(meanGameEnd);
            lastTask = t(minTaskName);
        } else {
            int minValue = Integer.MAX_VALUE;
            String minTaskName = null;

            for (Map.Entry<Integer, String> entry : taskMap.entrySet()) {
                Integer key = entry.getKey();
                String taskName = entry.getValue();
                if (game.getState() != GameState.RUNNING) {
                    return;
                }

                if (key < minValue) {
                    minValue = key;
                    minTaskName = taskName;
                }
            }

            if (minTaskName == null) {
                lastTask = "";
                lastTaskTimeLeft = "";
            } else {
                if (minTaskName.equals(meanGameEnd)) {
                    lastTaskTimeLeft = t(formatTimeLeft);
                } else {
                    lastTaskTimeLeft = minValue + t(meanSecond);
                }
                lastTask = t(minTaskName);
            }

        }
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String date = currentDate.format(formatter);

        String worldMode = Utils.isInMode(game);
        boolean isIn4v4 = worldMode.equals("4v4");

        String redName;
        String yellowName;
        String greenName;
        String blueName;

        String pinkName;
        String aquaName;
        String grayName;
        String whiteName;

        String orangeName;

        Team red;
        Team blue;
        Team green;
        Team yellow;

        Team pink;
        Team aqua;
        Team gray;
        Team white;

        Team orange;

        if (JudgeTeamByColor) {
            red = game.getTeamByDyeColor(TeamColor.RED.getDyeColor());
            blue = game.getTeamByDyeColor(TeamColor.BLUE.getDyeColor());
            green = game.getTeamByDyeColor(TeamColor.GREEN.getDyeColor());
            yellow = game.getTeamByDyeColor(TeamColor.YELLOW.getDyeColor());


            pink = game.getTeamByDyeColor(TeamColor.LIGHT_PURPLE.getDyeColor());
            aqua = game.getTeamByDyeColor(TeamColor.AQUA.getDyeColor());
            white = game.getTeamByDyeColor(TeamColor.WHITE.getDyeColor());
            gray = game.getTeamByDyeColor(TeamColor.GRAY.getDyeColor());

            orange = game.getTeamByDyeColor(TeamColor.GOLD.getDyeColor());

            if (red == null) {
                redName = "";
            } else {
                redName = red.getName();
            }

            if (blue == null) {
                blueName = "";
            } else {
                blueName = blue.getName();
            }

            if (green == null) {
                greenName = "";
            } else {
                greenName = green.getName();
            }

            if (yellow == null) {
                yellowName = "";
            } else {
                yellowName = yellow.getName();
            }

            if (pink == null) {
                pinkName = "";
            } else {
                pinkName = pink.getName();
            }

            if (aqua == null) {
                aquaName = "";
            } else {
                aquaName = aqua.getName();
            }

            if (white == null) {
                whiteName = "";
            } else {
                whiteName = white.getName();
            }

            if (gray == null) {
                grayName = "";
            } else {
                grayName = gray.getName();
            }

            if (orange == null) {
                orangeName = "";
            } else {
                orangeName = orange.getName();
            }

        } else {

            redName = relTeamName_Red;
            blueName = relTeamName_Blue;
            yellowName = relTeamName_Yellow;
            greenName = relTeamName_Green;

            pinkName = relTeamName_Pink;
            aquaName = relTeamName_Aqua;
            grayName = relTeamName_Gray;
            whiteName = relTeamName_White;

            orangeName = relTeamName_Orange;

            red = game.getTeam(redName);
            blue = game.getTeam(blueName);
            green = game.getTeam(greenName);
            yellow = game.getTeam(yellowName);

            pink = game.getTeam(pinkName);
            aqua = game.getTeam(aquaName);
            gray = game.getTeam(grayName);
            white = game.getTeam(whiteName);

            orange = game.getTeam(orangeName);
        }


        String redPlayer;
        String bluePlayer;
        String greenPlayer;
        String yellowPlayer;

        String pinkPlayer;
        String aquaPlayer;
        String whitePlayer;
        String grayPlayer;

        String orangePlayer;

        String redNameS;
        String blueNameS;
        String greenNameS;
        String yellowNameS;

        String pinkNameS;
        String aquaNameS;
        String whiteNameS;
        String grayNameS;

        String orangeNameS;

        if (red == null) {
            redNameS = "";
        } else {
            redNameS = String.valueOf(redName.charAt(0));
        }

        if (blue == null) {
            blueNameS = "";
        } else {
            blueNameS = String.valueOf(blueName.charAt(0));
        }

        if (green == null) {
            greenNameS = "";
        } else {
            greenNameS = String.valueOf(greenName.charAt(0));
        }

        if (yellow == null) {
            yellowNameS = "";
        } else {
            yellowNameS = String.valueOf(yellowName.charAt(0));
        }

        if (pink == null) {
            pinkNameS = "";
        } else {
            pinkNameS = String.valueOf(pinkName.charAt(0));
        }

        if (aqua == null) {
            aquaNameS = "";
        } else {
            aquaNameS = String.valueOf(aquaName.charAt(0));
        }

        if (white == null) {
            whiteNameS = "";
        } else {
            whiteNameS = String.valueOf(whiteName.charAt(0));
        }

        if (gray == null) {
            grayNameS = "";
        } else {
            grayNameS = String.valueOf(grayName.charAt(0));
        }

        if (orange == null) {
            orangeNameS = "";
        } else {
            orangeNameS = String.valueOf(orangeName.charAt(0));
        }

        String redStat;
        String blueStat;
        String greenStat;
        String yellowStat;

        String pinkStat;
        String aquaStat;
        String whiteStat;
        String grayStat;

        String orangeStat;

        String redIsAlive;

        if (red == null) {
            redIsAlive = "";
        } else {
            if (red.isDead(game)) {
                redIsAlive = meanTeamStat_Dead;
            } else {
                redIsAlive = meanTeamStat_Alive;
            }
        }

        String redBedStat;

        if (red == null) {
            redBedStat = "";
        } else {
            if (red.getTargetHeadBlock().getBlock().getType() == bed_block) {
                redBedStat = meanBedStat_Yes;
            } else {
                redBedStat = meanBedStat_No;
            }
        }

        String blueIsAlive;

        if (blue == null) {
            blueIsAlive = "";
        } else {
            if (blue.isDead(game)) {
                blueIsAlive = meanTeamStat_Dead;
            } else {
                blueIsAlive = meanTeamStat_Alive;
            }
        }

        String blueBedStat;

        if (blue == null) {
            blueBedStat = "";
        } else {
            if (blue.getTargetHeadBlock().getBlock().getType() == bed_block) {
                blueBedStat = meanBedStat_Yes;
            } else {
                blueBedStat = meanBedStat_No;
            }
        }

        String greenIsAlive;

        if (green == null) {
            greenIsAlive = "";
        } else {
            if (green.isDead(game)) {
                greenIsAlive = meanTeamStat_Dead;
            } else {
                greenIsAlive = meanTeamStat_Alive;
            }
        }

        String greenBedStat;

        if (green == null) {
            greenBedStat = "";
        } else {
            if (green.getTargetHeadBlock().getBlock().getType() == bed_block) {
                greenBedStat = meanBedStat_Yes;
            } else {
                greenBedStat = meanBedStat_No;
            }
        }

        String yellowIsAlive;

        if (yellow == null) {
            yellowIsAlive = "";
        } else {
            if (yellow.isDead(game)) {
                yellowIsAlive = meanTeamStat_Dead;
            } else {
                yellowIsAlive = meanTeamStat_Alive;
            }
        }

        String yellowBedStat;

        if (yellow == null) {
            yellowBedStat = "";
        } else {
            if (yellow.getTargetHeadBlock().getBlock().getType() == bed_block) {
                yellowBedStat = meanBedStat_Yes;
            } else {
                yellowBedStat = meanBedStat_No;
            }
        }

        String aquaIsAlive;

        if (aqua == null) {
            aquaIsAlive = "";
        } else {
            if (aqua.isDead(game)) {
                aquaIsAlive = meanTeamStat_Dead;
            } else {
                aquaIsAlive = meanTeamStat_Alive;
            }
        }

        String aquaBedStat;

        if (aqua == null) {
            aquaBedStat = "";
        } else {
            if (aqua.getTargetHeadBlock().getBlock().getType() == bed_block) {
                aquaBedStat = meanBedStat_Yes;
            } else {
                aquaBedStat = meanBedStat_No;
            }
        }

        String pinkIsAlive;

        if (pink == null) {
            pinkIsAlive = "";
        } else {
            if (pink.isDead(game)) {
                pinkIsAlive = meanTeamStat_Dead;
            } else {
                pinkIsAlive = meanTeamStat_Alive;
            }
        }

        String pinkBedStat;

        if (pink == null) {
            pinkBedStat = "";
        } else {
            if (pink.getTargetHeadBlock().getBlock().getType() == bed_block) {
                pinkBedStat = meanBedStat_Yes;
            } else {
                pinkBedStat = meanBedStat_No;
            }
        }

        String grayIsAlive;

        if (gray == null) {
            grayIsAlive = "";
        } else {
            if (gray.isDead(game)) {
                grayIsAlive = meanTeamStat_Dead;
            } else {
                grayIsAlive = meanTeamStat_Alive;
            }
        }

        String grayBedStat;

        if (gray == null) {
            grayBedStat = "";
        } else {
            if (gray.getTargetHeadBlock().getBlock().getType() == bed_block) {
                grayBedStat = meanBedStat_Yes;
            } else {
                grayBedStat = meanBedStat_No;
            }
        }
        String whiteIsAlive;

        if (white == null) {
            whiteIsAlive = "";
        } else {
            if (white.isDead(game)) {
                whiteIsAlive = meanTeamStat_Dead;
            } else {
                whiteIsAlive = meanTeamStat_Alive;
            }
        }

        String whiteBedStat;

        if (white == null) {
            whiteBedStat = "";
        } else {
            if (white.getTargetHeadBlock().getBlock().getType() == bed_block) {
                whiteBedStat = meanBedStat_Yes;
            } else {
                whiteBedStat = meanBedStat_No;
            }
        }

        String orangeIsAlive;

        if (orange == null) {
            orangeIsAlive = "";
        } else {
            if (orange.isDead(game)) {
                orangeIsAlive = meanTeamStat_Dead;
            } else {
                orangeIsAlive = meanTeamStat_Alive;
            }
        }

        String orangeBedStat;

        if (orange == null) {
            orangeBedStat = "";
        } else {
            if (orange.getTargetHeadBlock().getBlock().getType() == bed_block) {
                orangeBedStat = meanBedStat_Yes;
            } else {
                orangeBedStat = meanBedStat_No;
            }
        }

        if (red == null || red.getTargetHeadBlock() == null || red.getTargetHeadBlock().getBlock() == null) {
            redStat = "";
        } else {
            Material blockType = red.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                redStat = meanTeamStat_BedYes.replace("%aliveCount%", red.getPlayers().size() + "");
            } else if (!red.getPlayers().isEmpty()) {
                redStat = meanTeamStat_BedNo.replace("%aliveCount%", red.getPlayers().size() + "");
            } else {
                redStat = meanTeamStat_None.replace("%aliveCount%", red.getPlayers().size() + "");
            }
        }

        if (blue == null || blue.getTargetHeadBlock() == null || blue.getTargetHeadBlock().getBlock() == null) {
            blueStat = "";
        } else {
            Material blockType = blue.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                blueStat = meanTeamStat_BedYes.replace("%aliveCount%", blue.getPlayers().size() + "");
            } else if (!blue.getPlayers().isEmpty()) {
                blueStat = meanTeamStat_BedNo.replace("%aliveCount%", blue.getPlayers().size() + "");
            } else {
                blueStat = meanTeamStat_None.replace("%aliveCount%", blue.getPlayers().size() + "");
            }
        }

        if (green == null || green.getTargetHeadBlock() == null || green.getTargetHeadBlock().getBlock() == null) {
            greenStat = "";
        } else {
            Material blockType = green.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                greenStat = meanTeamStat_BedYes.replace("%aliveCount%", green.getPlayers().size() + "");
            } else if (!green.getPlayers().isEmpty()) {
                greenStat = meanTeamStat_BedNo.replace("%aliveCount%", green.getPlayers().size() + "");
            } else {
                greenStat = meanTeamStat_None.replace("%aliveCount%", green.getPlayers().size() + "");
            }
        }

        if (yellow == null || yellow.getTargetHeadBlock() == null || yellow.getTargetHeadBlock().getBlock() == null) {
            yellowStat = "";
        } else {
            Material blockType = yellow.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                yellowStat = meanTeamStat_BedYes.replace("%aliveCount%", yellow.getPlayers().size() + "");
            } else if (!yellow.getPlayers().isEmpty()) {
                yellowStat = meanTeamStat_BedNo.replace("%aliveCount%", yellow.getPlayers().size() + "");
            } else {
                yellowStat = meanTeamStat_None.replace("%aliveCount%", yellow.getPlayers().size() + "");
            }
        }

        if (pink == null || pink.getTargetHeadBlock() == null || pink.getTargetHeadBlock().getBlock() == null) {
            pinkStat = "";
        } else {
            Material blockType = pink.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                pinkStat = meanTeamStat_BedYes.replace("%aliveCount%", pink.getPlayers().size() + "");
            } else if (!pink.getPlayers().isEmpty()) {
                pinkStat = meanTeamStat_BedNo.replace("%aliveCount%", pink.getPlayers().size() + "");
            } else {
                pinkStat = meanTeamStat_None.replace("%aliveCount%", pink.getPlayers().size() + "");
            }
        }

        if (aqua == null || aqua.getTargetHeadBlock() == null || aqua.getTargetHeadBlock().getBlock() == null) {
            aquaStat = "";
        } else {
            Material blockType = aqua.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                aquaStat = meanTeamStat_BedYes.replace("%aliveCount%", aqua.getPlayers().size() + "");
            } else if (!aqua.getPlayers().isEmpty()) {
                aquaStat = meanTeamStat_BedNo.replace("%aliveCount%", aqua.getPlayers().size() + "");
            } else {
                aquaStat = meanTeamStat_None.replace("%aliveCount%", aqua.getPlayers().size() + "");
            }
        }

        if (white == null || white.getTargetHeadBlock() == null || white.getTargetHeadBlock().getBlock() == null) {
            whiteStat = "";
        } else {
            Material blockType = white.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                whiteStat = meanTeamStat_BedYes.replace("%aliveCount%", white.getPlayers().size() + "");
            } else if (!white.getPlayers().isEmpty()) {
                whiteStat = meanTeamStat_BedNo.replace("%aliveCount%", white.getPlayers().size() + "");
            } else {
                whiteStat = meanTeamStat_None.replace("%aliveCount%", white.getPlayers().size() + "");
            }
        }

        if (gray == null || gray.getTargetHeadBlock() == null || gray.getTargetHeadBlock().getBlock() == null) {
            grayStat = "";
        } else {
            Material blockType = gray.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                grayStat = meanTeamStat_BedYes.replace("%aliveCount%", gray.getPlayers().size() + "");
            } else if (!gray.getPlayers().isEmpty()) {
                grayStat = meanTeamStat_BedNo.replace("%aliveCount%", gray.getPlayers().size() + "");
            } else {
                grayStat = meanTeamStat_None.replace("%aliveCount%", gray.getPlayers().size() + "");
            }
        }

        if (orange == null || orange.getTargetHeadBlock() == null || orange.getTargetHeadBlock().getBlock() == null) {
            orangeStat = "";
        } else {
            Material blockType = orange.getTargetHeadBlock().getBlock().getType();
            if (blockType != null && blockType == bed_block) {
                orangeStat = meanTeamStat_BedYes.replace("%aliveCount%", orange.getPlayers().size() + "");
            } else if (!orange.getPlayers().isEmpty()) {
                orangeStat = meanTeamStat_BedNo.replace("%aliveCount%", orange.getPlayers().size() + "");
            } else {
                orangeStat = meanTeamStat_None.replace("%aliveCount%", orange.getPlayers().size() + "");
            }
        }

        if (red == null || red.getPlayers() == null) {
            redPlayer = "";
        } else {
            redPlayer = "" + red.getPlayers().size();
        }

        if (blue == null || blue.getPlayers() == null) {
            bluePlayer = "";
        } else {
            bluePlayer = "" + blue.getPlayers().size();
        }

        if (green == null || green.getPlayers() == null) {
            greenPlayer = "";
        } else {
            greenPlayer = "" + green.getPlayers().size();
        }

        if (yellow == null || yellow.getPlayers() == null) {
            yellowPlayer = "";
        } else {
            yellowPlayer = "" + yellow.getPlayers().size();
        }

        if (pink == null || pink.getPlayers() == null) {
            pinkPlayer = "";
        } else {
            pinkPlayer = "" + pink.getPlayers().size();
        }

        if (aqua == null || aqua.getPlayers() == null) {
            aquaPlayer = "";
        } else {
            aquaPlayer = "" + aqua.getPlayers().size();
        }

        if (white == null || white.getPlayers() == null) {
            whitePlayer = "";
        } else {
            whitePlayer = "" + white.getPlayers().size();
        }

        if (gray == null || gray.getPlayers() == null) {
            grayPlayer = "";
        } else {
            grayPlayer = "" + gray.getPlayers().size();
        }

        if (orange == null || orange.getPlayers() == null) {
            orangePlayer = "";
        } else {
            orangePlayer = "" + orange.getPlayers().size();
        }

        ScoreboardManager mgr = Bukkit.getScoreboardManager();

        String timeleft_m = gameTimeleft / 60 + "";
        String timeleft_h = gameTimeleft / 3600 + "";
        String timeleft_d = currentDate.getDayOfMonth() + "";
        String timeleft_mo = currentDate.getMonthValue() + "";
        String timeleft_y = currentDate.getYear() + "";
        final String scoreBoardName = "info";
        final String scoreBoardMode = "dummy";

        String ip;

        if (meanServerIp == null) {
            ip = "";
        } else {
            ip = meanServerIp;
        }
        String bw;

        if (meanBedwars == null) {
            bw = "";
        } else {
            bw = meanBedwars;
        }


        String mode;

        if (isIn4v4) {

            if (mean4v4Mode == null) {
                mode = "";
            } else {
                mode = mean4v4Mode;
            }
        } else {
            if (mean2v2Mode == null) {
                mode = "";
            } else {
                mode = mean2v2Mode;
            }
        }

        String itemO = plugin.getItemO();
        String stateOkLeft = plugin.getStateOkLeft();
        String stateOkRight = plugin.getStateOkRight();

        Map<Integer, String> willFilterMap;

        if (isIn4v4) {
            willFilterMap = ScoreBoard4v4Line;
        } else {
            willFilterMap = ScoreBoard2v2Line;
        }

        for (Player player : game.getPlayers()) {
            if (!Objects.equals(player.getWorld().getName(), game.getRegion().getWorld().getName())) {
                continue;
            }
            UUID playerUUID = player.getUniqueId();

            String redIsMe;
            String blueIsMe;
            String greenIsMe;
            String yellowIsMe;

            String pinkIsMe;
            String aquaIsMe;
            String whiteIsMe;
            String grayIsMe;

            String orangeIsMe;

            Team playerTeam = game.getPlayerTeam(player);

            if (playerTeam == null) {
                redIsMe = "";
                blueIsMe = "";
                greenIsMe = "";
                yellowIsMe = "";

                pinkIsMe = "";
                aquaIsMe = "";
                whiteIsMe = "";
                grayIsMe = "";

                orangeIsMe = "";
            } else {
                String playerTeamColor = playerTeam.getChatColor().toString();
                String playerTeamColorName = playerTeam.getColor().name();

                if (RelColor_Red.equals(playerTeamColorName)) {
                    redIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    redIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

                if (RelColor_Blue.equals(playerTeamColorName)) {
                    blueIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    blueIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

                if (RelColor_Green.equals(playerTeamColorName)) {
                    greenIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    greenIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

                if (RelColor_Yellow.equals(playerTeamColorName)) {
                    yellowIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    yellowIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

                if (RelColor_Pink.equals(playerTeamColorName)) {
                    pinkIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    pinkIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

                if (RelColor_Aqua.equals(playerTeamColorName)) {
                    aquaIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    aquaIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

                if (RelColor_Gray.equals(playerTeamColorName)) {
                    grayIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    grayIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

                if (RelColor_White.equals(playerTeamColorName)) {
                    whiteIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    whiteIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

                if (RelColor_Orange.equals(playerTeamColorName)) {
                    orangeIsMe = meanYou.replace("%teamColor%", playerTeamColor);
                } else {
                    orangeIsMe = meanNotYou.replace("%teamColor%", playerTeamColor);
                }

            }

            String kd = "" + getPlayerKD(playerUUID);
            String bed = "" + getPlayerBreakBed(playerUUID);
            String kill = "" + getPlayerKill(playerUUID);
            String fkill = "" + getPlayerFinalKill(playerUUID);
            String death = "" + getPlayerDeath(playerUUID);

            Scoreboard scoreboard = mgr.getNewScoreboard();
            Objective obj = scoreboard.registerNewObjective(scoreBoardName, scoreBoardMode);
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);

            Map<Integer, String> map = new HashMap<>(100);

            for (Map.Entry<Integer, String> entry : willFilterMap.entrySet()) {
                int score = entry.getKey();
                String string = entry.getValue();

                String s = string
                        .replace("%redName%", redName)
                        .replace("%blueName%", blueName)
                        .replace("%greenName%", greenName)
                        .replace("%yellowName%", yellowName)

                        .replace("%pinkName%", pinkName)
                        .replace("%aquaName%", aquaName)
                        .replace("%grayName%", grayName)
                        .replace("%whiteName%", whiteName)

                        .replace("%orangeName%", orangeName)

                        .replace("%redNameS%", redNameS)
                        .replace("%blueNameS%", blueNameS)
                        .replace("%greenNameS%", greenNameS)
                        .replace("%yellowNameS%", yellowNameS)

                        .replace("%pinkNameS%", pinkNameS)
                        .replace("%aquaNameS%", aquaNameS)
                        .replace("%whiteNameS%", whiteNameS)
                        .replace("%grayNameS%", grayNameS)

                        .replace("%orangeNameS%", orangeNameS)

                        .replace("%pinkStat%", pinkStat)
                        .replace("%aquaStat%", aquaStat)
                        .replace("%grayStat%", grayStat)
                        .replace("%whiteStat%", whiteStat)

                        .replace("%orangeStat%", orangeStat)

                        .replace("%pinkIsMe%", pinkIsMe)
                        .replace("%aquaIsMe%", aquaIsMe)
                        .replace("%grayIsMe%", grayIsMe)
                        .replace("%whiteIsMe%", whiteIsMe)

                        .replace("%orangeIsMe%", orangeIsMe)

                        .replace("%pinkPlayer%", pinkPlayer)
                        .replace("%aquaPlayer%", aquaPlayer)
                        .replace("%whitePlayer%", whitePlayer)
                        .replace("%grayPlayer%", grayPlayer)

                        .replace("%orangePlayer%", orangePlayer)

                        .replace("%redStat%", redStat)
                        .replace("%blueStat%", blueStat)
                        .replace("%greenStat%", greenStat)
                        .replace("%yellowStat%", yellowStat)

                        .replace("%redIsMe%", redIsMe)
                        .replace("%blueIsMe%", blueIsMe)
                        .replace("%greenIsMe%", greenIsMe)
                        .replace("%yellowIsMe%", yellowIsMe)

                        .replace("%redPlayer%", redPlayer)
                        .replace("%bluePlayer%", bluePlayer)
                        .replace("%greenPlayer%", greenPlayer)
                        .replace("%yellowPlayer%", yellowPlayer)

                        .replace("%yellowIsAlive%", yellowIsAlive)
                        .replace("%yellowBedStat%", yellowBedStat)

                        .replace("%greenIsAlive%", greenIsAlive)
                        .replace("%greenBedStat%", greenBedStat)

                        .replace("%redIsAlive%", redIsAlive)
                        .replace("%redBedStat%", redBedStat)

                        .replace("%blueIsAlive%", blueIsAlive)
                        .replace("%blueBedStat%", blueBedStat)

                        .replace("%aquaIsAlive%", aquaIsAlive)
                        .replace("%aquaBedStat%", aquaBedStat)

                        .replace("%pinkIsAlive%", pinkIsAlive)
                        .replace("%pinkBedStat%", pinkBedStat)

                        .replace("%whiteIsAlive%", whiteIsAlive)
                        .replace("%whiteBedStat%", whiteBedStat)

                        .replace("%grayIsAlive%", grayIsAlive)
                        .replace("%grayBedStat%", grayBedStat)

                        .replace("%orangeIsAlive%", orangeIsAlive)
                        .replace("%orangeBedStat%", orangeBedStat)

                        .replace("%timeleft_s%", timeleft_s)
                        .replace("%timeleft_m%", timeleft_m)
                        .replace("%timeleft_h%", timeleft_h)
                        .replace("%timeleft_d%", timeleft_d)
                        .replace("%timeleft_mo%", timeleft_mo)
                        .replace("%timeleft_y%", timeleft_y)
                        .replace("%date%", date)
                        .replace("%ip%", ip)
                        .replace("%bw%", bw)
                        .replace("%kill%", kill)
                        .replace("%fkill%", fkill)
                        .replace("%death%", death)
                        .replace("%bed%", bed)
                        .replace("%kd%", kd)
                        .replace("%game%", gameName)
                        .replace("%region%", regionName)
                        .replace("%world%", worldname)
                        .replace("%lastTask%", lastTask)
                        .replace("%lastTaskTimeLeft%", lastTaskTimeLeft)
                        .replace("%formatTimeLeft%", formatTimeLeft)

                        .replace("%mode%", mode)
                        .replace("%itemO%", itemO)
                        .replace("%stateOkLeft%", stateOkLeft)
                        .replace("%stateOkRight%", stateOkRight);

                map.put(score, s);
            }

            String st = t(map.get(100));
            String sl1 = t(map.get(1));
            String sl2 = t(map.get(2));
            String sl3 = t(map.get(3));
            String sl4 = t(map.get(4));
            String sl5 = t(map.get(5));
            String sl6 = t(map.get(6));
            String sl7 = t(map.get(7));
            String sl8 = t(map.get(8));
            String sl9 = t(map.get(9));
            String sl10 = t(map.get(10));
            String sl11 = t(map.get(11));
            String sl12 = t(map.get(12));
            String sl13 = t(map.get(13));
            String sl14 = t(map.get(14));
            String sl15 = t(map.get(15));
            String sl16 = t(map.get(16));

            if (Objects.equals(st, "")) {
                obj.setDisplayName(" ");
            } else {
                obj.setDisplayName(st);
            }
            if (!sl1.isEmpty())
                obj.getScore(sl1).setScore(1);
            if (!sl2.isEmpty())
                obj.getScore(sl2).setScore(2);
            if (!sl3.isEmpty())
                obj.getScore(sl3).setScore(3);
            if (!sl4.isEmpty())
                obj.getScore(sl4).setScore(4);
            if (!sl5.isEmpty())
                obj.getScore(sl5).setScore(5);
            if (!sl6.isEmpty())
                obj.getScore(sl6).setScore(6);
            if (!sl7.isEmpty())
                obj.getScore(sl7).setScore(7);
            if (!sl8.isEmpty())
                obj.getScore(sl8).setScore(8);
            if (!sl9.isEmpty())
                obj.getScore(sl9).setScore(9);
            if (!sl10.isEmpty())
                obj.getScore(sl10).setScore(10);
            if (!sl11.isEmpty())
                obj.getScore(sl11).setScore(11);
            if (!sl12.isEmpty())
                obj.getScore(sl12).setScore(12);
            if (!sl13.isEmpty())
                obj.getScore(sl13).setScore(13);
            if (!sl14.isEmpty())
                obj.getScore(sl14).setScore(14);
            if (!sl15.isEmpty())
                obj.getScore(sl15).setScore(15);
            if (!sl16.isEmpty())
                obj.getScore(sl16).setScore(16);

            player.setScoreboard(scoreboard);
        }

    }
}