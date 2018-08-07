package bai1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MainWindows extends JFrame {
	ResultSet rs = null;
	Statement stmt;
	Connection con;
	JTextField txtID;
	JTextField txtName;
	JTextField txtGroup;
	public MainWindows() {
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		
		JPanel pn1 = new JPanel();
		pn1.setLayout(new BorderLayout());
		main.add(pn1, BorderLayout.NORTH);
		
		JPanel pn2 = new JPanel();
		pn2.setLayout(new BorderLayout());
		main.add(pn2, BorderLayout.CENTER);
		
		JPanel pnText = new JPanel();
		pnText.setLayout(new GridLayout(4, 2));
		pn1.add(pnText, BorderLayout.CENTER);
		
		JLabel id = new JLabel("  ID student");
		pnText.add(id);
		txtID = new JTextField();
		pnText.add(txtID);
		
		JLabel name = new JLabel("  Name");
		pnText.add(name);
		txtName = new JTextField(20);
		pnText.add(txtName);
		
		JLabel group = new JLabel("  Group");
		pnText.add(group);
		txtGroup = new JTextField(20);
		pnText.add(txtGroup);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement","root","");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from students");
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("id");
		dm.addColumn("name");
		dm.addColumn("group");
		final JTable tbl=new JTable(dm);
		try {
			while (rs.next()) {
			dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JPanel pnBtn = new JPanel();
		pnBtn.setLayout(new FlowLayout());
		pn1.add(pnBtn, BorderLayout.SOUTH);
		
		JButton btnNext = new JButton("Next");
		pnBtn.add(btnNext);
		btnNext.addActionListener(new NextClick(rs));
		JButton btnBack = new JButton("Back");
		pnBtn.add(btnBack);
		btnBack.addActionListener(new BackClick(rs));
		JButton btnAdd = new JButton("Add");
		pnBtn.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String id = txtID.getText();
					String name = txtName.getText();
					String group = txtGroup.getText();
					stmt = con.createStatement();
					stmt.executeUpdate("insert into students values (\""+id+"\",\""+name+"\",\""+group+"\")");
					dm.setRowCount(0);
					
					ResultSet rs = connect();
					
					try {
						while (rs.next()) {
						dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
						}
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton btnID = new JButton("Update with ID");
		pnBtn.add(btnID);
		btnID.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String id = txtID.getText();
					String name = txtName.getText();
					String group = txtGroup.getText();
					String query = "UPDATE students SET name='" + name + "', `group`='"+group+"' WHERE idStudents = '"+id+"'";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.executeUpdate();
					dm.setRowCount(0);
					ResultSet rs = connect();
					try {
						while (rs.next()) {
						dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
						}
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				}
				catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		JButton btnName = new JButton("Update with Name");
		pnBtn.add(btnName);
		btnName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String id = txtID.getText();
					String name = txtName.getText();
					String group = txtGroup.getText();
					String query = "UPDATE students SET idStudents='" + id + "', `group`='"+group+"' WHERE name = '"+name+"'";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.executeUpdate();
					dm.setRowCount(0);
					ResultSet rs = connect();
					try {
						while (rs.next()) {
						dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
						}
					} catch (SQLException ex) {
						// TODO Auto-generated catch block
						ex.printStackTrace();
					}
					tbl.setModel(dm);
					dm.fireTableDataChanged();
				}
				catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		});
		tbl.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
			int row=tbl.getSelectedRow();
			
			String id=(String)tbl.getValueAt(row, 0);
			String name=(String)tbl.getValueAt(row, 1);
			String group=(String)tbl.getValueAt(row, 2);
			txtID.setText(id);
			txtName.setText(name);
			txtGroup.setText(group);
			}});
		
		
		JScrollPane sc=new JScrollPane(tbl);
		pn2.add(sc, BorderLayout.CENTER);
		JPanel pnFilter=new JPanel();
		pnFilter.setLayout(new GridLayout(1, 3));
		JComboBox cbo=new JComboBox();
		cbo.addItem("ID");
		cbo.addItem("Name");
		cbo.addItem("Group");
		JTextField txtFilter = new JTextField(20);
		pnFilter.add(cbo);
		pnFilter.add(txtFilter);
		pn2.add(pnFilter, BorderLayout.NORTH);
		
		JButton btnSearch = new JButton("search");
		pnFilter.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String text = txtFilter.getText();
				int n = cbo.getSelectedIndex();
				try {
					if (n==0) {
						String sql = "select * from students where idStudents = \'"+text+"\'";
						rs = stmt.executeQuery(sql);
						dm.setRowCount(0);	
						try {
							while (rs.next()) {
							System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
							dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
							}
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						tbl.setModel(dm);
						dm.fireTableDataChanged();
					} else if (n==1) {
						String sql = "select * from students where name = \'"+text+"\'";
						rs = stmt.executeQuery(sql);
						dm.setRowCount(0);	
						try {
							while (rs.next()) {
								System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
							dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
							}
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						tbl.setModel(dm);
						dm.fireTableDataChanged();
					} else if (n==2) {
						String sql = "select * from students where `group` = \'"+text+"\'";
						rs = stmt.executeQuery(sql);
						dm.setRowCount(0);	
						try {
							while (rs.next()) {
							System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
							dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
							}
							
						} catch (SQLException ex) {
							// TODO Auto-generated catch block
							ex.printStackTrace();
						}
						tbl.setModel(dm);
						dm.fireTableDataChanged();
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		});
		
		Container con = getContentPane();
		con.add(main);
	}
	private ResultSet connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from students");
			return rs;
		} catch (Exception ex ) {
			System.out.println(ex);
		}
		return null;
	}
	private class NextClick implements ActionListener {
		ResultSet rs;
		public NextClick(ResultSet rs) {
			this.rs = rs;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				
				if (rs.next()) {
				txtID.setText(rs.getString(1));
				txtName.setText(rs.getString(2));
				txtGroup.setText(rs.getString(3));
				}
			} catch (Exception ex ) {
				System.out.println(ex);
			}
		}
	}
	private class BackClick implements ActionListener {
		ResultSet rs;
		public BackClick(ResultSet rs) {
			this.rs = rs;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				if (rs.previous()) {
				txtID.setText(rs.getString(1));
				txtName.setText(rs.getString(2));
				txtGroup.setText(rs.getString(3));
				}
			} catch (Exception ex ) {
				System.out.println(ex);
			}
		}
	}
	public static void main(String[] args) {
		MainWindows ui = new MainWindows();
		ui.setSize(500,300);
		ui.setLocationRelativeTo(null);    
		ui.setVisible(true);
	}
}
