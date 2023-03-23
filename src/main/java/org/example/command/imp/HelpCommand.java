package org.example.command.imp;

import org.example.command.Command;
import org.example.handler.HandlerContext;
import org.telegram.telegrambots.meta.api.objects.Message;

public class HelpCommand implements Command {

    @Override
    public void execute(HandlerContext context, Message message) {
        var userFrom = message.getFrom();

        var response = "Список доступных команд:\n\n" +
                "/start - запустить бота\n/key - запросить клавиатуру\n" +
                "/donate - поддержать проект\n/help - список команд";

        context.getMessageSenderService().sendMessage(userFrom.getId(), response);
    }
}