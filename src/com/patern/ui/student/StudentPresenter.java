/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.ui.student;

import com.patern.data.Connect;
import com.patern.data.dao.PaternsTabel;
import com.patern.data.dao.Repository;
import com.patern.data.pojo.Paterns;
import java.sql.SQLException;

/**
 *
 * @author abrel
 */
public class StudentPresenter {
    private StudentView view;
    private Repository<Paterns> rep;

    public StudentPresenter(StudentView view) {
        this.view = view;
        rep = new Repository<>(new PaternsTabel(Connect.getInstance().getConnection()));
    }
    
    
    public void getData() throws SQLException{
        view.setData(rep.getAll());
    }
    
}
