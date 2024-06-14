







/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class MainConfigHandler {

    public static boolean teleportAlwayKeepDirection;
    public static String joinServer_mess;
    public static String rejoin_mess;
    public static boolean rejoin;
    public static String leaveServer_mess;

    public static int armorColor_RED_red;
    public static int armorColor_RED_green;
    public static int armorColor_RED_blue;
    public static int armorColor_BLUE_red;
    public static int armorColor_BLUE_green;
    public static int armorColor_BLUE_blue;
    public static int armorColor_GREEN_red;
    public static int armorColor_GREEN_green;
    public static int armorColor_GREEN_blue;
    public static int armorColor_YELLOW_red;
    public static int armorColor_YELLOW_green;
    public static int armorColor_YELLOW_blue;
    public static int armorColor_AQUA_red;
    public static int armorColor_AQUA_green;
    public static int armorColor_AQUA_blue;
    public static int armorColor_PINK_red;
    public static int armorColor_PINK_green;
    public static int armorColor_PINK_blue;
    public static int armorColor_GRAY_red;
    public static int armorColor_GRAY_green;
    public static int armorColor_GRAY_blue;
    public static int armorColor_WHITE_red;
    public static int armorColor_WHITE_green;
    public static int armorColor_WHITE_blue;
    public static int armorColor_ORANGE_red;
    public static int armorColor_ORANGE_green;
    public static int armorColor_ORANGE_blue;

    public static boolean worldMode_autoJudge;
    public static Set<String> gameWorld4v4;
    public static String lobbyWorld;
    public static String bungeeMode;

    public static String relTeamName_Red;
    public static String relTeamName_Blue;
    public static String relTeamName_Green;
    public static String relTeamName_Yellow;
    public static String relTeamName_Aqua;
    public static String relTeamName_White;
    public static String relTeamName_Gray;
    public static String relTeamName_Pink;
    public static String relTeamName_Orange;

    public static boolean resourceSplit;
    public static double resourceSplitDis;

    public static boolean holdCompassMess;
    public static String holdCompass_mess_actionBar;
    public static String holdCompassNotFound_mess_actionBar;
    public static boolean breakTitle;
    public static boolean noHunger;
    public static boolean noPearlDamage;
    public static boolean noPearlDamage_tpSound;
    public static boolean deathGameMode;
    public static boolean startKitCompass;
    public static boolean cleanBottle;
    public static boolean cleanBed;
    public static boolean killSeizeResource;
    public static boolean noItemBreak;

    public static int chainPrice;
    public static int ironPrice;
    public static int diamondPrice;

    public static int maxFoodLevel;
    public static int respawnDelay;


    public static String breakTitleAll;
    public static String breakSubTitleAll;
    public static String breakTitleBreakPlayer;
    public static String breakSubTitleBreakPlayer;
    public static String breakTitleBreakTeam;
    public static String breakSubTitleBreakTeam;


    public static String respawnTitle;
    public static String respawnSubTitle;
    public static String respawnChat;
    public static String respawnActionBar;

    public static String respawnSuccTitle;
    public static String respawnSuccSubTitle;
    public static String respawnSuccChat;
    public static String respawnSuccActionBar;

    public static String meanIron;
    public static String meanGold;
    public static String meanDiamond;
    public static String meanEmerlad;

    public static String messreloadnow;
    public static String messreloadsucc;
    public static Material chainPriceType;
    public static Material ironPriceType;
    public static Material diamondPriceType;
    public static Material upToChainArmor;
    public static Material upToIronArmor;
    public static Material upToDiamondArmor;

    public static boolean antiDrop;
    public static List<String> antiDropList;

    public static List<String> nobreakList;


    public static String damagefb_mess_chat;
    public static String damagefb_mess_title;
    public static String damagefb_mess_subTitle;
    public static String damagefb_mess_actionbar;

    public static boolean damagefb_blood;
    public static String damagefb_bloodMode;
    public static Material damagefb_bloodType;

    public static String startmess_all_chat;
    public static String startmess_all_title;
    public static String startmess_all_subtitle;
    public static String startmess_all_actionbar;

    public static String gameOver_mess_chat;

    public static String dieOut_mess_chat;
    public static String dieOut_mess_title;
    public static String dieOut_mess_subtitle;
    public static String dieOut_mess_actionbar;

    public static boolean update_reportOp;

    public static boolean deathGameMode_instantRepsawn;

    public static boolean preventLoadWorld;
    public static String preventLoadWorldMode;
    public static boolean preventLoadWorldMode_before_animFix;

    public static boolean placeCorrect_resourceSpawner;
    public static String placeCorrect_resourceSpawner_mess_chat;
    public static String placeCorrect_resourceSpawner_mess_title;
    public static String placeCorrect_resourceSpawner_mess_subtitle;
    public static String placeCorrect_resourceSpawner_mess_actionbar;

    public static boolean placeCorrect_playerSpawnLoc;
    public static String placeCorrect_playerSpawnLoc_mess_chat;
    public static String placeCorrect_playerSpawnLoc_mess_title;
    public static String placeCorrect_playerSpawnLoc_mess_subtitle;
    public static String placeCorrect_playerSpawnLoc_mess_actionbar;

    public static String killfb_mess_chat;
    public static String killfb_mess_title;
    public static String killfb_mess_subtitle;
    public static String killfb_mess_actionbar;
    public static boolean cleanHostileOnStart;
    public static String killSeizeResource_mess_chat;
    public static boolean placeCorrect_notInGame;
    public static boolean breakCorrect_notInGame;
    public static boolean placeCorrect_notInGame_OpBypass;
    public static boolean breakCorrect_notInGame_OpBypass;

    public static String compassDisplayName;
    public static String holdCompassDisplayName;

    public static String leaveHoldCompass_mess_actionbar;

    public static String meanSecond;

    public static boolean lobbyJoinTeam_changeItemColor;
    public static String lobbyJoinTeam_mess_chat;
    public static String lobbyJoinTeam_mess_title;
    public static String lobbyJoinTeam_mess_subtitle;
    public static String lobbyJoinTeam_mess_actionbar;

    public static boolean tab;
    public static boolean tab_is_multiLine;
    public static String tab_head;
    public static List<String> tab_headList;
    public static String tab_foot;
    public static List<String> tab_footList;


    public static boolean lobbyLeaveTeam;
    public static boolean dieOutGameItem_playAgain;
    public static String dieOutGameItem_playAgain_itemName;
    public static Material dieOutGameItem_playAgain_itemType;
    public static String dieOutGameItem_playAgain_clickSendCommand;
    public static boolean killfb_oneHealthKill;
    public static Material killfb_oneHealthKill_itemType;
    public static String killfb_oneHealthKill_itemName;

    public static boolean relFix_creativeCantToggleFly;
    public static boolean relFix_cantPickupItems;

    public static String deathGameMode_tpto;
    public static int placeCorrect_ResSpawner_dis;
    public static int dieOutGameItem_playAgain_itemSlot;

    public static boolean noEndermanGriefing;

    public static boolean noOpenInventory;
    public static Set<InventoryType> noOpenInventoryTypeList;

    public static boolean noWoodSwordDropWhenNothaveSword;
    public static boolean noWoodAxeDropWhenNothaveAxe;
    public static boolean noWoodPickaxeDropWhenNothavePickaxe;

    public static boolean noInteractWhileEndGame;
    public static boolean JudgeTeamByColor;

    public static String gameOver_mess_topKills_format;


}
