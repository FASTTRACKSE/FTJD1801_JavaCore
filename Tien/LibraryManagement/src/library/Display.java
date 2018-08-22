package library;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Display extends JFrame {
	JPanel main = new JPanel();

	public Display() {
		super("QUẢN LÝ THƯ VIỆN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		main.setLayout(new FlowLayout());

		JFrame frmMain = new JFrame();
		frmMain.setSize(400, 200);
		frmMain.setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();

		setJMenuBar(menuBar);

		JMenu mnQuanLy = new JMenu("Quản lý");
		JMenu mnBaoCao = new JMenu("Báo cáo & Thống kê");
		JMenu mnHelp = new JMenu("Help");

		menuBar.add(mnQuanLy);
		menuBar.add(mnBaoCao);
		menuBar.add(mnHelp);

		JMenuItem mnQLBanDoc = new JMenuItem("Bạn đọc");
		JMenuItem mnQLSach = new JMenuItem("Sách");
		JMenuItem mnQLPhieuMT = new JMenuItem("Phiếu mượn trả");
		JMenuItem mnQLChiTietMT = new JMenuItem("Chi tiết mượn trả");
		JMenuItem mnQLTacGia = new JMenuItem("Tác giả");
		JMenuItem mnQLNhaXuatBan = new JMenuItem("Nhà xuất bản");
		JMenuItem mnQLTheLoai = new JMenuItem("Thể loại");
		JMenuItem mnExit = new JMenuItem("Exit");

		mnQuanLy.add(mnQLBanDoc);
		mnQuanLy.add(mnQLSach);
		mnQuanLy.add(mnQLPhieuMT);
		mnQuanLy.add(mnQLChiTietMT);
		mnQuanLy.add(mnQLTacGia);
		mnQuanLy.add(mnQLNhaXuatBan);
		mnQuanLy.add(mnQLTheLoai);
		mnQuanLy.addSeparator();
		mnQuanLy.add(mnExit);

		JMenuItem mnBaoCaoDS = new JMenuItem("Danh sách bạn đọc");
		JMenuItem mnBaoCaoTK = new JMenuItem("Thống kê đầu sách");

		mnBaoCao.add(mnBaoCaoDS);
		mnBaoCao.add(mnBaoCaoTK);
		
		JPanel pnLogo = new JPanel();
		JLabel lblLogo = new JLabel();
		pnLogo.setPreferredSize(new Dimension(585, 600));
		lblLogo.setSize(585, 600);
		pnLogo.add(lblLogo);
		main.add(pnLogo);
		try {
			BufferedImage image = ImageIO.read(new File("WISCONSIN.png"));
			int x = lblLogo.getSize().width;
			int y = lblLogo.getSize().height;
			int imgX = image.getWidth();
			int imgY = image.getHeight();
			int dX = 0;
			int dY = 0;
			if(x / y > imgX / imgY) {
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
		
		JPanel pnWelcome = new JPanel();
		pnWelcome.setLayout(new FlowLayout());
		pnWelcome.setPreferredSize(new Dimension(585, 200));
		main.add(pnWelcome);
		
		JLabel lblWelcome = new JLabel();
		lblWelcome.setText("<html>YOU ARE WELCOME<br>WISCONSIN'S DIGITAL<br>LIBRARY");
		lblWelcome.setFont(new Font(Font.SERIF, Font.ITALIC, 50));
		lblWelcome.setForeground(Color.DARK_GRAY);
		
		pnWelcome.add(lblWelcome);
		
		mnQLBanDoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.removeAll();
				main.repaint();
				PanelQuanLyBanDoc pnBanDoc = new PanelQuanLyBanDoc();
				main.add(pnBanDoc);
				main.validate();
			}
		});
		
		mnQLTacGia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.removeAll();
				main.repaint();
				PanelQuanLyTacGia pnTacGia = new PanelQuanLyTacGia();
				main.add(pnTacGia);
				main.validate();
			}
		});
		
		mnQLNhaXuatBan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.removeAll();
				main.repaint();
				PanelQuanLyNXB pnNXB = new PanelQuanLyNXB();
				main.add(pnNXB);
				main.validate();
			}
		});
		
		mnQLTheLoai.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.removeAll();
				main.repaint();
				PanelQuanLyTheLoai pnTheLoai = new PanelQuanLyTheLoai();
				main.add(pnTheLoai);
				main.validate();
			}
		});
		
		mnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				main.removeAll();
				main.repaint();
				main.add(pnLogo);
				main.add(pnWelcome);
				main.validate();
			}
		});

		Container conr = getContentPane();
		conr.add(main);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display mainFrame = new Display();
		mainFrame.setSize(1200, 700);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
}
