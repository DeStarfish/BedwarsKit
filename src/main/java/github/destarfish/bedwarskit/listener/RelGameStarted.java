
































































/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelGameStarted implements Listener {
    private final String className = getClass().getSimpleName();
    private final BedwarsKit plugin = BedwarsKit.getInstance();
    private final Difficulty peaceful = Difficulty.PEACEFUL;
    private final Difficulty normal = Difficulty.NORMAL;
    private final String doWeatherCycle = "doWeatherCycle";
    private final String meanfalse = "false";
    private final int maxSize = 9999;
    private final DisplaySlot sidebar = DisplaySlot.SIDEBAR;
    private final Material botType = Material.GLASS_BOTTLE;
    private final ItemStack chain1 = new ItemStack(Material.CHAINMAIL_LEGGINGS);
    private final ItemStack chain2 = new ItemStack(Material.CHAINMAIL_BOOTS);
    private final ItemStack iron1 = new ItemStack(Material.IRON_LEGGINGS);
    private final ItemStack iron2 = new ItemStack(Material.IRON_BOOTS);
    private final ItemStack dm1 = new ItemStack(Material.DIAMOND_LEGGINGS);
    private final ItemStack dm2 = new ItemStack(Material.DIAMOND_BOOTS);
    private final GameState running = GameState.RUNNING;
    private RelScoreBoard relScoreBoard;
    private Material bed_blockType;
    private ItemStack bed_item;

    private void checkEffects(Game game) {
        TeamHaste.checkGame(game);
        TeamHeal.check(game);
        TeamProtect.check(game);
        TeamSharp.check(game);
    }


    @EventHandler
    public void on(final BedwarsGameStartedEvent event) {

        if (relScoreBoard == null) {
            relScoreBoard = plugin.getRelScoreBoard();
        }

        if (bed_blockType == null) {
            bed_blockType = GetMaterial.BED_BLOCK();
        }
        final Material bed_itemType = GetMaterial.BED_ITEM();

        if (bed_itemType == null) {
            if (isDebug()) {
                le(className, "[Waring] silent return : bed_itemType == null ");
            }
            return;
        }

        if (bed_item == null) {
            bed_item = new ItemStack(bed_itemType);
        }

        Game game = event.getGame();

        if (game == null) {
            if (isDebug()) {
                le(className, "[Waring] silent return : game == null");
            }
            return;
        }

        String gameName = game.getName();

        if (isDebug()) {
            l("[State] game " + gameName + " start");
        }

        World world = game.getRegion().getWorld();
        String worldName = world.getName();

        String worldMode = Utils.isInMode(game);

        new BukkitRunnable() {
            public void run() {

                ScoreboardManager scbMgr = Bukkit.getScoreboardManager();
                Scoreboard scoreboard = scbMgr.getNewScoreboard();
                Objective obj = scoreboard.registerNewObjective("load", "dummy");

                obj.setDisplaySlot(sidebar);

                game.getPlayers().stream()
                        .filter(Objects::nonNull)
                        .filter(Player::isOnline)
                        .forEach(player -> player.setScoreboard(scoreboard));

                if (Objects.equals(worldMode, "2v2")) {

                    if (ScoreBoard2v2Line != null &&
                            !ScoreBoard2v2Line.isEmpty()) {

                        obj.setDisplayName(ScoreBoard2v2StartTitle);
                        int scbLines = ScoreBoard2v2Line.size() - 2;

                        new BukkitRunnable() {
                            private int maxTry = 20;
                            private int scbLine = scbLines;
                            private String nextLine = "";

                            @Override
                            public void run() {

                                if (scbLine <= 0 || maxTry <= 0) {
                                    cancel();
                                }

                                maxTry--;
                                nextLine = nextLine + " ";
                                obj.getScore(nextLine).setScore(scbLine);
                                scbLine--;


                            }
                        }.runTaskTimer(plugin, 0L, 1L);
                    }

                } else if (Objects.equals(worldMode, "4v4")) {
                    if (ScoreBoard4v4Line != null &&
                            !ScoreBoard4v4Line.isEmpty()) {

                        obj.setDisplayName(ScoreBoard4v4StartTitle);
                        int scbLines = ScoreBoard4v4Line.size() - 2;

                        new BukkitRunnable() {
                            private int maxTry = 20;
                            private int scbLine = scbLines;
                            private String nextLine = "";

                            @Override
                            public void run() {

                                if (scbLine <= 0 || maxTry <= 0) {
                                    cancel();
                                }

                                maxTry--;
                                nextLine = nextLine + " ";
                                obj.getScore(nextLine).setScore(scbLine);
                                scbLine--;


                            }
                        }.runTaskTimer(plugin, 0L, 1L);
                    }
                }

                world.setThundering(false);
                world.setWeatherDuration(0);
                world.setGameRuleValue(doWeatherCycle, meanfalse);

                for (Entity entity : world.getEntities()) {
                    if (entity instanceof ArmorStand) {
                        entity.remove();
                    }
                }

                WorldBorder worldBorder = world.getWorldBorder();
                worldBorder.setCenter(game.getLobby());
                worldBorder.setSize(maxSize);

                Map<String, Team> teamMap = game.getTeams();

                if (teamMap != null && !teamMap.isEmpty()) {
                    List<Team> teamList = new ArrayList<>(teamMap.values());

                    TeamHaste.setTeamDatasDefault(gameName, teamList);
                    TeamHeal.setTeamDatasDefault(gameName, teamList);
                    TeamSharp.setTeamDatasDefault(gameName, teamList);
                    TeamProtect.setTeamDatasDefault(gameName, teamList);
                } else {

                    if (isDebug()) {
                        le(className, "teamMap is null or empty.");
                    }
                }

                runTaskIfEnabled(game);

                RelCurrentStat.onGameStart(game);
                game.getPlayers().stream()
                        .filter(Objects::nonNull)
                        .filter(Player::isOnline)
                        .forEach(player -> {

                            TaskCompassInfo.runTask(player);
                            game.getPlayerSettings(player).setOneStackPerShift(true);
                            UUID playerUUID = player.getUniqueId();
                            SoundPlayer.LEVEL_UP(player, 1);

                            if (game.getRespawnProtections() != null) {
                                if (game.getRespawnProtections().containsKey(player)) {
                                    game.removeProtection(player);
                                }
                            }

                            if (!Objects.equals(startmess_all_chat, "")) {
                                sendMessage(player, startmess_all_chat);
                            }
                            if (!Objects.equals(startmess_all_title, "")) {
                                String titleReal = startmess_all_title;
                                if (!Objects.equals(startmess_all_subtitle, "")) {
                                    String subtitleReal = startmess_all_subtitle;

                                    sendTitle(player, titleReal, subtitleReal);
                                }
                            } else if (!Objects.equals(startmess_all_subtitle, "")) {
                                String titleReal = " ";
                                String subtitleReal = startmess_all_subtitle;

                                sendTitle(player, titleReal, subtitleReal);
                            }
                            if (!Objects.equals(startmess_all_actionbar, "")) {
                                sendActionBar(player, startmess_all_actionbar);
                            }

                            setDefaultPlayerStat(playerUUID);
                            removeRespawningPlayer(playerUUID);
                            if (KitConfigHandler.kitEnable) {
                                if (KitConfigHandler.kitForce) {
                                    applykitforce(playerUUID, KitConfigHandler.kitForceKit);
                                } else {
                                    applykit(playerUUID);
                                }
                            }

                            removePlayerIsOut(playerUUID);

                            removeArmorChain(playerUUID);
                            removeArmorIron(playerUUID);
                            removeArmorDiamond(playerUUID);

                            if (startKitCompass) {

                                ItemStack compass = new ItemStack(Material.COMPASS);
                                if (!Objects.equals(compassDisplayName, "")) {
                                    ItemMeta meta = compass.getItemMeta();
                                    meta.setDisplayName(t(compassDisplayName));
                                    compass.setItemMeta(meta);
                                }

                                player.getInventory().addItem(compass);
                            }
                        });

                disableAI(worldName);

                if (cleanHostileOnStart) {
                    Difficulty difficultyOrg;
                    if (world.getDifficulty() == peaceful) {
                        difficultyOrg = normal;
                    } else {
                        difficultyOrg = world.getDifficulty();
                    }
                    new BukkitRunnable() {
                        private int h;

                        {
                            h = 3;
                        }

                        public void run() {
                            if (h != 0) {
                                world.setDifficulty(peaceful);
                                --h;
                            }

                            if (h == 0) {
                                world.setDifficulty(difficultyOrg);
                                cancel();
                            }
                        }
                    }
                            .runTaskTimer(plugin, 1L, 20L);
                }

                TaskResIron taskResIron = new TaskResIron(game);
                taskResIron.runTask();

                TaskResGold taskResGold = new TaskResGold(game);
                taskResGold.runTask();

                TaskResDiamond taskResDiamond = new TaskResDiamond(game);
                taskResDiamond.runTask();

                TaskResEmerald taskResEmerald = new TaskResEmerald(game);
                taskResEmerald.runTask();

            }
        }.runTaskLater(plugin, 1L);

        new BukkitRunnable() {

            @Override
            public void run() {

                if (game.getState() != running || game.getCycle().isEndGameRunning()) {
                    cancel();
                }

                if (tab) {
                    for (Player list : game.getPlayers()) {
                        sendTab(list);
                    }
                }

                if (isDebug()) {
                    le(className, "[State] Checking running game " + gameName);
                }
                try {
                    relScoreBoard.updateScoreBoard(game);
                } catch (Exception e) {
                    if (isDebug()) {
                        le(className, e);
                    }
                }
                if (tab) {
                    for (Player list : game.getPlayers()) {
                        sendTab(list);
                    }
                }

                if (game.getState() != running) {
                    cancel();
                } else {

                    for (Player player : game.getRegion().getWorld().getPlayers()) {
                        Team playerTeam = game.getPlayerTeam(player);
                        String b1;
                        if (playerTeam == null) {
                            b1 = "null";
                        } else {
                            b1 = playerTeam.getName();
                        }

                        if (isDebug()) {
                            String s1;
                            String s2;
                            String s3 = "you in team " + b1;
                            if (game.getRespawnProtections().containsKey(player)) {
                                s1 = "You has prot";
                            } else {
                                s1 = "You not has prot";
                            }
                            if (game.isSpectator(player)) {
                                s2 = "You are Spe";
                            } else {
                                s2 = "You are not Spe";
                            }
                            if (isDebug()) {
                                sendActionBar(player, ": " + b1);
                            }

                            sendActionBar(player, s1 + "|" + s2 + "|" + s3);
                        }
                    }

                    ItemStack chain = null;
                    if (chainPriceType != null) {
                        chain = new ItemStack(chainPriceType, chainPrice);
                    }
                    ItemStack iron = null;
                    if (ironPriceType != null) {
                        iron = new ItemStack(ironPriceType, ironPrice);
                    }
                    ItemStack diamond = null;
                    if (diamondPriceType != null) {
                        diamond = new ItemStack(diamondPriceType, diamondPrice);
                    }

                    for (Player player : game.getPlayers()) {
                        if (player != null && player.isOnline()) {
                            UUID playerUUID = player.getUniqueId();
                            updateKillsMapForGame(playerUUID, game);
                            PlayerInventory pi = player.getInventory();

                            if (game.isSpectator(player)) {
                                if (dieOutGameItem_playAgain) {
                                    if (!pi.contains(playAgainItem)) {
                                        pi.setItem(
                                                dieOutGameItem_playAgain_itemSlot,
                                                playAgainItem);
                                    }
                                }
                            } else {

                                if (cleanBottle && pi.contains(botType)) {
                                    pi.remove(botType);
                                }
                                if (cleanBed && pi.contains(bed_item)) {
                                    pi.remove(bed_item);
                                }

                                if (pi.contains(upToDiamondArmor)) {
                                    if (hasArmorDiamond(playerUUID)) {
                                        pi.remove(upToDiamondArmor);
                                        pi.addItem(diamond);
                                        return;
                                    }

                                    addArmorDiamond(playerUUID);
                                    removeArmorIron(playerUUID);
                                    removeArmorChain(playerUUID);

                                    pi.remove(upToDiamondArmor);
                                    pi.setLeggings(dm1);
                                    pi.setBoots(dm2);
                                }

                                if (pi.contains(upToIronArmor)) {
                                    if (hasArmorIron(playerUUID)
                                            || hasArmorDiamond(playerUUID)) {
                                        pi.remove(upToIronArmor);
                                        pi.addItem(iron);
                                        return;
                                    }

                                    removeArmorChain(playerUUID);
                                    addArmorIron(playerUUID);

                                    pi.remove(upToIronArmor);
                                    pi.setLeggings(iron1);
                                    pi.setBoots(iron2);
                                }

                                if (pi.contains(upToChainArmor)) {
                                    if (hasArmorChain(playerUUID)
                                            || hasArmorIron(playerUUID)
                                            || hasArmorDiamond(playerUUID)) {
                                        pi.remove(upToChainArmor);
                                        pi.addItem(chain);
                                        return;
                                    }

                                    addArmorChain(playerUUID);
                                    pi.remove(upToChainArmor);
                                    pi.setLeggings(chain1);
                                    pi.setBoots(chain2);
                                }

                            }
                        }
                    }

                    checkEffects(game);
                }
            }
        }.runTaskTimer(plugin, 0L, 20L);
    }

    private void runTaskIfEnabled(Game game) {

        boolean gameTaskIsDisabled = !gametask;

        if (gameTaskIsDisabled) {
            return;
        }

        if (gametask_spawntime) {

            List<ResourceSpawner> resourceSpawners = game.getResourceSpawners();
            resourceSpawners.forEach(spawner -> spawner.getResources().stream()
                    .filter(Objects::nonNull)
                    .findFirst()
                    .ifPresent(item -> {
                        if (item.getType() == Material.IRON_INGOT) {
                            spawner.setInterval(gametask_spawntime_iron_base);
                        } else if (item.getType() == Material.GOLD_INGOT) {
                            spawner.setInterval(gametask_spawntime_gold_base);
                        } else if (item.getType() == Material.DIAMOND) {
                            spawner.setInterval(gametask_spawntime_diamond_base);
                        } else if (item.getType() == Material.EMERALD) {
                            spawner.setInterval(gametask_spawntime_emerald_base);
                        }
                    }));

            if (gametask_spawntime_tasks_iron1 > 0) TaskIron1.runTask(game);
            if (gametask_spawntime_tasks_iron2 > 0) TaskIron2.runTask(game);
            if (gametask_spawntime_tasks_iron3 > 0) TaskIron3.runTask(game);
            if (gametask_spawntime_tasks_iron4 > 0) TaskIron4.runTask(game);

            if (gametask_spawntime_tasks_gold1 > 0) TaskGold1.runTask(game);
            if (gametask_spawntime_tasks_gold2 > 0) TaskGold2.runTask(game);
            if (gametask_spawntime_tasks_gold3 > 0) TaskGold3.runTask(game);
            if (gametask_spawntime_tasks_gold4 > 0) TaskGold4.runTask(game);

            if (gametask_spawntime_tasks_diamond1 > 0) TaskDiamond1.runTask(game);
            if (gametask_spawntime_tasks_diamond2 > 0) TaskDiamond2.runTask(game);
            if (gametask_spawntime_tasks_diamond3 > 0) TaskDiamond3.runTask(game);
            if (gametask_spawntime_tasks_diamond4 > 0) TaskDiamond4.runTask(game);


            if (gametask_spawntime_tasks_emerald1 > 0) TaskEmerald1.runTask(game);
            if (gametask_spawntime_tasks_emerald2 > 0) TaskEmerald2.runTask(game);
            if (gametask_spawntime_tasks_emerald3 > 0) TaskEmerald3.runTask(game);
            if (gametask_spawntime_tasks_emerald4 > 0) TaskEmerald4.runTask(game);

        }

        if (gametask_time_healthset1 > 0) TaskHealthSet1.runTask(game);
        if (gametask_time_healthset2 > 0) TaskHealthSet2.runTask(game);
        if (gametask_time_healthset3 > 0) TaskHealthSet3.runTask(game);
        if (gametask_time_healthset4 > 0) TaskHealthSet4.runTask(game);

        if (gametask_finalbattle) {
            if (gametask_finalbattle_time > 0) TaskFinalBattle.runTask(game);
        }

    }
}
