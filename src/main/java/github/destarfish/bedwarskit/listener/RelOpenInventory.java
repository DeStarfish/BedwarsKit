



















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelOpenInventory implements Listener {
    private static final GameState running = GameState.RUNNING;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final InventoryOpenEvent event) {
        if (!noOpenInventory) {
            return;
        }
        if (BedwarsRel.getInstance() == null) {
            return;
        }
        BedwarsRel bedwarsRel = BedwarsRel.getInstance();
        if (bedwarsRel.getGameManager() == null) {
            return;
        }
        GameManager gameManager = bedwarsRel.getGameManager();

        HumanEntity entity = event.getPlayer();

        boolean isPlayer = entity instanceof Player;

        if (!isPlayer) {
            return;
        }
        Player player = (Player) entity;

        if (gameManager.getGameOfPlayer(player) == null) {
            return;
        }

        Game game = gameManager.getGameOfPlayer(player);

        boolean playerIsOffline = !player.isOnline();

        if (
                game.getState() != running
                        || player.isSleeping()
                        || playerIsOffline
                        || player.isDead()
        ) {
            return;
        }

        if (
                game.isSpectator(player)
                        || game.getRespawnProtections().containsKey(player)
        ) {
            event.setCancelled(true);
            return;
        }

        InventoryType invType = getInvType(event.getInventory());
        if (isDebug()) {
            l("invType -> " + invType);
        }


        if (invType != null) {
            for (InventoryType blockType : noOpenInventoryTypeList) {
                if (invType == blockType) {
                    event.setCancelled(true);
                    break;
                }
            }
        }

    }
}
