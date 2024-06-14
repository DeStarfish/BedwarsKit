

















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class TeamProtect {
    private static final Enchantment prot = Enchantment.PROTECTION_ENVIRONMENTAL;
    private static final ConcurrentHashMap<String, HashMap<String, String>> listMap;

    static {
        listMap = new ConcurrentHashMap<>(24);
    }

    public static void setTeamDatas(String gameName, HashMap<String, String> newTeamDatas) {
        listMap.put(gameName, newTeamDatas);
    }


    public static HashMap<String, String> getTeamDatas(String gameName) {
        return listMap.get(gameName);
    }

    public static void setTeamDatasDefault(String gameName, List<Team> teamList) {
        HashMap<String, String> teamDatas = new HashMap<>();

        for (Team team : teamList) {
            String teamName = team.getName();
            teamDatas.put(teamName, "0");
        }

        setTeamDatas(gameName, teamDatas);
    }


    public static void check(Game game) {

        String gameName = game.getName();

        if (getTeamDatas(gameName) == null) {
            return;
        }

        Map<String, String> teamDatas = getTeamDatas(gameName);

        if (teamDatas.isEmpty()) {
            return;
        }

        for (Team team : game.getPlayingTeams()) {
            String teamName = team.getName();

            for (Map.Entry<String, String> entry : teamDatas.entrySet()) {
                if (Objects.equals(entry.getKey(), teamName)) {

                    int finallyLevel = 0;

                    String level = entry.getValue();

                    if (Objects.equals("1", level)) {
                        finallyLevel = 1;
                    } else if (Objects.equals("2", level)) {
                        finallyLevel = 2;
                    } else if (Objects.equals("3", level)) {
                        finallyLevel = 3;
                    } else if (Objects.equals("4", level)) {
                        finallyLevel = 4;
                    }

                    if (finallyLevel < 1) {
                        return;
                    }
                    for (Player player : team.getPlayers()) {
                        PlayerInventory pi = player.getInventory();
                        ItemStack[] inventory = pi.getArmorContents();
                        for (ItemStack item : inventory) {
                            if (item != null) {
                                for (String s : giveProtEnchList) {
                                    Material type = item.getType();
                                    String typeText = type.toString().toUpperCase();
                                    if (typeText.contains(s)) {
                                        item.addEnchantment(prot, finallyLevel);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

