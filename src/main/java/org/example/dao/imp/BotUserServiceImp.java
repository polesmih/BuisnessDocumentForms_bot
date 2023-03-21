package org.example.dao.imp;

import jakarta.transaction.Transactional;
import org.example.dao.BotUserDAO;
import org.example.dao.BotUserService;
import org.example.entity.BotUser;

import java.util.List;

@Transactional
public class BotUserServiceImp implements BotUserService {
    private final BotUserDAO userDAO;

    public BotUserServiceImp() {
        this.userDAO = new BotUserDAOImp();
    }

    @Override
    public List<BotUser> getAll() {
        return userDAO.getAll();
    }

    @Override
    public BotUser findById(int id) {
        return userDAO.getById(id);
    }

    @Override
    public void add(BotUser user) {
        userDAO.add(user);
    }

    @Override
    public void update(BotUser user) {
        userDAO.update(user);
    }

    @Override
    public void delete(BotUser user) {
        userDAO.delete(user);
    }

    @Override
    public void deleteAll() {
        userDAO.deleteAll();
    }

    @Override
    public List<BotUser> findByName(String name) {
        return userDAO.findByName(name);
    }

    @Override
    public long getUserCount() {
        return userDAO.getUserCount();
    }
}