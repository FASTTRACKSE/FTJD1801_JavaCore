package library;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelQuanLyBanDoc extends JPanel {
	ResultSet rs = null;
	ResultSet rsTinhThanh = null;
	ResultSet rsQuanHuyen = null;
	ResultSet rsXaPhuong = null;
	Statement stmt;
	Connection con;
	int i = 0, j = 1, indexOne, indexTwo, indexThree;
	String one, two, three;
	Vector<Vector> vecCbb;
	Vector<Vector> vecCbb2;
	Vector<Vector> vecCbb3;
	String maXaPhuong;
	String maQuanHuyen;
	String maTinhThanh;
	ActionComboBox atnCbb = new ActionComboBox();

	public PanelQuanLyBanDoc() {

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
			rsQuanHuyen = stmt.executeQuery("Select MaQuanHuyen, TenQuanHuyen from quan_huyen_thixa");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsXaPhuong = stmt.executeQuery("Select MaXaPhuong, TenXaPhuong from xa_phuong_thitran");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		vecCbb = new Vector<Vector>();

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(5, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã bạn đọc");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnTwo = new JPanel();
		pnTwo.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Họ tên");
		JTextField txtName = new JTextField(15);
		lblName.setFont(fontOne);
		txtName.setFont(fontOne);
		grTop.add(lblName);
		pnTwo.add(txtName);
		grTop.add(pnTwo);

		JPanel pnThree = new JPanel();
		pnThree.setLayout(new FlowLayout());
		JLabel lblAdd = new JLabel("Địa chỉ");
		JTextField txtAdd = new JTextField(15);
		lblAdd.setFont(fontOne);
		txtAdd.setFont(fontOne);
		grTop.add(lblAdd);
		pnThree.add(txtAdd);
		grTop.add(pnThree);

		JPanel pnFour = new JPanel();
		pnFour.setLayout(new FlowLayout());
		JLabel lblPhone = new JLabel("Số điện thoại");
		JTextField txtPhone = new JTextField(15);
		lblPhone.setFont(fontOne);
		txtPhone.setFont(fontOne);
		grTop.add(lblPhone);
		pnFour.add(txtPhone);
		grTop.add(pnFour);

		JPanel pnFive = new JPanel();
		pnFive.setLayout(new FlowLayout());
		JLabel lblMail = new JLabel("Email");
		JTextField txtMail = new JTextField(15);
		lblMail.setFont(fontOne);
		txtMail.setFont(fontOne);
		grTop.add(lblMail);
		pnFive.add(txtMail);
		grTop.add(pnFive);

		JPanel pnSix = new JPanel();
		pnSix.setLayout(new FlowLayout());
		JLabel lblBorrow = new JLabel("Số sách mượn");
		JTextField txtBorrow = new JTextField(15);
		lblBorrow.setFont(fontOne);
		txtBorrow.setFont(fontOne);
		grTop.add(lblBorrow);
		pnSix.add(txtBorrow);
		grTop.add(pnSix);

		JPanel pnSeven = new JPanel();
		pnSeven.setLayout(new FlowLayout());
		JLabel lblXaPhuong = new JLabel("Xã phường");
		JComboBox cbbXaPhuong = new JComboBox();
		cbbXaPhuong.setPreferredSize(new Dimension(200, 30));
		lblXaPhuong.setFont(fontOne);
		cbbXaPhuong.setFont(fontOne);
		grTop.add(lblXaPhuong);
		pnSeven.add(cbbXaPhuong);
		grTop.add(pnSeven);

		JPanel pnEight = new JPanel();
		pnEight.setLayout(new FlowLayout());
		JLabel lblQuanHuyen = new JLabel("Quận huyện");
		JComboBox cbbQuanHuyen = new JComboBox();
		cbbQuanHuyen.setPreferredSize(new Dimension(200, 30));
		lblQuanHuyen.setFont(fontOne);
		cbbQuanHuyen.setFont(fontOne);
		grTop.add(lblQuanHuyen);
		pnEight.add(cbbQuanHuyen);
		grTop.add(pnEight);

		JPanel pnNine = new JPanel();
		pnNine.setLayout(new FlowLayout());
		JLabel lblTinhThanh = new JLabel("Tỉnh thành");
		JComboBox cbbTinhThanh = new JComboBox();
		vecCbb = atnCbb.ArrComboBox(rsTinhThanh);
		for (i = 0; i < vecCbb.get(0).size(); i++) {
			cbbTinhThanh.addItem(vecCbb.get(0).get(i) + " | " + vecCbb.get(1).get(i));
		}
		vecCbb2 = atnCbb.ArrComboBox(rsQuanHuyen);
		for (i = 0; i < vecCbb2.get(0).size(); i++) {
			cbbQuanHuyen.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
		}
		vecCbb3 = atnCbb.ArrComboBox(rsXaPhuong);
		for (i = 0; i < vecCbb3.get(0).size(); i++) {
			cbbXaPhuong.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
		}

		cbbTinhThanh.setPreferredSize(new Dimension(200, 30));
		lblTinhThanh.setFont(fontOne);
		cbbTinhThanh.setFont(fontOne);
		grTop.add(lblTinhThanh);
		pnNine.add(cbbTinhThanh);
		grTop.add(pnNine);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFont(fontOne);
		pnCenter.add(btnAdd);

		JButton btnSave = new JButton("Lưu");
		btnSave.setFont(fontOne);
		pnCenter.add(btnSave);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(fontOne);
		pnCenter.add(btnUpdate);

		JButton btnRemove = new JButton("Xóa");
		btnRemove.setFont(fontOne);
		pnCenter.add(btnRemove);

		JLabel lblType = new JLabel("Tìm theo");
		lblType.setFont(fontOne);
		pnCenter.add(lblType);
		JComboBox cbbType = new JComboBox();
		cbbType.addItem("Mã bạn đọc");
		cbbType.addItem("Tên bạn đọc");
		cbbType.setFont(fontOne);
		cbbType.setPreferredSize(new Dimension(200, 30));
		pnCenter.add(cbbType);

		JLabel lblValue = new JLabel("Dữ liệu: ");
		pnCenter.add(lblValue);
		lblValue.setFont(fontOne);
		JTextField txtValue = new JTextField(15);
		txtValue.setFont(fontOne);
		pnCenter.add(txtValue);

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

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách bạn đọc");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 300));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

		cbbTinhThanh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexOne = cbbTinhThanh.getSelectedIndex();
				maTinhThanh = (String) vecCbb.get(0).get(indexOne);
				cbbQuanHuyen.removeAllItems();
			}
		});

		cbbQuanHuyen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexTwo = cbbQuanHuyen.getSelectedIndex();

				if (indexTwo < 0) {
					try {
						maTinhThanh = (String) vecCbb.get(0).get(indexOne);
						rsQuanHuyen = stmt.executeQuery(
								"Select MaQuanHuyen, TenQuanHuyen from quan_huyen_thixa where MaThanhPho = \'"
										+ maTinhThanh + "\'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vecCbb2 = atnCbb.ArrComboBox(rsQuanHuyen);
					for (int i = 0; i < vecCbb2.get(0).size(); i++) {
						cbbQuanHuyen.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
					}
				}
				indexTwo = cbbQuanHuyen.getSelectedIndex();
				maQuanHuyen = (String) vecCbb2.get(0).get(indexTwo);
				cbbXaPhuong.removeAllItems();
			}
		});

		cbbXaPhuong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexThree = cbbXaPhuong.getSelectedIndex();
				if (indexThree < 0) {
					try {
						maQuanHuyen = (String) vecCbb2.get(0).get(indexTwo);
						rsXaPhuong = stmt.executeQuery(
								"Select MaXaPhuong, TenXaPhuong from xa_phuong_thitran where MaQuanHuyen = \'"
										+ maQuanHuyen + "\'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vecCbb3 = atnCbb.ArrComboBox(rsXaPhuong);
					for (int i = 0; i < vecCbb3.get(0).size(); i++) {
						cbbXaPhuong.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
					}
				}

				indexThree = cbbXaPhuong.getSelectedIndex();
				maXaPhuong = (String) vecCbb3.get(0).get(indexThree);
			}
		});

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				String id = (String) tbl.getValueAt(row, 0);
				txtID.setText(id);

				String name = (String) tbl.getValueAt(row, 1);
				txtName.setText(name);

				String add = (String) tbl.getValueAt(row, 2);
				txtAdd.setText(add);

				String phone = (String) tbl.getValueAt(row, 6);
				txtPhone.setText(phone);

				String mail = (String) tbl.getValueAt(row, 7);
				txtMail.setText(mail);

				String soSach = (String) tbl.getValueAt(row, 8);
				txtBorrow.setText(soSach);

				String tinhThanh = (String) tbl.getValueAt(row, 5);
				String quanHuyen = (String) tbl.getValueAt(row, 4);
				String xaPhuong = (String) tbl.getValueAt(row, 3);

				for (int i = 0; i < vecCbb.get(0).size(); i++) {
					if (tinhThanh.equals(vecCbb.get(1).get(i))) {
						one = (String) vecCbb.get(0).get(i);
					}
				}
				cbbTinhThanh.setSelectedItem(one + " | " + tinhThanh);

				for (int i = 0; i < vecCbb2.get(0).size(); i++) {
					if (quanHuyen.equals(vecCbb2.get(1).get(i))) {
						two = (String) vecCbb2.get(0).get(i);
					}
				}
				cbbQuanHuyen.setSelectedItem(two + " | " + quanHuyen);

				for (int i = 0; i < vecCbb3.get(0).size(); i++) {
					if (xaPhuong.equals(vecCbb3.get(1).get(i))) {
						three = (String) vecCbb3.get(0).get(i);
					}
				}
				cbbXaPhuong.setSelectedItem(three + " | " + xaPhuong);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtID.setText("");
				txtBorrow.setText("");
				txtAdd.setText("");
				txtMail.setText("");
				txtName.setText("");
				txtPhone.setText("");
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into bandoc values(\'" + txtID.getText() + "\',\'" + txtName.getText()
							+ "\',\'" + txtAdd.getText() + "\',\'" + maXaPhuong + "\',\'" + maQuanHuyen + "\',\'"
							+ maTinhThanh + "\',\'" + txtPhone.getText() + "\',\'" + txtMail.getText() + "\',\'"
							+ txtBorrow.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
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

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("update bandoc set HoTen = \'" + txtName.getText() + "\', DiaChi = \'"
							+ txtAdd.getText() + "\', MaXaPhuong = \'" + maXaPhuong + "\', MaQuanHuyen = \'"
							+ maQuanHuyen + "\', MaTinhThanh = \'" + maTinhThanh + "\', SDT = \'" + txtPhone.getText()
							+ "\', Email = \'" + txtMail.getText() + "\', SoSachMuon = \'" + txtBorrow.getText()
							+ "\' where MaBanDoc = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
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

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		});

		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Thao tác này sẽ xóa dữ liệu của bạn đọc ở phiếu mượn trả!!!", "Cảnh báo", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					// Saving code here

					try {
						stmt.execute("delete from phieumuontra where MaBanDoc = \'" + txtID.getText() + "\'");
						stmt.execute("delete from bandoc where MaBanDoc = \'" + txtID.getText() + "\'");
						JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
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

					} catch (Exception ex) {
						// TODO: handle exception
						System.err.println(ex);
					}
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					int index = cbbType.getSelectedIndex();
					if (txtValue.getText().equals("")) {
						tblBanDoc.setRowCount(0);
						for (int i = 0; i < vecCbb.get(0).size(); i++) {
							System.out.print(vecCbb.get(0).get(i) + ", ");
							System.out.print(vecCbb.get(1).get(i) + ", ");
						}
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
						if (index == 0) {
							tblBanDoc.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaBanDoc, HoTen, DiaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, SDT, Email, SoSachMuon FROM bandoc as bd, xa_phuong_thitran as xp, quan_huyen_thixa as qh, tinh_thanhpho as tt where xp.MaXaPhuong = bd.MaXaPhuong and qh.MaQuanHuyen = bd.MaQuanHuyen and tt.MaTinhThanh = bd.MaTinhThanh and MaBanDoc like \'%"
											+ txtValue.getText() + "%\'");

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

						} else if (index == 1) {
							tblBanDoc.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaBanDoc, HoTen, DiaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, SDT, Email, SoSachMuon FROM bandoc as bd, xa_phuong_thitran as xp, quan_huyen_thixa as qh, tinh_thanhpho as tt where xp.MaXaPhuong = bd.MaXaPhuong and qh.MaQuanHuyen = bd.MaQuanHuyen and tt.MaTinhThanh = bd.MaTinhThanh and HoTen like \'%"
											+ txtValue.getText() + "%\'");

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

		add(grTop);
		add(pnCenter);
		add(pnTable);

	}
}
