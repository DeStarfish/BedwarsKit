











/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class GetItemStack extends VersionLib {
    private static final String className = GetItemStack.class.getSimpleName();
    private static final Map<String, String> classMap = Collections.unmodifiableMap(new HashMap<String, String>() {
        {

            put("1.8", c1_8);
            put("1.12", c1_12);
            put("1.11", c1_12);
            put("1.10", c1_12);
            put("1.9", c1_12);
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

    private static String getClassName() {
        for (Map.Entry<String, String> entry : classMap.entrySet()) {
            if (version.contains(entry.getKey())) {
                return entry.getValue() + className;
            }
        }

        return c1_16 + className;
    }

    public static ItemStack GRAY_STAINED_GLASS_PANE() {

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getDeclaredMethod("GRAY_STAINED_GLASS_PANE");

            return (ItemStack) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            le(className, e);
        }

        return null;
    }
}
