package org.example.handler.typesOfDocumentsHandler;

import lombok.SneakyThrows;
import org.example.handler.MessageHandler;
import org.example.bot.settings.*;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.example.handler.actsHandler.ActsPathsConst.ACT_MENU;
import static org.example.handler.claimsHandler.ClaimsPathsConst.CLIME_MENU;
import static org.example.handler.contractsHandler.ContractsPathsConst.CONT_MENU;
import static org.example.handler.customerHandler.CustomerPathsConst.CUSTOM_MENU;
import static org.example.handler.proxyHandler.ProxyPathsConst.PROXY_MENU;
import static org.example.handler.typesOfDocumentsHandler.DocumentTypesConst.*;
import static org.example.handler.vouchersHandler.VouchersPathsConst.VOUCHER_MENU;

public class DocumentSelectionHandler extends TelegramLongPollingBot {

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
                case ACTS:
                    execute(MessageHandler.sendMessage(chat_id, ACT_MENU));
                    logger.log("Запрошены формы актов");
                    break;

                case CONTRACTS:
                    execute(MessageHandler.sendMessage(chat_id, CONT_MENU));
                    logger.log("Запрошены формы договров");
                    break;

                case CUSTOMER:
                    execute(MessageHandler.sendMessage(chat_id, CUSTOM_MENU));
                    logger.log("Запрошены формы документов по защите прав потребителей");
                    break;

                case CLAIMS:
                    execute(MessageHandler.sendMessage(chat_id, CLIME_MENU));
                    logger.log("Запрошены формы судебных документов");
                    break;

                case PROXY:
                    execute(MessageHandler.sendMessage(chat_id, PROXY_MENU));
                    logger.log("Запрошены формы доверенностей");
                    break;

                case VOUCHERS:
                    execute(MessageHandler.sendMessage(chat_id, VOUCHER_MENU));
                    logger.log("Запрошены формы расписок");
                    break;
            }
        }
    }

}
