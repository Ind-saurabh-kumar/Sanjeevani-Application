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
import java.util.ArrayList;
import java.util.List;
import sanjeevaniapp.dbutil.DBConnection;
import sanjeevaniapp.pojo.AppointmentPojo;

/**
 *
 * @author Gyan Prakash
 */
public class AppointmentDao {
    public static boolean addAppointment(AppointmentPojo appt)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Insert into appointments values(?,?,?,?,?,?,?)");
        ps.setString(1,appt.getPatientId());
        ps.setString(2, appt.getPatientName());
        ps.setString(3,appt.getStatus());
        ps.setString(4, appt.getOpd());
        ps.setString(5, appt.getAppointmentDate());
        ps.setString(6,appt.getDoctorName());
        ps.setString(7,appt.getMobileNo());

        return ps.executeUpdate()==1;
    }
    
    public static List<AppointmentPojo> getAllAppointmentsByDoctorName(String doctorName,String status)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from appointments where doctor_name=? and status=? order by patient_id");
        ps.setString(1,doctorName);
        ps.setString(2, status);
        ResultSet rs=ps.executeQuery();
        List<AppointmentPojo>appList=new ArrayList<>();
        while(rs.next()){
            AppointmentPojo app=new AppointmentPojo();
            app.setPatientId(rs.getString("patient_id"));
            app.setPatientName(rs.getString("patient_name"));
            app.setOpd(rs.getString("opd"));
            app.setAppointmentDate(rs.getString("date_time"));
            app.setStatus(rs.getString("status"));
            app.setDoctorName(rs.getString("doctor_name"));
            app.setMobileNo(rs.getString("mobile_no"));
            appList.add(app);   

        }
        return appList;
    } 
    
    public static boolean updateAppointment(AppointmentPojo apt) throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("update appointments set patient_name = ? , opd = ? ,mobile_no = ?,doctor_name = ? where patient_id = ? ");
        ps.setString(1, apt.getPatientName());
        ps.setString(2, apt.getOpd());
        ps.setString(3, apt.getMobileNo());
        ps.setString(4, apt.getDoctorName());
        ps.setString(5, apt.getPatientId());
        
        return (ps.executeUpdate() == 1);
    }
    public static boolean updateStatus(AppointmentPojo app)throws SQLException{
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Update appointments set status = ?, date_time = ? where patient_id=?" );
        ps.setString(1, app.getStatus());
        ps.setString(2, app.getAppointmentDate());
        ps.setString(3,app.getPatientId());
        
        return (ps.executeUpdate()==1);
    }
    
    public static boolean deleteAptbyId(String patId) throws SQLException{
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("delete from appointments where patient_id = ?");
        ps.setString(1, patId);
        
        return (ps.executeUpdate() == 1);
    }
}
