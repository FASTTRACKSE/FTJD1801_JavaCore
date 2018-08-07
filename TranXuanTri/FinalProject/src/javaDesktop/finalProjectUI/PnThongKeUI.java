package javaDesktop.finalProjectUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PnThongKeUI {
	JPanel pnTxt = new JPanel();
	JPanel pnTxt1 = new JPanel();
	JComboBox cbo2;
	public JPanel pnThongKe() {
		JPanel pnThongKe = new JPanel();
		pnThongKe.setLayout(new BorderLayout());
		JPanel pn1 = new JPanel();
		pn1.setLayout(new GridLayout(3, 1));
		pnThongKe.add(pn1, BorderLayout.NORTH);
		Border bor2 = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titlebor2=	new TitledBorder(bor2, "Thống kê");
		pnThongKe.setBorder(titlebor2);
		pnThongKe.setPreferredSize(new Dimension(800, 800));
		JPanel pnFilter=new JPanel();
		//pnFilter.setLayout(new GridLayout(1, 3));
		pn1.add(pnFilter);
		
		JPanel _pnTxt1 = new JPanel();
		JPanel _pnTxt2 = new JPanel();
		
		JTextField msKhachHang = new JTextField(20);
		
		pnTxt.add(_pnTxt1);
		pnTxt.add(_pnTxt2);
		
		_pnTxt1.setVisible(false);
		_pnTxt2.setVisible(false);
		
		_pnTxt2.add(msKhachHang);
		JPanel pnKhuVuc = new JPanel();
		pnKhuVuc.setLayout(new GridLayout(1, 2));
		JComboBox cbo1=new JComboBox();
		cbo1.addItem("Quận...");
		cbo1.addItem("Hải Châu");
		cbo1.addItem("Thanh Khê");
		cbo1.addItem("Sơn Trà");
		cbo1.addItem("Ngũ Hành Sơn");
		cbo1.addItem("Liên Chiểu");
		cbo1.addItem("Hòa Vang");
		cbo1.addItem("Cẩm Lệ");
		cbo1.addItem("Hoàng Sa");
		cbo2 = new JComboBox();
		cbo2.addItem("Phường ...");
		cbo1.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				int i = cbo1.getSelectedIndex();
				switch (i) {
				case 0:
					cbo2.removeAllItems();
					cbo2.addItem("Phường ...");
					break;
				case 1:
					cbo2.removeAllItems();
					cbo2.addItem("Thanh Bình");
					cbo2.addItem("Thuận Phước");
					cbo2.addItem("Thạch Thang");
					cbo2.addItem("Hải Châu 1");
					cbo2.addItem("Hải Châu 2");
					cbo2.addItem("Phước Ninh");
					cbo2.addItem("Hòa Thuận Tây");
					break;
				case 2: 
					cbo2.removeAllItems();
					cbo2.addItem("An Khê");
					cbo2.addItem("Chính Gián");
					cbo2.addItem("Hòa Khê");
					cbo2.addItem("Tam Thuận");
					cbo2.addItem("Tân Chính");
					cbo2.addItem("Thạc Gián");
					cbo2.addItem("Thanh Khê Đông");
					cbo2.addItem("Thanh Khê Tây");
					cbo2.addItem("Vĩnh Trung");
					cbo2.addItem("Xuân Hà");
					break;
				case 3: 
					cbo2.removeAllItems();
					cbo2.addItem("An Hải Bắc");
					cbo2.addItem("An Hải Đông");
					cbo2.addItem("An Hải Tây");
					cbo2.addItem("Mân Thái");
					cbo2.addItem("Nại Hiên Đông");
					cbo2.addItem("Phước Mỹ");
					cbo2.addItem("Thọ Quang");
					break;
				case 4: 
					cbo2.removeAllItems();
					cbo2.addItem("Hòa Hải");
					cbo2.addItem("Hòa Quý");
					cbo2.addItem("Khuê Mỹ");
					cbo2.addItem("Mỹ An");
					break;
				case 5: 
					cbo2.removeAllItems();
					cbo2.addItem("Hòa Hiệp Bắc");
					cbo2.addItem("Hòa Hiệp Nam");
					cbo2.addItem("Hòa Khánh Bắc");
					cbo2.addItem("Hòa Khánh Nam");
					cbo2.addItem("Hòa Minh");
					break;
				case 6:
					cbo2.removeAllItems();
					cbo2.addItem("Hòa Bắc");
					cbo2.addItem("Hòa Châu");
					cbo2.addItem("Hòa Khương");
					cbo2.addItem("Hòa Liên");
					cbo2.addItem("Hòa Nhơn");
					cbo2.addItem("Hòa Ninh");
					cbo2.addItem("Hòa Phong");
					cbo2.addItem("Hòa Phú");
					cbo2.addItem("Hòa Phước");
					cbo2.addItem("Hòa Sơn");
					cbo2.addItem("Hòa Tiến");
					break;
				case 7:
					cbo2.removeAllItems();
					cbo2.addItem("Hòa An");
					cbo2.addItem("Hòa Phát");
					cbo2.addItem("Hòa Thọ Đông");
					cbo2.addItem("Hòa Thọ Tây");
					cbo2.addItem("Hòa Xuân");
					break;
				case 8:
					cbo2.removeAllItems();
					break;
				}
			}
		});
		pnKhuVuc.add(cbo1);
		pnKhuVuc.add(cbo2);
		_pnTxt1.add(pnKhuVuc);
		JLabel kh = new JLabel("Khách hàng");
		JComboBox cbo=new JComboBox();
		cbo.addItem("Khách hàng.....");
		cbo.addItem("Tất cả khách hàng");
		cbo.addItem("Theo khu vực");
		cbo.addItem("Theo mã số khách hàng");
		pnFilter.add(kh);
		pnFilter.add(cbo);
		pnFilter.add(pnTxt);
		cbo.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int n = cbo.getSelectedIndex();
				switch(n) {
				case 0:
					_pnTxt1.setVisible(false);
					_pnTxt2.setVisible(false);
					break;
				case 1:
					_pnTxt1.setVisible(false);
					_pnTxt2.setVisible(false);
					break;
				case 2:
					_pnTxt1.setVisible(true);
					_pnTxt2.setVisible(false);
					break;
				case 3:
					_pnTxt1.setVisible(false);
					_pnTxt2.setVisible(true);
					break;
				}
			}
		});
		
		JPanel pnFilter1=new JPanel();
		//pnFilter1.setLayout(new GridLayout(1, 3));
		pn1.add(pnFilter1);
		JLabel bill = new JLabel("Biên lai");
		JPanel _pnTxt3 = new JPanel();
		JPanel _pnTxt4 = new JPanel();
		JPanel _pnTxt5 = new JPanel();
		
