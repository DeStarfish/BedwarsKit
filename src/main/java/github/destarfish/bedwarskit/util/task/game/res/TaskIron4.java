


















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class TaskIron4 {
    private static final ConcurrentHashMap<String, Integer> taskTimeLeftMap = new ConcurrentHashMap<>();

    public static void setTaskTimeLeft(String gameName, int timeLeft) {
        taskTimeLeftMap.put(gameName, timeLeft);
    }

    public static int getTaskTimeLeft(String gameName) {
        return taskTimeLeftMap.getOrDefault(gameName, 0);
    }

    public static void runTask(Game game) {
        String gameName = game.getName();
        int gameTaskTime = gametask_spawntime_tasks_iron4;

        new BukkitRunnable() {
            private int taskTimeLeft = gameTaskTime;

            @Override
            public void run() {


                if (game.getState() != GameState.RUNNING || game.getCycle().isEndGameRunning()) {
                    cancel();
                }

                if (taskTimeLeft > 0) {
                    taskTimeLeft--;
                    setTaskTimeLeft(gameName, taskTimeLeft);
                } else {
                    executeTask(game);
                    notifyPlayers(game);
                    cancel();
                }

            }
        }.runTaskTimer(BedwarsKit.getInstance(), 0L, 20L);
    }

    private static void executeTask(Game game) {
        List<ResourceSpawner> resourceSpawners = game.getResourceSpawners();
        resourceSpawners.stream()
                .filter(Objects::nonNull)
                .forEach(spawner -> spawner.getResources().stream()
                        .filter(item -> item != null && item.getType() == Material.IRON_INGOT)
                        .findFirst()
                        .ifPresent(item -> spawner.setInterval(gametask_spawntime_iron_base)));
    }

    private static void notifyPlayers(Game game) {
        game.getPlayers().stream()
                .filter(Objects::nonNull)
                .filter(Player::isOnline)
                .forEach(player -> {
                    if (!Objects.equals(gametask_mess_iron4_chat, "")) {
                        sendMessage(player, gametask_mess_iron4_chat);
                    }
                    if (!Objects.equals(gametask_mess_iron4_title, "")) {
                        String titleReal = gametask_mess_iron4_title;
                        if (!Objects.equals(gametask_mess_iron4_subtitle, "")) {
                            String subtitleReal = gametask_mess_iron4_subtitle;

                            sendTitle(player, titleReal, subtitleReal);
                        }
                    } else if (!Objects.equals(gametask_mess_iron4_subtitle, "")) {
                        String titleReal = " ";
                        String subtitleReal = gametask_mess_iron4_subtitle;

                        sendTitle(player, titleReal, subtitleReal);
                    }
                    if (!Objects.equals(gametask_mess_iron4_actionbar, "")) {
                        sendActionBar(player, gametask_mess_iron4_actionbar);
                    }
                });
    }
}
