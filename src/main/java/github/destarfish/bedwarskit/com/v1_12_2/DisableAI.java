








/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class DisableAI {
    public static void disableAI(String worldName) {
        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            return;
        }

        List<Entity> entities = world.getEntities();
        for (Entity entity : entities) {
            if (entity instanceof CraftVillager) {
                CraftVillager craftVillager = (CraftVillager) entity;
                craftVillager.setAI(false);
            }
        }
    }
}
