package fasttrackse.quanlytiendien.DAO;

import java.sql.*;
import java.util.ArrayList;

import fasttrackse.quanlytiendien.entity.BienLaiEntity;
import fasttrackse.quanlytiendien.entity.KhachHangEntity;

public class ThongKeDAO {
	public ArrayList<KhachHangEntity> taoListKH() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from khachhang");
		ArrayList<KhachHangEntity> khachHangList = new ArrayList<KhachHangEntity>();
		while (rs.next()) {
			KhachHangEntity khachHang = new KhachHangEntity();
			khachHang.setMaKhachHang(rs.getString(1));
			khachHang.setHoTen(rs.getString(2));
			khachHang.setDiaChi(rs.getString(3));
			khachHang.setPhuong(rs.getInt(4));
			khachHang.setQuan(rs.getInt(5));
			khachHang.setDienThoai(rs.getString(6));
			khachHang.setEmail(rs.getString(7));
			khachHang.setMaSoCongTo(rs.getInt(8));
			khachHangList.add(khachHang);
		}
		return khachHangList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public ArrayList<BienLaiEntity> taoListBL() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from bienlai");
			ArrayList<BienLaiEntity> bienLaiList = new ArrayList<BienLaiEntity>();
			while (rs.next()) {
				BienLaiEntity bienLai = new BienLaiEntity();
				bienLai.setChiSoCongTo(rs.getInt(5));
				bienLai.setMaSoCongToDien(rs.getInt(2));
				bienLai.setNgayNhap(rs.getDate(3));
				bienLai.setChuKiNhap(rs.getDate(4));
				bienLai.setMaBienLai(rs.getInt(1));
				bienLai.setTienDien(rs.getDouble(6));
				bienLaiList.add(bienLai);
			}
			return bienLaiList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
