package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.TinhThanh;

public class TinhThanhDAO {
ArrayList<TinhThanh> arrTinhThanh = new ArrayList<>();
	
	public ArrayList<TinhThanh> selectAll() {
		try {Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien", "root", "");
		;
			String sql = "select * from devvn_tinhthanhpho";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while (result.next()) {
				String provinceId = result.getString("matp");
				String name = result.getString("name");
				arrTinhThanh.add(new TinhThanh(provinceId, name));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arrTinhThanh;
	}
}
