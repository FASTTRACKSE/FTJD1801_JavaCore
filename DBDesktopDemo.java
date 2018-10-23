package Bai1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class DBDesktopDemo extends JFrame{
	private static final String BoderLayout = null;
	ResultSet rs = null; 
	Statement stmt;
	DefaultTableModel dm = new DefaultTableModel();
	public DBDesktopDemo() { 
	
	JPanel main1 = new JPanel();
	main1.setLayout(new BorderLayout());

	JPanel pnFlow=new JPanel();
	pnFlow.setLayout(new GridLayout(4,2));
	//pnFlow.setBackground(Color.PINK);
	main1.add(pnFlow, BorderLayout.CENTER);


	JLabel id = new JLabel("Student id");
	pnFlow.add(id);
	JTextField txtId = new JTextField(20);
	pnFlow.add(txtId);

	JLabel lbName = new JLabel("Name");
	pnFlow.add(lbName);
	JTextField txtName = new JTextField(20);
	pnFlow.add(txtName);

	JLabel lbGroup = new JLabel("Group");
	pnFlow.add(lbGroup);
	JTextField txtGroup = new JTextField(20);
	pnFlow.add(txtGroup);


	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlsv","root", "");
	 stmt = con.createStatement();

	 rs = stmt.executeQuery("select * from user");

	} catch(Exception ex) {
	System.out.println(ex);
	}

	JPanel pnButton = new JPanel();
	JButton btnNext = new JButton(" Next ");
	pnButton.add(btnNext);
	btnNext.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	try {
	if(rs.next()) {
	txtId.setText(rs.getString(1));
	txtName.setText(rs.getString(2));
	txtGroup.setText(rs.getString(3));
	}

	} catch(Exception ex) {
	System.out.println(ex);
	} 
	}
	});
	

	JButton btnBack = new JButton(" Back ");
	pnButton.add(btnBack);
	btnBack.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	try {
	if(rs.previous()) {
	txtId.setText(rs.getString(1));
	txtName.setText(rs.getString(2));
	txtGroup.setText(rs.getString(3));
	}

	} catch(Exception ex) {
	System.out.println(ex);
	} 
	}
	});
	
	JButton btnInsert = new JButton(" Insert ");
	pnButton.add(btnInsert);
	btnInsert.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		
			String id = txtId.getText();
			String name = txtName.getText();
			String group = txtGroup.getText();
			String user =("insert into user values (\""+id+"\",\""+name+"\",\""+group+"\")");
	

		stmt.executeUpdate(user);
		rs = stmt.executeQuery("select * from user");
		dm.addRow(new String[] {txtId.getText(),txtName.getText(),txtGroup.getText() });




		} catch(Exception ex) {
		System.out.println(ex);
		} 
		}
		});
	
	dm.addColumn("idUser");
	dm.addColumn("hoTen");
	dm.addColumn("Group");
	
	final JTable tbl = new JTable(dm);
	try {
		while(rs.next()) {
			dm.addRow(new String[] {rs.getString(1),rs.getString(2),rs.getString(3)});
		
		}
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	tbl.addMouseListener(new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int row=tbl.getSelectedRow();
			
			String s1=(String) tbl.getValueAt(row, 0);
			txtId.setText(s1);
			String s2=(String) tbl.getValueAt(row, 1);
			txtName.setText(s2);
			String s3=(String) tbl.getValueAt(row, 2);
			txtGroup.setText(s3);
			
			//JOptionPane.showMessageDialog(null, s1);
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}});
	


	
	
	
	
	main1.add(pnButton, BorderLayout.SOUTH);
	JPanel main2 = new JPanel();
	main2.setLayout(new BorderLayout());
	
	
	JScrollPane sc=new JScrollPane(tbl); 
	main2.add(sc, BorderLayout.CENTER);
	Container con = getContentPane();
	con.setLayout(new BorderLayout());
	
	JPanel main3 = new JPanel();
	main3.setLayout(new BorderLayout());
	JPanel pnFlow1 =new JPanel();
	pnFlow1.setLayout(new GridLayout(2,2));
	main3.add(pnFlow1, BorderLayout.CENTER);
	
	JTextField txtFind = new JTextField(20);
	pnFlow1.add(txtFind, BorderLayout.EAST);
	JComboBox cbo = new JComboBox();
	cbo.addItem("idUser");
	cbo.addItem("hoTen");
	cbo.addItem("Group");
	add(cbo);
	main3.add(cbo, BorderLayout.WEST);
	
	
	JPanel pnButton1 = new JPanel();
	main3.add(pnButton1, BorderLayout.SOUTH);
	JButton btnFind = new JButton(" FIND ");
	pnButton1.add(btnFind);
	
	 
	
	
	btnFind.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			int t = cbo.getSelectedIndex();
			String str = txtFind.getText();
				
			if(t==0) {
				String sql = "Select * from user where idUser ='"+ str + "'";
				System.out.println(sql);
				try {
					
					rs= stmt.executeQuery(sql);
					dm.setRowCount(0);
					
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
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
			if(t==1) {
				String sql = "Select * from user where hoTen ='"+ str + "'";
			System.out.println(sql);
			try {
				
				rs= stmt.executeQuery(sql);
				dm.setRowCount(0);
				
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
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(t==2) {
				String sql1 = "Select * from user where `group` ='"+ str + "'";
			System.out.println(sql1);
			try {
				
				rs= stmt.executeQuery(sql1);
				dm.setRowCount(0);
				
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
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			}
		}
		
		
	});
	
	
	
	
	
	
	
	con.add(main1,BorderLayout.NORTH);
	con.add(main2,BorderLayout.SOUTH);
	con.add(main3,BorderLayout.CENTER);
	
	
	

	}
	public static void main(String[] args) {
	DBDesktopDemo ui=new DBDesktopDemo();
	ui.setSize(400, 250);
	ui.setLocationRelativeTo(null);
	ui.setVisible(true);
	}

	}