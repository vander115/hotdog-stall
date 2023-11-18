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
        this.hostname = "test_db.mysql.dbaas.com.br";
        this.username = "test_db";
        this.password = "TecProg23-2!@";
        this.database = "test_db";
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
