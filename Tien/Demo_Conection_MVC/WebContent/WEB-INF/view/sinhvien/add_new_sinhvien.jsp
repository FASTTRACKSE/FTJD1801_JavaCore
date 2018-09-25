<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<title>THÊM MỘT CHÚT</title>
	<script language="Javascript">
            function IsEmpty(){
            	var Sid = document.forms['frm']['id'].value;
            	var Sname = document.forms['frm']['name'].value;
            	var Sbirth = document.forms['frm']['birthday'].value;
                if( Sid == "" || Sname == "" || Sbirth == "")
                {
                    alert("Bạn cần nhập đầy đủ thông tin!");
                    return false;
                }
                return true;
            }
	</script>
</head>
<body>
	<div style="width: 300px; margin: 10px;">
		<h1>Thêm sinh viên</h1>
		<form action="do_insert" onsubmit="return IsEmpty()" method="post" name="frm">
			<label>Student ID</label> 
			<input type="text" name="id" class="form-control" placeholder="Student ID" pattern="[0-9]{1,12}"><br> 
			<label>Full Name</label> 
			<input type="text" name="hoten" class="form-control" placeholder="Full Name"><br>
			<label>Year Of Birth</label>
			<input type="text" name="namsinh" class="form-control"	placeholder="Year Of Birth" pattern="[0-9]{4}"><br> 
			<input  type="submit" value="Thêm" class="btn btn-primary" >
		</form>
	</div>
</body>
</html>