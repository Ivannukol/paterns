/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ivan
 */
public class Connect {

    private Connect() {
    }

    public static Connection getInstance() {
        Connect con = new Connect();
        return con.getConnection();
    }
    public String DB = "jdbc:derby:" + System.getProperty("user.dir") + "/BD/paterns;create=true";

    public Connection getConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            return DriverManager.getConnection(DB, "users", "users");
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    private static class NewSingletonHolder {

        private static final Connect INSTANCE = new Connect();

    }
}
