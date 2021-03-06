package fasttrackse.quanlytiendien.ui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlytiendien.dao.BienLaiDAO;
import fasttrackse.quanlytiendien.dao.QuanLyTienDienException;
import fasttrackse.quanlytiendien.dao.ThongKeDAO;
import fasttrackse.quanlytiendien.entity.BienLaiEntity;
import fasttrackse.quanlytiendien.entity.KhachHangEntity;

public class PnBienLaiUI {
	Connection con;
	Statement stmt;
	ResultSet rs;
	JComboBox cboMaSoCongTo;
	JTextField txtThang;
	JTextField txtNam;
	JTextField txtChiSo;
	JTextField txtMaBienLai;
	JButton btnUpdate;
	JButton btnDelete;
	ArrayList<BienLaiEntity> bienLaiList;

	public JPanel pnBienLai() {
		BienLaiDAO bienLai = new BienLaiDAO();
		bienLaiList = bienLai.taoBienLaiList();
		Color orange = Color.decode("#683f07");
		BienLaiDAO tienDien = new BienLaiDAO();
		JPanel pnTienDien = new JPanel();
		pnTienDien.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Thông tin biên lai");
		titlebor2.setTitleColor(orange);
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
				int max1 = 0;
				int row = tbl.getSelectedRow();
				int maCongTo = Integer.parseInt((String) tbl.getValueAt(row, 2));
				int chiSo1 = Integer.parseInt((String) tbl.getValueAt(row, 5));
				ArrayList<BienLaiEntity> bienLaiList = bienLai.taoBienLaiList();
				for (int i = 0; i < bienLaiList.size(); i++) {
					if (bienLaiList.get(i).getMaSoCongToDien() == maCongTo) {
						if (i == 0) {
							max1 = bienLaiList.get(i).getChiSoCongTo();
						} else if (bienLaiList.get(i).getChiSoCongTo() > max1) {
							max1 = bienLaiList.get(i).getChiSoCongTo();
						}
					}
				}
				if (chiSo1 == max1) {
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					cboMaSoCongTo.setEnabled(false);
					String chiSo = (String) tbl.getValueAt(row, 5);
					String date1 = (String) tbl.getValueAt(row, 4);
					String maBienLai = (String) tbl.getValueAt(row, 0);
					txtMaBienLai.setText(maBienLai);
					for (String retval : date1.split("-")) {
						if (retval.length() <= 2) {
							txtThang.setText(retval);
						} else if (retval.length() == 4) {
							txtNam.setText(retval);
						}
					}

					txtChiSo.setText(chiSo);
					cboMaSoCongTo.setSelectedIndex(maCongTo);
				} else {
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					cboMaSoCongTo.setEnabled(true);
					txtMaBienLai.setText("");
					txtNam.setText("");
					txtThang.setText("");
					txtChiSo.setText("");
					cboMaSoCongTo.setSelectedIndex(0);
				}
			}
		});
		tbl.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				int max1 = 0;
				int row = tbl.getSelectedRow();
				int maCongTo = Integer.parseInt((String) tbl.getValueAt(row, 2));
				int chiSo1 = Integer.parseInt((String) tbl.getValueAt(row, 5));
				ArrayList<BienLaiEntity> bienLaiList = bienLai.taoBienLaiList();
				for (int i = 0; i < bienLaiList.size(); i++) {
					if (bienLaiList.get(i).getMaSoCongToDien() == maCongTo) {
						if (i == 0) {
							max1 = bienLaiList.get(i).getChiSoCongTo();
						} else if (bienLaiList.get(i).getChiSoCongTo() > max1) {
							max1 = bienLaiList.get(i).getChiSoCongTo();
						}
					}
				}
				if (chiSo1 == max1) {
					btnUpdate.setEnabled(true);
					btnDelete.setEnabled(true);
					cboMaSoCongTo.setEnabled(false);
					String chiSo = (String) tbl.getValueAt(row, 5);
					String date1 = (String) tbl.getValueAt(row, 4);
					String maBienLai = (String) tbl.getValueAt(row, 0);
					txtMaBienLai.setText(maBienLai);
					for (String retval : date1.split("-")) {
						if (retval.length() <= 2) {
							txtThang.setText(retval);
						} else if (retval.length() == 4) {
							txtNam.setText(retval);
						}
					}

					txtChiSo.setText(chiSo);
					cboMaSoCongTo.setSelectedIndex(maCongTo);
				} else {
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);
					cboMaSoCongTo.setEnabled(true);
					txtMaBienLai.setText("");
					txtNam.setText("");
					txtThang.setText("");
					txtChiSo.setText("");
					cboMaSoCongTo.setSelectedIndex(0);
				}

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
		JButton btnReset = new JButton("Reset");
		btnUpdate.setEnabled(false);
		btnDelete.setEnabled(false);
		pnBtn.add(btnDelete);
		pnBtn.add(btnReset);
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
		txtMaBienLai.setEnabled(false);
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

		btnAdd.setForeground(orange);
		btnDelete.setForeground(orange);
		btnUpdate.setForeground(orange);

		btnAdd.setFont(new Font(null, Font.BOLD, 13));
		btnDelete.setFont(new Font(null, Font.BOLD, 13));
		btnUpdate.setFont(new Font(null, Font.BOLD, 13));

		btnAdd.setPreferredSize(new Dimension(200, 30));
		btnDelete.setPreferredSize(new Dimension(200, 30));
		btnUpdate.setPreferredSize(new Dimension(200, 30));
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cboMaSoCongTo.removeAllItems();
				cboMaSoCongTo.addItem("Mã số công tơ...");
				cboMaCongTo();
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ArrayList<BienLaiEntity> bienLaiList = tienDien.taoBienLaiList();
					QuanLyTienDienException.chckText(txtChiSo.getText());
					QuanLyTienDienException.chckText(txtNam.getText());
					QuanLyTienDienException.chckText(txtThang.getText());
					QuanLyTienDienException.chckComboBox(cboMaSoCongTo.getSelectedIndex());
					int maCongToDien = cboMaSoCongTo.getSelectedIndex();
					int thangCK = Integer.parseInt(txtThang.getText());
					int namCK = Integer.parseInt(txtNam.getText());
					int chiSo = Integer.parseInt(txtChiSo.getText());
					int count;
					if (bienLaiList.isEmpty() == true) {
						count = 0;
					} else {
						Collections.sort(bienLaiList, new Comparator<BienLaiEntity>() {
							public int compare(BienLaiEntity sv1, BienLaiEntity sv2) {
								if (sv1.getMaBienLai() > sv2.getMaBienLai()) {
									return -1;
								} else if (sv1.getMaBienLai() > sv2.getMaBienLai()) {
									return 0;
								} else
									return 1;
							}
						});
						count = bienLaiList.get(0).getMaBienLai();
					}
					int maBienLai = ++count;

					Calendar c = Calendar.getInstance();
					String ngayNhap = BienLaiDAO.showCalendar(c);
					double soTien = tienDien.getTienDien(maCongToDien, chiSo, bienLaiList);

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
					txtMaBienLai.setText("");
					txtNam.setText("");
					txtThang.setText("");
					txtChiSo.setText("");
					cboMaSoCongTo.setSelectedIndex(0);
				} catch (QuanLyTienDienException ex) {
					JOptionPane.showMessageDialog(null, ex);

				}
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					QuanLyTienDienException.chckText(txtChiSo.getText());
					QuanLyTienDienException.chckText(txtNam.getText());
					QuanLyTienDienException.chckText(txtThang.getText());
					QuanLyTienDienException.chckComboBox(cboMaSoCongTo.getSelectedIndex());
					BienLaiDAO bienLai = new BienLaiDAO();
					ArrayList<BienLaiEntity> bienLaiList = bienLai.taoBienLaiList();
					btnUpdate.setEnabled(false);
					btnDelete.setEnabled(false);

					cboMaSoCongTo.setEnabled(true);

					int maCongToDien = cboMaSoCongTo.getSelectedIndex();
					int thangCK = Integer.parseInt(txtThang.getText());
					int namCK = Integer.parseInt(txtNam.getText());
					int chiSo = Integer.parseInt(txtChiSo.getText());
					int maBienLai = Integer.parseInt(txtMaBienLai.getText());
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

				} catch (QuanLyTienDienException ex) {
					JOptionPane.showMessageDialog(null, ex);

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
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnUpdate.setEnabled(false);
				btnDelete.setEnabled(false);
				cboMaSoCongTo.setEnabled(true);
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
		ThongKeDAO kh = new ThongKeDAO();
		ArrayList<KhachHangEntity> khList = kh.taoListKH();
		int tam = 0;
		for (KhachHangEntity kh1 : khList) {
			if (tam != kh1.getMaSoCongTo()) {
				cboMaSoCongTo.addItem(kh1.getMaSoCongTo());
				tam = kh1.getMaSoCongTo();
			}
		}
		// connect();
		// try {
		// while (rs.next()) {
		// cboMaSoCongTo.addItem(rs.getInt(1));
		// }
		// } catch (Exception e) {
		//
		// }
	}

	private void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("select * from khachhang");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
