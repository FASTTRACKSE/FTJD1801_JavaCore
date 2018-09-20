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
 * Servlet implementation class FormUpdateStudent
 */
@WebServlet("/FormUpdate")
public class FormUpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> student = new ArrayList<SinhVien>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormUpdateStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student = (ArrayList<SinhVien>) request.getSession().getAttribute("shareDsSinhVien");

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String head = "<html>" + "<head>"
				+ "<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' >"
				+ "</head>";
		out.println(head);
		out.println("<body>");
		out.print("<h> Sửa thông tin sinh viên </h>");
		out.print("<form action=\"UpdateStudent\" method=\"post\" class=\"form-group\">\r\n");
		int id = Integer.parseInt(request.getParameter("id"));
		for (SinhVien sv : student) {
			if (sv.getId() == id) {
				out.println("ID: <input value =" + sv.getId() + " name = \"idUpdate\" readonly /><br>");
				out.println("Họ tên: <input value =\"" + sv.getHoTen() + "\" name = \"nameUpdate\" /><br>");
				out.println("Năm sinh: <input value =" + sv.getNamSinh() + " name = \"birthdayUpdate\" /><br>");
			}
		}
		out.println(" <input type = \"submit\" class=\"btn btn-info\" value = \"Sửa thông tin\" />"
				+ " <a href=\"/QuanLySinhVien/\" class=\"btn btn-info\"> Cancel </a> " + "	</form>\r\n");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
