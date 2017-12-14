/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.ui.student;

import com.patern.data.pojo.Paterns;
import java.util.ArrayList;

/**
 *
 * @author abrel
 */
public interface StudentView {
    void getPattern();
    
    void setData(ArrayList<Paterns> data);
}
