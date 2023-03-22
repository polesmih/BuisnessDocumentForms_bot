package org.example.service.imp;

import org.example.bot.Bot;
import org.example.dao.DocumentDAO;
import org.example.service.DocumentService;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DocumentServiceImp implements DocumentService {
    private final Bot bot;
    private final String documentsDirectory;
    private final DocumentDAO documentDAO;

    public DocumentServiceImp(Bot bot, String documentsDirectory, DocumentDAO documentDAO) {
        this.bot = bot;
        this.documentsDirectory = documentsDirectory;
        this.documentDAO = documentDAO;
    }

    @Override
    public SendDocument getByIndex(int docIndex) {
        var docInfo = documentDAO.getByIndex(docIndex);

        if (docInfo == null) {
            return null;
        }

        File file = Path.of(docInfo.getFilePath()).toFile();
        InputFile inputFile = new InputFile(file);
        SendDocument sendDocument = new SendDocument();
        sendDocument.setDocument(inputFile);
        return sendDocument;
    }

    @Override
    public void delete(int docIndex) {
        var docInfo = documentDAO.getByIndex(docIndex);

        if (docInfo == null) {
            return;
        }

        try {
            Files.delete(Path.of(docInfo.getFilePath()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        documentDAO.delete(docInfo);
    }

    @Override
    public long getCountDocument() {
        return documentDAO.getCount();
    }
}