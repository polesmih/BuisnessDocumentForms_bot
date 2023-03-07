package org.example.db;

import lombok.SneakyThrows;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserConnection {

    @SneakyThrows
    public static void userAccounting(UserModel userModel) {

        String insert = "INSERT INTO " + DbConst.TABLE
                + "(" + DbConst.DATE + ", "
                + DbConst.TG_ID + ", "
                + DbConst.NAME + ")"
                + "VALUES (?, ?, ?)";

        try {

            PreparedStatement preparedStatement = DbConnection.getConnection().prepareStatement(insert);
            preparedStatement.setString(1, String.valueOf(userModel.getDate()));
            preparedStatement.setString(2, String.valueOf(userModel.getUserTgId()));
            preparedStatement.setString(3, userModel.getUserName());

            preparedStatement.execute();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public static int numberOfVisits() {
        int visits = 0;
        try {
            String query = "SELECT COUNT(*) FROM " + DbConst.TABLE;
            PreparedStatement preparedStatement = DbConnection.dbConnection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 visits = resultSet.getInt("COUNT(*)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return visits;
    }

}
