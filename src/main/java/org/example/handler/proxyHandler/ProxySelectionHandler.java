package org.example.handler.proxyHandler;

import lombok.SneakyThrows;
import org.example.handler.FileHandler;
import org.example.bot.settings.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.handler.proxyHandler.ProxyPathsConst.*;

public class ProxySelectionHandler extends TelegramLongPollingBot {

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
                case "22":
                    execute(FileHandler.sendFile(chat_id, TWENTY_TWO));
                    logger.log("Запрошена доверенность на представление организации юристом");
                    break;

                case "23":
                    execute(FileHandler.sendFile(chat_id, TWENTY_THREE));
                    logger.log("Запрошена доверенность на получение стипенции");
                    break;

                case "24":
                    execute(FileHandler.sendFile(chat_id, TWENTY_FOUR));
                    logger.log("Запрошена доверенность на управление квартирой");
                    break;

                case "25":
                    execute(FileHandler.sendFile(chat_id, TWENTY_FIVE));
                    logger.log("Запрошена доверенность на получение пенсии");
                    break;

                case "26":
                    execute(FileHandler.sendFile(chat_id, TWENTY_SIX));
                    logger.log("Запрошена доверенность на получение зарплаты");
                    break;

                case "27":
                    execute(FileHandler.sendFile(chat_id, TWENTY_SEVEN));
                    logger.log("Запрошена доверенность на оплату обучения");
                    break;

                case "28":
                    execute(FileHandler.sendFile(chat_id, TWENTY_EIGHT));
                    logger.log("Запрошена доверенность на получение корреспонденции");
                    break;

                case "29":
                    execute(FileHandler.sendFile(chat_id, TWENTY_NINE));
                    logger.log("Запрошена доверенность на право забирать ребенка из ДС и школы");
                    break;

                case "30":
                    execute(FileHandler.sendFile(chat_id, THIRTY));
                    logger.log("Запрошена доверенность на сопровождение ребенка по поездке по РФ");
                    break;
            }
        }
    }

}
