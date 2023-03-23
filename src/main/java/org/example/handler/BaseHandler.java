package org.example.handler;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface BaseHandler {
    void handling(Message message);
}