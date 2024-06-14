








/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelChangeWorldFirst implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(PlayerChangedWorldEvent event) {

        if (Bukkit.getPluginManager().getPlugin("MultiWorld") == null) {
            return;
        }

        Player player = event.getPlayer();
        player.getInventory().clear();
    }

}