//		JTextField ms = new JTextField(20);
		
		pnFilter1.add(bill);
		pnTxt1.add(_pnTxt3);
		pnTxt1.add(_pnTxt4);
		pnTxt1.add(_pnTxt5);
		
		JTextField year = new JTextField(10);
		_pnTxt3.add(year);
		
		JTextField month1 = new JTextField(5);
		JLabel m1 = new JLabel("/");
		JTextField year1 = new JTextField(5);
		JLabel m2 = new JLabel(" - ");
		JTextField month2 = new JTextField(5);
		JLabel m3 = new JLabel("/");
		JTextField year2 = new JTextField(5);
		_pnTxt4.add(month1);
		_pnTxt4.add(m1);
		_pnTxt4.add(year1);
		_pnTxt4.add(m2);
		_pnTxt4.add(month2);
		_pnTxt4.add(m3);
		_pnTxt4.add(year2);
		
		JTextField month3 = new JTextField(5);
		JLabel m4 = new JLabel("/");
		JTextField year4 = new JTextField(5);
		_pnTxt5.add(month3);
		_pnTxt5.add(m4);
		_pnTxt5.add(year4);
		
		
		_pnTxt3.setVisible(false);
		_pnTxt4.setVisible(false);
		_pnTxt5.setVisible(false);
//		
//		_pnTxt2.add(msKhachHang);
//		JPanel _pnFilter1 = new JPanel();
//		_pnFilter1.setLayout(new GridLayout(1, 2));
		JComboBox cbo3=new JComboBox();
		cbo3.addItem("Thời gian.....");
		cbo3.addItem("Năm:");
		cbo3.addItem("Khoảng thời gian:");
		cbo3.addItem("Kỳ:");
		pnFilter1.add(cbo3);	

		pnFilter1.add(pnTxt1);
		cbo3.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int i = cbo3.getSelectedIndex();
				switch(i) {
				case 0:
					_pnTxt3.setVisible(false);
					_pnTxt4.setVisible(false);
					_pnTxt5.setVisible(false);
					break;
				case 1:
					_pnTxt3.setVisible(true);
					_pnTxt4.setVisible(false);
					_pnTxt5.setVisible(false);
					break;
				case 2:
					_pnTxt3.setVisible(false);
					_pnTxt4.setVisible(true);
					_pnTxt5.setVisible(false);
					break;
				case 3:
					_pnTxt3.setVisible(false);
					_pnTxt4.setVisible(false);
					_pnTxt5.setVisible(true);
					break;
				}
			}
		});
		JPanel pnBtn = new JPanel();
		JButton search = new JButton("Search");
		search.setSize(30, 40);
		pnBtn.add(search);
		pn1.add(pnBtn);
		DefaultTableModel dm1 = new DefaultTableModel();
		dm1.addColumn("Mã khách hàng");
		dm1.addColumn("Mã số công tơ");
		dm1.addColumn("Họ tên");
		dm1.addColumn("Địa chỉ");
		dm1.addColumn("Phường");
		dm1.addColumn("Quận");
		dm1.addColumn("Thời gian");
		dm1.addColumn("Chu kì");
		dm1.addColumn("Chỉ số");
		dm1.addColumn("Số tiền");
		final JTable tbl1=new JTable(dm1);
		//dm.addRow(new String[]{"ID_002","25/07/2018","07/2018","0001"});
		JScrollPane sc=new JScrollPane(tbl1);
		pnThongKe.add(sc, BorderLayout.CENTER);
		return pnThongKe;
	}
}
