package student.management;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class MyWindows extends JFrame {
	ResultSet rs = null;
	Statement stmt;

	public MyWindows() {
		super("QUAN LY SINH VIEN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

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
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from students");

		} catch (Exception ex) {
			System.out.println(ex);
		}

		JPanel pnBottom = new JPanel();
		pnMain.add(pnBottom, BorderLayout.SOUTH);

		JButton btnBack = new JButton("Back");
		pnBottom.add(btnBack);
		btnBack.addActionListener(new ActionClickBack(txtID, txtName, txtGroup, rs));

		JButton btnNext = new JButton("Next");
		pnBottom.add(btnNext);
		btnNext.addActionListener(new ActionClick(txtID, txtName, txtGroup, rs));

		JButton btnAdd = new JButton("Add");
		pnBottom.add(btnAdd);

		JPanel pnData = new JPanel();
		pnData.setLayout(new BorderLayout());

		DefaultTableModel tblStudent = new DefaultTableModel();
		tblStudent.addColumn("Mã sinh viên");
		tblStudent.addColumn("Tên sinh viên");
		tblStudent.addColumn("Lớp");

		final JTable tbl = new JTable(tblStudent);
		try {
			while (rs.next()) {
				String maSV = rs.getString(1);
				String hoTen = rs.getString(2);
				String lop = rs.getString(3);
				Vector<String> vec = new Vector<String>();
				vec.add(maSV);
				vec.add(hoTen);
				vec.add(lop);
				tblStudent.addRow(vec);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbl.getSelectedRow();

				String id = (String) tbl.getValueAt(row, 0);
				txtID.setText(id);

				String name = (String) tbl.getValueAt(row, 1);
				txtName.setText(name);

				String group = (String) tbl.getValueAt(row, 2);
				txtGroup.setText(group);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					stmt.execute("Insert into students(Student_ID,Name,`Group`) values(" + txtID.getText() + ",\'"
							+ txtName.getText() + "\',\'" + txtGroup.getText() + "\')");
					JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
					tblStudent.setRowCount(0);
					ResultSet rs = stmt.executeQuery("Select * from students");
					
						while (rs.next()) {
							String maSV = rs.getString(1);
							String hoTen = rs.getString(2);
							String lop = rs.getString(3);
							Vector<String> vec = new Vector<String>();
							vec.add(maSV);
							vec.add(hoTen);
							vec.add(lop);
							tblStudent.addRow(vec);							
						}
						tbl.setModel(tblStudent);
						tblStudent.fireTableDataChanged();
					
				} catch (Exception ex) {
					// TODO: handle exception
					System.err.println(ex);
				}
			}
		});
		JPanel pnSearch = new JPanel();
		
		JLabel lblRow = new JLabel("Tìm kiếm theo: ");
		
		JComboBox cbo=new JComboBox(); 
		cbo.addItem("Mã sinh viên");
		cbo.addItem("Tên sinh viên");
		cbo.addItem("Lớp");
		
		JLabel lblSearch = new JLabel("Tìm kiếm: ");
		
		JTextField txtSearch = new JTextField();
		
		JButton btnSearch = new JButton("Tìm kiếm");
		
		pnSearch.add(lblRow);
		pnSearch.add(cbo);
		pnSearch.add(lblSearch);
		pnSearch.add(txtSearch);
		pnSearch.add(btnSearch);
		
		pnSearch.setLayout(new GridLayout(1, 5));
		JPanel pnTable = new JPanel();
		Border border=  BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle=  BorderFactory.createTitledBorder(   border, "Danh sách");				
		pnTable.setBorder(borderTitle);
		
		pnTable.add(tbl);
		pnData.add(pnTable, BorderLayout.SOUTH);
		pnData.add(pnSearch, BorderLayout.CENTER);
		main.add(pnMain, BorderLayout.CENTER);
		main.add(pnData, BorderLayout.SOUTH);

		Container con = getContentPane();
		con.add(main);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindows mainFrame = new MyWindows();
		mainFrame.setSize(600, 300);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

}
