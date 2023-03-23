package org.example.command.imp;

import org.example.command.Command;
import org.example.handler.HandlerContext;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.example.bot.settings.StringConst.UNKNOWN;

public class UnknownCommand implements Command {

    @Override
    public void execute(HandlerContext context, Message message) {
        var userFrom = message.getFrom();
        context.getMessageSenderService().sendMessage(userFrom.getId(), UNKNOWN);
    }
}