package org.example.command.imp;

import org.example.command.Command;
import org.example.component.Keyboards;
import org.example.handler.HandlerContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.example.bot.settings.StringConst.DOWN;

public class KeyCommand implements Command {
    private static final String CHOOSE = "На появившейся клавиатуре выбери нужный вид документов " + DOWN;

    @Override
    public void execute(HandlerContext context, Message message) {
        var userFrom = message.getFrom();

        context.getMessageSenderService().sendMessage(SendMessage.builder()
                .chatId(userFrom.getId())
                .text(CHOOSE)
                .replyMarkup(Keyboards.mainKeyboard())
                .build());
    }
}