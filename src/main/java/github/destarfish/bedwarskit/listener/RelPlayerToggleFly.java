













/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlayerToggleFly implements Listener {
    private static final GameMode creative = GameMode.CREATIVE;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final PlayerToggleFlightEvent event) {

        if (!relFix_creativeCantToggleFly) {
            return;
        }

        Player player = event.getPlayer();
        if (BedwarsRel.getInstance() == null) {
            return;
        }
        BedwarsRel bedwarsRel = BedwarsRel.getInstance();
        if (bedwarsRel.getGameManager() == null) {
            return;
        }
        GameManager gameManager = bedwarsRel.getGameManager();
        if (gameManager.getGameOfPlayer(player) == null) {
            return;
        }

        Game game = gameManager.getGameOfPlayer(player);
        GameMode current = player.getGameMode();

        boolean playerInNotFlying = !player.isFlying();

        if (current == creative) {
            event.setCancelled(true);
            player.setFlying(playerInNotFlying);
            return;
        }

        if (game.getRespawnProtections().containsKey(player)) {
            event.setCancelled(true);
            player.setFlying(playerInNotFlying);
            return;
        }
    }
}
