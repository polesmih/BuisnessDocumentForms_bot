package org.example.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class MessageHandler {

    public static SendMessage sendMessage (Long chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(text);
        return sendMessage;
    }

}
