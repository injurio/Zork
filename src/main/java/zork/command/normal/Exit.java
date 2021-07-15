package zork.command.normal;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;

public class Exit implements Command {


    @Override
    public Observation do_the_command(Game game) {
        System.exit(0);
        return null;
    }

    @Override
    public String get_name_command() {
        return "exit";
    }
}
