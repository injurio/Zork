package zork.command.walk;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;

public class Left implements Command {
    @Override
    public Observation do_the_command(Game game) {
        return game.getCurrentLevel().walkLeft();
    }

    @Override
    public String get_name_command() {
        return "left";
    }
}
