package fasttrackse.quanlytiendien.ui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlytiendien.dao.KhachHangDAO;
import fasttrackse.quanlytiendien.dao.QuanLyTienDienException;
import fasttrackse.quanlytiendien.entity.ComboItem;
import fasttrackse.quanlytiendien.entity.PhuongEntity;
import fasttrackse.quanlytiendien.entity.QuanEntity;

public class PnKhachHangUI {
	ResultSet rs;
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
	JButton btnEdit;
	JButton btnDelete;

	public JPanel pnKhachHang() {
		Color green = Color.decode("#2c562e");
		JPanel pnTab1 = new JPanel();
		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Thông tin khách hàng");
		titlebor2.setTitleColor(green);
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(1000, 800));
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã khách hàng");
		dm.addColumn("Họ tên");
		dm.addColumn("Địa chỉ");
		dm.addColumn("111");
		dm.addColumn("Phường");
		dm.addColumn("222");
		dm.addColumn("Quận");
		dm.addColumn("Điện thoại");
		dm.addColumn("Email");
		dm.addColumn("Mã số công tơ");
		final JTable tbl = new JTable(dm);
		tbl.getTableHeader().setResizingAllowed(false);
		tbl.getColumnModel().getColumn(0).setMaxWidth(100);
		tbl.getColumnModel().getColumn(0).setPreferredWidth(100);
		tbl.getColumnModel().getColumn(1).setPreferredWidth(150);
		tbl.getColumnModel().getColumn(1).setMinWidth(100);
		tbl.getColumnModel().getColumn(1).setMinWidth(150);
		tbl.getColumnModel().getColumn(2).setPreferredWidth(150);
		tbl.getColumnModel().getColumn(3).setMaxWidth(0);
		tbl.getColumnModel().getColumn(3).setMinWidth(0);
		tbl.getColumnModel().getColumn(3).setPreferredWidth(0);
		tbl.getColumnModel().getColumn(4).setPreferredWidth(150);
		tbl.getColumnModel().getColumn(5).setMaxWidth(0);
		tbl.getColumnModel().getColumn(5).setMinWidth(0);
		tbl.getColumnModel().getColumn(5).setPreferredWidth(0);
		tbl.getColumnModel().getColumn(6).setPreferredWidth(150);
		tbl.getColumnModel().getColumn(7).setPreferredWidth(75);
		tbl.getColumnModel().getColumn(9).setPreferredWidth(100);
		tbl.getColumnModel().getColumn(9).setMaxWidth(100);
		tbl.setDefaultEditor(Object.class, null);
		connect();
		try {
			while (rs.next()) {
				dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
						rs.getString(10) });
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
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				cboMaSoCongTo.setEnabled(false);
				int row = tbl.getSelectedRow();
				String maKH = (String) tbl.getValueAt(row, 0);
				String hoTen = (String) tbl.getValueAt(row, 1);
				String diaChi = (String) tbl.getValueAt(row, 2);
				String dienThoai = (String) tbl.getValueAt(row, 7);
				String email = (String) tbl.getValueAt(row, 8);
				int maCongTo = Integer.parseInt((String) tbl.getValueAt(row, 9));
				int idQuan = Integer.parseInt((String) tbl.getValueAt(row, 5));
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
				txtMaKH.setEditable(false);
				txtMaKH.setText(maKH);
				txtHoTen.setText(hoTen);
				txtDiaChi.setText(diaChi);
				txtDienThoai.setText(dienThoai);
				txtEmail.setText(email);
				cboMaSoCongTo.setSelectedIndex(maCongTo);
				for (int i = 0; i < cboPhuong1.getItemCount(); i++) {
					if (((ComboItem) (cboPhuong1.getItemAt(i))).getId() == idPhuong) {
						cboPhuong1.setSelectedIndex(i);
					}
				}
			}
		});
		tbl.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyReleased(KeyEvent e) {
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				cboMaSoCongTo.setEnabled(false);
				int row = tbl.getSelectedRow();
				String maKH = (String) tbl.getValueAt(row, 0);
				String hoTen = (String) tbl.getValueAt(row, 1);
				String diaChi = (String) tbl.getValueAt(row, 2);
				String dienThoai = (String) tbl.getValueAt(row, 7);
				String email = (String) tbl.getValueAt(row, 8);
				int maCongTo = Integer.parseInt((String) tbl.getValueAt(row, 9));
				int idQuan = Integer.parseInt((String) tbl.getValueAt(row, 5));
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
				txtMaKH.setEditable(false);
				txtMaKH.setText(maKH);
				txtHoTen.setText(hoTen);
				txtDiaChi.setText(diaChi);
				txtDienThoai.setText(dienThoai);
				txtEmail.setText(email);
				cboMaSoCongTo.setSelectedIndex(maCongTo);
				for (int i = 0; i < cboPhuong1.getItemCount(); i++) {
					if (((ComboItem) (cboPhuong1.getItemAt(i))).getId() == idPhuong) {
						cboPhuong1.setSelectedIndex(i);
					}
				}
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
		cboQuan = new JComboBox<String>();
		cboQuan.addItem(new ComboItem(0, "Quận..."));
		cboQuan();
		cboPhuong = new JComboBox<String>();
		cboPhuong.addItem(new ComboItem(0, "Phường..."));

		cboQuan.addItemListener(new CboPhuong());

		pnFilter.add(cboQuan);
		pnFilter.add(cboPhuong);
		JButton btnSearch = new JButton("Search");
		JButton btnReset = new JButton("Reset");
		btnSearch.setForeground(green);
		btnReset.setForeground(green);
		btnReset.setFont(new Font(null, Font.BOLD, 13));
		btnSearch.setFont(new Font(null, Font.BOLD, 13));
		btnSearch.setPreferredSize(new Dimension(100, 30));
		btnReset.setPreferredSize(new Dimension(100, 30));
		cboQuan.setPreferredSize(new Dimension(200, 30));
		cboPhuong.setPreferredSize(new Dimension(200, 30));
		pnFilter.add(btnSearch);
		pnFilter.add(btnReset);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = connect();
				int n = cboQuan.getSelectedIndex();
				if (n == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn tiêu chí tìm kiếm");
				} else {
					int j = ((ComboItem) cboPhuong.getSelectedItem()).getId();
					int i = ((ComboItem) cboQuan.getSelectedItem()).getId();
					try {
						String sql = "select * from khachhang where idquan = '" + i + "'";
						rs = stmt.executeQuery(sql);
						dm.setRowCount(0);
						while (rs.next()) {
							if (rs.getInt(6) == i) {
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
		btnReset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ResultSet rs = connect();
					dm.setRowCount(0);
					String sql = "select * from khachhang";
					rs = stmt.executeQuery(sql);
					while (rs.next()) {
						dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
								rs.getString(10) });
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
					cboQuan.setSelectedIndex(0);
					cboPhuong.setSelectedIndex(0);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
				if (cboQuan1.getSelectedIndex() == 0) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
				} else {
					try {
						ComboItem quan = (ComboItem) cboQuan1.getSelectedItem();
						ComboItem phuong = (ComboItem) cboPhuong1.getSelectedItem();
						QuanLyTienDienException.chckText(txtMaKH.getText());
						QuanLyTienDienException.chckText(txtHoTen.getText());
						QuanLyTienDienException.chckText(txtDiaChi.getText());
						QuanLyTienDienException.chckText(phuong.getName());
						QuanLyTienDienException.chckText(quan.getName());
						QuanLyTienDienException.chckText(txtDienThoai.getText());
						QuanLyTienDienException.chckText(txtEmail.getText());
						QuanLyTienDienException.chckComboBox(cboMaSoCongTo.getSelectedIndex());
						QuanLyTienDienException.chckMaKH(txtMaKH.getText());
						String maKhachHang = txtMaKH.getText();
						String hoTen = txtHoTen.getText();
						String diaChi = txtDiaChi.getText();

						int idPhuong = phuong.getId();
						int idQuan = quan.getId();
						String namePhuong = phuong.getName();
						String nameQuan = quan.getName();
						String dienThoai = txtDienThoai.getText();
						String email = txtEmail.getText();
						int maCongToDien = cboMaSoCongTo.getSelectedIndex();
						KhachHangDAO kh = new KhachHangDAO();
						kh.insert(maKhachHang, hoTen, diaChi, idPhuong, namePhuong, idQuan, nameQuan, dienThoai, email,
								maCongToDien);
						dm.setRowCount(0);
						connect();
						try {
							while (rs.next()) {
								dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
										rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
										rs.getString(8), rs.getString(9), rs.getString(10) });
							}
						} catch (SQLException ex) {

							ex.printStackTrace();
						}
						tbl.setModel(dm);
						dm.fireTableDataChanged();
						txtMaKH.setText("");
						txtHoTen.setText("");
						txtDiaChi.setText("");
						cboQuan1.setSelectedIndex(0);
						cboPhuong1.setSelectedIndex(0);
						txtDienThoai.setText("");
						txtEmail.setText("");
						cboMaSoCongTo.setSelectedIndex(0);
					} catch (QuanLyTienDienException ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		});

		btnEdit = new JButton("Sửa thông tin khách hàng");
		btnEdit.setEnabled(false);

		pnBtn.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMaKH.setEditable(true);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				cboMaSoCongTo.setEnabled(true);
				String maKhachHang = txtMaKH.getText();
				String hoTen = txtHoTen.getText();
				String diaChi = txtDiaChi.getText();
				ComboItem quan = (ComboItem) cboQuan1.getSelectedItem();
				ComboItem phuong = (ComboItem) cboPhuong1.getSelectedItem();
				int idPhuong = phuong.getId();
				int idQuan = quan.getId();
				String namePhuong = phuong.getName();
				String nameQuan = quan.getName();
				String dienThoai = txtDienThoai.getText();
				String email = txtEmail.getText();
				int maCongToDien = cboMaSoCongTo.getSelectedIndex();
				KhachHangDAO kh = new KhachHangDAO();
				kh.update(maKhachHang, hoTen, diaChi, idPhuong, namePhuong, idQuan, nameQuan, dienThoai, email,
						maCongToDien);
				dm.setRowCount(0);
				connect();
				try {
					while (rs.next()) {
						dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
								rs.getString(10) });
					}
				} catch (SQLException ex) {

					ex.printStackTrace();
				}
				tbl.setModel(dm);
				dm.fireTableDataChanged();
				txtMaKH.setText("");
				txtHoTen.setText("");
				txtDiaChi.setText("");
				cboQuan1.setSelectedIndex(0);
				cboPhuong1.setSelectedIndex(0);
				txtDienThoai.setText("");
				txtEmail.setText("");
				cboMaSoCongTo.setSelectedIndex(0);
			}
		});

		btnDelete = new JButton("Xóa khách hàng");
		btnDelete.setEnabled(false);

		pnBtn.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtMaKH.setEditable(true);
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				cboMaSoCongTo.setEnabled(true);
				String maKhachHang = txtMaKH.getText();
				KhachHangDAO kh = new KhachHangDAO();
				kh.delete(maKhachHang);
				dm.setRowCount(0);
				connect();
				try {
					while (rs.next()) {
						dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
								rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
								rs.getString(10) });
					}
				} catch (SQLException ex) {

					ex.printStackTrace();
				}
				tbl.setModel(dm);
				dm.fireTableDataChanged();
				txtMaKH.setText("");
				txtHoTen.setText("");
				txtDiaChi.setText("");
				cboQuan1.setSelectedIndex(0);
				cboPhuong1.setSelectedIndex(0);
				txtDienThoai.setText("");
				txtEmail.setText("");
				cboMaSoCongTo.setSelectedIndex(0);
			}
		});
		btnAdd.setForeground(green);
		btnDelete.setForeground(green);
		btnEdit.setForeground(green);
		
		btnAdd.setFont(new Font(null, Font.BOLD, 13));
		btnDelete.setFont(new Font(null, Font.BOLD, 13));
		btnEdit.setFont(new Font(null, Font.BOLD, 13));
		btnAdd.setPreferredSize(new Dimension(200, 30));
		btnDelete.setPreferredSize(new Dimension(200, 30));
		btnEdit.setPreferredSize(new Dimension(200, 30));

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
		cboMaSoCongTo.setEnabled(true);
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
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from khachhang");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return null;
	}
}
