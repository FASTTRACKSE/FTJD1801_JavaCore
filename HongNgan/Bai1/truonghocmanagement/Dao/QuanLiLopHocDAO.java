package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.QuanLiLopHoc;
public class QuanLiLopHocDAO {
	ArrayList<QuanLiLopHoc> arrLop = new ArrayList<>();
	int soLuongSinhVien;
	public ArrayList<QuanLiLopHoc> sellectAllLop(){
		arrLop.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			String sql = "select * from lophoc";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);
			while(result.next())
			{
				 String maLop = result.getString("Malop");
				 String tenLop = result.getString("Tenlop");
				 String namHoc = result.getString("Namhoc");
				 arrLop.add(new QuanLiLopHoc(maLop, tenLop, namHoc));
			}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		return arrLop;
	}
	
	
	
}
