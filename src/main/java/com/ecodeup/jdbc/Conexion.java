package com.ecodeup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = getConnection();
            System.out.println("Conexión exitosa a la base de datos");
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    public static Connection getConnection() {
        String url = "jdbc:mysql://127.0.0.1/tiendaelectrodomesticos?serverTimezone=UTC";
        String user = "root";
        String password = "1234";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datos", e);
        }
    }
}
