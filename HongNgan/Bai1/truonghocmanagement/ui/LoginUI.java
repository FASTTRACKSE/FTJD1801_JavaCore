package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class LoginUI extends JFrame {
	JTabbedPane myTabled = new JTabbedPane();
	JButton btnHSSV;
	JButton btnLH;
	JButton btnMH;
	JButton btnKH;
	JPanel jsp2 = new JPanel();

	QuanLySinhVienUI pnHSSV = new QuanLySinhVienUI();
	MonHocUI pnMH = new MonHocUI();
	LopHocUI pnLH = new LopHocUI();
	KhoaHocUI pnKH = new KhoaHocUI();
	BangDiemUI pnBD = new BangDiemUI();
	ThongKeLopHocUI pnThongKe = new ThongKeLopHocUI();
	ThongKeSinhVienUI pnThongKeSV = new ThongKeSinhVienUI();

	public LoginUI() {

		JPanel pnTab1 = new JPanel();
		JPanel pnTab2 = new JPanel();
		JPanel pnTab3 = new JPanel();
		JPanel pnTab4 = new JPanel();
		JPanel pnTab5 = new JPanel();

		myTabled.add(pnTab1, "Trang Chủ");
		myTabled.add(pnTab2, "Quản Lý");
		myTabled.add(pnTab3, "Xem Điểm");
		myTabled.add(pnTab4, "Thống Kê Lớp Học");
		myTabled.add(pnTab5, "Thống kê Sinh Viên");

		setTitle("Quản Lý Trường Học");
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		JPanel main1 = new JPanel();
		main1.setLayout(new BorderLayout());
		main.add(main1, BorderLayout.NORTH);

		JPanel main2 = new JPanel();
		main2.setLayout(new BorderLayout());
		main.add(main2, BorderLayout.CENTER);

		JPanel main3 = new JPanel();
		main3.setLayout(new BorderLayout());
		main.add(main3, BorderLayout.CENTER);

		JPanel main5 = new JPanel();
		main3.setLayout(new BorderLayout());
		main.add(main3, BorderLayout.CENTER);

		JPanel main4 = new JPanel();
		main4.setLayout(new BorderLayout());
		main.add(main4, BorderLayout.CENTER);

		JPanel jsp1 = new JPanel();
		JPanel jsp3 = new JPanel();
		JPanel jsp4 = new JPanel();
		JPanel jsp5 = new JPanel();
		JPanel jsp6 = new JPanel();

		JPanel pnLogo = new JPanel();
		JLabel lblLogo = new JLabel();
		pnLogo.setPreferredSize(new Dimension(1000, 700));
		lblLogo.setSize(1000, 700);
		pnLogo.add(lblLogo);
		main5.add(pnLogo);
		try {
			BufferedImage image = ImageIO.read(new File("logo1.jpg"));
			int x = lblLogo.getSize().width;
			int y = lblLogo.getSize().height;
			int imgX = image.getWidth();
			int imgY = image.getHeight();
			int dX = 0;
			int dY = 0;
			if (x / y > imgX / imgY) {
				dY = y;
				dX = dY * imgX / imgY;
			} else {
				dX = x;
				dY = dX * imgY / imgX;
			}
			lblLogo.setIcon(new ImageIcon(image.getScaledInstance(dX, dY, image.SCALE_SMOOTH)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.Y_AXIS));
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp1, jsp2);
		splitPane.setDividerLocation(150);

		pnTab2.add(main1);
		main1.add(splitPane, BorderLayout.CENTER);

		btnHSSV = new JButton("    Hồ Sơ Sinh Viên    ");
		jsp1.add(btnHSSV);
		jsp3.add(pnHSSV.pnKhachHang());

		jsp4.add(pnMH.pnMonHoc());
		jsp5.add(pnLH.pnLopHoc());
		jsp6.add(pnKH.pnKhoaHoc());

		jsp2.add(jsp3);
		jsp2.add(jsp4);
		jsp2.add(jsp5);
		jsp2.add(jsp6);
		jsp4.setVisible(false);
		jsp5.setVisible(false);
		jsp6.setVisible(false);
		btnHSSV.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jsp3.setVisible(true);
				jsp4.setVisible(false);
				jsp5.setVisible(false);
			}
		});

		btnMH = new JButton("          Môn Học            ");
		jsp1.add(btnMH);
		btnMH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jsp4.setVisible(true);
				jsp3.setVisible(false);
				jsp5.setVisible(false);
			}
		});

		btnLH = new JButton("   Quản lý Lớp Học    ");
		jsp1.add(btnLH);
		btnLH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jsp5.setVisible(true);
				jsp3.setVisible(false);
				jsp4.setVisible(false);

			}
		});

		btnKH = new JButton("          Khoa Học          ");
		jsp1.add(btnKH);
		btnKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jsp6.setVisible(true);
				jsp3.setVisible(false);
				jsp5.setVisible(false);
			}
		});
		pnTab5.add(pnThongKeSV.pnThongKeSinhVien());
		pnTab4.add(pnThongKe.pnThongKe());
		pnTab3.add(pnBD.pnBangDiem());
		pnTab3.add(main2);
		pnTab2.add(main1);
		pnTab4.add(main3);
		pnTab5.add(main4);
		pnTab1.add(main5);
		main.add(myTabled);
		Container con = getContentPane();
		con.add(main);

	}

	public void showWindow() {

		this.setSize(1000, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
