<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tính tổng</title>
</head>
<body>
	<%!int soA, soB;

	int tinhTong(int a, int b) {
		return (a + b);
	}%>
	<%
		if (request.getParameter("a") != "") {
			soA = Integer.parseInt(request.getParameter("a"));
		}
		if (request.getParameter("b") != "") {
			soB = Integer.parseInt(request.getParameter("b"));
		}
	%>
	<h3>Chương trình tính tổng hai số A và B</h3>
	<h3>---------------------------------------</h3>
	<a href = "formNhap.html">Nhập 2 số</a>
	<p>
		Số A =
		<%=soA%>
	</p>
	<p>
		Số B =
		<%=soB%>
	</p>
	<h4>
		Tổng A + B =
		<%=tinhTong(soA, soB)%></h4>
</body>
</html>