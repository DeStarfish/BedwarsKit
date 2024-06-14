














/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class BedwarsKit extends JavaPlugin {
    @Getter
    private static BedwarsKit instance;
    @Getter
    private final String versionPackage = "github.destarfish.bedwarskit.com.";
    @Getter
    private PluginInit pluginInit;
    @Getter
    private float armorStandAngle;
    @Getter
    private RelScoreBoard relScoreBoard;
    @Getter
    private RelRejoinHandler rejoinHandler;
    @Getter
    private String itemO = "o";
    @Getter
    private String stateOkLeft = "\u2588\u2587\u2586\u2585\u2584\u2583\u2582\u2581";
    @Getter
    private String stateOkRight = "\u2581\u2582\u2583\u2584\u2585\u2586\u2587\u2588";
    @Getter
    @Setter
    private ItemJoinAPI itemJoinAPI;

    @Override
    public final void onEnable() {
        instance = this;

        pluginInit = new PluginInit(this);

        relScoreBoard = new RelScoreBoard(this);
        rejoinHandler = new RelRejoinHandler(this);

        startTimerTasks();
    }

    @Override
    public final void onDisable() {
        pluginInit.onShutdown();
    }

    private void startTimerTasks() {

        new BukkitRunnable() {
            @Override
            public void run() {

                if (armorStandAngle + resBlock_yawPerTick >= 360) {
                    armorStandAngle = armorStandAngle + resBlock_yawPerTick - 360;
                } else {
                    armorStandAngle += resBlock_yawPerTick;
                }
            }
        }.runTaskTimerAsynchronously(this, 80L, 1L);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (Objects.equals(itemO, "o")) {
                    itemO = "0";
                } else if (Objects.equals(itemO, "0")) {
                    itemO = "o";
                }
            }
        }.runTaskTimerAsynchronously(this, 80L, 20L);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (Objects.equals(stateOkLeft, "\u2588\u2587\u2586\u2585\u2584\u2583\u2582\u2581")) {
                    stateOkLeft = "\u2587\u2586\u2585\u2584\u2583\u2582\u2581\u2588";
                } else if (Objects.equals(stateOkLeft, "\u2587\u2586\u2585\u2584\u2583\u2582\u2581\u2588")) {
                    stateOkLeft = "\u2586\u2585\u2584\u2583\u2582\u2581\u2588\u2587";
                } else if (Objects.equals(stateOkLeft, "\u2586\u2585\u2584\u2583\u2582\u2581\u2588\u2587")) {
                    stateOkLeft = "\u2585\u2584\u2583\u2582\u2581\u2588\u2587\u2586";
                } else if (Objects.equals(stateOkLeft, "\u2585\u2584\u2583\u2582\u2581\u2588\u2587\u2586")) {
                    stateOkLeft = "\u2584\u2583\u2582\u2581\u2588\u2587\u2586\u2585";
                } else if (Objects.equals(stateOkLeft, "\u2584\u2583\u2582\u2581\u2588\u2587\u2586\u2585")) {
                    stateOkLeft = "\u2583\u2582\u2581\u2588\u2587\u2586\u2585\u2584";
                } else if (Objects.equals(stateOkLeft, "\u2583\u2582\u2581\u2588\u2587\u2586\u2585\u2584")) {
                    stateOkLeft = "\u2582\u2581\u2588\u2587\u2586\u2585\u2584\u2583";
                } else if (Objects.equals(stateOkLeft, "\u2582\u2581\u2588\u2587\u2586\u2585\u2584\u2583")) {
                    stateOkLeft = "\u2581\u2588\u2587\u2586\u2585\u2584\u2583\u2582";
                } else if (Objects.equals(stateOkLeft, "\u2581\u2588\u2587\u2586\u2585\u2584\u2583\u2582")) {
                    stateOkLeft = "\u2588\u2587\u2586\u2585\u2584\u2583\u2582\u2581";
                }
            }
        }.runTaskTimerAsynchronously(this, 80L, 1L);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (Objects.equals(stateOkRight, "\u2581\u2582\u2583\u2584\u2585\u2586\u2587\u2588")) {
                    stateOkRight = "\u2588\u2581\u2582\u2583\u2584\u2585\u2586\u2587";
                } else if (Objects.equals(stateOkRight, "\u2588\u2581\u2582\u2583\u2584\u2585\u2586\u2587")) {
                    stateOkRight = "\u2587\u2588\u2581\u2582\u2583\u2584\u2585\u2586";
                } else if (Objects.equals(stateOkRight, "\u2587\u2588\u2581\u2582\u2583\u2584\u2585\u2586")) {
                    stateOkRight = "\u2586\u2587\u2588\u2581\u2582\u2583\u2584\u2585";
                } else if (Objects.equals(stateOkRight, "\u2586\u2587\u2588\u2581\u2582\u2583\u2584\u2585")) {
                    stateOkRight = "\u2585\u2586\u2587\u2588\u2581\u2582\u2583\u2584";
                } else if (Objects.equals(stateOkRight, "\u2585\u2586\u2587\u2588\u2581\u2582\u2583\u2584")) {
                    stateOkRight = "\u2584\u2585\u2586\u2587\u2588\u2581\u2582\u2583";
                } else if (Objects.equals(stateOkRight, "\u2584\u2585\u2586\u2587\u2588\u2581\u2582\u2583")) {
                    stateOkRight = "\u2583\u2584\u2585\u2586\u2587\u2588\u2581\u2582";
                } else if (Objects.equals(stateOkRight, "\u2583\u2584\u2585\u2586\u2587\u2588\u2581\u2582")) {
                    stateOkRight = "\u2582\u2583\u2584\u2585\u2586\u2587\u2588\u2581";
                } else if (Objects.equals(stateOkRight, "\u2582\u2583\u2584\u2585\u2586\u2587\u2588\u2581")) {
                    stateOkRight = "\u2581\u2582\u2583\u2584\u2585\u2586\u2587\u2588";
                }
            }
        }.runTaskTimerAsynchronously(this, 80L, 1L);
    }
}