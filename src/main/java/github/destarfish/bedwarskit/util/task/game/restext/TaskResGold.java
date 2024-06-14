




















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class TaskResGold {
    private final GameState running = GameState.RUNNING;
    private final Game game;
    private final World world;
    private int resTime;
    private boolean isRunning;

    public TaskResGold(Game game) {
        this.game = game;
        this.world = game.getRegion().getWorld();
        this.isRunning = false;
        this.resTime = 0;
    }

    public void runTask() {
        for (ResourceSpawner resourceSpawner : game.getResourceSpawners()) {
            if (resourceSpawner.getResources().get(0).getType() == Material.GOLD_INGOT) {
                Location resOrgLoc = resourceSpawner.getLocation();

                runCountDownTask(resourceSpawner);
                if (resBlock_Gold) {
                    Location location = resOrgLoc.clone().add(0, resBlock_Gold_y, 0);

                    ArmorStand armorStand = world.spawn(location, ArmorStand.class);
                    armorStand.setGravity(false);
                    armorStand.setCanPickupItems(false);
                    armorStand.setVisible(false);
                    ItemStack item = new ItemStack(Material.GOLD_BLOCK);

                    armorStand.setHelmet(item);

                    new BukkitRunnable() {
                        float angle = 0;

                        @Override
                        public void run() {
                            GameCycle gameCycle = game.getCycle();

                            if (gameCycle.isEndGameRunning() || game.getState() != running) {
                                if (isDebug()) {
                                    l("is run = false,remove Gold Block entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setSmall(resBlock_Gold_isSmall);

                            angle = BedwarsKit.getInstance().getArmorStandAngle();


                            Location currentLocation = armorStand.getLocation();
                            currentLocation.setYaw(angle);
                            armorStand.teleport(currentLocation);

                        }
                    }.runTaskTimer(BedwarsKit.getInstance(), 0L, resBlock_spinSpeed);


                }
                if (!Objects.equals(resText1_Gold, "")) {
                    Location location = resOrgLoc.clone().add(0, resText1_Gold_y, 0);
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
                                    l("is run = false,remove Gold Text1 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }
                            armorStand.setCustomName(t(resText1_Gold.replace("%s%", resTime + "")));
                        }
                    }.runTaskTimer(BedwarsKit.getInstance(), 0L, 20L);
                }
                if (!Objects.equals(resText2_Gold, "")) {

                    Location location = resOrgLoc.clone().add(0, resText2_Gold_y, 0);
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
                                    l("is run = false,remove Gold Text2 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setCustomName(t(resText2_Gold.replace("%s%", resTime + "")));

                        }
                    }.runTaskTimer(BedwarsKit.getInstance(), 0L, 20L);
                }
                if (!Objects.equals(resText3_Gold, "")) {

                    Location location = resOrgLoc.clone().add(0, resText3_Gold_y, 0);
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
                                    l("is run = false,remove Gold Text3 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setCustomName(t(resText3_Gold.replace("%s%", resTime + "")));
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
