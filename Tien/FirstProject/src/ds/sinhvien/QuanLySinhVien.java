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
@WebServlet("/manage")
public class QuanLySinhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> student = new ArrayList<SinhVien>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuanLySinhVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		if (request.getParameter("name")!=null || request.getParameter("birthday")!=null) {
			String name = request.getParameter("name");
			String birthday = request.getParameter("birthday");
			student.add(new SinhVien(name, birthday));
		}
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\' integrity=\'sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO' crossorigin='anonymous'>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Danh sách sinh viên</h1>");
		out.println("<table class='table table-dark'><tr><td>STT</td><td>Họ tên</td><td>Tuổi</td></tr>");
		int i = 0;
		for(SinhVien sv : student) {
			i++;
			int tuoi = 2018 - Integer.parseInt(sv.getNamSinh());
			out.println("<tr><td>"+i+"</td><td>"+sv.getHoTen()+"</td><td>"+tuoi+"</td></tr>");
		}
		out.println("</table>");
		out.println("<h2><a href='AddSinhVien.html'>Thêm</a></h2>");
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
