



















































/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlayerJoin implements Listener {
    private static final Pattern p_teamColor = Pattern.compile("%teamColor%", Pattern.LITERAL);
    private static final Pattern p_teamName = Pattern.compile("%teamName%", Pattern.LITERAL);
    public static ItemStack playAgainItem;
    private final String className = getClass().getSimpleName();
    private final BedwarsKit plugin = BedwarsKit.getInstance();
    private final GameState running = GameState.RUNNING;
    private final Random random = new SecureRandom();

    private Material bed_blockType;

    private void playerSoundSucc(Player player) {
        SoundPlayer.CHICKEN_EGG_POP(player, 1);
    }

    private String replaceString(
            String text,
            String teamColor,
            String teamName
    ) {
        return p_teamName.matcher(p_teamColor.matcher(text).replaceAll(Matcher.quoteReplacement(teamColor))).replaceAll(Matcher.quoteReplacement(teamName));
    }

    @EventHandler
    public void on(final BedwarsPlayerJoinedEvent event) {

        if (bed_blockType == null) {
            bed_blockType = GetMaterial.BED_BLOCK();
        }

        if (event.getGame() == null) {
            return;
        }

        if (event.getPlayer() == null) {
            return;
        }
        Player player = event.getPlayer();

        Game game = event.getGame();

        if (!player.isOnline()) {
            return;
        }

        if (tab) {
            sendTab(player);
        }

        UUID joinPlayerUUID = player.getUniqueId();

        if (!game.getPlayers().contains(player)) {
            if (isDebug()) {
                le(className, "[Waring] silent return : !game.getPlayers().contains(player) -> " + player.getName());
            }
            return;
        }
        if (getPlayerKit(joinPlayerUUID) == null) {
            setPlayerKit(joinPlayerUUID, defaultKit);
        }

        playAgainItem = new ItemStack(dieOutGameItem_playAgain_itemType, 1);
        ItemMeta playAgainItemMeta = playAgainItem.getItemMeta();
        playAgainItemMeta.setDisplayName(dieOutGameItem_playAgain_itemName);
        playAgainItem.setItemMeta(playAgainItemMeta);

        setDefaultPlayerStat(joinPlayerUUID);

        if (bed_blockType != null) {
            if (
                    game.getState() == running
                            && game.getPlayerTeam(player) != null
                            && game.getPlayerTeam(player).getHeadTarget() != null
                            && game.getPlayerTeam(player).getHeadTarget().getType() != bed_blockType
            ) {
                Team team = game.getPlayerTeam(player);
                team.getPlayers().remove(player);
                game.getCycle().checkGameOver();
                addPlayerIsOut(joinPlayerUUID);
                game.addProtection(player);
            }
        }
        if (game.getState() == GameState.WAITING) {
            game.getPlayers().forEach(players -> SoundPlayer.CHICKEN_EGG_POP(players, 2));
        }

        if (!game.isSpectator(player)) {

            if (kitEnable) {

                if (kitMenuItemGive) {
                    new BukkitRunnable() {
                        @Override
                        public void run() {

                            PlayerInventory pi = player.getInventory();
                            if (!pi.contains(kitMenuItem)) {
                                pi.addItem(kitMenuItem);
                            }
                        }

                    }.runTask(plugin);

                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final PlayerJoinEvent event) {

        Player player = event.getPlayer();
        if (player == null || !player.isOnline()) {
            return;
        }

        RelRejoinHandler rejoinHandler = BedwarsKit.getInstance().getRejoinHandler();
        boolean rejoined = rejoinHandler.onPlayerRejoin(player);

        if (rejoined) {
            if (Objects.equals(rejoin_mess, "null")) {
                event.setJoinMessage(null);
            } else if (!Objects.equals(rejoin_mess, "")) {
                String willSend = rejoin_mess
                        .replace("%player%", player.getName())
                        .replace("%bwrel_prefix%", BedwarsRel.getInstance().getConfig().getString("chat-prefix")
                        );
                event.setJoinMessage(t(willSend));
            }
            boolean plugin_itemJoinEnabled = Bukkit.getPluginManager().getPlugin("ItemJoin") != null;
            if (plugin_itemJoinEnabled && !isBungeeEnabled()) {
                new BukkitRunnable() {
                    private final PlayerInventory pi = player.getInventory();
                    private final ItemJoinAPI itemJoinAPI = BedwarsKit.getInstance().getItemJoinAPI();

                    @Override
                    public void run() {
                        for (ItemStack item : pi.getContents()) {
                            if (itemJoinAPI.isCustom(item)) {
                                pi.remove(item);
                            }
                        }
                        for (ItemStack item : pi.getArmorContents()) {
                            if (itemJoinAPI.isCustom(item)) {
                                pi.remove(item);
                            }
                        }

                        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

                        if (game == null || !Objects.equals(player.getWorld().getName(), game.getRegion().getWorld().getName())) {
                            cancel();
                        } else {
                            TaskCompassInfo.runTask(player);
                        }
                    }
                }.runTaskLater(plugin, 40L);

            }
        } else {
            if (Objects.equals(joinServer_mess, "null")) {
                event.setJoinMessage(null);
            } else if (!Objects.equals(joinServer_mess, "")) {
                event.setJoinMessage(t(joinServer_mess.replace("%player%", player.getName())));
            }
            new BukkitRunnable() {
                @Override
                public void run() {

                    Game game = BedwarsRel.getInstance().getGameManager().getGameByLocation(player.getLocation());

                    if (game != null) {
                        game.toSpectator(player);
                    }


                }
            }.runTaskLater(plugin, 20L);


        }

        if (player.isOp()) {

            long l = random.nextInt(35) + 5;
            new BukkitRunnable() {
                @Override
                public void run() {
                    if (!isLastestVersion()) {
                        if (update_reportOp) {
                            showUpdateInfo(player);
                        }
                    }
                }
            }.runTaskLater(plugin, l);
        }
    }

    @EventHandler
    public void on(final BedwarsPlayerJoinTeamEvent event) {
        Player player = event.getPlayer();
        if (player == null || !player.isOnline()) {
            return;
        }
        if (BedwarsRel.getInstance() == null) {
            return;
        }
        Team team = event.getTeam();
        String teamName = team.getName();

        ChatColor chatColor = team.getChatColor();
        String teamColor = chatColor.toString();

        playerSoundSucc(player);
        if (!Objects.equals(lobbyJoinTeam_mess_chat, "")) {
            sendMessage(player, replaceString(lobbyJoinTeam_mess_chat,
                    teamColor, teamName));
        }
        if (!Objects.equals(lobbyJoinTeam_mess_title, "")) {
            String titleReal = t(replaceString(lobbyJoinTeam_mess_title,
                    teamColor, teamName));
            if (!Objects.equals(lobbyJoinTeam_mess_subtitle, "")) {
                String subtitleReal = t(replaceString(lobbyJoinTeam_mess_subtitle,
                        teamColor, teamName));

                sendTitle(player, titleReal, subtitleReal);
            }
        } else if (!Objects.equals(lobbyJoinTeam_mess_subtitle, "")) {
            String titleReal = " ";
            String subtitleReal = t(replaceString(lobbyJoinTeam_mess_subtitle,
                    teamColor, teamName));

            sendTitle(player, titleReal, subtitleReal);
        }
        if (!Objects.equals(lobbyJoinTeam_mess_actionbar, "")) {
            sendActionBar(player, t(replaceString(lobbyJoinTeam_mess_actionbar,
                    teamColor, teamName)));
        }

        if (lobbyJoinTeam_changeItemColor) {
            DyeColor dyeColor = team.getColor().getDyeColor();
            ItemStack itemInFirstSlot = player.getInventory().getItem(0);

            setColorByPlayerTeam(itemInFirstSlot, dyeColor);
        }

    }
}
