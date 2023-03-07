package org.example.handler.contractsHandler;

import lombok.SneakyThrows;
import org.example.handler.FileHandler;
import org.example.bot.settings.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.handler.contractsHandler.ContractsPathsConst.*;

public class ContractSelectionHandler extends TelegramLongPollingBot {

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
                case "1":
                    execute(FileHandler.sendFile(chat_id, ONE));
                    logger.log("Запрошен договор К-П ТС");
                    break;

                case "2":
                    execute(FileHandler.sendFile(chat_id, TWO));
                    logger.log("Запрошен договор оказания юр.услуг");
                    break;

                case "3":
                    execute(FileHandler.sendFile(chat_id, THREE));
                    logger.log("Запрошен договор перевода долга");
                    break;

                case "4":
                    execute(FileHandler.sendFile(chat_id, FOUR));
                    logger.log("Запрошен договор займа");
                    break;

                case "5":
                    execute(FileHandler.sendFile(chat_id, FIVE));
                    logger.log("Запрошен договор задатка");
                    break;

                case "6":
                    execute(FileHandler.sendFile(chat_id, SIX));
                    logger.log("Запрошен договор ремонта квартиры");
                    break;

                case "7":
                    execute(FileHandler.sendFile(chat_id, SEVEN));
                    logger.log("Запрошен договор покупки квартиры");
                    break;

                case "8":
                    execute(FileHandler.sendFile(chat_id, EIGHT));
                    logger.log("Запрошен договор покупки доли в квартире");
                    break;

                case "9":
                    execute(FileHandler.sendFile(chat_id, NINE));
                    logger.log("Запрошен договор найма квартиры");
                    break;

                case "10":
                    execute(FileHandler.sendFile(chat_id, TEN));
                    logger.log("Запрошен договор покупки доли в ООО");
                    break;

                case "11":
                    execute(FileHandler.sendFile(chat_id, ELEVEN));
                    logger.log("Запрошен трудовой договор");
                    break;
            }
        }
    }

}
