












/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class SendTitleHelper extends VersionLib {
    private static final String className = SendTitleHelper.class.getSimpleName();
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

    private static void sendTitl(Player player, String title, String subTitle, int fadeIn, int stay, int fadeOut) {

        if (title != null) {
            title = t(title);
        }
        if (subTitle != null) {
            subTitle = t(subTitle);
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getMethod("sendTitle", Player.class, String.class, String.class, int.class, int.class, int.class);

            method.invoke(null, player, title, subTitle, fadeIn, stay, fadeOut);

        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException |
                 IllegalAccessException e) {
            le(className, e);
        }
    }

    private static void sendTitl(Player player, String title, String subTitle) {

        if (title != null) {
            title = t(title);
        }
        if (subTitle != null) {
            subTitle = t(subTitle);
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Method method = aClass.getMethod("sendTitle", Player.class, String.class, String.class);

            method.invoke(null, player, title, subTitle);

        } catch (NoSuchMethodException | ClassNotFoundException | InvocationTargetException |
                 IllegalAccessException e) {
            le(className, e);
        }
    }

    public static void sendTitle(Player player, String title, String subtitle) {
        sendTitl(player, title, subtitle);
    }

    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        sendTitl(player, title, subtitle, 3, 10, 5);
    }
}
