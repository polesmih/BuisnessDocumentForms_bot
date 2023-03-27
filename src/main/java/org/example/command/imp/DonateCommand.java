package org.example.command.imp;

import org.example.command.Command;
import org.example.handler.HandlerContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.example.bot.settings.StringConst.DOG;

public class DonateCommand implements Command {
    public final static String DOG_SHELTER = "Хочешь меня отблагодарить?\n" +
            "Помоги Фонду\n<a href=\"https://donate.priut.ru\">Помощь бездомным собакам</a> " + DOG;

    @Override
    public void execute(HandlerContext context, Message message) {
        var userFrom = message.getFrom();

        context.getMessageSenderService().sendMessage(SendMessage.builder()
                .chatId(userFrom.getId())
                .text(DOG_SHELTER)
                .parseMode("html")
                .build());
    }
}