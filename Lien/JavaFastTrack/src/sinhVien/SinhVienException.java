package sinhVien;

import java.util.ArrayList;

public class SinhVienException extends Exception{
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
		if(hoTen.matches(ckeck) == false) {
		throw new SinhVienException("Tên của bạn phải từ A-z và kí tự phải từ 1-50");	
		}
			
		}

	static public void checkMaSV(String maSV, ArrayList<SinhVienFpt> arr) throws SinhVienException{
		for (int i =0;i<arr.size();i++) {
			if(arr.get(i).getMaSV().equals(maSV)) {
				throw new SinhVienException("Trùng mã sinh viên!!!!!!!");
			}
		}
	}
	

}
