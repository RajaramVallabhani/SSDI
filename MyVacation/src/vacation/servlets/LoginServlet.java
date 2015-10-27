package vacation.servlets;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
  
import vacation.dao.Logindao;  
  
public class LoginServlet extends HttpServlet{  
  
    private static final long serialVersionUID = 1L;  
  
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect("Register_Page.jsp");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)    
            throws ServletException, IOException {    
    	System.out.println("Test");
    	try{
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        
        String n=request.getParameter("username");    
        String p=request.getParameter("password");   
        
        HttpSession session = request.getSession(false);  
        System.out.println("Test1");
			if( Logindao.validate(n, p)){    
		        session.setAttribute("name", n); 
			    RequestDispatcher rd=request.getRequestDispatcher("Home_Page_Final.jsp");    
			    rd.forward(request,response);    
			}    
			else{    
			    out.print("<p style=\"color:red\">Sorry username or password error</p>");    
			    RequestDispatcher rd=request.getRequestDispatcher("Register_Page.jsp");    
			    rd.include(request,response);    
			}
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch(Exception e)
    	{
    		e.printStackTrace();
    	} 
  
            
    }    
}