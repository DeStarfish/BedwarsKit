
































/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class BaseCommand implements CommandExecutor {
    public static final BedwarsKit plugin = BedwarsKit.getInstance();
    private final String className = getClass().getSimpleName();

    private void showDebugInfo(CommandSender sender) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            String playerName = player.getName();
            UUID playerUUID = player.getUniqueId();
            l("[State] showing debug info for " + playerName);
            sendMessage(player, "BedwarsKit Current: ");

            {
                sendMessage(player, "&a------------------ ");
                sendMessage(player, "Is You Editing Player: ");

                String willSend = "" + RelEditGame.isEditPlayer(playerUUID);
                sendMessage(player, willSend);
            }


            sendMessage(player, "&a------------------ ");
            sendMessage(player, "Reg listeners: ");
            for (Listener listener : PluginState.getRegListners()) {
                String willSend = listener.toString();
                sendMessage(player, willSend);
            }


            sendMessage(player, "&a------------------ ");
            sendMessage(player, "RelPlayerKit map: ");
            if (getPlayerKitList() == null) {
                String willSend = "getPlayerKitList() == null";
                sendMessage(player, willSend);
            } else {
                ConcurrentHashMap<UUID, String> playerKitList = getPlayerKitList();
                for (Map.Entry<UUID, String> entry : playerKitList.entrySet()) {
                    UUID key = entry.getKey();
                    String value = entry.getValue();
                    Player mapPlayer = Bukkit.getPlayer(key);
                    if (mapPlayer != null) {
                        String name = mapPlayer.getName();
                        String willSend = key + "(" + name + ")" + ": " + value;
                        sendMessage(player, willSend);
                    } else {
                        le(className, "Bukkit.getPlayer( " + key + " ) == null, cant get the name of player");
                    }
                }
            }

            sendMessage(player, "&a------------------ ");
            sendMessage(player, "RelArmorList armorChain: ");
            for (UUID a : RelArmorList.getArmorChain()) {
                String name = Bukkit.getPlayer(a).getName();
                String willSend = a.toString() + "(" + name + ")";
                sendMessage(player, willSend);
            }

            sendMessage(player, "RelArmorList armorIron: ");
            for (UUID a : RelArmorList.getArmorIron()) {
                String name = Bukkit.getPlayer(a).getName();
                String willSend = a.toString() + "(" + name + ")";
                sendMessage(player, willSend);
            }

            sendMessage(player, "RelArmorList armorDiamond: ");
            for (UUID a : RelArmorList.getArmorDiamond()) {
                String name = Bukkit.getPlayer(a).getName();
                String willSend = a.toString() + "(" + name + ")";
                sendMessage(player, willSend);
            }


        } else {
            l("Use /bwk as a player to see debug info");
        }

    }

    private void reloadConfig(CommandSender sender) {
        PluginInit pluginInit = plugin.getPluginInit();
        MainConfigLoad mainConfigLoad = pluginInit.getMainConfigLoad();
        mainConfigLoad.loadConfig(sender, false);
    }

    private void toggleDebug(CommandSender sender) {
        PluginState.toggleDebug();
        if (isDebug()) {
            l("&e======= &fBedwarsKit Debug Start &e=======");
            sendMessage(sender, meanDebugEnable);
        } else {
            sendMessage(sender, meanDebugDisable);
            l("&e======= &fBedwarsKit Debug End &e=======");
        }
    }


    private void showHelpMess(CommandSender sender) {
        if (command_help == null) {
            sender.sendMessage(green + msgline);
            showFallBackHelpMsg(sender);
            sender.sendMessage(green + msgline);
        } else {
            for (String s : command_help) {
                sendMessage(sender, s);
            }
        }
    }

    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args) {

        boolean senderIsPlayer = sender instanceof Player;
        boolean senderIsOp = sender.isOp();

        if (senderIsPlayer) {
            Player player = (Player) sender;
            if (senderIsOp) {
                if (args.length > 0) {
                    String s0 = args[0];
                    if (s0.equalsIgnoreCase("reload")) {
                        reloadConfig(sender);
                        return true;
                    } else if (s0.equalsIgnoreCase("debug")) {
                        toggleDebug(sender);
                        return true;
                    } else if (s0.equalsIgnoreCase("edit")) {
                        toggleEdit(player);
                        return true;
                    } else if (s0.equalsIgnoreCase("info")) {
                        showPluginInfo(player);
                        return true;
                    } else if (s0.equalsIgnoreCase("uinfo")) {
                        showUpdateInfo(player);
                        return true;
                    } else if (s0.equalsIgnoreCase("ed")) {
                        showAllError(sender);
                        return true;
                    }
                }

                if (isDebug()) {
                    showDebugInfo(player);
                } else {
                    showHelpMess(player);
                }
            }
        } else {
            if (args.length > 0) {
                String s0 = args[0];
                if (s0.equalsIgnoreCase("reload")) {
                    reloadConfig(sender);
                    return true;
                } else if (s0.equalsIgnoreCase("debug")) {
                    toggleDebug(sender);
                    return true;
                } else if (s0.equalsIgnoreCase("info")) {
                    showPluginInfo(sender);
                    return true;
                } else if (s0.equalsIgnoreCase("edit")) {
                    sendMessage(sender, red + meanCommandIsPlayerOnly);
                    return true;
                } else if (s0.equalsIgnoreCase("uinfo")) {
                    showUpdateInfo();
                    return true;
                } else if (s0.equalsIgnoreCase("ed")) {
                    showAllError(sender);
                    return true;
                }
            }

            if (isDebug()) {
                showDebugInfo(sender);
            } else {
                showHelpMess(sender);
            }

        }
        return true;
    }

}

