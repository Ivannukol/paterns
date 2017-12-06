/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data.dao;

import com.patern.model.Paterns;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaternsDAO {

    ArrayList<Paterns> paterns = new ArrayList<>();
    Connection con;

    public PaternsDAO(Connection con) {
        this.con = con;
    }

    public boolean Insert(Paterns patern) throws SQLException {
        PreparedStatement ste = con.prepareStatement("INSERT INTO USERS.PATERNS(patern, type_patern ,sort_patern ) VALUES ( ?, ?, ?)");
        ste.setString(1, patern.getPaterns());
        ste.setString(2, patern.getType_parent());
        ste.setInt(3, patern.getSort_patern());

        return ste.execute();
    }

    public boolean Delete(Paterns patern) throws SQLException {
        PreparedStatement ste = con.prepareStatement("DELETE from USERS.PATERNS where ID" + patern.getId());
        return ste.execute();
    }

    public ArrayList<Paterns> Select() throws SQLException {
        PreparedStatement ste = con.prepareStatement("Select * From USERS.PATERNS");
        ResultSet pater = ste.executeQuery();
        while (pater.next()) {
                    Paterns p = new Paterns();

            p.setId(pater.getInt("ID"));
            p.setPaterns(pater.getString("PATERN"));
            p.setType_parent(pater.getString("TYPE_PATERN"));
            p.setSort_patern(pater.getInt("SORT_PATERN"));

            paterns.add(p);
        }
        return paterns;
    }

    public boolean Updete(Paterns patern) throws SQLException {
        PreparedStatement ste = con.prepareStatement("UPDATE USERS.PATERNS set PATERN=? ,TYPE_PATERN=?,SORT_PATERN=? where ID=?");
        ste.setInt(4, patern.getId());
        ste.setString(1, patern.getPaterns());
        ste.setString(2, patern.getType_parent());
        ste.setInt(3, patern.getSort_patern());
        return ste.execute();
    }
}
