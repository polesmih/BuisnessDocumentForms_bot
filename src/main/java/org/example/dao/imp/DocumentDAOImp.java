package org.example.dao.imp;

import org.example.config.HibernateConfig;
import org.example.dao.DocumentDAO;
import org.example.entity.DocumentInfo;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class DocumentDAOImp extends AbstractDAO implements DocumentDAO {
    @Override
    public void save(DocumentInfo docInfo) {
        addEntity(docInfo);
    }

    @Override
    public DocumentInfo getById(long id) {
        return (DocumentInfo) findEntityById(id, new DocumentInfo());
    }

    @Override
    public DocumentInfo getByIndex(int docIndex) {
        sessionFactory = HibernateConfig.getSessionFactory();
        DocumentInfo documentInfo = null;
        try (Session session = sessionFactory.openSession()) {
            Query<DocumentInfo> query = session.createQuery("from DocumentInfo where fileIndex=:fIndex", DocumentInfo.class);
            query.setParameter("fIndex", "%" + docIndex + "%");
            documentInfo = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory = null;
        }
        return documentInfo;
    }

    @Override
    public void update(DocumentInfo docInfo) {
        updateEntity(docInfo);
    }

    @Override
    public void delete(DocumentInfo docInfo) {
        deleteEntity(docInfo);
    }

    @Override
    public void deleteAll() {
        deleteAllEntity(new DocumentInfo());
    }

    @Override
    public long getCount() {
        return getEntityCount(new DocumentInfo());
    }
}