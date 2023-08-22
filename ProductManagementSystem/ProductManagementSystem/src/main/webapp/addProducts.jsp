<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.nagarro.models.Product"%>
<%@ page import="com.nagarro.controller.AddProduct"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%
if (session.getAttribute("username") == null) {
	response.sendRedirect("./");
}
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
				<form action="addProduct" method="post">
					<div class="fs-5 h5">Please enter product details to add to
						stock</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Title</label>
						</div>
						<div class="col-8">
							<input type="text" name="title" required />
						</div>
					</div>
					<div class="row ">
						<div class="col-3">
							<label class="form-label">Quantity</label>
						</div>
						<div class="col-7 ">
							<input type="number" name="quantity" required />
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Size</label>
						</div>
						<div class="col-8">
							<input type="number" name="size" required />
						</div>
					</div>
					<div class="row py-1">
						<div class="col-3">
							<label class="form-label">Image</label>
						</div>
						<div class="col-5">
							<input type="file" name="image" id="imgUpload" accept="image/*"
								required />
						</div>
						<div class="col-3 py-1 float-end" style="width: 140px;">
							<button type="submit" class=" border-1 rounded-2">Add
								Product</button>
						</div>


					</div>


				</form>
			</div>
		</div>
	</div>
	<div class="container-fluid" style="height: 62vh; overflow-y: scroll;">
		<div class="row p-4">
			<table
				class="table table-bordered border-dark border-2 table-responsive-sm">
				<caption class="text-center">Products Table</caption>
				<thead class="thead-dark ">
					<tr class="text-center border-2 ">
						<th scope="col" class="border-2 ">S.No.</th>
						<th scope="col" class="border-2 ">Title</th>
						<th scope="col" class="border-2 ">Quantity</th>
						<th scope="col" class="border-2 ">Size</th>
						<th scope="col" class="border-2 ">Image</th>
						<th scope="col" class="border-2 ">Actions</th>
					</tr>
				</thead>
				<tbody class="text-center  ">
					<%
					AddProduct pc = new AddProduct();
					List<Product> pr = pc.getAllProduct();
					int count = 1;
					for (Product p : pr) {
					%>

					<tr class="border-2 ">
						<td class="p-5  border-2  "><%=count++%></td>
						<td class="p-5  border-2  "><%=p.getProductTitle()%></td>
						<td class="p-5  border-2 "><%=p.getProductQuantity()%></td>
						<td class="p-5  border-2 "><%=p.getProductSize()%></td>
						<td class="p-5  border-2 "><img
							src="<%=p.getProductImage()%>"
							style="width: 100px; height: 100px;" alt="" /></td>

						<td class="p-5  border-2 ">
							<button class="bg-transparent btn-sm border-0" value="edit"
								onclick="window.location.href='./Products/editProduct?id=<%=p.getProductId()%>'">
								<img
									src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABmJLR0QA/wD/AP+gvaeTAAABC0lEQVRIie3Tv07CQBzA8e+vYXDgXoTCQzAJzoTEaKKP4UZJHPQ9TPzzAIATs5MD1DdwcztH7M9BqRQrPXs3clv7Sz7f9O4K+wVMFzaZLd+vymYSAkcYfWFy3Ws3L4IFHl9sO8t4Bhr5S2Xc75hk/RjVxVVVDltmqcopsMoHwmi6sH6B7z2/m8+1cdQx9yocFyIR+tOrga/3HOXh4K150u3KapLagSi3CJf92IxrBQp4LuiNTc35cCgfs9TGvdikhbEXvhF5apmzRCTbHjmdwU4cEI1ey3Bw+IJKvOTuOwd88Z2BEPifgVB4aSAkDlu3qApHSP6D/wpU4Zt/aL1AYNwt4IFXBzzx/XJanwb6edJPjj7yAAAAAElFTkSuQmCC"
									alt="">
							</button>
							<button class="bg-transparent btn-sm border-0" value="delete"
								onclick="window.location.href='./Products/deleteProduct?id=<%=p.getProductId()%>'">
								<img
									src="https://img.icons8.com/ios-glyphs/30/000000/macos-close.png"
									alt="" />
							</button>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>

</html>