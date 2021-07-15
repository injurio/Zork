package zork.command.fight;

import zork.command.Command;
import zork.game.AttackOb;
import zork.game.Game;
import zork.game.Observation;

public class Critical implements Command {
    @Override
    public Observation do_the_command(Game game) {
        Observation ob = new Observation("Take this special attack!");
        AttackOb attackOb = game.getPlayer().criticalAttack();
        if (attackOb != null){
            game.getCurrentFight().getFightingMonster().getAttacked(attackOb, ob);
            game.getCurrentFight().toggleTurnCompleted();
        }else {
            ob.addMessage("you're lack of mana");
        }
        return ob;
    }

    @Override
    public String get_name_command() {
        return "critical attack";
    }
}
