package org.example.command.imp;

import org.example.command.Command;
import org.telegram.telegrambots.meta.api.objects.Message;

public class UnknownCommand implements Command {

    @Override
    public void execute(Message message) {

    }
}