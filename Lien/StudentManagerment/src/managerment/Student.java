package managerment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
	private int id;
	private String name;
	private String group;

	public Student(int id) {
		super();
		this.id = id;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from student");
			if(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				group = rs.getString(3);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Student(int id, String name, String group) {
		super();
		this.id = id;
		this.name = name;
		this.group = group;
	}

	public Student() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
