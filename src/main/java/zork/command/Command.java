package zork.command;

import zork.game.Game;
import zork.game.Observation;

public interface Command {

    public Observation do_the_command(Game game);

    public String get_name_command();

}
