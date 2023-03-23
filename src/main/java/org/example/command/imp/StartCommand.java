package org.example.command.imp;

import org.example.command.Command;
import org.example.entity.BotUser;
import org.example.handler.HandlerContext;
import org.example.service.BotUserService;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDateTime;

public class StartCommand implements Command {
    private final BotUserService botUserService;
    public final static String HELLO_MSG = "!\nЭтот бот знает формы некоторых документов," +
            "которые тебе могут пригодиться." +
            "\nВведи команду /key";

    public StartCommand(BotUserService botUserService) {
        this.botUserService = botUserService;
    }

    @Override
    public void execute(HandlerContext context, Message message) {
        User userFrom = message.getFrom();

        if (botUserService.findById(userFrom.getId()) == null) {
            BotUser botUser = BotUser.builder()
                    .id(userFrom.getId())
                    .firstName(userFrom.getFirstName())
                    .lastName(userFrom.getLastName())
                    .userName(userFrom.getUserName())
                    .dateCreate(LocalDateTime.now())
                    .build();

            botUserService.add(botUser);
        }

        var response = "Привет, " + userFrom.getFirstName() + HELLO_MSG;
        context.getMessageSenderService().sendMessage(userFrom.getId(), response);
    }
}