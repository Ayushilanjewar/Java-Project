package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/fgotC")
public class ForgotCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	IOException{
		
		
		
		String uN = req.getParameter("uname1");
		String uW = req.getParameter("pword");
		System.out.println(uN+" "+uW);
		
		int k = new ForgotCustomerDAO().forgot(uN,uW);
		if(k<0)
		{
			req.setAttribute("msg","Invalid Customer Username.....<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			HttpSession hs=req.getSession();
			hs.setAttribute("msg","Password Updated Succesfully.....<br>");
			req.getRequestDispatcher("forgotCust.jsp").forward(req, res);
		}
		
	}

}
