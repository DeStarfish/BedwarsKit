










/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelDeathFirst implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(PlayerDeathEvent event) {

        Player player = event.getEntity();

        if (!preventLoadWorld) {
            if (deathGameMode) {
                if (deathGameMode_instantRepsawn) {
                    player.spigot().respawn();
                }
                onPlayerDeath(player, false);
            }
        }

    }
}
