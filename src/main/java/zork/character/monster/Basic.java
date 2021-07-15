package zork.character.monster;

import zork.character.Character;
import zork.game.Observation;

public class Basic extends Monster{

    // setting the health for the basic monster
    private static final int basic_max_health = 10;

    // setting the max attack for the basic monster
    private static final int basic_max_attack = 3;


    @Override
    public Observation doInTurn(Character c) {
        Observation ob = new Observation("The monster is attacking you.");
        basic_attack(c, ob);
        return ob;
    }

    @Override
    public int get_max_health() {
        return basic_max_health;
    }

    @Override
    public int get_max_attack() {
        return basic_max_attack;
    }

    // normal monster does not have critical attack
    @Override
    public int get_critical_attack() {
        return 0;
    }
}
