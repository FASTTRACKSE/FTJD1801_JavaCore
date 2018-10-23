package student.management;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JTextField;

public class ActionClickBack implements ActionListener{
	JTextField txtID;
	JTextField txtName;
	JTextField txtGroup;
	ResultSet rs;
	
	public ActionClickBack(JTextField txtID, JTextField txtName, JTextField txtGroup, ResultSet rs) {
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
			if (rs.previous()) {
				txtID.setText(rs.getString(1));
				txtName.setText(rs.getString(2));
				txtGroup.setText(rs.getString(3));
			} 
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
