package ds.sinhvien;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class add
 */
@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add() {
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
				+ "		<form action=\"main\" onsubmit=\"return IsEmpty()\" method=\"post\" name=\"frm\">\r\n"
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
