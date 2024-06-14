


















/**
 * A Addon for BedwarsRel, Added some features to BedwarsRel
 * github.com/DeStarfish/BedwarsKit
 *
 * @author DeStarfish
 */
public class RelPlayerDamage implements Listener {
    public static final EntityEffect damageAnim = EntityEffect.HURT;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void on(EntityDamageEvent event) {

        if (!preventLoadWorld) {
            return;
        }

        boolean isNotBeforeMode = !Objects.equals(preventLoadWorldMode, "before");
        if (isNotBeforeMode) {
            return;
        }

        boolean isPlayer = event.getEntity() instanceof Player;

        if (!isPlayer) {
            return;
        }

        Player player = (Player) event.getEntity();

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);

        if (game == null) {
            return;
        }

        if (game.getState() != GameState.RUNNING || game.getCycle().isEndGameRunning()) {
            return;
        }

        double damage = event.getFinalDamage();
        double current = player.getHealth();

        EntityDamageEvent.DamageCause cause = event.getCause();

        if (event instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent entityEvent = (EntityDamageByEntityEvent) event;
            onDamageByEntity(entityEvent, player, damage, current);
            return;
        }

        EntityDamageEvent.DamageCause cVoid = EntityDamageEvent.DamageCause.VOID;

        if (cause == cVoid || current - damage <= 0) {
            event.setCancelled(true);
            if (preventLoadWorldMode_before_animFix) {
                onDamgeFeedBack(player);
            }
            player.setHealth(player.getMaxHealth() - 1);
            onPlayerDeath(player, true);
        }


    }

    public final void onDamageByEntity(EntityDamageByEntityEvent event
            , Player player, double damage, double current
    ) {

        boolean killerIsPlayer = event.getDamager() instanceof Player;

        if (!killerIsPlayer) {
            return;
        }
        Player killer = (Player) event.getDamager();

        Game game = BedwarsRel.getInstance().getGameManager().getGameOfPlayer(player);
        if (game == null) {
            return;
        }

        if (Objects.equals(game.getPlayerTeam(player).getName(), game.getPlayerTeam(killer).getName())) {
            event.setCancelled(true);
            return;
        }


        if (current - damage <= 0) {
            event.setCancelled(true);
            if (preventLoadWorldMode_before_animFix) {
                onDamgeFeedBack(player);
            }
            player.setHealth(player.getMaxHealth() - 1);
            onPlayerDeath(player, true);
        }
    }


    private void onDamgeFeedBack(Player player) {

        player.playEffect(damageAnim);
        SoundPlayer.PLAYER_HURT(player, 1);
    }

}
