package zork.items.itemUseInFight;

import zork.character.Player;
import zork.game.Game;
import zork.game.Observation;

public class RedPotion extends FightItem {

    private static final int potion_amount = 30;

    @Override
    public Observation use(Game game) {
        Player player = game.getPlayer();
        player.setHealth(Math.min(player.getMax_player_health(), player.getHealth() + potion_amount));
        return new Observation("Drinking red potion");
    }

    @Override
    public boolean canRunOut() {
        return true;
    }

    @Override
    public Observation drop(Game game) {
        Player player = game.getPlayer();
        return new Observation("Drop Red Potion!");
    }
}
