package zork.command.fight;

import zork.command.Command;
import zork.command.CommandFactory;

import java.util.ArrayList;
import java.util.List;

public class FightCommand extends CommandFactory {

    private List<Command> commands = new ArrayList<Command>(){{
        add(new Attack());
        add(new Block());
        add(new Critical());
        add(new UseItem());
    }};

    @Override
    public List<Command> getCommands() {
        return commands;
    }
}
