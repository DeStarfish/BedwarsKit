

























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class TaskCompassInfo {
    public static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static final Material compass = GetMaterial.COMPASS();
    private static final Random random = new Random();

    public static void sendLeaveCompassMess(Player player) {
        if (!Objects.equals(leaveHoldCompass_mess_actionbar, "")) {
            sendActionBar(player, leaveHoldCompass_mess_actionbar);
        }
    }

    public static void runTask(Player player) {

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);
        if (game == null) {
            return;
        }

        if (game.getCycle().isEndGameRunning() || game.getState() != GameState.RUNNING) {
            return;
        }

        BedwarsKit plugin = TaskCompassInfo.plugin;

        new BukkitRunnable() {
            @Override
            public void run() {

                if (game.getCycle().isEndGameRunning() || game.getState() != GameState.RUNNING || !Objects.equals(game.getRegion().getWorld().getName(), player.getWorld().getName())) {
                    cancel();
                }

                boolean playerIsOnline = player.isOnline();
                if (playerIsOnline) {
                    boolean playerIsNotSpec = !game.isSpectator(player);

                    if (holdCompassMess && playerIsNotSpec) {

                        ItemStack itemInHand = getItemInHand(player);
                        if (itemInHand != null) {
                            Material type = itemInHand.getType();
                            if (type == compass) {

                                ItemMeta meta = itemInHand.getItemMeta();
                                if (Objects.equals(holdCompassDisplayName, "null")) {
                                    meta.setDisplayName(null);
                                } else {
                                    meta.setDisplayName(t(holdCompassDisplayName));
                                }
                                itemInHand.setItemMeta(meta);

                                HashMap<Player, Integer> nerInfo = getNerestPlayerInfo(player, game);

                                boolean nerInfoIsEmpty = nerInfo.isEmpty();
                                boolean alwayAGoalEnabled = isAlwaysHaveAGoal();
                                boolean alwayAGoalDisabled = !isAlwaysHaveAGoal();

                                if (nerInfoIsEmpty && alwayAGoalDisabled) {
                                    String willSend = replaceNotFound(player, holdCompassNotFound_mess_actionBar);
                                    sendActionBar(player, willSend);
                                } else {
                                    String nerPlayer = null;
                                    String nerDistane = null;
                                    if (alwayAGoalEnabled) {
                                        nerPlayer = "FakePlayer";
                                        nerDistane = String.valueOf(random.nextInt(99));
                                    } else {
                                        for (Map.Entry<Player, Integer> entry : nerInfo.entrySet()) {
                                            nerPlayer = entry.getKey().getName();
                                            nerDistane = entry.getValue() + "";
                                            break;
                                        }
                                    }

                                    Team nerPlayerTeam = game.getPlayerTeam(player);

                                    String willSend = replaceFound(player, holdCompass_mess_actionBar, nerPlayer, nerDistane, nerPlayerTeam);

                                    sendActionBar(player, willSend);
                                }
                            }
                        }
                    }
                }


            }
        }.runTaskTimer(plugin, 1L, 1L);


    }

    private static String replaceFound(Player player, String text
            , String nerPlayer
            , String nerDistane
            , Team nerPlayerTeam


    ) {
        String nerPlayerTeamColor;
        String nerPlayerTeamName;
        if (nerPlayerTeam == null) {
            nerPlayerTeamColor = "null(nerPlayerTeamColor)";
            nerPlayerTeamName = "null(nerPlayerTeamName)";

        } else {
            nerPlayerTeamColor = nerPlayerTeam.getColor().getChatColor().toString();
            nerPlayerTeamName = nerPlayerTeam.getName();
        }

        String stateOkLeft = plugin.getStateOkLeft();
        String stateOkRight = plugin.getStateOkRight();
        String itemO = plugin.getItemO();

        BedwarsRel bwrel = BedwarsRel.getInstance();

        String bwrel_prefix = bwrel.getConfig().getString("chat-prefix");
        String bwrel_mess = BedwarsRel._l(player, "ingame.specials.tracker.target-found");

        String relOrg = text
                .replace("%nerPlayer%", nerPlayer)
                .replace("%nerPlayerTeamColor%", nerPlayerTeamColor)
                .replace("%nerPlayerTeamName%", nerPlayerTeamName)
                .replace("%nerDistane%", nerDistane)
                .replace("%bwrel_prefix%", bwrel_prefix)
                .replace("%bwrel_mess%", bwrel_mess)
                .replace("%stateOkLeft%", stateOkLeft)
                .replace("%stateOkRight%", stateOkRight)
                .replace("%itemO%", itemO);


        return relOrg
                .replace("$player$", nerPlayer)
                .replace("$blocks$", nerDistane)
                ;
    }

    private static String replaceNotFound(Player player, String text
    ) {
        String stateOkLeft = plugin.getStateOkLeft();
        String stateOkRight = plugin.getStateOkRight();
        String itemO = plugin.getItemO();

        BedwarsRel bwrel = BedwarsRel.getInstance();

        String bwrel_prefix = bwrel.getConfig().getString("chat-prefix");
        String bwrel_mess = BedwarsRel._l(player, "ingame.specials.tracker.no-target-found");

        return text
                .replace("%bwrel_prefix%", bwrel_prefix)
                .replace("%bwrel_mess%", bwrel_mess)
                .replace("%stateOkLeft%", stateOkLeft)
                .replace("%stateOkRight%", stateOkRight)
                .replace("%itemO%", itemO)
                ;
    }

    public static HashMap<Player, Integer> getNerestPlayerInfo(Player fromPlayer, Game game) {

        final HashMap<Player, Integer> willSend = new HashMap<>();

//        if (isDebug()) {
//            le(className, "[State] getNerestPlayerInfo for player " + fromPlayer.getName());
//        }

        Team fromPlayerTeam = game.getPlayerTeam(fromPlayer);


        List<Player> players = game.getPlayers();
        players.remove(fromPlayer);
        for (Player player : players) {
            if (!Objects.equals(player.getWorld().getName(), game.getRegion().getWorld().getName())) {
                players.remove(player);
            }
        }

//        if (isDebug()) {
//            le(className, "[State] getNerestPlayerInfo before fileter map: " + Collections.singletonList(players));
//        }

        Player nearestPlayer = null;
        int minDistance = Integer.MAX_VALUE;

        int distance = 0;
        for (Player player : players) {
            Team playerTeam = game.getPlayerTeam(player);

            boolean playerIsNotMe = !Objects.equals(player.getUniqueId(), fromPlayer.getUniqueId());
            boolean playerIsNotMyTeammate = !Objects.equals(fromPlayerTeam, playerTeam);
            boolean playerIsNotRepsawn = !RelRespawningPlayer.isPlayerRespawning(player.getUniqueId());

            boolean playerHasInvs = false;
            for (PotionEffect effect : player.getActivePotionEffects()) {
                PotionEffectType potionType = effect.getType();
                if (potionType == PotionEffectType.INVISIBILITY) {
                    playerHasInvs = true;
                    break;
                }
            }
            boolean playerNotHasInvs = !playerHasInvs;

//            if (isDebug()) {
//                String willSendD = "[State] getNerestPlayerInfo fileting: ";
//
//                willSendD = willSendD + player.getName()
//                        + ": playerIsNotMe[" + playerIsNotMe
//                        + "], playerIsNotMyTeammate[" + playerIsNotMyTeammate
//                        + "], playerIsNotRepsawn[" + playerIsNotRepsawn
//                        + "], playerNotProtectd[" + playerNotProtectd
//                        + "], playerNotHasInvs[" + playerNotHasInvs
//                        + "]"
//                ;
//                l(willSendD);
//            }

            if (playerIsNotMe
                    && playerNotHasInvs
                    && playerIsNotRepsawn
                    && playerIsNotMyTeammate
            ) {
                distance = getPlayerDistane(fromPlayer, player);
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestPlayer = player;
                }
            }
        }

        if (nearestPlayer != null) {
            willSend.put(nearestPlayer, distance);
        }

        return willSend;
    }

    private static int getPlayerDistane(Player formPlayer, Player player) {

        Location formPlayerLoc = formPlayer.getLocation();
        Location playerLoc = player.getLocation();

        if (Objects.equals(formPlayerLoc.getWorld().getName(), playerLoc.getWorld().getName())) {
            return -1;
        }

        return (int) formPlayerLoc.distance(playerLoc);
    }
}
