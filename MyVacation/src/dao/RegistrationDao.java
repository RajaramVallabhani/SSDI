package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationDao {
	public static boolean validate(String email,String name, String pass) throws SQLException {          
        boolean status = false;  
        Connection conn = null;  
        PreparedStatement pst = null;  
		//Driver mysqlDriver=new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/";  
        String dbName = "ssdi";  
       // String driver = "com.mysql.jdbc.Driver";  
        String userName = "root";  
        String password = "Ramadevi_9";  
        
        
        try {  
        	Driver mysqlDriver=new com.mysql.jdbc.Driver();
    		DriverManager.registerDriver(mysqlDriver);
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi", "root", "Ramadevi_9");
            
            pst = conn  
                    .prepareStatement("insert into login(email,username,password) values(?,?,?)");  
            
            pst.setString(1, email);
            pst.setString(2, name);  
            pst.setString(3, pass);
            
            if(pst.executeUpdate()>0)
            	{
            	status=true;
            	}else
            	{
            	status=false;	
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
        return status;  
    }
}
