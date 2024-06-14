












/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelFoodLevelLock implements Listener {
    @EventHandler
    public void on(final FoodLevelChangeEvent event) {

        boolean funDisabled = !noHunger;

        if (funDisabled) {
            return;
        }


        if (event.getEntity() == null) {
            return;
        }

        if (event.getEntity().getType() != EntityType.PLAYER) {
            return;
        }

        Player player = (Player) event.getEntity();

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        boolean isInGame = game != null && game.isInGame(player);

        int current = event.getFoodLevel();
        if (isInGame && current != maxFoodLevel) {
            event.setFoodLevel(maxFoodLevel);
        }

    }
}
