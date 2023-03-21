package org.example.dao;

import org.example.entity.BotUser;

import java.util.List;

public interface BotUserDAO {
    List<BotUser> getAll();

    BotUser getById(int id);

    void add(BotUser user);

    void update(BotUser user);

    void delete(BotUser user);

    void deleteAll();

    List<BotUser> findByName(String name);
    long getUserCount();
}