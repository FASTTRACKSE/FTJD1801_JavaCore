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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PanelBaoCaoSach extends JPanel {
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

	public PanelBaoCaoSach() {
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

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 16);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JLabel lblType = new JLabel("Tìm theo");
		lblType.setFont(fontOne);
		pnCenter.add(lblType);
		JComboBox cbbType = new JComboBox();
		cbbType.addItem("Tất cả");
		cbbType.addItem("Nhà xuất bản");
		cbbType.addItem("Tác giả");
		cbbType.addItem("Thể loại");
		cbbType.addItem("Theo cả 3");
		cbbType.addItem("Nhà xuất bản và Tác giả");
		cbbType.addItem("Nhà xuất bản và Thể loại");
		cbbType.addItem("Thể loại và Tác giả");
		cbbType.setFont(fontOne);
		cbbType.setPreferredSize(new Dimension(180, 30));
		pnCenter.add(cbbType);

		JLabel lblValue = new JLabel("Dữ liệu: ");
		pnCenter.add(lblValue);
		lblValue.setFont(fontOne);

		JPanel pnSeven = new JPanel();
		pnSeven.setLayout(new FlowLayout());
		JLabel lblNXB = new JLabel("Nhà xuất bản");
		JComboBox cbbNXB = new JComboBox();
		cbbNXB.setPreferredSize(new Dimension(180, 30));
		lblNXB.setFont(fontOne);
		cbbNXB.setFont(fontOne);
		pnCenter.add(lblNXB);
		pnSeven.add(cbbNXB);
		pnCenter.add(pnSeven);

		JPanel pnEight = new JPanel();
		pnEight.setLayout(new FlowLayout());
		JLabel lblTacGia = new JLabel("Tác giả");
		JComboBox cbbTacGia = new JComboBox();
		cbbTacGia.setPreferredSize(new Dimension(180, 30));
		lblTacGia.setFont(fontOne);
		cbbTacGia.setFont(fontOne);
		pnCenter.add(lblTacGia);
		pnEight.add(cbbTacGia);
		pnCenter.add(pnEight);

		JPanel pnNine = new JPanel();
		pnNine.setLayout(new FlowLayout());
		JLabel lblTheLoai = new JLabel("Thể loại");
		JComboBox cbbTheLoai = new JComboBox();
		cbbTheLoai.setPreferredSize(new Dimension(180, 30));
		lblTheLoai.setFont(fontOne);
		cbbTheLoai.setFont(fontOne);
		pnCenter.add(lblTheLoai);
		pnNine.add(cbbTheLoai);
		pnCenter.add(pnNine);

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
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 500));
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

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					int index = cbbType.getSelectedIndex();
					if (index == 0) {
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
						if (index == 1) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and s.MaNXB = \'"
											+ maNXB + "\'");
							if(!rs.next()) {
								JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác!!!");
							}
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
						} else if (index == 2) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and s.MaTacGia = \'"
											+ maTacGia + "\'");
							if(!rs.next()) {
								JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác!!!");
							}
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
						} else if (index == 3) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and s.MaTheLoai = \'"
											+ maTheLoai + "\'");
							if(!rs.next()) {
								JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác!!!");
							}
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

						}else if (index == 4) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and s.MaTheLoai = \'"
											+ maTheLoai + "\' and s.MaNXB = \'" + maNXB + "\' and s.MaTacGia = \'" + maTacGia + "\'");
							if(!rs.next()) {
								JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác!!!");
							}
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

						} else if (index == 5) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and s.MaNXB = \'" + maNXB + "\' and s.MaTacGia = \'" + maTacGia + "\'");
							if(!rs.next()) {
								JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác!!!");
							}
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

						} else if (index == 6) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and s.MaTheLoai = \'"
											+ maTheLoai + "\' and s.MaNXB = \'" + maNXB + "\'");
							if(!rs.next()) {
								JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác!!!");
							}
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

						} else if (index == 7) {
							tblSach.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT MaSach, TenSach, TenXuatBan, TenTacGia, TenTheLoai, NamXuatBan, SoLuongTong, SoLuongCon FROM sach as s, nhaxuatban as nxb, theloaisach as tls, tacgia as tg where nxb.MaNXB = s.MaNXB and tls.MaTheLoai = s.MaTheLoai and tg.MaTacGia = s.MaTacGia and s.MaTheLoai = \'"
											+ maTheLoai + "\' and s.MaTacGia = \'" + maTacGia + "\'");
							if(!rs.next()) {
								JOptionPane.showMessageDialog(null, "Dữ liệu không chính xác!!!");
							}
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

		add(pnCenter);
		add(pnTable);

	}
}
