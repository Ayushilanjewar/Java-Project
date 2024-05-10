package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/aview")
public class ViewAllProductAdminServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
		req.setAttribute("msg","Session EXpired...<br>");
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
	}else {
		ArrayList<ProductBean> al=new ViewAllProductAdminDAO().retrieve();
		hs.setAttribute("alist", al);
		req.getRequestDispatcher("ViewAllProductAdmin.jsp").forward(req,res);
	}

}
}