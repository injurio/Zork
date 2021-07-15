package zork.character.monster;

import zork.character.Character;
import zork.game.Observation;

public class Boss extends Monster {

    private static final int boss_max_health = 40;
    private static final int boss_max_attack = 10;
    private static final int boss_critical_attack = 15;

    @Override
    public Observation doInTurn(Character c) {
        if (health < 2){ // if boss monster health less than 2, it will do critical damage
            Observation ob = new Observation("Boss critical hit");
            critical_attack(c, ob);
            return ob;
        }else {
            Observation ob = new Observation("Boss attack.");
            basic_attack(c, ob);
            return ob;
        }
    }

    @Override
    public int get_max_health() {
        return boss_max_health;
    }

    @Override
    public int get_max_attack() {
        return boss_max_attack;
    }

    @Override
    public int get_critical_attack() {
        return boss_critical_attack;
    }
}
