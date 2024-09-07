/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevaniapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.User;
import sanjeevaniapp.pojo.UserPojo;

/**
 *
 * @author TANMAY KUMAR
 */
public class UserDao {
    public  static String validateUser(User user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select user_name from users where login_id = ? and password = ? and user_type = ?");
        ps.setString(1, user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs = ps.executeQuery();
        String name = null;
        if(rs.next()){
            name = rs.getString("user_name");
        }
        return name;
    }
    
    public static void updateName(String currName,String newName) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set user_name = ? where user_name = ?");
        ps.setString(1,newName);
        ps.setString(2,currName);
        ps.executeUpdate();
    }
    
    public static void deleteUserByName(String name) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from users where user_name = ?");
        ps.setString(1,name);
        ps.executeUpdate();
    }
    
    public static boolean addUser(UserPojo user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into users values(?,?,?,?)");
        ps.setString(1, user.getLoginId());
        ps.setString(2, user.getUserName());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getUserType());
        
        return (ps.executeUpdate() == 1);
    }
    
    public static UserPojo getUserByName(String userName) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select *from users where user_name = ?");
        ps.setString(1, userName);
        ResultSet rs = ps.executeQuery();
        UserPojo user = new UserPojo();
        if(rs.next()){
        
            user.setLoginId(rs.getString(1));
            user.setUserName(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setUserType(rs.getString(4));
        }
        return user;
    }
    
    public static boolean updateUser(UserPojo user) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update users set login_id = ?, password = ? where user_name = ?");
        ps.setString(1,user.getLoginId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserName());
        
        return ps.executeUpdate() == 1;
    }
}
    