package com.ecodeup.jdbc;

import java.sql.*;

public class Conexion {

    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/tiendaelectrodomesticos?serverTimezone=UTC";
        String user = "root";
        String password = "12345";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from usuarios");

            while(resultSet.next()) {

                System.out.println(resultSet.getString("cedulaUsuario"));

            }
            connection.close();
            statement.close();
            resultSet.close();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
