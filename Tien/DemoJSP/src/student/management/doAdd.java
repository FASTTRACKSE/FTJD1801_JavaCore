package student.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class doAdd
 */
@WebServlet("/doAdd")
public class doAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
		ArrayList<SinhVien> listStudent = new ArrayList<SinhVien>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		listStudent = (ArrayList<SinhVien>) request.getSession().getAttribute("shareList");
		if (request.getParameter("name") != null && request.getParameter("birthday") != null && request.getParameter("id") != null) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String birthday = request.getParameter("birthday");
			if (id != null && name != null && birthday != null) {
				listStudent.add(new SinhVien(id, name, birthday));
			}
		}
		response.sendRedirect("qlsv");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
