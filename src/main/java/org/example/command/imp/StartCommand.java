package org.example.command.imp;

import org.example.command.Command;
import org.example.entity.BotUser;
import org.example.handler.HandlerContext;
import org.example.service.BotUserService;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDateTime;

import static org.example.bot.settings.StringConst.HI;

public class StartCommand implements Command {
    private final BotUserService botUserService;
    public final static String HELLO_MSG = "! " + HI + "\nЭтот бот знает формы некоторых документов," +
            "которые тебе могут пригодиться." +
            "\nВведи команду /key";

    public StartCommand(BotUserService botUserService) {
        this.botUserService = botUserService;
    }

    @Override
    public void execute(HandlerContext context, Message message) {
        User userFrom = message.getFrom();

        BotUser botUser = botUserService.findById(userFrom.getId());

        if (botUser == null) {
            botUser = BotUser.builder()
                    .id(userFrom.getId())
                    .firstName(userFrom.getFirstName())
                    .lastName(userFrom.getLastName())
                    .userName(userFrom.getUserName())
                    .dateCreate(LocalDateTime.now())
                    .countVisits(1L)
                    .build();

            botUserService.add(botUser);
        }
        else {
            botUser.setCountVisits(botUser.getCountVisits() + 1);
            botUserService.update(botUser);
        }

        var response = "Привет, " + userFrom.getFirstName() + HELLO_MSG;
        context.getMessageSenderService().sendMessage(userFrom.getId(), response);
    }
}