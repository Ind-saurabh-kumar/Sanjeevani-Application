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
import sanjeevaniapp.pojo.DoctorPojo;


/**
 *
 * @author TANMAY KUMAR
 */
public class DoctorDao {
    public static void updateName(String currName,String newName) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update doctors set doctor_name = ? where doctor_name = ?");
        ps.setString(1,newName);
        ps.setString(2,currName);
        ps.executeUpdate();
    }
    
    
    
    public static void deleteDoctor(String name) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from doctors where doctor_name = ?");
        ps.setString(1,name);
        ps.executeUpdate();
    }
    
    public static boolean addDoctor(DoctorPojo doc) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into doctors values(?,?,?,?,?,?,?)");
        ps.setString(1, doc.getDoctorId());
        ps.setString(2, doc.getDoctorName());
        ps.setString(3, doc.getEmailId());
        ps.setString(4, doc.getContactNo());
        ps.setString(5, doc.getQualification());
        ps.setString(6, doc.getGender());
        ps.setString(7, doc.getSpecialist());
        
        return (ps.executeUpdate() == 1);
    }
    
    public static String getNextDocId() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select max(doctor_id) from doctors");
        rs.next();
        String str=rs.getString(1);
        int empId=101;
        if(str!=null){
            String id=str.substring(3);
            empId=Integer.parseInt(id);
            empId++;
        }
        String newId="DOC"+empId;
        return newId;  
    }
    
    public static List<DoctorPojo> getAllDocDetails() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select *from doctors order by doctor_id");
        List<DoctorPojo> docList = new ArrayList<>();
        while(rs.next()){
            DoctorPojo doc = new DoctorPojo();
            doc.setDoctorId(rs.getString(1));
            doc.setDoctorName(rs.getString(2));
            doc.setEmailId(rs.getString(3));
            doc.setContactNo(rs.getString(4));
            doc.setQualification(rs.getString(5));
            doc.setGender(rs.getString(6));
            doc.setSpecialist(rs.getString(7));
            docList.add(doc);
        }
        return docList;
    }
    
    public static List<String> getAllDocIds() throws SQLException{
        Connection conn = DBConnection.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select doctor_id from doctors order by doctor_id");
        List<String> docIdList = new ArrayList<>();
        while(rs.next()){
            String docId = rs.getString(1);
            docIdList.add(docId);
        }
        return docIdList;
    }
    
    public static boolean deleteDocbyId(String docId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select doctor_name from doctors where doctor_id = ?");
        ps.setString(1, docId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        String docName = rs.getString(1);
        UserDao.deleteUserByName(docName);
        ps = conn.prepareStatement("delete from doctors where doctor_id = ?");
        ps.setString(1, docId);
        return ps.executeUpdate() == 1;
    }
    
    public static DoctorPojo getDocById(String docId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("select * from doctors where doctor_id = ?");
        ps.setString(1, docId);
        ResultSet rs = ps.executeQuery();
        rs.next();
        DoctorPojo doc = new DoctorPojo();
        doc.setDoctorId(rs.getString(1));
        doc.setDoctorName(rs.getString(2));
        doc.setEmailId(rs.getString(3));
        doc.setContactNo(rs.getString(4));
        doc.setQualification(rs.getString(5));
        doc.setGender(rs.getString(6));
        doc.setSpecialist(rs.getString(7));
        return doc;
    }
    
    public static boolean updateDoc(DoctorPojo doc) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("update doctors set doctor_name = ?, contact_no = ?, email_id = ?, qualification = ?, specialist = ?, gender = ? where doctor_id = ?");
        ps.setString(1, doc.getDoctorName());
        ps.setString(2, doc.getContactNo());
        ps.setString(3, doc.getEmailId());
        ps.setString(4,doc.getQualification());
        ps.setString(5, doc.getSpecialist());
        ps.setString(6, doc.getGender());
        ps.setString(7, doc.getDoctorId());
        
        return ps.executeUpdate() == 1;
    }
    
    public static String getDoctorNameById(String docId)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select doctor_name from doctors where doctor_id=?");
        ps.setString(1,docId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        return rs.getString(1);

    } 
}
