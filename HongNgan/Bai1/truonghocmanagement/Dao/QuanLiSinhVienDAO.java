package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import entity.QuanHuyen;
import entity.QuanLiSinhVien;
public class QuanLiSinhVienDAO {
	Statement stmt;
	ResultSet rs;
	Connection con;
	ArrayList<QuanLiSinhVien> arrSv = new ArrayList<>();
	ArrayList<QuanLiSinhVien> arr = new ArrayList<>();
	public ArrayList<QuanLiSinhVien> selectAllSv(){
		arrSv.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			Statement statement = conn.createStatement();
			ResultSet result=statement.executeQuery("select * from hososinhvien");
			while(result.next())
			{
				String maSV = result.getString("Masv");
				String hoTen = result.getString("Hoten");
				String diachi = result.getString("Diachi");
				String phuong = result.getString("Phuong");
				String quanHuyen = result.getString("Quanhuyen");
				String tinhThanh = result.getString("Tinhthanh");
				String dienThoai = result.getString("Dienthoai");
				String email = result.getString("Email");
				String maLop = result.getString("Malop");
				arrSv.add(new QuanLiSinhVien(maSV, hoTen, diachi, phuong, quanHuyen, tinhThanh, dienThoai, email, maLop));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arrSv;
	}
	
	public ArrayList<QuanLiSinhVien> selectAll(String maLop){
		arr.clear();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			String sql = "select * from hososinhvien where malop ="+"'"+maLop+ "'";
			//Statement statement=conn.createStatement();
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sql);

			while(result.next())
			{ String name = result.getString("hoten");
				 String districtId = result.getString("masv");
				 arr.add(new QuanLiSinhVien( districtId,name));
			}
			} catch (Exception e) {
			e.printStackTrace();
			}
		return arr;
	}

	

	
	
	}
	
