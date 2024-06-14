












/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class SoundPlayer extends VersionLib {
    private static final String className = SoundPlayer.class.getSimpleName();
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

    public static void CLICK(Player player, int pitch) {

        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("CLICK");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

    public static void VILLAGER_YES(Player player, int pitch) {

        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("VILLAGER_YES");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

    public static void ZOMBIE_INFECT(Player player, int pitch) {
        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("ZOMBIE_INFECT");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

    public static void PLAYER_HURT(Player player, int pitch) {
        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("PLAYER_HURT");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

    public static void LEVEL_UP(Player player, int pitch) {
        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("LEVEL_UP");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

    public static void ITEM_PICKUP(Player player, int pitch) {
        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("ITEM_PICKUP");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

    public static void ITEM_BREAK(Player player, int pitch) {
        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("ITEM_BREAK");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

    public static void CHICKEN_EGG_POP(Player player, int pitch) {
        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("CHICKEN_EGG_POP");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

    public static void ENDERMAN_TELEPORT(Player player, int pitch) {
        if (player == null) {
            return;
        }

        try {
            String className = getClassName();

            Class<?> aClass = Class.forName(BASE_PACKAGE + className);

            Field field = aClass.getField("ENDERMAN_TELEPORT");

            Sound sound = (Sound) field.get(null);

            Location location = player.getLocation();
            player.playSound(location, sound, 1, pitch);

        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            le(className, e);
        }
    }

}
