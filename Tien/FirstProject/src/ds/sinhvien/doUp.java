package ds.sinhvien;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class doUp
 */
@WebServlet("/doUp")
public class doUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
		ArrayList<SinhVien> student = new ArrayList<SinhVien>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doUp() {
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

		student = (ArrayList<SinhVien>) request.getSession().getAttribute("shareStudent");

		String idUpdate = request.getParameter("idUpdate");
		String nameUpdate = request.getParameter("nameUpdate");
		String birthUpdate = request.getParameter("birthUpdate");
		if (student != null) {
			for (SinhVien sv : student) {
				if (sv.getMaSV().equals(idUpdate)) {
					sv.setHoTen(nameUpdate);
					sv.setNamSinh(birthUpdate);
					break;
				}
			}
		}
		response.sendRedirect("main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
