









/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class DisableAI {
    public static void disableAI(String worldName) {
        if (worldName == null) {
            return;
        }

        World world = Bukkit.getWorld(worldName);
        if (world == null) {
            return;
        }

        List<Entity> entities = world.getEntities();
        for (Entity entity : entities) {
            if (entity instanceof Villager) {
                Villager villager = (Villager) entity;
                villager.setAI(false);
            }
        }
    }
}
