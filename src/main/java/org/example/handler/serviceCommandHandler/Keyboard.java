package org.example.handler.serviceCommandHandler;

import lombok.SneakyThrows;
import org.example.bot.settings.ConfigSettings;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.Arrays;

import static org.example.handler.typesOfDocumentsHandler.DocumentTypesConst.*;
import static org.example.bot.settings.MessagesConst.*;

public class Keyboard extends TelegramLongPollingBot {

    private final static ConfigSettings settings = ConfigSettings.getInstance();

    @Override
    public String getBotUsername() {
        return settings.getUserName();
    }

    @Override
    public String getBotToken() {
        return settings.getToken();
    }

    public static ReplyKeyboardMarkup createKeyboard() {

        KeyboardRow row = new KeyboardRow();
        row.add(CONTRACTS);
        row.add(PROXY);

        KeyboardRow row2 = new KeyboardRow();
        row2.add(CLAIMS);
        row2.add(ACTS);
        row2.add(VOUCHERS);

        KeyboardRow row3 = new KeyboardRow();
        row3.add(CUSTOMER);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Arrays.asList(row, row2, row3));
        replyKeyboardMarkup.setResizeKeyboard(true);
        return replyKeyboardMarkup;
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText(CHOOSE);
        sendMessage.setReplyMarkup(createKeyboard());
        execute(sendMessage);

    }

}
