package Dao;

import java.util.ArrayList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import entity.QuanHuyen;

public class QuanHuyenDAO {
	ArrayList<QuanHuyen> arrQuanHuyen = new ArrayList<>();
	public ArrayList<QuanHuyen> selectQuanHuyen(String provinceId){
		arrQuanHuyen.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien", "root", "");
			String sql = "select * from devvn_quanhuyen where matp =" + "'"+ provinceId +"'";
			//Statement statement=conn.createStatement();
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);

			while(result.next())
			{
				 String name = result.getString("name");
				 String districtId = result.getString("maqh");
				 arrQuanHuyen.add(new QuanHuyen(name, districtId));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrQuanHuyen;
	}
}
