package fasttrackse.quanlytiendien.UI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlytiendien.DAO.BienLaiDAO;
import fasttrackse.quanlytiendien.DAO.QuanLyTienDienException;
import fasttrackse.quanlytiendien.DAO.ThongKeDAO;
import fasttrackse.quanlytiendien.entity.BienLaiEntity;
import fasttrackse.quanlytiendien.entity.KhachHangEntity;

public class PnBienLaiUI {
	ResultSet rs;
	JComboBox cboMaSoCongTo;
	JTextField txtThang;
	JTextField txtNam;
	JTextField txtChiSo;
	JTextField txtMaBienLai;
	JButton btnUpdate;
	JButton btnDelete;

	public JPanel pnBienLai() {
		BienLaiDAO tienDien = new BienLaiDAO();
		JPanel pnTienDien = new JPanel();
		pnTienDien.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Thông tin biên lai");
		pnTienDien.setBorder(titlebor2);
		pnTienDien.setPreferredSize(new Dimension(1000, 800));
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã biên lai");
		dm.addColumn("Mã khách hàng");
		dm.addColumn("Mã số công tơ");
		dm.addColumn("Thời gian");
		dm.addColumn("Chu kì nhập");
		dm.addColumn("Chỉ số ");
		dm.addColumn("Số tiền");
		final JTable tbl = new JTable(dm);
		tbl.setDefaultEditor(Object.class, null);
		BienLaiDAO connect = new BienLaiDAO();
		rs = connect.connect1();
		ThongKeDAO thongKe = new ThongKeDAO();
		ArrayList<KhachHangEntity> khList = thongKe.taoListKH();

		try {
			while (rs.next()) {
				for (KhachHangEntity kh1 : khList) {
					if (kh1.getMaSoCongTo() == rs.getInt(2)) {
						Calendar cal = Calendar.getInstance();
						cal.setTime(rs.getDate(3));
						int year = cal.get(Calendar.YEAR);
						int month = cal.get(Calendar.MONTH) + 1;
						int day = cal.get(Calendar.DAY_OF_MONTH);
						cal.setTime(rs.getDate(4));
						int nam = cal.get(Calendar.YEAR);
						int thang = cal.get(Calendar.MONTH) + 1;

						String ngayNhap = day + "-" + month + "-" + year;
						String chuKiNhap = thang + "-" + nam;
						dm.addRow(new String[] { rs.getString(1), kh1.getMaKhachHang(), rs.getString(2), ngayNhap,
								chuKiNhap, rs.getString(5), rs.getString(6) });
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JScrollPane sc = new JScrollPane(tbl);
		pnTienDien.add(sc, BorderLayout.CENTER);
		tbl.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				int row = tbl.getSelectedRow();
				int maCongTo = Integer.parseInt((String) tbl.getValueAt(row, 2));
				String chiSo = (String) tbl.getValueAt(row, 5);
				String date1 = (String) tbl.getValueAt(row, 4);
				String maBienLai = (String) tbl.getValueAt(row, 0);
				txtMaBienLai.setText(maBienLai);
				txtThang.setText(date1.substring(0, 1));
				txtNam.setText(date1.substring(2));
				txtChiSo.setText(chiSo);
				cboMaSoCongTo.setSelectedIndex(maCongTo);
			}
		});
		tbl.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				btnUpdate.setEnabled(true);
				btnDelete.setEnabled(true);
				int row = tbl.getSelectedRow();
				int maCongTo = Integer.parseInt((String) tbl.getValueAt(row, 2));
				String chiSo = (String) tbl.getValueAt(row, 5);
				String date1 = (String) tbl.getValueAt(row, 4);
				String maBienLai = (String) tbl.getValueAt(row, 0);
				txtMaBienLai.setText(maBienLai);
				txtThang.setText(date1.substring(0, 1));
				txtNam.setText(date1.substring(2));
				txtChiSo.setText(chiSo);
				cboMaSoCongTo.setSelectedIndex(maCongTo);
			}

			public void keyPressed(KeyEvent e) {
			}
		});
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		pnTienDien.add(pn, BorderLayout.NORTH);
		JPanel pnBtn = new JPanel();
		pn.add(pnBtn, BorderLayout.NORTH);
		JButton btnAdd = new JButton("Thêm biên lai");
		pnBtn.add(btnAdd);
		btnUpdate = new JButton("Sửa biên lai");
		pnBtn.add(btnUpdate);
		btnDelete = new JButton("Xóa biên lai");
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		pnBtn.add(btnDelete);
		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(4, 2));
		pn1.add(pnText, BorderLayout.CENTER);

		JLabel maCongTo = new JLabel("  Mã công tơ điện:");

		cboMaSoCongTo = new JComboBox();
		cboMaSoCongTo.addItem("Mã số công tơ...");
		cboMaCongTo();
		JLabel maBienLai = new JLabel("  Mã biên lai:");
		pnText.add(maBienLai);
		txtMaBienLai = new JTextField(5);
		pnText.add(txtMaBienLai);
		pnText.add(maCongTo);
		pnText.add(cboMaSoCongTo);

		JLabel chuKi = new JLabel("  Chu kì nhập:");
		pnText.add(chuKi);
		JPanel chuKi1 = new JPanel();
		txtThang = new JTextField(5);
		chuKi1.add(txtThang);
		JLabel command2 = new JLabel("/");
		chuKi1.add(command2);
		txtNam = new JTextField(5);
		chuKi1.add(txtNam);
		pnText.add(chuKi1);
		JLabel chiSo = new JLabel("  Chỉ số công tơ:");
		pnText.add(chiSo);
		txtChiSo = new JTextField(15);
		pnText.add(txtChiSo);
		BienLaiDAO bienLai = new BienLaiDAO();

		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QuanLyTienDienException.chckText(txtMaBienLai.getText());
					QuanLyTienDienException.chckText(txtChiSo.getText());
					QuanLyTienDienException.chckText(txtNam.getText());
					QuanLyTienDienException.chckText(txtThang.getText());
					QuanLyTienDienException.chckComboBox(cboMaSoCongTo.getSelectedIndex());
					int maCongToDien = cboMaSoCongTo.getSelectedIndex();
					int thangCK = Integer.parseInt(txtThang.getText());
					int namCK = Integer.parseInt(txtNam.getText());
					int chiSo = Integer.parseInt(txtChiSo.getText());
					int maBienLai = Integer.parseInt(txtMaBienLai.getText());

					Calendar c = Calendar.getInstance();
					String ngayNhap = BienLaiDAO.showCalendar(c);
					double soTien = tienDien.getTienDien(maCongToDien, chiSo, tienDien.taoBienLaiList());

					QuanLyTienDienException.chckTien(soTien);

					bienLai.insert(maBienLai, maCongToDien, ngayNhap, thangCK, namCK, chiSo, soTien);
					dm.setRowCount(0);
					rs = connect.connect1();
					try {
						while (rs.next()) {
							for (KhachHangEntity kh1 : khList) {
								if (kh1.getMaSoCongTo() == rs.getInt(2)) {
									Calendar cal = Calendar.getInstance();
									cal.setTime(rs.getDate(3));
									int year = cal.get(Calendar.YEAR);
									int month = cal.get(Calendar.MONTH) + 1;
									int day = cal.get(Calendar.DAY_OF_MONTH);
									cal.setTime(rs.getDate(4));
									int nam = cal.get(Calendar.YEAR);
									int thang = cal.get(Calendar.MONTH) + 1;

									String ngayNhap1 = day + "-" + month + "-" + year;
									String chuKiNhap = thang + "-" + nam;
									dm.addRow(new String[] { rs.getString(1), kh1.getMaKhachHang(), rs.getString(2),
											ngayNhap1, chuKiNhap, rs.getString(5), rs.getString(6) });
								}
							}
						}
					} catch (SQLException ex) {

						ex.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				} catch (QuanLyTienDienException ex) {
					JOptionPane.showMessageDialog(null, ex);

				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QuanLyTienDienException.chckText(txtMaBienLai.getText());
					QuanLyTienDienException.chckText(txtChiSo.getText());
					QuanLyTienDienException.chckText(txtNam.getText());
					QuanLyTienDienException.chckText(txtThang.getText());
					QuanLyTienDienException.chckComboBox(cboMaSoCongTo.getSelectedIndex());
					BienLaiDAO bienLai = new BienLaiDAO();
					ArrayList<BienLaiEntity> bienLaiList = bienLai.taoBienLaiList();

					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					int maCongToDien = cboMaSoCongTo.getSelectedIndex();
					int thangCK = Integer.parseInt(txtThang.getText());
					int namCK = Integer.parseInt(txtNam.getText());
					int chiSo = Integer.parseInt(txtChiSo.getText());
					int maBienLai = Integer.parseInt(txtMaBienLai.getText());
					BienLaiDAO tienDien = new BienLaiDAO();
					Calendar c = Calendar.getInstance();
					String ngayNhap = BienLaiDAO.showCalendar(c);
					double soTien = tienDien.updateTienDien(maCongToDien, chiSo, bienLaiList);
					QuanLyTienDienException.chckTien(soTien);
					bienLai.update(maBienLai, maCongToDien, ngayNhap, thangCK, namCK, chiSo, soTien);
					dm.setRowCount(0);
					rs = connect.connect1();
					try {
						while (rs.next()) {
							for (KhachHangEntity kh1 : khList) {
								if (kh1.getMaSoCongTo() == rs.getInt(2)) {
									Calendar cal = Calendar.getInstance();
									cal.setTime(rs.getDate(3));
									int year = cal.get(Calendar.YEAR);
									int month = cal.get(Calendar.MONTH) + 1;
									int day = cal.get(Calendar.DAY_OF_MONTH);
									cal.setTime(rs.getDate(4));
									int nam = cal.get(Calendar.YEAR);
									int thang = cal.get(Calendar.MONTH) + 1;

									String ngayNhap1 = day + "-" + month + "-" + year;
									String chuKiNhap = thang + "-" + nam;
									dm.addRow(new String[] { rs.getString(1), kh1.getMaKhachHang(), rs.getString(2),
											ngayNhap1, chuKiNhap, rs.getString(5), rs.getString(6) });
								}
							}
						}
					} catch (SQLException ex) {

						ex.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				} catch (QuanLyTienDienException ex) {
					JOptionPane.showMessageDialog(null, ex);

				}
			}
		});
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);
				int maBienLai = Integer.parseInt(txtMaBienLai.getText());
				bienLai.delete(maBienLai);
				dm.setRowCount(0);
				rs = connect.connect1();
				try {
					while (rs.next()) {
						for (KhachHangEntity kh1 : khList) {
							if (kh1.getMaSoCongTo() == rs.getInt(2)) {
								Calendar cal = Calendar.getInstance();
								cal.setTime(rs.getDate(3));
								int year = cal.get(Calendar.YEAR);
								int month = cal.get(Calendar.MONTH) + 1;
								int day = cal.get(Calendar.DAY_OF_MONTH);
								cal.setTime(rs.getDate(4));
								int nam = cal.get(Calendar.YEAR);
								int thang = cal.get(Calendar.MONTH) + 1;

								String ngayNhap = day + "-" + month + "-" + year;
								String chuKiNhap = thang + "-" + nam;
								dm.addRow(new String[] { rs.getString(1), kh1.getMaKhachHang(), rs.getString(2),
										ngayNhap, chuKiNhap, rs.getString(5), rs.getString(6) });
							}
						}
					}
				} catch (SQLException ex) {

					ex.printStackTrace();
				}
				tbl.setModel(dm);
				dm.fireTableDataChanged();
				txtMaBienLai.setText("");
				txtNam.setText("");
				txtThang.setText("");
				txtChiSo.setText("");
				cboMaSoCongTo.setSelectedIndex(0);
			}
		});
		return pnTienDien;
	}

	private void cboMaCongTo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("Select * from congtodien");
			while (rs1.next()) {
				cboMaSoCongTo.addItem(rs1.getInt(1));
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
