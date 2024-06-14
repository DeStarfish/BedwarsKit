











/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlayerDeath implements Listener {
    @EventHandler
    public void on(PlayerDeathEvent event) {

        Player player = event.getEntity();

        boolean isNotAfterMode = !Objects.equals(preventLoadWorldMode, "after");

        if (isNotAfterMode) {
            return;
        }

        player.setHealth(player.getMaxHealth() - 1);
        onPlayerDeath(player, false);


    }
}
