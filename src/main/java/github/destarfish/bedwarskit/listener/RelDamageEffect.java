




















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelDamageEffect implements Listener {
    public static final String bloodModeSingle = "single";
    public static final String bloodModePlayer = "player";
    public static final String bloodModeBox = "box";
    public static final Effect step = Effect.STEP_SOUND;

    @EventHandler(priority = EventPriority.MONITOR)
    public void on(EntityDamageByEntityEvent event) {

        boolean killerIsPlayer = event.getDamager() instanceof Player;
        boolean isPlayer = event.getEntity() instanceof Player;

        if (!isPlayer || !killerIsPlayer) {
            return;
        }

        BedwarsKit plugin = BedwarsKit.getInstance();
        Player killer = (Player) event.getDamager();
        Player player = (Player) event.getEntity();

        double damageOrg = event.getFinalDamage();
        double damage = roundToOneDecimalPlace(damageOrg);

        if (!event.isCancelled()) {
            new BukkitRunnable() {
                public void run() {
                    if (!Objects.equals(damagefb_mess_chat, "")) {
                        killer.sendMessage(t(damagefb_mess_chat).
                                replace("%damage%", damage + ""));
                    }
                    if (!Objects.equals(damagefb_mess_title, "")) {
                        String titleReal = t(damagefb_mess_title).
                                replace("%damage%", damage + "");
                        if (!Objects.equals(damagefb_mess_subTitle, "")) {
                            String subtitleReal = t(damagefb_mess_subTitle).
                                    replace("%damage%", damage + "");

                            sendTitle(killer, titleReal, subtitleReal, 0, 20, 5);
                        }
                    } else if (!Objects.equals(damagefb_mess_subTitle, "")) {
                        String titleReal = " ";
                        String subtitleReal = t(damagefb_mess_subTitle).
                                replace("%damage%", damage + "");

                        sendTitle(killer, titleReal, subtitleReal, 0, 20, 5);
                    }
                    if (!Objects.equals(damagefb_mess_actionbar, "")) {
                        sendActionBar(killer, t(damagefb_mess_actionbar).
                                replace("%damage%", damage + ""));
                    }
                }
            }.runTask(plugin);

            if (damagefb_blood) {
                new BukkitRunnable() {
                    private final Material partType = damagefb_bloodType;

                    @Override
                    public void run() {
                        Location damagedPlayerLocation = player.getLocation();
                        switch (damagefb_bloodMode.toLowerCase()) {
                            case bloodModeSingle: {
                                killer.playEffect(damagedPlayerLocation, step, partType);
                            }
                            break;
                            case bloodModePlayer: {
                                killer.playEffect(damagedPlayerLocation, step, partType);
                                killer.playEffect(damagedPlayerLocation.add(1, 0, 0), step, partType);
                            }
                            break;
                            case bloodModeBox: {
                                for (int x = -1; x <= 1; x++) {
                                    for (int y = -1; y <= 1; y++) {
                                        for (int z = -1; z <= 1; z++) {
                                            Location tempLocation = damagedPlayerLocation.clone().add(x, y, z);
                                            killer.playEffect(tempLocation, step, partType);
                                        }
                                    }
                                }
                            }
                            break;
                            default: {
                            }
                            break;
                        }
                    }
                }.runTask(plugin);
            }
        }
    }
}
