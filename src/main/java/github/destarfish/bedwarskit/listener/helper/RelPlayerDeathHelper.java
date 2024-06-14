

































/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlayerDeathHelper {
    private static final String className = RelPlayerDeathHelper.class.getSimpleName();
    private static final Material bed_block = GetMaterial.BED_BLOCK();
    private static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static final GameState waiting = GameState.WAITING;
    private static final Pattern p_timeleft = Pattern.compile("%timeleft%", Pattern.LITERAL);
    private static final ItemStack airItem = new ItemStack(Material.AIR);

    private static String replaceString(
            String text,
            String i) {
        return p_timeleft.matcher(text).replaceAll(Matcher.quoteReplacement(i));
    }

    public static void onPlayerDeath(Player player, boolean callCycle) {

        if (!deathGameMode) {
            return;
        }

        if (player == null) {
            return;
        }

        if (!player.isOnline()) {
            return;
        }


        GameManager gameManager = BedwarsRel.getInstance().getGameManager();
        Game game = gameManager.getGameOfPlayer(player);
        if (game == null) {
            return;
        }

        Team team = game.getPlayerTeam(player);

        if (team == null) {
            return;
        }

        UUID playerUUID = player.getUniqueId();
        if (isPlayerRespawning(playerUUID)) {
            return;
        }

        addRespawningPlayer(playerUUID);

        if (bed_block == null) {
            le(className, "bed_block mat is null");
            return;
        }

        Location spawnLocation = team.getSpawnLocation();

        Location lobbyLoc = game.getLobby();

        GameCycle cycle = game.getCycle();
        GameState state = game.getState();

        if (state != GameState.RUNNING || cycle.isEndGameRunning()) {
            return;
        }

        Player killer = game.getPlayerDamager(player);

        if (callCycle) {
            cycle.onPlayerDies(player, killer);

            PlayerRespawnEvent playerRespawnEvent = new PlayerRespawnEvent(player, player.getLocation(), false);
            cycle.onPlayerRespawn(playerRespawnEvent, player);
        }

        Location willTeleport;
        Vector playerDire = player.getLocation().getDirection();

        if (!Objects.equals(deathGameMode_tpto, "none")) {
            if (deathGameMode_tpto.equalsIgnoreCase("team")) {
                if (spawnLocation != null) {
                    willTeleport = spawnLocation.setDirection(playerDire);
                    player.teleport(willTeleport);
                }
            } else if (deathGameMode_tpto.equalsIgnoreCase("lobby")) {
                willTeleport = lobbyLoc.setDirection(playerDire);
                player.teleport(willTeleport);
            }
        }

        if (preventLoadWorld) {
            player.setGameMode(GameMode.SPECTATOR);
            player.setLastDamageCause(null);
            game.setPlayerDamager(player, null);
        }

        PlayerInventory pi = player.getInventory();

        InventoryView invView = player.getOpenInventory();
        if (invView != null) {
            invView.setCursor(airItem);
        }

        for (ItemStack item : pi.getContents()) {
            if (item != null) {
                Material type = item.getType();
                if (
                        type != killfb_oneHealthKill_itemType
                ) {
                    pi.remove(item);
                }
            }
        }

        pi.clear(36);
        pi.clear(37);
        pi.clear(38);
        pi.clear(39);

        player.getActivePotionEffects().clear();

        addRespawningPlayer(playerUUID);

        if (team.isDead(game)) {

            new BukkitRunnable() {
                @Override
                public void run() {

                    game.toSpectator(player);

                    BedwarsRel bwrel = BedwarsRel.getInstance();
                    String bwrel_prefix = bwrel.getConfig().getString("chat-prefix");
                    if (!Objects.equals(dieOut_mess_chat, "")) {
                        sendMessage(player, dieOut_mess_chat.replace("%bwrel_prefix%", bwrel_prefix));
                    }
                    if (!Objects.equals(dieOut_mess_title, "")) {
                        String titleReal = dieOut_mess_title.replace("%bwrel_prefix%", bwrel_prefix);
                        if (!Objects.equals(dieOut_mess_subtitle, "")) {
                            String subtitleReal = dieOut_mess_subtitle.replace("%bwrel_prefix%", bwrel_prefix);

                            sendTitle(player, titleReal, subtitleReal);
                        }
                    } else if (!Objects.equals(dieOut_mess_subtitle, "")) {
                        String titleReal = " ";
                        String subtitleReal = dieOut_mess_subtitle.replace("%bwrel_prefix%", bwrel_prefix);

                        sendTitle(player, titleReal, subtitleReal);
                    }
                    if (!Objects.equals(dieOut_mess_actionbar, "")) {
                        sendActionBar(player, dieOut_mess_actionbar.replace("%bwrel_prefix%", bwrel_prefix));
                    }
                }
            }.runTask(plugin);
        } else {

            new BukkitRunnable() {
                private int x = respawnDelay + 1;

                public void run() {

                    if (player.isOnline()) {
                        if (state == waiting || cycle.isEndGameRunning()) {
                            cancel();
                        }
                    } else {
                        cancel();
                    }

                    String i;
                    if (x != 0) {
                        --x;
                        i = Integer.toString(x);

                        if (!Objects.equals(respawnChat, "")) {
                            sendMessage(player, replaceString(respawnChat, i));
                        }
                        if (!Objects.equals(respawnTitle, "")) {
                            String titleReal = replaceString(respawnTitle, i);
                            if (!Objects.equals(respawnSubTitle, "")) {
                                String subtitleReal = replaceString(respawnSubTitle, i);

                                sendTitle(player, titleReal, subtitleReal);
                            }
                        } else if (!Objects.equals(respawnSubTitle, "")) {
                            String titleReal = " ";
                            String subtitleReal = replaceString(respawnSubTitle, i);

                            sendTitle(player, titleReal, subtitleReal);
                        }
                        if (!Objects.equals(respawnActionBar, "")) {
                            sendActionBar(player, replaceString(respawnActionBar, i));
                        }

                        if (!game.getRespawnProtections().containsKey(player)) {
                            game.addProtection(player);
                        }

                    }

                    if (x == 0) {

                        if (!getPlayerisOut(playerUUID)) {
                            game.removeProtection(player);
                            if (spawnLocation == null) {
                                if (isDebug()) {
                                    l("[Warning] player " + player + " 's spawnLocation is null, cant teleport player to there spawnLocation!");
                                }
                            } else {
                                Vector playerDirection = player.getLocation().getDirection();
                                Location willTele = spawnLocation.setDirection(playerDirection);
                                player.setFallDistance(0);
                                player.teleport(willTele);
                                player.setFallDistance(0);
                            }
                            removeRespawningPlayer(playerUUID);
                            playerRespawn(player, 0L);
                        }


                        i = Integer.toString(x);


                        if (!Objects.equals(respawnSuccChat, "")) {
                            sendMessage(player, replaceString(respawnSuccChat, i));
                        }
                        if (!Objects.equals(respawnSuccTitle, "")) {
                            String titleReal = replaceString(respawnSuccTitle, i);
                            if (!Objects.equals(respawnSuccSubTitle, "")) {
                                String subtitleReal = replaceString(respawnSuccSubTitle, i);

                                sendTitle(player, titleReal, subtitleReal);
                            }
                        } else if (!Objects.equals(respawnSuccSubTitle, "")) {
                            String titleReal = " ";
                            String subtitleReal = replaceString(respawnSuccSubTitle, i);

                            sendTitle(player, titleReal, subtitleReal);
                        }
                        if (!Objects.equals(respawnSuccActionBar, "")) {
                            sendActionBar(player, replaceString(respawnSuccActionBar, i));
                        }

                        cancel();
                    }
                }
            }.runTaskTimer(plugin, 2L, 20L);
        }
    }
}
