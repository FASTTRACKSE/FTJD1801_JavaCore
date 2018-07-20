package managerment;

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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MyWindows extends JFrame{
	ResultSet rs = null;
	Statement stmt;
	public MyWindows() {
		super("QUẢN LÍ SINH VIÊN");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());
		
		
		
		
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
			 stmt = con.createStatement();
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
		pnMain.add(btn, BorderLayout.SOUTH);
		Button btnadd = new Button("Add");
		btn.add(btnadd);
		btnadd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				stmt.execute("Insert into student(id,Name,`Group`) values(" + txtID.getText()
						+ ",\'" + txtName.getText() + "\',\'" + txtClass.getText() + "\')");
				JOptionPane.showMessageDialog(null, "Thêm thành công!!!");
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
			}
		});
		
		DefaultTableModel dm = new DefaultTableModel();
		dm.addColumn("Id");
		dm.addColumn("Name");
		dm.addColumn("Group");
		
		final JTable tbl=new JTable(dm);
		try {
			while (rs.next()) {
				String Id = rs.getString(1);
				String Name = rs.getString(2);
				String Group = rs.getString(3);
				Vector<String> vec = new Vector<String>();
				vec.add(Id);
				vec.add(Name);
				vec.add(Group);
				dm.addRow(vec);
				
			} 
		} catch (Exception ex) {
			// TODO: handle exception
		}
		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
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
				int row =tbl.getSelectedRow();
				String Id=(String)tbl.getValueAt(row, 0);
				txtID.setText(Id);
				
				String Name=(String)tbl.getValueAt(row, 1);
				txtID.setText(Name);
				
				String Group=(String)tbl.getValueAt(row, 2);
				txtID.setText(Group);
				
				
				

				
			}
			
		});
		
		JPanel tblData = new JPanel();
		tblData.setLayout(new BorderLayout());
		
		JPanel pnTK = new JPanel();
		pnTK.setLayout(new GridLayout(1, 7));
		
		JLabel lblLoai = new JLabel("Loai Tim Kiem: ");
		
		JComboBox cbbLoai = new JComboBox();
		cbbLoai.addItem("Ma Sinh Vien");
		cbbLoai.addItem("Ten Sinh Vien");
		cbbLoai.addItem("Lop Hoc");
		
		JLabel lblTK = new JLabel("Du Lieu Tim Kiem: ");
		
		JTextField txtTK = new JTextField();
		
		JButton btnTK = new JButton("Tim Kiem");
		
		JPanel one = new JPanel();
		JPanel two = new JPanel();
		
		pnTK.add(lblLoai);
		pnTK.add(cbbLoai);
		pnTK.add(one);
		pnTK.add(lblTK);
		pnTK.add(txtTK);
		pnTK.add(two);
		pnTK.add(btnTK);
		
		tblData.add(pnTK, BorderLayout.CENTER);
		tblData.add(tbl, BorderLayout.SOUTH);
		
		main.add(pnMain,BorderLayout.CENTER );
		main.add(tblData, BorderLayout.SOUTH);
		
		
		
		Container con=getContentPane();
		con.add(main);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyWindows mainFrame = new MyWindows();
				
		
		mainFrame.setSize(800,400);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);

	}

}
