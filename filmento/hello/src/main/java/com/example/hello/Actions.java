package com.example.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Actions {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {

      //  String connectionUrl ="jdbc:sqlserver://localhost:1433;instance=(LocalDb)\\MSSQLLocalDB;databaseName=IS;integratedSecurity=true;";

        String connectionUrl =
                "jdbc:sqlserver://DESKTOP-KSBSOAV:1433;"
                        + "database=IS;"
                        + "user=DESKTOP-KSBSOAV\\Mihai"
                        + "password=;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        String insertSql = "INSERT INTO Clients (ID_Client,email,parola) VALUES "
                + "(0, 'mihai.gligor@gmail.com', 'glig');";

        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(connectionUrl);
             PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);) {

            prepsInsertProduct.execute();
            // Retrieve the generated key from the insert.
            resultSet = prepsInsertProduct.getGeneratedKeys();

            // Print the ID of the inserted row.
            while (resultSet.next()) {
                System.out.println("Generated: " + resultSet.getString(1));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
