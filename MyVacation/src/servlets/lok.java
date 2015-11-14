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
import dao.Logindao;

/**
 * Servlet implementation class lok
 */
@WebServlet("/lok")
public class lok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lok() {
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
		System.out.println("its working");
		try{
	        response.setContentType("text/html");    
	        PrintWriter out = response.getWriter();    
	        
	        String n=request.getParameter("email");    
	        String p=request.getParameter("password");   
	        
	        HttpSession session = request.getSession();
	        session.setMaxInactiveInterval(10000);
	        
	        //System.out.println("Test1");
	        //Logindao.validate(n, p)
				if(true){    
			        session.setAttribute("email", n);
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
				// TODO Auto-generated catch blocksetMaxInactiveInterval(int interval)
				e.printStackTrace();
			}*/   catch(Exception e)
	    	{
	    		e.printStackTrace();
	    	}
	}

}
