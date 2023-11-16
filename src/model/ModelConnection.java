package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ModelConnection {
    private String hostname;
    private String username;
    private String password;
    private String database;

    public ModelConnection() {
        this.hostname = "localhost"; // "test_db.mysql.dbaas.com.br";
        this.username = "root"; // "test_db";
        this.password = "";
        this.database = "db_test_hot_dogs";
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://" + this.hostname + "/" + this.database
                + "?verifyServerCertificate=false&useSSL=true";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Não foi possível se conectar com o banco de dados :(");
            ex.printStackTrace();
        }
        return null;
    }
}
