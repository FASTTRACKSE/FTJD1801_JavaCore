package demowindows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MyWindow extends JFrame {
	ResultSet rs = null;
	Statement stmt;

	public MyWindow() {

		super("QUAN LY");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		JPanel main1 = new JPanel();
		main1.setLayout(new BorderLayout());
		main.add(main1, BorderLayout.NORTH);

		JPanel main2 = new JPanel();
		main2.setLayout(new BorderLayout());
		main.add(main2, BorderLayout.CENTER);

		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new GridLayout(4, 2));
		main1.add(pnFlow, BorderLayout.CENTER);

		JLabel lblId = new JLabel("Student id:");
		pnFlow.add(lblId);
		JTextField txtId = new JTextField(20);
		pnFlow.add(txtId);

		JLabel lblName = new JLabel("Name:");
		pnFlow.add(lblName);
		JTextField txtName = new JTextField(20);
		pnFlow.add(txtName);

		JLabel lblGroup = new JLabel("Group:");
		pnFlow.add(lblGroup);
		JTextField txtGroup = new JTextField(20);
		pnFlow.add(txtGroup);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
			stmt = con.createStatement();

			rs = stmt.executeQuery("select * from students");

		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Id");
		dm.addColumn("Name");
		dm.addColumn("Group");
		final JTable tbl = new JTable(dm);
		try {
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String group = rs.getString(3);
				Vector<String> vec = new Vector<String>();
				vec.add(id);
				vec.add(name);
				vec.add(group);
				dm.addRow(vec);

			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();

				String id = (String) tbl.getValueAt(row, 0);
				txtId.setText(id);

				String name = (String) tbl.getValueAt(row, 1);
				txtName.setText(name);

				String group = (String) tbl.getValueAt(row, 2);
				txtGroup.setText(group);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		JPanel pnbutton = new JPanel();
		pnbutton.setLayout(new FlowLayout());
		main1.add(pnbutton, BorderLayout.SOUTH);

		JButton btnNext = new JButton(" Next ");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (rs.next()) {
						txtId.setText(rs.getString(1));
						txtName.setText(rs.getString(2));
						txtGroup.setText(rs.getString(3));
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}
		});

		pnbutton.add(btnNext);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (rs.previous()) {
						txtId.setText(rs.getString(1));
						txtName.setText(rs.getString(2));
						txtGroup.setText(rs.getString(3));
					}
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});
		pnbutton.add(btnBack);

		JButton btnAdd = new JButton(" Them ");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String id1 = txtId.getText();
					String name1 = txtName.getText();
					String group1 = txtGroup.getText();

					stmt.executeUpdate(
							"insert into students values (\"" + id1 + "\",\"" + name1 + "\",\"" + group1 + "\")");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from students");
					try {
						while (rs.next()) {
							String id = rs.getString(1);
							String name = rs.getString(2);
							String group = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(id);
							vec.add(name);
							vec.add(group);
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
		pnbutton.add(btnAdd);

		JButton btnUpdateid = new JButton(" Update id  ");
		btnUpdateid.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String id1 = txtId.getText();
					String name1 = txtName.getText();
					String group1 = txtGroup.getText();

					stmt.executeUpdate("update students set name =\"" + name1 + "\",group1=\"" + group1
							+ "\" where id = \"" + id1 + "\" ");
					JOptionPane.showMessageDialog(null, "Sua thanh cong!!!");
					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from students");
					try {
						while (rs.next()) {
							String id = rs.getString(1);
							String name = rs.getString(2);
							String group = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(id);
							vec.add(name);
							vec.add(group);
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
		pnbutton.add(btnUpdateid);

		JButton btnXoa = new JButton(" Xoa Id  ");
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					String id1 = txtId.getText();

					stmt.executeUpdate("delete from students WHERE id = \"" + id1 + "\" ");
					int ret = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (ret != JOptionPane.YES_OPTION) {
						return;
					}

					dm.setRowCount(0);
					ResultSet rs = stmt.executeQuery("select * from students");
					try {
						while (rs.next()) {
							String id = rs.getString(1);
							String name = rs.getString(2);
							String group = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(id);
							vec.add(name);
							vec.add(group);
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
		pnbutton.add(btnXoa);

		JScrollPane sc = new JScrollPane(tbl);
		main2.add(sc, BorderLayout.CENTER);

		JPanel pnSearch = new JPanel();
		pnSearch.setLayout(new GridLayout(1, 2));

		JComboBox cbo = new JComboBox();
		cbo.addItem("ID");
		cbo.addItem("Name");
		cbo.addItem("Group");

		JTextField txtFilter = new JTextField(20);
		pnSearch.add(cbo);
		pnSearch.add(txtFilter);
		main2.add(pnSearch, BorderLayout.NORTH);

		JButton btnSearch = new JButton("search");

		pnSearch.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = txtFilter.getText();
				// TODO Auto-generated method stub
				int n = cbo.getSelectedIndex();
				if (n == 0) {
					String sql;
					if (text.equals(""))
						sql = "select * from students";
					else
						sql = "select * from students where id =\'" + text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							String id = rs.getString(1);
							String name = rs.getString(2);
							String group = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(id);
							vec.add(name);
							vec.add(group);
							dm.addRow(vec);

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				} else if (n == 1) {
					String sql;
					if (text.equals(""))
						sql = "select * from students";
					else
						sql = "select * from students where name =\'" + text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							String id = rs.getString(1);
							String name = rs.getString(2);
							String group = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(id);
							vec.add(name);
							vec.add(group);
							dm.addRow(vec);

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				} else if (n == 2) {
					String sql;
					if (text.equals(""))
						sql = "select * from students";
					else
						sql = "select * from students where group1 =\'" + text + "\'";

					dm.setRowCount(0);
					ResultSet rs;
					try {
						rs = stmt.executeQuery(sql);

						while (rs.next()) {
							String id = rs.getString(1);
							String name = rs.getString(2);
							String group = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(id);
							vec.add(name);
							vec.add(group);
							dm.addRow(vec);

						}
					} catch (Exception ex1) {
						ex1.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				}

			}
		});

		Container con = getContentPane();
		con.add(main);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindow ui = new MyWindow();
		ui.setSize(650, 270);
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
	}

}
