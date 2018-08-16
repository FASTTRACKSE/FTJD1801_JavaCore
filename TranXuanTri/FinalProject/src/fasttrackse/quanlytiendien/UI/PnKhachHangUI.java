package fasttrackse.quanlytiendien.UI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlytiendien.DAO.KhachHangDAO;
import fasttrackse.quanlytiendien.entity.PhuongEntity;
import fasttrackse.quanlytiendien.entity.QuanEntity;

public class PnKhachHangUI {
	ResultSet rs = null;
	Statement stmt;
	Connection con;
	JComboBox cboQuan = new JComboBox();
	JComboBox cboPhuong = new JComboBox();
	JComboBox cboPhuong1 = new JComboBox();
	JComboBox cboQuan1;
	JComboBox cboMaSoCongTo;
	JTextField txtMaKH;
	JTextField txtHoTen;
	JTextField txtDiaChi;
	JTextField txtDienThoai;
	JTextField txtEmail;

	public JPanel pnKhachHang() {
		JPanel pnTab1 = new JPanel();
		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Thông tin khách hàng");
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(800, 450));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from khachhang");

		} catch (Exception ex) {
			System.out.println(ex);
		}
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã khách hàng");
		dm.addColumn("Họ tên");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Phường");
		dm.addColumn("Quận");
		dm.addColumn("Điện thoại");
		dm.addColumn("Email");
		dm.addColumn("Mã số công tơ điện");
		final JTable tbl = new JTable(dm);
		try {
			while (rs.next()) {
				dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
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
				int row = tbl.getSelectedRow();
				String maKH = (String) tbl.getValueAt(row, 0);
				String hoTen = (String) tbl.getValueAt(row, 1);
				String diaChi = (String) tbl.getValueAt(row, 2);
				String dienThoai = (String) tbl.getValueAt(row, 5);
				String email = (String) tbl.getValueAt(row, 6);
				int maCongTo = Integer.parseInt((String) tbl.getValueAt(row, 7));
				int idQuan = Integer.parseInt((String) tbl.getValueAt(row, 4));
				int idPhuong = Integer.parseInt((String) tbl.getValueAt(row, 3));
				switch (idQuan) {
				case 490:
					cboQuan1.setSelectedIndex(1);
					break;
				case 491:
					cboQuan1.setSelectedIndex(2);
					break;
				case 492:
					cboQuan1.setSelectedIndex(3);
					break;
				case 493:
					cboQuan1.setSelectedIndex(4);
					break;
				case 494:
					cboQuan1.setSelectedIndex(5);
					break;
				case 495:
					cboQuan1.setSelectedIndex(6);
					break;
				case 496:
					cboQuan1.setSelectedIndex(7);
					break;
				case 497:
					cboQuan1.setSelectedIndex(8);
					break;
				case 498:
					cboQuan1.setSelectedIndex(5);
					break;
				}
				txtMaKH.setText(maKH);
				txtHoTen.setText(hoTen);
				txtDiaChi.setText(diaChi);
				txtDienThoai.setText(dienThoai);
				txtEmail.setText(email);
				cboMaSoCongTo.setSelectedIndex(maCongTo);

				for (int i = 0; i < cboPhuong1.getItemCount(); i++) {
					if (((ComboItem) (cboPhuong1.getItemAt(i))).getValue() == idPhuong) {
						cboPhuong1.setSelectedIndex(i);
					}
				}

				// cboPhuong1.setSelectedIndex(idPhuong);
				// cboPhuong1.setSelectedItem(new ComboItem(value, label));
			}
		});
		tbl.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {

				int row = tbl.getSelectedRow();
				String maKH = (String) tbl.getValueAt(row, 0);
				String hoTen = (String) tbl.getValueAt(row, 1);
				String diaChi = (String) tbl.getValueAt(row, 2);
				String dienThoai = (String) tbl.getValueAt(row, 5);
				String email = (String) tbl.getValueAt(row, 6);
				int maCongTo = Integer.parseInt((String) tbl.getValueAt(row, 7));
				int quan = Integer.parseInt((String) tbl.getValueAt(row, 4));
				int phuong = Integer.parseInt((String) tbl.getValueAt(row, 3));
				txtMaKH.setText(maKH);
				txtHoTen.setText(hoTen);
				txtDiaChi.setText(diaChi);
				txtDienThoai.setText(dienThoai);
				txtEmail.setText(email);
				cboMaSoCongTo.setSelectedIndex(maCongTo);
				cboQuan1.setSelectedIndex(quan);
				cboPhuong1.setSelectedIndex(phuong);
			}

			public void keyPressed(KeyEvent e) {
			}
		});
		JScrollPane sc = new JScrollPane(tbl);
		pnTab1.add(sc, BorderLayout.CENTER);
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());

		JPanel pnFilter = new JPanel();
		pn.add(pnFilter, BorderLayout.SOUTH);
		pnFilter.setLayout(new GridLayout(1, 3));
		cboQuan = new JComboBox<String>();
		cboQuan.addItem(new ComboItem(0, "Quận..."));
		cboQuan();
		cboPhuong = new JComboBox<String>();
		cboPhuong.addItem(new ComboItem(0, "Phường..."));

		cboQuan.addItemListener(new CboPhuong());

		pnFilter.add(cboQuan);
		pnFilter.add(cboPhuong);
		JButton btnSearch = new JButton("search");
		pnFilter.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int n = cboQuan.getSelectedIndex();
				if (n == 0) {
					try {
						dm.setRowCount(0);
						String sql = "select * from khachhang";
						rs = stmt.executeQuery(sql);
						while (rs.next()) {
							dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
							tbl.setModel(dm);
							dm.fireTableDataChanged();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else {
					int j = ((ComboItem) cboPhuong.getSelectedItem()).getValue();
					int i = ((ComboItem) cboQuan.getSelectedItem()).getValue();
					try {
						String sql = "select * from khachhang where idquan = '" + i + "'";
						rs = stmt.executeQuery(sql);
						dm.setRowCount(0);
						while (rs.next()) {
							if (rs.getInt(5) == i) {
								if (rs.getInt(4) == j) {
									dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
											rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
											rs.getString(8) });
								}

							}
							tbl.setModel(dm);
							dm.fireTableDataChanged();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		pnTab1.add(pn, BorderLayout.NORTH);

		JPanel pnBtn = new JPanel();
		pn.add(pnBtn, BorderLayout.NORTH);
		JButton btnAdd = new JButton("Thêm khách hàng");
		pnBtn.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String maKhachHang = txtMaKH.getText();
				String hoTen = txtHoTen.getText();
				String diaChi = txtDiaChi.getText();
				ComboItem quan = (ComboItem) cboQuan1.getSelectedItem();
				ComboItem phuong = (ComboItem) cboPhuong1.getSelectedItem();
				int idPhuong = phuong.getValue();
				int idQuan = quan.getValue();
				String dienThoai = txtDienThoai.getText();
				String email = txtEmail.getText();
				int maCongToDien = cboMaSoCongTo.getSelectedIndex();
				KhachHangDAO kh = new KhachHangDAO();
				kh.insert(maKhachHang, hoTen, diaChi, idPhuong, idQuan, dienThoai, email, maCongToDien);
				dm.setRowCount(0);
				ResultSet rs = connect();
				try {
					while (rs.next()) {
						dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
					}
				} catch (SQLException ex) {

					ex.printStackTrace();
				}
				tbl.setModel(dm);
				dm.fireTableDataChanged();
			}
		});
		// btnAdd.setEnabled(true);

		JButton btnEdit = new JButton("Sửa thông tin khách hàng");
		pnBtn.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maKhachHang = txtMaKH.getText();
				String hoTen = txtHoTen.getText();
				String diaChi = txtDiaChi.getText();
				ComboItem quan = (ComboItem) cboQuan1.getSelectedItem();
				ComboItem phuong = (ComboItem) cboPhuong1.getSelectedItem();
				int idPhuong = phuong.getValue();
				int idQuan = quan.getValue();
				String dienThoai = txtDienThoai.getText();
				String email = txtEmail.getText();
				int maCongToDien = cboMaSoCongTo.getSelectedIndex();
				KhachHangDAO kh = new KhachHangDAO();
				kh.update(maKhachHang, hoTen, diaChi, idPhuong, idQuan, dienThoai, email, maCongToDien);
				dm.setRowCount(0);
				ResultSet rs = connect();
				try {
					while (rs.next()) {
						dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
					}
				} catch (SQLException ex) {

					ex.printStackTrace();
				}
				tbl.setModel(dm);
				dm.fireTableDataChanged();
			}
		});

		JButton btnDelete = new JButton("Xóa khách hàng");
		pnBtn.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String maKhachHang = txtMaKH.getText();
				KhachHangDAO kh = new KhachHangDAO();
				kh.delete(maKhachHang);
				dm.setRowCount(0);
				ResultSet rs = connect();
				try {
					while (rs.next()) {
						dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });
					}
				} catch (SQLException ex) {

					ex.printStackTrace();
				}
				tbl.setModel(dm);
				dm.fireTableDataChanged();
			}
		});

		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(8, 2));
		pn1.add(pnText, BorderLayout.CENTER);

		JLabel maKH = new JLabel("  Mã khách hàng");
		pnText.add(maKH);
		txtMaKH = new JTextField(10);
		pnText.add(txtMaKH);

		JLabel hoTen = new JLabel("  Họ tên");
		pnText.add(hoTen);
		txtHoTen = new JTextField(20);
		pnText.add(txtHoTen);

		JLabel diaChi = new JLabel("  Địa chỉ");
		pnText.add(diaChi);
		txtDiaChi = new JTextField(20);
		pnText.add(txtDiaChi);

		JLabel quan = new JLabel("  Quận");
		pnText.add(quan);
		cboQuan1 = new JComboBox<String>();
		cboQuan1.addItem("Quận...");
		cboQuan1();
		pnText.add(cboQuan1);
		cboQuan1.addItemListener(new CboPhuong1());

		JLabel phuong = new JLabel("  Phường");
		pnText.add(phuong);
		cboPhuong1.addItem("Phường...");
		pnText.add(cboPhuong1);

		JLabel dienThoai = new JLabel("  Điện Thoại");
		pnText.add(dienThoai);
		txtDienThoai = new JTextField(20);
		pnText.add(txtDienThoai);

		JLabel email = new JLabel("  Email");
		pnText.add(email);
		txtEmail = new JTextField(20);
		pnText.add(txtEmail);

		JLabel maSoCongTo = new JLabel("  Mã số công tơ");
		pnText.add(maSoCongTo);
		cboMaSoCongTo = new JComboBox();
		cboMaSoCongTo.addItem("Mã số công tơ.....");
		cboMaCongTo();
		pnText.add(cboMaSoCongTo);
		return pnTab1;
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

	private void cboQuan1() {
		QuanEntity quan = new QuanEntity();
		quan.quan();
		for (QuanEntity quan1 : quan.quan()) {
			cboQuan1.addItem(new ComboItem(quan1.getMaQh(), quan1.getTenQuan()));
		}
	}

	private void cboQuan() {
		QuanEntity quan = new QuanEntity();
		quan.quan();
		for (QuanEntity quan1 : quan.quan()) {
			cboQuan.addItem(new ComboItem(quan1.getMaQh(), quan1.getTenQuan()));
		}
	}

	private class CboPhuong implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			int i = cboQuan.getSelectedIndex();
			PhuongEntity phuong = new PhuongEntity();
			switch (i) {
			case 0:
				cboPhuong.removeAllItems();
				cboPhuong.addItem("Phường ....");
				break;
			case 1:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 490) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));

					}
				}
				break;
			case 2:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 491) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 3:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 492) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 4:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 493) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 5:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 494) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 6:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 495) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 7:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 497) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 8:
				cboPhuong.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 498) {
						cboPhuong.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			}
		}
	}

	private class CboPhuong1 implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			int i = cboQuan1.getSelectedIndex();
			PhuongEntity phuong = new PhuongEntity();
			switch (i) {
			case 0:
				cboPhuong1.removeAllItems();
				cboPhuong1.addItem("Phường ....");
				break;
			case 1:
				cboPhuong1.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 490) {
						// cboPhuong1.addItem(phuong1.getTenPhuong());
						cboPhuong1.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 2:
				cboPhuong1.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 491) {
						cboPhuong1.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 3:
				cboPhuong1.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 492) {
						cboPhuong1.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 4:
				cboPhuong1.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 493) {
						cboPhuong1.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 5:
				cboPhuong1.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 494) {
						cboPhuong1.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 6:
				cboPhuong1.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 495) {
						cboPhuong1.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 7:
				cboPhuong1.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 497) {
						cboPhuong1.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			case 8:
				cboPhuong1.removeAllItems();
				for (PhuongEntity phuong1 : phuong.phuong()) {
					if (phuong1.getMaQuan() == 498) {
						cboPhuong1.addItem(new ComboItem(phuong1.getMaPhuong(), phuong1.getTenPhuong()));
					}
				}
				break;
			}
		}

	}

	private ResultSet connect() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from khachhang");
			return rs;
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}

	private class ComboItem {
		private int value;
		private String label;

		public String getLabel() {
			return label;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public int getValue() {
			return this.value;
		}

		public ComboItem(int value, String label) {
			this.value = value;
			this.label = label;
		}

		@Override
		public String toString() {
			return label;
		}
	}
}
