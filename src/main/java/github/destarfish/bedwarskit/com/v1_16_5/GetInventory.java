










/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class GetInventory {
    public static @Nullable String getInvTitle(Inventory inventory) {
        if (inventory == null){
            return null;
        }
        Optional<HumanEntity> firstViewer = inventory.getViewers().stream().findFirst();
        if (firstViewer.isPresent()) {
            InventoryView openInventory = firstViewer.get().getOpenInventory();
            return openInventory.getTitle();
        } else {
            return null;
        }
    }


    public static @Nullable InventoryType getInvType(Inventory inventory) {
        if (inventory == null){
            return null;
        }
        return inventory.getType();
    }
}
