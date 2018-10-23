package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entity.MonHoc;
import entity.QuanHuyen;
import entity.QuanLiLopHoc;
import entity.QuanLiSinhVien;

public class MonHocDAO {
	Statement stmt;
	ResultSet rs;
	Connection con;
ArrayList<MonHoc> arrMonHoc = new ArrayList<>();
ArrayList<MonHoc> arrMonHoc1 = new ArrayList<>();
	public ArrayList<MonHoc> sellectMonHoc(){
		arrMonHoc.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select * from monhoc");
			while(result.next())
			{
				String maMon = result.getString("Mamonhoc");
				String tenMon = result.getString("Tenmon");
				String tinChi = result.getString("Sotinchi");
				String thoiLuong = result.getString("Thoiluonghoc");
				arrMonHoc.add(new MonHoc(maMon, tenMon, tinChi, thoiLuong));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrMonHoc;
	}
	public ArrayList<MonHoc> sellectMonHoc1(String maMonHoc){
		arrMonHoc1.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			String sql = "select * from monhoc where mamonhoc =" + "'"+ maMonHoc +"'";
			//Statement statement=conn.createStatement();
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);

			while(result.next())
			{ String districtId = result.getString("mamonhoc");
				 String name = result.getString("tenmon");
				
				 arrMonHoc1.add(new MonHoc( districtId,name));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrMonHoc1;
	}
		
	}

