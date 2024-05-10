package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/fgotA")
public class ForgotAdminServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	IOException{
		
		
		
		String uN = req.getParameter("uname2");
		String uW = req.getParameter("pword");
		System.out.println(uN+" "+uW);
		
		int k = new ForgotAdminDAO().forgot(uN,uW);
		if(k<0)
		{
			req.setAttribute("msg","Invalid Admin Username.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			HttpSession hs=req.getSession();
			hs.setAttribute("msg","Password Change Succesfully.....<br>");
			req.getRequestDispatcher("forgotAdmin.jsp").forward(req, res);
		}
		
	}


}
