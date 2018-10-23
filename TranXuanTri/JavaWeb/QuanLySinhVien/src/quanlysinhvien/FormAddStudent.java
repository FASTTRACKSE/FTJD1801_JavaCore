package quanlysinhvien;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quanlysinhvien.entity.SinhVien;

/**
 * Servlet implementation class UpdateSinhVien
 */
@WebServlet("/FormAdd")
public class FormAddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> student = new ArrayList<SinhVien>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormAddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		student = (ArrayList<SinhVien>) request.getSession().getAttribute("shareDsSinhVien");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();
		String content = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' >"
				+ "<title>Thêm sinh viên mới</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<h1>Form thêm sinh viên</h1>\r\n"
				+ "	<form action=\"AddStudent\" method=\"post\" class=\"form-group\">\r\n"
				+ "		ID: <input type=\"text\" name=\"id\"><br> \r\n"
				+ "		Name: <input type=\"text\" name=\"name\"><br> \r\n"
				+ "		BirthDay: <input type=\"text\" name=\"birthday\"><br> \r\n"
				+ "		<input type=\"submit\" class=\"btn btn-info\" value=\"Thêm\">"
				+ " <a href=\"/QuanLySinhVien/\" class=\"btn btn-info\"> Cancel </a> " + "	</form>\r\n" + "</body>\r\n"
				+ "</html>";
		out.print(content);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
