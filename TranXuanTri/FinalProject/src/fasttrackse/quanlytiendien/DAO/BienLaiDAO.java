package fasttrackse.quanlytiendien.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class BienLaiDAO {
	Statement stmt;
	ResultSet rs;
	Connection con;
	int i;
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
	public ResultSet connect1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien","root","");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from bienlai");
			return rs;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
	public void insert(String maBienLai,int maCongToDien, int ngay, int thang, int nam, int thangCK, int namCK, int chiSoCongTo,double soTien) {
		connect();
		try {
			String ngayNhap = nam+"-"+thang+"-"+ngay;
			String chuKiNhap = namCK+"-"+thangCK+"-1";
			stmt.executeUpdate("insert into bienlai values (\""+maBienLai+"\",\""+maCongToDien+"\",\""+ngayNhap+"\",\""+chuKiNhap+"\", \""+chiSoCongTo+"\",\""+soTien+"\")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(String maBienLai,int maCongToDien, int ngay, int thang, int nam, int thangCK, int namCK, int chiSoCongTo,double soTien) {
		connect();
		try {
			String ngayNhap = nam+"-"+thang+"-"+ngay;
			String chuKiNhap = namCK+"-"+thangCK+"-1";
			String query = "UPDATE bienlai SET maCongToDien = '"+maCongToDien+"' ngayNhap='"+ngayNhap+"',chuKiNhap='"+chuKiNhap+"',chiSoCongTo='"+chiSoCongTo+"',soTien = '"+soTien+"' WHERE maBienLai = '"+maBienLai+"'";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getDay() {
		connect();
		Date date;
		try {
			while (rs.next()) {
				date = rs.getDate(3);
				// System.out.println(rs.getDate(2));
				Calendar cal = Calendar.getInstance();
				cal.setTime(date);
				int year = cal.get(Calendar.YEAR);
				int month = cal.get(Calendar.MONTH) + 1;
				int day = cal.get(Calendar.DAY_OF_MONTH);
//				System.out.println(day);
				return day;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public double tinhTien(String thoiGianMoi, int chiSoMoi) {
		connect();
		try {
		int chiSoCu = 0;
		double soDien = chiSoMoi-chiSoCu;
		if (soDien<=50) {
			return 1.549*(soDien);
		} else if (soDien<=100) {
			return 1.549*50+1.600*(soDien-50);
		} else if (soDien<=200) {
			return 1.549*50 + 1.600*50 + 1.858*(soDien-100);
		} else if (soDien<=300) {
			return 1.549*50 + 1.600*50 + 1.858*100 + 2.340*(soDien-200);
		} else if (soDien<=400) {
			return 1.549*50 + 1.600*50 + 1.858*100 + 2.340*100 + 2.615*(soDien-300);
		} else return 1.549*50 + 1.600*50 + 1.858*100 + 2.340*100 + 2.615*100 + 2.701*(soDien-400);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
