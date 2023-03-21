package org.example.dao.imp;

import org.example.config.HibernateConfig;
import org.example.dao.BotUserDAO;
import org.example.entity.BotUser;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BotUserDAOImp implements BotUserDAO {
    private SessionFactory sessionFactory;

    @Override
    public List<BotUser> getAll() {
        sessionFactory = HibernateConfig.getSessionFactory();
        List<BotUser> users = null;
        try (Session session = sessionFactory.openSession()) {
            Query<BotUser> query = session.createQuery("from BotUser ", BotUser.class);
            users = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory = null;
        }
        return users;
    }

    @Override
    public BotUser getById(int id) {
        sessionFactory = HibernateConfig.getSessionFactory();
        BotUser user = null;
        try (Session session = sessionFactory.openSession()) {
            user = session.get(BotUser.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory = null;
        }
        return user;
    }

    @Override
    public void add(BotUser user) {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(user);
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
    public void update(BotUser user) {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.merge(user);
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
    public void delete(BotUser user) {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(user);
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
    public void deleteAll() {
        sessionFactory = HibernateConfig.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Query<BotUser> query = session.createQuery("delete from BotUser", BotUser.class);
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

    @Override
    public List<BotUser> findByName(String name) {
        sessionFactory = HibernateConfig.getSessionFactory();
        List<BotUser> users = null;
        try (Session session = sessionFactory.openSession()) {
            Query<BotUser> query = session.createQuery("from BotUser where userName like :searchName", BotUser.class);
            query.setParameter("searchName", "%" + name + "%");
            users = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.sessionFactory = null;
        }
        return users;
    }

    @Override
    public long getUserCount() {
        sessionFactory = HibernateConfig.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM BotUser", Long.class);
            return query.getSingleResult();
        } catch (HibernateException e) {
            throw new RuntimeException("Failed to get user count", e);
        } finally {
            this.sessionFactory = null;
        }
    }
}