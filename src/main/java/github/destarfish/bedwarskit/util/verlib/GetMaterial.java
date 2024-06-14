











/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class GetMaterial extends VersionLib {
    private static final String className = GetMaterial.class.getSimpleName();
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

    public static Material STAINED_GLASS_PANE() {

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getDeclaredMethod("STAINED_GLASS_PANE");

            return (Material) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            le(className, e);
        }

        return null;
    }

    public static Material BED_BLOCK() {

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getDeclaredMethod("BED_BLOCK");

            return (Material) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            le(className, e);
        }

        return null;
    }


    public static Material COMPASS() {

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getDeclaredMethod("COMPASS");

            return (Material) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            le(className, e);
        }

        return null;
    }

    public static Material BED_ITEM() {

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getDeclaredMethod("BED_ITEM");

            return (Material) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            le(className, e);
        }

        return null;
    }

    public static Material WOOD_SWORD() {

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getDeclaredMethod("WOOD_SWORD");

            return (Material) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            le(className, e);
        }

        return null;
    }

    public static Material WOOD_PICKAXE() {

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getDeclaredMethod("WOOD_PICKAXE");

            return (Material) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            le(className, e);
        }

        return null;
    }

    public static Material WOOD_AXE() {

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getDeclaredMethod("WOOD_AXE");

            return (Material) method.invoke(null);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException |
                 InvocationTargetException e) {
            le(className, e);
        }

        return null;
    }

}
