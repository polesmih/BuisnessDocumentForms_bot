package org.example.handler.handlers;

import org.example.handler.AbstractHandler;
import org.example.handler.HandlerContext;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class DocumentHandler extends AbstractHandler {
    public DocumentHandler(HandlerContext context) {
        super(context);
    }

    @Override
    public void handling(Message message) {
        var userFrom = message.getFrom();

        executeMessage(SendMessage.builder()
                .chatId(userFrom.getId())
                .text("Функционал обработки документов еще в разработке...")
                .build());
    }
}