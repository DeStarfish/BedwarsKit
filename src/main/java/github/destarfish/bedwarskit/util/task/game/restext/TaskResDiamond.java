




















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class TaskResDiamond {
    private final Game game;
    private final World world;
    private final GameState running = GameState.RUNNING;
    private int resTime;
    private boolean isRunning;

    public TaskResDiamond(Game game) {
        this.game = game;
        this.world = game.getRegion().getWorld();
        this.isRunning = false;
        this.resTime = 0;
    }

    public void runTask() {
        for (ResourceSpawner resourceSpawner : game.getResourceSpawners()) {
            if (resourceSpawner.getResources().get(0).getType() == Material.DIAMOND) {
                Location resOrgLoc = resourceSpawner.getLocation();

                runCountDownTask(resourceSpawner);
                if (resBlock_Diamond) {
                    Location location = resOrgLoc.clone().add(0, resBlock_Diamond_y, 0);

                    ArmorStand armorStand = world.spawn(location, ArmorStand.class);
                    armorStand.setGravity(false);
                    armorStand.setCanPickupItems(false);
                    armorStand.setVisible(false);
                    ItemStack item = new ItemStack(Material.DIAMOND_BLOCK);

                    armorStand.setHelmet(item);

                    new BukkitRunnable() {
                        float angle = 0;

                        @Override
                        public void run() {
                            GameCycle gameCycle = game.getCycle();

                            if (gameCycle.isEndGameRunning() || game.getState() != running) {
                                if (isDebug()) {
                                    l("is run = false,remove Diamond Block entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setSmall(resBlock_Diamond_isSmall);

                            angle = BedwarsKit.getInstance().getArmorStandAngle();


                            Location currentLocation = armorStand.getLocation();
                            currentLocation.setYaw(angle);
                            armorStand.teleport(currentLocation);

                        }
                    }.runTaskTimer(BedwarsKit.getInstance(), 0L, resBlock_spinSpeed);


                }
                if (!Objects.equals(resText1_Diamond, "")) {
                    Location location = resOrgLoc.clone().add(0, resText1_Diamond_y, 0);
                    ArmorStand armorStand = world.spawn(location, ArmorStand.class);
                    armorStand.setGravity(false);
                    armorStand.setCanPickupItems(false);
                    armorStand.setVisible(false);
                    armorStand.setCustomNameVisible(true);
                    armorStand.setMarker(true);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            GameCycle gameCycle = game.getCycle();

                            if (gameCycle.isEndGameRunning() || game.getState() != running) {
                                if (isDebug()) {
                                    l("is run = false,remove Diamond Text1 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }
                            armorStand.setCustomName(t(resText1_Diamond.replace("%s%", resTime + "")));
                        }
                    }.runTaskTimer(BedwarsKit.getInstance(), 0L, 20L);
                }
                if (!Objects.equals(resText2_Diamond, "")) {

                    Location location = resOrgLoc.clone().add(0, resText2_Diamond_y, 0);
                    ArmorStand armorStand = world.spawn(location, ArmorStand.class);
                    armorStand.setGravity(false);
                    armorStand.setCanPickupItems(false);
                    armorStand.setVisible(false);
                    armorStand.setCustomNameVisible(true);
                    armorStand.setMarker(true);

                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            GameCycle gameCycle = game.getCycle();

                            if (gameCycle.isEndGameRunning() || game.getState() != running) {
                                if (isDebug()) {
                                    l("is run = false,remove Diamond Text2 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setCustomName(t(resText2_Diamond.replace("%s%", resTime + "")));

                        }
                    }.runTaskTimer(BedwarsKit.getInstance(), 0L, 20L);
                }
                if (!Objects.equals(resText3_Diamond, "")) {

                    Location location = resOrgLoc.clone().add(0, resText3_Diamond_y, 0);
                    ArmorStand armorStand = world.spawn(location, ArmorStand.class);
                    armorStand.setGravity(false);
                    armorStand.setCanPickupItems(false);
                    armorStand.setVisible(false);
                    armorStand.setCustomNameVisible(true);
                    armorStand.setMarker(true);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            GameCycle gameCycle = game.getCycle();

                            if (gameCycle.isEndGameRunning() || game.getState() != running) {
                                if (isDebug()) {
                                    l("is run = false,remove Diamond Text3 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setCustomName(t(resText3_Diamond.replace("%s%", resTime + "")));
                        }
                    }.runTaskTimer(BedwarsKit.getInstance(), 0L, 20L);
                }

            }
        }
    }

    private void runCountDownTask(ResourceSpawner resourceSpawner) {
        if (!isRunning) {
            isRunning = true;

            resTime = resourceSpawner.getInterval() / 1000;
            new BukkitRunnable() {

                @Override
                public void run() {

                    GameCycle gameCycle = game.getCycle();

                    if (gameCycle.isEndGameRunning() || game.getState() != running) {
                        cancel();
                    }

                    resTime = resTime - 1;

                    if (resTime <= 0) {
                        resTime = resourceSpawner.getInterval() / 1000;
                    }

                }
            }.runTaskTimer(BedwarsKit.getInstance(), 0L, 20L);
        }
    }
}
