package org.example.dao.imp;

import org.example.config.HibernateConfig;
import org.example.dao.BotUserDAO;
import org.example.entity.BotUser;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BotUserDAOImp extends AbstractDAO implements BotUserDAO {
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
    public BotUser getById(long id) {
        return (BotUser) findEntityById(id, new BotUser());
    }

    @Override
    public void save(BotUser user) {
        addEntity(user);
    }

    @Override
    public void update(BotUser user) {
        updateEntity(user);
    }

    @Override
    public void delete(BotUser user) {
        deleteEntity(user);
    }

    @Override
    public void deleteAll() {
        deleteAllEntity(new BotUser());
    }

    @Override
    public List<BotUser> getByName(String name) {
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
    public long getCount() {
        return getEntityCount(new BotUser());
    }
}