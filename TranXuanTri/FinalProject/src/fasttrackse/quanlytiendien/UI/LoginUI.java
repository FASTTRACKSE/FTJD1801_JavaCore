package fasttrackse.quanlytiendien.UI;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		JPanel jsp5 = new JPanel();

		jsp1.setLayout(new BoxLayout(jsp1, BoxLayout.Y_AXIS));
//		jsp1.setLayout(new GridLayout(12, 1));

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jsp1, jsp2);
		splitPane.setDividerLocation(170);
		main.add(splitPane, BorderLayout.CENTER);

		btnKhachHang = new JButton("Quản lý khách hàng");
		Color blue = Color.decode("#9bcfef");
		Color orange = Color.decode("#683f07");
		Color green = Color.decode("#2c562e");
		btnKhachHang.setBackground(blue);
		btnKhachHang.setForeground(green);
		btnKhachHang.setFont(new Font("Arial", Font.BOLD, 14));
		btnKhachHang.setMargin(new Insets(5, 5, 5, 5));
		jsp1.add(btnKhachHang);
		
		jsp3.add(pnKhach.pnKhachHang());
		jsp4.add(pnBienLai.pnBienLai());
		jsp5.add(pnThongKe.pnThongKe());
		jsp2.add(jsp3);
		jsp2.add(jsp4);
		jsp2.add(jsp5);
		jsp4.setVisible(false);
		jsp5.setVisible(false);

		btnKhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jsp3.setVisible(true);
				jsp4.setVisible(false);
				jsp5.setVisible(false);
			}
		});

		btnBienLai = new JButton("Quản lý biên lai");
		btnBienLai.setBackground(blue);
		btnBienLai.setForeground(orange);
		btnBienLai.setFont(new Font("Arial", Font.BOLD, 14));
		btnBienLai.setMargin(new Insets(5, 5, 5, 5));
		jsp1.add(btnBienLai);
		btnBienLai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jsp4.setVisible(true);
				jsp3.setVisible(false);
				jsp5.setVisible(false);
			}
		});

		btnThongKe = new JButton("Thống kê báo cáo");
		jsp1.add(btnThongKe);
		btnThongKe.setBackground(blue);
		btnThongKe.setForeground(Color.DARK_GRAY);
		btnThongKe.setFont(new Font("Arial", Font.BOLD, 14));
		btnThongKe.setMargin(new Insets(5, 5, 5, 5));
		btnThongKe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jsp5.setVisible(true);
				jsp3.setVisible(false);
				jsp4.setVisible(false);
			}
		});
		btnKhachHang.setPreferredSize(new Dimension(160, 40));
		btnKhachHang.setMinimumSize(new Dimension(150, 40));
		btnKhachHang.setMaximumSize(new Dimension(160, 40));
		btnBienLai.setPreferredSize(new Dimension(160, 40));
		btnBienLai.setMinimumSize(new Dimension(150, 40));
		btnBienLai.setMaximumSize(new Dimension(160, 40));
		btnThongKe.setPreferredSize(new Dimension(160, 40));
		btnThongKe.setMinimumSize(new Dimension(150, 40));
		btnThongKe.setMaximumSize(new Dimension(160, 40));

		Container con = getContentPane();
		con.add(main);
	}

	public void showWindow() {
		setSize(1200, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
