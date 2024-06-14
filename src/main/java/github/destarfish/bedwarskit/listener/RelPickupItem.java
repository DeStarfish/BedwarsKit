




















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPickupItem implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(PlayerPickupItemEvent event) {

        if (!resourceSplit) {
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

        if (game.isSpectator(player) || game.getRespawnProtections().containsKey(player)) {
            event.setCancelled(true);
            return;
        }

        ItemStack item = event.getItem().getItemStack();
        Material itemType = item.getType();

        if (
                itemType == Material.IRON_INGOT
                        || itemType == Material.GOLD_INGOT
        ) {
            Location current = event.getItem().getLocation();
            if (game.getPlayerTeam(player) != null) {
                Team playerTeam = game.getPlayerTeam(player);

                for (Player list : game.getPlayers()) {

                    Location listLoc = list.getLocation();

                    if (listLoc.distance(current) <= resourceSplitDis) {
                        if (
                                game.getPlayerTeam(list) == playerTeam
                                        && list != player
                        ) {

                            PlayerInventory lpi = list.getInventory();
                            lpi.addItem(item);

                            playPickUpSound(list);

                        }
                    }

                }
            }
        }


    }

    private void playPickUpSound(Player player) {
        SoundPlayer.ITEM_PICKUP(player, 1);
    }
}
