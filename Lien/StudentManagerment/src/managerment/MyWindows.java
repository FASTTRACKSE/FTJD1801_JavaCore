package managerment;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class MyWindows extends JFrame{
	ResultSet rs = null;

	public MyWindows() {
		super("QUẢN LÍ SINH VIÊN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		
		JPanel pnGrid = new JPanel();
		pnGrid.setLayout(new GridLayout(4,2));
		pnMain.add(pnGrid,BorderLayout.CENTER); 
		pnGrid.setBackground(Color.PINK);
		
		
		JLabel lblID = new JLabel("mã sinh viên: ");
		pnGrid.add(lblID);
		JTextField txtID = new JTextField(15);
		pnGrid.add(txtID);
		lblID.setForeground(Color.RED);
		
		
		JLabel lblName = new JLabel("tên sinh viên: ");
		pnGrid.add(lblName);
		JTextField txtName = new JTextField(15);
		pnGrid.add(txtName);
		lblName.setForeground(Color.RED);
		
		JLabel lblClass = new JLabel(" sinh viên lớp : ");
		pnGrid.add(lblClass);
		JTextField txtClass = new JTextField(15);
		pnGrid.add(txtClass);
		lblClass.setForeground(Color.RED);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "");
			Statement stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from student");
		} catch (Exception e) {
			// TODO: handle exception
		}
		JPanel btn = new JPanel();
		pnMain.add(btn, BorderLayout.SOUTH);
		Button btnNext = new Button("Next");
		btn.add(btnNext);
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
			if(rs.next()) {
			txtID.setText(rs.getString(1));
			txtName.setText(rs.getString(2));
			txtClass.setText(rs.getString(3));
			}

			} catch(Exception ex) {
			System.out.println(ex);
			} 
			
			}
			
		});
		
		pnMain.add(btn, BorderLayout.SOUTH);
		Button btnBack = new Button("Back");
		btn.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		if(rs.previous()) {
		txtID.setText(rs.getString(1));
		txtName.setText(rs.getString(2));
		txtClass.setText(rs.getString(3));
		}

		} catch(Exception ex) {
		System.out.println(ex);
		} 
		}
		});
		Container con = getContentPane();
		con.add(pnMain);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindows mainFrame = new MyWindows();
				
		
		mainFrame.setSize(400,200);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);

	}

}
