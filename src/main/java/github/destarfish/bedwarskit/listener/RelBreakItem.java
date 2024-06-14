












/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelBreakItem implements Listener {
    private static final String className = RelBreakItem.class.getSimpleName();

    @EventHandler
    public void on(final PlayerItemDamageEvent event) {
        if (!noItemBreak) {
            if (isDebug()) {
                le(className, "[Waring] silent return : noItemBreak == false");
            }
            return;
        }
        if (nobreakList == null) {
            if (isDebug()) {
                le(className, "[Waring] silent return : nobreakList == null");
            }
            return;
        }
        if (nobreakList.isEmpty()) {
            if (isDebug()) {
                le(className, "[Waring] silent return : nobreakList is empty");
            }
            return;
        }

        ItemStack item = event.getItem();

        if (item == null) {
            return;
        }

        Material itemType = item.getType();
        String typeText = itemType.toString();

        int damage = event.getDamage();

        short current = item.getDurability();
        short max = itemType.getMaxDurability();

        for (String s : nobreakList) {

            if (typeText.contains(s)) {
                if (current + damage >= max) {
                    event.setCancelled(true);
                    item.setDurability((short) 0);
                    break;
                }
            }
        }
    }
}
