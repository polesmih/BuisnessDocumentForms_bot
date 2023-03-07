package org.example.handler.customerHandler;

import lombok.SneakyThrows;
import org.example.handler.FileHandler;
import org.example.bot.settings.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.handler.customerHandler.CustomerPathsConst.*;

public class CustomerSelectionHandler extends TelegramLongPollingBot {

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
                case "48":
                    execute(FileHandler.sendFile(chat_id, FORTY_EIGHT));
                    logger.log("Запрошен иск о защите право потребителей");
                    break;

                case "49":
                    execute(FileHandler.sendFile(chat_id, FORTY_NINE));
                    logger.log("Запрошена претензия при дистанционном приобретении товара");
                    break;

                case "50":
                    execute(FileHandler.sendFile(chat_id, FIFTY));
                    logger.log("Запрошена претензия о нарушении сроков выполнения работы");
                    break;

                case "51":
                    execute(FileHandler.sendFile(chat_id, FIFTY_ONE));
                    logger.log("Запрошен иск о взыскании неустойки за просрочку передачи товара");
                    break;

                case "52":
                    execute(FileHandler.sendFile(chat_id, FIFTY_TWO));
                    logger.log("Запрошена жалоба в Роспотребнадзор");
                    break;

                case "53":
                    execute(FileHandler.sendFile(chat_id, FIFTY_THREE));
                    logger.log("Запрошена жалоба на постановление о штрафе за платную парковку");
                    break;
            }
        }
    }

}
