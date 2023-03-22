package org.example.service.imp;

import jakarta.transaction.Transactional;
import org.example.dao.BotUserDAO;
import org.example.dao.imp.BotUserDAOImp;
import org.example.service.BotUserService;
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
        userDAO.save(user);
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
        return userDAO.getByName(name);
    }

    @Override
    public long getUserCount() {
        return userDAO.getCount();
    }
}