package zork.command.walk;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;

public class Down implements Command {
    @Override
    public Observation do_the_command(Game game) {
        return game.getCurrentLevel().walkDown();
    }

    @Override
    public String get_name_command() {
        return "down";
    }
}
