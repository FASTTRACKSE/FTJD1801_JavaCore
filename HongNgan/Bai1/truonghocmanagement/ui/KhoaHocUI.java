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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Dao.KhoaHocDAO;

public class KhoaHocUI {
	ResultSet rs = null;
	Statement stmt;
	JTextField txtMaKhoa = new JTextField();
	JTextField txtTenKhoa = new JTextField();
	DefaultTableModel dm = new DefaultTableModel();

	public JPanel pnKhoaHoc() {
		JPanel pnTab1 = new JPanel();

		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Quản Lý Khoa Học");
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(800, 800));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from khoa");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Khoa");
		dm.addColumn("Tên Khoa");

		final JTable tbl = new JTable(dm);
		try {
			while (rs.next()) {
				String maKhoa = rs.getString(1);
				String tenKhoa = rs.getString(2);

				Vector<String> vec = new Vector<String>();
				vec.add(maKhoa);
				vec.add(tenKhoa);

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

		JButton btnAdd = new JButton("Thêm Khoa");
		pnBtn.add(btnAdd);

		JButton btnEdit = new JButton("Sửa Khoa ");
		pnBtn.add(btnEdit);

		JButton btnDelete = new JButton("Xóa Khoa");
		pnBtn.add(btnDelete);

		pnTab1.add(pn, BorderLayout.NORTH);

		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(2, 2));
		pn1.add(pnText, BorderLayout.CENTER);

		JLabel maKhoa = new JLabel(" Mã Khoa :");
		pnText.add(maKhoa);
		txtMaKhoa = new JTextField();
		pnText.add(txtMaKhoa);

		JLabel tenKhoa = new JLabel("Tên Khoa :");
		pnText.add(tenKhoa);
		txtTenKhoa = new JTextField(20);
		pnText.add(txtTenKhoa);

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();

				String maKhoa = (String) tbl.getValueAt(row, 0);
				txtMaKhoa.setText(maKhoa);

				String tenKhoa = (String) tbl.getValueAt(row, 1);
				txtTenKhoa.setText(tenKhoa);

			}
		});

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String maKhoa1 = txtMaKhoa.getText();
					String tenKhoa1 = txtTenKhoa.getText();

					stmt.executeUpdate("insert into khoa values (\"" + maKhoa1 + "\",\"" + tenKhoa1 + "\")");
					JOptionPane.showMessageDialog(null, "thêm thanh cong!!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from khoa");
					try {
						while (rs.next()) {
							String maKhoa = rs.getString(1);
							String tenKhoa = rs.getString(2);
							Vector<String> vec = new Vector<String>();
							vec.add(maKhoa);
							vec.add(tenKhoa);

							dm.addRow(vec);

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
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
					String maKhoa1 = txtMaKhoa.getText();
					String tenKhoa1 = txtTenKhoa.getText();

					stmt.executeUpdate(
							"update khoa set tenkhoa =\"" + tenKhoa1 + "\" where makhoa = \"" + maKhoa1 + "\" ");
					JOptionPane.showMessageDialog(null, "Sua thanh cong!!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from khoa");
					try {
						while (rs.next()) {
							String maKhoa = rs.getString(1);
							String tenKhoa = rs.getString(2);
							Vector<String> vec = new Vector<String>();
							vec.add(maKhoa);
							vec.add(tenKhoa);

							dm.addRow(vec);

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
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
						String maSv = txtMaKhoa.getText();
						if(txtMaKhoa.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Vui lòng chọn khoa cần xóa");
						}else {
							int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
							if(chose == JOptionPane.YES_OPTION) {
						String maKhoa1 = txtMaKhoa.getText();
						

						stmt.executeUpdate("delete from khoa WHERE makhoa = \"" + maKhoa1 + "\" ");
						int ret = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
								JOptionPane.YES_NO_OPTION);
						if (ret != JOptionPane.YES_OPTION) {
							return;
						}
						dm.setRowCount(0);
						ResultSet rs = stmt.executeQuery("select * from makhoa");
						try {
							while (rs.next()) {
								dm.addRow(new String[] { rs.getString(1), rs.getString(2)
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