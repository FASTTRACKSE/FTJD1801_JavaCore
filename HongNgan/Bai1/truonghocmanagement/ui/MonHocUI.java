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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MonHocUI extends JFrame {
	ResultSet rs = null;
	Statement stmt;

	public JPanel pnMonHoc() {
		JPanel pnTab1 = new JPanel();
		pnTab1.setLayout(new BorderLayout());
		Border bor2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Quản Lý Môn Học");
		pnTab1.setBorder(titlebor2);
		pnTab1.setPreferredSize(new Dimension(800, 800));

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/qlsinhvien?useUnicode=true&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from monhoc");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Mã Môn Học");
		dm.addColumn("Tên Môn Học");
		dm.addColumn("Số Tín Chỉ");
		dm.addColumn("Thời Lượng Học");
		dm.addColumn("Mã Khoa");

		final JTable tbl = new JTable(dm);
		try {
			while (rs.next()) {
				String mamonhoc = rs.getString(1);
				String tenmonhoc = rs.getString(2);
				String sotinchi = rs.getString(3);
				String thoiluonghoc = rs.getString(4);
				String makhoa = rs.getString(5);

				Vector<String> vec = new Vector<String>();
				vec.add(mamonhoc);
				vec.add(tenmonhoc);
				vec.add(sotinchi);
				vec.add(thoiluonghoc);
				vec.add(makhoa);

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

		JButton btnAdd = new JButton("Thêm Môn Học");
		pnBtn.add(btnAdd);

		JButton btnEdit = new JButton("Sửa Môn Học");
		pnBtn.add(btnEdit);

		JButton btnDelete = new JButton("Xóa Môn Học");
		pnBtn.add(btnDelete);

		pnTab1.add(pn, BorderLayout.NORTH);

		JPanel pn1 = new JPanel();
		pn.add(pn1, BorderLayout.CENTER);
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(5, 2));
		pn1.add(pnText, BorderLayout.CENTER);

		JLabel maMH = new JLabel("  Mã Môn Học  :");
		pnText.add(maMH);
		JTextField txtMaMH = new JTextField();
		pnText.add(txtMaMH);

		JLabel tenMH = new JLabel(" Tên Môn Học :");
		pnText.add(tenMH);
		JTextField txtTenMH = new JTextField(20);
		pnText.add(txtTenMH);

		JLabel soTinChi = new JLabel(" Số Tín Chỉ :");
		pnText.add(soTinChi);
		JTextField txtSoTinChi = new JTextField(20);
		pnText.add(txtSoTinChi);

		JLabel thoiLH = new JLabel(" Thời Lượng Học :");
		pnText.add(thoiLH);
		JTextField txtThoiLH = new JTextField(20);
		pnText.add(txtThoiLH);

		JLabel maKhoa = new JLabel("  Mã Khoa   :");
		pnText.add(maKhoa);
		JComboBox cboMaKhoa = new JComboBox();
		pnText.add(cboMaKhoa);
		try {

			rs = stmt.executeQuery("select * from khoa");
			while (rs.next()) {
				cboMaKhoa.addItem(rs.getString(1));
				String strMyString = (String) cboMaKhoa.getSelectedItem();
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}

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

				String maMonHoc = (String) tbl.getValueAt(row, 0);
				txtMaMH.setText(maMonHoc);

				String tenMonHoc = (String) tbl.getValueAt(row, 1);
				txtTenMH.setText(tenMonHoc);
				String soTinChi = (String) tbl.getValueAt(row, 2);
				txtSoTinChi.setText(soTinChi);

				String thoiLuongHoc = (String) tbl.getValueAt(row, 3);
				txtThoiLH.setText(thoiLuongHoc);

				String maKhoa = (String) tbl.getValueAt(row, 4);
				cboMaKhoa.setSelectedItem(maKhoa);

			}
		});
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String maMH1 = txtMaMH.getText();
					String tenMon1 = txtTenMH.getText();
					String soTinChi1 = txtSoTinChi.getText();
					String thoiLuongHoc1 = txtThoiLH.getText();
					String maKhoa1 = (String) cboMaKhoa.getItemAt(cboMaKhoa.getSelectedIndex());

					stmt.executeUpdate("insert into monhoc values (\"" + maMH1 + "\",\"" + tenMon1 + "\",\"" + soTinChi1
							+ "\",\"" + thoiLuongHoc1 + "\",\"" + maKhoa1 + "\")");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from monhoc");
					try {
						while (rs.next()) {
							String mamonhoc = rs.getString(1);
							String tenmonhoc = rs.getString(2);
							String sotinchi = rs.getString(3);
							String thoiluonghoc = rs.getString(4);
							String makhoa = rs.getString(5);

							Vector<String> vec = new Vector<String>();
							vec.add(mamonhoc);
							vec.add(tenmonhoc);
							vec.add(sotinchi);
							vec.add(thoiluonghoc);
							vec.add(makhoa);

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
					String maMH1 = txtMaMH.getText();
					String tenMon1 = txtTenMH.getText();
					String soTinChi1 = txtSoTinChi.getText();
					String thoiLuongHoc1 = txtThoiLH.getText();
					String maKhoa1 = (String) cboMaKhoa.getItemAt(cboMaKhoa.getSelectedIndex());

					stmt.executeUpdate("update monhoc set tenmon =\"" + tenMon1 + "\",sotinchi=\"" + soTinChi1
							+ "\",thoiluonghoc=\"" + thoiLuongHoc1 + "\" where mamonhoc = \"" + maMH1 + "\" ");
					JOptionPane.showMessageDialog(null, "Sửa Thành Công!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from monhoc");
					try {
						while (rs.next()) {
							String mamonhoc = rs.getString(1);
							String tenmonhoc = rs.getString(2);
							String sotinchi = rs.getString(3);
							String thoiluonghoc = rs.getString(4);
							String makhoa = rs.getString(5);

							Vector<String> vec = new Vector<String>();
							vec.add(mamonhoc);
							vec.add(tenmonhoc);
							vec.add(sotinchi);
							vec.add(thoiluonghoc);
							vec.add(makhoa);

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
					String maSv = txtMaMH.getText();
					if (txtMaMH.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng chọn Môn Học cần xóa");
					} else {
						int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa",
								JOptionPane.YES_NO_OPTION);
						if (chose == JOptionPane.YES_OPTION) {
							String maKhoa1 = txtMaMH.getText();

							stmt.executeUpdate("delete from monhoc WHERE mamonhoc = \"" + maKhoa1 + "\" ");
							int ret = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
									JOptionPane.YES_NO_OPTION);
							if (ret != JOptionPane.YES_OPTION) {
								return;
							}
							dm.setRowCount(0);
							ResultSet rs = stmt.executeQuery("select * from monhoc");
							try {
								while (rs.next()) {
									dm.addRow(new String[] { rs.getString(1), rs.getString(2), rs.getString(3),
											rs.getString(4), rs.getString(5) });

								}
							} catch (Exception ex1) {
								ex1.printStackTrace();
							}
							tbl.setModel(dm);
							dm.fireTableDataChanged();
						}
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}

			}

		});

		return pnTab1;

	}

}
