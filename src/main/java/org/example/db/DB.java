package org.example.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
   public static Connection conn = null;// conectar com o banco de daos

    public static Connection getConnection() {// de fato vai fazer a conexão
        if(conn== null){//
            try{
                Properties props = loadPropetiers();
                String  url = props.getProperty("dburl");
                conn = DriverManager.getConnection(url, props );

            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }

        }
        return conn;
    }

    public static Properties loadPropetiers() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);

            return props;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }

    }}
