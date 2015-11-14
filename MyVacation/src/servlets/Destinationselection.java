package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.select_flight_hotelDao;

/**
 * Servlet implementation class Destinationselection
 */
@WebServlet("/Destinationselection")
public class Destinationselection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Destinationselection() {
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
		//save the attributes departure, destination, email
		try{
				HttpSession session = request.getSession();
				String dept=request.getParameter("MyLocation");
				String dest=request.getParameter("To");
				String email=(String)session.getAttribute("email");
				//select_flight_hotelDao.store(email,dest,dept);
				session.setAttribute("dest", dest);
				request.setAttribute("dest", dest);
					RequestDispatcher rdr=
							request.getRequestDispatcher("hotel_flight_selection.jsp");
					rdr.forward(request, response);
		}catch(Exception e)
		{
		}
		}
	}


