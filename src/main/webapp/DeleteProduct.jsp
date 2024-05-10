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
        background-color:#a6f74f;
        margin: 0;
        text-align:center;
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
    0
    
</style>
<body>
<%
	 AdminBean ab = (AdminBean) session.getAttribute("abean"); 
	 ProductBean pb = (ProductBean) request.getAttribute("pbean"); 
	
	out.println(pb);
	out.println("Page belong to Admin :" + ab.getfName() + "<br>");
	%>
	
	<form action="delete" method="get">
		<input type="hidden"   value=<%=pb.getCode()%>><br>
		
		<input type="submit" value="DeleteProduct" />
	</form>
	
	

</body>
</html>