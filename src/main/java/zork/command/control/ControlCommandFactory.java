package zork.command.control;

import zork.command.Command;
import zork.command.CommandFactory;

import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.List;

public class ControlCommandFactory extends CommandFactory {

    private List<Command> commands = new ArrayList<Command>(){{
        add(new Info());
        add(new Map());
        add(new Take());
        add(new Drop());
        add(new Use());
        add(new Quite());
    }};

    @Override
    public List<Command> getCommands() {
        return commands;
    }
}
