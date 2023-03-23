package org.example.service.imp;

import com.google.common.collect.ImmutableMap;
import org.example.command.Command;
import org.example.command.imp.*;
import org.example.service.BotUserService;
import org.example.service.CommandService;

import static org.example.command.enums.CommandName.*;

public class CommandServiceImp implements CommandService {

    private final Command unknownCommand;
    private static volatile CommandServiceImp instance;
    private final ImmutableMap<String, Command> commandMap;

    private CommandServiceImp() {
        BotUserService botUserService = BotUserServiceImp.getInstance();

        this.unknownCommand = new UnknownCommand();
        this.commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(botUserService))
                .put(KEY.getCommandName(), new KeyCommand())
                .put(INFO.getCommandName(), new InfoCommand())
                .put(DONATE.getCommandName(), new DonateCommand())
                .put(HELP.getCommandName(), new HelpCommand())
                .build();
    }

    public static CommandServiceImp getInstance() {
        if (instance == null) {
            synchronized (CommandServiceImp.class) {
                if (instance == null) {
                    instance = new CommandServiceImp();
                }
            }
        }
        return instance;
    }

    @Override
    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}