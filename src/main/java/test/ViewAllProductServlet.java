package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/view")

public class ViewAllProductServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session Expired...<br>");
		    req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			ArrayList<ProductBean> al=new ViewAllProductDAO().retrieve();
			//ArryList<CustomerBean> al2=new 
			hs.setAttribute("alist", al);
			req.getRequestDispatcher("ViewAllProduct.jsp").forward(req,res);
		}
}
}