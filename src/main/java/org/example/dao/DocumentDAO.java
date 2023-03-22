package org.example.dao;

import org.example.entity.DocumentInfo;

public interface DocumentDAO {
    void save(DocumentInfo docInfo);

    DocumentInfo getById(long id);

    DocumentInfo getByIndex(int docIndex);

    void update(DocumentInfo docInfo);

    void delete(DocumentInfo docInfo);

    void deleteAll();

    long getCount();
}