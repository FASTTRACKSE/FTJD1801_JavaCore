package javaDesktop.finalProjectUI;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
	JButton btnKhachHang;
	JButton btnBienLai;
	JButton btnThongKe;
	
	JPanel jsp2 = new JPanel();
	PnKhachHangUI pnKhach = new PnKhachHangUI();
	PnBienLaiUI pnBienLai = new PnBienLaiUI();
	PnThongKeUI pnThongKe = new PnThongKeUI();
	public LoginUI() {
		setTitle("Quản Lý Tiền Điện");
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		JPanel jsp1 = new JPanel();
		JPanel jsp3 = new JPanel();
		JPanel jsp4 = new JPanel();
		JPanel jsp5	= new JPanel();
		
		jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.Y_AXIS));
		//jsp2.setLayout(new FlowLayout());
		//jsp2.setLayout(new BorderLayout());

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp1, jsp2);
		splitPane.setDividerLocation(150);
		main.add(splitPane, BorderLayout.CENTER);

		btnKhachHang = new JButton("Quản lý khách hàng");
		jsp1.add(btnKhachHang);
		// jsp2.add(pnKhach.pnKhachHang(),BorderLayout.CENTER);
		
		jsp3.add(pnKhach.pnKhachHang());
		jsp4.add(pnBienLai.pnBienLai());
		jsp5.add(pnThongKe.pnThongKe());
		jsp2.add(jsp3);
		jsp2.add(jsp4);
		jsp2.add(jsp5);
		//jsp3.setMaximumSize(jsp2.getPreferredSize());
		//jsp4.setMaximumSize(jsp2.getPreferredSize());
		jsp4.setVisible(false);
		jsp5.setVisible(false);
		//jsp3.setVisible(false);
		//jsp2.add(pnKhach.pnKhachHang());
		
		

		btnKhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jsp3.setVisible(true);
				jsp4.setVisible(false);
				jsp5.setVisible(false);
//				 pnBienLai.pnBienLai().setVisible(false);
//				 pnKhach.pnKhachHang().setVisible(true);
				// jsp2.add(pnKhach.pnKhachHang(),BorderLayout.CENTER);
			}
		});

		btnBienLai = new JButton("Quản lý biên lai");
		jsp1.add(btnBienLai);
		btnBienLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//jsp2.removeAll();
				jsp4.setVisible(true);
				jsp3.setVisible(false);
				jsp5.setVisible(false);
				
//				 pnKhach.PnKhachHangUI().setVisible(false);
//				 pnBienLai.pnBienLai().setVisible(true);
				// jsp2.add(pnBienLai.pnBienLai(),BorderLayout.CENTER);
			}
		});

		btnThongKe = new JButton("Thống kê báo cáo");
		jsp1.add(btnThongKe);
		btnThongKe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jsp5.setVisible(true);
				jsp3.setVisible(false);
				jsp4.setVisible(false);
			}
		});

		Container con = getContentPane();
		con.add(main);
	}

	public void showWindow() {
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
