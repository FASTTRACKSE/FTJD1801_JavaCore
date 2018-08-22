package fasttrackse.quanlytiendien.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class KhachHangDAO {
	Statement stmt;
	ResultSet rs;
	Connection con;

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/quanlytiendien?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from khachhang");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public void insert(String maKhachHang, String hoTen, String diaChi, int idPhuong, String phuong, int idQuan,
			String quan, String dienThoai, String email, int maSoCongTo) {
		connect();
		try {
			stmt.executeUpdate("insert into khachhang values (\"" + maKhachHang + "\",\"" + hoTen + "\",\"" + diaChi
					+ "\",\"" + idPhuong + "\" ,\"" + phuong + "\",\"" + idQuan + "\",\"" + quan + "\",\"" + dienThoai
					+ "\",\"" + email + "\",\"" + maSoCongTo + "\")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(String maKhachHang, String hoTen, String diaChi, int idPhuong, String phuong, int idQuan,
			String quan, String dienThoai, String email, int maCongToDien) {
		connect();
		try {
			String query = "UPDATE khachhang SET hoTen='" + hoTen + "', diaChi='" + diaChi + "',idphuong='" + idPhuong
					+ "',phuong ='" + phuong + "' ,idquan='" + idQuan + "',quan='" + quan + "',dienThoai='" + dienThoai
					+ "',email='" + email + "',maCongToDien='" + maCongToDien + "' WHERE maKhachHang = '" + maKhachHang
					+ "'";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String maKhachHang) {
		connect();
		try {
			String query = "DELETE FROM khachhang WHERE maKhachHang = " + maKhachHang + "";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
