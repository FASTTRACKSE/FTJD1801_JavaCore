package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class KhoaHocDAO {
	Statement stmt;
	ResultSet rs;
	Connection con;
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8","root","");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from khoa");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void insert(String maKhoa1,String tenKhoa1) {
		connect();
		
		try {
		stmt.executeUpdate(
				"insert into khoa values (\"" + maKhoa1 + "\",\"" + tenKhoa1 + "\")");
		JOptionPane.showMessageDialog(null, "Them thanh cong!!!");
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
