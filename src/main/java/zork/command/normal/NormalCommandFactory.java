package zork.command.normal;

import zork.command.Command;
import zork.command.CommandFactory;

import java.util.ArrayList;
import java.util.List;

public class NormalCommandFactory extends CommandFactory {

    private List<Command> commands = new ArrayList<Command>(){{
        add(new Start());
        add(new Exit());
    }};

    @Override
    public List<Command> getCommands() {
        return commands;
    }
}
