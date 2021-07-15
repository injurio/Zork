package zork.scene;

import zork.command.Command;
import zork.game.Game;
import zork.game.Input;
import zork.game.Observation;

public abstract class Scene {

    public abstract void playScene(Game game);

    protected void showCommand(Game game){

        Observation commandList = game.getCommandsAsString();

        game.notifyObserver(commandList);

        Input input = game.getInput();

        Command command = input.receiveInput(game);

        Observation output = input.processCommand(command, game);

        game.notifyObserver(output);
    }
}
