/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.ui.authorization;

import com.patern.data.Connect;
import com.patern.data.dao.Repository;
import com.patern.data.dao.Request;
import com.patern.data.dao.UserTable;
import com.patern.data.pojo.User;
import java.sql.SQLException;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author abrel
 */
public class AuthorizationPresentor {

    AuthorizationView view;
    Repository<User> rep;

    public AuthorizationPresentor(AuthorizationView view) {
        this.view = view;
        rep = new Repository<>(new UserTable(Connect.getInstance().getConnection()));
    }

    public void login() {
        try { 
            User user = rep.get(new Request.Builder<User>(User.class)
                    .where(UserTable.Fields.USERNAME, view.getUserName())
                    .where(UserTable.Fields.PASSWORD, view.getPassword())
                    .build())
                    .stream()
                    .findFirst()
                    .orElse(null);
            if (user != null) {
                view.goToMainScreen(user);
            } else {
                view.showError("User not found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorizationPresentor.class.getName()).log(Level.SEVERE, null, ex);
            view.showError(ex.getMessage());
        }
    }

    public void registerNewUser() {

        User user = new User();
        user.setFirstName(view.getFirstName());
        user.setLastName(view.getLastName());
        user.setUserName(view.getUserName());
        user.setPassword(view.getPassword());
        user.setType(view.getTypeUser());
        Stream.of(user).filter(u -> u.getPassword() != null).findFirst().ifPresent(u -> {
            try {
                rep.insert(u);
            } catch (SQLException ex) {
                view.showError(ex.getMessage());

            }
        });

    }
}
