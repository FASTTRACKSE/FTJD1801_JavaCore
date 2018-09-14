package quanlysinhvien;

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
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (request.getParameter("name") != null && request.getParameter("birthday") != null) {
			for (SinhVien sv : student) {
				if (Integer.parseInt(request.getParameter("id")) == sv.getId()) {
					sv.setHoTen(request.getParameter("name"));
					sv.setNamSinh(Integer.parseInt(request.getParameter("birthday")));
					break;
				} else {
					SinhVien svNew = new SinhVien();
					svNew.setId(Integer.parseInt(request.getParameter("id")));
					svNew.setHoTen(request.getParameter("name"));
					svNew.setNamSinh(Integer.parseInt(request.getParameter("birthday")));
					student.add(svNew);
					break;
				}
			}
		}

		String action = "";
		action = (request.getPathInfo() != null ? request.getPathInfo()
				: (request.getServletPath() != null ? request.getServletPath() : "/"));

		try {
			switch (action) {
			case "/new":
				showAddForm(request, response);
				break;

			case "/insert":
				addStudent(request, response);
				break;

			case "/delete":
				deleteStudent(request, response);
				break;

			case "/edit":
				updateFormStudent(request, response);
				break;

			case "/update":
				updateStudent(request, response);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String head = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' >"
				+ "</head>";
		out.println(head);
		String bodyContent = "<body>" + "<h1>Danh sách sinh viên</h1>"
				+ "<a href=\"/QuanLySinhVien/new\" class=\"btn btn-info\">Thêm sinh viên</a>"
				+ "<table class='table'><tr><td>STT</td><td>Họ tên</td><td>Tuổi</td><td>Thao tác</td></tr>";
		out.println(bodyContent);
		int i = 0;
		for (SinhVien sv : student) {
			i++;
			int tuoi = 2018 - sv.getNamSinh();
			out.println("<tr><td>" + i + "</td><td>" + sv.getHoTen() + "</td><td>" + tuoi
					+ "</td> <td><a href = \"/QuanLySinhVien/edit?id=" + sv.getId()
					+ "\">  Sửa </a></td> <td><a href = \"/QuanLySinhVien/delete?id=" + sv.getId()
					+ "\">  Xóa </a></td></tr>");
		}
		out.println("</table>");
		out.println("</body></html>");
	}

	private void showAddForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String content = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Thêm sinh viên mới</title>\r\n" + "</head>\r\n" + "<body>\r\n"
				+ "	<h1>Form thêm sinh viên</h1>\r\n"
				+ "	<form action=\"manage\" method=\"post\" class=\"form-group\">\r\n"
				+ "		ID: <input type=\"text\" name=\"id\"><br> \r\n"
				+ "		Name: <input type=\"text\" name=\"name\"><br> \r\n"
				+ "		BirthDay: <input type=\"text\" name=\"birthday\"><br> \r\n"
				+ "		<input type=\"submit\" value=\"Thêm\">" + "	</form>\r\n" + "</body>\r\n" + "</html>";
		out.print(content);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int birthday = Integer.parseInt(request.getParameter("birthday"));
		student.add(new SinhVien(id, name, birthday));
		
	}

	private void updateFormStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String head = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' >"
				+ "</head>";
		out.println(head);
		out.println("<body>");
		out.print("<form action=\"manage\" method=\"post\" class=\"form-group\">\r\n");
		int id = Integer.parseInt(request.getParameter("id"));
		for (SinhVien sv : student) {
			if (sv.getId() == id) {
				out.println("ID: <input value =" + sv.getId() + " name = \"idUpdate\" ><br>");
				out.println("Họ tên: <input value =" + sv.getHoTen() + " name = \"nameUpdate\" ><br>");
				out.println("Năm sinh: <input value =" + sv.getNamSinh() + " name = \"birthdayUpdate\"><br>");
			}
		}
		out.println(" <input type = \"submit\" value = \"Sửa thông tin\">" + "	</form>\r\n");
		out.println("</body></html>");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("name") != null || request.getParameter("birthday") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int birthday = Integer.parseInt(request.getParameter("birthday"));
			if (id != 0 && name != null && birthday != 0) {
				student.add(new SinhVien(id, name, birthday));
			}
		}
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String head = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' >"
				+ "</head>";
		out.println(head);
		String bodyContent = "<body>" + "<h1>Danh sách sinh viên</h1>"
				+ "<a href=\"/QuanLySinhVien/new\" class=\"btn btn-info\">Thêm sinh viên</a>"
				+ "<table class='table'><tr><td>STT</td><td>Họ tên</td><td>Tuổi</td><td>Thao tác</td></tr>";
		out.println(bodyContent);
		int idUpdate = Integer.parseInt(request.getParameter("idUpdate"));
		String nameUpdate = request.getParameter("nameUpdate");
		int birthUpdate = Integer.parseInt(request.getParameter("birthUpdate"));
		if (student != null) {
			for (SinhVien sv : student) {
				if (sv.getId() == idUpdate) {
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
				int tuoi = 2018 - sv.getNamSinh();
				out.println("<tr><td>" + i + "</td><td>" + sv.getHoTen() + "</td><td>" + tuoi
						+ "</td> <td><a href = \"/QuanLySinhVien/edit?id=" + sv.getId()
						+ "\">  Sửa </a></td> <td><a href = \"/QuanLySinhVien/delete?id=" + sv.getId()
						+ "\">  Xóa </a></td></tr>");
				;
			}
		}
		out.println("</table>");
		out.println("</body></html>");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		if (request.getParameter("name") != null || request.getParameter("birthday") != null) {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int birthday = Integer.parseInt(request.getParameter("birthday"));
			if (id != 0 && name != null && birthday != 0) {
				student.add(new SinhVien(id, name, birthday));
			}
		}

		PrintWriter out = response.getWriter();
		String head = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' >"
				+ "</head>";
		out.println(head);
		String bodyContent = "<body>" + "<h1>Danh sách sinh viên</h1>"
				+ "<a href=\"/QuanLySinhVien/new\" class=\"btn btn-info\">Thêm sinh viên</a>"
				+ "<table class='table'><tr><td>STT</td><td>Họ tên</td><td>Tuổi</td><td>Thao tác</td></tr>";
		out.println(bodyContent);

		int id = Integer.parseInt(request.getParameter("id"));
		if (id != 0 && student != null) {
			for (SinhVien sv : student) {
				if (sv.getId() == id) {
					student.remove(sv);
					break;
				}
			}
		}

		int i = 0;
		if (student != null) {
			for (SinhVien sv : student) {
				i++;
				int tuoi = 2018 - sv.getNamSinh();
				out.println("<tr><td>" + i + "</td><td>" + sv.getHoTen() + "</td><td>" + tuoi
						+ "</td> <td><a href = \"/QuanLySinhVien/edit?id=" + sv.getId()
						+ "\">  Sửa </a></td> <td><a href = \"/QuanLySinhVien/delete?id=" + sv.getId()
						+ "\">  Xóa </a></td></tr>");
				;
			}
		}
		out.println("</table>");
		out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
