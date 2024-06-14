






























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelGameOver implements Listener {
    private static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static final Material bed_block = GetMaterial.BED_BLOCK();
    private static final double maxBord = 9999;

    @EventHandler
    public void on(final BedwarsGameOverEvent event) {
        new BukkitRunnable() {
            public void run() {
                Game game = event.getGame();
                ArrayList<Player> players = event.getGame().getPlayers();

                if (players != null && !players.isEmpty()) {

                    for (Player player : players) {
                        if (player != null) {
                            UUID uuid = player.getUniqueId();
                            setDefaultPlayerStat(uuid);

                        }
                    }

                    if (!Objects.equals(gameOver_mess_chat, "")) {
                        BedwarsRel bwrel = BedwarsRel.getInstance();
                        String bwrel_prefix = bwrel.getConfig().getString("chat-prefix");

                        Team winTeam = event.getWinner();

                        String winner = "";
                        if (winTeam != null && !winTeam.getPlayers().isEmpty()) {
                            List<Player> winPlayers = winTeam.getPlayers();
                            StringBuilder sb = new StringBuilder();

                            for (Player var1 : winPlayers) {
                                if (sb.length() > 0) {
                                    sb.append(", ");
                                }
                                sb.append(var1.getName());
                            }

                            winner = sb.toString();
                        }
                        String topKillFormat = gameOver_mess_topKills_format;
                        String topKill1 = "";
                        String topKill2 = "";
                        String topKill3 = "";
                        String topKill4 = "";
                        String topKill5 = "";
                        HashMap<UUID, Integer> killsMap = RelCurrentStat.getKillsMapByGame(game);

                        TreeMap<Integer, UUID> treeMap = new TreeMap<>(Comparator.reverseOrder());

                        if (killsMap != null) {
                            killsMap.forEach((uuid, kills) -> treeMap.put(kills, uuid));
                        }

                        int count = 0;
                        for (int kills : treeMap.keySet()) {
                            if (kills == 0) {
                                continue;
                            }

                            UUID uuid = treeMap.get(kills);
                            String playerName = Bukkit.getPlayer(uuid).getName();
                            String formatted = topKillFormat
                                    .replace("%player%", playerName)
                                    .replace("%kills%", String.valueOf(kills));

                            if (count == 0) {
                                topKill1 = formatted;
                            } else if (count == 1) {
                                topKill2 = formatted;
                            } else if (count == 2) {
                                topKill3 = formatted;
                            } else if (count == 3) {
                                topKill4 = formatted;
                            } else if (count == 4) {
                                topKill5 = formatted;
                            }
                            count++;

                            if (count >= 5) {
                                break;
                            }
                        }


                        String willSend = gameOver_mess_chat
                                .replace("%bwrel_prefix%", bwrel_prefix)
                                .replace("%winner%", winner)
                                .replace("%topKills1%", topKill1)
                                .replace("%topKills2%", topKill2)
                                .replace("%topKills3%", topKill3)
                                .replace("%topKills4%", topKill4)
                                .replace("%topKills5%", topKill5);

                        players.forEach(player -> {
                            sendMessage(player, willSend);
                        });
                    }

                }

                Team winTeam = event.getWinner();
                boolean winnerIsNotNull = winTeam != null && winTeam.getPlayers() != null;

                if (winnerIsNotNull) {

                    List<Player> winTeamPlayers = winTeam.getPlayers();
                    boolean winnerIsNotEmpty = !winTeamPlayers.isEmpty();

                    if (winnerIsNotEmpty) {
                        for (Player player : winTeamPlayers) {
                            SoundPlayer.LEVEL_UP(player, 1);
                        }
                    }
                }

                World world = game.getRegion().getWorld();
                WorldBorder worldBorder = world.getWorldBorder();
                worldBorder.setCenter(game.getLobby());
                worldBorder.setSize(maxBord);

            }
        }.runTaskLater(plugin, 1L);
    }

    @EventHandler
    public void on(final BedwarsGameEndEvent event) {
        Game game = event.getGame();
        World world = game.getRegion().getWorld();
        for (Team team : game.getTeams().values()) {
            if (team.getHeadTarget().getType() != bed_block) {
                world.getBlockAt(team.getTargetHeadBlock()).setType(bed_block, true);
            }
            if (team.getFeetTarget().getType() != bed_block) {
                world.getBlockAt(team.getTargetFeetBlock()).setType(bed_block, true);
            }
        }

        new BukkitRunnable() {
            public void run() {
                int gameSize = game.getPlayers().size();
                int gameWorldSize = game.getRegion().getWorld().getPlayers().size();
                if (gameWorldSize != gameSize) {

                    if (isDebug()) {
                        l("game: " + gameSize + " , world: " + gameWorldSize);
                        l("game " + game.getName() + " not match player count, trying to synchronize");
                    }

                    if (Bukkit.getWorld(lobbyWorld) == null) {
                        if (isDebug()) {
                            l("game " + game.getName() + " fail to synchronize : Bukkit.getWorld(lobbyWorld) == null");
                        }
                    } else {

                        List<Player> playerList = new ArrayList<>(game.getMaxPlayers() + 1);
                        for (Player player : game.getRegion().getWorld().getPlayers()) {
                            if (player != null && player.isOnline()) {
                                playerList.add(player);
                            }
                        }

                        World lobby = Bukkit.getWorld(lobbyWorld);
                        GameManager gameManager = BedwarsRel.getInstance().getGameManager();
                        for (Player player : playerList) {
                            Location current = player.getLocation();
                            Location newLoc = current.setDirection(player.getLocation().getDirection());

                            if (gameManager.getGameOfPlayer(player) == null) {
                                if (isDebug()) {
                                    l(player.getName() + " joined world with no game,tp to lobby.");
                                }
                                sendMessage(player, "&c&lYou are in a game world but not in the game, sending you to the lobby!");
                                player.teleport(lobby.getSpawnLocation());
                            } else {
                                game.playerLeave(player, false);
                                game.playerJoins(player);
                                player.teleport(newLoc);
                            }
                        }

                    }
                }


                RelCurrentStat.onGameOver(game);
            }
        }.runTaskLater(plugin, 10L);

        new BukkitRunnable() {
            public void run() {
                if (game.getState() == GameState.WAITING) {
                    for (Player player : game.getPlayers()) {
                        if (player.getGameMode() == GameMode.SPECTATOR) {
                            player.setGameMode(GameMode.SURVIVAL);
                        }
                    }
                }
            }
        }.runTaskLater(plugin, 40L);
        if (kitEnable) {

            if (kitMenuItemGive) {
                new BukkitRunnable() {
                    @Override
                    public void run() {

                        for (Player player : game.getPlayers()) {
                            PlayerInventory pi = player.getInventory();
                            if (!pi.contains(kitMenuItem)) {
                                pi.addItem(kitMenuItem);
                            }
                            player.resetMaxHealth();
                        }
                    }

                }.runTaskLater(plugin, 10L);

            }
        }
    }


}
