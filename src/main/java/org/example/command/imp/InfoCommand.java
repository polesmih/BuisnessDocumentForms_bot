package org.example.command.imp;

import org.example.command.Command;
import org.example.handler.HandlerContext;
import org.example.service.BotUserService;
import org.telegram.telegrambots.meta.api.objects.Message;

import static org.example.bot.settings.StringConst.VISIT;

public class InfoCommand implements Command {
    private final BotUserService botUserService;

    public InfoCommand(BotUserService botUserService) {
        this.botUserService = botUserService;
    }

    @Override
    public void execute(HandlerContext context, Message message) {
        var userFrom = message.getFrom();

        var response = "Количество посещений " + VISIT + " " + botUserService.getUserCount();
        context.getMessageSenderService().sendMessage(userFrom.getId(), response);
    }
}
