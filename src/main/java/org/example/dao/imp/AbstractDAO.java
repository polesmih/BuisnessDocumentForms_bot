package org.example.dao.imp;

import org.example.config.HibernateConfig;
import org.example.entity.BotEntity;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public abstract class AbstractDAO {
    protected SessionFactory sessionFactory;

    protected void addEntity(BotEntity botEntity) {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;

        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(botEntity);
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

    protected BotEntity findEntityById(long id, BotEntity entity) {
        sessionFactory = HibernateConfig.getSessionFactory();
        BotEntity botEntity = null;
        try (Session session = sessionFactory.openSession()) {

            botEntity = session.get(entity.getClass(), id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory = null;
        }
        return botEntity;
    }

    protected void updateEntity(BotEntity entity) {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.merge(entity);
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

    public void deleteEntity(BotEntity entity) {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.remove(entity);
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

    public void deleteAllEntity(BotEntity entity) {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Query<?> query = session.createQuery("delete from " + entity.getClass().getSimpleName(), entity.getClass());
            query.executeUpdate();
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

    public long getEntityCount(BotEntity entity) {
        sessionFactory = HibernateConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

//            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM " + entity.getClass().getSimpleName(), Long.class);
            Query<Long> query = session.createQuery("SELECT SUM (countVisits) FROM " + entity.getClass().getSimpleName(), Long.class);
            return query.getSingleResult();
        } catch (HibernateException e) {
            throw new RuntimeException("Failed to get " + entity.getClass().getSimpleName() + " count", e);
        } finally {
            this.sessionFactory = null;
        }
    }
}