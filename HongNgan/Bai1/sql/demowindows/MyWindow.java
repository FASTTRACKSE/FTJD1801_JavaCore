package demowindows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.*;

public class MyWindow extends JFrame {
	ResultSet rs = null;

	public MyWindow() {

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		JPanel pnFlow = new JPanel();
		pnFlow.setLayout(new GridLayout(4, 2));
		main.add(pnFlow, BorderLayout.CENTER);

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
			Statement stmt = con.createStatement();

			rs = stmt.executeQuery("select * from students");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		JPanel pnbutton = new JPanel();

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
					String id = txtId.getText();
					String name = txtName.getText();
					String group = txtGroup.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					stmt.executeUpdate(
							"insert into students values (\"" + id + "\",\"" + name + "\",\"" + group + "\")");
					
					con.close();
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
					String id = txtId.getText();
					String name = txtName.getText();
					String group = txtGroup.getText();

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("update students set name =\"" + name + "\",group1=\"" + group
							+ "\" where id = \"" + id + "\" ");
					

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});
		pnbutton.add(btnUpdateid);

		JButton btnUpdateName = new JButton(" Update Name  ");
		btnUpdateName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String id = txtId.getText();
					String name = txtName.getText();
					String group = txtGroup.getText();

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("update students set name =\"" + name + "\",group1=\"" + group
							+ "\" where name = \"" + name + "\" ");
					

				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});
		pnbutton.add(btnUpdateName);

		JButton btnXoa = new JButton(" Xoa Id  ");
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					String id = txtId.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("delete from students WHERE id = \"" + id + "\" ");
					
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});
		pnbutton.add(btnXoa);

		JButton btnXoaName = new JButton(" Xoa Name  ");
		btnXoaName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					String name = txtName.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("delete from students WHERE name = \"" + name + "\" ");
					
				} catch (Exception ex) {
					System.out.println(ex);
				}
			}

		});
		pnbutton.add(btnXoaName);

		main.add(pnbutton, BorderLayout.SOUTH);
		Container con = getContentPane();
		con.add(main);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindow ui = new MyWindow();
		ui.setSize(650, 170);
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
	}

}
