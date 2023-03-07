package org.example.handler.claimsHandler;

import lombok.SneakyThrows;
import org.example.handler.FileHandler;
import org.example.bot.settings.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.handler.claimsHandler.ClaimsPathsConst.*;

public class ClimesSelectionHandler extends TelegramLongPollingBot {

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
                case "36":
                    execute(FileHandler.sendFile(chat_id, THIRTY_SIX));
                    logger.log("Запрошен иск о взыскании по займу");
                    break;

                case "37":
                    execute(FileHandler.sendFile(chat_id, THIRTY_SEVEN));
                    logger.log("Запрошен иск о расторжении брака");
                    break;

                case "38":
                    execute(FileHandler.sendFile(chat_id, THIRTY_EIGHT));
                    logger.log("Запрошен иск о взыскании алиментов");
                    break;

                case "39":
                    execute(FileHandler.sendFile(chat_id, THIRTY_NINE));
                    logger.log("Запрошен иск об обжаловании взыскания");
                    break;

                case "40":
                    execute(FileHandler.sendFile(chat_id, FORTY));
                    logger.log("Запрошен иск о восстановлении на работе");
                    break;

                case "41":
                    execute(FileHandler.sendFile(chat_id, FORTY_ONE));
                    logger.log("Запрошен иск о взыскании зарплаты");
                    break;

                case "42":
                    execute(FileHandler.sendFile(chat_id, FORTY_TWO));
                    logger.log("Запрошен иск о выселении из квартиры");
                    break;

                case "43":
                    execute(FileHandler.sendFile(chat_id, FORTY_THREE));
                    logger.log("Запрошен иск обжалования продажи доли в квартире");
                    break;

                case "44":
                    execute(FileHandler.sendFile(chat_id, FORTY_FOUR));
                    logger.log("Запрошен иск о взыскании неосновательного обогащения");
                    break;

                case "45":
                    execute(FileHandler.sendFile(chat_id, FORTY_FIVE));
                    logger.log("Запрошены возражения на иск");
                    break;

                case "46":
                    execute(FileHandler.sendFile(chat_id, FORTY_SIX));
                    logger.log("Запрошено заявление о выдаче судебного приказа");
                    break;

                case "47":
                    execute(FileHandler.sendFile(chat_id, FORTY_SEVEN));
                    logger.log("Запрошено заявление о возбуждении исполнительного производства");
                    break;
            }
        }
    }

}
