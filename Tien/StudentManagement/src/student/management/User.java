package student.management;

import java.sql.*;

public class User {
	private int id;
	private String userName;
	private String passWord;
	private String role;
	public User() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User(int id, String userName, String passWord, String role) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User(String userName) {
		super();
		this.userName = userName;
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentmanagement","root","");
			PreparedStatement stmt = con.prepareStatement("Select * from users where UserName = ?");
			stmt.setString(1, userName);
			ResultSet rs = stmt.executeQuery();			
			if(rs.next()) {
				id = rs.getInt(1);
				userName = rs.getString(2);
				passWord = rs.getString(3);
				role = rs.getString(4);	
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
