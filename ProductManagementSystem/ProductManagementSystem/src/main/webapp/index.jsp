<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	if(session.getAttribute("username")!=null){
		response.sendRedirect("./Products");
	}
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/a.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<% if(request.getAttribute("errMsg")!=null)
			out.print("<div class='alert alert-danger m-2'>"+request.getAttribute("errMsg")+"</div>");
		%> 
    <div class="container-fluid d-flex justify-content-center align-items-center" style="min-height:70vh;">
        <div style="width:750px;">
            <form class="container" style="background-color:rgb(245,248,251); border:1px solid rgb(201, 213, 228)" action="login" method="post">
                <div class=" row fw-bolder ps-2 fs-4 p-1" style="background-color:rgb(235,241,247); 
                border-bottom:1px solid rgb(201, 213, 228);
                color:rgb(4,52,99)">Login</div>
                <div class="row p-3">
                    <div class="col-3">
                        <label>Username:</label>
                    </div>
                    <div class="col-9 ">
                         <span class="text-danger">*</span>
                        <input type="text" name="username" required />
                    </div>
                </div>
                <div class="row p-3">
                    <div class="col-3">
                        <label>Password:</label>
                    </div>
                    <div class="col-9">
                        <span class="text-danger">*</span>
                        <input type="password" name="password" required />
                    </div>
                </div>
                <div class="p-3 w-75 text-center">
                            <a href="#">Forgot Your Password?</a>
                </div>
                <div class="row p-2" style="background-color:rgb(235,241,247); border-top:1px solid rgb(201, 213, 228)">
                    <div class="col-3 ms-auto" >
                        <input type="submit"  value="Login >>">
                    </div>
                </div>
            </form>
        </div>
    </div>


</body>

</html>