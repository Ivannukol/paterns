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
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Paterns> getAll() throws SQLException {
        ArrayList<Paterns> teacher = rep.getAll();
        return teacher;
    }
}
