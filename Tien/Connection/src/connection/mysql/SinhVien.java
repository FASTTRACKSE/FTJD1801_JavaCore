package connection.mysql;

import java.sql.*;

public class SinhVien {
	private String id;
	private String hoTen;	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/QuanLySinhVien","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from SinhVien");
			rs.next();
			System.out.println(rs.getString(1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}		
			
	}
}
