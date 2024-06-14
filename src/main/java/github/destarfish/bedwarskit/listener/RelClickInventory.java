






































/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelClickInventory implements Listener {
    private static final Pattern p_player = Pattern.compile("%player%", Pattern.LITERAL);
    private static final Material glass_pane = GetMaterial.STAINED_GLASS_PANE();
    private final String className = getClass().getSimpleName();

    @EventHandler(priority = EventPriority.NORMAL)
    public void on(final InventoryClickEvent event) {

        Inventory inv = event.getClickedInventory();

        if (inv == null) {
            return;
        }
        String invTitle = getInvTitle(inv);

        if (invTitle == null) {
            return;
        }

        ItemStack itemStack = event.getCurrentItem();

        if (itemStack == null) {
            return;
        }

        Material itemType = itemStack.getType();

        if (itemType == null) {
            return;
        }

        String typeText = itemType.toString().toUpperCase();

        Player player = (Player) event.getWhoClicked();

        if (player == null) {
            return;
        }

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);
        if (game == null) {
            return;
        }

        if (isDebug()) {
            le(className, "[State] click slot : " + event.getSlot());
        }

        if (!player.isOnline()) {
            if (isDebug()) {
                le(className, "[Waring] silent return : player is offline");
            }
            return;
        }

        String playerName = player.getName();
        UUID playerUUID = player.getUniqueId();

        InventoryType invType = GetInventory.getInvType(inv);

        if (invType == InventoryType.CRAFTING) {
            event.setCancelled(true);
            if (isDebug()) {
                le(className, "[Waring] silent return : invType == CRAFTING");
            }
            return;
        }


        if (invTitle.equals(kitMenuTitle)) {
            event.setCancelled(true);
            boolean isSelected = isSelectedKit(playerUUID, itemType);

            if (isSelected) {
                sendMessage(player, meanSelKitSucc);
                playerSoundSucc(player);
                player.closeInventory();
            }
            if (isDebug()) {
                le(className, "[Waring] silent return : invTitle.equals(kitMenuTitle) isSelected: -> " + isSelected);
            }
            return;
        }

        if (dieOutGameItem_playAgain) {
            if (typeText.equals(dieOutGameItem_playAgain_itemType.toString())
                    && itemStack.getItemMeta().getDisplayName().equals(dieOutGameItem_playAgain_itemName)) {
                String willSend = p_player.matcher(dieOutGameItem_playAgain_clickSendCommand).replaceAll(Matcher.quoteReplacement(playerName));
                consoleSendCommand(willSend);
                if (isDebug()) {
                    le(className, "[Waring] silent return : clicked playAgain_Item");
                }
                return;
            }
        }

        if (
                Objects.equals(LevelConfigHandler.levelupShopOpenMode, "click on item")
                        && itemType == LevelConfigHandler.levelupItemType
        ) {
            event.setCancelled(true);
            if (levelupShopDelayOpen) {
                playerSoundOpen(player);
                openShop(player, 8L);
            } else {
                playerSoundOpen(player);
                openShop(player, 0L);
            }
            if (isDebug()) {
                le(className, "[Waring] silent return : itemType == LevelupItemType -> opened shop for player -> " + playerName);
            }
            return;
        }

        if (event.getCurrentItem() != null) {
            for (String string : antiDropList) {
                if (typeText.contains(string)) {
                    event.setCancelled(true);
                }
            }
        }

        String worldMode = Utils.isInMode(game);

        if (invTitle.equalsIgnoreCase(LevelConfigHandler.levelUpShopInvTitle)) {

            event.setCancelled(true);
            Team playerTeam = game.getPlayerTeam(player);

            String gameName = game.getName();

            ItemStack clickedItem = event.getCurrentItem();

            if (clickedItem == null) {
                return;
            }

            if (clickedItem.getItemMeta() != null) {

                String clickedItemName = clickedItem.getItemMeta().getDisplayName();
                String teamName = playerTeam.getName();
                Material clickedItemType = clickedItem.getType();

                Matcher m_fail = p_player.matcher(LevelConfigHandler.messLevelUpFailed);

                Matcher m_prot1 = p_player.matcher(LevelConfigHandler.messLevelUpprot1);
                Matcher m_prot2 = p_player.matcher(LevelConfigHandler.messLevelUpprot2);
                Matcher m_prot3 = p_player.matcher(LevelConfigHandler.messLevelUpprot4);
                Matcher m_prot4 = p_player.matcher(LevelConfigHandler.messLevelUpprot3);

                Matcher m_sharp1 = p_player.matcher(LevelConfigHandler.messLevelUpsharp1);
                Matcher m_sharp2 = p_player.matcher(LevelConfigHandler.messLevelUpsharp2);
                Matcher m_sharp3 = p_player.matcher(LevelConfigHandler.messLevelUpsharp3);
                Matcher m_sharp4 = p_player.matcher(LevelConfigHandler.messLevelUpsharp4);

                Matcher m_heal1 = p_player.matcher(LevelConfigHandler.messLevelUpheal1);

                Matcher m_haste1 = p_player.matcher(LevelConfigHandler.messLevelUphaste1);
                Matcher m_haste2 = p_player.matcher(LevelConfigHandler.messLevelUphaste2);
                Matcher m_haste3 = p_player.matcher(LevelConfigHandler.messLevelUphaste3);

                boolean is2v2 = worldMode.equals("2v2");
                boolean is4v4 = worldMode.equals("4v4");

                String replacement = Matcher.quoteReplacement(playerName);

                boolean buyFail;
                buyFail = RelClickInvHelper.isBuyFail(is2v2, clickedItemType, gameName, clickedItemName, player, teamName, m_haste1, replacement, m_fail, m_haste2, m_haste3, m_heal1, m_sharp1, m_sharp2, m_sharp3, m_sharp4, m_prot1, m_prot2, m_prot4, m_prot3, is4v4);

                if (clickedItemType == glass_pane) {
                    buyFail = false;
                }
                if (clickedItemType == LevelConfigHandler.levelupresItemType) {
                    buyFail = false;
                }
                if (buyFail) {
                    playerSoundFail(player);
                    String mess = p_player.matcher(LevelConfigHandler.messLevelUpFailed).replaceAll(Matcher.quoteReplacement(player.getName()));
                    player.sendMessage(t(mess));
                } else {
                    playerSoundSucc(player);
                    openShop(player, 1L);
                }
            }
        }
    }

    private void playerSoundOpen(Player player) {
        CLICK(player, 1);
    }

    private void playerSoundSucc(Player player) {
        CHICKEN_EGG_POP(player, 1);
    }

    private void playerSoundFail(Player player) {
        ITEM_BREAK(player, 1);
    }
}
