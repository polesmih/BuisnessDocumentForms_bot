package org.example.service.imp;

import org.example.bot.Bot;
import org.example.entity.DocumentInfo;
import org.example.service.MessageSenderService;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.nio.file.Path;

public class MessageSenderServiceImp implements MessageSenderService {
    private final Bot bot;

    public MessageSenderServiceImp(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(SendMessage response) {
        bot.sendMessage(response);
    }

    @Override
    public void sendDocument(long chatId, DocumentInfo docInfo) {
        File document = Path.of(docInfo.getDocPath()).toFile();

        bot.sendMessage(SendDocument.builder()
                .chatId(chatId)
                .document(new InputFile(document))
                .caption(docInfo.getDescription())
                .build());
    }

    @Override
    public void sendMessage(long chatId, String message) {
        SendMessage response = SendMessage.builder()
                .chatId(chatId)
                .text(message)
                .build();

        bot.sendMessage(response);
    }
}