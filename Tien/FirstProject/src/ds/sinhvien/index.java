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
 * Servlet implementation class index
 */
@WebServlet("/main")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> student = new ArrayList<SinhVien>();
   
    public index() {
    	student.add(new SinhVien("161250533543", "Trần Tài Tiên", "1998"));
		student.add(new SinhVien("161250533324", "Trương Thị Mỹ Liên", "1998"));
		student.add(new SinhVien("161250533533", "Nguyễn Thành Tâm", "1999"));
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (request.getParameter("name") != null || request.getParameter("birthday") != null) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String birthday = request.getParameter("birthday");
			if (id != null && name != null && birthday != null) {
				student.add(new SinhVien(id, name, birthday));
			}
		}
		
		request.getSession().setAttribute("shareStudent", student);

		PrintWriter out = response.getWriter();
		String head1 = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>"
				+ "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">"
				+ "<title>QUẢN LÝ SINH VIÊN</title>" + "</head>" + "<body>"
				+ "<marquee><h1>Danh sách sinh viên	</h1></marquee>"
				+ "<table class=\"table table-hover\"><tr><td>STT</td><td>Mã sinh viên</td><td>Họ tên</td><td>Tuổi</td><td>Thao tác</td></tr>";
		out.println(head1);

		int i = 0;
		if (student != null) {
			for (SinhVien sv : student) {
				i++;
				int tuoi = 2018 - Integer.parseInt(sv.getNamSinh());
				out.println("<tr><td>" + i + "</td><td>" + sv.getMaSV() + "</td><td>" + sv.getHoTen() + "</td><td>"
						+ tuoi + "</td><td><a href='up?id=" + sv.getMaSV()
						+ "'><i class=\"fas fa-edit\"></i> </a><a href='re?id=" + sv.getMaSV()
						+ "'> <i class=\"fas fa-trash\"></i></a></td></tr>");
			}
		}
		String foot1 = "</table>" + "<h3 style='float: left;'><a href='add'>Thêm</a></h3>" + "</body></html>";
		out.println(foot1);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
