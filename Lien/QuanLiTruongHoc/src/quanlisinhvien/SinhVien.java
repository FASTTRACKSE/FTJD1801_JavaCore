package quanlisinhvien;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

public class SinhVien extends JPanel {
	ResultSet rs = null;
	ResultSet rsTinhThanh = null;
	ResultSet rsQuanHuyen = null;
	ResultSet rsXaPhuong = null;
	Statement stmt;
	Connection con;
	int i = 0, j = 1, indexOne, indexTwo, indexThree;
	Vector<Vector> vecCbb;
	Vector<Vector> vecCbb2;
	Vector<Vector> vecCbb3;
	String maXaPhuong;
	String maQuanHuyen;
	String maTinhThanh;

	public SinhVien() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlitruonghoc", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT maSV, tenSV, diaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, dienThoai, eMail FROM sinhvien as list, xa_phuong as xp, quan_huyen as qh, tinh_thanh as tt where xp.MaXaPhuong = list.MaXaPhuong and qh.MaQuanHuyen = list.MaQuanHuyen and tt.MaTinhThanh = list.MaTinhThanh");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			stmt = con.createStatement();
			rsTinhThanh = stmt.executeQuery("select MaTinhThanh, TenTinhThanh from tinh_thanh");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsQuanHuyen = stmt.executeQuery("Select MaQuanHuyen, TenQuanHuyen from quan_huyen");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsXaPhuong = stmt.executeQuery("Select MaXaPhuong, TenXaPhuong from xa_phuong");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		List list = new List();
		vecCbb = new Vector<Vector>();
		vecCbb = list.AddList(rsTinhThanh);

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(4, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã sinh viên");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnTwo = new JPanel();
		pnTwo.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Họ và tên");
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
		cbbTinhThanh.setPreferredSize(new Dimension(200, 30));
		lblTinhThanh.setFont(fontOne);
		cbbTinhThanh.setFont(fontOne);
		grTop.add(lblTinhThanh);
		pnNine.add(cbbTinhThanh);
		grTop.add(pnNine);

		for (i = 0; i < vecCbb.get(0).size(); i++) {
			cbbTinhThanh.addItem(vecCbb.get(0).get(i) + " | " + vecCbb.get(1).get(i));
		}
		vecCbb2 = list.AddList(rsQuanHuyen);
		for (i = 0; i < vecCbb2.get(0).size(); i++) {
			cbbQuanHuyen.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
		}
		vecCbb3 = list.AddList(rsXaPhuong);
		for (i = 0; i < vecCbb3.get(0).size(); i++) {
			cbbXaPhuong.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
		}

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JButton btnSave = new JButton("Thêm");
		btnSave.setFont(fontOne);
		pnCenter.add(btnSave);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(fontOne);
		pnCenter.add(btnUpdate);

		JButton btnRemove = new JButton("Xóa");
		btnRemove.setFont(fontOne);
		pnCenter.add(btnRemove);

		JLabel lblType = new JLabel("Tìm kiếm");
		lblType.setFont(fontOne);
		pnCenter.add(lblType);
		JComboBox cbbType = new JComboBox();
		cbbType.addItem("Mã sinh viên");
		cbbType.addItem("Họ và tên");
		cbbType.setFont(fontOne);
		cbbType.setPreferredSize(new Dimension(200, 30));
		pnCenter.add(cbbType);

		JLabel lblValue = new JLabel("Mời nhập: ");
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
		DefaultTableModel tblSinhVien = new DefaultTableModel();
		tblSinhVien.addColumn("Mã sinh viên");
		tblSinhVien.addColumn("Họ và tên");
		tblSinhVien.addColumn("Địa chỉ");
		tblSinhVien.addColumn("Xã phường");
		tblSinhVien.addColumn("Quận huyện");
		tblSinhVien.addColumn("Tỉnh thành");
		tblSinhVien.addColumn("Số điện thoại");
		tblSinhVien.addColumn("Email");

		final JTable tbl = new JTable(tblSinhVien);
		try {
			while (rs.next()) {
				String maSV = rs.getString(1);
				String hoTen = rs.getString(2);
				String diaChi = rs.getString(3);
				String xaPhuong = rs.getString(4);
				String quanHuyen = rs.getString(5);
				String tinhThanh = rs.getString(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
				Vector<String> vec = new Vector<String>();
				vec.add(maSV);
				vec.add(hoTen);
				vec.add(diaChi);
				vec.add(xaPhuong);
				vec.add(quanHuyen);
				vec.add(tinhThanh);
				vec.add(sdt);
				vec.add(email);
				tblSinhVien.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 300));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

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

				String xaPhuong = (String) tbl.getValueAt(row, 3);
				cbbXaPhuong.setToolTipText(xaPhuong);

				String quanHuyen = (String) tbl.getValueAt(row, 4);
				cbbQuanHuyen.setToolTipText(quanHuyen);

				String tinhThanh = (String) tbl.getValueAt(row, 5);
				cbbTinhThanh.setToolTipText(tinhThanh);

				String phone = (String) tbl.getValueAt(row, 6);
				txtPhone.setText(phone);

				String mail = (String) tbl.getValueAt(row, 7);
				txtMail.setText(mail);

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

		cbbTinhThanh.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexOne = cbbTinhThanh.getSelectedIndex();
				cbbQuanHuyen.removeAllItems();
				try {
					maTinhThanh = (String) vecCbb.get(0).get(indexOne);
					rsQuanHuyen = stmt
							.executeQuery("Select MaQuanHuyen, TenQuanHuyen from quan_huyen where MaTinhThanh = \'"
									+ maTinhThanh + "\'");
					vecCbb2 = list.AddList(rsQuanHuyen);
					for (int i = 0; i < vecCbb2.get(0).size(); i++) {
						cbbQuanHuyen.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
						rsQuanHuyen = stmt
								.executeQuery("Select MaQuanHuyen, TenQuanHuyen from quan_huyen where MaTinhThanh = \'"
										+ maTinhThanh + "\'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					vecCbb2 = list.AddList(rsQuanHuyen);
					for (int i = 0; i < vecCbb2.get(0).size(); i++) {
						cbbQuanHuyen.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
					}
				}
				indexTwo = cbbQuanHuyen.getSelectedIndex();
				cbbXaPhuong.removeAllItems();
				try {
					maQuanHuyen = (String) vecCbb2.get(0).get(indexTwo);
					rsXaPhuong = stmt
							.executeQuery("Select MaXaPhuong, TenXaPhuong from xa_phuong where MaQuanHuyen = \'"
									+ maQuanHuyen + "\'");
					vecCbb3 = list.AddList(rsXaPhuong);
					for (int i = 0; i < vecCbb3.get(0).size(); i++) {
						cbbXaPhuong.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
						rsXaPhuong = stmt
								.executeQuery("Select MaXaPhuong, TenXaPhuong from xa_phuong where MaQuanHuyen = \'"
										+ maQuanHuyen + "\'");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();

					}
					vecCbb3 = list.AddList(rsXaPhuong);
					for (int i = 0; i < vecCbb3.get(0).size(); i++) {
						cbbXaPhuong.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
					}
				}

				indexThree = cbbXaPhuong.getSelectedIndex();
				maXaPhuong = (String) vecCbb3.get(0).get(indexThree);
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into sinhvien values(" + txtID.getText() + ",\'" + txtName.getText() + "\',\'"
							+ txtAdd.getText() + "\',\'" + maXaPhuong + "\',\'" + maQuanHuyen + "\',\'" + maTinhThanh
							+ "\',\'" + txtPhone.getText() + "\',\'" + txtMail.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblSinhVien.setRowCount(0);
					rs = stmt.executeQuery("Select * from sinhvien");

					while (rs.next()) {
						String maSV = rs.getString(1);
						String hoTen = rs.getString(2);
						String diaChi = rs.getString(3);
						String xaPhuong = rs.getString(4);
						String quanHuyen = rs.getString(5);
						String tinhThanh = rs.getString(6);
						String sdt = rs.getString(7);
						String email = rs.getString(8);
						Vector<String> vec = new Vector<String>();
						vec.add(maSV);
						vec.add(hoTen);
						vec.add(diaChi);
						vec.add(xaPhuong);
						vec.add(quanHuyen);
						vec.add(tinhThanh);
						vec.add(sdt);
						vec.add(email);
						tblSinhVien.addRow(vec);
					}
					tbl.setModel(tblSinhVien);
					tblSinhVien.fireTableDataChanged();

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
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
						tblSinhVien.setRowCount(0);
						rs = stmt.executeQuery(
								"SELECT maSV, tenSV, diaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, dienThoai, eMail FROM sinhvien as list, xa_phuong as xp, quan_huyen as qh, tinh_thanh as tt where xp.MaXaPhuong = list.MaXaPhuong and qh.MaQuanHuyen = list.MaQuanHuyen and tt.MaTinhThanh = list.MaTinhThanh");

						while (rs.next()) {
							String maSV = rs.getString(1);
							String hoTen = rs.getString(2);
							String diaChi = rs.getString(3);
							String xaPhuong = rs.getString(4);
							String quanHuyen = rs.getString(5);
							String tinhThanh = rs.getString(6);
							String sdt = rs.getString(7);
							String email = rs.getString(8);
							Vector<String> vec = new Vector<String>();
							vec.add(maSV);
							vec.add(hoTen);
							vec.add(diaChi);
							vec.add(xaPhuong);
							vec.add(quanHuyen);
							vec.add(tinhThanh);
							vec.add(sdt);
							vec.add(email);

							tblSinhVien.addRow(vec);
						}
						tbl.setModel(tblSinhVien);
						tblSinhVien.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblSinhVien.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT maSV, tenSV, diaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, dienThoai, eMail FROM sinhvien as list, xa_phuong as xp, quan_huyen as qh, tinh_thanh as tt where xp.MaXaPhuong = list.MaXaPhuong and qh.MaQuanHuyen = list.MaQuanHuyen and tt.MaTinhThanh = list.MaTinhThanh and maSV like \'%"
											+ txtValue.getText() + "%\'");

							while (rs.next()) {
								String maSV = rs.getString(1);
								String hoTen = rs.getString(2);
								String diaChi = rs.getString(3);
								String xaPhuong = rs.getString(4);
								String quanHuyen = rs.getString(5);
								String tinhThanh = rs.getString(6);
								String sdt = rs.getString(7);
								String email = rs.getString(8);
								Vector<String> vec = new Vector<String>();
								vec.add(maSV);
								vec.add(hoTen);
								vec.add(diaChi);
								vec.add(xaPhuong);
								vec.add(quanHuyen);
								vec.add(tinhThanh);
								vec.add(sdt);
								vec.add(email);
								tblSinhVien.addRow(vec);
							}
							tbl.setModel(tblSinhVien);
							tblSinhVien.fireTableDataChanged();

						} else if (index == 1) {
							tblSinhVien.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT maSV, tenSV, diaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, dienThoai, eMail FROM sinhvien as list, xa_phuong as xp, quan_huyen as qh, tinh_thanh as tt where xp.MaXaPhuong = list.MaXaPhuong and qh.MaQuanHuyen = list.MaQuanHuyen and tt.MaTinhThanh = list.MaTinhThanh and tenSV like \'%"
											+ txtValue.getText() + "%\'");

							while (rs.next()) {
								String maSV = rs.getString(1);
								String hoTen = rs.getString(2);
								String diaChi = rs.getString(3);
								String xaPhuong = rs.getString(4);
								String quanHuyen = rs.getString(5);
								String tinhThanh = rs.getString(6);
								String sdt = rs.getString(7);
								String email = rs.getString(8);
								Vector<String> vec = new Vector<String>();
								vec.add(maSV);
								vec.add(hoTen);
								vec.add(diaChi);
								vec.add(xaPhuong);
								vec.add(quanHuyen);
								vec.add(tinhThanh);
								vec.add(sdt);
								vec.add(email);
								tblSinhVien.addRow(vec);
							}
							tbl.setModel(tblSinhVien);
							tblSinhVien.fireTableDataChanged();

						}
					}
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});

		// cbbTinhThanh.addItemListener(new ItemListener() {
		//
		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// // TODO Auto-generated method stub
		// cbbQuanHuyen.removeAllItems();
		// arrMa2.clear();
		// arrTen2.clear();
		//// for (int i = 0; i < arrMa2.size(); i++) {
		//// arrMa2.remove(i);
		//// arrTen2.remove(i);
		//// }
		// int index = cbbTinhThanh.getSelectedIndex();
		// try {
		// ResultSet rs3 = stmt.executeQuery("Select MaQuanHuyen, TenQuanHuyen from
		// quan_huyen_thixa where MaThanhPho = \'"+ arrMa.get(index) +"\'");
		// while(rs3.next()) {
		// maTinhThanh = rs3.getString(1);
		// tenTinhThanh = rs3.getString(2);
		// arrMa2.add(maTinhThanh);
		// arrTen2.add(tenTinhThanh);
		// }
		// } catch (SQLException e1) {
		// // TODO Auto-generated catch block
		// e1.printStackTrace();
		// }
		// for(int i = 0; i < arrMa2.size(); i++) {
		// cbbQuanHuyen.addItem(arrMa2.get(i) + " | " + arrTen2.get(i));
		// }
		//
		// }
		// });

		add(grTop);
		add(pnCenter);
		add(pnTable);
	}

}
