package test;
import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/update")
public class UpdateProductSevlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,
	IOException{
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg", "Session Expired...<br>");
			req.getRequestDispatcher("Msg.jsp").forward(req, res);
		}else {
			String Code=req.getParameter("code");
			String Name=req.getParameter("pname");
			int Price= Integer.parseInt(req.getParameter("pprice"));
			int Qty= Integer.parseInt(req.getParameter("pqty"));
			
			
			System.out.println(Code+" "+Name+" "+Price+" "+Qty);
			
	   ArrayList<ProductBean> al =(ArrayList<ProductBean>)hs.getAttribute("alist");
					Iterator<ProductBean> it = al.iterator();
			        while(it.hasNext()) {
			        	ProductBean pb=(ProductBean)it.next();
			        	if(Code.equals(pb.getCode())) {
			        		
			        		pb.setName(Name);
			        		pb.setPrice(Price);
			        		pb.setQty(Qty);
			        		int k=new UpdateProductDAO().update(pb);
			        		if(k>0) {
			        			System.out.println(k);
			        			req.setAttribute("msg", "Product Updated Successfully...<br>");
			        		}
			        		break;
			        		
			        	}
			        }
			           req.getRequestDispatcher("UpdateProduct.jsp").forward(req,res) ;
		}
		
	}

}
