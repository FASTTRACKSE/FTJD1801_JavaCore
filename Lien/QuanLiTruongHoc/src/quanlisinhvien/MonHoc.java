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

public class MonHoc extends JPanel {
	ResultSet rs = null;
	Statement stmt;

	public MonHoc() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/quanlitruonghoc?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = (Statement) con.createStatement();
			rs = stmt.executeQuery("SELECT * from monhoc");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		Font fontOne = new Font(Font.SERIF, Font.ITALIC, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(2, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã môn học");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnTwo = new JPanel();
		pnTwo.setLayout(new FlowLayout());
		JLabel lblName = new JLabel("Tên môn học");
		JTextField txtName = new JTextField(15);
		lblName.setFont(fontOne);
		txtName.setFont(fontOne);
		grTop.add(lblName);
		pnTwo.add(txtName);
		grTop.add(pnTwo);

		JPanel pnThree = new JPanel();
		pnThree.setLayout(new FlowLayout());
		JLabel lblTinchi = new JLabel("Tín chỉ");
		JTextField txtTinchi = new JTextField(15);
		lblTinchi.setFont(fontOne);
		txtTinchi.setFont(fontOne);
		grTop.add(lblTinchi);
		pnThree.add(txtTinchi);
		grTop.add(pnThree);

		JPanel pnFour = new JPanel();
		pnFour.setLayout(new FlowLayout());
		JLabel lblThoigian = new JLabel("Thời gian");
		JTextField txtThoigian = new JTextField(15);
		lblThoigian.setFont(fontOne);
		txtThoigian.setFont(fontOne);
		grTop.add(lblThoigian);
		pnFour.add(txtThoigian);
		grTop.add(pnFour);

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
		cbbType.addItem("Mã môn học");
		cbbType.addItem("Tên môn học");
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
		DefaultTableModel tblMonHoc = new DefaultTableModel();
		tblMonHoc.addColumn("Mã môn học");
		tblMonHoc.addColumn("Tên môn học");
		tblMonHoc.addColumn("Tín chỉ");
		tblMonHoc.addColumn("Thời gian");

		final JTable tbl = new JTable(tblMonHoc);
		try {
			while (rs.next()) {
				String maMH = rs.getString(1);
				String tenMH = rs.getString(2);
				String tinChi = rs.getString(3);
				String thoiGian = rs.getString(4);

				Vector<String> vec = new Vector<String>();
				vec.add(maMH);
				vec.add(tenMH);
				vec.add(tinChi);
				vec.add(thoiGian);

				tblMonHoc.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		Border border = BorderFactory.createLineBorder(Color.DARK_GRAY);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Quản lí môn học");

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
				String maMH = (String) tbl.getValueAt(row, 0);
				txtID.setText(maMH);

				String tenMH = (String) tbl.getValueAt(row, 1);
				txtName.setText(tenMH);

				String tinChi = (String) tbl.getValueAt(row, 2);
				txtTinchi.setText(tinChi);

				String thoiGian = (String) tbl.getValueAt(row, 3);
				txtThoigian.setText(thoiGian);

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
					stmt.execute("Insert into monhoc values(\'" + txtID.getText() + "\',\'" + txtName.getText()
							+ "\',\'" + txtTinchi.getText() + "\',\'" + txtThoigian.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblMonHoc.setRowCount(0);
					rs = stmt.executeQuery("Select * from monhoc");

					while (rs.next()) {
						String maMH = rs.getString(1);
						String tenMH = rs.getString(2);
						String tinChi = rs.getString(3);
						String thoiGian = rs.getString(4);

						Vector<String> vec = new Vector<String>();
						vec.add(maMH);
						vec.add(tenMH);
						vec.add(tinChi);
						vec.add(thoiGian);

						tblMonHoc.addRow(vec);
					}
					tbl.setModel(tblMonHoc);
					tblMonHoc.fireTableDataChanged();

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
					stmt.executeUpdate("update monhoc set tenMH = \'" + txtName.getText() + "\', tinChi = \'"
							+ txtTinchi.getText() + "\', thoiGian = \'" + txtThoigian.getText() + "\' where maMH = \'"
							+ txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblMonHoc.setRowCount(0);
					rs = stmt.executeQuery("Select * from monHoc");

					while (rs.next()) {
						String maMH = rs.getString(1);
						String tenMH = rs.getString(2);
						String tinChi = rs.getString(3);
						String thoiGian = rs.getString(4);

						Vector<String> vec = new Vector<String>();
						vec.add(maMH);
						vec.add(tenMH);
						vec.add(tinChi);
						vec.add(thoiGian);

						tblMonHoc.addRow(vec);
					}
					tbl.setModel(tblMonHoc);
					tblMonHoc.fireTableDataChanged();

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
						"Bạn muốn xóa dữ liệu môn học ở lớp học phần !", "Xem cho kỹ", JOptionPane.YES_NO_OPTION);
				if (dialogResult == JOptionPane.YES_OPTION) {
					try {
						stmt.execute("delete from monhoc where maMH = \'" + txtID.getText() + "\'");
						JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
						tblMonHoc.setRowCount(0);
						rs = stmt.executeQuery("Select * from monhoc");

						while (rs.next()) {
							String maMH = rs.getString(1);
							String tenMH = rs.getString(2);
							String tinChi = rs.getString(3);
							String thoiGian = rs.getString(4);

							Vector<String> vec = new Vector<String>();
							vec.add(maMH);
							vec.add(tenMH);
							vec.add(tinChi);
							vec.add(thoiGian);
							tblMonHoc.addRow(vec);
						}
						tbl.setModel(tblMonHoc);
						tblMonHoc.fireTableDataChanged();

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
						tblMonHoc.setRowCount(0);
						rs = stmt.executeQuery("Select * from monhoc");

						while (rs.next()) {
							String maMH = rs.getString(1);
							String tenMH = rs.getString(2);
							String tinChi = rs.getString(3);
							String thoiGian = rs.getString(4);

							Vector<String> vec = new Vector<String>();
							vec.add(maMH);
							vec.add(tenMH);
							vec.add(tinChi);
							vec.add(thoiGian);

							tblMonHoc.addRow(vec);
						}
						tbl.setModel(tblMonHoc);
						tblMonHoc.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblMonHoc.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from monhoc where maMH like \'%" + txtValue.getText() + "%\'");

							while (rs.next()) {
								String maMH = rs.getString(1);
								String tenMH = rs.getString(2);
								String tinChi = rs.getString(3);
								String thoiGian = rs.getString(4);

								Vector<String> vec = new Vector<String>();
								vec.add(maMH);
								vec.add(tenMH);
								vec.add(tinChi);
								vec.add(thoiGian);

								tblMonHoc.addRow(vec);
							}
							tbl.setModel(tblMonHoc);
							tblMonHoc.fireTableDataChanged();

						} else if (index == 1) {
							tblMonHoc.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from monhoc where tenMH like \'%" + txtValue.getText() + "%\'");

							while (rs.next()) {
								String maMH = rs.getString(1);
								String tenMH = rs.getString(2);
								String tinChi = rs.getString(3);
								String thoiGian = rs.getString(4);

								Vector<String> vec = new Vector<String>();
								vec.add(maMH);
								vec.add(tenMH);
								vec.add(tinChi);
								vec.add(thoiGian);

								tblMonHoc.addRow(vec);
							}
							tbl.setModel(tblMonHoc);
							tblMonHoc.fireTableDataChanged();

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
