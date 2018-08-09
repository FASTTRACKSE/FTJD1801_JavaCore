package fasttrackse.quanlytiendien.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PnBienLaiUI {

	public JPanel pnBienLai() {
		
		JPanel pnTienDien=new JPanel();
		pnTienDien.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.GRAY);
		TitledBorder titlebor2=	new TitledBorder(bor2, "Thông tin biên lai");
		pnTienDien.setBorder(titlebor2);
		pnTienDien.setPreferredSize(new Dimension(800, 800));
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("Mã khách hàng");
		dm.addColumn("Mã số công tơ");
		dm.addColumn("Họ tên");
		dm.addColumn("Địa chỉ");
		dm.addColumn("Phường");
		dm.addColumn("Quận");
		dm.addColumn("Thời gian");
		dm.addColumn("Chỉ số ");
		final JTable tbl=new JTable(dm);
		//dm.addRow(new String[]{"ID_002","25/07/2018","07/2018","0001"});
		JScrollPane sc=new JScrollPane(tbl);
		pnTienDien.add(sc, BorderLayout.CENTER);

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
		pnText.setLayout(new GridLayout(4, 2));
		pn1.add(pnText, BorderLayout.CENTER);
		
		JLabel maCongTo = new JLabel("  Mã công tơ điện:");
		pnText.add(maCongTo);
		JComboBox<String> cbo = new JComboBox<String>();
		cbo.addItem("Mã số công tơ...");
		pnText.add(cbo);
		JLabel ngayNhap = new JLabel("  Ngày nhập:");
		pnText.add(ngayNhap);
		JPanel ngayNhap1 = new JPanel();
		JTextField txtNgayNhap = new JTextField(5);
		ngayNhap1.add(txtNgayNhap);
		JLabel command = new JLabel("/");
		ngayNhap1.add(command);
		JTextField txtThangNhap = new JTextField(5);
		ngayNhap1.add(txtThangNhap);
		JLabel command1 = new JLabel("/");
		ngayNhap1.add(command1);
		JTextField txtNamNhap = new JTextField(5);
		ngayNhap1.add(txtNamNhap);
		pnText.add(ngayNhap1);
		
		JLabel chuKi = new JLabel("  Chu kì nhập:");
		pnText.add(chuKi);
		JPanel chuKi1 = new JPanel();
		JTextField txtThang = new JTextField(5);
		chuKi1.add(txtThang);
		JLabel command2 = new JLabel("/");
		chuKi1.add(command2);
		JTextField txtNam = new JTextField(5);
		chuKi1.add(txtNam);
		pnText.add(chuKi1);
		JLabel chiSo = new JLabel("  Chỉ số công tơ:");
		pnText.add(chiSo);
		JTextField txtChiSo = new JTextField(15);
		pnText.add(txtChiSo);
		return pnTienDien;
	}
}
