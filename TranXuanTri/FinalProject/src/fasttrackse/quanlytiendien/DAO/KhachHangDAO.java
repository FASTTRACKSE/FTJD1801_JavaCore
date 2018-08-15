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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien","root","");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from khachhang");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	public void insert(String maKhachHang,String hoTen,String diaChi, int idPhuong,int idQuan,String dienThoai, String email, int maSoCongTo) {
		connect();
		try {
//			KhachHangEntity kh = new KhachHangEntity();
//			kh.setMaKhachHang(maKhachHang);
//			kh.setHoTen(hoTen);
//			kh.setDiaChi(diaChi);
//			kh.setQuan(idQuan);
//			kh.setPhuong(idPhuong);
//			kh.setEmail(email);
//			kh.setMaSoCongTo(maSoCongTo);
			stmt.executeUpdate("insert into khachhang values (\""+maKhachHang+"\",\""+hoTen+"\",\""+diaChi+"\", "
															+ "\""+idPhuong+"\",\""+idQuan+"\",\""+dienThoai+"\",\""+email+"\",\""+maSoCongTo+"\")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void update(String maKhachHang,String hoTen,String diaChi, int idPhuong,int idQuan,String dienThoai, String email, int maCongToDien) {
		connect();
		try {
			String query = "UPDATE khachhang SET hoTen='" + hoTen + "', diaChi='"+diaChi+"',idphuong='"+idPhuong+"',idquan='"+idQuan+"',dienThoai='"+dienThoai+"',email='"+email+"',maCongToDien='"+maCongToDien+"' WHERE maKhachHang = '"+maKhachHang+"'";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
	public void delete(String maKhachHang) {
		connect();
		try {
			String query = "DELETE FROM khachhang WHERE maKhachHang = "+maKhachHang+"";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
