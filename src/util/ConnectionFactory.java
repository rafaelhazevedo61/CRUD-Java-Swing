/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

/**
 *
 * @author Rafael
 */
public class ConnectionFactory {

    private static Connection connection;
    private static final String URL_CONNECTION = "jdbc:postgresql://localhost:5432/crud-javaswing";
    private static final String USER = "postgres";
    private static final String PASSWORD = "arisco2017";
    private static final String DRIVER = "org.postgresql.Driver";

    public static Connection openConnection() {

        if (connection == null) {

            try {

                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);

                System.out.println("Connection opened!");

            } catch (SQLException | ClassNotFoundException ex) {

                printStackTrace(ex);

            }

        }

        return connection;
    }

    public static void closeConnection() {

        if (connection != null) {

            try {

                connection.close();
                connection = null;

                System.out.println("Connection closed!");

            } catch (SQLException ex) {

                printStackTrace(ex);

            }

        }

    }

}
