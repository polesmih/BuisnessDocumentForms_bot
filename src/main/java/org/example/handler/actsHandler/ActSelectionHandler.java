package org.example.handler.actsHandler;

import lombok.SneakyThrows;
import org.example.handler.FileHandler;
import org.example.bot.settings.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.handler.actsHandler.ActsPathsConst.*;

public class ActSelectionHandler extends TelegramLongPollingBot {


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
                case "12":
                    execute(FileHandler.sendFile(chat_id, TWELVE));
                    logger.log("Запрошен акт приема-передачи ТС");
                    break;

                case "13":
                    execute(FileHandler.sendFile(chat_id, THIRTEEN));
                    logger.log("Запрошен акт приема-передачи квартиры в аренду");
                    break;

                case "14":
                    execute(FileHandler.sendFile(chat_id, FOURTEEN));
                    logger.log("Запрошен акт вскрытия квартиры арендодателем");
                    break;

                case "15":
                    execute(FileHandler.sendFile(chat_id, FIFTEEN));
                    logger.log("Запрошен акт приема-передачи квартиры при покупке");
                    break;

                case "16":
                    execute(FileHandler.sendFile(chat_id, SIXTEEN));
                    logger.log("Запрошен акт отсутствия работника на рабочем месте");
                    break;

                case "17":
                    execute(FileHandler.sendFile(chat_id, SEVENTEEN));
                    logger.log("Запрошен акт о невыполнении основных обязанностей");
                    break;

                case "18":
                    execute(FileHandler.sendFile(chat_id, EIGHTEEN));
                    logger.log("Запрошен акт сверки взаиморасчетов");
                    break;

                case "19":
                    execute(FileHandler.sendFile(chat_id, NINETEEN));
                    logger.log("Запрошен акт об утрате документов");
                    break;

                case "20":
                    execute(FileHandler.sendFile(chat_id, TWENTY));
                    logger.log("Запрошен акт оказания юр.услуг");
                    break;

                case "21":
                    execute(FileHandler.sendFile(chat_id, TWENTY_ONE));
                    logger.log("Запрошен приема-передачи документов при переводе долга");
                    break;
            }
        }
    }
}
