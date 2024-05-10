package test;

import java.sql.*;

public class ForgotAdminDAO {
	int k=0;
	public AdminBean ab=null;
	public  int forgot(String uN,String uW) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select pword  from AdminTab60 where uname=? ");
			     ps.setString(1, uN);
			    ResultSet rs=ps.executeQuery();
			    if(rs.next()) {
			    ab=new AdminBean();
			    ab.setpWord(rs.getString(1));
			    //cb.setpWord(rs.getString(2));
			 
			    
			    k=reset(uN,uW);
			    }  
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}
	int x;
	public int reset(String uN,String pW) {
		try {
			Connection con = DBConnection.getCon();
   		 PreparedStatement ps = con.prepareStatement
   				 ("Update AdminTab60 set pword=? where uname=?");
   		 ps.setString(1, pW);
   		 ps.setString(2, uN);
   		x = ps.executeUpdate();
   		

		}catch(Exception e) {e.printStackTrace();}
		return x;
	

}}
