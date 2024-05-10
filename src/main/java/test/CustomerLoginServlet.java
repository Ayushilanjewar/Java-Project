package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/custlog")

public class CustomerLoginServlet extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
IOException{
	String uN=req.getParameter("uname");
	String pW=req.getParameter("pword");
	CustomerBean cb=new CustomerLoginDAO().login(uN, pW);
	if(cb==null) {
		req.setAttribute("msg", "Invalid Customer Login Process");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}else {
		HttpSession hs=req.getSession();
		hs.setAttribute("cbean", cb);
		req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
	}
	
}
}
