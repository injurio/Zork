package zork.character;

import zork.game.AttackOb;
import zork.game.Observation;

import java.util.Random;

// this class contain the thing that Character จะมีหรือถูกกระทำได้ in this class Character should be able to have
// 1. health
// 2. be attacked by other character

public abstract class Character {

    protected Random rand = new Random();
    protected int health;
    protected boolean isAlive;

    // declare that character is not death
    public Character(){
        isAlive = true;
    }

    public abstract void getAttacked(AttackOb ao, Observation ob);

    // return the HP of the character
    public int getHealth(){
        return health;
    }
}
