package com.works.days2.services;

import com.works.days2.props.User;
import com.works.days2.utils.DB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> getLs() {


    List<User> ls = new ArrayList<>();

    DB db = new DB();

    try {
        String sql = "select * from users where status = 1 order by uid desc";
        PreparedStatement pre = db.connect().prepareStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            User u = new User();
            u.setUid(rs.getInt("uid"));
            u.setName(rs.getString("name"));
            u.setSurname(rs.getString("surname"));
            u.setPassword(rs.getString("password"));
            ls.add(u);

        }
    }catch (Exception ex) {
        System.err.println("Users Error: " + ex);
    }finally {
        db.close();
    }



        return ls;
    }

    public boolean deleteUser(int uid) {
        DB db = new DB();
        boolean success = false;

        try {
            String sql = "DELETE FROM users WHERE uid = ?";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setInt(1, uid);
            int rowsAffected = pre.executeUpdate();

            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException ex) {
            System.err.println("Delete User Error: " + ex);
        } finally {
            db.close();
        }

        return success;
    }

    public int userSave(User user) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "INSERT INTO users (uid,name,surname, email,password,status,age,date) VALUES (NULL, ?, ?, ?, ?, 1, ? , NOW())";
            PreparedStatement pre = db.connect().prepareStatement(sql);
            pre.setString(1, user.getName());
            pre.setString(2, user.getSurname());
            pre.setString(3, user.getEmail());
            pre.setString(4, user.getPassword());
            pre.setInt(5, user.getAge());
            status = pre.executeUpdate();
        } catch (Exception ex) {
            System.err.println("userSave Error : " + ex);
        } finally {
            db.close();
        }
        return status;
    }


}
