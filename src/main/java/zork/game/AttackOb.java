package zork.game;

public class AttackOb {

    private int damage;


    // get the damage
    public int getDamage(){
        return damage;
    }


    public static class Builder {

        private int damage = 0;
        private int StunTurn = 0;

        // set the damage from in the class
        public Builder damage(int damage){
            this.damage = damage;
            return this;
        }


        public AttackOb build(){
            AttackOb attackObjective = new AttackOb();
            attackObjective.damage = this.damage;
            return attackObjective;
        }

    }

}
