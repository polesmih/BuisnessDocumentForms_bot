package org.example.service.imp;

import org.example.dao.DocumentDAO;
import org.example.dao.imp.DocumentDAOImp;
import org.example.entity.DocumentInfo;
import org.example.service.DocumentService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DocumentServiceImp implements DocumentService {
    private final DocumentDAO documentDAO;
    private static volatile DocumentServiceImp instance;

    private DocumentServiceImp() {
        this.documentDAO = new DocumentDAOImp();
    }

    public static DocumentServiceImp getInstance() {
        if (instance == null) {
            synchronized (DocumentServiceImp.class) {
                if (instance == null) {
                    instance = new DocumentServiceImp();
                }
            }
        }
        return instance;
    }

    @Override
    public DocumentInfo getByIndex(int docIndex) {
        return documentDAO.getByIndex(docIndex);
    }

    @Override
    public List<DocumentInfo> getAllByType(String docType) {
        return documentDAO.getAllByType(docType);
    }

    @Override
    public void delete(int docIndex) {
        var docInfo = documentDAO.getByIndex(docIndex);

        if (docInfo == null) {
            return;
        }

        try {
            Files.delete(Path.of(docInfo.getDocPath()));
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