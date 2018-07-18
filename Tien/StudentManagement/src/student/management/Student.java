package student.management;

import java.sql.*;

public class Student {
	private int studentID;
	private String name;
	private String group;
	
	public Student() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Student(int studentID, String name, String group) {
		super();
		this.studentID = studentID;
		this.name = name;
		this.group = group;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	public void display() {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from students");
			while(rs.next()) {				
				System.out.println(rs.getInt(1) + "  |  "+rs.getString(2)+"  |  "+rs.getString(3));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addStudent(String id, String ten, String gr) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "");
			PreparedStatement stmt = con.prepareStatement("Insert into students(Student_ID,Name,Group) values(?,?,?)");
			stmt.setString(1, id);
			stmt.setString(2, ten);
			stmt.setString(3, gr);
			stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
}
