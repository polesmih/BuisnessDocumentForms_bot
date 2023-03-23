package org.example.command.imp;

import org.example.command.Command;
import org.example.handler.HandlerContext;
import org.telegram.telegrambots.meta.api.objects.Message;

public class InfoCommand implements Command {
    @Override
    public void execute(HandlerContext context, Message message) {
        var userFrom = message.getFrom();

        var response = "Команда в разработке...";
        context.getMessageSenderService().sendMessage(userFrom.getId(), response);
    }
}
