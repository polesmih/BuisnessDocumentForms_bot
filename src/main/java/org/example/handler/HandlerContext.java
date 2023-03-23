package org.example.handler;

import lombok.Getter;
import lombok.Setter;
import org.example.bot.Bot;
import org.example.handler.handlers.CommandHandler;
import org.example.handler.handlers.DocumentHandler;
import org.example.handler.handlers.TextHandler;
import org.example.service.CommandService;
import org.example.service.DocumentService;
import org.example.service.MessageSenderService;
import org.example.service.imp.CommandServiceImp;
import org.example.service.imp.DocumentServiceImp;
import org.example.service.imp.MessageSenderServiceImp;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class HandlerContext {
    private final BaseHandler textHandler;
    private final BaseHandler commandHandler;
    private final BaseHandler documentHandler;
    private final MessageSenderService messageSenderService;

    @Setter
    private BaseHandler handler;

    public HandlerContext(Bot bot) {
        CommandService commandService = CommandServiceImp.getInstance();
        DocumentService documentService = DocumentServiceImp.getInstance();

        this.textHandler = new TextHandler(this, documentService);
        this.commandHandler = new CommandHandler(this, commandService);
        this.documentHandler = new DocumentHandler(this);
        this.messageSenderService = new MessageSenderServiceImp(bot);
    }

    public void handling(Update update) {
        handler.handling(update.getMessage());
    }
}