package test;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","Session Expired...<br>");
		}else {
			hs.removeAttribute("cbean");
			hs.removeAttribute("alist");
			hs.invalidate();
			req.setAttribute("msg", "Logged Successfully...<br>");
		}
		req.getRequestDispatcher("Msg.jsp").forward(req, res);
		
	}
 
}
