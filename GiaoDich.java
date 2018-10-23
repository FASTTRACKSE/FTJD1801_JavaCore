package baitapatm;

import java.util.Date;

public class GiaoDich {
	private String moTaGiaoDich;
	private String id;
	private Date thoiGian;
	private int soTienGiaoDich;
	
	
	public GiaoDich() {
		super();
	}


	public GiaoDich(String moTaGiaoDich, String id, Date thoiGian, int soTienGiaoDich) {
		super();
		this.moTaGiaoDich = moTaGiaoDich;
		this.id = id;
		this.thoiGian = thoiGian;
		this.soTienGiaoDich = soTienGiaoDich;
	}


	public String getMoTaGiaoDich() {
		return moTaGiaoDich;
	}


	public void setMoTaGiaoDich(String moTaGiaoDich) {
		this.moTaGiaoDich = moTaGiaoDich;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getThoiGian() {
		return thoiGian;
	}


	public void setThoiGian(Date thoiGian) {
		this.thoiGian = thoiGian;
	}


	public int getSoTienGiaoDich() {
		return soTienGiaoDich;
	}


	public void setSoTienGiaoDich(int soTienGiaoDich) {
		this.soTienGiaoDich = soTienGiaoDich;
	}
	


}
