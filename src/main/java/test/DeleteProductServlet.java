package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,
	IOException{
		
		
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			
				req.setAttribute("msg", "Session Expired...<br>");
				req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String Code=req.getParameter("code");
			
			
			DeleteProductDAO do1=new DeleteProductDAO();
			int k=do1.delete(Code);
			if(k>0) {
        			req.setAttribute("msg", "Product Delete Successfully...<br>");
        			req.getRequestDispatcher("AddProduct.jsp").forward(req, res); 
        			
        			
			}
  	
           }
            
        		
        	    }
	
	
	

	}
