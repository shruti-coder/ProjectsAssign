<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Management System</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js">
	
</script>
</head>

<body>
	<nav
		class="navbar navbar-expand-lg d-flex justify-content-between navbar-dark bg-dark">
		<div class="m-auto text-light fw-bold  fs-5 ">Factory Outlet</div>
		<div class="login text-light d-flex">
			<!-- <label class="fs-5 p-1 me-3">Welcome, ${user.getUsername()} </label> -->
			<input type="submit" class="btn btn-light me-3" value="Logout" onclick="window.location.href='./logout'" />
		</div>
	</nav>
	<div class="container-fluid ">
		<div class="row py-2">
			<div class="col-md-4 p-4 d-flex justify-content-center">

				<form:form action="getTshirt" modelAttribute="tshirt">
					<div class="text-center fs-5 fw-bold">Please enter Tshirt
						details to Find</div>
					<div class="row py-1">
						<div class="col-4">
							<form:label cssClass="form-label" path="colour">Colour</form:label>
						</div>
						<div class="col-7">
							<form:input cssClass="form-control" path="colour"
								placeholder="Enter Colour" />
						</div>
					</div>
					<div class="row py-1">
						<div class="col-4">
							<form:label cssClass="form-label"  path="size">Size</form:label>
						</div>
						<div class="col-7">
							<form:select cssClass="form-select" path="size">
								<form:option value="NONE" label="Select" />
								<form:options items="${sizeList}" />
							</form:select>
						</div>
					</div>
					<div class="row py-1">
						<div class="col-4">
							<form:label cssClass="form-label"  path="gender">Gender</form:label>
						</div>
						<div class="col-7">
							<form:radiobutton path="gender" value="M" label="Male" />
							<form:radiobutton path="gender" value="F" label="Female" />
						</div>
					</div>
					<div class="row py-1">
						<div class="col-4">
							<label class="form-label" >Output Pref.</label>
						</div>
						<div class="col-7">
							<input class="form-check-input"  type="radio" id="price" name="pref" value="price" checked>
							<label class="form-check-label" for="price">Sort by Price</label> 
<br>							<input class="form-check-input" type="radio" id="rating" name="pref" value="rating"> 
							<label class="form-check-label" for="rating">Sort by Rating</label> 
<br>							<input class="form-check-input" type="radio" id="both" name="pref" value="both"> 
							<label  class="form-check-label" for="both">Sort by Both</label>
						</div>
					</div>
				<div class="row py-1">
					<input type="submit" class="btn btn-dark" value="Search">
				</div>
				</form:form>
			</div>
		</div>
	</div>
	<div class="container-fluid" style="height: 46vh; overflow-y: scroll;">
		<div class="row p-4">
			<table class="table table-striped table-responsive-sm">
				<caption class="text-center">Products Table</caption>
				<thead class="thead-dark">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Color</th>
						<th>Gender</th>
						<th>Size</th>
						<th>Price</th>
						<th>Rating</th>
						<th>Availability</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${!tShirtList.equals('null')}">
						<c:forEach var="tShirt" items="${tShirtList}">
							<tr>
								<td>${tShirt.id}</td>
								<td>${tShirt.name}</td>
								<td>${tShirt.colour}</td>
								<td>${tShirt.gender}</td>
								<td>${tShirt.size}</td>
								<td>${tShirt.price}</td>
								<td>${tShirt.rating}</td>
								<td>${tShirt.availability}</td>
							</tr>
						</c:forEach>
					</c:if>
			</table>
			<c:if test="${tShirtList.equals('null')}">
				<div class="alert alert-warning text-center">NO T-SHIRT AVAILABLE</div>
			</c:if>
		</div>
	</div>
</body>

</html>

