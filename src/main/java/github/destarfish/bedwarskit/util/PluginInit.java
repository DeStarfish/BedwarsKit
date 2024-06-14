

































/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public final class PluginInit {
    private final BedwarsKit plugin;
    @Getter
    private MainConfigLoad mainConfigLoad;

    public PluginInit(BedwarsKit pluginInstane) {
        plugin = pluginInstane;
        onStartup();
    }

    public void sendStartUpInfo() {
        BedwarsKit plugin = BedwarsKit.getInstance();
        PluginDescriptionFile file = plugin.getDescription();
        String author = file.getAuthors().get(0);

        l(green + msgline);
        l(" ");
        l(white + pluginName + " " + aqua + getPluginVersion());
        l(" ");
        l(white + meanAuthor + ": " + yellow + author);
        l(" ");
        l(green + msgline);
    }

    public void regCommand() {
        l(meanCommandRegNow);
        plugin.getCommand("bwk").setExecutor(new BaseCommand());
        plugin.getCommand("bwk reload").setExecutor(new BaseCommand());
        plugin.getCommand("bwk edit").setExecutor(new BaseCommand());
        plugin.getCommand("shout").setExecutor(new ShoutICommand());
        l(meanCommandRegSucc);
    }

    public void onStartup() {
        if (!isVerifyAuthor(plugin.getDescription())) {
            throw new AssertionError("Modifying plugin.yml is not allowed!");
        }
        setUpBungeeCordState();

        Locale locale = Locale.getDefault();

        String currentLang = locale.getLanguage();
        String currentCountry = locale.getCountry();
        String currentLanguageFormat = currentLang + "_" + currentCountry;

        setLanguage(currentLang);

        setCountry(currentCountry);

        setformatLanguage(currentLanguageFormat);

        loadCurrentLang(currentLang);
        setUpServerVersion();

        sendStartUpInfo();
        l(meanConfigLoadNow);

        mainConfigLoad = new MainConfigLoad(plugin);
        mainConfigLoad.loadConfig(null, true);

        l(meanConfigLoadSucc);

        regCommand();

        regListener();

        startMetrics();

        Plugin itemJoin = Bukkit.getPluginManager().getPlugin("ItemJoin");
        if (itemJoin != null && itemJoin.isEnabled()) {
            BedwarsKit.getInstance().setItemJoinAPI(new ItemJoinAPI());
        }
    }

    private void setUpBungeeCordState() {
        File configFile = new File("spigot.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        boolean isBungeeEnabled = config.getBoolean("settings.bungeecord");
        setBungeeEnabled(isBungeeEnabled);
    }

    private void rl(Listener listener) {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(listener, plugin);
        addRegListners(listener);

    }

    public void regListener() {

        rl(new RelDeathFirst());
        rl(new RelTeleportFirst());
        rl(new RelRespawnFirst());
        rl(new RelSwapSlot());

        rl(new RelAlwayPickup());
        rl(new RelDropWatcher());

        rl(new RelMobGriefing());
        rl(new CommandExecute());
        rl(new RelBreakBed());
        rl(new RelMapProtect());
        rl(new RelBreakItem());
        rl(new RelClickInventory());
        rl(new RelGameOver());
        rl(new RelGameStarted());
        rl(new RelOpenInventory());
        rl(new RelOpenShop());
        rl(new RelPickupItem());
        rl(new RelPlaceBlockCorrect());
        rl(new RelClick());
        rl(new RelPlayerDamage());
        rl(new RelDamageEffect());
        rl(new RelPlayerDrop());
        rl(new RelFoodLevelLock());
        rl(new RelPlayerJoin());
        rl(new RelPlayerKilled());
        rl(new RelPlayerLeave());
        rl(new RelPlayerTeleport());
        rl(new RelPlayerToggleFly());
        rl(new RelPlayerDeath());
        rl(new RelChangeWorldFirst());

        RelEx.setUpPacketListener();
    }

    private void setUpServerVersion() {
        Server server = Bukkit.getServer();
        String version = server.getVersion();
        String[] parts = version.split("MC: ");
        if (parts.length > 1) {

            setServerVersion(version);
        }
    }

    public void onShutdown() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            UUID playerUUID = player.getUniqueId();
            removeEditPlayer(playerUUID);
        }
        cl(pluginDisable);
    }

    private boolean isVerifyAuthor(PluginDescriptionFile file) {
        List<String> authors = file.getAuthors();

        return authors != null
                && authors.size() == 1
                && Objects.equals("DeStarfish", authors.get(0))
                && Objects.equals("BedwarsKit", file.getName());
    }
}
