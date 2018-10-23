package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import entity.QuanLiLopHoc;

public class ThongKeSinhVienUI extends JFrame {
	ResultSet rs = null;
	Statement stmt;
	public JComboBox cboNamHoc, cboMaLop;
	public DefaultTableModel dm;
	private JTable tbSinhVien;

	public JPanel pnThongKeSinhVien() {
		JPanel pnTab1 = new JPanel();

		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Thống Kê Sinh Viên", TitledBorder.CENTER,
				TitledBorder.DEFAULT_POSITION);
		titlebor2.setTitleFont(titlebor2.getTitleFont().deriveFont(Font.BOLD, 30));
		titlebor2.setTitleColor(Color.BLACK);
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(920, 920));

		JPanel main2 = new JPanel();
		main2.setLayout(new BorderLayout());

		pnTab1.add(main2, BorderLayout.CENTER);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien", "root", "");
			stmt = con.createStatement();

			rs = stmt.executeQuery("SELECT hososinhvien.masv,hososinhvien.hoten, hososinhvien.malop,\r\n"
					+ "BangDiemMH1.ketqua as MH1, \r\n" + "BangDiemMH2.ketqua as MH2, \r\n"
					+ "BangDiemMH3.ketqua as MH3, \r\n" + "BangDiemMH4.ketqua as MH4, \r\n"
					+ "ROUND((BangDiemMH1.ketqua + BangDiemMH1.ketqua+ BangDiemMH3.ketqua+ BangDiemMH4.ketqua)/4,1 )as dtb \r\n"
					+ "from\r\n" + "hososinhvien \r\n"
					+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH1') BangDiemMH1 on hososinhvien.masv = BangDiemMH1.masv\r\n"
					+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH2') BangDiemMH2 on hososinhvien.masv = BangDiemMH2.masv\r\n"
					+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH3') BangDiemMH3 on hososinhvien.masv = BangDiemMH3.masv\r\n"
					+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH4') BangDiemMH4 on hososinhvien.masv = BangDiemMH4.masv");

		} catch (Exception ex) {
			System.out.println(ex);
		}
		dm = new DefaultTableModel();
		dm.addColumn("Mã sinh viên");
		dm.addColumn("Họ tên");
		dm.addColumn("Mã Lớp");
		dm.addColumn("Công Nghệ");
		dm.addColumn("JavaCore");
		dm.addColumn("Thiết Kế Web");
		dm.addColumn("Chính Trị");
		dm.addColumn("Điểm Trung Bình");
		tbSinhVien = new JTable(dm);
		try {
			while (rs.next()) {
				String masv = rs.getString(1);
				String hoten = rs.getString(2);
				String malop = rs.getString(3);
				String monhoc1 = rs.getString(4);
				String monhoc2 = rs.getString(5);
				String monhoc3 = rs.getString(6);
				String monhoc4 = rs.getString(7);
				String dtb = rs.getString(8);
				Vector<String> vec = new Vector<String>();
				vec.add(masv);
				vec.add(hoten);
				vec.add(malop);
				vec.add(monhoc1);
				vec.add(monhoc2);
				vec.add(monhoc3);
				vec.add(monhoc4);
				vec.add(dtb);
				dm.addRow(vec);

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		JScrollPane sc = new JScrollPane(tbSinhVien);
		main2.add(sc, BorderLayout.CENTER);

		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());

		JPanel pnFilter = new JPanel();
		pn.add(pnFilter, BorderLayout.SOUTH);

		JComboBox cbo = new JComboBox();
		cbo.addItem("Tìm Theo ");
		cbo.addItem("Mã Sinh Viên");
		cbo.addItem("Tên");
		cbo.addItem("Mã Lớp");
		JTextField txtFilter = new JTextField(20);

		// pnFilter.setLayout(new GridLayout(1, 5));

		pnFilter.add(cbo);
		pnFilter.add(txtFilter);
		JButton btnSearch = new JButton("Search");

		btnSearch.setFont(new Font(null, Font.BOLD, 13));
		btnSearch.setPreferredSize(new Dimension(100, 30));

		pnFilter.add(btnSearch);
		main2.add(pn, BorderLayout.NORTH);

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = txtFilter.getText();
				// TODO Auto-generated method stub
				int n = cbo.getSelectedIndex();
				if (n == 1) {
					String sql;
					if (text.equals(""))
						sql = "SELECT hososinhvien.masv,hososinhvien.hoten, hososinhvien.malop,\r\n"
								+ "BangDiemMH1.ketqua as MH1, \r\n" + "BangDiemMH2.ketqua as MH2, \r\n"
								+ "BangDiemMH3.ketqua as MH3, \r\n" + "BangDiemMH4.ketqua as MH4, \r\n"
								+ "ROUND((BangDiemMH1.ketqua + BangDiemMH1.ketqua+ BangDiemMH3.ketqua+ BangDiemMH4.ketqua)/4,1 )as dtb \r\n"
								+ "from\r\n" + "hososinhvien \r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH1') BangDiemMH1 on hososinhvien.masv = BangDiemMH1.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH2') BangDiemMH2 on hososinhvien.masv = BangDiemMH2.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH3') BangDiemMH3 on hososinhvien.masv = BangDiemMH3.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH4') BangDiemMH4 on hososinhvien.masv = BangDiemMH4.masv";
					else
						sql = "SELECT hososinhvien.masv,hososinhvien.hoten, hososinhvien.malop,\r\n"
								+ "BangDiemMH1.ketqua as MH1, \r\n" + "BangDiemMH2.ketqua as MH2, \r\n"
								+ "BangDiemMH3.ketqua as MH3, \r\n" + "BangDiemMH4.ketqua as MH4, \r\n"
								+ "ROUND((BangDiemMH1.ketqua + BangDiemMH1.ketqua+ BangDiemMH3.ketqua+ BangDiemMH4.ketqua)/4,1 )as dtb \r\n"
								+ "from\r\n" + "hososinhvien \r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH1') BangDiemMH1 on hososinhvien.masv = BangDiemMH1.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH2') BangDiemMH2 on hososinhvien.masv = BangDiemMH2.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH3') BangDiemMH3 on hososinhvien.masv = BangDiemMH3.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH4') BangDiemMH4 on hososinhvien.masv = BangDiemMH4.masv where hososinhvien.masv =\'"
								+ text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbSinhVien.setModel(dm);
					dm.fireTableDataChanged();
				} else if (n == 2) {
					String sql;
					if (text.equals(""))
						sql = "SELECT hososinhvien.masv,hososinhvien.hoten, hososinhvien.malop,\r\n"
								+ "BangDiemMH1.ketqua as MH1, \r\n" + "BangDiemMH2.ketqua as MH2, \r\n"
								+ "BangDiemMH3.ketqua as MH3, \r\n" + "BangDiemMH4.ketqua as MH4, \r\n"
								+ "ROUND((BangDiemMH1.ketqua + BangDiemMH1.ketqua+ BangDiemMH3.ketqua+ BangDiemMH4.ketqua)/4,1 )as dtb \r\n"
								+ "from \r\n" + "hososinhvien \r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH1') BangDiemMH1 on hososinhvien.masv = BangDiemMH1.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH2') BangDiemMH2 on hososinhvien.masv = BangDiemMH2.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH3') BangDiemMH3 on hososinhvien.masv = BangDiemMH3.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH4') BangDiemMH4 on hososinhvien.masv = BangDiemMH4.masv";
					else
						sql = "SELECT hososinhvien.masv,hososinhvien.hoten, hososinhvien.malop,\r\n"
								+ "BangDiemMH1.ketqua as MH1, \r\n" + "BangDiemMH2.ketqua as MH2, \r\n"
								+ "BangDiemMH3.ketqua as MH3, \r\n" + "BangDiemMH4.ketqua as MH4, \r\n"
								+ "ROUND((BangDiemMH1.ketqua + BangDiemMH1.ketqua+ BangDiemMH3.ketqua+ BangDiemMH4.ketqua)/4,1 )as dtb \r\n"
								+ "from \r\n" + "hososinhvien \r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH1') BangDiemMH1 on hososinhvien.masv = BangDiemMH1.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH2') BangDiemMH2 on hososinhvien.masv = BangDiemMH2.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH3') BangDiemMH3 on hososinhvien.masv = BangDiemMH3.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH4') BangDiemMH4 on hososinhvien.masv = BangDiemMH4.masv where hososinhvien.hoten =\'"
								+ text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbSinhVien.setModel(dm);
					dm.fireTableDataChanged();
				} else if (n == 3) {
					String sql;
					if (text.equals(""))
						sql = "SELECT hososinhvien.masv,hososinhvien.hoten, hososinhvien.malop,\r\n"
								+ "BangDiemMH1.ketqua as MH1, \r\n" + "BangDiemMH2.ketqua as MH2, \r\n"
								+ "BangDiemMH3.ketqua as MH3, \r\n" + "BangDiemMH4.ketqua as MH4, \r\n"
								+ "ROUND((BangDiemMH1.ketqua + BangDiemMH1.ketqua+ BangDiemMH3.ketqua+ BangDiemMH4.ketqua)/4,1 )as dtb \r\n"
								+ "from \r\n" + "hososinhvien \r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH1') BangDiemMH1 on hososinhvien.masv = BangDiemMH1.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH2') BangDiemMH2 on hososinhvien.masv = BangDiemMH2.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH3') BangDiemMH3 on hososinhvien.masv = BangDiemMH3.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH4') BangDiemMH4 on hososinhvien.masv = BangDiemMH4.masv";
					else
						sql = "SELECT hososinhvien.masv,hososinhvien.hoten, hososinhvien.malop,\r\n"
								+ "BangDiemMH1.ketqua as MH1, \r\n" + "BangDiemMH2.ketqua as MH2, \r\n"
								+ "BangDiemMH3.ketqua as MH3, \r\n" + "BangDiemMH4.ketqua as MH4, \r\n"
								+ "ROUND((BangDiemMH1.ketqua + BangDiemMH1.ketqua+ BangDiemMH3.ketqua+ BangDiemMH4.ketqua)/4,1 )as dtb \r\n"
								+ "from \r\n" + "hososinhvien \r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH1') BangDiemMH1 on hososinhvien.masv = BangDiemMH1.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH2') BangDiemMH2 on hososinhvien.masv = BangDiemMH2.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH3') BangDiemMH3 on hososinhvien.masv = BangDiemMH3.masv\r\n"
								+ "left join (select ketqua, masv from bangdiem where mamonhoc = 'MH4') BangDiemMH4 on hososinhvien.masv = BangDiemMH4.masv where hososinhvien.malop =\'"
								+ text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
									rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8) });

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbSinhVien.setModel(dm);
					dm.fireTableDataChanged();
				}

			}

		});
		return pnTab1;
	}

}
