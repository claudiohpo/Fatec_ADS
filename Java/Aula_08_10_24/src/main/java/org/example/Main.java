package org.example;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost:3306/?useSSL=false&createDatabaseIfNotExist=true";
        final String user = "root";
        final String password = "root";

        Connection conexao = DriverManager.getConnection(url, user, password);

        Statement stmt = conexao.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS Ryan_Takata");

        System.out.println("Banco criado com sucesso");
        conexao.close();
    }
}