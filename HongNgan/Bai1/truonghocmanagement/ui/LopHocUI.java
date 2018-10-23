package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class LopHocUI {
	ResultSet rs = null;
	Statement stmt;

	public JPanel pnLopHoc() {
		JPanel pnTab1 = new JPanel();
		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Quản Lý Lớp Học");
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(800, 800));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from lophoc");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Lớp");
		dm.addColumn("Tên Tên Lớp");

		dm.addColumn("Năm Học");

		final JTable tbl = new JTable(dm);
		try {
			while (rs.next()) {
				String maLop = rs.getString(1);
				String tenLop = rs.getString(2);
	
				String namHoc = rs.getString(3);

				Vector<String> vec = new Vector<String>();
				vec.add(maLop);
				vec.add(tenLop);
			
				vec.add(namHoc);

				dm.addRow(vec);

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

		JScrollPane sc = new JScrollPane(tbl);
		pnTab1.add(sc, BorderLayout.CENTER);
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());

		JPanel pnFilter = new JPanel();
		JPanel pnBtn = new JPanel();
		pn.add(pnBtn, BorderLayout.SOUTH);
		JButton btnAdd = new JButton("Thêm Lớp Học");
		pnBtn.add(btnAdd);

		JButton btnEdit = new JButton("Sửa Lớp Học");
		pnBtn.add(btnEdit);

		JButton btnDelete = new JButton("Xóa Lớp Học");
		pnBtn.add(btnDelete);

		pnTab1.add(pn, BorderLayout.NORTH);

		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(5, 2));
		pn1.add(pnText, BorderLayout.CENTER);

		JLabel maLop = new JLabel("  Mã Lớp  :");
		pnText.add(maLop);
		JTextField txtMaLop = new JTextField();
		pnText.add(txtMaLop);

		JLabel tenLop = new JLabel(" Tên Lớp :");
		pnText.add(tenLop);
		JTextField txtTenLop = new JTextField(20);
		pnText.add(txtTenLop);

		
		JLabel namHoc = new JLabel(" Năm Học :");
		pnText.add(namHoc);
		JTextField txtNamHoc = new JTextField(20);
		pnText.add(txtNamHoc);

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();

				String maLop = (String) tbl.getValueAt(row, 0);
				txtMaLop.setText(maLop);

				String tenLop = (String) tbl.getValueAt(row, 1);
				txtTenLop.setText(tenLop);
			

				String namHoc = (String) tbl.getValueAt(row, 2);
				txtNamHoc.setText(namHoc);

			}
		});
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String maLop1 = txtMaLop.getText();
					String tenLop1 = txtTenLop.getText();
			
					String namHoc1 = txtNamHoc.getText();

					stmt.executeUpdate("insert into lophoc values (\"" + maLop1 + "\",\"" + tenLop1 + "\",\"" + namHoc1 + "\")");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from lophoc");
					try {
						while (rs.next()) {
							String maLop = rs.getString(1);
							String tenLop = rs.getString(2);
						
							String namHoc = rs.getString(3);

							Vector<String> vec = new Vector<String>();
							vec.add(maLop);
							vec.add(tenLop);
						
							vec.add(namHoc);

							dm.addRow(vec);

						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String maLop1 = txtMaLop.getText();
					String tenLop1 = txtTenLop.getText();
				
					String namHoc1 = txtNamHoc.getText();

					stmt.executeUpdate("update lophoc set tenlop =\"" + tenLop1 + "\",namhoc=\"" + namHoc1 + "\" where malop = \"" + maLop1 + "\" ");
					JOptionPane.showMessageDialog(null, "Sửa Thành Công!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from lophoc");
					try {
						while (rs.next()) {
							String maLop = rs.getString(1);
							String tenLop = rs.getString(2);
							String namHoc = rs.getString(3);

							Vector<String> vec = new Vector<String>();
							vec.add(maLop);
							vec.add(tenLop);
					
							vec.add(namHoc);

							dm.addRow(vec);

						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});

		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String maSv = txtMaLop.getText();
					if(txtMaLop.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng lớp cần xóa");
					}else {
						int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
						if(chose == JOptionPane.YES_OPTION) {
					String maKhoa1 = txtMaLop.getText();
					

					stmt.executeUpdate("delete from lophoc WHERE malop = \"" + maKhoa1 + "\" ");
					int ret = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (ret != JOptionPane.YES_OPTION) {
						return;
					}
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from lophoc");
					try {
						while (rs.next()) {
							dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3)
									 });

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
						}}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}
		});

		return pnTab1;

	}
}
