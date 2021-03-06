package student.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class doUpdate
 */
@WebServlet("/doUpdate")
public class doUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> listStudent = new ArrayList<SinhVien>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doUpdate() {
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

		String idUpdate = request.getParameter("idUpdate");
		String nameUpdate = request.getParameter("nameUpdate");
		String birthUpdate = request.getParameter("birthUpdate");
		if (listStudent != null) {
			for (SinhVien sv : listStudent) {
				if (sv.getmaSV().equals(idUpdate)) {
					sv.setHoTen(nameUpdate);
					sv.setNamSinh(birthUpdate);
					break;
				}
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
