











/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelRespawnFirst implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(PlayerRespawnEvent event) {

        Player player = event.getPlayer();

        if (!preventLoadWorld) {
            if (deathGameMode) {
                player.setGameMode(GameMode.SPECTATOR);
            }
        }
    }
}
