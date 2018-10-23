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
 * Servlet implementation class callFormUpdate
 */
@WebServlet("/callFormUpdate")
public class callFormUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
		ArrayList<SinhVien> listStudent = new ArrayList<SinhVien>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public callFormUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listStudent = (ArrayList<SinhVien>) request.getSession().getAttribute("shareList");
		String id = request.getParameter("id");
		String hoTen = null;
		String namSinh = null;
		for(SinhVien sv : listStudent) {
			if(sv.getmaSV().equals(id)) {
				hoTen = sv.getHoTen();
				namSinh = sv.getNamSinh();
			}
		}
		SinhVien sv = new SinhVien(id, hoTen, namSinh);
		request.getSession().setAttribute("shareStudent", sv);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/formUpdate.jsp");

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
