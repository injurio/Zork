package zork.items;

import zork.game.Game;
import zork.game.Observation;
import zork.location.rooms.EscapeRoom;

public class Key extends Item {

    public Observation use(Game game){
        Observation observation;
        if (game.getCurrentLevel().getCurrentRoom() instanceof EscapeRoom){
            observation = game.getCurrentLevel().getCurrentRoom().roomAction(game);
        }else {
            observation = new Observation("cannot use the key now");
        }
        return observation;
    }

    @Override
    public boolean canRunOut() {
        return true;
    }

    @Override
    public Observation drop(Game game) {
        return null;
    }
}
