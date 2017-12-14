package com.patern.data.dao;

import com.patern.data.pojo.User;
import com.patern.data.pojo.User.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Andrew Brelyk
 */
public class UserTable implements Table<User> {

    private final Connection con;

    public UserTable(Connection con) {
        this.con = con;
    }

    @Override
    public boolean insert(User item) throws SQLException {
        PreparedStatement ste = con.prepareStatement("INSERT INTO USERS (userName, password, firstName, lastName, typeUser) VALUES ( ?, ?, ?, ?, ?)");
        ste.setString(1, item.getUserName());
        ste.setString(2, item.getPassword());
        ste.setString(3, item.getFirstName());
        ste.setString(4, item.getLastName());
        ste.setInt(5, item.getType().getValue());

        return ste.execute();
    }

    @Override
    public boolean update(User item) throws SQLException {
        PreparedStatement ste = con.prepareStatement("UPDATE USERS set userName=? ,password=?, firstName=?, lastName=? where id=?");
        ste.setString(1, item.getUserName());
        ste.setString(2, item.getPassword());
        ste.setString(3, item.getFirstName());
        ste.setString(4, item.getLastName());
        ste.setInt(5, item.getId());

        return ste.execute();
    }

    @Override
    public ArrayList<User> getAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement ste = con.prepareStatement("SELECT * From USERS");
        ResultSet res = ste.executeQuery();
         getResult(users, res);
        return users;
    }

    @Override
    public boolean delete(User item) throws SQLException {
        PreparedStatement ste = con.prepareStatement("DELETE from USERS WHERE id=" + item.getId());
        return ste.execute();
    }

    @Override
    public ArrayList<User> get(Request<User> request) throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        PreparedStatement ste = con.prepareStatement(request.getSQL());
        ResultSet res = ste.executeQuery();
        getResult(users, res);
        return users;
    }

    private void getResult(ArrayList<User> users, ResultSet res) throws SQLException {
        while (res.next()) {
            User item = new User();

            item.setId(res.getInt(Fields.ID));
            item.setUserName(res.getString(Fields.USERNAME));
            item.setPassword(res.getString(Fields.PASSWORD));
            item.setFirstName(res.getString(Fields.FIRSTNAME));
            item.setLastName(res.getString(Fields.LASTNAME));
            item.setType(res.getInt(Fields.TYPEUSER) == 0 ? Type.STUDENT : Type.TEACHER);

            users.add(item);
        }
    }

    public interface Fields {

        public String ID = "id";
        public String USERNAME = "userName";
        public String PASSWORD = "password";
        public String FIRSTNAME = "firstName";
        public String LASTNAME = "lastName";
        public String TYPEUSER = "typeUser";
    }

}
