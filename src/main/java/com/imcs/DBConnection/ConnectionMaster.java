/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.imcs.DBConnection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Avishek
 */
public class ConnectionMaster {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/employee_project";
    private static String username = "IMCSJavaTraining";
    private static String password = "java";

    private Connection dbCon;

    /**
     * @return the dbCon
     */
    public Connection getDbCon() {        
        return dbCon;
    }

    /**
     * @param dbCon the dbCon to set
     */
    public void setDbCon() {
        try {
            Class.forName(JDBC_DRIVER);
            dbCon = (Connection) DriverManager.getConnection(URL, username, password);            
            this.dbCon = dbCon;
            if (dbCon.isClosed()) {
                System.out.println("Connection Not Active!! Please check parameters!!");
            }
        } catch (SQLException ex) {
            System.out.println("Error in Connection!! Please check parameters!!");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Error in Connection!! Please check parameters!!");
            ex.printStackTrace();
        }
    }
}
