/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.ui.authorization;

import com.patern.data.Connect;
import com.patern.data.dao.Repository;
import com.patern.data.dao.UserTable;
import com.patern.data.pojo.User;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abrel
 */
public class AuthorizationPresentor {
    
    AuthorizationView view;
    Repository<User> rep;
    
    public AuthorizationPresentor(AuthorizationView view) {
        this.view = view;
        rep = new Repository<>(new UserTable(Connect.getConnection()));
    }
    
    public void login() {
        try {
            User user = rep.getAll().stream()
                    .filter(c -> c.getUserName().equals(view.getUserName()) && c.getPassword().equals(view.getPassword()))
                    .findFirst().orElse(null);
            if (user != null) {
                //TODO go next main screen
                view.showError("User "+user.getFirstName());
            } else {
                view.showError("User not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorizationPresentor.class.getName()).log(Level.SEVERE, null, ex);
            view.showError(ex.getMessage());
        }
    }
    
    public void registerNewUser() {
    }
}
