package library;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

public class PanelQuanLyTacGia extends JPanel {
	ResultSet rs = null;
	Statement stmt;

	public PanelQuanLyTacGia() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from tacgia");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(2, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã tác giả");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnTwo = new JPanel();
		pnTwo.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Tên tác giả");
		JTextField txtName = new JTextField(15);
		lblName.setFont(fontOne);
		txtName.setFont(fontOne);
		grTop.add(lblName);
		pnTwo.add(txtName);
		grTop.add(pnTwo);

		JPanel pnThree = new JPanel();
		pnThree.setLayout(new FlowLayout());
		JLabel lblYear = new JLabel("Niên đại");
		JTextField txtYear = new JTextField(15);
		lblYear.setFont(fontOne);
		txtYear.setFont(fontOne);
		grTop.add(lblYear);
		pnThree.add(txtYear);
		grTop.add(pnThree);

		JPanel pnNull = new JPanel();
		grTop.add(pnNull);

		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new FlowLayout());

		JButton btnAdd = new JButton("Thêm");
		btnAdd.setFont(fontOne);
		pnCenter.add(btnAdd);

		JButton btnSave = new JButton("Lưu");
		btnSave.setFont(fontOne);
		pnCenter.add(btnSave);

		JButton btnUpdate = new JButton("Sửa");
		btnUpdate.setFont(fontOne);
		pnCenter.add(btnUpdate);

		JButton btnRemove = new JButton("Xóa");
		btnRemove.setFont(fontOne);
		pnCenter.add(btnRemove);

		JLabel lblType = new JLabel("Tìm theo");
		lblType.setFont(fontOne);
		pnCenter.add(lblType);
		JComboBox cbbType = new JComboBox();
		cbbType.addItem("Mã tác giả");
		cbbType.addItem("Tên tác giả");

		cbbType.setFont(fontOne);
		cbbType.setPreferredSize(new Dimension(200, 30));
		pnCenter.add(cbbType);

		JLabel lblValue = new JLabel("Dữ liệu: ");
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
		DefaultTableModel tblTacGia = new DefaultTableModel();
		tblTacGia.addColumn("Mã tác giả");
		tblTacGia.addColumn("Tên tác giả");
		tblTacGia.addColumn("Niên đại");

		final JTable tbl = new JTable(tblTacGia);
		try {
			while (rs.next()) {
				String maTacGia = rs.getString(1);
				String tenTacGia = rs.getString(2);
				String nienDai = rs.getString(3);
				Vector<String> vec = new Vector<String>();
				vec.add(maTacGia);
				vec.add(tenTacGia);
				vec.add(nienDai);
				tblTacGia.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách tác giả");

		tbl.setFont(fontOne);
		tbl.setPreferredScrollableViewportSize(new Dimension(1100, 400));
		JScrollPane sc = new JScrollPane(tbl);
		sc.setViewportView(tbl);
		pnTable.add(sc);
		pnTable.setBorder(borderTitle);

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();
				String id = (String) tbl.getValueAt(row, 0);
				txtID.setText(id);

				String name = (String) tbl.getValueAt(row, 1);
				txtName.setText(name);

				String year = (String) tbl.getValueAt(row, 2);
				txtYear.setText(year);
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

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				txtID.setText("");
				txtName.setText("");
				txtYear.setText("");
			}
		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into tacgia values(\'" + txtID.getText() + "\',\'" + txtName.getText()
							+ "\',\'" + txtYear.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblTacGia.setRowCount(0);
					rs = stmt.executeQuery("Select * from tacgia");

					while (rs.next()) {
						String maTacGia = rs.getString(1);
						String tenTacGia = rs.getString(2);
						String nienDai = rs.getString(3);
						Vector<String> vec = new Vector<String>();
						vec.add(maTacGia);
						vec.add(tenTacGia);
						vec.add(nienDai);
						tblTacGia.addRow(vec);
					}
					tbl.setModel(tblTacGia);
					tblTacGia.fireTableDataChanged();

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
					stmt.executeUpdate("update tacgia set TenTacGia = \'" + txtName.getText() + "\', NienDai = \'"
							+ txtYear.getText() + "\' where MaTacGia = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblTacGia.setRowCount(0);
					rs = stmt.executeQuery("Select * from tacgia");

					while (rs.next()) {
						String maTacGia = rs.getString(1);
						String tenTacGia = rs.getString(2);
						String nienDai = rs.getString(3);
						Vector<String> vec = new Vector<String>();
						vec.add(maTacGia);
						vec.add(tenTacGia);
						vec.add(nienDai);
						tblTacGia.addRow(vec);
					}
					tbl.setModel(tblTacGia);
					tblTacGia.fireTableDataChanged();

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
						"Thao tác này sẽ xóa dữ liệu của bảng sách với cùng tác giả!!!", "Cảnh báo",
						JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						stmt.execute("delete from sach where MaTacGia = \'" + txtID.getText() + "\'");
						stmt.execute("delete from tacgia where MaTacGia = \'" + txtID.getText() + "\'");
						JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
						tblTacGia.setRowCount(0);
						rs = stmt.executeQuery("Select * from tacgia");

						while (rs.next()) {
							String maTacGia = rs.getString(1);
							String tenTacGia = rs.getString(2);
							String nienDai = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(maTacGia);
							vec.add(tenTacGia);
							vec.add(nienDai);
							tblTacGia.addRow(vec);
						}
						tbl.setModel(tblTacGia);
						tblTacGia.fireTableDataChanged();

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
						tblTacGia.setRowCount(0);
						rs = stmt.executeQuery("Select * from tacgia");

						while (rs.next()) {
							String maTacGia = rs.getString(1);
							String tenTacGia = rs.getString(2);
							String nienDai = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(maTacGia);
							vec.add(tenTacGia);
							vec.add(nienDai);
							tblTacGia.addRow(vec);
						}
						tbl.setModel(tblTacGia);
						tblTacGia.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblTacGia.setRowCount(0);
							rs = stmt.executeQuery("Select * from tacgia where MaTacGia = " + txtValue.getText() + "");

							while (rs.next()) {
								String maTacGia = rs.getString(1);
								String tenTacGia = rs.getString(2);
								String nienDai = rs.getString(3);
								Vector<String> vec = new Vector<String>();
								vec.add(maTacGia);
								vec.add(tenTacGia);
								vec.add(nienDai);
								tblTacGia.addRow(vec);
							}
							tbl.setModel(tblTacGia);
							tblTacGia.fireTableDataChanged();

						} else if (index == 1) {
							tblTacGia.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from tacgia where TenTacGia = \'" + txtValue.getText() + "\'");

							while (rs.next()) {
								String maTacGia = rs.getString(1);
								String tenTacGia = rs.getString(2);
								String nienDai = rs.getString(3);
								Vector<String> vec = new Vector<String>();
								vec.add(maTacGia);
								vec.add(tenTacGia);
								vec.add(nienDai);
								tblTacGia.addRow(vec);
							}
							tbl.setModel(tblTacGia);
							tblTacGia.fireTableDataChanged();

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
