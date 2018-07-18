package managerment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class users {
	private int id;
	private String username;
	private String password;
	private String role;

	public users(String username) {
		super();
		this.username = username;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from users");
			if(rs.next()) {
				id = rs.getInt(1);
				username = rs.getString(2);
				password = rs.getString(3);
				role = rs.getString(4);
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public users(int id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public users() {
		super();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
