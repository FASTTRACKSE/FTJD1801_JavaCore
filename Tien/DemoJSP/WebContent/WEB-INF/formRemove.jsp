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
			<form action="doRemove" method="post">
				<label>Student ID</label> 
				<input type="text" name="idRemove" class="form-control" value="${shareStudent.maSV}" disabled="disabled"><br> 
				<label>Full Name</label> 
				<input type="text" name="nameRemove" class="form-control" value="${shareStudent.hoTen}" disabled="disabled"><br>
				<label>Year Of Birth</label> 
				<input type="text" name="birthRemove" class="form-control" value="${shareStudent.namSinh}" disabled="disabled"><br> 
				<input type="submit" value="Xóa" class="btn btn-primary">
			</form>
		</div>
</body>
</html>