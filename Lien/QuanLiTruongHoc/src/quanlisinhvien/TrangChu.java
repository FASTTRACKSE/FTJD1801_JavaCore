package quanlisinhvien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TrangChu extends JFrame {
	JPanel pnMain = new JPanel();

	public TrangChu() {
		super("QUẢN LÍ TRƯỜNG HỌC");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pnMain.setLayout(new FlowLayout());
		
		JFrame main = new JFrame();
		main.setSize(400, 200);
		main.setLocationRelativeTo(null);
		
		JMenuBar menubar= new JMenuBar();
		setJMenuBar(menubar);
		
		JMenu tacVu = new JMenu("Tác vụ");
		JMenu baoCao = new JMenu("Báo cáo");
		JMenu inAn = new JMenu("In ấn");
		JMenu help = new JMenu("Help");
		
		menubar.add(tacVu);
		menubar.add(baoCao);
		menubar.add(inAn);
		menubar.add(help);
		
		JMenuItem mnQuanlysinhvien = new JMenuItem("Quản lý sinh viên");
		JMenuItem mnQuanlylophoc = new JMenuItem("Quản lý lớp học");
		JMenuItem mnQuanlymonhoc = new JMenuItem("Quản lý môn học");
		JMenuItem mnQuanlylophocphan = new JMenuItem("Quản lý lớp học phần");
		
		tacVu.add(mnQuanlysinhvien);
		
		JPanel pnLogo = new JPanel();
		JLabel lblLogo = new JLabel();
		pnLogo.setPreferredSize(new Dimension(585, 600));
		lblLogo.setSize(585, 600);
		pnLogo.add(lblLogo);
		main.add(pnLogo);
		try {
			BufferedImage image = ImageIO.read(new File("logo.jpg"));
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
		lblWelcome.setText("<html>YOU ARE WELCOME<br>TECHNICAL PEDAGOGICAL UNIVERSITY<br>\r\n" + 
				"energy and persistence can conquer everything</html>");
		lblWelcome.setFont(new Font(Font.SERIF, Font.ITALIC, 50));
		lblWelcome.setForeground(Color.DARK_GRAY);
		
		pnWelcome.add(lblWelcome);
		
		
		mnQuanlysinhvien.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				pnMain.repaint();
				SinhVien sv = new SinhVien();
				pnMain.add(sv);
				pnMain.validate();
			}
		});
		
		mnQuanlylophoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				pnMain.repaint();
				LopHoc lh = new LopHoc();
				pnMain.add(lh);
				pnMain.validate();
			}
		});
		
		mnQuanlymonhoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				pnMain.repaint();
				MonHoc mh = new MonHoc();
				pnMain.add(mh);
				pnMain.validate();
				
			}
		});
		
		mnQuanlylophocphan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				pnMain.removeAll();
				pnMain.repaint();
				LopHocPhan lhp = new LopHocPhan();
				pnMain.add(lhp);
				pnMain.validate();
				
			}
		});
		
		tacVu.add(mnQuanlylophoc);
		tacVu.add(mnQuanlymonhoc);
		tacVu.add(mnQuanlylophocphan);
		
		
		JMenuItem mnDanhsachsinhvien = new JMenuItem("Danh sách sinh viên");
		JMenuItem mnDanhsachlophoc = new JMenuItem("Danh sách lớp học");
		
		
		baoCao.add(mnDanhsachsinhvien);
		baoCao.add(mnDanhsachlophoc);
		
		
		Container con = getContentPane();
		con.add(pnMain);
		pnMain.add(pnLogo);
		pnMain.add(pnWelcome);

	}
public static void main(String[] args) {
	TrangChu frmMain = new TrangChu();
	frmMain.setSize(1200, 700);
	frmMain.setLocationRelativeTo(null);
	frmMain.setVisible(true);
}
}
