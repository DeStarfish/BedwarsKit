




















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class TaskResEmerald {
    private final GameState running = GameState.RUNNING;
    private final Game game;
    private final World world;
    private int resTime;
    private boolean isRunning;

    public TaskResEmerald(Game game) {
        this.game = game;
        this.world = game.getRegion().getWorld();
        this.isRunning = false;
        this.resTime = 0;
    }

    public void runTask() {
        for (ResourceSpawner resourceSpawner : game.getResourceSpawners()) {
            if (resourceSpawner.getResources().get(0).getType() == Material.EMERALD) {
                Location resOrgLoc = resourceSpawner.getLocation();

                runCountDownTask(resourceSpawner);
                BedwarsKit plugin = BedwarsKit.getInstance();
                if (resBlock_Emerald) {
                    Location location = resOrgLoc.clone().add(0, resBlock_Emerald_y, 0);

                    ArmorStand armorStand = world.spawn(location, ArmorStand.class);
                    armorStand.setGravity(false);
                    armorStand.setCanPickupItems(false);
                    armorStand.setVisible(false);
                    ItemStack item = new ItemStack(Material.EMERALD_BLOCK);

                    armorStand.setHelmet(item);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            GameCycle gameCycle = game.getCycle();

                            if (gameCycle.isEndGameRunning() || game.getState() != running) {
                                if (isDebug()) {
                                    l("is run = false,remove Emerald Block entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setSmall(resBlock_Emerald_isSmall);

                            float angle = plugin.getArmorStandAngle();

                            Location currentLocation = armorStand.getLocation();
                            currentLocation.setYaw(angle);
                            armorStand.teleport(currentLocation);

                        }
                    }.runTaskTimer(plugin, 0L, resBlock_spinSpeed);


                }

                if (!Objects.equals(resText1_Emerald, "")) {
                    Location location = resOrgLoc.clone().add(0, resText1_Emerald_y, 0);
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
                                    l("is run = false,remove Emerald Text1 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }
                            armorStand.setCustomName(t(resText1_Emerald.replace("%s%", resTime + "")));
                        }
                    }.runTaskTimer(plugin, 0L, 20L);
                }
                if (!Objects.equals(resText2_Emerald, "")) {

                    Location location = resOrgLoc.clone().add(0, resText2_Emerald_y, 0);
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
                                    l("is run = false,remove Emerald Text2 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setCustomName(t(resText2_Emerald.replace("%s%", resTime + "")));

                        }
                    }.runTaskTimer(plugin, 0L, 20L);
                }
                if (!Objects.equals(resText3_Emerald, "")) {

                    Location location = resOrgLoc.clone().add(0, resText3_Emerald_y, 0);
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
                                    l("is run = false,remove Emerald Text3 entity");
                                }
                                armorStand.remove();
                                cancel();
                            }

                            armorStand.setCustomName(t(resText3_Emerald.replace("%s%", resTime + "")));
                        }
                    }.runTaskTimer(plugin, 0L, 20L);
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
