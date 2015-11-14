package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.hotel_listDao;
/**
 * Servlet implementation class hotellistservlet
 */
@WebServlet("/hotellistservlet")
public class hotellistservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hotellistservlet() {
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
		try{
		doGet(request, response);
		HttpSession session= request.getSession();
		String email= (String)session.getAttribute("email");
		String destination= (String)session.getAttribute("dest");
		String[] s=new String[10];
		s=hotel_listDao.retrieve(destination);
		request.setAttribute("hotel1",s[0]);
		request.setAttribute("hotel2",s[1]);
		request.setAttribute("hotel3",s[2]);
		RequestDispatcher rdr=
				request.getRequestDispatcher("Hotels.jsp");
		rdr.forward(request, response);
		} catch(Exception e){}
	
	}

}
