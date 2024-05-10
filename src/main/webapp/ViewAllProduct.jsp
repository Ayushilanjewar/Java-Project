<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,test.*"%>
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
    .CC{
       text-align:center;
        padding: 10px 20px;
        margin-right:100px
    }
</style>
<body>
<form>
	<%
	ProductBean pb = (ProductBean) request.getAttribute("pbean");
	CustomerBean cb = (CustomerBean) session.getAttribute("cbean");
	ArrayList<ProductBean> al = (ArrayList<ProductBean>) session.getAttribute("alist");
	//ArrayList<CustomerBean> al1 =(ArrayList<CustomerBean>)session.getAttribute("alist");

	out.println("Page Belong To Customer:" + cb.getfName() + "<br>");
	if (al.size() == 0) {
		out.println("Product Not Available....<br>");
	} else {
		Iterator<ProductBean> it = al.iterator();
		while (it.hasNext()) {
			pb = (ProductBean) it.next();
			out.print(pb.getCode() + "&nbsp&nbsp" + pb.getName() + "&nbsp&nbsp" + pb.getPrice() + "&nbsp&nbsp" + pb.getQty()
			+ "&nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp" + "<a href='buy?code=" + pb.getCode() + "'>Buy</a>" + "&nbsp&nbsp" + "<br>");
		}
	}
	%><br><br>
	<a className="CC" href="logout">Logout</a>
</form>
</body>
</html>