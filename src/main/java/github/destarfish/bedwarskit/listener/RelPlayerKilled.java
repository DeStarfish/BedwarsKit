





























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlayerKilled implements Listener {
    private static final String className = RelPlayerKilled.class.getSimpleName();
    private static final BedwarsKit plugin = BedwarsKit.getInstance();
    private static final Material ironIngot = Material.IRON_INGOT;
    private static final Material goldIngot = Material.GOLD_INGOT;
    private static final Material diamond = Material.DIAMOND;
    private static final Material emerald = Material.EMERALD;
    private static final Material bed_block = GetMaterial.BED_BLOCK();

    private String replaceString(
            String text,
            String kName,
            String dName,
            String kHealth,
            String dHealth,
            String ohk
    ) {
        return text
                .replace("%kName%", kName)
                .replace("%dName%", dName)
                .replace("%kHealth%", kHealth)
                .replace("%dHealth%", dHealth)
                .replace("%ohk%", ohk)

                ;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void on(final BedwarsPlayerKilledEvent event) {

        if (event.getKiller() == null
                || event.getPlayer() == null
                || event.getKiller() == event.getPlayer()
        ) {
            return;
        }
        if (!event.getKiller().isOnline()) {
            return;
        }

        if (event.getGame() == null) {
            return;
        }

        if (bed_block == null) {
            le(className, "bed_block mat is null");
            return;
        }


        Game game = event.getGame();


        Player d = event.getPlayer();
        String dName = d.getName();
        UUID duuid = d.getUniqueId();
        String dHealth = d.getHealth() + "";
        PlayerInventory dpi = d.getInventory();
        updatePlayerStat(duuid, addDeath, 1);
        updatePlayerStat(duuid, setOneHeathKill, 0);

        Player k = event.getKiller();
        if (k != null) {
            String kName = k.getName();
            UUID kuuid = k.getUniqueId();
            String kHealth = k.getHealth() + "";
            PlayerInventory kpi = k.getInventory();

            if (game.getPlayerTeam(d).getHeadTarget() == null
                    || game.getPlayerTeam(d).getHeadTarget().getType() != bed_block) {
                updatePlayerStat(kuuid, addFinalKill, 1);
                SoundPlayer.LEVEL_UP(k, 1);
            } else {
                updatePlayerStat(kuuid, addKill, 1);
            }

            if (killfb_oneHealthKill) {

                updatePlayerStat(kuuid, addOneHeathKill, 1);

                if (getPlayerOHKill(kuuid) > 1) {
                    PlayerInventory pi = k.getInventory();
                    ItemStack fbItem = new ItemStack(killfb_oneHealthKill_itemType);
                    ItemMeta fbItemMeta = fbItem.getItemMeta();
                    fbItemMeta.setDisplayName(t(killfb_oneHealthKill_itemName));
                    fbItem.setItemMeta(fbItemMeta);
                    pi.addItem(fbItem);

                }
            }

            String ohk = getPlayerOHKill(kuuid) + "";


            if (killSeizeResource) {

                int ironCount = 0;
                int goldCount = 0;
                int diamondCount = 0;
                int emeraldCount = 0;

                for (Map.Entry<Integer, ? extends ItemStack> entry : dpi.all(ironIngot).entrySet()) {
                    ItemStack item = entry.getValue();
                    kpi.addItem(item);
                    ironCount = ironCount + item.getAmount();
                }

                for (Map.Entry<Integer, ? extends ItemStack> entry : dpi.all(goldIngot).entrySet()) {
                    ItemStack item = entry.getValue();
                    kpi.addItem(item);
                    goldCount = goldCount + item.getAmount();
                }

                for (Map.Entry<Integer, ? extends ItemStack> entry : dpi.all(diamond).entrySet()) {
                    ItemStack item = entry.getValue();
                    kpi.addItem(item);
                    diamondCount = diamondCount + item.getAmount();
                }

                for (Map.Entry<Integer, ? extends ItemStack> entry : dpi.all(emerald).entrySet()) {
                    ItemStack item = entry.getValue();
                    kpi.addItem(item);
                    emeraldCount = emeraldCount + item.getAmount();
                }

                if (killSeizeResource) {

                    if (!Objects.equals(killSeizeResource_mess_chat, "")) {
                        if (ironCount > 0) {
                            sendMessage(k, replaceKillResMess(killSeizeResource_mess_chat,
                                    meanIron, ironCount, dName, kName)
                            );
                        }
                        if (goldCount > 0) {
                            sendMessage(k, replaceKillResMess(killSeizeResource_mess_chat,
                                    meanGold, goldCount, dName, kName)
                            );
                        }
                        if (diamondCount > 0) {
                            sendMessage(k, replaceKillResMess(killSeizeResource_mess_chat,
                                    meanDiamond, diamondCount, dName, kName)
                            );
                        }

                        if (emeraldCount > 0) {
                            sendMessage(k, replaceKillResMess(killSeizeResource_mess_chat,
                                    meanEmerlad, emeraldCount, dName, kName)
                            );
                        }
                    }
                }


            }

            BedwarsKit plugin = BedwarsKit.getInstance();
            if (isDebug()) {
                le(className, "send killfb_sendmess to " + kName);
                le(className, "killfb_sendmess_title: " + killfb_mess_title);
            }

            new BukkitRunnable() {
                @Override
                public void run() {

                    if (!Objects.equals(killfb_mess_chat, "")) {
                        sendMessage(k, replaceString(killfb_mess_chat, kName, dName, kHealth, dHealth, ohk));
                    }
                    if (!Objects.equals(killfb_mess_title, "")) {
                        String titleReal = replaceString(killfb_mess_title, kName, dName, kHealth, dHealth, ohk);
                        if (!Objects.equals(killfb_mess_subtitle, "")) {
                            String subtitleReal = replaceString(killfb_mess_subtitle, kName, dName, kHealth, dHealth, ohk);

                            sendTitle(k, titleReal, subtitleReal);
                        }
                    } else if (!Objects.equals(killfb_mess_subtitle, "")) {
                        String titleReal = " ";
                        String subtitleReal = replaceString(killfb_mess_subtitle, kName, dName, kHealth, dHealth, ohk);

                        sendTitle(k, titleReal, subtitleReal);
                    }
                    if (!Objects.equals(killfb_mess_actionbar, "")) {
                        sendActionBar(k, replaceString(killfb_mess_actionbar, kName, dName, kHealth, dHealth, ohk));
                    }
                }
            }.runTaskLater(plugin, 1L);

        }


    }

    private String replaceKillResMess(
            String text,
            String resName,
            int count,
            String dName,
            String kName
    ) {

        return text
                .replace("%res%", resName)
                .replace("%count%", "" + count)
                .replace("%dName%", dName)
                .replace("%dName%", kName)
                ;
    }
}
