

















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelBreakBed implements Listener {
    private static final BedwarsKit plugin = BedwarsKit.getInstance();

    private String replaceStrings(
            String text,
            String breakTeamColor,
            String breakTeamName,
            String breakPlayerTeamColor,
            String breakPlayerName,
            String breakPlayerTeamName) {
        return text.
                replace("%breakTeamColor%", breakTeamColor).
                replace("%breakTeamName%", breakTeamName).
                replace("%breakPlayerTeamColor%", breakPlayerTeamColor).
                replace("%breakPlayerName%", breakPlayerName).
                replace("%breakPlayerTeamName%", breakPlayerTeamName);
    }

    @EventHandler
    public void on(final BedwarsTargetBlockDestroyedEvent event) {

        if (!breakTitle) {
            return;
        }
        Game game = event.getGame();
        Player breakPlayer = event.getPlayer();
        Team breakPlayerTeam = game.getPlayerTeam(breakPlayer);

        new BukkitRunnable() {
            @Override
            public void run() {

                String playerName = breakPlayer.getName();
                String breakPlayerName = event.getPlayer().getName();
                String breakPlayerTeamName = breakPlayerTeam.getName();

                String breakTeamName = event.getTeam().getName();
                String breakTeamColor = event.getTeam().getChatColor().toString();
                String breakPlayerTeamColor = breakPlayerTeam.getChatColor().toString();

                String btBreakTeamReal = replaceStrings(breakTitleBreakTeam, breakTeamColor, breakTeamName, breakPlayerTeamColor, breakPlayerName, breakPlayerTeamName);
                String bstBreakTeamReal = replaceStrings(breakSubTitleBreakTeam, breakTeamColor, breakTeamName, breakPlayerTeamColor, breakPlayerName, breakPlayerTeamName);
                String btBreakPlayerReal = replaceStrings(breakTitleBreakPlayer, breakTeamColor, breakTeamName, breakPlayerTeamColor, breakPlayerName, breakPlayerTeamName);
                String bstBreakPlayerReal = replaceStrings(breakSubTitleBreakPlayer, breakTeamColor, breakTeamName, breakPlayerTeamColor, breakPlayerName, breakPlayerTeamName);
                String btAllReal = replaceStrings(breakTitleAll, breakTeamColor, breakTeamName, breakPlayerTeamColor, breakPlayerName, breakPlayerTeamName);
                String bstAllReal = replaceStrings(breakSubTitleAll, breakTeamColor, breakTeamName, breakPlayerTeamColor, breakPlayerName, breakPlayerTeamName);

                game.getTeamPlayers().forEach((player) -> {
                    String playerTeam = game.getPlayerTeam(player).getName();

                    if (!playerName.equals(breakPlayerName)
                            && !playerTeam.equals(breakTeamName)) {
                        sendTitle(player, btAllReal, bstAllReal);
                    } else if (playerTeam.equals(breakTeamName)) {

                        sendTitle(player, btBreakTeamReal, bstBreakTeamReal);
                    }
                });

                sendTitle(breakPlayer, btBreakPlayerReal, bstBreakPlayerReal);

                UUID breakPlayerUUID = breakPlayer.getUniqueId();
                updatePlayerStat(breakPlayerUUID, addBreakBed, 1);

            }

        }.runTaskLater(plugin, 0L);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (breakPlayerTeam.isDead(game)) {
                    for (Player player : breakPlayerTeam.getPlayers()) {
                        if (!player.isOnline()) {
                            breakPlayerTeam.removePlayer(player);
                        }
                    }
                }
            }
        }.runTaskLater(plugin, 20L);
    }
}
