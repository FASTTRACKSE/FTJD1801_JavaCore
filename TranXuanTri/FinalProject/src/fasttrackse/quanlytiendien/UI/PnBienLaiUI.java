package fasttrackse.quanlytiendien.UI;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import fasttrackse.quanlytiendien.DAO.BienLaiDAO;

public class PnBienLaiUI {
	ResultSet rs;
	JComboBox cboMaSoCongTo;
	JTextField txtNgayNhap;
	JTextField txtThangNhap;
	JTextField txtNamNhap;
	JTextField txtThang;
	JTextField txtNam;
	JTextField txtChiSo;
	JTextField txtMaBienLai;
	public JPanel pnBienLai() {
		JPanel pnTienDien=new JPanel();
		pnTienDien.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titlebor2=	new TitledBorder(bor2, "Thông tin biên lai");
		pnTienDien.setBorder(titlebor2);
		pnTienDien.setPreferredSize(new Dimension(800, 800));
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("Mã biên lai");
		dm.addColumn("Mã khách hàng");
		dm.addColumn("Mã số công tơ");
		dm.addColumn("Thời gian");
		dm.addColumn("Chu kì nhập");
		dm.addColumn("Chỉ số ");
		dm.addColumn("Số tiền");
		final JTable tbl=new JTable(dm);
		BienLaiDAO connect = new BienLaiDAO();
		rs = connect.connect1();
		try {
			while (rs.next()) {
			dm.addRow(new String[]{rs.getString(1),null,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JScrollPane sc=new JScrollPane(tbl);
		pnTienDien.add(sc, BorderLayout.CENTER);
		tbl.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int row=tbl.getSelectedRow();
				int maCongTo = Integer.parseInt((String)tbl.getValueAt(row, 2));
				String date = (String) tbl.getValueAt(row, 3);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
				LocalDate localDate = LocalDate.parse( date , formatter );
				int year = localDate.getYear();
				int month = localDate.getMonthValue();
				int dayOfMonth = localDate.getDayOfMonth();
				String chiSo = (String)tbl.getValueAt(row, 5);
				String date1 = (String) tbl.getValueAt(row, 4);
				String maBienLai = (String) tbl.getValueAt(row, 0);
				LocalDate localDate1 = LocalDate.parse( date1 , formatter );
				int year1 = localDate1.getYear();
				int month1 = localDate1.getMonthValue();
				txtMaBienLai.setText(maBienLai);
				txtNgayNhap.setText(String.valueOf(dayOfMonth));
				txtThangNhap.setText(String.valueOf(month));
				txtNamNhap.setText(String.valueOf(year));
				txtThang.setText(String.valueOf(month1));
				txtNam.setText(String.valueOf(year1));
				txtChiSo.setText(chiSo);
				cboMaSoCongTo.setSelectedIndex(maCongTo);

			}
		});
		tbl.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {
				int row=tbl.getSelectedRow();
				int maCongTo = Integer.parseInt((String)tbl.getValueAt(row, 1));
				String date = (String) tbl.getValueAt(row, 2);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
				LocalDate localDate = LocalDate.parse( date , formatter );
				int year = localDate.getYear();
				int month = localDate.getMonthValue();
				int dayOfMonth = localDate.getDayOfMonth();
				String chiSo = (String)tbl.getValueAt(row, 4);
				String date1 = (String) tbl.getValueAt(row, 3);
				LocalDate localDate1 = LocalDate.parse( date1 , formatter );
				int year1 = localDate1.getYear();
				int month1 = localDate1.getMonthValue();
				txtNgayNhap.setText(String.valueOf(dayOfMonth));
				txtThangNhap.setText(String.valueOf(month));
				txtNamNhap.setText(String.valueOf(year));
				txtThang.setText(String.valueOf(month1));
				txtNam.setText(String.valueOf(year1));
				txtChiSo.setText(chiSo);
				cboMaSoCongTo.setSelectedIndex(maCongTo);
			}
			public void keyPressed(KeyEvent e) {}
		});
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		pnTienDien.add(pn,BorderLayout.NORTH);
		JPanel pnBtn = new JPanel();
		pn.add(pnBtn, BorderLayout.NORTH);
		JButton btnAdd = new JButton("Thêm biên lai");
		pnBtn.add(btnAdd);
		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(5, 2));
		pn1.add(pnText, BorderLayout.CENTER);
		
		JLabel maCongTo = new JLabel("  Mã công tơ điện:");
		
		cboMaSoCongTo = new JComboBox();
		cboMaSoCongTo.addItem("Mã số công tơ...");
		cboMaCongTo();
		JLabel maBienLai = new JLabel("  Mã biên lai:");
		pnText.add(maBienLai);
		txtMaBienLai = new JTextField(5);
		pnText.add(txtMaBienLai);
		pnText.add(maCongTo);
		pnText.add(cboMaSoCongTo);
		JLabel ngayNhap = new JLabel("  Ngày nhập:");
		pnText.add(ngayNhap);
		JPanel ngayNhap1 = new JPanel();
		txtNgayNhap = new JTextField(5);
		ngayNhap1.add(txtNgayNhap);
		JLabel command = new JLabel("/");
		ngayNhap1.add(command);
		txtThangNhap = new JTextField(5);
		ngayNhap1.add(txtThangNhap);
		JLabel command1 = new JLabel("/");
		ngayNhap1.add(command1);
		txtNamNhap = new JTextField(5);
		ngayNhap1.add(txtNamNhap);
		pnText.add(ngayNhap1);
		
		JLabel chuKi = new JLabel("  Chu kì nhập:");
		pnText.add(chuKi);
		JPanel chuKi1 = new JPanel();
		txtThang = new JTextField(5);
		chuKi1.add(txtThang);
		JLabel command2 = new JLabel("/");
		chuKi1.add(command2);
		txtNam = new JTextField(5);
		chuKi1.add(txtNam);
		pnText.add(chuKi1);
		JLabel chiSo = new JLabel("  Chỉ số công tơ:");
		pnText.add(chiSo);
		txtChiSo = new JTextField(15);
		pnText.add(txtChiSo);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int maCongToDien = cboMaSoCongTo.getSelectedIndex();
				int ngayNhap= Integer.parseInt(txtNgayNhap.getText());
				int thangNhap= Integer.parseInt(txtThangNhap.getText());
				int namNhap= Integer.parseInt(txtNamNhap.getText());
				int thangCK= Integer.parseInt(txtThang.getText());
				int namCK= Integer.parseInt(txtNam.getText());
				int chiSo= Integer.parseInt(txtChiSo.getText());
				String maBienLai = txtMaBienLai.getText();
				BienLaiDAO tienDien	= new BienLaiDAO();
				String thoiGianMoi = namNhap+"-"+thangNhap+"-"+ngayNhap;
				double soTien = tienDien.tinhTien(thoiGianMoi, chiSo);
				BienLaiDAO bienLai = new BienLaiDAO();
				bienLai.insert(maBienLai,maCongToDien, ngayNhap, thangNhap, namNhap, thangCK, namCK, chiSo,soTien);				
				System.out.println(soTien);
			}
		});
		return pnTienDien;
	}
	private void cboMaCongTo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlytiendien","root","");
			Statement stmt = con.createStatement();
			ResultSet rs1 = stmt.executeQuery("Select * from congtodien");
			while (rs1.next()) {
				cboMaSoCongTo.addItem(rs1.getInt(1));
			}
			con.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
