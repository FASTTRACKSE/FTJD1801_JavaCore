package bai1;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentsManager extends JFrame{

	ResultSet rs = null;
	JTextField txtID;
	JTextField txtName;
	JTextField txtGroup;

	public StudentsManager() {
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		JPanel pn = new JPanel();
		pn.setLayout(new BorderLayout());
		main.add(pn, BorderLayout.NORTH);
		JPanel pn1 = new JPanel();
		pn1.setLayout(new GridLayout(4, 2));
		JPanel pnBtn = new JPanel();
		
		pn.add(pn1, BorderLayout.NORTH);
		pn.add(pnBtn, BorderLayout.CENTER);
		
		JLabel id = new JLabel("  ID student");
		pn1.add(id);
		txtID = new JTextField(20);
		pn1.add(txtID);

		JLabel name = new JLabel("  Name");
		pn1.add(name);
		txtName = new JTextField(20);
		pn1.add(txtName);

		JLabel group = new JLabel("  Group");
		pn1.add(group);
		txtGroup = new JTextField(20);
		pn1.add(txtGroup);

		JButton bnBack = new JButton("Back");
		pnBtn.add(bnBack);
		ResultSet rs = connect();
		bnBack.addActionListener(new BackClick(rs));

		JButton bnNext = new JButton("Next");
		pnBtn.add(bnNext);
		bnNext.addActionListener(new NextClick(rs));

		
		DefaultTableModel dm=new DefaultTableModel();
		dm.addColumn("id");
		dm.addColumn("name");
		dm.addColumn("group");
		final JTable tbl=new JTable(dm);
		
		
		
		JButton bnInsert = new JButton("Insert");
		pnBtn.add(bnInsert);
		bnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
					String id = txtID.getText();
					String name = txtName.getText();
					String group = txtGroup.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("insert into students values (\""+id+"\",\""+name+"\",\""+group+"\")");
					//update rs
					//update table
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
					
					} catch (Exception ex) {
						System.out.println(ex);
					}
				}
				
			
		});

		JButton bnUpdateID = new JButton("Update with ID");
		pnBtn.add(bnUpdateID);
		bnUpdateID.addActionListener(new UpdateIDClick());

		JButton bnUpdateName = new JButton("Update with name");
		pnBtn.add(bnUpdateName);
		bnUpdateName.addActionListener(new UpdateNameClick());
		
	
		try {
			while (rs.next()) {
			dm.addRow(new String[]{rs.getString(1),rs.getString(2),rs.getString(3)});
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		JComboBox cbo=new JComboBox();
		cbo.addItem("ID");
		cbo.addItem("Name");
		cbo.addItem("Group");
		add(cbo);
		main.add(sc,BorderLayout.CENTER);
		
		Container con = getContentPane();
//		con.setLayout(new BorderLayout());
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
	private class InsertClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
			String id = txtID.getText();
			String name = txtName.getText();
			String group = txtGroup.getText();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into students values (\""+id+"\",\""+name+"\",\""+group+"\")");
			} catch (Exception ex) {
				System.out.println(ex);
			}
		}
		
	}
	private class UpdateIDClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String id = txtID.getText();
				String name = txtName.getText();
				String group = txtGroup.getText();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
				String query = "UPDATE students SET name='" + name + "', `group`='"+group+"' WHERE idStudents = '"+id+"'";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.executeUpdate();
				con.close();
			} catch (Exception ex ) {
				System.out.println(ex);
			}
		}
		
	}
	private class UpdateNameClick implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				String id = txtID.getText();
				String name = txtName.getText();
				String group = txtGroup.getText();
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentsmanagement",  "root","");
				String query = "UPDATE students SET idStudents= '"+id+"', `group` ='"+group+"' WHERE name = '"+name+"'";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.executeUpdate();
				con.close();
			} catch (Exception ex ) {
				System.out.println(ex);
			}
		}
		
	}
	public static void main(String[] args) {
		StudentsManager ui = new StudentsManager();
		ui.setSize(500,250);
		ui.setLocationRelativeTo(null);    
		ui.setVisible(true);
	}
}
