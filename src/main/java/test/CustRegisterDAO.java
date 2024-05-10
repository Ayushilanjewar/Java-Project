package test;
import java.sql.*;
public class CustRegisterDAO {
	public int k=0;
	public int custRegister(CustomerBean cb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("insert into Customertab60 values(?,?,?,?,?,?,?)");
			ps.setString(1,cb.getuName());
			ps.setString(2,cb.getpWord());
			ps.setString(3,cb.getfName());
			ps.setString(4,cb.getlName());
			ps.setString(5,cb.getAddr());
			ps.setString(6,cb.getmId());
			ps.setLong(7,cb.getPhNo());
			k=ps.executeUpdate();
			//ps.setString(1,cb.getuName());
			
			
			
		}catch(Exception e) {e.printStackTrace();
		return -1;
		}
		
		return k;
	}

}
