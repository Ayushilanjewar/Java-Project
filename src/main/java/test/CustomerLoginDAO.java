package test;
import java.sql.*;
public class CustomerLoginDAO {
	public CustomerBean cb=null;
	public CustomerBean login(String uN, String pW) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("Select*from Customertab60 where uname=? and pword=?");
			ps.setNString(1, uN);
			ps.setString(2, pW);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				cb=new CustomerBean();
				cb.setuName(rs.getString(1));
				cb.setpWord(rs.getString(2));
				cb.setfName(rs.getString(3));
				cb.setlName(rs.getString(4));
				cb.setAddr(rs.getString(5));
				cb.setmId(rs.getString(6));
				cb.setPhNo(rs.getLong(7));
			
			}
			
		}catch(Exception e) {e.printStackTrace();}
	   return cb;
	}

}
