package zork.command.fight;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;
import zork.items.Item;
import zork.items.itemUseInFight.FightItem;

public class UseItem implements Command {
    @Override
    public Observation do_the_command(Game game) {
        Observation ob = null;
        game.notifyObserver(new Observation("What do you want to use?"));
        for (Class<? extends Item> itemType: game.getPlayer().getInventory().keySet()){
            new Observation(itemType.getSimpleName().toLowerCase() + ", ");
        }
        String input = game.getInput().receiveInputAsString().toLowerCase();
        for (Class<? extends Item> itemType: game.getPlayer().getInventory().keySet()){
            if(input.startsWith(itemType.getSimpleName().toLowerCase())){
                if (FightItem.class.isAssignableFrom(itemType)) {
                    ob = game.getPlayer().retrieveItem(itemType).use(game);
                    game.getCurrentFight().toggleTurnCompleted();
                } else{
                    ob = new Observation("Cannot use this item here!");
                }
                break;
            }
        }
        if (ob == null){
            ob = new Observation("This item does not exist! Bruh!");
        }
        return ob;
    }

    @Override
    public String get_name_command() {
        return "use item";
    }
}
