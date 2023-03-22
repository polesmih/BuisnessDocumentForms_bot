package org.example.service;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;

import java.util.List;

public interface DocumentService {
    SendDocument getByIndex(int docIndex);

    List<SendDocument> getAllByType(String docType);

    void delete(int docIndex);

    long getCountDocument();
}