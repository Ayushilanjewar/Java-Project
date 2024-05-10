<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="test.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
   
        margin: 0;
        padding: 0;
        background-image: linear-gradient(rgba(0, 0, 0, 0.5),
                       rgba(0, 0, 0, 0.5)),url('shop.jpg'); 
        background-color: black;
        background-size: cover;
        height: 100vh;
        background-position: center; 
        background-repeat: no-repeat;
        text-align:center;
    }
   form{
        background-color: #313136;
        width: 400px;
        margin: 50px auto;
        padding: 20px;
        border-radius: 8px;
        text-align: center;
        
        box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
    }
    
</style>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("abean");
String msg=(String)request.getAttribute("msg");
out.println("Page Belong to Admin:"+ab.getfName()+"<br>");
out.println(msg);
%>
<form>
<a href="product.html">AddProduct</a>
<a href="aview">ViewAllProduct</a>
<a href="logout">Logout?</a>
</form>
</body>
</html>