package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;

public class TriggerSoSachMuon {
	ResultSet rsBanDoc = null;
	ResultSet rsChiTietMuonTra = null;
	ResultSet rsPhieuMuonTra = null;
	ResultSet rsMaBanDoc = null;
	Statement stmt;
	Connection con;
	Vector<Vector> vecCbb;
	ActionComboBox atnCbb = new ActionComboBox();

	public TriggerSoSachMuon() {
		super();
	}

	public void CapNhatSoSachMuon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rsBanDoc = stmt.executeQuery("select MaBanDoc, SoSachMuon from bandoc");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		try {
			stmt = con.createStatement();
			rsChiTietMuonTra = stmt.executeQuery("select MaGiaoDich, MaSach, TinhTrang from chitietmuontra");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsPhieuMuonTra = stmt.executeQuery("select MaGiaoDich, MaBanDoc, SoLuongMuon, TinhTrang from phieumuontra");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			stmt = con.createStatement();
			rsBanDoc = stmt.executeQuery("select MaBanDoc from phieumuontra");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		try {
			while (rsChiTietMuonTra.next()) {
				JOptionPane.showMessageDialog(null, rsChiTietMuonTra.getString(1));
				rsBanDoc = stmt.executeQuery("select MaBanDoc from phieumuontra where MaGiaoDich = \'"
						+ rsChiTietMuonTra.getString(1) + "\'");
				String mbd = rsBanDoc.getString(1);
				if (rsChiTietMuonTra.getString(3).equals("Đang mượn")) {
					stmt.executeUpdate("update bandoc set SoSachMuon =  SoSachMuon + 1 where MaBanDoc = \'"
							+ mbd + "\'");
				} else if (rsChiTietMuonTra.getString(3).equals("Đã trả")) {
					stmt.executeUpdate("update bandoc set SoSachMuon = SoSachMuon - 1 where MaBanDoc = \'"
							+ mbd + "\'");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
