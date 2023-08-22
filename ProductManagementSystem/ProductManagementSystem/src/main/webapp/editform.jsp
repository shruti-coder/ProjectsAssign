<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.nagarro.models.Product"%>
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("../");
}
%>

<%
Product pr = (Product) session.getAttribute("editProductDetail");
%>
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
		class="navbar navbar-expand-lg d-flex justify-content-around navbar-light bg-light">

		<div class="m-auto text-dark fw-bold  fs-5  ps-5 ">Product
			Management Tool</div>
		<div class="login text-dark  d-flex">
			<label class=" p-1 me-3"> Hi, <%=session.getAttribute("username")%>
			</label>
			<button type="submit" class="me-4 p-0 pe-3 ps-3 border-1 rounded-2"
				onclick="window.location.href='./logout'">logout</button>
		</div>
	</nav>
	<div class="container-fluid ">
		<div class="row py-2">

			<div class="col-12 p-3 me-4 d-flex ">
				<form action="updateProduct" method="post">
					<div class="fs-5 h5">Please enter product details to add to
						stock</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Title</label>
						</div>
						<div class="col-8">
							<input type="text" value="<%= pr.getProductTitle() %>" name="title" required />
						</div>
					</div>
					<div class="row ">
						<div class="col-3">
							<label class="form-label">Quantity</label>
						</div>
						<div class="col-7 ">
							<input type="number" value="<%= pr.getProductQuantity() %>"name="quantity" required />
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Size</label>
						</div>
						<div class="col-8">
							<input type="number"value="<%= pr.getProductSize() %>" name="size" required />
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Image</label>
						</div>
						<div class="col-5">
							<input type="file" name="image"value="<%= pr.getProductImage()%>" id="imgUpload" accept="image/*"
								size="11" required />
						</div>
					</div>
					<div class="row py-1">
						<div class="col-4">
							<input type="submit" value="Save Product">
						</div>
						<div class="col-2">
							<input type="submit" onclick="window.location.href='../'"
								value="Cancel">
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>
