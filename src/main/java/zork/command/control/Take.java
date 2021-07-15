package zork.command.control;

import zork.command.Command;
import zork.game.Game;
import zork.game.Observation;
import zork.items.Item;
import zork.location.rooms.Room;

public class Take implements Command {
    @Override
    public Observation do_the_command(Game game) {
        Room currentRoom = game.getCurrentLevel().getCurrentRoom();
        if (currentRoom.hasItem()){
            Item item = currentRoom.pickItem();
            game.getPlayer().getItem(item);
            return new Observation("Picked up " + item.getClass().getSimpleName());
        } else{
            return new Observation("Nothing to pick up here.");
        }
    }

    @Override
    public String get_name_command() {
        return "take";
    }
}
