package test;
import java.sql.*;

public class UpdateProductDAO {
	public int k=0;
	public int update(ProductBean pb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("update product set name=?, price=?,qty=? where code=? ");
			
			ps.setString(1, pb.getName());
			ps.setInt(2, pb.getPrice());
			ps.setInt(3, pb.getQty());
			ps.setString(4, pb.getCode());
			k=ps.executeUpdate();
		}catch(Exception e) {e.printStackTrace();}
		return k;
	}

}
