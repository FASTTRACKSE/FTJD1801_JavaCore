package quanlisinhvien;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class LopHoc extends JPanel {
	ResultSet rs = null;
	Statement stmt;

	public LopHoc() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/quanlitruonghoc?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = (Statement) con.createStatement();
			rs = stmt.executeQuery("SELECT * from lophoc");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		Font fontOne = new Font(Font.SERIF, Font.ITALIC, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(2, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã lớp học");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnThree = new JPanel();
		pnThree.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Tên lớp học");
		JTextField txtName = new JTextField(15);
		lblName.setFont(fontOne);
		txtName.setFont(fontOne);
		grTop.add(lblName);
		pnThree.add(txtName);
		grTop.add(pnThree);

		JPanel pnFour = new JPanel();
		pnFour.setLayout(new FlowLayout());
		JLabel lblYear = new JLabel("Năm học");
		JTextField txtYear = new JTextField(15);
		lblYear.setFont(fontOne);
		txtYear.setFont(fontOne);
		grTop.add(lblYear);
		pnFour.add(txtYear);
		grTop.add(pnFour);

		JPanel pnNull = new JPanel();
		grTop.add(pnNull);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JButton btnSave = new JButton("Thêm");
		btnSave.setFont(fontOne);
		pnCenter.add(btnSave);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(fontOne);
		pnCenter.add(btnUpdate);

		JButton btnRemove = new JButton("Xóa");
		btnRemove.setFont(fontOne);
		pnCenter.add(btnRemove);

		JLabel lblType = new JLabel("Tìm kiếm");
		lblType.setFont(fontOne);
		pnCenter.add(lblType);
		JComboBox cbbType = new JComboBox();
		cbbType.addItem("Mã lớp học");
		cbbType.addItem("Tên lớp học");
		cbbType.setFont(fontOne);
		cbbType.setPreferredSize(new Dimension(200, 30));
		pnCenter.add(cbbType);

		JLabel lblValue = new JLabel("Mời nhập: ");
		pnCenter.add(lblValue);
		lblValue.setFont(fontOne);
		JTextField txtValue = new JTextField(15);
		txtValue.setFont(fontOne);
		pnCenter.add(txtValue);

		JButton btnSearch = new JButton("Tìm kiếm");
		btnSearch.setFont(fontOne);
		pnCenter.add(btnSearch);

		JPanel pnTable = new JPanel();
		pnTable.setLayout(new FlowLayout());
		DefaultTableModel tblSinhVien = new DefaultTableModel();
		tblSinhVien.addColumn("Mã lớp học");
		tblSinhVien.addColumn("Tên lớp học");
		tblSinhVien.addColumn("Năm học");

		final JTable tbl = new JTable(tblSinhVien);
		try {
			while (rs.next()) {
				String maLH = rs.getString(1);
				String tenLH = rs.getString(2);
				String namHoc = rs.getString(3);

				Vector<String> vec = new Vector<String>();
				vec.add(maLH);
				vec.add(tenLH);
				vec.add(namHoc);

				tblSinhVien.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Quản lí lớp học");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 300));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				String maLH = (String) tbl.getValueAt(row, 0);
				txtID.setText(maLH);

				String tenLH = (String) tbl.getValueAt(row, 1);
				txtName.setText(tenLH);

				String namHoc = (String) tbl.getValueAt(row, 2);
				txtYear.setText(namHoc);

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into lophoc values(\'" + txtID.getText() + "\',\'" + txtName.getText()
							+ "\',\'" + txtYear.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblSinhVien.setRowCount(0);
					rs = stmt.executeQuery("Select * from lophoc");

					while (rs.next()) {
						String maLH = rs.getString(1);
						String tenLH = rs.getString(2);
						String namHoc = rs.getString(3);

						Vector<String> vec = new Vector<String>();
						vec.add(maLH);
						vec.add(tenLH);
						vec.add(namHoc);

						tblSinhVien.addRow(vec);
					}
					tbl.setModel(tblSinhVien);
					tblSinhVien.fireTableDataChanged();

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		});

		btnUpdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.executeUpdate("update lophoc set tenLH = \'" + txtName.getText() + "\', namHoc = \'"
							+ txtYear.getText() + "\' where maLH = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblSinhVien.setRowCount(0);
					rs = stmt.executeQuery("Select * from lophoc");

					while (rs.next()) {
						String maLH = rs.getString(1);
						String tenLH = rs.getString(2);
						String namHoc = rs.getString(3);

						Vector<String> vec = new Vector<String>();
						vec.add(maLH);
						vec.add(tenLH);
						vec.add(namHoc);

						tblSinhVien.addRow(vec);
					}
					tbl.setModel(tblSinhVien);
					tblSinhVien.fireTableDataChanged();

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		});

		btnRemove.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dialogResult = JOptionPane.showConfirmDialog(null,
						"Thao tác sẽ xóa lớp học của sinh viên thuộc lớp học này!", "Xem cho kỹ", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						
						stmt.execute("delete from lophoc where maLH = \'" + txtID.getText() + "\'");
						JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
						tblSinhVien.setRowCount(0);
						rs = stmt.executeQuery("Select * from lophoc");

						while (rs.next()) {
							String maLH = rs.getString(1);
							String tenLH = rs.getString(2);
							String namHoc = rs.getString(3);

							Vector<String> vec = new Vector<String>();
							vec.add(maLH);
							vec.add(tenLH);
							vec.add(namHoc);

							tblSinhVien.addRow(vec);
						}
						tbl.setModel(tblSinhVien);
						tblSinhVien.fireTableDataChanged();

					} catch (Exception ex) {
						// TODO: handle exception
						System.err.println(ex);
					}
				}
			}
		});

		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// TODO Auto-generated method stub
					int index = cbbType.getSelectedIndex();
					if (txtValue.getText().equals("")) {
						tblSinhVien.setRowCount(0);
						rs = stmt.executeQuery("Select * from lophoc");

						while (rs.next()) {
							String maLH = rs.getString(1);
							String tenLH = rs.getString(2);
							String namHoc = rs.getString(3);

							Vector<String> vec = new Vector<String>();
							vec.add(maLH);
							vec.add(tenLH);
							vec.add(namHoc);

							tblSinhVien.addRow(vec);
						}
						tbl.setModel(tblSinhVien);
						tblSinhVien.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblSinhVien.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from lophoc where maLH like \'%" + txtValue.getText() + "%\'");

							while (rs.next()) {
								String maLH = rs.getString(1);
								String tenLH = rs.getString(2);
								String namHoc = rs.getString(3);

								Vector<String> vec = new Vector<String>();
								vec.add(maLH);
								vec.add(tenLH);
								vec.add(namHoc);

								tblSinhVien.addRow(vec);
							}
							tbl.setModel(tblSinhVien);
							tblSinhVien.fireTableDataChanged();

						} else if (index == 1) {
							tblSinhVien.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from lophoc where tenLH like \'%" + txtValue.getText() + "%\'");

							while (rs.next()) {
								String maLH = rs.getString(1);
								String tenLH = rs.getString(2);
								String namHoc = rs.getString(3);

								Vector<String> vec = new Vector<String>();
								vec.add(maLH);
								vec.add(tenLH);
								vec.add(namHoc);

								tblSinhVien.addRow(vec);
							}
							tbl.setModel(tblSinhVien);
							tblSinhVien.fireTableDataChanged();

						}
					}
				} catch (Exception e2) {
					System.err.println(e2);
				}
			}
		});

		add(grTop);
		add(pnCenter);
		add(pnTable);
	}

}
