package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SinhVienDAO;
import entity.SinhVien;

/**
 * Servlet implementation class Do_Insert
 */
@WebServlet("/do_insert")
public class Do_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
		SinhVienDAO studentDAO = new SinhVienDAO();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Do_Insert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String hoTen = request.getParameter("hoten");
		int namSinh = Integer.parseInt(request.getParameter("namsinh"));

		SinhVien sinhVien = new SinhVien(id, hoTen, namSinh);
		studentDAO.addNewSinhVien(sinhVien);
		response.sendRedirect("list");
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
