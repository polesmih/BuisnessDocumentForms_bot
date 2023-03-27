package org.example.bot;

import org.example.bot.settings.ConfigSettings;
import org.example.bot.settings.Logger;
import org.example.handler.HandlerContext;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.example.bot.settings.StringConst.UNKNOWN;
import static org.example.component.BotCommands.LIST_OF_COMMAND;

public class Bot extends TelegramLongPollingBot {
    public final Logger logger;
    private HandlerContext context;
    private final ConfigSettings settings;

    public Bot() {
        this.logger = new Logger();
        this.settings = ConfigSettings.getInstance();
    }

    public void init() throws TelegramApiException {
        this.context = new HandlerContext(this);
        execute(new SetMyCommands(LIST_OF_COMMAND, new BotCommandScopeDefault(), null));
    }

    @Override
    public String getBotUsername() {
        return settings.getBotName();
    }

    @Override
    public String getBotToken() {
        return settings.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update == null) {
            return;
        }

        if (update.hasMessage()) {
            var message = update.getMessage();

            if (message.hasText()) {
                var text = message.getText();

                if (text.startsWith("/")) {
                    context.setHandler(context.getCommandHandler());
                } else {
                    context.setHandler(context.getTextHandler());
                }
            } else if (message.hasDocument()) {
                context.setHandler(context.getDocumentHandler());
            } else {
                sendMessage(SendMessage.builder()
                        .chatId(message.getChatId())
                        .text(UNKNOWN)
                        .build());
                return;
            }
            context.handling(update);
        }
    }

    public void sendMessage(SendMessage response) {
        try {
            execute(response);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }

    public void sendMessage(SendDocument response) {
        try {
            execute(response);
        } catch (TelegramApiException ex) {
            ex.printStackTrace();
        }
    }
}