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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.ReceptionistPojo;

/**
 *
 * @author TANMAY KUMAR
 */
public class ReceptionistDao {
    public static void updateName(String currName,String newName) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update receptionists set receptionist_name = ? where receptionist_name = ?");
        ps.setString(1,newName);
        ps.setString(2,currName);
        ps.executeUpdate();
    }
    
    public static void deleteReceptioist(String name) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from receptionists where receptionist_name = ?");
        ps.setString(1,name);
        ps.executeUpdate();
    }
    
    public static String getNextRecepId() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(receptionist_id) from receptionists");
        rs.next();
        String str=rs.getString(1);
        int recId=101;
        if(str!=null){
            String id=str.substring(3);
            recId=Integer.parseInt(id);
            recId++;
        }
        String newId="REC"+recId;
        return newId;  
    }
    
    public static boolean addReceptionist(ReceptionistPojo rec) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into receptionists values(?,?,?)");
        ps.setString(1, rec.getReceptionistId());
        ps.setString(2, rec.getReceptionistName());
        ps.setString(3, rec.getReceptionistGender());
        
        return (ps.executeUpdate() == 1);
    }
    
    public static List<ReceptionistPojo> getAllRecepDetails() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select *from receptionists order by receptionist_id");
        List<ReceptionistPojo> recList = new ArrayList<>();
        while(rs.next()){
            ReceptionistPojo rec = new ReceptionistPojo();
            rec.setReceptionistId(rs.getString(1));
            rec.setReceptionistName(rs.getString(2));
            rec.setReceptionistGender(rs.getString(3));
            recList.add(rec);
        }
        return recList;
    }
    
    public static List<String> getAllRecepIds() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select receptionist_id from receptionists order by receptionist_id");
        List<String> recepIdList = new ArrayList<>();
        while(rs.next()){
            String recepId = rs.getString(1);
            recepIdList.add(recepId);
        }
        return recepIdList;
    }
    
    public static boolean deleteRecepById(String recepId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select receptionist_name from receptionists where receptionist_id = ?");
        ps.setString(1, recepId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String recepName = rs.getString(1);
        UserDao.deleteUserByName(recepName);
        ps = conn.prepareStatement("delete from receptionists where receptionist_id = ?");
        ps.setString(1, recepId);
        return ps.executeUpdate() == 1;
    }
    
    public static ReceptionistPojo getRecepbyId(String recepId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from receptionists where receptionist_id = ?");
        ps.setString(1, recepId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        ReceptionistPojo recep = new ReceptionistPojo();
        recep.setReceptionistId(rs.getString(1));
        recep.setReceptionistName(rs.getString(2));
        recep.setReceptionistGender(rs.getString(3));
        return recep;
    }
    
    public static boolean updateRecep(ReceptionistPojo recep) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update receptionists set receptionist_name = ?, gender = ? where receptionist_id = ?");
        ps.setString(1,recep.getReceptionistName());
        ps.setString(2, recep.getReceptionistGender());
        ps.setString(3, recep.getReceptionistId());
        
        return ps.executeUpdate() == 1;
    }
}
