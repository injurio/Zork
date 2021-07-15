package zork.location.rooms;

import zork.game.Game;
import zork.game.Observation;

public class RoomThatCanFall extends Room {

    @Override
    public boolean canWalk() {
        return true;
    }

    @Override
    protected String roomMessage() {
        return "The floor is very weak. be careful!";
    }

    @Override
    public Observation roomAction(Game game) {
        game.getCurrentLevel().toggleCompleted();
        return new Observation("Boom!!!, you break the floor, and now you fell to somewhere");
    }
}
