






/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelArmorList {
    private static final Set<UUID> armorChain;
    private static final Set<UUID> armorIron;
    private static final Set<UUID> armorDiamond;

    static {
        armorChain = Collections.newSetFromMap(new ConcurrentHashMap<>());
        armorIron = Collections.newSetFromMap(new ConcurrentHashMap<>());
        armorDiamond = Collections.newSetFromMap(new ConcurrentHashMap<>());
    }

    public static Set<UUID> getArmorChain() {
        return armorChain;
    }

    public static Set<UUID> getArmorDiamond() {
        return armorDiamond;
    }

    public static Set<UUID> getArmorIron() {
        return armorIron;
    }

    public static void addArmorChain(UUID uuid) {
        armorChain.add(uuid);
    }

    public static boolean hasArmorChain(UUID uuid) {
        return armorChain.contains(uuid);
    }

    public static void removeArmorChain(UUID uuid) {
        armorChain.remove(uuid);
    }

    public static void addArmorIron(UUID uuid) {
        armorIron.add(uuid);
    }

    public static boolean hasArmorIron(UUID uuid) {
        return armorIron.contains(uuid);
    }

    public static void removeArmorIron(UUID uuid) {
        armorIron.remove(uuid);
    }

    public static void addArmorDiamond(UUID uuid) {
        armorDiamond.add(uuid);
    }

    public static boolean hasArmorDiamond(UUID uuid) {
        return armorDiamond.contains(uuid);
    }

    public static void removeArmorDiamond(UUID uuid) {
        armorDiamond.remove(uuid);
    }
}