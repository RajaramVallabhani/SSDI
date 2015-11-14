package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.RegistrationDao;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("Test3");
    	try{
        response.setContentType("text/html");    
        PrintWriter out = response.getWriter();    
        
        String n=request.getParameter("usernamesignup");    
        String p=request.getParameter("passwordsignup");   
        String cp=request.getParameter("passwordsignup_confirm");
        String email=request.getParameter("emailsignup");
        HttpSession session = request.getSession();  
        
       // RegistrationDao.validate(email,n,p)
			if( p.equals(cp) && RegistrationDao.validate(email,n,p)){    
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
		} /*catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */  catch(Exception e)
    	{
    		e.printStackTrace();
    	}
	}

}
