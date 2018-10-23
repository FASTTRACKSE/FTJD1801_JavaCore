package ui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
public class List {
	String ma;
	String ten;
	int index = 0;

	public Vector<Vector> AddList(ResultSet rs) {
		Vector<String> vec = new Vector<String>();
		Vector<String> vec2 = new Vector<String>();
		Vector<Vector> vec3 = new Vector<Vector>();
		try {
			while (rs.next()) {
				ma = rs.getString(1);
				ten = rs.getString(2);
				vec.add(ma);
				vec2.add(ten);
				vec3.add(vec);
				vec3.add(vec2);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return vec3;
	}
}
