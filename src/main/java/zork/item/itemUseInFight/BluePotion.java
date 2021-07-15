package zork.items.itemUseInFight;

import zork.character.Player;
import zork.game.Game;
import zork.game.Observation;

public class BluePotion extends FightItem {

    private static final int potion_amount = 10;

    @Override
    public Observation use(Game game) {
        Player player = game.getPlayer();
        player.setMana(Math.min(player.getMax_player_mana(), player.getMana() + potion_amount));
        return new Observation("Drinking Blue potion");
    }

    @Override
    public boolean canRunOut() {
        return true;
    }

    @Override
    public Observation drop(Game game) {
        Player player = game.getPlayer();
        return new Observation("Drop Blue Potion");
    }
}
