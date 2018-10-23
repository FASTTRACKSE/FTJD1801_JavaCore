package quanlysinhvien;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.ApplicationBufferHandler;

import quanlysinhvien.entity.SinhVien;

/**
 * Servlet implementation class QuanLySinhVien
 */
@WebServlet("/")
public class QuanLySinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> student = new ArrayList<SinhVien>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QuanLySinhVien() {
		super();
		// TODO Auto-generated constructor stub
		student.add(new SinhVien(1, "tri", 1997));
		student.add(new SinhVien(2, "tri 2", 1989));
		student.add(new SinhVien(3, "tri 3", 1987));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("shareDsSinhVien", student);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String head = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' >"
				+ "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">"
				+ "<meta charset='utf-8'>" + "</head>";
		out.println(head);
		String bodyContent = "<body>" + "<h1 style=\"text-align: center;\">Danh sách sinh viên</h1>"
				+ "<a href=\"/QuanLySinhVien/FormAdd\" class=\"btn btn-info\">Thêm sinh viên</a>"
				+ "<table class=\"table table-striped\"><thead><tr><th>STT</th><th>Họ tên</th><th>Tuổi</th><th>Thao tác</th></tr></thead>";
		out.println(bodyContent);
		int i = 0;
		for (SinhVien sv : student) {
			i++;
			int tuoi = 2018 - sv.getNamSinh();
			out.println("<tr><td>" + i + "</td>" + "<td>" + sv.getHoTen() + "</td>" + "<td>" + tuoi + "</td> "
					+ "<td><a href = \"/QuanLySinhVien/FormUpdate?id=" + sv.getId()
					+ "\"  class=\"far fa-edit\"></a> <a class=\"far fa-trash-alt\" href = \"/QuanLySinhVien/FormDelete?id="
					+ sv.getId() + "\"></a></td></tr>");
		}
		out.println("</table>");
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
