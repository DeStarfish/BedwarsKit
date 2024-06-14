























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelEditPlayerClick implements Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(final PlayerInteractAtEntityEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        if (isEditPlayer(playerUUID)) {
            event.setCancelled(true);
        }

        if (event.getRightClicked() != null) {
            Entity entity = event.getRightClicked();
            ItemStack itemInHand = getItemInHand(player);

            if (itemInHand != null) {
                switch (itemInHand.getType()) {
                    case NAME_TAG: {
                        String willSend = meanEntityNameSetTo
                                .replace("%orgName%", entity.getCustomName() + "")
                                .replace("%newName%", levelupShopOpenModeEntityName);
                        entity.setCustomName(t(levelupShopOpenModeEntityName));
                        sendMessage(player, willSend);
                    }
                    break;
                    case ITEM_FRAME: {
                        String willSend = meanEntityNameSetTo
                                .replace("%orgName%", entity.getCustomName() + "")
                                .replace("%newName%", itemShopEntityName);
                        entity.setCustomName(t(itemShopEntityName));
                        sendMessage(player, willSend);
                    }
                    break;
                    case REDSTONE: {
                        String willSend = meanEntityNameRemove
                                .replace("%orgName%", entity.getCustomName() + "");
                        sendMessage(player, willSend);
                        entity.setCustomName(null);
                    }
                    break;
                    default: {
                    }
                    break;
                }
            }
        }
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        if (isEditPlayer(playerUUID)) {
            event.setCancelled(true);
        }

        ItemStack itemInHand = getItemInHand(player);

        if (itemInHand != null) {
            if (itemInHand.getType() == Material.PAPER) {
                toggleEdit(player);
            }
        }
    }
}

