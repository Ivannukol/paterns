/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.ui.Teachers;

import com.patern.data.Connect;
import com.patern.data.dao.PaternsTabel;
import com.patern.data.dao.Repository;
import com.patern.data.pojo.User;
import com.patern.model.Paterns;

/**
 *
 * @author abrel
 */
public class TeacherPresentor {

    TeachersView view;
    Repository<Paterns> rep;

    public TeacherPresentor(TeachersView view) {
        this.view = view;
        rep = new Repository<>(new PaternsTabel(Connect.getInstance().getConnection()));
    }

    public void login() {

    }

}
