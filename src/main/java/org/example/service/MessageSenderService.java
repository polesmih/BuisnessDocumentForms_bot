package org.example.service;

import org.example.entity.DocumentInfo;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface MessageSenderService {
    void sendMessage(SendMessage response);

    void sendDocument(long chatId, DocumentInfo docInfo);

    void sendMessage(long chatId, String message);
}