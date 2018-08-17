package library;

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

public class PanelQuanLySach extends JPanel {
	ResultSet rs = null;
	ResultSet rsMaNXB = null;
	ResultSet rsTheLoai = null;
	ResultSet rsMaTacGia = null;
	Statement stmt;
	Connection con;
	int i = 0, j = 1, indexOne, indexTwo, indexThree;
	Vector<Vector> vecCbb;
	Vector<Vector> vecCbb2;
	Vector<Vector> vecCbb3;
	String maNXB;
	String maTheLoai;
	String maTacGia;
	ActionComboBox atnCbb = new ActionComboBox();

	public PanelQuanLySach() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			stmt = con.createStatement();
			rsMaNXB = stmt.executeQuery("select MaNXB, TenXuatBan from nhaxuatban");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsMaTacGia = stmt.executeQuery("Select MaTacGia, TenTacGia from tacgia");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsTheLoai = stmt.executeQuery("Select MaTheLoai, TenTheLoai from theloai");
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
		JLabel lblID = new JLabel("Mã sách");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnTwo = new JPanel();
		pnTwo.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Tên sách");
		JTextField txtName = new JTextField(15);
		lblName.setFont(fontOne);
		txtName.setFont(fontOne);
		grTop.add(lblName);
		pnTwo.add(txtName);
		grTop.add(pnTwo);
		
		JPanel pnSeven = new JPanel();
		pnSeven.setLayout(new FlowLayout());
		JLabel lblNXB = new JLabel("Nhà xuất bản");
		JComboBox cbbNXB = new JComboBox();
		cbbNXB.setPreferredSize(new Dimension(200, 30));
		lblNXB.setFont(fontOne);
		cbbNXB.setFont(fontOne);
		grTop.add(lblNXB);
		pnSeven.add(cbbNXB);
		grTop.add(pnSeven);

		JPanel pnEight = new JPanel();
		pnEight.setLayout(new FlowLayout());
		JLabel lblTacGia = new JLabel("Tác giả");
		JComboBox cbbTacGia = new JComboBox();
		cbbTacGia.setPreferredSize(new Dimension(200, 30));
		lblTacGia.setFont(fontOne);
		cbbTacGia.setFont(fontOne);
		grTop.add(lblTacGia);
		pnEight.add(cbbTacGia);
		grTop.add(pnEight);

		JPanel pnNine = new JPanel();
		pnNine.setLayout(new FlowLayout());
		JLabel lblTheLoai = new JLabel("Thể loại");
		JComboBox cbbTheLoai = new JComboBox();
		cbbTheLoai.setPreferredSize(new Dimension(200, 30));
		lblTheLoai.setFont(fontOne);
		cbbTheLoai.setFont(fontOne);
		grTop.add(lblTheLoai);
		pnNine.add(cbbTheLoai);
		grTop.add(pnNine);

		JPanel pnFour = new JPanel();
		pnFour.setLayout(new FlowLayout());
		JLabel lblNamXB = new JLabel("Năm xuất bản");
		JTextField txtNamXB = new JTextField(15);
		lblNamXB.setFont(fontOne);
		txtNamXB.setFont(fontOne);
		grTop.add(lblNamXB);
		pnFour.add(txtNamXB);
		grTop.add(pnFour);

		JPanel pnFive = new JPanel();
		pnFive.setLayout(new FlowLayout());
		JLabel lblSLTong = new JLabel("Số lượng tổng");
		JTextField txtSLTong = new JTextField(15);
		lblSLTong.setFont(fontOne);
		txtSLTong.setFont(fontOne);
		grTop.add(lblSLTong);
		pnFive.add(txtSLTong);
		grTop.add(pnFive);

		JPanel pnSix = new JPanel();
		pnSix.setLayout(new FlowLayout());
		JLabel lblBorrow = new JLabel("Số lượng còn");
		JTextField txtBorrow = new JTextField(15);
		lblBorrow.setFont(fontOne);
		txtBorrow.setFont(fontOne);
		grTop.add(lblBorrow);
		pnSix.add(txtBorrow);
		grTop.add(pnSix);
		
		vecCbb = atnCbb.ArrComboBox(rsTinhThanh);
		for (i = 0; i < vecCbb.get(0).size(); i++) {
			cbbTheLoai.addItem(vecCbb.get(0).get(i) + " | " + vecCbb.get(1).get(i));
		}
		vecCbb2 = atnCbb.ArrComboBox(rsQuanHuyen);
		for (i = 0; i < vecCbb2.get(0).size(); i++) {
			cbbTacGia.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
		}
		vecCbb3 = atnCbb.ArrComboBox(rsXaPhuong);
		for (i = 0; i < vecCbb3.get(0).size(); i++) {
			cbbNXB.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
		}

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

		cbbTheLoai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexOne = cbbTheLoai.getSelectedIndex();
				cbbTacGia.removeAllItems();
				try {
					maTinhThanh = (String) vecCbb.get(0).get(indexOne);
					rsQuanHuyen = stmt
							.executeQuery("Select MaQuanHuyen, TenQuanHuyen from quan_huyen_thixa where MaThanhPho = \'"
									+ maTinhThanh + "\'");
					vecCbb2 = atnCbb.ArrComboBox(rsQuanHuyen);
					for (int i = 0; i < vecCbb2.get(0).size(); i++) {
						cbbTacGia.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		cbbTacGia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexTwo = cbbTacGia.getSelectedIndex();

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
						cbbTacGia.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
					}
				}
				indexTwo = cbbTacGia.getSelectedIndex();
				cbbNXB.removeAllItems();
				try {
					maQuanHuyen = (String) vecCbb2.get(0).get(indexTwo);
					rsXaPhuong = stmt
							.executeQuery("Select MaXaPhuong, TenXaPhuong from xa_phuong_thitran where MaQuanHuyen = \'"
									+ maQuanHuyen + "\'");
					vecCbb3 = atnCbb.ArrComboBox(rsXaPhuong);
					for (int i = 0; i < vecCbb3.get(0).size(); i++) {
						cbbNXB.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		cbbNXB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexThree = cbbNXB.getSelectedIndex();
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
						cbbNXB.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
					}
				}

				indexThree = cbbNXB.getSelectedIndex();
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
				txtNamXB.setText(phone);

				String mail = (String) tbl.getValueAt(row, 7);
				txtSLTong.setText(mail);

				String soSach = (String) tbl.getValueAt(row, 8);
				txtBorrow.setText(soSach);
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

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into bandoc values(\'" + txtID.getText() + "\',\'" + txtName.getText()
							+ "\',\'" + txtAdd.getText() + "\',\'" + maXaPhuong + "\',\'" + maQuanHuyen + "\',\'"
							+ maTinhThanh + "\',\'" + txtNamXB.getText() + "\',\'" + txtSLTong.getText() + "\',\'"
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
							+ maQuanHuyen + "\', MaTinhThanh = \'" + maTinhThanh + "\', SDT = \'" + txtNamXB.getText()
							+ "\', Email = \'" + txtSLTong.getText() + "\', SoSachMuon = \'" + txtBorrow.getText()
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
				try {
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
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					int index = cbbType.getSelectedIndex();
					if (txtValue.getText().equals("")) {
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
