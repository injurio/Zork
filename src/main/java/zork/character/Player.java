package zork.character;

import zork.game.AttackOb;
import zork.game.Observation;
import zork.items.Item;
import zork.items.itemUseInFight.RedPotion;

import java.util.HashMap;
import java.util.Map;

public class Player extends Character{

    private int x_coordinate;
    private int y_coordinate;

    private Map<Class<? extends Item>, Integer> inventory;
    private int size_inventory;
    private static final int MAX_SIZE_INVENTORY = 12;

    private int mana;
    private int blockAmount;


    // setting the conditions at the starting game
    private static final int Current_Max_Player_Health = 30;
    private static final int Current_Max_Player_MANA = 10;
    private static final int Current_Max_Player_Attack = 10;

    // number that will go up in the game
    private int max_player_health;
    private int max_player_mana;
    private int max_player_attack;

    // mana amounts
    private static final int Mana_For_Critical_Hit = 7;

    private static Player player = new Player();

    public Player(){
        super();
        max_player_health = Current_Max_Player_Health;
        max_player_mana = Current_Max_Player_MANA;
        max_player_attack = Current_Max_Player_Attack;
        health = max_player_health;
        mana = max_player_mana;
        inventory = new HashMap<Class<? extends Item>, Integer>();
        getItem(new RedPotion());
    }

    public void reset(){
        max_player_health = Current_Max_Player_Health;
        max_player_mana = Current_Max_Player_MANA;
        max_player_attack = Current_Max_Player_Attack;
        health = max_player_health;
        mana = max_player_mana;
        inventory = new HashMap<Class<? extends Item>, Integer>();
        getItem(new RedPotion());
    }

    // the defend condition;
    public void defend() {
        blockAmount = rand.nextInt(max_player_attack / 2) + max_player_attack/2;
    }

    // the number of normal attack
    public AttackOb attack(){
        int attackAmount = rand.nextInt(max_player_attack / 2) + max_player_attack / 2;
        return new AttackOb.Builder().damage(attackAmount).build();
    }

    // the number of critical attack
    public AttackOb criticalAttack(){
        if (mana >= Mana_For_Critical_Hit){
            mana -= Mana_For_Critical_Hit;
            int attackAmount = rand.nextInt(max_player_attack)+max_player_attack;
            return new AttackOb.Builder().damage(attackAmount).build();
        }else
            return null;
    }

    @Override
    public void getAttacked(AttackOb ao, Observation ob) {

        int attackAmount = ao.getDamage() - blockAmount;
        if (attackAmount > 0){
            health -= attackAmount;
            if (health <= 0){   // if HP below 0, you're death
                isAlive = false;
            }
        }else {
            ob.addMessage("You are strong enough to block this attack");
        }
        blockAmount = 0;
    }

    public static Player getPlayer(){
        return player;
    }

    public void place_player(int x_coordinate, int y_coordinate){
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public int getx_coordinate(){
        return x_coordinate;
    }

    public int gety_coordinate(){
        return y_coordinate;
    }

    public void walkUp(){  // เดินขึ้น y-coordinate ก็เปลี่ยน
        y_coordinate--;
    }

    public void walkDown(){  // เดินลง y-coordinate ก็เปลี่ยน
        y_coordinate++;
    }

    public void walkLeft(){
        x_coordinate--;
    }

    public void walkRight(){
        x_coordinate++;
    }

    public void increase_health(int healthAmount){
        if (health + healthAmount <= max_player_health){
            health += healthAmount;
        }
    }

    public void increase_health(){
        increase_health(1);
    }

    public void increase_max_health(){
        max_player_health++;
    }

    public void increase_max_health(int increase){
        max_player_health += increase;
    }

    public void increase_max_mana(){
        max_player_mana++;
    }

    public void increase_max_mana(int increase){
        max_player_mana += increase;
    }

    public void increase_max_attack(){
        max_player_attack++;
    }

    public void increase_mana(int manaAmount){
        if (mana + manaAmount <= max_player_mana){
            mana += manaAmount;
        }
    }

    public void increase_mana(){
        increase_mana(1);
    }

    public boolean isAlive(){
        return health > 0;
    }

    /// if you have item and item is not 0 - True
    /// otherwise False
    public boolean hasItem(Class<? extends Item> itemType){
        return inventory.containsKey(itemType) && inventory.get(itemType) > 0;
    }

    public Item retrieveItem(Class<? extends Item> itemType){
        try{
            Item newItem = itemType.getConstructor().newInstance();
            if (newItem.canRunOut()) {
                if (inventory.get(itemType) - 1 > 0){
                    inventory.put(itemType, inventory.get(itemType)-1);
                }else{
                    inventory.remove(itemType);
                }
                size_inventory--;
            }
            return newItem;
        }catch (Exception e){
            return null;
        }
    }

    public Observation getItem(Item item){
        if (size_inventory < MAX_SIZE_INVENTORY){
            Class<? extends Item> itemType = item.getClass();
            if (inventory.containsKey(itemType)){
                inventory.put(itemType, inventory.get(itemType)+1);
            }else {
                inventory.put(itemType, 1);
            }
            size_inventory++;
            return new Observation("You get a " + itemType.getSimpleName()+ ".");
        }else {
            return new Observation("You cannot get the item, inventory is full");
        }
    }

    public Item dropItem(Class<? extends Item> itemType){
        try{
            Item newItem = itemType.getConstructor().newInstance();
            if (newItem.canRunOut()) {
                if (inventory.get(itemType) - 1 > 0){
                    inventory.put(itemType, inventory.get(itemType)-1);
                }else{
                    inventory.remove(itemType);
                }
                size_inventory--;
            }
            return newItem;
        }catch (Exception e){
            return null;
        }
    }


    public Map<Class<? extends Item>, Integer> getInventory(){
        return inventory;
    }

    public int getMana(){
        return mana;
    }

    public int getMax_player_health(){
        return max_player_health;
    }

    public int getMax_player_attack(){
        return max_player_attack;
    }

    public int getMax_player_mana(){
        return max_player_mana;
    }

    public void setHealth(int newHealth){
        this.health = newHealth;
    }

    public void setMana(int newMana){
        this.mana = newMana;
    }

    public void setMax_player_attack(int max_player_attack){
        this.max_player_attack = max_player_attack;
    }

}
