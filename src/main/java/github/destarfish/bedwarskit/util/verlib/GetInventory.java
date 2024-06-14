














/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class GetInventory extends VersionLib {
    private static final String className = GetInventory.class.getSimpleName();
    private static final Map<String, String> classMap = Collections.unmodifiableMap(new HashMap<String, String>() {
        {
            put("1.8", c1_8);
            put("1.12", c1_8);
            put("1.11", c1_8);
            put("1.10", c1_8);
            put("1.9", c1_8);
            put("1.16", c1_16);
            put("1.15", c1_16);
            put("1.14", c1_16);
            put("1.13", c1_16);
        }

        @Override
        public HashMap<String, String> clone() throws AssertionError {
            throw new AssertionError();
        }
    });

    private static @NotNull String getClassName() {
        for (Map.Entry<String, String> entry : classMap.entrySet()) {
            if (version.contains(entry.getKey())) {
                return entry.getValue() + className;
            }
        }

        return c1_16 + className;
    }

    public static String getInvTitle(Inventory inventory) {
        if (inventory == null) {
            return null;
        }

        try {
            String name = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + name);

            Method method = aClass.getMethod("getInvTitle", Inventory.class);

            return (String) method.invoke(null, inventory);
        } catch (IllegalArgumentException | SecurityException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException | ClassNotFoundException e) {
            le(className, e);
        }
        return null;
    }

    @Nullable
    public static InventoryType getInvType(Inventory inventory) {
        if (inventory == null) {
            return null;
        }

        try {
            String name = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + name);

            Method method = aClass.getMethod("getInvType", Inventory.class);

            return (InventoryType) method.invoke(null, inventory);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException |
                 ClassNotFoundException e) {
            le(className, e);
        }
        return null;
    }
}
