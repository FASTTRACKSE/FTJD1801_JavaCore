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
		student.add(new SinhVien("161250533543", "Trần Tài Tiên", "1998"));
		student.add(new SinhVien("161250533324", "Trương Thị Mỹ Liên", "1998"));
		student.add(new SinhVien("161250533533", "Nguyễn Thành Tâm", "1999"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = "";
		action = (request.getPathInfo() != null ? request.getPathInfo()
				: (request.getServletPath() != null ? request.getServletPath() : "/"));

		try {
			switch (action) {
			case "/showform":
				showAddForm(request, response);
				break;

			case "/insert":
				AddStudent(request, response);
				break;

			case "/remove":
				RemoveStudent(request, response);
				break;
//				
//			case "/edit":
//				showEditForm(request, response);
//				break;
//				
			case "/update":
				UpdateStudent(request, response);
				break;

			case "/index":
				listStudent(request, response);
				break;

			default:
				listStudent(request, response);
				break;

			}
		} catch (Exception ex) {
			//
		}

	}

	protected void UpdateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		String head1 = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>"
				+ "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">"
				+ "<title>QUẢN LÝ SINH VIÊN</title>" + "</head>" + "<body>"
				+ "<marquee><h1>Danh sách sinh viên	</h1></marquee>"
				+ "<table class='table table-hover table-dark'><tr><td>STT</td><td>Mã sinh viên</td><td>Họ tên</td><td>Tuổi</td><td>Thao tác</td></tr>";
		out.println(head1);

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

		int i = 0;
		if (student != null) {
			for (SinhVien sv : student) {
				i++;
				int tuoi = 2018 - Integer.parseInt(sv.getNamSinh());
				out.println("<tr><td>" + i + "</td><td>" + sv.getMaSV() + "</td><td>" + sv.getHoTen() + "</td><td>"
						+ tuoi + "</td><td><a href='showform?id=" + sv.getMaSV()
						+ "'><i class=\"fas fa-edit\"></i> </a><a href='remove?id=" + sv.getMaSV()
						+ "'> <i class=\"fas fa-trash\"></i></a></td></tr>");
			}
		}
		String foot1 = "</table>" + "<h3 style='float: left;'><a href='insert'>Thêm</a></h3>" + "</body></html>";
		out.println(foot1);
	}

	protected void RemoveStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		PrintWriter out = response.getWriter();
		String head1 = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>"
				+ "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">"
				+ "<title>QUẢN LÝ SINH VIÊN</title>" + "</head>" + "<body>"
				+ "<marquee><h1>Danh sách sinh viên	</h1></marquee>"
				+ "<table class='table table-hover table-dark'><tr><td>STT</td><td>Mã sinh viên</td><td>Họ tên</td><td>Tuổi</td><td>Thao tác</td></tr>";
		out.println(head1);

		String id = request.getParameter("id");
		if (id != null && student != null) {
			for (SinhVien sv : student) {
				if (sv.getMaSV().equals(id)) {
					student.remove(sv);
					break;
				}
			}
		}

		int i = 0;
		if (student != null) {
			for (SinhVien sv : student) {
				i++;
				int tuoi = 2018 - Integer.parseInt(sv.getNamSinh());
				out.println("<tr><td>" + i + "</td><td>" + sv.getMaSV() + "</td><td>" + sv.getHoTen() + "</td><td>"
						+ tuoi + "</td><td><a href='showform?id=" + sv.getMaSV()
						+ "'><i class=\"fas fa-edit\"></i> </a><a href='remove?id=" + sv.getMaSV()
						+ "'> <i class=\"fas fa-trash\"></i></a></td></tr>");
			}
		}
		String foot1 = "</table>" + "<h3 style='float: left;'><a href='insert'>Thêm</a></h3>" + "</body></html>";
		out.println(foot1);
	}

	protected void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

		PrintWriter out = response.getWriter();
		String head1 = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css' integrity='sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>"
				+ "<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.3.1/css/all.css\" integrity=\"sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU\" crossorigin=\"anonymous\">"
				+ "<title>QUẢN LÝ SINH VIÊN</title>" + "</head>" + "<body>"
				+ "<marquee><h1>Danh sách sinh viên	</h1></marquee>"
				+ "<table class='table table-hover table-dark'><tr><td>STT</td><td>Mã sinh viên</td><td>Họ tên</td><td>Tuổi</td><td>Thao tác</td></tr>";
		out.println(head1);

		int i = 0;
		if (student != null) {
			for (SinhVien sv : student) {
				i++;
				int tuoi = 2018 - Integer.parseInt(sv.getNamSinh());
				out.println("<tr><td>" + i + "</td><td>" + sv.getMaSV() + "</td><td>" + sv.getHoTen() + "</td><td>"
						+ tuoi + "</td><td><a href='showform?id=" + sv.getMaSV()
						+ "'><i class=\"fas fa-edit\"></i> </a><a href='remove?id=" + sv.getMaSV()
						+ "'> <i class=\"fas fa-trash\"></i></a></td></tr>");
			}
		}
		String foot1 = "</table>" + "<h3 style='float: left;'><a href='insert'>Thêm</a></h3>" + "</body></html>";
		out.println(foot1);
	}

	protected void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
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
				+ "		<form action=\"update\" method=\"post\">\r\n" + "			<label>Student ID</label> \r\n"
				+ "			<input type=\"text\" name=\"idUpdate\" class=\"form-control\" placeholder=\"Student ID\" value=\""
				+ id + "\"><br> \r\n" + "			<label>Full Name</label> \r\n"
				+ "			<input type=\"text\" name=\"nameUpdate\" class=\"form-control\" placeholder=\"Full Name\" value=\""
				+ name + "\"><br>\r\n" + "			<label>Year Of Birth</label> \r\n"
				+ "			<input type=\"text\" name=\"birthUpdate\" class=\"form-control\"	placeholder=\"Year Of Birth\" value=\""
				+ birth + "\"><br> \r\n"
				+ "			<input type=\"submit\" value=\"Cập nhật\" class=\"btn btn-primary\">\r\n"
				+ "		</form>\r\n" + "	</div>\r\n" + "</body>\r\n" + "</html>";
		PrintWriter out = response.getWriter();
		out.println(html);
	}

	protected void AddStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		String html = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"\r\n"
				+ "	integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n" + "<title>THÊM MỘT CHÚT</title>\r\n"
				+ "	<script language=\"Javascript\">\r\n" + "            function IsEmpty(){\r\n"
				+ "            	var Sid = document.forms['frm']['id'].value;\r\n"
				+ "            	var Sname = document.forms['frm']['name'].value;\r\n"
				+ "            	var Sbirth = document.forms['frm']['birthday'].value;\r\n"
				+ "                if( Sid == \"\" || Sname == \"\" || Sbirth == \"\")\r\n" + "                {\r\n"
				+ "                    alert(\"Bạn cần nhập đầy đủ thông tin!\");\r\n"
				+ "                    return false;\r\n" + "                }\r\n" + "                return true;\r\n"
				+ "            }\r\n" + "	</script>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<div style=\"width: 300px; margin: 10px;\">\r\n" + "		<h1>Thêm sinh viên</h1>\r\n"
				+ "		<form action=\"index\" onsubmit=\"return IsEmpty()\" method=\"post\" name=\"frm\">\r\n"
				+ "			<label>Student ID</label> \r\n"
				+ "			<input type=\"text\" name=\"id\" class=\"form-control\" placeholder=\"Student ID\" pattern=\"[0-9]{1,12}\"><br> \r\n"
				+ "			<label>Full Name</label> \r\n"
				+ "			<input type=\"text\" name=\"name\" class=\"form-control\" placeholder=\"Full Name\"><br>\r\n"
				+ "			<label>Year Of Birth</label>\r\n"
				+ "			<input type=\"text\" name=\"birthday\" class=\"form-control\"	placeholder=\"Year Of Birth\" pattern=\"[0-9]{4}\"><br> \r\n"
				+ "			<input  type=\"submit\" value=\"Thêm\" class=\"btn btn-primary\" >\r\n" + "		</form>\r\n"
				+ "	</div>\r\n" + "</body>\r\n" + "</html>";
		PrintWriter out = response.getWriter();
		out.println(html);
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
