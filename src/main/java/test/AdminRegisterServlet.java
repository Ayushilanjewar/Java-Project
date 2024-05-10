package test;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
 import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/areg")
public class AdminRegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	IOException{
		AdminBean ab= new AdminBean();
		ab.setuName(req.getParameter("uname"));
		ab.setpWord(req.getParameter("pword"));
		ab.setfName(req.getParameter("fname"));
		ab.setlName(req.getParameter("lname"));
		ab.setAddr(req.getParameter("addr"));
		ab.setmId(req.getParameter("mid"));
		ab.setPhNo(Long.parseLong(req.getParameter("phno")));
		int k=new AdminRegisterDAO().adminRegister(ab);
		if(k>0) {
			req.setAttribute("msg", "Admin Registered Successfully...<br>");
			req.getRequestDispatcher("AdminRegSuccess.jsp").forward(req, res);
		}
		

}
}


