package zork.command.walk;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;

public class Right implements Command {
    @Override
    public Observation do_the_command(Game game) {
        return game.getCurrentLevel().walkRight();
    }

    @Override
    public String get_name_command() {
        return "right";
    }
}
