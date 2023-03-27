package org.example.handler.handlers;

import org.example.handler.AbstractHandler;
import org.example.handler.HandlerContext;
import org.example.service.CommandService;
import org.telegram.telegrambots.meta.api.objects.Message;

public class CommandHandler extends AbstractHandler {
    private final CommandService commandService;

    public CommandHandler(HandlerContext context,
                          CommandService commandService) {
        super(context);
        this.commandService = commandService;
    }

    @Override
    public void handling(Message message) {
        commandService.retrieveCommand(message.getText()).execute(context, message);
    }
}