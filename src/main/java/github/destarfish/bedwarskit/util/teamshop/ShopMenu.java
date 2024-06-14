
























/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class ShopMenu {
    private static ItemStack paneItem;
    private static ItemStack sharp12v2;
    private static ItemStack sharp22v2;
    private static ItemStack sharp32v2;
    private static ItemStack sharp42v2;
    private static ItemStack sharpMax2v2;
    private static ItemStack prot12v2;
    private static ItemStack prot22v2;
    private static ItemStack prot32v2;
    private static ItemStack prot42v2;
    private static ItemStack protMax2v2;
    private static ItemStack haste12v2;
    private static ItemStack haste22v2;
    private static ItemStack haste32v2;
    private static ItemStack hasteMax2v2;
    private static ItemStack heal12v2;
    private static ItemStack healMax2v2;
    private static ItemStack sharp14v4;
    private static ItemStack sharp24v4;
    private static ItemStack sharp34v4;
    private static ItemStack sharp44v4;
    private static ItemStack sharpMax4v4;
    private static ItemStack prot14v4;
    private static ItemStack prot24v4;
    private static ItemStack prot34v4;
    private static ItemStack prot44v4;
    private static ItemStack protMax4v4;
    private static ItemStack haste14v4;
    private static ItemStack haste24v4;
    private static ItemStack haste34v4;
    private static ItemStack hasteMax4v4;
    private static ItemStack heal14v4;
    private static ItemStack healMax4v4;
    private static ItemStack res12v2;
    private static ItemStack res14v4;
    private static List<Integer> paneList;

    public static void loadLevelUpInv() {
        ItemMeta meta;
        if (paneItem == null) {
            paneItem = GetItemStack.GRAY_STAINED_GLASS_PANE();
        }

        if (paneList == null) {
            paneList = new ArrayList<>(10);
        } else {
            paneList.clear();
        }

        paneList.add(27);
        paneList.add(28);
        paneList.add(29);
        paneList.add(30);

        paneList.add(31);
        paneList.add(32);
        paneList.add(33);
        paneList.add(34);

        paneList.add(35);

        List<String> lore = new ArrayList<>(6);
        lore.add("ERROR");

        paneItem = GetItemStack.GRAY_STAINED_GLASS_PANE();
        meta = paneItem.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.paneItemName));
        lore.clear();
        for (String list : LevelConfigHandler.paneItemLore) {
            if (!list.isEmpty()) {
                lore.add(t(list));
            }
        }
        meta.setLore(lore);
        paneItem.setItemMeta(meta);

        loadLevelUpInv2v2();
        loadLevelUpInv4v4();


    }

    private static void loadLevelUpInv2v2() {

        ItemMeta meta;

        List<String> lore = new ArrayList<>(6);
        lore.add("ERROR");

        sharp12v2 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharp12v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharp1));
        lore.clear();
        lore.add(t("&f" + sharp1Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        sharp12v2.setItemMeta(meta);

        sharp22v2 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharp22v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharp2));
        lore.clear();
        lore.add(t("&f" + sharp2Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        sharp22v2.setItemMeta(meta);


        sharp32v2 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharp32v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharp3));
        lore.clear();
        lore.add(t("&f" + sharp3Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        sharp32v2.setItemMeta(meta);

        sharp42v2 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharp42v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharp4));
        lore.clear();
        lore.add(t("&f" + sharp4Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        sharp42v2.setItemMeta(meta);

        sharpMax2v2 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharpMax2v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharpMax));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.teamEnchantMaxCost));
        meta.setLore(lore);
        sharpMax2v2.setItemMeta(meta);

        prot12v2 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = prot12v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_prot1));
        lore.clear();
        lore.add(t("&f" + prot1Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        prot12v2.setItemMeta(meta);

        prot22v2 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = prot22v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_prot2));
        lore.clear();
        lore.add(t("&f" + prot2Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        prot22v2.setItemMeta(meta);


        prot32v2 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = prot32v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_prot3));
        lore.clear();
        lore.add(t("&f" + prot3Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        prot32v2.setItemMeta(meta);

        prot42v2 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = prot42v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_prot4));
        lore.clear();
        lore.add(t("&f" + prot4Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        prot42v2.setItemMeta(meta);

        protMax2v2 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = protMax2v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_protMax));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.teamEnchantMaxCost));
        meta.setLore(lore);
        protMax2v2.setItemMeta(meta);

        haste12v2 = new ItemStack(LevelConfigHandler.leveluphasteItemType, 1);
        meta = haste12v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_haste1));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.haste1Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        haste12v2.setItemMeta(meta);

        haste22v2 = new ItemStack(LevelConfigHandler.leveluphasteItemType, 1);
        meta = haste22v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_haste2));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.haste2Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        haste22v2.setItemMeta(meta);

        haste32v2 = new ItemStack(LevelConfigHandler.leveluphasteItemType, 1);
        meta = haste32v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_haste3));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.haste3Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        haste32v2.setItemMeta(meta);

        hasteMax2v2 = new ItemStack(LevelConfigHandler.leveluphasteItemType, 1);
        meta = hasteMax2v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_hasteMax));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.teamEnchantMaxCost));
        meta.setLore(lore);
        hasteMax2v2.setItemMeta(meta);

        heal12v2 = new ItemStack(LevelConfigHandler.leveluphealItemType, 1);
        meta = heal12v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_heal1));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.heal1Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        heal12v2.setItemMeta(meta);

        healMax2v2 = new ItemStack(LevelConfigHandler.leveluphealItemType, 1);
        meta = healMax2v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_healMax));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.teamEnchantMaxCost));
        meta.setLore(lore);
        healMax2v2.setItemMeta(meta);

        res12v2 = new ItemStack(LevelConfigHandler.levelupresItemType, 1);
        meta = res12v2.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.levelupresItemName));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.heal1Cost2v2 + " " + meanDiamond));
        meta.setLore(lore);
        res12v2.setItemMeta(meta);
    }

    private static void loadLevelUpInv4v4() {

        ItemMeta meta;

        List<String> lore = new ArrayList<>(6);
        lore.add("ERROR");

        sharp14v4 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharp14v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharp1));
        lore.clear();
        lore.add(t("&f" + sharp1Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        sharp14v4.setItemMeta(meta);

        sharp24v4 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharp24v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharp2));
        lore.clear();
        lore.add(t("&f" + sharp2Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        sharp24v4.setItemMeta(meta);


        sharp34v4 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharp34v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharp3));
        lore.clear();
        lore.add(t("&f" + sharp3Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        sharp34v4.setItemMeta(meta);

        sharp44v4 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharp44v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharp4));
        lore.clear();
        lore.add(t("&f" + sharp4Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        sharp44v4.setItemMeta(meta);

        sharpMax4v4 = new ItemStack(LevelConfigHandler.levelupsharpItemType, 1);
        meta = sharpMax4v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_sharpMax));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.teamEnchantMaxCost));
        meta.setLore(lore);
        sharpMax4v4.setItemMeta(meta);

        prot14v4 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = prot14v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_prot1));
        lore.clear();
        lore.add(t("&f" + prot1Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        prot14v4.setItemMeta(meta);

        prot24v4 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = prot24v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_prot2));
        lore.clear();
        lore.add(t("&f" + prot2Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        prot24v4.setItemMeta(meta);


        prot34v4 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = prot34v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_prot3));
        lore.clear();
        lore.add(t("&f" + prot3Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        prot34v4.setItemMeta(meta);

        prot44v4 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = prot44v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_prot4));
        lore.clear();
        lore.add(t("&f" + prot4Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        prot44v4.setItemMeta(meta);

        protMax4v4 = new ItemStack(LevelConfigHandler.levelupprotItemType, 1);
        meta = protMax4v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEnchItemName_protMax));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.teamEnchantMaxCost));
        meta.setLore(lore);
        protMax4v4.setItemMeta(meta);

        haste14v4 = new ItemStack(LevelConfigHandler.leveluphasteItemType, 1);
        meta = haste14v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_haste1));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.haste1Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        haste14v4.setItemMeta(meta);

        haste24v4 = new ItemStack(LevelConfigHandler.leveluphasteItemType, 1);
        meta = haste24v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_haste2));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.haste2Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        haste24v4.setItemMeta(meta);

        haste34v4 = new ItemStack(LevelConfigHandler.leveluphasteItemType, 1);
        meta = haste34v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_haste3));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.haste3Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        haste34v4.setItemMeta(meta);

        hasteMax4v4 = new ItemStack(LevelConfigHandler.leveluphasteItemType, 1);
        meta = hasteMax4v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_hasteMax));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.teamEnchantMaxCost));
        meta.setLore(lore);
        hasteMax4v4.setItemMeta(meta);

        heal14v4 = new ItemStack(LevelConfigHandler.leveluphealItemType, 1);
        meta = heal14v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_heal1));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.heal1Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        heal14v4.setItemMeta(meta);

        healMax4v4 = new ItemStack(LevelConfigHandler.leveluphealItemType, 1);
        meta = healMax4v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.teamEffItemName_healMax));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.teamEnchantMaxCost));
        meta.setLore(lore);
        healMax4v4.setItemMeta(meta);

        res14v4 = new ItemStack(LevelConfigHandler.levelupresItemType, 1);
        meta = res14v4.getItemMeta();
        meta.setDisplayName(t(LevelConfigHandler.levelupresItemName));
        lore.clear();
        lore.add(t("&f" + LevelConfigHandler.heal1Cost4v4 + " " + meanDiamond));
        meta.setLore(lore);
        res14v4.setItemMeta(meta);
    }

    public static void openShop2v2(Player player, Game game) {

        if (!levelupShop) {
            return;
        }

        Inventory inventory = Bukkit.getServer().createInventory(null, 6 * 9, LevelConfigHandler.levelUpShopInvTitle);

        int minSlot = 0;
        int maxSlot = inventory.getSize() - 1;

        for (int i : paneList) {
            ItemStack item;
            if (paneItem != null) {
                item = paneItem.clone();
                inventory.setItem(i, item);
            }
        }

        Team team = game.getPlayerTeam(player);

        String teamName = team.getName();
        String gameName = game.getName();


        if (LevelConfigHandler.leveluphasteItemSlot != -1) {

            final int levelSlot = LevelConfigHandler.leveluphasteItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }

            HashMap<String, String> teamDatas = TeamHaste.getTeamDatas(gameName);

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (entry.getKey().equals(teamName)) {
                    String level = entry.getValue();
                    switch (level) {
                        case "0": {
                            inventory.setItem(setTo, haste12v2);
                        }
                        break;
                        case "1": {
                            inventory.setItem(setTo, haste22v2);
                        }
                        break;
                        case "2": {
                            inventory.setItem(setTo, haste32v2);
                        }
                        break;
                        case "3": {
                            inventory.setItem(setTo, hasteMax2v2);
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                }
            }
        }

        if (LevelConfigHandler.leveluphealItemSlot != -1) {

            final int levelSlot = LevelConfigHandler.leveluphealItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }

            Map<String, String> teamDatas = TeamHeal.getTeamDatas(gameName);

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (entry.getKey().equals(teamName)) {
                    String level = entry.getValue();
                    switch (level) {
                        case "0": {
                            inventory.setItem(setTo, heal12v2);
                        }
                        break;
                        case "1": {
                            inventory.setItem(setTo, healMax2v2);
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                }
            }
        }

        if (LevelConfigHandler.levelupprotItemSlot != -1) {

            final int levelSlot = LevelConfigHandler.levelupprotItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }

            Map<String, String> teamDatas = TeamProtect.getTeamDatas(gameName);

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (entry.getKey().equals(teamName)) {
                    String level = entry.getValue();
                    switch (level) {
                        case "0": {
                            inventory.setItem(setTo, prot12v2);
                        }
                        break;
                        case "1": {
                            inventory.setItem(setTo, prot22v2);
                        }
                        break;
                        case "2": {
                            inventory.setItem(setTo, prot32v2);
                        }
                        break;
                        case "3": {
                            inventory.setItem(setTo, prot42v2);
                        }
                        break;
                        case "4": {
                            inventory.setItem(setTo, protMax2v2);
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                }
            }
        }

        if (LevelConfigHandler.levelupsharpItemSlot != -1) {

            final int levelSlot = LevelConfigHandler.levelupsharpItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }

            Map<String, String> teamDatas = TeamSharp.getTeamDatas(gameName);

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (entry.getKey().equals(teamName)) {
                    String level = entry.getValue();
                    switch (level) {
                        case "0": {
                            inventory.setItem(setTo, sharp12v2);
                        }
                        break;
                        case "1": {
                            inventory.setItem(setTo, sharp22v2);
                        }
                        break;
                        case "2": {
                            inventory.setItem(setTo, sharp32v2);
                        }
                        break;
                        case "3": {
                            inventory.setItem(setTo, sharp42v2);
                        }
                        break;
                        case "4": {
                            inventory.setItem(setTo, sharpMax2v2);
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                }
            }
        }

        if (LevelConfigHandler.levelupresItemSlot != -1) {
            final int levelSlot = LevelConfigHandler.levelupresItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }
            inventory.setItem(setTo, res12v2);
        }

        player.openInventory(inventory);
    }

    public static void openShop4v4(Player player, Game game) {

        if (!levelupShop) {
            return;
        }

        Inventory inventory = Bukkit.getServer().createInventory(null, 6 * 9, LevelConfigHandler.levelUpShopInvTitle);

        int minSlot = 0;
        int maxSlot = inventory.getSize() - 1;

        for (int i : paneList) {
            ItemStack item;
            if (paneItem != null) {
                item = paneItem.clone();
                inventory.setItem(i, item);
            }
        }

        Team team = game.getPlayerTeam(player);

        String teamName = team.getName();
        String gameName = game.getName();


        if (LevelConfigHandler.leveluphasteItemSlot != -1) {

            final int levelSlot = LevelConfigHandler.leveluphasteItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }

            HashMap<String, String> teamDatas = TeamHaste.getTeamDatas(gameName);

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (entry.getKey().equals(teamName)) {
                    String level = entry.getValue();
                    switch (level) {
                        case "0": {
                            inventory.setItem(setTo, haste14v4);
                        }
                        break;
                        case "1": {
                            inventory.setItem(setTo, haste24v4);
                        }
                        break;
                        case "2": {
                            inventory.setItem(setTo, haste34v4);
                        }
                        break;
                        case "3": {
                            inventory.setItem(setTo, hasteMax4v4);
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                }
            }
        }

        if (LevelConfigHandler.leveluphealItemSlot != -1) {

            final int levelSlot = LevelConfigHandler.leveluphealItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }

            Map<String, String> teamDatas = TeamHeal.getTeamDatas(gameName);

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (entry.getKey().equals(teamName)) {
                    String level = entry.getValue();
                    switch (level) {
                        case "0": {
                            inventory.setItem(setTo, heal14v4);
                        }
                        break;
                        case "1": {
                            inventory.setItem(setTo, healMax4v4);
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                }
            }
        }

        if (LevelConfigHandler.levelupprotItemSlot != -1) {

            final int levelSlot = LevelConfigHandler.levelupprotItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }

            Map<String, String> teamDatas = TeamProtect.getTeamDatas(gameName);

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (entry.getKey().equals(teamName)) {
                    String level = entry.getValue();
                    switch (level) {
                        case "0": {
                            inventory.setItem(setTo, prot14v4);
                        }
                        break;
                        case "1": {
                            inventory.setItem(setTo, prot24v4);
                        }
                        break;
                        case "2": {
                            inventory.setItem(setTo, prot34v4);
                        }
                        break;
                        case "3": {
                            inventory.setItem(setTo, prot44v4);
                        }
                        break;
                        case "4": {
                            inventory.setItem(setTo, protMax4v4);
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                }
            }
        }

        if (LevelConfigHandler.levelupsharpItemSlot != -1) {

            final int levelSlot = LevelConfigHandler.levelupsharpItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }

            Map<String, String> teamDatas = TeamSharp.getTeamDatas(gameName);

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (entry.getKey().equals(teamName)) {
                    String level = entry.getValue();
                    switch (level) {
                        case "0": {
                            inventory.setItem(setTo, sharp14v4);
                        }
                        break;
                        case "1": {
                            inventory.setItem(setTo, sharp24v4);
                        }
                        break;
                        case "2": {
                            inventory.setItem(setTo, sharp34v4);
                        }
                        break;
                        case "3": {
                            inventory.setItem(setTo, sharp44v4);
                        }
                        break;
                        case "4": {
                            inventory.setItem(setTo, sharpMax4v4);
                        }
                        break;
                        default: {
                        }
                        break;
                    }
                }
            }
        }

        if (LevelConfigHandler.levelupresItemSlot != -1) {
            final int levelSlot = LevelConfigHandler.levelupresItemSlot;
            int setTo;

            if (levelSlot < minSlot) {
                setTo = minSlot;
            } else if (levelSlot > maxSlot) {
                setTo = maxSlot;
            } else {
                setTo = levelSlot;
            }
            inventory.setItem(setTo, res14v4);
        }

        player.openInventory(inventory);
    }
}