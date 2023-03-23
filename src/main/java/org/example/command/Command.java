package org.example.command;

import org.example.handler.HandlerContext;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface Command {
    void execute(HandlerContext context, Message message);
}