package zork.command.control;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;

public class Map implements Command {
    @Override
    public Observation do_the_command(Game game) {
        return game.getCurrentLevel().getLevelLand();
    }

    @Override
    public String get_name_command() {
        return "map";
    }
}
