package zork.location.rooms;

import zork.game.Game;
import zork.game.Observation;

public class EscapeRoom extends Room {
    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    protected String roomMessage() {
        return "There is a door in here. It is locked. T T";
    }

    @Override
    public Observation roomAction(Game game) {
        game.getCurrentLevel().toggleCompleted();
        return new Observation("the door is unlocked. Yeah!!!");
    }
}
