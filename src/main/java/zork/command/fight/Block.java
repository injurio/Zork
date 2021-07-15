package zork.command.fight;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;

public class Block implements Command {
    @Override
    public Observation do_the_command(Game game) {
        game.getPlayer().defend();
        game.getCurrentFight().toggleTurnCompleted();
        return new Observation("Block!");
    }

    @Override
    public String get_name_command() {
        return "block";
    }
}
