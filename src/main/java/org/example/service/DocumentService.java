package org.example.service;

import org.example.entity.DocumentInfo;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;

import java.util.List;

public interface DocumentService {
    DocumentInfo getByIndex(int docIndex);

    List<DocumentInfo> getAllByType(String docType);

    void delete(int docIndex);

    long getCountDocument();
}