<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<c:forEach var="sinhVien"items="${students_list}">
<tr>
<td>${sinhVien.ID} </td>
<td>${sinhVien.hoTen} </td>
<td>${sinhVien.namSinh} </td>
</tr>
</c:forEach>
</table>
</body>
</html>