package student.management;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class MyWindows extends JFrame{
	ResultSet rs = null;
	public MyWindows() {
		super("QUAN LY SINH VIEN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		JPanel pnTop = new JPanel();
		pnTop.setLayout(new GridLayout(4, 2));
		pnMain.add(pnTop, BorderLayout.CENTER);
		
		JLabel lblID = new JLabel("Mã sinh viên: ");
		pnTop.add(lblID);
		JTextField txtID = new JTextField(15);
		pnTop.add(txtID);
		
		JLabel lblName = new JLabel("Tên sinh viên: ");
		pnTop.add(lblName);
		JTextField txtName = new JTextField(15);
		pnTop.add(txtName);
		
		JLabel lblGroup = new JLabel("Lớp: ");
		pnTop.add(lblGroup);
		JTextField txtGroup = new JTextField(15);
		pnTop.add(txtGroup);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","");
			Statement stmt = con.createStatement();
			 rs = stmt.executeQuery("Select * from students");
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
		JPanel pnBottom = new JPanel();
		pnMain.add(pnBottom, BorderLayout.SOUTH);
		
		Button btnBack = new Button("Back");
		pnBottom.add(btnBack);
		btnBack.addActionListener(new ActionClickBack(txtID, txtName, txtGroup, rs));
		
		Button btnNext = new Button("Next");
		pnBottom.add(btnNext);
		btnNext.addActionListener(new ActionClick(txtID, txtName, txtGroup, rs));		
		
		Button btnAdd = new Button("Add");
		pnBottom.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","");
					Statement stmt = con.createStatement();
					 rs = stmt.executeQuery("Insert into students(Student_ID,Name,Group) values(6,'abc','12a')");
					
					
					con.close();
				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		});
		
		Container con = getContentPane();
		con.add(pnMain);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindows mainFrame = new MyWindows();		
		mainFrame.setSize(400, 150);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

}
