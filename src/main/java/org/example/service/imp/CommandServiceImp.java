package org.example.service.imp;

import com.google.common.collect.ImmutableMap;
import org.example.command.Command;
import org.example.command.imp.*;
import org.example.service.CommandService;

import static org.example.command.enums.CommandName.*;

public class CommandServiceImp implements CommandService {

    private final Command unknownCommand;
    private final ImmutableMap<String, Command> commandMap;

    public CommandServiceImp() {
        this.unknownCommand = new UnknownCommand();
        this.commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand())
                .put(KEY.getCommandName(), new KeyCommand())
                .put(INFO.getCommandName(), new KeyCommand())
                .put(DONATE.getCommandName(), new DonateCommand())
                .put(HELP.getCommandName(), new HelpCommand())
                .build();
    }

    @Override
    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
