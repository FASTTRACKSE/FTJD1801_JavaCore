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

public class LopHocPhan extends JPanel {
	ResultSet rs = null;
	Statement stmt;

	public LopHocPhan() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlitruonghoc?useUnicode=yes&characterEncoding=UTF-8", "root", "");
			stmt = (Statement) con.createStatement();
			rs = stmt.executeQuery("SELECT * from lophocphan");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		Font fontOne = new Font(Font.SERIF, Font.PLAIN, 18);

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel grTop = new JPanel();
		grTop.setLayout(new GridLayout(2, 4));

		JPanel pnOne = new JPanel();
		pnOne.setLayout(new FlowLayout());
		JLabel lblID = new JLabel("Mã lớp học phần");
		JTextField txtID = new JTextField(15);
		lblID.setFont(fontOne);
		txtID.setFont(fontOne);
		grTop.add(lblID);
		pnOne.add(txtID);
		grTop.add(pnOne);

		JPanel pnTwo = new JPanel();
		pnTwo.setLayout(new FlowLayout());
		JLabel lblMaSV = new JLabel("Mã sinh viên");
		JTextField txtMaSV = new JTextField(15);
		lblMaSV.setFont(fontOne);
		txtMaSV.setFont(fontOne);
		grTop.add(lblMaSV);
		pnTwo.add(txtMaSV);
		grTop.add(pnTwo);

		JPanel pnThree = new JPanel();
		pnThree.setLayout(new FlowLayout());
		JLabel lblMaMH = new JLabel("Mã môn học");
		JTextField txtMaMH = new JTextField(15);
		lblMaMH.setFont(fontOne);
		txtMaMH.setFont(fontOne);
		grTop.add(lblMaMH);
		pnThree.add(txtMaMH);
		grTop.add(pnThree);
		
		JPanel pnFour = new JPanel();
		pnFour.setLayout(new FlowLayout());
		JLabel lblDiem = new JLabel("Điểm");
		JTextField txtDiem = new JTextField(15);
		lblDiem.setFont(fontOne);
		txtDiem.setFont(fontOne);
		grTop.add(lblDiem);
		pnFour.add(txtDiem);
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
		cbbType.addItem("Mã lớp học phần");
		cbbType.addItem("Mã sinh viên");
		cbbType.addItem("Điểm");
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
		DefaultTableModel tblLopHocPhan = new DefaultTableModel();
		tblLopHocPhan.addColumn("Mã lớp học phần");
		tblLopHocPhan.addColumn("Mã sinh viên");
		tblLopHocPhan.addColumn("Mã môn học");
		tblLopHocPhan.addColumn("Điểm");

