package abstracts;

import java.util.ArrayList;

public class SinhVienException extends Exception {
	String err;

	public SinhVienException() {
		super();
	}

	public SinhVienException(String err) {
		super();
		this.err = err;
	}

	@Override
	public String toString() {
		return this.err;
	}

	static public void checkHoTen(String hoTen) throws SinhVienException {
		if (hoTen.equals("")) {
			throw new SinhVienException("Họ tên không được rỗng!!!");
		}
		String checkFormat = "^[a-zA-Z\\s]+";
		if (hoTen.matches(checkFormat) == false) {
			throw new SinhVienException("Họ tên phải có ký tự A đến z hoặc khoảng trống và từ 1 đến 40 ký tự!!!");
		}
	}

	static public void checkMaSV(String maSV, ArrayList<SinhVienFpt> arr) throws SinhVienException {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getMaSV().equals(maSV)) {
				throw new SinhVienException("Mã sinh viên đã có!!!");
			}
		}
		if(maSV.equals("")) {
			throw new SinhVienException("Mã sinh viên không được rỗng!!!");
		}
	}
	static public void checkDiem(double diem) throws SinhVienException{
		if(diem < 0 || diem > 10) {
			throw new SinhVienException("Điểm phải nằm trong khoảng từ 0.0 đến 10.0!!!");
		}
	}
	static public void checkTuoi(int tuoi) throws SinhVienException{
		if(tuoi == (int)tuoi) {
			throw new SinhVienException("Tuổi phải là kiểu số nguyên!!!");
		}
		if(tuoi < 0 || tuoi > 100) {
			throw new SinhVienException("Tuổi phải nằm trong khoảng từ 0 đếm 100!!!");
		}
	}
}
