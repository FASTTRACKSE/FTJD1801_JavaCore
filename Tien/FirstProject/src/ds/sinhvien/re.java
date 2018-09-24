package ds.sinhvien;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.RequestUtil;

/**
 * Servlet implementation class re
 */
@WebServlet("/re")
public class re extends HttpServlet {
	private static final long serialVersionUID = 1L;
		ArrayList<SinhVien> student = new ArrayList<SinhVien>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public re() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		student = (ArrayList<SinhVien>) request.getSession().getAttribute("shareStudent");
		
		String id = request.getParameter("id");
		if (id != null && student != null) {
			for (SinhVien sv : student) {
				if (sv.getMaSV().equals(id)) {
					student.remove(sv);
					break;
				}
			}
		}

		response.sendRedirect("main");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
