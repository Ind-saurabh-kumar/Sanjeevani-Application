package sanjeevaniapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gyan kumar
 */
public class DBConnection {
    private static Connection conn;
    static {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
        }catch(ClassNotFoundException ex){
            ex.printStackTrace();
            System.exit(0);
        }
        
        try{
            conn =  DriverManager.getConnection("jdbc:oracle:thin:@//localhost/XE","projects","java");
        }catch(SQLException ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
    
    public static void closeConnection(){
        try{
            conn.close();
        }catch(SQLException ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }
    
}
