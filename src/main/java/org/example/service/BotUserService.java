package org.example.service;

import org.example.entity.BotUser;

import java.util.List;

public interface BotUserService {
    List<BotUser> getAll();

    BotUser findById(int id);

    void add(BotUser user);

    void update(BotUser user);

    void delete(BotUser user);

    void deleteAll();

    List<BotUser> findByName(String name);

    long getUserCount();
}