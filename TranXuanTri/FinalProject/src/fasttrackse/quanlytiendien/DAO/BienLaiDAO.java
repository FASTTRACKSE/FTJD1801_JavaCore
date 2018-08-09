package fasttrackse.quanlytiendien.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BienLaiDAO {
	Statement stmt;
	ResultSet rs;
	Connection con;
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien","root","");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from bienlai");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void insert(String maCongToDien, String ngayNhap, String chuKiNhap, String chiSoCongTo) {
		connect();
		try {
			stmt.executeUpdate("insert into bienlai values (\""+maCongToDien+"\",\""+ngayNhap+"\",\""+chuKiNhap+"\", \""+chiSoCongTo+"\")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		
	}
	
}
