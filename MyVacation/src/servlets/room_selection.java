package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.room_selectionDao;

/**
 * Servlet implementation class room_selection
 */
@WebServlet("/room_selection")
public class room_selection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public room_selection() {
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
		
		//Comparing two dates example
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd h:m");
		System.out.println(sdf.parse(startDate).before(sdf.parse(endDate)));*/
		doGet(request, response);int donecount=0;int j=1;String check_in[]=new String[10];String check_out[]=new String[10];int roomnum[]=new int[10];
		String checkin_date=null;String checkout_date=null;
		response.setContentType("text/html");    
        PrintWriter out = response.getWriter();
		HttpSession session= request.getSession();
		request.setAttribute("dest",session.getAttribute("dest"));
		request.setAttribute("hotel",session.getAttribute("hotelname"));
		String room_selection = request.getParameter("rooms");
		String room_count = request.getParameter("room_count");
		String email= (String)session.getAttribute("email");
		String fromdate=(String)session.getAttribute("");
		String frommonth=(String)session.getAttribute("");
		String todate=(String)session.getAttribute("");
		String tomonth=(String)session.getAttribute("");
		j=Integer.parseInt(room_count);
		try{
		room_selectionDao.Validate(room_selection,(String)session.getAttribute("hotelname"),(String)session.getAttribute("dest"));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		for(int i=0;i<j;i++){
		if(check_in[i]==null && check_out[i]==null){
			//room_selectionDao.update();donecount++;
			if(donecount==(Integer.parseInt(room_count))){
			out.print("<p style=\"color:red\"> Your room selection is successful</p>");
			RequestDispatcher rdr=request.getRequestDispatcher("Hotelhudson.jsp");
			rdr.include(request,response);
				}
		}
		/*else if(check_in[i]>checkin_date && checkin[i]>checkout_date){
			room_selectionDao.Insert();donecount++;
			if(donecount==room_count){
				out.print("<p style=\"color:red\"> Your room selection is successful</p>");
				RequestDispatcher rdr=request.getRequestDispatcher("Hotelhudson.jsp");
				rdr.include(request,response);
					}
		}
		else if(check_out[i]<checkin_date && check_out[i]<checkout_date){
			room_selectionDao.Insert();donecount++;
			if(donecount==room_count){
				out.print("<p style=\"color:red\"> Your room selection is successful</p>");
				RequestDispatcher rdr=request.getRequestDispatcher("Hotelhudson.jsp");
				rdr.include(request,response);
		}*/
	    else{
	    	
	    	if(i==j-1){
	    	out.print("<p style=\"color:red\"> The selected rooms are not available, please choose another</p>");
	    	RequestDispatcher rdr=request.getRequestDispatcher("Hotelhudson.jsp");
			rdr.include(request,response);
	    }}
	}
	}

}
