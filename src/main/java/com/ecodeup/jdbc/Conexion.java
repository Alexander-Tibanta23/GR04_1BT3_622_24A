package com.ecodeup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://127.0.0.1/tiendaelectrodomesticos?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void cerrarConexion(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
