









/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelMobGriefing implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final EntityChangeBlockEvent event) {
        if (!noEndermanGriefing) {
            return;
        }

        boolean isEnderMan = event.getEntity() instanceof Enderman;

        if (!isEnderMan) {
            return;
        }

        event.setCancelled(true);

    }
}
