package org.example.dao.imp;

import org.example.config.HibernateConfig;
import org.example.dao.DocumentDAO;
import org.example.entity.DocumentInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DocumentDAOImp extends AbstractDAO implements DocumentDAO {
    @Override
    public void save(DocumentInfo docInfo) {
        addEntity(docInfo);
    }

    @Override
    public void saveAll(List<DocumentInfo> infoList) {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            infoList.forEach(session::persist);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            this.sessionFactory = null;
        }
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
            Query<DocumentInfo> query = session.createQuery("from DocumentInfo where docIndex=:fIndex", DocumentInfo.class);
            query.setParameter("fIndex", docIndex);
            documentInfo = query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory = null;
        }
        return documentInfo;
    }

    @Override
    public List<DocumentInfo> getAllByType(String docType) {
        sessionFactory = HibernateConfig.getSessionFactory();
        List<DocumentInfo> documentsInfo = null;
        try (Session session = sessionFactory.openSession()) {
            Query<DocumentInfo> query = session.createQuery("from DocumentInfo where docType like :type", DocumentInfo.class);
            query.setParameter("type", "%" + docType + "%");
            documentsInfo = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory = null;
        }
        return documentsInfo;
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