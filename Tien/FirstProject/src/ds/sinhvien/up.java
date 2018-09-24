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
 * Servlet implementation class up
 */
@WebServlet("/up")
public class up extends HttpServlet {
	private static final long serialVersionUID = 1L;
		ArrayList<SinhVien> student = new ArrayList<SinhVien>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public up() {
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
		
		String id = request.getParameter("id");
		String name = null;
		String birth = null;
		for (SinhVien sv : student) {
			if (sv.getMaSV().equals(id)) {
				name = sv.getHoTen();
				birth = sv.getNamSinh();
				break;
			}
		}
		String html = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n" + "<title>SỬA TOÀN BỘ</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<div style=\"width: 300px; margin: 10px;\">\r\n" + "		<h1>Cập nhật thông tin</h1>\r\n"
				+ "		<form action=\"doUp\" method=\"post\">\r\n" + "			<label>Student ID</label> \r\n"
				+ "			<input type=\"text\" name=\"idUpdate\" class=\"form-control\" placeholder=\"Student ID\" value=\""
				+ id + "\" disabled><br> \r\n" + "			<label>Full Name</label> \r\n"
				+ "			<input type=\"text\" name=\"nameUpdate\" class=\"form-control\" placeholder=\"Full Name\" value=\""
				+ name + "\"><br>\r\n" + "			<label>Year Of Birth</label> \r\n"
				+ "			<input type=\"text\" name=\"birthUpdate\" class=\"form-control\"	placeholder=\"Year Of Birth\" value=\""
				+ birth + "\"><br> \r\n"
				+ "			<input type=\"submit\" value=\"Cập nhật\" class=\"btn btn-primary\">\r\n"
				+ "		</form>\r\n" + "	</div>\r\n" + "</body>\r\n" + "</html>";
		PrintWriter out = response.getWriter();
		out.println(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
