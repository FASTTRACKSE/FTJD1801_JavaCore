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
	String one, two, three;
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
					"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia");
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
			rsTheLoai = stmt.executeQuery("Select MaTheLoai, TenTheLoai from theloaisach");
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
		JLabel lblSLCon = new JLabel("Số lượng còn");
		JTextField txtSLCon = new JTextField(15);
		lblSLCon.setFont(fontOne);
		txtSLCon.setFont(fontOne);
		grTop.add(lblSLCon);
		pnSix.add(txtSLCon);
		grTop.add(pnSix);

		vecCbb = atnCbb.ArrComboBox(rsMaNXB);
		for (i = 0; i < vecCbb.get(0).size(); i++) {
			cbbNXB.addItem(vecCbb.get(0).get(i) + " | " + vecCbb.get(1).get(i));
		}
		vecCbb2 = atnCbb.ArrComboBox(rsMaTacGia);
		for (i = 0; i < vecCbb2.get(0).size(); i++) {
			cbbTacGia.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
		}
		vecCbb3 = atnCbb.ArrComboBox(rsTheLoai);
		for (i = 0; i < vecCbb3.get(0).size(); i++) {
			cbbTheLoai.addItem(vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i));
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
		cbbType.addItem("Mã sách");
		cbbType.addItem("Tên sách");
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
		DefaultTableModel tblSach = new DefaultTableModel();
		tblSach.addColumn("Mã sách");
		tblSach.addColumn("Tên sách");
		tblSach.addColumn("Nhà xuất bản");
		tblSach.addColumn("Tác giả");
		tblSach.addColumn("Thể loại");
		tblSach.addColumn("Năm xuất bản");
		tblSach.addColumn("Số lượng tổng");
		tblSach.addColumn("Số lượng còn");

		final JTable tbl = new JTable(tblSach);
		try {
			while (rs.next()) {
				String maSach = rs.getString(1);
				String tenSach = rs.getString(2);
				String maNXB = rs.getString(3);
				String maTacGia = rs.getString(4);
				String maTheLoai = rs.getString(5);
				String namXB = rs.getString(6);
				String slTong = rs.getString(7);
				String slCon = rs.getString(8);
				Vector<String> vec = new Vector<String>();
				vec.add(maSach);
				vec.add(tenSach);
				vec.add(maNXB);
				vec.add(maTacGia);
				vec.add(maTheLoai);
				vec.add(namXB);
				vec.add(slTong);
				vec.add(slCon);
				tblSach.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách tác phẩm");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 300));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

		cbbNXB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				indexThree = cbbNXB.getSelectedIndex();
				maNXB = (String) vecCbb.get(0).get(indexThree);
			}
		});

		cbbTacGia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexTwo = cbbTacGia.getSelectedIndex();
				maTacGia = (String) vecCbb2.get(0).get(indexTwo);

			}
		});
		
		cbbTheLoai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexOne = cbbTheLoai.getSelectedIndex();
				maTheLoai = (String) vecCbb3.get(0).get(indexOne);
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
				
				String NXB = (String) tbl.getValueAt(row, 2);
				for(int i = 0; i < vecCbb.get(0).size(); i++) {
					if(vecCbb.get(1).get(i).equals(NXB)) {
						one = (String) vecCbb.get(0).get(i) + " | " + vecCbb.get(1).get(i);
						
					}
				}
				cbbNXB.setSelectedItem(one);
				
				String tacGia = (String) tbl.getValueAt(row, 3);
				for(int i = 0; i < vecCbb2.get(0).size(); i++) {
					if(vecCbb2.get(1).get(i).equals(tacGia)) {
						two = (String) vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i);
						
					}
				}
				cbbTacGia.setSelectedItem(two);
				
				String theLoai = (String) tbl.getValueAt(row, 4);
				for(int i = 0; i < vecCbb3.get(0).size(); i++) {
					if(vecCbb3.get(1).get(i).equals(theLoai)) {
						three = (String) vecCbb3.get(0).get(i) + " | " + vecCbb3.get(1).get(i);
						
					}
				}
				cbbTheLoai.setSelectedItem(three);

				String phone = (String) tbl.getValueAt(row, 5);
				txtNamXB.setText(phone);

				String mail = (String) tbl.getValueAt(row, 6);
				txtSLTong.setText(mail);

				String soSach = (String) tbl.getValueAt(row, 7);
				txtSLCon.setText(soSach);
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
					stmt.execute("Insert into sach values(\'" + txtID.getText() + "\',\'" + txtName.getText() + "\',\'" + maNXB
							+ "\',\'" + maTacGia + "\',\'" + maTheLoai + "\',\'" + txtNamXB.getText() + "\',\'"
							+ txtSLTong.getText() + "\',\'" + txtSLCon.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblSach.setRowCount(0);
					rs = stmt.executeQuery(
							"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia");

					while (rs.next()) {
						String maSach = rs.getString(1);
						String tenSach = rs.getString(2);
						String maNXB = rs.getString(3);
						String maTacGia = rs.getString(4);
						String maTheLoai = rs.getString(5);
						String namXB = rs.getString(6);
						String slTong = rs.getString(7);
						String slCon = rs.getString(8);
						Vector<String> vec = new Vector<String>();
						vec.add(maSach);
						vec.add(tenSach);
						vec.add(maNXB);
						vec.add(maTacGia);
						vec.add(maTheLoai);
						vec.add(namXB);
						vec.add(slTong);
						vec.add(slCon);
						tblSach.addRow(vec);
					}
					tbl.setModel(tblSach);
					tblSach.fireTableDataChanged();

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
					stmt.execute("update sach set TenSach = \'" + txtName.getText() + "\', MaNXB = \'" + maNXB
							+ "\', MaTacGia = \'" + maTacGia + "\', MaTheLoai = \'" + maTheLoai + "\', NamXuatBan = \'"
							+ txtNamXB.getText() + "\', SoLuongTong = \'" + txtSLTong.getText() + "\', SoLuongCon = \'"
							+ txtSLCon.getText() + "\' where MaSach = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblSach.setRowCount(0);
					rs = stmt.executeQuery(
							"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia");

					while (rs.next()) {
						String maSach = rs.getString(1);
						String tenSach = rs.getString(2);
						String maNXB = rs.getString(3);
						String maTacGia = rs.getString(4);
						String maTheLoai = rs.getString(5);
						String namXB = rs.getString(6);
						String slTong = rs.getString(7);
						String slCon = rs.getString(8);
						Vector<String> vec = new Vector<String>();
						vec.add(maSach);
						vec.add(tenSach);
						vec.add(maNXB);
						vec.add(maTacGia);
						vec.add(maTheLoai);
						vec.add(namXB);
						vec.add(slTong);
						vec.add(slCon);
						tblSach.addRow(vec);
					}
					tbl.setModel(tblSach);
					tblSach.fireTableDataChanged();

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
					stmt.execute("delete from sach where MaSach = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
					tblSach.setRowCount(0);
					rs = stmt.executeQuery(
							"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia");

					while (rs.next()) {
						String maSach = rs.getString(1);
						String tenSach = rs.getString(2);
						String maNXB = rs.getString(3);
						String maTacGia = rs.getString(4);
						String maTheLoai = rs.getString(5);
						String namXB = rs.getString(6);
						String slTong = rs.getString(7);
						String slCon = rs.getString(8);
						Vector<String> vec = new Vector<String>();
						vec.add(maSach);
						vec.add(tenSach);
						vec.add(maNXB);
						vec.add(maTacGia);
						vec.add(maTheLoai);
						vec.add(namXB);
						vec.add(slTong);
						vec.add(slCon);
						tblSach.addRow(vec);
					}
					tbl.setModel(tblSach);
					tblSach.fireTableDataChanged();

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
						tblSach.setRowCount(0);
						rs = stmt.executeQuery(
								"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia");

						while (rs.next()) {
							String maSach = rs.getString(1);
							String tenSach = rs.getString(2);
							String maNXB = rs.getString(3);
							String maTacGia = rs.getString(4);
							String maTheLoai = rs.getString(5);
							String namXB = rs.getString(6);
							String slTong = rs.getString(7);
							String slCon = rs.getString(8);
							Vector<String> vec = new Vector<String>();
							vec.add(maSach);
							vec.add(tenSach);
							vec.add(maNXB);
							vec.add(maTacGia);
							vec.add(maTheLoai);
							vec.add(namXB);
							vec.add(slTong);
							vec.add(slCon);
							tblSach.addRow(vec);
						}
						tbl.setModel(tblSach);
						tblSach.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and MaSach like \'%"
											+ txtValue.getText() + "%\'");

							while (rs.next()) {
								String maSach = rs.getString(1);
								String tenSach = rs.getString(2);
								String maNXB = rs.getString(3);
								String maTacGia = rs.getString(4);
								String maTheLoai = rs.getString(5);
								String namXB = rs.getString(6);
								String slTong = rs.getString(7);
								String slCon = rs.getString(8);
								Vector<String> vec = new Vector<String>();
								vec.add(maSach);
								vec.add(tenSach);
								vec.add(maNXB);
								vec.add(maTacGia);
								vec.add(maTheLoai);
								vec.add(namXB);
								vec.add(slTong);
								vec.add(slCon);
								tblSach.addRow(vec);
							}
							tbl.setModel(tblSach);
							tblSach.fireTableDataChanged();

						} else if (index == 1) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and TenSach like \'%"
											+ txtValue.getText() + "%\'");

							while (rs.next()) {
								String maSach = rs.getString(1);
								String tenSach = rs.getString(2);
								String maNXB = rs.getString(3);
								String maTacGia = rs.getString(4);
								String maTheLoai = rs.getString(5);
								String namXB = rs.getString(6);
								String slTong = rs.getString(7);
								String slCon = rs.getString(8);
								Vector<String> vec = new Vector<String>();
								vec.add(maSach);
								vec.add(tenSach);
								vec.add(maNXB);
								vec.add(maTacGia);
								vec.add(maTheLoai);
								vec.add(namXB);
								vec.add(slTong);
								vec.add(slCon);
								tblSach.addRow(vec);
							}
							tbl.setModel(tblSach);
							tblSach.fireTableDataChanged();

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
