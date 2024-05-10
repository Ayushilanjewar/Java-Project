package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/buy")
public class BuyProductServlet extends HttpServlet {
	@Override
protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		HttpSession hs = req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Transaction failed..<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
			
		}else {
			String Code = req.getParameter("code");
			ArrayList<ProductBean> al =(ArrayList<ProductBean>)hs.getAttribute("alist");
			Iterator<ProductBean>it=al.iterator();
			while(it.hasNext()) {
				ProductBean pb=(ProductBean)it.next();
				if(Code.equals(pb.getCode())) {
					req.setAttribute("pbean", pb);
					break;
				}
			}
			req.getRequestDispatcher("BuyProduct.jsp").forward(req,res);
			
			
			
		}
	

}
}