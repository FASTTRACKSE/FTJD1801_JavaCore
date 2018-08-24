package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelBaoCaoBanHoc extends JPanel {
	ResultSet rs = null;
	ResultSet rsTinhThanh = null;
	ResultSet rsMaBanDoc = null;
	Statement stmt;
	Connection con;
	int i = 0, j = 1, indexOne, indexTwo;
	Vector<Vector> vecCbb;
	Vector<Vector> vecCbb2;
	String maTinhThanh = null;
	String maBanDoc = null;
	ActionComboBox atnCbb = new ActionComboBox();

	public PanelBaoCaoBanHoc() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT MaBanDoc, HoTen, DiaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, SDT, Email, SoSachMuon FROM bandoc as bd, xa_phuong_thitran as xp, quan_huyen_thixa as qh, tinh_thanhpho as tt where xp.MaXaPhuong = bd.MaXaPhuong and qh.MaQuanHuyen = bd.MaQuanHuyen and tt.MaTinhThanh = bd.MaTinhThanh");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			stmt = con.createStatement();
			rsTinhThanh = stmt.executeQuery("select MaTinhThanh, TenTinhThanh from tinh_thanhpho");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsMaBanDoc = stmt.executeQuery("select MaBanDoc, HoTen from bandoc");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JLabel lblType = new JLabel("Tìm theo");
		lblType.setFont(fontOne);
		pnCenter.add(lblType);
		JComboBox cbbType = new JComboBox();
		cbbType.addItem("Tất cả");
		cbbType.addItem("Bạn đọc");
		cbbType.addItem("Thành Phố");
		cbbType.addItem("Theo cả 2");
		cbbType.setFont(fontOne);
		cbbType.setPreferredSize(new Dimension(200, 30));
		pnCenter.add(cbbType);

		JLabel lblValue = new JLabel("Dữ liệu: ");
		pnCenter.add(lblValue);
		lblValue.setFont(fontOne);

		JPanel pnNine = new JPanel();
		pnNine.setLayout(new FlowLayout());
		JLabel lblTinhThanh = new JLabel("Tỉnh thành");
		JComboBox cbbTinhThanh = new JComboBox();
		cbbTinhThanh.setPreferredSize(new Dimension(200, 30));
		lblTinhThanh.setFont(fontOne);
		cbbTinhThanh.setFont(fontOne);
		pnCenter.add(lblTinhThanh);
		pnNine.add(cbbTinhThanh);
		pnCenter.add(pnNine);
		vecCbb = atnCbb.ArrComboBox(rsTinhThanh);
		cbbTinhThanh.addItem("Tất cả");
		for (i = 0; i < vecCbb.get(0).size(); i++) {
			cbbTinhThanh.addItem(vecCbb.get(0).get(i) + " | " + vecCbb.get(1).get(i));
		}

		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblMaBanDoc = new JLabel("Mã bạn đọc");
		JComboBox cbbMaBanDoc = new JComboBox();
		cbbMaBanDoc.setPreferredSize(new Dimension(200, 30));
		lblMaBanDoc.setFont(fontOne);
		cbbMaBanDoc.setFont(fontOne);
		pnCenter.add(lblMaBanDoc);
		pnTen.add(cbbMaBanDoc);
		pnCenter.add(pnTen);
		vecCbb2 = atnCbb.ArrComboBox(rsMaBanDoc);
		for (i = 0; i < vecCbb2.get(0).size(); i++) {
			cbbMaBanDoc.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
		}

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(fontOne);
		pnCenter.add(btnSearch);

		JPanel pnTable = new JPanel();
		pnTable.setLayout(new FlowLayout());
		DefaultTableModel tblBanDoc = new DefaultTableModel();
		tblBanDoc.addColumn("Mã bạn đọc");
		tblBanDoc.addColumn("Họ tên");
		tblBanDoc.addColumn("Địa chỉ");
		tblBanDoc.addColumn("Xã phường");
		tblBanDoc.addColumn("Quận huyện");
		tblBanDoc.addColumn("Tỉnh thành");
		tblBanDoc.addColumn("Số điện thoại");
		tblBanDoc.addColumn("Email");
		tblBanDoc.addColumn("Số sách mượn");

		final JTable tbl = new JTable(tblBanDoc);
		try {
			while (rs.next()) {
				String maBanDoc = rs.getString(1);
				String hoTen = rs.getString(2);
				String diaChi = rs.getString(3);
				String xaPhuong = rs.getString(4);
				String quanHuyen = rs.getString(5);
				String tinhThanh = rs.getString(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
				String soSachMuon = rs.getString(9);
				Vector<String> vec = new Vector<String>();
				vec.add(maBanDoc);
				vec.add(hoTen);
				vec.add(diaChi);
				vec.add(xaPhuong);
				vec.add(quanHuyen);
				vec.add(tinhThanh);
				vec.add(sdt);
				vec.add(email);
				vec.add(soSachMuon);
				tblBanDoc.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		cbbTinhThanh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexOne = cbbTinhThanh.getSelectedIndex() - 1;
				if (indexOne == -1) {
					cbbMaBanDoc.removeAllItems();
					try {
						rsMaBanDoc = stmt.executeQuery(
								"Select MaBanDoc, HoTen from bandoc");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vecCbb2 = atnCbb.ArrComboBox(rsMaBanDoc);
					for (i = 0; i < vecCbb2.get(0).size(); i++) {
						cbbMaBanDoc.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
					}
				}else {
					try {
						maTinhThanh = (String) vecCbb.get(0).get(indexOne);
						cbbMaBanDoc.removeAllItems();
						rsMaBanDoc = stmt.executeQuery(
								"Select MaBanDoc, HoTen from bandoc where MaTinhThanh = \'" + maTinhThanh + "\'");
						vecCbb2 = atnCbb.ArrComboBox(rsMaBanDoc);
						if (vecCbb2.size() <= 0) {
							JOptionPane.showMessageDialog(null, "Thành phố này không có dữ liệu bạn đọc!!!");
						} else {
							for (int i = 0; i < vecCbb2.get(0).size(); i++) {
								cbbMaBanDoc.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
			}
		});
		cbbMaBanDoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (vecCbb.size() <= 0) {
					// TODO Auto-generated method stub
					try {
						rsMaBanDoc = stmt.executeQuery(
								"Select MaBanDoc, HoTen from bandoc where MaTinhThanh = \'" + maTinhThanh + "\'");
						vecCbb2 = atnCbb.ArrComboBox(rsMaBanDoc);
						if (vecCbb2.size() > 0) {
							for (int i = 0; i < vecCbb2.get(0).size(); i++) {
								cbbMaBanDoc.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				}
				indexTwo = cbbMaBanDoc.getSelectedIndex();
				if (indexTwo >= 0) {
					indexTwo = cbbMaBanDoc.getSelectedIndex();
					maBanDoc = (String) vecCbb2.get(0).get(indexTwo);
				}

			}
		});

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách bạn đọc");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 500));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					int index = cbbType.getSelectedIndex();
					if (index == 0) {
						tblBanDoc.setRowCount(0);
						rs = stmt.executeQuery(
								"SELECT MaBanDoc, HoTen, DiaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, SDT, Email, SoSachMuon FROM bandoc as bd, xa_phuong_thitran as xp, quan_huyen_thixa as qh, tinh_thanhpho as tt where xp.MaXaPhuong = bd.MaXaPhuong and qh.MaQuanHuyen = bd.MaQuanHuyen and tt.MaTinhThanh = bd.MaTinhThanh");

						while (rs.next()) {
							String maBanDoc = rs.getString(1);
							String hoTen = rs.getString(2);
							String diaChi = rs.getString(3);
							String xaPhuong = rs.getString(4);
							String quanHuyen = rs.getString(5);
							String tinhThanh = rs.getString(6);
							String sdt = rs.getString(7);
							String email = rs.getString(8);
							String soSachMuon = rs.getString(9);
							Vector<String> vec = new Vector<String>();
							vec.add(maBanDoc);
							vec.add(hoTen);
							vec.add(diaChi);
							vec.add(xaPhuong);
							vec.add(quanHuyen);
							vec.add(tinhThanh);
							vec.add(sdt);
							vec.add(email);
							vec.add(soSachMuon);
							tblBanDoc.addRow(vec);
						}
						tbl.setModel(tblBanDoc);
						tblBanDoc.fireTableDataChanged();
					} else {
						if (index == 1) {
							tblBanDoc.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaBanDoc, HoTen, DiaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, SDT, Email, SoSachMuon FROM bandoc as bd, xa_phuong_thitran as xp, quan_huyen_thixa as qh, tinh_thanhpho as tt where xp.MaXaPhuong = bd.MaXaPhuong and qh.MaQuanHuyen = bd.MaQuanHuyen and tt.MaTinhThanh = bd.MaTinhThanh and bd.MaBanDoc = \'"
											+ maBanDoc + "\'");

							while (rs.next()) {
								String maBanDoc = rs.getString(1);
								String hoTen = rs.getString(2);
								String diaChi = rs.getString(3);
								String xaPhuong = rs.getString(4);
								String quanHuyen = rs.getString(5);
								String tinhThanh = rs.getString(6);
								String sdt = rs.getString(7);
								String email = rs.getString(8);
								String soSachMuon = rs.getString(9);
								Vector<String> vec = new Vector<String>();
								vec.add(maBanDoc);
								vec.add(hoTen);
								vec.add(diaChi);
								vec.add(xaPhuong);
								vec.add(quanHuyen);
								vec.add(tinhThanh);
								vec.add(sdt);
								vec.add(email);
								vec.add(soSachMuon);
								tblBanDoc.addRow(vec);
							}
							tbl.setModel(tblBanDoc);
							tblBanDoc.fireTableDataChanged();

						} else if (index == 2) {
							tblBanDoc.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaBanDoc, HoTen, DiaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, SDT, Email, SoSachMuon FROM bandoc as bd, xa_phuong_thitran as xp, quan_huyen_thixa as qh, tinh_thanhpho as tt where xp.MaXaPhuong = bd.MaXaPhuong and qh.MaQuanHuyen = bd.MaQuanHuyen and tt.MaTinhThanh = bd.MaTinhThanh and bd.MaTinhThanh =  \'"
											+ maTinhThanh + "\'");

							while (rs.next()) {
								String maBanDoc = rs.getString(1);
								String hoTen = rs.getString(2);
								String diaChi = rs.getString(3);
								String xaPhuong = rs.getString(4);
								String quanHuyen = rs.getString(5);
								String tinhThanh = rs.getString(6);
								String sdt = rs.getString(7);
								String email = rs.getString(8);
								String soSachMuon = rs.getString(9);
								Vector<String> vec = new Vector<String>();
								vec.add(maBanDoc);
								vec.add(hoTen);
								vec.add(diaChi);
								vec.add(xaPhuong);
								vec.add(quanHuyen);
								vec.add(tinhThanh);
								vec.add(sdt);
								vec.add(email);
								vec.add(soSachMuon);
								tblBanDoc.addRow(vec);
							}
							tbl.setModel(tblBanDoc);
							tblBanDoc.fireTableDataChanged();
						} else if (index == 3) {
							tblBanDoc.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaBanDoc, HoTen, DiaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, SDT, Email, SoSachMuon FROM bandoc as bd, xa_phuong_thitran as xp, quan_huyen_thixa as qh, tinh_thanhpho as tt where xp.MaXaPhuong = bd.MaXaPhuong and qh.MaQuanHuyen = bd.MaQuanHuyen and tt.MaTinhThanh = bd.MaTinhThanh and bd.MaBanDoc = \'"
											+ maBanDoc + "\' and  bd.MaTinhThanh =  \'" + maTinhThanh + "\'");

							while (rs.next()) {
								String maBanDoc = rs.getString(1);
								String hoTen = rs.getString(2);
								String diaChi = rs.getString(3);
								String xaPhuong = rs.getString(4);
								String quanHuyen = rs.getString(5);
								String tinhThanh = rs.getString(6);
								String sdt = rs.getString(7);
								String email = rs.getString(8);
								String soSachMuon = rs.getString(9);
								Vector<String> vec = new Vector<String>();
								vec.add(maBanDoc);
								vec.add(hoTen);
								vec.add(diaChi);
								vec.add(xaPhuong);
								vec.add(quanHuyen);
								vec.add(tinhThanh);
								vec.add(sdt);
								vec.add(email);
								vec.add(soSachMuon);
								tblBanDoc.addRow(vec);
							}
							tbl.setModel(tblBanDoc);
							tblBanDoc.fireTableDataChanged();
						}
					}
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});

		add(pnCenter);
		add(pnTable);
	}
}
