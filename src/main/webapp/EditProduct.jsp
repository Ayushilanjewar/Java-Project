<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="test.*"%>
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
    h1 {
        color: #333;
        text-align: center;
    }
    input[type="text"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
<body>
	<%
	AdminBean ab = (AdminBean) session.getAttribute("abean");
	ProductBean pb = (ProductBean) request.getAttribute("pbean");
	out.println("Page belong to Admin :" + ab.getfName() + "<br>");
	%>

	<form action="update" method="get">
		<input type="hidden" name="code"  value=<%=pb.getCode()%>><br>
		ProductName:<input type="text"  name="pname" value=<%=pb.getName()%>><br>
		ProductPrice:<input type="number"  name="pprice" value=<%=pb.getPrice()%>> <br> 
		ProductQulity:<input type="number"  name="pqty" value=<%=pb.getQty()%>><br> 
		<input type="submit" value="UpdateProduct" />
	</form>
</body>
</html>