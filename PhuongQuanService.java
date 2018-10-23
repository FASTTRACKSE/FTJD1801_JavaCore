package service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import object.Item;
import ui.QuanLyKhachHangUi;

public class PhuongQuanService extends Connect {
	ResultSet rs = null;
	Statement stmt;

	public PhuongQuanService() {
		try {
			stmt = con.createStatement();
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	public List<Item> getQuanList() {
		// TODO Auto-generated method stub
		List<Item> myListQuan = new ArrayList<Item>();
		try {
			rs = stmt.executeQuery("SELECT DISTINCT idDistrict, District from diachi where idProvince = 48");
			while (rs.next()) {
				
				myListQuan.add(new Item(rs.getInt("idDistrict"), rs.getString("District")));
				
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return myListQuan;
	}

	public List<Item> getPhuongList(int idDistrict) {
		// TODO Auto-generated method stub
		List<Item> myListPhuong = new ArrayList<Item>();
		try {
			rs = stmt.executeQuery("SELECT DISTINCT idCommune, Commune from diachi where idDistrict = "+ idDistrict );
			

			while (rs.next()) {
				myListPhuong.add(new Item(rs.getInt("idCommune"), rs.getString("Commune")));
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return myListPhuong;
	}

}
