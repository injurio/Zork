package zork.items;

import zork.game.Game;
import zork.game.Observation;

public abstract class Item {

    // each item should be usable
    public abstract Observation use(Game game);

    // each item can be run out
    public abstract boolean canRunOut();

    // each item can be drop
    public abstract Observation drop(Game game);
}
