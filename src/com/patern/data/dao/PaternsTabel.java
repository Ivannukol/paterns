/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.patern.data.dao;

import com.patern.data.pojo.Paterns;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class PaternsTabel implements Table<Paterns> {

    private final Connection con;

    public PaternsTabel(Connection con) {
        this.con = con;

    }

    @Override
    public boolean insert(Paterns item) throws SQLException {
        PreparedStatement ste = con.prepareStatement("INSERT INTO USERS.PATERNS(patern, type_patern ,sort_patern ) VALUES ( ?, ?, ?)");
        ste.setString(1, item.getPaterns());
        ste.setString(2, item.getTypeParent());
        ste.setInt(3, item.getSortPatern());

        return ste.execute();
    }

    @Override
    public boolean update(Paterns item) throws SQLException {
        PreparedStatement ste = con.prepareStatement("UPDATE USERS.PATERNS set PATERN=? ,TYPE_PATERN=?,SORT_PATERN=? where ID=?");
        ste.setInt(4, item.getId());
        ste.setString(1, item.getPaterns());
        ste.setString(2, item.getTypeParent());
        ste.setInt(3, item.getSortPatern());
        return ste.execute();
    }

    @Override
    public ArrayList<Paterns> getAll() throws SQLException {
        ArrayList<Paterns> paterns = new ArrayList<>();

        PreparedStatement ste = con.prepareStatement("Select * From USERS.PATERNS");
        ResultSet pater = ste.executeQuery();
        while (pater.next()) {
            Paterns p = new Paterns();

            p.setId(pater.getInt("ID"));
            p.setPaterns(pater.getString("PATERN"));
            p.setTypeParent(pater.getString("TYPE_PATERN"));
            p.setSortPatern(pater.getInt("SORT_PATERN"));

            paterns.add(p);
        }
        return paterns;
    }

    @Override
    public boolean delete(Paterns item) throws SQLException {
        PreparedStatement ste = con.prepareStatement("DELETE from USERS.PATERNS where ID" + item.getId());
        return ste.execute();
    }

    @Override
    public ArrayList<Paterns> get(Request<Paterns> request) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
