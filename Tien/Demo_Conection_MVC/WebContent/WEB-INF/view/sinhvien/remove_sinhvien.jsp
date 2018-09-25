<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>XÓA SẠCH HẾT</title>
</head>
<body> 
		<div style="width: 300px; margin: 10px;">
			<h1>Xóa sinh viên</h1>
			<form action="do_remove" method="post">
				<label>Student ID</label> 
				<input type="text" name="id" class="form-control" value="${shareStudent.maSV}" readonly="readonly"><br> 
				<label>Full Name</label> 
				<input type="text" name="hoten" class="form-control" value="${shareStudent.hoTen}" readonly="readonly"><br>
				<label>Year Of Birth</label> 
				<input type="text" name="namsinh" class="form-control" value="${shareStudent.namSinh}" readonly="readonly"><br> 
				<input type="submit" value="Xóa" class="btn btn-primary">
			</form>
		</div>
</body>
</html>