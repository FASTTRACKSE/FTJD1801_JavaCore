package student.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class ActionClick implements ActionListener {
	JTextField txtID;
	JTextField txtName;
	JTextField txtGroup;
	ResultSet rs;
	

	public ActionClick(JTextField txtID, JTextField txtName, JTextField txtGroup, ResultSet rs) {
		super();
		this.txtID = txtID;
		this.txtName = txtName;
		this.txtGroup = txtGroup;
		this.rs = rs;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try {			
			if (rs.next()) {
				txtID.setText(rs.getString(1));
				txtName.setText(rs.getString(2));
				txtGroup.setText(rs.getString(3));
			} 
		} catch (Exception ex) {
			System.out.println(ex);
		}
		
	}

}
