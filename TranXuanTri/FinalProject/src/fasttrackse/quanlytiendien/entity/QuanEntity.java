package fasttrackse.quanlytiendien.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class QuanEntity {
	private int maQh;
	private String tenQuan;
	
	
	public int getMaQh() {
		return maQh;
	}

	public void setMaQh(int maQh) {
		this.maQh = maQh;
	}

	public String getTenQuan() {
		return tenQuan;
	}

	public void setTenQuan(String tenQuan) {
		this.tenQuan = tenQuan;
	}

	public ArrayList<QuanEntity> quan() {
		try {
//			QuanEntity quan = new QuanEntity();
			
			ArrayList<QuanEntity> quanList = new ArrayList<QuanEntity>();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien","root","");
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("Select * from devvn_quanhuyen");
			while (rs1.next()) {	
				if (rs1.getInt(4)==48) {
					QuanEntity quan = new QuanEntity();
					quan.setMaQh(rs1.getInt(1));
					quan.setTenQuan(rs1.getString(2));
					quanList.add(quan);
				}
				
			}
			con.close();
			return quanList;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

}
