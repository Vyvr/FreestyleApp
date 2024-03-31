package org.vyvr.javaprojektzaliczeniowy.services;

import org.vyvr.javaprojektzaliczeniowy.database.Database;
import org.vyvr.javaprojektzaliczeniowy.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    public User getUserByEmail(String email) {
        User user = null;
        Database db = new Database();
        try (Connection connection = db.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ?")) {
            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String foundEmail = resultSet.getString("email");
                String password = resultSet.getString("password");
                user = new User(foundEmail, password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle exceptions
        }
        return user;
    }
}
