package sinhVien;

import java.util.ArrayList;

public class SinhVienException extends Exception {
	String err;

	public SinhVienException() {
		super();
	}

	public String getErr() {
		return err;
	}

	public void setErr(String err) {
		this.err = err;
	}

	public SinhVienException(String err) {
		super();
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
		String ckeck = "^[a-zA-Z\\s]+";
		if (hoTen.matches(ckeck) == false) {
			throw new SinhVienException("Tên của bạn phải từ A-z và kí tự phải từ 1-50");
		}

	}

	static public void checkMaSV(String maSV, ArrayList<SinhVienFpt> arr) throws SinhVienException {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getMaSV().equals(maSV)) {
				throw new SinhVienException("Trùng mã sinh viên!!!!!!!");
			}
		}
		if (maSV.equals("")) {
			throw new SinhVienException("Mã sinh viên không được rỗng!!!");
		}
	}
	static public void checkDiem(double diem) throws SinhVienException{
		if (diem<0 || diem>10 == false) {
			throw new SinhVienException("Điểm sinh viên phải nhập từ 0 đến 10!!!");
		}
	}
	static public void checkTuoi(int tuoi) throws SinhVienException{
		if (tuoi != (int)tuoi) {
			throw new SinhVienException("Tuổi phải là kiểu số nguyên!!");
			
		}
		if (tuoi <0 || tuoi>100) {
			throw new SinhVienException ("Tuổi sinh viên phải nằm trong khoảng 0 đến 100");
		}
	}

}
