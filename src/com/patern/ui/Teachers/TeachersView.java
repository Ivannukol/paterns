/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.ui.Teachers;

import com.patern.ui.authorization.*;
import com.patern.data.pojo.User.Type;

/**
 *
 * @author abrel
 */
public interface TeachersView {

    String getid();

    String getpaterns();

    String gettype_parent();

    String getsort_parent();

    void showError(String message);
}
