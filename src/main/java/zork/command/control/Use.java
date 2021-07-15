package zork.command.control;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;
import zork.items.Item;

import java.util.Iterator;

public class Use implements Command {
    @Override
    public Observation do_the_command(Game game) {
        Observation ob = null;

        if (game.getPlayer().getInventory().isEmpty()){
            System.out.println("> your inventory is empty");
        }

        game.notifyObserver(new Observation("> What Items do you want to use"));

        Iterator<Class<? extends Item>> iterator = game.getPlayer().getInventory().keySet().iterator();
        while (iterator.hasNext()){
            Class<? extends Item> item = iterator.next();
            System.out.println(item.getSimpleName() + ": " + game.getPlayer().getInventory().get(item));
        }

        String input = game.getInput().receiveInputAsString().toLowerCase();
        for (Class<? extends Item> itemType: game.getPlayer().getInventory().keySet()){
            if (input.startsWith(itemType.getSimpleName().toLowerCase())){
                ob = game.getPlayer().retrieveItem(itemType).use(game);
                break;
            }
        }
        if (ob == null){
            ob = new Observation("This item does not exit!!");
        }
        return ob;
    }

    @Override
    public String get_name_command() {
        return "use";
    }
}
