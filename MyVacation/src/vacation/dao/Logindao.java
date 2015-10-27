package vacation.dao;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;  
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
  
public class Logindao {  
    public static boolean validate(String name, String pass) throws SQLException {          
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
        
        
        try {  
        	Driver mysqlDriver=new com.mysql.jdbc.Driver();
    		DriverManager.registerDriver(mysqlDriver);
    		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ssdi", "root", "Ramadevi_9");
            
            pst = conn  
                    .prepareStatement("select * from login where username=? and password=?");  
            pst.setString(1, name);  
            pst.setString(2, pass);  
  
            rs = pst.executeQuery();  
            status = rs.next();  
  
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
        return status;  
    }  
} 