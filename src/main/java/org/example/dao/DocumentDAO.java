package org.example.dao;

import org.example.entity.DocumentInfo;

import java.util.List;

public interface DocumentDAO {
    void save(DocumentInfo docInfo);

    void saveAll(List<DocumentInfo> infoList);

    DocumentInfo getById(long id);

    DocumentInfo getByIndex(int docIndex);

    List<DocumentInfo> getAllByType(String docType);

    void update(DocumentInfo docInfo);

    void delete(DocumentInfo docInfo);

    void deleteAll();

    long getCount();
}