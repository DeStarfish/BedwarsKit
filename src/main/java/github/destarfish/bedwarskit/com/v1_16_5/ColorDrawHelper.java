





public final class ColorDrawHelper {
    public static void setColor(ItemStack itemStack, DyeColor dyeColor) {
        Material itemType = itemStack.getType();
        String typeText = itemType.toString();

        Material finalType = itemType;

        if (typeText.contains("BED")) {
            switch (dyeColor) {
                case RED: {
                    finalType = Material.RED_BED;
                }
                break;
                case BLUE: {
                    finalType = Material.BLUE_BED;
                }
                break;
                case GREEN: {
                    finalType = Material.GREEN_BED;
                }
                break;
                case YELLOW: {
                    finalType = Material.YELLOW_BED;
                }
                break;
                case PINK: {
                    finalType = Material.PINK_BED;
                }
                break;
                case CYAN: {
                    finalType = Material.CYAN_BED;
                }
                break;
                case GRAY: {
                    finalType = Material.GRAY_BED;
                }
                break;
                case LIGHT_GRAY: {
                    finalType = Material.LIGHT_GRAY_BED;
                }
                break;
                case ORANGE: {
                    finalType = Material.ORANGE_BED;
                }
                break;
                case LIME: {
                    finalType = Material.LIME_BED;
                }
                break;
                case LIGHT_BLUE: {
                    finalType = Material.LIGHT_BLUE_BED;
                }
                break;
                case WHITE: {
                    finalType = Material.WHITE_BED;
                }
                break;
                default: {
                    finalType = Material.WHITE_BED;
                }
                break;


            }
        }

        itemStack.setType(finalType);

    }
}
