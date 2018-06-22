package bai2;

import java.util.ArrayList;

public class SinhVienException extends Exception {
	String err;

	public SinhVienException() {

	}

	public SinhVienException(String err) {
		this.err = err;
	}

	@Override
	public String toString() {
		return this.err;
	}

	static public void chkHoTen(String hoTen) throws SinhVienException {
		if (hoTen.equals("")) {
			throw new SinhVienException("Ho ten rong");
		}
		String reHoTen = "^[a-zA-Z][a-zA-Z\\s]+";
		if (!hoTen.matches(reHoTen)) {
			throw new SinhVienException("Nhap sai, nhap lai ho va ten");
		}
	}

	static public void chkMaSinhVien(String maSinhVien, ArrayList<SinhVienFpt> arr) throws SinhVienException {
		if (maSinhVien.equals("")) {
			throw new SinhVienException("Ma sinh vien rong, nhap lai");
		}
		for (int i = 0;i<arr.size();i++) {
			if (arr.get(i).getMaSinhVien().equals(maSinhVien)) {
				throw new SinhVienException("Ma sinh vien da ton tai, nhap ma so khac");
			}
		}
	}
	static public void chkDiem (double diem) throws SinhVienException {
		if ((diem<0.0)||(diem>10.0)) {
			throw new SinhVienException("nhap sai, nhap lai");
		}
	}
}
