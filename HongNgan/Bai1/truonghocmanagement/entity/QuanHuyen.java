package entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
public class QuanHuyen {
private String name, districId;
	
	public QuanHuyen() {
		//
	}
	
	public QuanHuyen(String name, String districtId) {
		this.name = name;
		this.districId = districtId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistricId() {
		return districId;
	}

	public void setDistricId(String districId) {
		this.districId = districId;
	}

	
	
	

	
	@Override
	public String toString() {
		return this.name;
	}

}
