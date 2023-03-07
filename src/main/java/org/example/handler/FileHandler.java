package org.example.handler;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;

public class FileHandler {

    public static SendDocument sendFile(Long chatId, String path) {
        File doc = new File(path);
        SendDocument document = new SendDocument();
        document.setChatId(chatId.toString());
        document.setDocument(new InputFile(doc));
        return document;
    }

}
