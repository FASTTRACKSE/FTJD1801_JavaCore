package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SinhVienDAO;
import entity.SinhVien;

/**
 * Servlet implementation class List
 * @param <SinhVien>
 */
@WebServlet("/list")
public class List<SinhVien> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SinhVienDAO studentDAO = new SinhVienDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public List() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<SinhVien> dsSinhVien = new ArrayList<SinhVien>();

		// Lay danh sach sinh vien tu tang DAO
		dsSinhVien = (ArrayList<SinhVien>) studentDAO.getAllSinhVien();

		request.getSession().setAttribute("student_list", dsSinhVien);

		// Step 2: get request dispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/sinhvien/ds_sinh_vien.jsp");

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
