<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sinh viên</title>
</head>
<body>
	<%!int i = 0;%>
	<marquee><h1>Danh sách sinh viên</h1></marquee>
	<table class="table table-hover">
		<c:forEach var="tempStudent" items="${shareList}">
			<tr>
				<td><%=++i%></td>
				<td>${tempStudent.maSV}</td>
				<td>${tempStudent.hoTen}</td>
				<td>${tempStudent.namSinh}</td>
				<td>
					<a href = "callFormUpdate?id=${tempStudent.maSV}" ><i class="fas fa-edit"></i></a>
					<a href = "callFormRemove?id=${tempStudent.maSV}" ><i class="fas fa-trash"></i></a>
				</td>
			</tr>
		</c:forEach>
		<% i = 0; %>
		<thead>
			<tr>
			<td>#</td>
			<td>Mã sinh viên</td>
			<td>Họ tên</td>
			<td>Tuổi</td>
			<td>Tác vụ</td>
		</tr>
		</thead>
	</table>
	<h3 style='text-align: center;'>
		<a href='callFormAdd' class="btn btn-primary btn-lg active">Thêm</a>
	</h3>
</body>
</html>