





public final class ColorDrawHelper {
    public static void setColor(ItemStack itemStack, DyeColor dyeColor) {

        if (itemStack == null){
            return;
        }

        Material itemType = itemStack.getType();
        String typeText = itemType.toString();

        int finalType = 0;

        if (typeText.contains("BED")) {
            switch (dyeColor) {
                case RED: {
                    finalType = 14;
                }
                break;
                case BLUE: {
                    finalType = 3;
                }
                break;
                case GREEN: {
                    finalType = 5;
                }
                break;
                case YELLOW: {
                    finalType = 4;
                }
                break;
                case PINK: {
                    finalType = 6;
                }
                break;
                case CYAN: {
                    finalType = 9;
                }
                break;
                case SILVER: {
                    finalType = 8;
                }
                break;
                case GRAY: {
                    finalType = 8;
                }
                break;
                case ORANGE: {
                    finalType = 1;
                }
                break;
                case LIME: {
                    finalType = 5;
                }
                break;
                case LIGHT_BLUE: {
                    finalType = 3;
                }
                break;
                case WHITE: {
                    finalType = 0;
                }
                break;
                default: {
                    finalType = 0;
                }
                break;


            }
        }

        itemStack.setDurability((short) finalType);

    }
}
