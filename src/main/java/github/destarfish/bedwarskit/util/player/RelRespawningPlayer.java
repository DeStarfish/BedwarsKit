






/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelRespawningPlayer {
    private static final Set<UUID> respawningPlayer = Collections.newSetFromMap(new ConcurrentHashMap<>());

    public static boolean isPlayerRespawning(UUID uuid) {
        return respawningPlayer.contains(uuid);
    }

    public static void addRespawningPlayer(UUID uuid) {
        respawningPlayer.add(uuid);
    }

    public static void removeRespawningPlayer(UUID uuid) {
        respawningPlayer.remove(uuid);
    }
}
