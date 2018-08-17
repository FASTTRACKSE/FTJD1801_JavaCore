package fasttrackse.quanlytiendien.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import fasttrackse.quanlytiendien.entity.BienLaiEntity;

public class BienLaiDAO {
	Statement stmt;
	ResultSet rs;
	Connection con;
	int i;

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from bienlai");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public ResultSet connect1() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from bienlai");
			return rs;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	public void insert(int maBienLai, int maCongToDien, String ngayNhap, int thangCK, int namCK, int chiSoCongTo,
			double soTien) {
		connect();
		try {
			String chuKiNhap = namCK + "-" + thangCK + "-1";
			stmt.executeUpdate("insert into bienlai values (\"" + maBienLai + "\",\"" + maCongToDien + "\",\""
					+ ngayNhap + "\",\"" + chuKiNhap + "\", \"" + chiSoCongTo + "\",\"" + soTien + "\")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int maBienLai, int maCongToDien, String ngayNhap, int thangCK, int namCK, int chiSoCongTo,
			double soTien) {
		connect();
		try {
			String chuKiNhap = namCK + "-" + thangCK + "-1";
			String query = "UPDATE bienlai SET maCongToDien = '" + maCongToDien + "' ngayNhap='" + ngayNhap
					+ "',chuKiNhap='" + chuKiNhap + "',chiSoCongTo='" + chiSoCongTo + "',soTien = '" + soTien
					+ "' WHERE maBienLai = '" + maBienLai + "'";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int maBienLai) {
		connect();
		try {
			String query = "DELETE FROM bienlai WHERE maBienLai = " + maBienLai + "";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String showCalendar(Calendar calendar) {
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return year + "-" + (month + 1) + "-" + day;
	}

	public double tinhTien(double soDien) {
		if (soDien <= 50) {
			return 1.549 * (soDien);
		} else if (soDien <= 100) {
			return 1.549 * 50 + 1.600 * (soDien - 50);
		} else if (soDien <= 200) {
			return 1.549 * 50 + 1.600 * 50 + 1.858 * (soDien - 100);
		} else if (soDien <= 300) {
			return 1.549 * 50 + 1.600 * 50 + 1.858 * 100 + 2.340 * (soDien - 200);
		} else if (soDien <= 400) {
			return 1.549 * 50 + 1.600 * 50 + 1.858 * 100 + 2.340 * 100 + 2.615 * (soDien - 300);
		} else
			return 1.549 * 50 + 1.600 * 50 + 1.858 * 100 + 2.340 * 100 + 2.615 * 100 + 2.701 * (soDien - 400);
	}

	public double getTienDien(int maCongTo, int chiSo) {
		ArrayList<BienLaiEntity> bienLaiList = taoBienLaiList();

		Collections.sort(bienLaiList, new Comparator<BienLaiEntity>() {
			public int compare(BienLaiEntity sv1, BienLaiEntity sv2) {
				if (sv1.getChiSoCongTo() > sv2.getChiSoCongTo()) {
					return -1;
				} else if (sv1.getChiSoCongTo() > sv2.getChiSoCongTo()) {
					return 0;
				} else
					return 1;
			}
		});

		for (BienLaiEntity bl : bienLaiList) {
			if (bl.getMaSoCongToDien() == maCongTo) {
				if (bl.getChiSoCongTo() < chiSo) {
					return tinhTien(chiSo - bl.getChiSoCongTo());
				}
			}
		}
		return tinhTien(chiSo - 0);
	}

	public ArrayList<BienLaiEntity> taoBienLaiList() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("Select * from bienlai");
			ArrayList<BienLaiEntity> bienLaiList = new ArrayList<BienLaiEntity>();
			while (rs1.next()) {
				BienLaiEntity bienLai = new BienLaiEntity();
				bienLai.setChiSoCongTo(rs1.getInt(5));
				bienLai.setMaSoCongToDien(rs1.getInt(2));
				bienLai.setNgayNhap(rs1.getDate(3));
				bienLai.setChuKiNhap(rs1.getDate(4));
				bienLai.setMaBienLai(rs1.getInt(1));
				bienLai.setTienDien(rs1.getDouble(6));
				bienLaiList.add(bienLai);
			}
			return bienLaiList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
