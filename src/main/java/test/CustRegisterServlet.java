package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
 import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/creg")

public class CustRegisterServlet  extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	IOException{
		CustomerBean cb= new CustomerBean();
		cb.setuName(req.getParameter("uname"));
		cb.setpWord(req.getParameter("pword"));
		cb.setfName(req.getParameter("fname"));
		cb.setlName(req.getParameter("lname"));
		cb.setAddr(req.getParameter("addr"));
		cb.setmId(req.getParameter("mid"));
		cb.setPhNo(Long.parseLong(req.getParameter("phno")));
		int k=new CustRegisterDAO().custRegister(cb);
		
		if(k<0) {
			req.setAttribute("msg", "Duplicate Details Found....<br>");
			req.getRequestDispatcher("Msg2.jsp").forward(req, res);
		}
		else if(k>0) {
			req.setAttribute("msg", "Customer Registered Successfully...<br>");
			req.getRequestDispatcher("CustRegSuccess.jsp").forward(req, res);
		}else {
			req.setAttribute("msg", "Failed ...<br>");
			req.getRequestDispatcher("Msg2.jsp").forward(req, res);
		}
		

}
}