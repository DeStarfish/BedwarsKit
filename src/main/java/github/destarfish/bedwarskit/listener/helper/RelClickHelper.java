




















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class RelClickHelper {

    public static void onLobbyClick(PlayerInteractEvent event, Game game, ItemStack itemInHand, Player player) {

        Action action = event.getAction();
        boolean isRightClick = action == Action.RIGHT_CLICK_AIR
                || action == Action.RIGHT_CLICK_BLOCK;

        if (!isRightClick) {
            return;
        }

        event.setCancelled(true);

        ItemMeta meta = itemInHand.getItemMeta();
        Material type = itemInHand.getType();

        String itemName = meta.getDisplayName();

        if (itemName.equalsIgnoreCase(KitMenu.kitMenuItem.getItemMeta().getDisplayName())) {
            openMenu(player);
            return;
        }


        if (lobbyLeaveTeam) {
            if (type == Material.LEATHER_CHESTPLATE) {
                Team team = game.getPlayerTeam(player);

                if (team != null) {
                    onPlayerLeaveTeam(game, player);
                    return;
                }
            }

        }
    }

    private static void onPlayerLeaveTeam(Game game, Player player) {

        boolean isNotBungee = !isBungeeEnabled();
        if (isNotBungee) {
            game.playerLeave(player, false);
            game.playerJoins(player);
        } else {
            if (isDebug()) {
                String itemO = BedwarsKit.getInstance().getItemO();
                sendActionBar(player, "&f&l" + itemO + " &c&lYou Can't leave team while in bungee mode! " + "&f&l" + itemO);
            }
        }
    }


    private static void onGameLeftClick(PlayerInteractEvent event, ItemStack itemInHand, Player player) {

        Action action = event.getAction();
        boolean isLeftClick = action == Action.LEFT_CLICK_AIR
                || action == Action.LEFT_CLICK_BLOCK;

        if (!isLeftClick) {
            return;
        }

        Material itemType = itemInHand.getType();
        if (itemType == null) {
            return;
        }

        String itemTypeText = itemType.toString();

        if (isDebug()) {
            if (itemTypeText.contains("COMPASS")) {
                toggleAlwayHaveGoal();
                sendTitle(player, "[" + isAlwaysHaveAGoal() + "] Toggle AlwayHaveGoal", null);
                event.setCancelled(true);
                return;
            }
        }
    }

    public static void onGameClick(PlayerInteractEvent event, Game game, ItemStack itemInHand, Player player) {

        Action action = event.getAction();
        boolean isRightClick = action == Action.RIGHT_CLICK_AIR
                || action == Action.RIGHT_CLICK_BLOCK;

        if (!isRightClick) {
            if (isDebug()) {
                onGameLeftClick(event, itemInHand, player);
                return;
            }
            return;
        }

        GameCycle cycle = game.getCycle();
        if (cycle.isEndGameRunning()) {
            event.setCancelled(true);
            return;
        }


        String playerName = player.getName();

        Material itemType = itemInHand.getType();
        String itemTypeText = itemType.toString();


        if (dieOutGameItem_playAgain) {
            if (itemTypeText.equals(dieOutGameItem_playAgain_itemType.toString())
                    && itemInHand.getItemMeta().getDisplayName().equals(dieOutGameItem_playAgain_itemName)) {
                String willSend = dieOutGameItem_playAgain_clickSendCommand.
                        replace("%player%", playerName);
                consoleSendCommand(willSend);
                event.setCancelled(true);
                return;
            }
        }
    }
}
