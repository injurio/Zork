package zork.command.walk;

import zork.command.Command;
import zork.command.CommandFactory;

import java.util.ArrayList;
import java.util.List;

public class WalkCommandFactory extends CommandFactory {

    @Override
    public List<Command> getCommands() {
        return commands;
    }

    private List<Command> commands = new ArrayList<Command>(){{
        add(new Up());
        add(new Down());
        add(new Left());
        add(new Right());
    }};
}
