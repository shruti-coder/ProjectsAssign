<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Management System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="m-auto text-light fw-bold  fs-5">Factory Outlet</div>
	</nav>
	<div class="container-fluid px-5 py-3">
	
		<div class="row justify-content-center align-items-center p-4"
			style="min-height: 80vh">
			
			<div class="col-7 m-auto">
				<div
					class="py-5 d-flex  align-items-center text-center justify-content-center h-100">
					<form:form action="signed" modelAttribute="user" >
						<div class="text-center fs-4 fw-bold">User SignUp</div>
						<div class="row p-2">
							<div class="col-4">
								<form:label path="username" cssClass="form-label">Username</form:label>
							</div>
							<div class="col-7">
								<form:input cssClass="form-control" path="username"/>
							</div>
						</div>
						<div class="row ">
							<div class="col m-auto ">
								<form:errors path="username" cssClass="text-danger"/>
							</div>
						</div>
						<div class="row p-2">
							<div class="col-4">
								<form:label path="password" cssClass="form-label">Password</form:label>
							</div>
							<div class="col-7 ">
								<form:password cssClass="form-control" path="password"/>
							</div>
						</div>
						<div class="row ">
							<div class="col-5 m-auto ">
								<form:errors path="password" cssClass="text-danger"/>
							</div>
						</div>
						<div class="row px-4">
							<input type="submit" class="btn btn-dark" value="Signup">
						</div>
						<div class="form-text ps-3 pb-3 text-center ">
							<label>Already have an account? &nbsp;<a href="./">Login</a></label>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>