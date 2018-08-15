package fasttrackse.quanlytiendien.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PhuongEntity {
	private int maPhuong;
	private int maQuan;
	private String tenPhuong;
	public int getMaPhuong() {
		return maPhuong;
	}
	public void setMaPhuong(int maPhuong) {
		this.maPhuong = maPhuong;
	}
	public int getMaQuan() {
		return maQuan;
	}
	public void setMaQuan(int maQuan) {
		this.maQuan = maQuan;
	}
	public String getTenPhuong() {
		return tenPhuong;
	}
	public void setTenPhuong(String tenPhuong) {
		this.tenPhuong = tenPhuong;
	}
	public ArrayList<PhuongEntity> phuong() {
		try {
			ArrayList<PhuongEntity> phuongList = new ArrayList<PhuongEntity>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien","root","");
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("Select * from devvn_xaphuongthitran");
			while (rs1.next()) {
					PhuongEntity phuong = new PhuongEntity();
					phuong.setMaPhuong(rs1.getInt(1));
					phuong.setTenPhuong(rs1.getString(2));
					phuong.setMaQuan(rs1.getInt(4));
					phuongList.add(phuong);
			}
			con.close();
			return phuongList;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
}
