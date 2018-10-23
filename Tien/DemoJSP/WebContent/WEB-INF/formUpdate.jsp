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
<title>SỬA TOÀN BỘ</title>
</head>
<body>
	 
		<div style="width: 300px; margin: 10px;">
			<h1>Cập nhật thông tin</h1>
			<form action="doUpdate" method="post">
				<label>Student ID</label> 
				<input type="text" name="idUpdate" class="form-control" placeholder="Student ID" value="${shareStudent.maSV}"><br> 
				<label>Full Name</label> 
				<input type="text" name="nameUpdate" class="form-control" placeholder="Full Name" value="${shareStudent.hoTen}"><br>
				<label>Year Of Birth</label> 
				<input type="text" name="birthUpdate" class="form-control"	placeholder="Year Of Birth" value="${shareStudent.namSinh}"><br> 
				<input type="submit" value="Cập nhật" class="btn btn-primary">
			</form>
		</div>
	
</body>
</html>