		final JTable tbl = new JTable(tblLopHocPhan);
		try {
			while (rs.next()) {
				String maLHP = rs.getString(1);
				String maSV = rs.getString(2);
				String maMH = rs.getString(3);
				String diem = rs.getString(4);

				Vector<String> vec = new Vector<String>();
				vec.add(maLHP);
				vec.add(maSV);
				vec.add(maMH);
				vec.add(diem);

				tblLopHocPhan.addRow(vec);
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
				String maLHP = (String) tbl.getValueAt(row, 0);
				txtID.setText(maLHP);

				String maSV = (String) tbl.getValueAt(row, 1);
				txtMaSV.setText(maSV);

				String maMH = (String) tbl.getValueAt(row, 2);
				txtMaMH.setText(maMH);
				
				String diem = (String) tbl.getValueAt(row, 3);
				txtDiem.setText(diem);

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
					stmt.execute("Insert into lophocphan values(\'" + txtID.getText() + "\',\'" + txtMaSV.getText()
							+ "\',\'" + txtMaMH.getText() + "\',\'" + txtDiem.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblLopHocPhan.setRowCount(0);
					rs = stmt.executeQuery("Select * from lophocphan");

					while (rs.next()) {
						String maLHP = rs.getString(1);
						String maSV = rs.getString(2);
						String maMH = rs.getString(3);
						String diem = rs.getString(4);

						Vector<String> vec = new Vector<String>();
						vec.add(maLHP);
						vec.add(maSV);
						vec.add(maMH);
						vec.add(diem);

						tblLopHocPhan.addRow(vec);
					}
					tbl.setModel(tblLopHocPhan);
					tblLopHocPhan.fireTableDataChanged();

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
					stmt.executeUpdate("update lophocphan set tenMH = \'" + txtMaSV.getText() + "\', tinChi = \'"
							+ txtMaMH.getText() + "\', thoiGian = \'"+ txtDiem.getText() + "\' where maMH = \'"+ txtID.getText()+"\'");
					JOptionPane.showMessageDialog(null, "Cập nhật thành công!!!");
					tblLopHocPhan.setRowCount(0);
					rs = stmt.executeQuery("Select * from lophocphan");

					while (rs.next()) {
						String maLHP = rs.getString(1);
						String maSV = rs.getString(2);
						String maMH = rs.getString(3);
						String diem = rs.getString(4);

						Vector<String> vec = new Vector<String>();
						vec.add(maLHP);
						vec.add(maSV);
						vec.add(maMH);
						vec.add(diem);
						
						tblLopHocPhan.addRow(vec);
					}
					tbl.setModel(tblLopHocPhan);
					tblLopHocPhan.fireTableDataChanged();

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

				try {
					stmt.execute("delete from lophocphan where maMH = \'" + txtID.getText() + "\'");
					JOptionPane.showMessageDialog(null, "Xóa thành công!!!");
					tblLopHocPhan.setRowCount(0);
					rs = stmt.executeQuery("Select * from lophocphan");

					while (rs.next()) {
						String maLHP = rs.getString(1);
						String maSV = rs.getString(2);
						String maMH = rs.getString(3);
						String diem = rs.getString(4);

						Vector<String> vec = new Vector<String>();
						vec.add(maLHP);
						vec.add(maSV);
						vec.add(maMH);
						vec.add(diem);
						tblLopHocPhan.addRow(vec);
					}
					tbl.setModel(tblLopHocPhan);
					tblLopHocPhan.fireTableDataChanged();

				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
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
						tblLopHocPhan.setRowCount(0);
						rs = stmt.executeQuery("Select * from lophocphan");

						while (rs.next()) {
							String maLHP = rs.getString(1);
							String maSV = rs.getString(2);
							String maMH = rs.getString(3);
							String diem = rs.getString(4);

							Vector<String> vec = new Vector<String>();
							vec.add(maLHP);
							vec.add(maSV);
							vec.add(maMH);
							vec.add(diem);
							
							tblLopHocPhan.addRow(vec);
						}
						tbl.setModel(tblLopHocPhan);
						tblLopHocPhan.fireTableDataChanged();
					} else {
						if (index == 0) {
							tblLopHocPhan.setRowCount(0);
							rs = stmt.executeQuery("Select * from lophocphan where maLHP = " + txtValue.getText() + "");

							while (rs.next()) {
								String maLHP = rs.getString(1);
								String maSV = rs.getString(2);
								String maMH = rs.getString(3);
								String diem = rs.getString(4);

								Vector<String> vec = new Vector<String>();
								vec.add(maLHP);
								vec.add(maSV);
								vec.add(maMH);
								vec.add(diem);
								
								
								tblLopHocPhan.addRow(vec);
							}
							tbl.setModel(tblLopHocPhan);
							tblLopHocPhan.fireTableDataChanged();

						} else if (index == 1) {
							tblLopHocPhan.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from lophocphan where maSV = \'" + txtValue.getText() + "\'");

							while (rs.next()) {
								String maLHP = rs.getString(1);
								String maSV = rs.getString(2);
								String maMH = rs.getString(3);
								String diem = rs.getString(4);

								Vector<String> vec = new Vector<String>();
								vec.add(maLHP);
								vec.add(maSV);
								vec.add(maMH);
								vec.add(diem);
								
								tblLopHocPhan.addRow(vec);
							}
							tbl.setModel(tblLopHocPhan);
							tblLopHocPhan.fireTableDataChanged();
							
						} else if (index == 2) {
							tblLopHocPhan.setRowCount(0);
							rs = stmt.executeQuery(
									"Select * from lophocphan where diem = \'" + txtValue.getText() + "\'");

							while (rs.next()) {
								String maLHP = rs.getString(1);
								String maSV = rs.getString(2);
								String maMH = rs.getString(3);
								String diem = rs.getString(4);

								Vector<String> vec = new Vector<String>();
								vec.add(maLHP);
								vec.add(maSV);
								vec.add(maMH);
								vec.add(diem);
								
								tblLopHocPhan.addRow(vec);
							}
							tbl.setModel(tblLopHocPhan);
							tblLopHocPhan.fireTableDataChanged();

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

