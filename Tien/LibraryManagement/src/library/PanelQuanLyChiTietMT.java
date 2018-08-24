package library;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class PanelQuanLyChiTietMT extends JPanel {
	ResultSet rs = null;
	ResultSet rsMaGiaoDich = null;
	ResultSet rsMaSach = null;
	Statement stmt;
	Connection con;
	int i = 0, j = 1, indexOne, indexTwo, indexThree;
	String one, two, three;
	Vector<String> vecCbb;
	Vector<Vector> vecCbb2;
	String maGD;
	String maSach;
	String tinhTrang;
	String ngayTra;
	ActionComboBox atnCbb = new ActionComboBox();

	public PanelQuanLyChiTietMT() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from chitietmuontra");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			stmt = con.createStatement();
			rsMaGiaoDich = stmt.executeQuery("select MaGiaoDich from phieumuontra");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsMaSach = stmt.executeQuery("Select MaSach, TenSach from sach");
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(2, 4));

		JPanel pnSeven = new JPanel();
		pnSeven.setLayout(new FlowLayout());
		JLabel lblMaGiaoDich = new JLabel("Mã giao dịch");
		JComboBox cbbMaGiaoDich = new JComboBox();
		cbbMaGiaoDich.setPreferredSize(new Dimension(200, 30));
		lblMaGiaoDich.setFont(fontOne);
		cbbMaGiaoDich.setFont(fontOne);
		grTop.add(lblMaGiaoDich);
		pnSeven.add(cbbMaGiaoDich);
		grTop.add(pnSeven);

		JPanel pnEight = new JPanel();
		pnEight.setLayout(new FlowLayout());
		JLabel lblMaSach = new JLabel("Mã Sách");
		JComboBox cbbMaSach = new JComboBox();
		cbbMaSach.setPreferredSize(new Dimension(200, 30));
		lblMaSach.setFont(fontOne);
		cbbMaSach.setFont(fontOne);
		grTop.add(lblMaSach);
		pnEight.add(cbbMaSach);
		grTop.add(pnEight);

		JPanel pnNine = new JPanel();
		pnNine.setLayout(new FlowLayout());
		JLabel lblTinhTrang = new JLabel("Tình trạng");
		JComboBox cbbTinhTrang = new JComboBox();
		cbbTinhTrang.addItem("Đang mượn");
		cbbTinhTrang.addItem("Đã trả");
		cbbTinhTrang.setPreferredSize(new Dimension(200, 30));
		lblTinhTrang.setFont(fontOne);
		cbbTinhTrang.setFont(fontOne);
		grTop.add(lblTinhTrang);
		pnNine.add(cbbTinhTrang);
		grTop.add(pnNine);

		JPanel pnFive = new JPanel();
		pnFive.setLayout(new FlowLayout());
		JLabel lblNgayTra = new JLabel("Ngày trả");
		JTextField txtNgayTra = new JTextField(15);
		lblNgayTra.setFont(fontOne);
		txtNgayTra.setFont(fontOne);
		grTop.add(lblNgayTra);
		pnFive.add(txtNgayTra);
		grTop.add(pnFive);

		vecCbb = atnCbb.ArrComboBox2(rsMaGiaoDich);
		for (i = 0; i < vecCbb.size(); i++) {
			cbbMaGiaoDich.addItem(vecCbb.get(i));
		}
		vecCbb2 = atnCbb.ArrComboBox(rsMaSach);
		for (i = 0; i < vecCbb2.get(0).size(); i++) {
			cbbMaSach.addItem(vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i));
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
		cbbType.addItem("Mã giao dịch");
		cbbType.addItem("Mã sách");
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
		tblSach.addColumn("Mã giao dịch");
		tblSach.addColumn("Mã sách");
		tblSach.addColumn("Tình trạng");
		tblSach.addColumn("Ngày trả");

		final JTable tbl = new JTable(tblSach);
		try {
			while (rs.next()) {
				String maGD = rs.getString(1);
				String maSach = rs.getString(2);
				String tinhTrang = rs.getString(3);
				String ngayTra = rs.getString(4);
				if(ngayTra.equals("0000-00-00")) {
					ngayTra = "";
				}
				Vector<String> vec = new Vector<String>();
				vec.add(maGD);
				vec.add(maSach);
				vec.add(tinhTrang);
				vec.add(ngayTra);
				tblSach.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách chi tiết mượn trả");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 400));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

		cbbMaGiaoDich.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				indexOne = cbbMaGiaoDich.getSelectedIndex();
				maGD = (String) vecCbb.get(indexOne);
			}
		});

		cbbTinhTrang.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				tinhTrang = (String) cbbTinhTrang.getSelectedItem();
			}
		});

		cbbMaSach.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				indexTwo = cbbMaSach.getSelectedIndex();
				maSach = (String) vecCbb2.get(0).get(indexTwo);

			}
		});

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				String NXB = (String) tbl.getValueAt(row, 0);
				for (int i = 0; i < vecCbb.size(); i++) {
					if (vecCbb.get(i).equals(NXB)) {
						one = (String) vecCbb.get(i);
					}
				}
				cbbMaGiaoDich.setSelectedItem(one);

				String tacGia = (String) tbl.getValueAt(row, 1);
				for (int i = 0; i < vecCbb2.get(0).size(); i++) {
					if (vecCbb2.get(0).get(i).equals(tacGia)) {
						two = (String) vecCbb2.get(0).get(i) + " | " + vecCbb2.get(1).get(i);
					}
				}
				cbbMaSach.setSelectedItem(two);

				String tinhTrang = (String) tbl.getValueAt(row, 2);
				cbbTinhTrang.setSelectedItem(tinhTrang);

				String ngayTra = (String) tbl.getValueAt(row, 3);
				txtNgayTra.setText(ngayTra);
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
				txtNgayTra.setText("");
				cbbTinhTrang.setSelectedIndex(0);
				cbbMaGiaoDich.setSelectedIndex(0);
				cbbMaSach.setSelectedIndex(0);
			}
		});
		
		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtNgayTra.getText().equals("")) {
					ngayTra = "0000-00-00";
				}
				try {
					stmt.execute("Insert into chitietmuontra values(\'" + maGD + "\',\'" + maSach + "\',\'" + tinhTrang
							+ "\',\'" + ngayTra + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblSach.setRowCount(0);
					rs = stmt.executeQuery("Select * from chitietmuontra");

					while (rs.next()) {
						String maGD = rs.getString(1);
						String maSach = rs.getString(2);
						String tinhTrang = rs.getString(3);
						String ngayTra = rs.getString(4);
						if(ngayTra.equals("0000-00-00")) {
							ngayTra = "";
						}
						Vector<String> vec = new Vector<String>();
						vec.add(maGD);
						vec.add(maSach);
						vec.add(tinhTrang);
						vec.add(ngayTra);
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
				if(txtNgayTra.getText().equals("")) {
					ngayTra = "0000-00-00";
				}
				try {
					stmt.execute("update chitietmuontra set TinhTrang = \'" + tinhTrang + "\', NgayTra = \'"
							+ ngayTra + "\' where MaGiaoDich = \'" + maGD + "\' and  MaSach = \'" + maSach
							+ "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblSach.setRowCount(0);
					rs = stmt.executeQuery("Select * from chitietmuontra");

					while (rs.next()) {
						String maGD = rs.getString(1);
						String maSach = rs.getString(2);
						String tinhTrang = rs.getString(3);
						String ngayTra = rs.getString(4);
						if(ngayTra.equals("0000-00-00")) {
							ngayTra = "";
						}
						Vector<String> vec = new Vector<String>();
						vec.add(maGD);
						vec.add(maSach);
						vec.add(tinhTrang);
						vec.add(ngayTra);
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
				int dialogResult = JOptionPane.showConfirmDialog(null, "Thao tác này sẽ xóa dữ liệu đã chọn!!!",
						"Cảnh báo", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						stmt.execute("delete from chitietmuontra where MaGiaoDich = \'" + maGD + "\' and MaSach = \'"
								+ maSach + "\'");
						JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
						tblSach.setRowCount(0);
						rs = stmt.executeQuery("Select * from chitietmuontra");

						while (rs.next()) {
							String maGD = rs.getString(1);
							String maSach = rs.getString(2);
							String tinhTrang = rs.getString(3);
							String ngayTra = rs.getString(4);
							Vector<String> vec = new Vector<String>();
							vec.add(maGD);
							vec.add(maSach);
							vec.add(tinhTrang);
							vec.add(ngayTra);
							tblSach.addRow(vec);
						}
						tbl.setModel(tblSach);
						tblSach.fireTableDataChanged();

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
						tblSach.setRowCount(0);
						rs = stmt.executeQuery(
								"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.maGD = s.maGD and tls.maSach = s.maSach and tg.MaTacGia = s.MaTacGia");

						while (rs.next()) {
							String maGD = rs.getString(1);
							String maSach = rs.getString(2);
							String tinhTrang = rs.getString(3);
							String ngayTra = rs.getString(4);
							if(ngayTra.equals("0000-00-00")) {
								ngayTra = "";
							}
							Vector<String> vec = new Vector<String>();
							vec.add(maGD);
							vec.add(maSach);
							vec.add(tinhTrang);
							vec.add(ngayTra);
							tblSach.addRow(vec);
						}
						tbl.setModel(tblSach);
						tblSach.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.maGD = s.maGD and tls.maSach = s.maSach and tg.MaTacGia = s.MaTacGia and MaSach like \'%"
											+ txtValue.getText() + "%\'");

							while (rs.next()) {
								String maGD = rs.getString(1);
								String maSach = rs.getString(2);
								String tinhTrang = rs.getString(3);
								String ngayTra = rs.getString(4);
								Vector<String> vec = new Vector<String>();
								vec.add(maGD);
								vec.add(maSach);
								vec.add(tinhTrang);
								vec.add(ngayTra);
								tblSach.addRow(vec);
							}
							tbl.setModel(tblSach);
							tblSach.fireTableDataChanged();

						} else if (index == 1) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.maGD = s.maGD and tls.maSach = s.maSach and tg.MaTacGia = s.MaTacGia and TenSach like \'%"
											+ txtValue.getText() + "%\'");

							while (rs.next()) {
								String maGD = rs.getString(1);
								String maSach = rs.getString(2);
								String tinhTrang = rs.getString(3);
								String ngayTra = rs.getString(4);
								if(ngayTra.equals("0000-00-00")) {
									ngayTra = "";
								}
								Vector<String> vec = new Vector<String>();
								vec.add(maGD);
								vec.add(maSach);
								vec.add(tinhTrang);
								vec.add(ngayTra);
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
