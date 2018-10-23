package methodDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class SubmitDemo
 */
@WebServlet("/SubmitDemo")
public class SubmitDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SubmitDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
			String firstName = request.getParameter("FirstName");
			String lastName = request.getParameter("LastName");
			String birthDay = request.getParameter("BirthDay");
			int tuoi = 2018 - Integer.parseInt(birthDay);
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h2>Thông báo</h2>");
			out.println("<hr>");
			out.println("Chào bạn : " + firstName + " " + lastName + "<br>");
			out.println("Có phải bạn " + tuoi + " tuổi không?");
			out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
