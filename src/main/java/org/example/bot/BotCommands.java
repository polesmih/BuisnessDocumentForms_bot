package org.example.bot;

import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.List;

public interface BotCommands {
    List<BotCommand> LIST_OF_COMMAND = List.of(
            new BotCommand("/start", "start bot"),
            new BotCommand("/key", "show documents"),
            new BotCommand("/help", "bot info"),
            new BotCommand("/info", "show count users"),
            new BotCommand("/donate", "thank me")
    );
}