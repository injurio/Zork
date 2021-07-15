package zork.location.rooms;

import zork.character.monster.Monster;
import zork.game.Game;
import zork.game.Observation;
import zork.items.Item;

public abstract class Room {

    private Monster monster;
    private Item item;

    Room(Monster monster){
        this.monster = monster;
    }

    Room(){
        this.monster = null;
    }

    public abstract boolean canWalk();

    public void putItem(Item item){
        if(canWalk()) {
            this.item = item;
        }
    }

    public Item pickItem(){
        Item itemHere = this.item;
        this.item = null;
        return itemHere;
    }

    public boolean hasItem(){
        return this.item != null;
    }

    public void putMonster(Monster monster){
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean hasMonster(){
        return monster != null;
    }

    public Observation getRoomMessage(){
        StringBuilder sb = new StringBuilder();
        if (roomMessage() != null){
            sb.append(roomMessage());
        }
        if (hasItem()){
            sb.append("In the room there is a ").append(item.getClass().getSimpleName());
        }
        if (sb.length() > 0) {
            return new Observation(sb.toString());
        } else return null;
    }

    protected abstract String roomMessage();

    public abstract Observation roomAction(Game game);
}
