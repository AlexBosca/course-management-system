package org.example.dao;

import org.example.database.Database;
import org.example.exception.login.LoginException;
import org.example.model.User;
import org.example.security.AESEncryptionEngine;

import java.sql.*;
import java.util.Arrays;

public class DAO {  // To refactor that class

    private Connection databaseConnection;
    private AESEncryptionEngine encryptionEngine;

    public DAO() {
        databaseConnection = Database.getDatabaseInstance().getDatabaseConnection();
        encryptionEngine = new AESEncryptionEngine();
    }

    public boolean createUser(User user) {
        try {
            PreparedStatement createUserPreparedStatement = databaseConnection.prepareStatement("insert into Users(first_name, last_name, email_address, date_of_birth, phone_number, password, account_type) values(?, ?, ?, ? ,? ,? ,?)");

            createUserPreparedStatement.setString(1, user.getFirstName());
            createUserPreparedStatement.setString(2, user.getLastName());
            createUserPreparedStatement.setString(3, user.getEmailAddress());
            createUserPreparedStatement.setDate(4, Date.valueOf(user.getDateOfBirth()));
            createUserPreparedStatement.setString(5, user.getPhoneNumber());
            createUserPreparedStatement.setString(6, new String(user.getPassword()));
            createUserPreparedStatement.setString(7, user.getPrivileges().getAccountType());

            createUserPreparedStatement.execute();

            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public User authenticateUser(String emailAddress, char[] encryptedPassword) throws LoginException {
        User userToRetrieve = null;
        String retrievedPassword = "";

        try {
            PreparedStatement retrieveUserByEmailPreparedStatement = databaseConnection.prepareStatement("select * from users where email_address=?");

            retrieveUserByEmailPreparedStatement.setString(1, emailAddress);

            ResultSet userResultSet = retrieveUserByEmailPreparedStatement.executeQuery();

            while(userResultSet.next()) {
                retrievedPassword = userResultSet.getString(7);

                userToRetrieve = new User.Builder(userResultSet.getString(4))
                        .withFirstName(userResultSet.getString(2))
                        .withLastName(userResultSet.getString(3))
                        .withDateOfBirth(userResultSet.getDate(5).toLocalDate())
                        .withPhoneNumber(userResultSet.getString(6))
                        .build();
            }

            if(Arrays.equals(encryptedPassword, retrievedPassword.toCharArray())) {
                return userToRetrieve;
            }

            throw new LoginException();
        } catch (SQLException sqlException) {
            return null;
        }
    }
}
