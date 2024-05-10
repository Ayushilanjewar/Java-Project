<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color:#a6f74f;
        margin: 0;
        padding: 0;
    }
    form {
        background-color: #fff;
        width: 400px;
        margin: 50px auto;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }
    h1{
    text-align:center
    }
    
</style>
<body>
<%
String msg=(String)request.getAttribute("msg");
out.println(msg);

%><br><br><br>
<h1>ProductDetails</h1>

<a href="product.html">AddProduct</a><br><br>
<a href="view" >ViewAllProduct</a><br><br>
<a href="logout" >Logout?</a>


</body>
</html>