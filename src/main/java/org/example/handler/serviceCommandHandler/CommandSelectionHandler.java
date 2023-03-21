package org.example.handler.serviceCommandHandler;

import lombok.SneakyThrows;
import org.example.bot.Bot;
import org.example.bot.settings.CommandConst;
import org.example.bot.settings.Logger;
import org.example.bot.settings.MessagesConst;
import org.example.dao.BotUserService;
import org.example.dao.imp.BotUserServiceImp;
import org.example.entity.BotUser;
import org.example.handler.MessageHandler;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.time.LocalDateTime;

import static org.example.bot.settings.CommandConst.KEY;
import static org.example.bot.settings.CommandConst.START;
import static org.example.bot.settings.MessagesConst.HELLO;

public class CommandSelectionHandler {
    private final Bot bot;
    private final Logger logger;
    private final Keyboard keyboard;
    private final BotUserService botUserService;

    public CommandSelectionHandler(Bot bot) {
        this.bot = bot;
        this.logger = new Logger();
        this.keyboard = new Keyboard();
        this.botUserService = new BotUserServiceImp();
    }

    @SneakyThrows
    public void onUpdateReceived(Update update) {
        long chatId = update.getMessage().getChatId();

        if (update.hasMessage() && update.getMessage().hasText()) {
            switch (update.getMessage().getText()) {
                case START:
                    bot.execute(MessageHandler.sendMessage(chatId, HELLO));

                    User userFrom = update.getMessage().getFrom();
                    BotUser botUser = BotUser.builder()
                            .id(userFrom.getId())
                            .firstName(userFrom.getFirstName())
                            .lastName(userFrom.getLastName())
                            .userName(userFrom.getUserName())
                            .dateCreate(LocalDateTime.now())
                            .build();

                    botUserService.add(botUser);

                    logger.log("Подключился пользователь");
                    break;

                case KEY:
                    keyboard.onUpdateReceived(update);
                    logger.log("Запрошена клавиатура");
                    break;

                case CommandConst.INFO:
                    long countUser = botUserService.getUserCount();
                    bot.execute(MessageHandler.sendMessage(chatId, MessagesConst.INFO + countUser));

                    logger.log("Запрошены сведения о пользователях");
                    break;
            }
        }
    }
}