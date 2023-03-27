package org.example.handler;

import org.example.entity.DocumentInfo;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public abstract class AbstractHandler implements BaseHandler {
    protected final HandlerContext context;

    protected AbstractHandler(HandlerContext context) {
        this.context = context;
    }

    protected void executeDocument(long chatId, DocumentInfo docInfo) {
        context.getMessageSenderService().sendDocument(chatId, docInfo);
    }

    protected void executeMessage(long chatId, String message) {
        context.getMessageSenderService().sendMessage(chatId, message);
    }

    protected void executeMessage(SendMessage sendMessage) {
        context.getMessageSenderService().sendMessage(sendMessage);
    }
}