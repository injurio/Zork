package zork.command.fight;

import zork.command.Command;
import zork.game.AttackOb;
import zork.game.Game;
import zork.game.Observation;

public class Attack implements Command {

    @Override
    public Observation do_the_command(Game game) {
        Observation ob = new Observation("You attack the monster.");
        AttackOb attackObject = game.getPlayer().attack();
        game.getCurrentFight().getFightingMonster().getAttacked(attackObject, ob);
        game.getCurrentFight().toggleTurnCompleted();
        return ob;
    }

    @Override
    public String get_name_command() {
        return "attack";
    }
}
