

























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelRejoinHandler {
    private final ConcurrentHashMap<UUID, HashMap<String, String>> rejoinList = new ConcurrentHashMap<>();
    private final HashMap<String, String> emptyMap = new HashMap<>(0);

    public RelRejoinHandler(BedwarsKit ignored) {
    }

    public void clearAllPlayer() {
        rejoinList.clear();
    }

    public boolean listIsEmpty() {
        return rejoinList.isEmpty();
    }

    public void onPlayerLeave(Player player, Game game) {
        String gameName = game.getName();
        if (!rejoin) {
            return;
        }

        if (game.getState() != GameState.RUNNING || game.getCycle().isEndGameRunning()) {
            return;
        }

        Team team = game.getPlayerTeam(player);
        if (team == null) {
            return;
        }

        if (team.isDead(game)) {
            return;
        }

        UUID playerUUID = player.getUniqueId();
        final HashMap<String, String> willSaveMap = new HashMap<>(1);
        willSaveMap.put(gameName, team.getName());
        rejoinList.put(playerUUID, willSaveMap);
    }

    public HashMap<String, String> getRejoinGame(UUID uuid) {
        return rejoinList.getOrDefault(uuid, emptyMap);
    }

    public boolean onPlayerRejoin(Player player) {
        if (!rejoin) {
            return false;
        }

        UUID playerUUID = player.getUniqueId();
        HashMap<String, String> rejoinMap = getRejoinGame(playerUUID);
        if (rejoinMap.isEmpty()) {
            return false;
        }
        rejoinList.remove(playerUUID);
        Game game = null;
        Team team = null;
        for (Map.Entry<String, String> entry : rejoinMap.entrySet()) {
            game = BedwarsRel.getInstance().getGameManager().getGame(entry.getKey());
            team = game.getTeam(entry.getValue());
            break;
        }

        if (game == null || team == null) {
            return false;
        }

        if (game.getState() != GameState.RUNNING || game.getCycle().isEndGameRunning()) {
            return false;
        }

        if (team.isDead(game)) {
            return false;
        }

        SoundPlayer.ZOMBIE_INFECT(player, 1);
        silentJoinTeam(player, game, team);
        silentPlayerJoins(player, game);
        RelPlayerDeathHelper.onPlayerDeath(player, true);
        return true;
    }

    public void silentPlayerJoins(Player player, Game game) {
        if (game.getState() == GameState.STOPPED) {
            return;
        }

        if (game.getState() == GameState.RUNNING
        ) {
            Team team = game.getPlayerTeam(player);
            if (team == null || team.isDead(game)) {
                game.toSpectator(player);
            } else {

                BedwarsRel.getInstance().getGameManager().addGamePlayer(player, game);

                game.setPlayerDamager(player, null);
                game.addPlayerSettings(player);

                PlayerStorage storage = game.addPlayerStorage(player);
                storage.store();
                storage.clean();
                onPlayerTeleport(player, game);
            }
        }
    }

    private void silentJoinTeam(Player player, Game game, Team team) {
        silentAddPlayer(player, team);
        game.nonFreePlayer(player);
    }

    private void silentAddPlayer(Player player, Team team) {

        String displayName = player.getDisplayName();
        String playerListName = player.getPlayerListName();
        String playerName = player.getName();

        BedwarsRel bwrel = BedwarsRel.getInstance();
        if (bwrel.getConfig().getBoolean("overwrite-names", false)) {
            displayName = team.getChatColor() + ChatColor.stripColor(playerName);
            playerListName = team.getChatColor() + ChatColor.stripColor(playerName);
        }

        if (bwrel.getConfig().getBoolean("teamname-on-tab", true)) {
            playerListName = team.getChatColor() + team.getName() + ChatColor.WHITE + " | " + team.getChatColor() + ChatColor.stripColor(player.getDisplayName());
        }

        BedwarsPlayerSetNameEvent playerSetNameEvent = new BedwarsPlayerSetNameEvent(team, displayName, playerListName, player);
        Bukkit.getPluginManager().callEvent(playerSetNameEvent);

        player.setDisplayName(playerSetNameEvent.getDisplayName());
        player.setPlayerListName(playerSetNameEvent.getPlayerListName());

        team.getScoreboardTeam().addEntry(playerName);

    }

    private void onPlayerTeleport(Player player, Game game) {

        Location lobbyLoc = game.getLobby();
        Vector playerDire = player.getLocation().getDirection();

        if (!BedwarsRel.getInstance().isBungee()) {
            final Location spawnLocation = game.getPlayerTeleportLocation(player);
            Location willTeleport;
            game.getPlayerSettings(player).setTeleporting(true);
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
        }
    }

}
