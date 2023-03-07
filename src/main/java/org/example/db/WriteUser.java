package org.example.db;

import java.sql.Date;

public class WriteUser {

    public static void writeUserIntoDb (Date date, Long id, String name) {

        UserModel user = new UserModel();

        user.setDate(date);
        user.setUserTgId(id);
        user.setUserName(name);

        UserModel userModel = new UserModel(date, id, name);

        UserConnection.userAccounting(userModel);

    }
}
