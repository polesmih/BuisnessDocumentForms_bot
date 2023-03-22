package org.example.service;

import org.telegram.telegrambots.meta.api.methods.send.SendDocument;

public interface DocumentService {
    SendDocument getByIndex(int docIndex);

    void delete(int docIndex);

    long getCountDocument();
}