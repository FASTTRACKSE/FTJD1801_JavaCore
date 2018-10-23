package student.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class main
 */
@WebServlet("/qlsv")
public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> listStudent = new ArrayList<SinhVien>();

	public main() {
		listStudent.add(new SinhVien("161250533543", "Trần Tài Tiên", "1998"));
		listStudent.add(new SinhVien("161250533324", "Trương Thị Mỹ Liên", "1998"));
		listStudent.add(new SinhVien("161250533533", "Nguyễn Thành Tâm", "1999"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 1: Prepare data
		request.getSession().setAttribute("shareList", listStudent);

		// Step 2: get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/pageMain.jsp");

		// Step 3: forward to the JSP
		dispatcher.forward(request, response);
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
