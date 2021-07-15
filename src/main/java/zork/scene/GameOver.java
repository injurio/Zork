package zork.scene;

import zork.game.Game;
import zork.game.Observation;
import zork.location.level.LevelIterator;

public class GameOver extends Scene {
    @Override
    public void playScene(Game game) {
        game.notifyObserver(new Observation("Game Over! you are death" +
                "\nPlease enter anything to return to main menu."));
        game.getPlayer().reset();
        LevelIterator.reset();
        String input = game.getInput().receiveInputAsString();
        game.setNextScene(new StartScene());
    }
}
