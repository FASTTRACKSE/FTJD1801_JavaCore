package quanlisinhvien;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BaoCao extends JPanel {
	ResultSet rs = null;
	ResultSet rsNamHoc = null;
	ResultSet rsLopHoc = null;
	ResultSet rsDiem = null;
	Vector<Vector> cbbVector;
	Vector<Vector> cbbVector3;
	Vector<Vector> cbbVector4;
	Vector<Vector> cbbVector5;
	Vector<String> cbbVector2;
	Statement stmt;
	Connection con;
	int indexCbbNamHoc, indexCbbLopHoc;
	String namHoc, lopHoc;
	List list = new List();
	

	public BaoCao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/quanlitruonghoc?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery(
					"SELECT maSV, tenSV, diaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, dienThoai, eMail, maLH FROM sinhvien as list, xa_phuong as xp, quan_huyen as qh, tinh_thanh as tt where xp.MaXaPhuong = list.MaXaPhuong and qh.MaQuanHuyen = list.MaQuanHuyen and tt.MaTinhThanh = list.MaTinhThanh");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		try {
			stmt = con.createStatement();
			rsNamHoc = stmt.executeQuery("select namHoc from lophoc");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsLopHoc = stmt.executeQuery("select maLH, tenLH, namHoc from lophoc");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stmt = con.createStatement();
			rsDiem = stmt.executeQuery("select * from lophocphan");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		cbbVector3 = list.AddList(rsDiem);
//		cbbVector4.get(0).add(cbbVector3.get(0).get(0));
//		cbbVector4.get(1).add(cbbVector3.get(1).get(0));
//		cbbVector4.get(2).add(0);
//		for(int i = 0; i < cbbVector3.get(0).size(); i++) {
//			for(int j = 0; j < cbbVector4.get(0).size(); j++) {
//				if(!cbbVector3.get(0).get(i).equals(cbbVector4.get(0).get(j)) & !cbbVector3.get(1).get(i).equals(cbbVector4.get(1).get(j))){
//					cbbVector4.get(0).add(cbbVector3.get(0).get(i));
//					cbbVector4.get(1).add(cbbVector3.get(1).get(i));
//					cbbVector4.get(2).add(0);
//				}
//			}
//		}
//		try {
//			while(rsDiem.next()) {
//				for(int i = 0 ; i < cbbVector4.get(0).size(); i++) {
//					if(rsDiem.getString(2).equals(cbbVector4.get(0).get(i)) & rsDiem.getString(3).equals(cbbVector4.get(1).get(i))) {
//						cbbVector4.get(2).set(i, rsDiem.getInt(4));					}
//				}
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			while(rs.next()) {
//				cbbVector5.get(0).add(rs.getString(1));
//				int diem = 0;
//				for(int i = 0; i < cbbVector4.get(0).size(); i++) {
//					if(rs.getString(1).equals(cbbVector4.get(0).get(i))) {
//						diem = diem + (int)cbbVector4.get(2).get(i);
//					}
//				}
//				cbbVector5.get(1).add(diem);
//			}
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		Font fontOne = new Font(Font.SERIF, Font.ITALIC, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JPanel pnNull = new JPanel();
		pnCenter.add(pnNull);

		JPanel pnSeach = new JPanel();
		pnSeach.setLayout(new FlowLayout());
		JLabel lblSeach = new JLabel("Tìm theo");
		JComboBox cbbSeach = new JComboBox();
		cbbSeach.addItem("Tất cả");
		cbbSeach.addItem("Năm học");
		cbbSeach.addItem("Tên lớp");
		cbbSeach.setPreferredSize(new Dimension(200, 30));
		lblSeach.setFont(fontOne);
		cbbSeach.setFont(fontOne);
		pnCenter.add(lblSeach);
		pnSeach.add(cbbSeach);
		pnCenter.add(pnSeach);

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblNamHoc = new JLabel("Năm học");
		JComboBox cbbNamHoc = new JComboBox();
		cbbNamHoc.setPreferredSize(new Dimension(200, 30));
		lblNamHoc.setFont(fontOne);
		cbbNamHoc.setFont(fontOne);
		pnCenter.add(lblNamHoc);
		pnOne.add(cbbNamHoc);
		pnCenter.add(pnOne);
		cbbVector2 = list.AddList2(rsNamHoc);
		for (int i = 0; i < cbbVector2.size(); i++) {
			cbbNamHoc.addItem(cbbVector2.get(i));
		}

		JPanel pnTwo = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblLop = new JLabel("Tên lớp");
		JComboBox cbbLop = new JComboBox();
		cbbLop.setPreferredSize(new Dimension(200, 30));
		lblLop.setFont(fontOne);
		cbbLop.setFont(fontOne);
		pnCenter.add(lblLop);
		pnTwo.add(cbbLop);
		pnCenter.add(pnTwo);
		cbbVector = list.AddList(rsLopHoc);
		for (int i = 0; i < cbbVector.get(0).size(); i++) {
			cbbLop.addItem(cbbVector.get(0).get(i) + " | " + cbbVector.get(1).get(i));
		}

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(fontOne);
		pnCenter.add(btnSearch);

		JPanel pnTa = new JPanel();
		pnTa.setLayout(new FlowLayout());
		DefaultTableModel tblSinhVien = new DefaultTableModel();
		tblSinhVien.addColumn("Mã sinh viên");
		tblSinhVien.addColumn("Họ và tên");
		tblSinhVien.addColumn("Địa chỉ");
		tblSinhVien.addColumn("Xã phường");
		tblSinhVien.addColumn("Quận huyện");
		tblSinhVien.addColumn("Tỉnh thành");
		tblSinhVien.addColumn("Số điện thoại");
		tblSinhVien.addColumn("Email");
		tblSinhVien.addColumn("Mã lớp học");
		tblSinhVien.addColumn("Điểm học phần");
		tblSinhVien.addColumn("Xếp loại");

		final JTable tbl = new JTable(tblSinhVien);
		try {
			while (rs.next()) {
				int i = 0;
				String maSV = rs.getString(1);
				String hoTen = rs.getString(2);
				String diaChi = rs.getString(3);
				String xaPhuong = rs.getString(4);
				String quanHuyen = rs.getString(5);
				String tinhThanh = rs.getString(6);
				String sdt = rs.getString(7);
				String email = rs.getString(8);
				String maLH = rs.getString(9);
//				String diem = (String)cbbVector5.get(1).get(0);
				// String xl = rs.getString(11);
				Vector<String> vec = new Vector<String>();
				vec.add(maSV);
				vec.add(hoTen);
				vec.add(diaChi);
				vec.add(xaPhuong);
				vec.add(quanHuyen);
				vec.add(tinhThanh);
				vec.add(sdt);
				vec.add(email);
				vec.add(maLH);
//				vec.add(diem);
				// vec.add(xl);
				tblSinhVien.addRow(vec);
				i++;
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
		pnTa.add(sc);
		pnTa.setBorder(borderTitle);

		cbbNamHoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				indexCbbNamHoc = cbbNamHoc.getSelectedIndex();
				namHoc = cbbVector2.get(indexCbbNamHoc);
			}
		});

		cbbLop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				indexCbbLopHoc = cbbLop.getSelectedIndex();
				lopHoc = (String) cbbVector.get(1).get(indexCbbLopHoc);
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					int index = cbbSeach.getSelectedIndex();
					if (index == 0) {
						tblSinhVien.setRowCount(0);
						rs = stmt.executeQuery(
								"SELECT maSV, tenSV, diaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, dienThoai, eMail, maLH FROM sinhvien as list, xa_phuong as xp, quan_huyen as qh, tinh_thanh as tt where xp.MaXaPhuong = list.MaXaPhuong and qh.MaQuanHuyen = list.MaQuanHuyen and tt.MaTinhThanh = list.MaTinhThanh");

						while (rs.next()) {
							String maSV = rs.getString(1);
							String hoTen = rs.getString(2);
							String diaChi = rs.getString(3);
							String xaPhuong = rs.getString(4);
							String quanHuyen = rs.getString(5);
							String tinhThanh = rs.getString(6);
							String sdt = rs.getString(7);
							String email = rs.getString(8);
							String maLH = rs.getString(9);
							Vector<String> vec = new Vector<String>();
							vec.add(maSV);
							vec.add(hoTen);
							vec.add(diaChi);
							vec.add(xaPhuong);
							vec.add(quanHuyen);
							vec.add(tinhThanh);
							vec.add(sdt);
							vec.add(email);
							vec.add(maLH);
							tblSinhVien.addRow(vec);
						}
						tbl.setModel(tblSinhVien);
						tblSinhVien.fireTableDataChanged();
					} else {
						if (index == 1) {
							tblSinhVien.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT maSV, tenSV, diaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, dienThoai, eMail,list.maLH FROM sinhvien as list, xa_phuong as xp, quan_huyen as qh, tinh_thanh as tt, lophoc as lh where xp.MaXaPhuong = list.MaXaPhuong and qh.MaQuanHuyen = list.MaQuanHuyen and tt.MaTinhThanh = list.MaTinhThanh and lh.maLH = list.maLH and namHoc = \'"
											+ namHoc + "\'");

							while (rs.next()) {
								String maSV = rs.getString(1);
								String hoTen = rs.getString(2);
								String diaChi = rs.getString(3);
								String xaPhuong = rs.getString(4);
								String quanHuyen = rs.getString(5);
								String tinhThanh = rs.getString(6);
								String sdt = rs.getString(7);
								String email = rs.getString(8);
								String maLH = rs.getString(9);
								Vector<String> vec = new Vector<String>();
								vec.add(maSV);
								vec.add(hoTen);
								vec.add(diaChi);
								vec.add(xaPhuong);
								vec.add(quanHuyen);
								vec.add(tinhThanh);
								vec.add(sdt);
								vec.add(email);
								vec.add(maLH);
								tblSinhVien.addRow(vec);
							}
							tbl.setModel(tblSinhVien);
							tblSinhVien.fireTableDataChanged();

						} else if (index == 2) {
							tblSinhVien.setRowCount(0);
							rs = stmt.executeQuery(
									"SELECT maSV, tenSV, diaChi, TenXaPhuong, TenQuanHuyen, TenTinhThanh, dienThoai, eMail, list.maLH FROM sinhvien as list, xa_phuong as xp, quan_huyen as qh, tinh_thanh as tt, lophoc as lh where xp.MaXaPhuong = list.MaXaPhuong and qh.MaQuanHuyen = list.MaQuanHuyen and tt.MaTinhThanh = list.MaTinhThanh and list.maLH = lh.maLH  and tenLH = \'"
											+ lopHoc + "\'");

							while (rs.next()) {
								String maSV = rs.getString(1);
								String hoTen = rs.getString(2);
								String diaChi = rs.getString(3);
								String xaPhuong = rs.getString(4);
								String quanHuyen = rs.getString(5);
								String tinhThanh = rs.getString(6);
								String sdt = rs.getString(7);
								String email = rs.getString(8);
								String maLH = rs.getString(9);
								Vector<String> vec = new Vector<String>();
								vec.add(maSV);
								vec.add(hoTen);
								vec.add(diaChi);
								vec.add(xaPhuong);
								vec.add(quanHuyen);
								vec.add(tinhThanh);
								vec.add(sdt);
								vec.add(email);
								vec.add(maLH);
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

		add(pnCenter);
		add(pnTa);
	}

}
