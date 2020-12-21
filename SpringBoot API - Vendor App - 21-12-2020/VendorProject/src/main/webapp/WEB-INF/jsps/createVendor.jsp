<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Vendor</title>
</head>
<body>
<pre>
		<form action="createVendor" method="POST"> 
			
			<br>
			Code   :  <input type="text" name="code" />
			<br>
			Name   :  <input type="text" name="name" />
			<br>
			Type   :  <input type="radio" name="type" value="Manufactures" /> Manufacturer
			          <input type="radio" name="type" value="Distributors" /> Distributor
			          <input type="radio" name="type" value="Wholesaler" /> Wholesaler
			          <input type="radio" name="type" value="Retailer" /> Retailer
			          <input type="radio" name="type" value="Customer" /> Customer
			<br>
			E-Mail :  <input type="text" name="email" />
			<br>
			Phone  :  <input type="text" name="phone" />
			<br>
			Address:  <input type="text" name="address" />
			<br>
		    <input type="submit"  value="save"/>
		</form>
	</pre>
	<p>
		${message}
	</p>
	<p>
		<a href="displayVendors">View All</a>
	</p>
</body>
</html>