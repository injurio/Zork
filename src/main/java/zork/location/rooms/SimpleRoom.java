package zork.location.rooms;

import zork.game.Game;
import zork.game.Observation;

public class SimpleRoom extends Room {

    private static final boolean canWalk = true;

    public SimpleRoom(){
        super();
    }

    @Override
    public boolean canWalk() {
        return canWalk;
    }

    @Override
    protected String roomMessage() {
        return null;
    }

    @Override
    public Observation roomAction(Game game) {
        return new Observation("Wow this room has nothing!");
    }
}
