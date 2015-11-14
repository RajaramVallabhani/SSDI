package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class hotel_listDao {
	 public static String[] retrieve(String dest) throws SQLException {          
	        boolean status = false;  
	        Connection conn = null;  
	        PreparedStatement pst = null;  
	        ResultSet rs = null;  
			//Driver mysqlDriver=new com.mysql.jdbc.Driver();
	        String url = "jdbc:mysql://localhost:3306/";  
	        String dbName = "ssdi";  
	       // String driver = "com.mysql.jdbc.Driver";  
	        String userName = "root";  
	        String password = "Ramadevi_9";  
	        String[] hotels=new String[20];int i=0;
	        
	        
	        try {  
	        	Driver mysqlDriver=new com.mysql.jdbc.Driver();
	    		DriverManager.registerDriver(mysqlDriver);
	    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi", "root", "Ramadevi_9");
	            
	            pst = conn  
	                    .prepareStatement("select distinct hotelname where destination=?");  
	            pst.setString(1, dest);
	  
	            rs = pst.executeQuery();  
	            while(rs.next()){
	            	hotels[i]= rs.getString("hotelname");i++;
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
	            if (rs != null) {  
	                try {  
	                    rs.close();  
	                } catch (SQLException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	        return hotels;  
	    }  
}
