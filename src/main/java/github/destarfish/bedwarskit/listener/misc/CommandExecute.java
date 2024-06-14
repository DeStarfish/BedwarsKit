














public class CommandExecute implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final PlayerCommandPreprocessEvent event) {

        final Player player = event.getPlayer();

        if (player == null) {
            return;
        }
        String text = event.getMessage();
        if (text.equals("/bwk")) {
            if (player.isOp()) {
                return;
            }
            showPluginInfo(player);
        } else if (text.startsWith("/shout ")) {

            if (BedwarsRel.getInstance() == null) {
                return;
            }

            BedwarsRel bedwarsRel = BedwarsRel.getInstance();
            if (bedwarsRel.getGameManager() == null) {
                return;
            }
            GameManager gm = bedwarsRel.getGameManager();
            final String acMess = text.replace("/shout ", "");

            Game game = gm.getGameOfPlayer(player);
            if (game != null && game.getState() == GameState.RUNNING) {

                final String finalMessage = (shoutPrefix + acMess).trim();
                player.chat(finalMessage);
            }
        }
    }
}
