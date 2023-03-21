package org.example.bot;

import org.example.bot.settings.ConfigSettings;
import org.example.bot.settings.Logger;
import org.example.handler.MessageHandler;
import org.example.handler.actsHandler.ActSelectionHandler;
import org.example.handler.actsHandler.ActTypes;
import org.example.handler.claimsHandler.ClimesSelectionHandler;
import org.example.handler.claimsHandler.ClimesTypes;
import org.example.handler.contractsHandler.ContractSelectionHandler;
import org.example.handler.contractsHandler.ContractTypes;
import org.example.handler.customerHandler.CustomerSelectionHandler;
import org.example.handler.customerHandler.CustomerTypes;
import org.example.handler.proxyHandler.ProxySelectionHandler;
import org.example.handler.proxyHandler.ProxyTypes;
import org.example.handler.serviceCommandHandler.CommandSelectionHandler;
import org.example.handler.serviceCommandHandler.CommandServiceType;
import org.example.handler.typesOfDocumentsHandler.DocumentSelectionHandler;
import org.example.handler.typesOfDocumentsHandler.DocumentTypes;
import org.example.handler.vouchersHandler.VouchersSelectionHandler;
import org.example.handler.vouchersHandler.VouchersTypes;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.example.bot.settings.MessagesConst.UNKNOWN;

public class Bot extends TelegramLongPollingBot {

    public Logger logger = new Logger();
    DocumentSelectionHandler documentsHandler = new DocumentSelectionHandler();
    ContractSelectionHandler contractsHandler = new ContractSelectionHandler();
    ActSelectionHandler actHandler = new ActSelectionHandler();
    ProxySelectionHandler proxyHandler = new ProxySelectionHandler();
    VouchersSelectionHandler vouchersHandler = new VouchersSelectionHandler();
    ClimesSelectionHandler climesHandler = new ClimesSelectionHandler();
    CustomerSelectionHandler customerHandler = new CustomerSelectionHandler();
    DocumentTypes docTypes = new DocumentTypes();
    ContractTypes contTypes = new ContractTypes();
    ActTypes actTypes = new ActTypes();
    ProxyTypes proxyTypes = new ProxyTypes();
    VouchersTypes vouchersTypes = new VouchersTypes();
    ClimesTypes climesTypes = new ClimesTypes();
    CustomerTypes customerTypes = new CustomerTypes();
    CommandServiceType commandType = new CommandServiceType();
    CommandSelectionHandler commandHandler = new CommandSelectionHandler(this);
    private final static ConfigSettings settings = ConfigSettings.getInstance();
    String message_text;
    Long chat_id;


    @Override
    public String getBotUsername() {
        return settings.getUserName();
    }

    @Override
    public String getBotToken() {
        return settings.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        message_text = update.getMessage().getText();
        chat_id = update.getMessage().getChatId();

        if (update.hasMessage() && update.getMessage().hasText()) {

            if (commandType.types().contains(message_text)) {
                commandHandler.onUpdateReceived(update);

            } else if (docTypes.types().contains(message_text)) {
                documentsHandler.onUpdateReceived(update);

            } else if (contTypes.types().contains(message_text)) {
                contractsHandler.onUpdateReceived(update);

            } else if (actTypes.types().contains(message_text)) {
                actHandler.onUpdateReceived(update);

            } else if (proxyTypes.types().contains(message_text)) {
                proxyHandler.onUpdateReceived(update);

            } else if (vouchersTypes.types().contains(message_text)) {
                vouchersHandler.onUpdateReceived(update);

            } else if (climesTypes.types().contains(message_text)) {
                climesHandler.onUpdateReceived(update);

            } else if (customerTypes.types().contains(message_text)) {
                customerHandler.onUpdateReceived(update);

            } else {
                try {
                    execute(MessageHandler.sendMessage(chat_id, UNKNOWN));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
                logger.log("Неизвестная команда");
            }
        }
    }
}

