package org.example.handler.serviceCommandHandler;

import lombok.SneakyThrows;
import org.example.db.UserConnection;
import org.example.db.WriteUser;
import org.example.handler.MessageHandler;
import org.example.bot.settings.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.example.bot.settings.CommandConst.*;
import static org.example.bot.settings.MessagesConst.*;

public class CommandSelectionHandler extends TelegramLongPollingBot {

    long chat_id;
    Logger logger = new Logger();
    private final static ConfigSettings settings = ConfigSettings.getInstance();
    Keyboard keyboard = new Keyboard();

    @Override
    public String getBotUsername() {
        return settings.getUserName();
    }

    @Override
    public String getBotToken() {
        return settings.getToken();
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        update.getUpdateId();
        chat_id = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());

        if (update.hasMessage() && update.getMessage().hasText()) {

            switch (update.getMessage().getText()) {

                case START:

                    execute(MessageHandler.sendMessage(chat_id, HELLO));

                    Message message = update.getMessage();
                    User from = message.getFrom();
                    Date date = Date.valueOf(LocalDate.now());

                    WriteUser.writeUserIntoDb(date, from.getId(), from.getFirstName());

                    logger.log("Подключился пользователь");
                    break;

                case KEY:
                    keyboard.onUpdateReceived(update);

                    logger.log("Запрошена клавиатура");
                    break;

                case CommandConst.INFO:
                    execute(MessageHandler.sendMessage(chat_id,
                            MessagesConst.INFO + UserConnection.numberOfVisits()));

                    logger.log("Запрошены сведения о пользователях");
                    break;
            }
        }
    }

}
