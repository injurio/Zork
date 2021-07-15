package zork.character.monster;

import zork.character.Character;
import zork.game.AttackOb;
import zork.game.Observation;

public class Advance extends Monster{

    private static final int advance_max_health = 20;
    private static final int advance_max_attack = 5;
    private static final int advance_critical_attack = 5;
    private static final double half_attack_pos = 0.1;

    @Override
    public Observation doInTurn(Character c) {
        if (rand.nextDouble() < half_attack_pos) {
            Observation ob = new Observation("Monster divides your health by a half");
            AttackOb ao = new AttackOb.Builder().damage(c.getHealth()/2).build();
            c.getAttacked(ao, ob);
            return ob;
        }else if (health < 4){ // if advance monster health less than 4, it will do critical damage
            Observation ob = new Observation("Monster critical hit");
            critical_attack(c, ob);
            return ob;
        }else {
            Observation ob = new Observation("Normal attack.");
            basic_attack(c, ob);
            return ob;
        }
    }

    @Override
    public int get_max_health() {
        return advance_max_health;
    }

    @Override
    public int get_max_attack() {
        return advance_max_attack;
    }

    @Override
    public int get_critical_attack() {
        return advance_critical_attack;
    }
}
