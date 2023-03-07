package org.example.handler.vouchersHandler;

import lombok.SneakyThrows;
import org.example.handler.FileHandler;
import org.example.bot.settings.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.handler.vouchersHandler.VouchersPathsConst.*;

public class VouchersSelectionHandler extends TelegramLongPollingBot {

    long chat_id;

    Logger logger = new Logger();

    private final static ConfigSettings settings = ConfigSettings.getInstance();

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
                case "31":
                    execute(FileHandler.sendFile(chat_id, THIRTY_ONE));
                    logger.log("Запрошена расписка за оплату авто");
                    break;

                case "32":
                    execute(FileHandler.sendFile(chat_id, THIRTY_TWO));
                    logger.log("Запрошена расписка в получении денег");
                    break;

                case "33":
                    execute(FileHandler.sendFile(chat_id, THIRTY_THREE));
                    logger.log("Запрошена расписка в получении документов");
                    break;

                case "34":
                    execute(FileHandler.sendFile(chat_id, THIRTY_FOUR));
                    logger.log("Запрошена расписка в получении трудовой книжки");
                    break;

                case "35":
                    execute(FileHandler.sendFile(chat_id, THIRTY_FIVE));
                    logger.log("Запрошена сохранная расписка");
                    break;
            }
        }
    }
}
