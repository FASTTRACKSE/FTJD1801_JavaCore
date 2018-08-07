package javaDesktop.finalProjectUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PnKhachHangUI {
	ResultSet rs = null;
	Statement stmt;
	Connection con;
	JComboBox cbo1 = new JComboBox();
	JComboBox cboPhuong = new JComboBox();
	public JPanel pnKhachHang () {
		JPanel pnTab1=new JPanel();
		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titlebor2=	new TitledBorder(bor2, "Thông tin khách hàng");
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(800, 800));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien","root","");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from quanlykhachhang");
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("Mã khách hàng");
		dm.addColumn("Họ tên");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Phường");
		dm.addColumn("Quận");
		dm.addColumn("Điện thoại");
		dm.addColumn("Email");
		dm.addColumn("Mã số công tơ điện");
		final JTable tbl=new JTable(dm);
		try {
			while (rs.next()) {
			dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JScrollPane sc=new JScrollPane(tbl);
		pnTab1.add(sc, BorderLayout.CENTER);
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		
		JPanel pnFilter=new JPanel();
		pn.add(pnFilter, BorderLayout.SOUTH);
		pnFilter.setLayout(new GridLayout(1, 3));
		JComboBox cbo=new JComboBox();
		cbo.addItem("Quận...");
		cbo.addItem("Hải Châu");
		cbo.addItem("Thanh Khê");
		cbo.addItem("Sơn Trà");
		cbo.addItem("Ngũ Hành Sơn");
		cbo.addItem("Liên Chiểu");
		cbo.addItem("Hòa Vang");
		cbo.addItem("Cẩm Lệ");
		cbo.addItem("Hoàng Sa");
		cbo1 = new JComboBox();
		cbo1.addItem("Phường ...");
		cbo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int i = cbo.getSelectedIndex();
				switch (i) {
				case 0:
					cbo1.removeAllItems();
					cbo1.addItem("Phường ...");
					break;
				case 1:
					cbo1.removeAllItems();
					cbo1.addItem("Thanh Bình");
					cbo1.addItem("Thuận Phước");
					cbo1.addItem("Thạch Thang");
					cbo1.addItem("Hải Châu 1");
					cbo1.addItem("Hải Châu 2");
					cbo1.addItem("Phước Ninh");
					cbo1.addItem("Hòa Thuận Tây");
					break;
				case 2: 
					cbo1.removeAllItems();
					cbo1.addItem("An Khê");
					cbo1.addItem("Chính Gián");
					cbo1.addItem("Hòa Khê");
					cbo1.addItem("Tam Thuận");
					cbo1.addItem("Tân Chính");
					cbo1.addItem("Thạc Gián");
					cbo1.addItem("Thanh Khê Đông");
					cbo1.addItem("Thanh Khê Tây");
					cbo1.addItem("Vĩnh Trung");
					cbo1.addItem("Xuân Hà");
					break;
				case 3: 
					cbo1.removeAllItems();
					cbo1.addItem("An Hải Bắc");
					cbo1.addItem("An Hải Đông");
					cbo1.addItem("An Hải Tây");
					cbo1.addItem("Mân Thái");
					cbo1.addItem("Nại Hiên Đông");
					cbo1.addItem("Phước Mỹ");
					cbo1.addItem("Thọ Quang");
					break;
				case 4: 
					cbo1.removeAllItems();
					cbo1.addItem("Hòa Hải");
					cbo1.addItem("Hòa Quý");
					cbo1.addItem("Khuê Mỹ");
					cbo1.addItem("Mỹ An");
					break;
				case 5: 
					cbo1.removeAllItems();
					cbo1.addItem("Hòa Hiệp Bắc");
					cbo1.addItem("Hòa Hiệp Nam");
					cbo1.addItem("Hòa Khánh Bắc");
					cbo1.addItem("Hòa Khánh Nam");
					cbo1.addItem("Hòa Minh");
					break;
				case 6:
					cbo1.removeAllItems();
					cbo1.addItem("Hòa Bắc");
					cbo1.addItem("Hòa Châu");
					cbo1.addItem("Hòa Khương");
					cbo1.addItem("Hòa Liên");
					cbo1.addItem("Hòa Nhơn");
					cbo1.addItem("Hòa Ninh");
					cbo1.addItem("Hòa Phong");
					cbo1.addItem("Hòa Phú");
					cbo1.addItem("Hòa Phước");
					cbo1.addItem("Hòa Sơn");
					cbo1.addItem("Hòa Tiến");
					break;
				case 7:
					cbo1.removeAllItems();
					cbo1.addItem("Hòa An");
					cbo1.addItem("Hòa Phát");
					cbo1.addItem("Hòa Thọ Đông");
					cbo1.addItem("Hòa Thọ Tây");
					cbo1.addItem("Hòa Xuân");
					break;
				case 8:
					cbo1.removeAllItems();
					break;
				}
			}
		});

		pnFilter.add(cbo);
		pnFilter.add(cbo1);
		JButton btnSearch = new JButton("search");
		pnFilter.add(btnSearch);
		pnTab1.add(pn, BorderLayout.NORTH);
		
		JPanel pnBtn = new JPanel();
		pn.add(pnBtn, BorderLayout.NORTH);
		JButton btnAdd = new JButton("Thêm khách hàng");
		pnBtn.add(btnAdd);

		JButton btnEdit = new JButton("Sửa thông tin khách hàng");
		pnBtn.add(btnEdit);
		
		JButton btnDelete = new JButton("Xóa khách hàng");
		pnBtn.add(btnDelete);
	
		
		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(8, 2));
		pn1.add(pnText, BorderLayout.CENTER);
		
		JLabel maKH = new JLabel("  Mã khách hàng");
		pnText.add(maKH);
		JTextField txtMaKH = new JTextField();
		pnText.add(txtMaKH);
		
		JLabel hoTen = new JLabel("  Họ tên");
		pnText.add(hoTen);
		JTextField txtHoTen = new JTextField(20);
		pnText.add(txtHoTen);
		
		JLabel diaChi = new JLabel("  Địa chỉ");
		pnText.add(diaChi);
		JTextField txtDiaChi = new JTextField(20);
		pnText.add(txtDiaChi);
		
		JLabel quan = new JLabel("  Quận");
		pnText.add(quan);
		JComboBox cboQuan=new JComboBox();
		cboQuan.addItem("Quận...");
		cboQuan.addItem("Hải Châu");
		cboQuan.addItem("Thanh Khê");
		cboQuan.addItem("Sơn Trà");
		cboQuan.addItem("Ngũ Hành Sơn");
		cboQuan.addItem("Liên Chiểu");
		cboQuan.addItem("Hòa Vang");
		cboQuan.addItem("Cẩm Lệ");
		cboQuan.addItem("Hoàng Sa");
		pnText.add(cboQuan);
		cboQuan.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int i = cboQuan.getSelectedIndex();
				switch (i) {
				case 0:
					cboPhuong.removeAllItems();
					cboPhuong.addItem("Phường ...");
					break;
				case 1:
					cboPhuong.removeAllItems();
					cboPhuong.addItem("Thanh Bình");
					cboPhuong.addItem("Thuận Phước");
					cboPhuong.addItem("Thạch Thang");
					cboPhuong.addItem("Hải Châu 1");
					cboPhuong.addItem("Hải Châu 2");
					cboPhuong.addItem("Phước Ninh");
					cboPhuong.addItem("Hòa Thuận Tây");
					break;
				case 2: 
					cboPhuong.removeAllItems();
					cboPhuong.addItem("An Khê");
					cboPhuong.addItem("Chính Gián");
					cboPhuong.addItem("Hòa Khê");
					cboPhuong.addItem("Tam Thuận");
					cboPhuong.addItem("Tân Chính");
					cboPhuong.addItem("Thạc Gián");
					cboPhuong.addItem("Thanh Khê Đông");
					cboPhuong.addItem("Thanh Khê Tây");
					cboPhuong.addItem("Vĩnh Trung");
					cboPhuong.addItem("Xuân Hà");
					break;
				case 3: 
					cboPhuong.removeAllItems();
					cboPhuong.addItem("An Hải Bắc");
					cboPhuong.addItem("An Hải Đông");
					cboPhuong.addItem("An Hải Tây");
					cboPhuong.addItem("Mân Thái");
					cboPhuong.addItem("Nại Hiên Đông");
					cboPhuong.addItem("Phước Mỹ");
					cboPhuong.addItem("Thọ Quang");
					break;
				case 4: 
					cboPhuong.removeAllItems();
					cboPhuong.addItem("Hòa Hải");
					cboPhuong.addItem("Hòa Quý");
					cboPhuong.addItem("Khuê Mỹ");
					cboPhuong.addItem("Mỹ An");
					break;
				case 5: 
					cboPhuong.removeAllItems();
					cboPhuong.addItem("Hòa Hiệp Bắc");
					cboPhuong.addItem("Hòa Hiệp Nam");
					cboPhuong.addItem("Hòa Khánh Bắc");
					cboPhuong.addItem("Hòa Khánh Nam");
					cboPhuong.addItem("Hòa Minh");
					break;
				case 6:
					cboPhuong.removeAllItems();
					cboPhuong.addItem("Hòa Bắc");
					cboPhuong.addItem("Hòa Châu");
					cboPhuong.addItem("Hòa Khương");
					cboPhuong.addItem("Hòa Liên");
					cboPhuong.addItem("Hòa Nhơn");
					cboPhuong.addItem("Hòa Ninh");
					cboPhuong.addItem("Hòa Phong");
					cboPhuong.addItem("Hòa Phú");
					cboPhuong.addItem("Hòa Phước");
					cboPhuong.addItem("Hòa Sơn");
					cboPhuong.addItem("Hòa Tiến");
					break;
				case 7:
					cboPhuong.removeAllItems();
					cboPhuong.addItem("Hòa An");
					cboPhuong.addItem("Hòa Phát");
					cboPhuong.addItem("Hòa Thọ Đông");
					cboPhuong.addItem("Hòa Thọ Tây");
					cboPhuong.addItem("Hòa Xuân");
					break;
				case 8:
					cboPhuong.removeAllItems();
					break;
				}
			}
		});
		
		JLabel phuong = new JLabel("  Phường");
		pnText.add(phuong);
		cboPhuong.addItem("Phường...");
		pnText.add(cboPhuong);
		
		JLabel dienThoai = new JLabel("  Điện Thoại");
		pnText.add(dienThoai);
		JTextField txtDienThoai = new JTextField(20);
		pnText.add(txtDienThoai);
		
		JLabel email = new JLabel("  Email");
		pnText.add(email);
		JTextField txtEmail = new JTextField(20);
		pnText.add(txtEmail);
		
		JLabel maSoCongTo = new JLabel("  Mã số công tơ");
		pnText.add(maSoCongTo);
		JTextField txtMaSoCongTo = new JTextField(20);
		pnText.add(txtMaSoCongTo);	
		return pnTab1;
	}
}
