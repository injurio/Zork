package zork.scene;

import zork.command.normal.NormalCommandFactory;
import zork.game.Game;
import zork.game.Observation;

public class StartScene extends Scene {

    String intro =
                    " _____          _       ____                      \n" +
                    "|__  /___  _ __| | __  / ___| __ _ _ __ ___   ___ \n" +
                    "  / // _ \\| '__| |/ / | |  _ / _` | '_ ` _ \\ / _ \\\n" +
                    " / /| (_) | |  |   <  | |_| | (_| | | | | | |  __/\n" +
                    "/____\\___/|_|  |_|\\_\\  \\____|\\__,_|_| |_| |_|\\___| \n";

    @Override
    public void playScene(Game game) {
        game.notifyObserver(new Observation(intro));
        game.notifyObserver(new Observation("> Welcome to the zork game!!"));
        game.setNextScene(null);

        while (game.getNextScene() == null){
            game.resetCommandsList();
            game.addCommandsToList(new NormalCommandFactory().getCommands());
            showCommand(game);
        }
    }
}
