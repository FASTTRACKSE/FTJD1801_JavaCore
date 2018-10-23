package quanlysinhvien.entity;

import java.io.Serializable;

public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String hoTen;
	private int namSinh;
	private int id;
	
	public SinhVien () {
		super();
	}
	public SinhVien(int id,String hoTen, int namSinh) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

}
