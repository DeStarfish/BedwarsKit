










/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelCurrentStat {
    public static final String addKill = "k";
    public static final String addDeath = "d";
    public static final String addBreakBed = "b";
    public static final String addFinalKill = "f";
    public static final String addOneHeathKill = "ohk";
    public static final String setOneHeathKill = "setohk";
    private static final String className = RelCurrentStat.class.getSimpleName();
    private static final ConcurrentHashMap<UUID, Integer> playerKill;
    private static final ConcurrentHashMap<UUID, Integer> playerFKill;
    private static final ConcurrentHashMap<UUID, Integer> playerDeath;
    private static final ConcurrentHashMap<UUID, Integer> playerBreakBed;
    private static final ConcurrentHashMap<UUID, Double> playerKD;
    private static final ConcurrentHashMap<UUID, Integer> playerOHKill;
    private static final Set<UUID> playerIsOut;
    private static final ConcurrentHashMap<String, HashMap<UUID, Integer>> killsMap;

    static {
        playerKill = new ConcurrentHashMap<>(101);
        playerFKill = new ConcurrentHashMap<>(101);
        playerDeath = new ConcurrentHashMap<>(101);
        playerBreakBed = new ConcurrentHashMap<>(101);
        playerKD = new ConcurrentHashMap<>(101);
        playerOHKill = new ConcurrentHashMap<>(101);
        playerIsOut = Collections.newSetFromMap(new ConcurrentHashMap<>());
        killsMap = new ConcurrentHashMap<>(101);
    }

    public static int getPlayerOHKill(UUID uuid) {
        return playerOHKill.get(uuid);
    }

    public static int getPlayerKill(UUID uuid) {
        return playerKill.getOrDefault(uuid, 0);
    }

    public static int getPlayerFinalKill(UUID uuid) {
        return playerFKill.getOrDefault(uuid, 0);
    }

    public static int getPlayerDeath(UUID uuid) {
        return playerDeath.getOrDefault(uuid, 0);
    }

    public static int getPlayerBreakBed(UUID uuid) {
        return playerBreakBed.getOrDefault(uuid, 0);
    }

    public static double getPlayerKD(UUID uuid) {
        return playerKD.getOrDefault(uuid, 0.0);
    }

    public static boolean getPlayerisOut(UUID uuid) {
        return playerIsOut.contains(uuid);
    }

    public static void addPlayerIsOut(UUID uuid) {
        playerIsOut.add(uuid);
    }

    public static void removePlayerIsOut(UUID uuid) {
        playerIsOut.remove(uuid);
    }

    public static void updatePlayerStat(UUID uuid, String pd, int value) {

        switch (pd.toLowerCase()) {
            case addKill: {
                int k = playerKill.get(uuid);
                playerKill.put(uuid, k + value);
            }
            break;
            case addDeath: {
                int d = playerDeath.get(uuid);
                playerDeath.put(uuid, d + value);
            }
            break;
            case addBreakBed: {
                int b = playerBreakBed.get(uuid);
                playerBreakBed.put(uuid, b + value);
            }
            break;
            case addFinalKill: {
                int f = playerFKill.get(uuid);
                playerFKill.put(uuid, f + value);
            }
            break;
            case addOneHeathKill: {
                int ohk = playerOHKill.getOrDefault(uuid, 0);
                playerOHKill.put(uuid, ohk + value);
            }
            break;
            case setOneHeathKill: {
                playerOHKill.put(uuid, value);
            }
            break;
            default: {
                sendError(pd);
            }
            break;
        }


        int kills = playerKill.getOrDefault(uuid, 0);
        int deaths = playerDeath.getOrDefault(uuid, 0);
        double kd = deaths != 0 ? kills / (double) deaths : kills;
        playerKD.put(uuid, kd);

    }

    public static void removePlayerStat(UUID uuid) {

        playerKill.remove(uuid);
        playerFKill.remove(uuid);
        playerDeath.remove(uuid);
        playerBreakBed.remove(uuid);
        playerKD.remove(uuid);
        playerOHKill.remove(uuid);

    }

    public static void setDefaultPlayerStat(UUID uuid) {

        playerKill.put(uuid, 0);
        playerFKill.put(uuid, 0);
        playerDeath.put(uuid, 0);
        playerBreakBed.put(uuid, 0);
        playerKD.put(uuid, 0.0);
        playerOHKill.put(uuid, 0);

    }

    private static void sendError(String pd) {

        le(className, "updatePlayerStat" + " error: pd : "
                + pd + vauleIsWrong);

    }

    public static void onGameStart(Game game) {
        String gameName = game.getName();
        HashMap<UUID, Integer> map = new HashMap<>();

        ArrayList<Player> players = game.getPlayers();

        players.removeAll(game.getFreePlayers());

        for (Player player : players) {
            map.put(player.getUniqueId(), 0);
        }
        killsMap.put(gameName, map);

    }


    public static void onGameOver(Game game) {
        String gameName = game.getName();
        killsMap.remove(gameName);
    }

    public static void onPlayerLeave(UUID uuid, Game game) {
        String gameName = game.getName();
        int i = getPlayerKill(uuid) + getPlayerFinalKill(uuid);
        HashMap<UUID, Integer> map = killsMap.get(gameName);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(uuid, i);
        killsMap.put(gameName, map);
    }

    public static void updateKillsMapForGame(UUID uuid, Game game) {
        String gameName = game.getName();
        int i = getPlayerKill(uuid) + getPlayerFinalKill(uuid);
        HashMap<UUID, Integer> map = killsMap.get(gameName);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(uuid, i);
        killsMap.put(gameName, map);
    }


    public static HashMap<UUID, Integer> getKillsMapByGame(Game game) {
        String gameName = game.getName();
        HashMap<UUID, Integer> willSend;
        if (killsMap.get(gameName) == null) {
            willSend = new HashMap<>();
        } else {
            willSend = killsMap.get(gameName);
        }
        return willSend;
    }

}
