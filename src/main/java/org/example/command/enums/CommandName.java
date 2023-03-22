package org.example.command.enums;

public enum CommandName {
    START("/start"),
    KEY("/key"),
    INFO("/info"),
    DONATE("/donate"),
    HELP("/help");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}