<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@page isELIgnored="false" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Vendor</title>
</head>
<body>
<h1>Update Vendor Details</h1>
	<pre>
		<form action="updateVendor" method="POST">
			Id:    <input type="text" name="id" value="${vendor.id}" readonly/>
			<br>
			Code   :  <input type="text" name="code" value="${vendor.code}"/>
			<br>
			Name   :  <input type="text" name="name" value="${vendor.name}"/>
			<br>
			Type   :  <input type="radio" name="type" value="Manufactures" ${vendor.type=='Manufactures' ? 'checked' : ''}/> Manufacturer
			          <input type="radio" name="type" value="Distributors" ${vendor.type=='Distributors' ? 'checked' : ''} /> Distributor
			          <input type="radio" name="type" value="Wholesaler" ${vendor.type=='Wholesaler' ? 'checked' : ''} /> Wholesaler
			          <input type="radio" name="type" value="Retailer" ${vendor.type=='Retailer' ? 'checked' : ''} /> Retailer
			          <input type="radio" name="type" value="Customer" ${vendor.type=='Customer' ? 'checked' : ''} /> Customer
			<br>
			E-Mail :  <input type="text" name="email" value="${vendor.email}"/>
			<br>
			Phone  :  <input type="text" name="phone" value="${vendor.phone}"/>
			<br>
			Address:  <input type="text" name="address" value="${vendor.address}"/>
			<br>
		    <input type="submit"  value="save"/>
		</form>
	</pre>
</body>
</html>