package zork.character.monster;

import zork.character.Character;
import zork.game.AttackOb;
import zork.game.Observation;

public abstract class Monster extends Character {

    public abstract Observation doInTurn(Character c);

    public abstract int get_max_health();

    public abstract int get_max_attack();

    public abstract int get_critical_attack();

    public Monster(){
        health = get_max_health();
    }

    public void getAttacked(AttackOb ao, Observation ob){
        health -= ao.getDamage();
        if (health <= 0){
            isAlive = false;
        }
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void basic_attack(Character c, Observation ob){
        int attackLevel = rand.nextInt(get_max_attack() + 1);
        AttackOb attackOb = new AttackOb.Builder().damage(attackLevel).build();
        c.getAttacked(attackOb, ob);
        ob.addMessage("Monster attacks with " + attackLevel + " damage");
    }

    public void critical_attack(Character c, Observation ob){
        int attackLevel = rand.nextInt(get_max_attack() + (get_critical_attack() - 1));
        AttackOb attackOb = new AttackOb.Builder().damage(attackLevel).build();
        c.getAttacked(attackOb, ob);
        ob.addMessage("Monster makes critical attack with " + attackLevel + " damage");
    }





}
