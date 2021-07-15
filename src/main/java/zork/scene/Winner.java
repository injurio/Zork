package zork.scene;

import zork.game.Game;
import zork.game.Observation;
import zork.location.level.LevelIterator;

public class Winner extends Scene {
    @Override
    public void playScene(Game game) {
        game.notifyObserver(new Observation("Congratulations! you are the winner!!" + "\nPlease enter anything to return to main menu."));
        LevelIterator.reset();
        String input = game.getInput().receiveInputAsString();
        game.setNextScene(new StartScene());
    }
}
