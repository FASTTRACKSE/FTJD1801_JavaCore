package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.Phuong;

public class PhuongDAO {
ArrayList<Phuong> arrPhuong = new ArrayList<>();
	
	public ArrayList<Phuong> selectPhuong(String districtId){
		arrPhuong.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien", "root", "");
			String sql = "select * from devvn_xaphuongthitran where maqh = '"+districtId+"'";
			//Statement statement=conn.createStatement();
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
//			ps = (PreparedStatement) conn.prepareStatement(sql);
//			ResultSet result=ps.executeQuery();
			while(result.next())
			{
				String namePhuong = result.getString("name");
				 arrPhuong.add(new Phuong(namePhuong));

			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		
		return arrPhuong;
	}
}
