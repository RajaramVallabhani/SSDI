package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

public class select_flight_hotelDao {
	public static String[] Validate(String roomtype,String hotelname, String dest) throws SQLException {          
        boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
		//Driver mysqlDriver=new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "ssdi";  
       // String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "Ramadevi_9";  
        String result[]=new String[10];int i=1;
        
        
        try {  
        	Driver mysqlDriver=new com.mysql.jdbc.Driver();
    		DriverManager.registerDriver(mysqlDriver);
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi", "root", "Ramadevi_9");
            
            pst = conn  
                    .prepareStatement("select room_num,checkin_date,checkout_date from reservations where room_type=? and hotel_id=(select hotel_id from hotel where hotelname=? and destination=?)");  
            
            pst.setString(1, roomtype);
            pst.setString(2, hotelname);  
            pst.setString(3, dest);
            
            ResultSet rs=pst.executeQuery("");
            while(rs.next()){
            	result[i]=rs.getString("room_num");
            	result[i++]=rs.getString("checkin_date");
            	result[i++]=rs.getString("checkout_date");
            }
  
        } catch (Exception e) {  
            System.out.println(e); 
            e.printStackTrace();
        } finally {  
            if (conn != null) {  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
            if (pst != null) {  
                try {  
                    pst.close();  
                } catch (SQLException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return result;  
    }
}
