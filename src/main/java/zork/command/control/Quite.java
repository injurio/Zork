package zork.command.control;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;
import zork.scene.LevelScene;
import zork.scene.StartScene;

public class Quite implements Command {

    @Override
    public Observation do_the_command(Game game) {
        game.getStartScene().playScene(game);
        return new Observation("quite! the game");
    }

    @Override
    public String get_name_command() {
        return "quite";
    }
}
