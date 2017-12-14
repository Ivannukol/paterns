/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.ui.authorization;

import com.patern.data.pojo.User;
import com.patern.data.pojo.User.Type;

/**
 *
 * @author abrel
 */
public interface AuthorizationView {

    String getUserName();

    String getPassword();

    String getFirstName();

    String getLastName();

    Type getTypeUser();

    void showError(String message);

    void goToMainScreen(User user);
    
}
