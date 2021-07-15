package zork.location.rooms;

import zork.game.Game;
import zork.game.Observation;

public class Wall extends Room {

    public Wall(){
        super();
    }

    @Override
    public boolean canWalk() {
        return false;
    }

    @Override
    protected String roomMessage() {
        return null;
    }

    @Override
    public Observation roomAction(Game game) {
        return new Observation("this is a wall");
    }
}
