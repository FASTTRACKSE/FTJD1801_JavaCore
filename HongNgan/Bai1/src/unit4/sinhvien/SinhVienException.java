package unit4.sinhvien;

import java.util.ArrayList;



public class SinhVienException  extends Exception{
	String err;
	public SinhVienException() {
		
	}
	public SinhVienException( 	String errHoTen) {
		this.err=errHoTen;
	}
	@Override
	public String toString() {
	return this.err;
	}
	static public void chkName(String ten) throws SinhVienException{
		if (ten.equals("")) {
			throw new SinhVienException("Ho ten rong");
		}
		String check ="^[a-zA-Z\\s]+";
		if (ten.matches(check)==false) {
			throw new SinhVienException("Ho ten  a-z hoac khoang trong ");
		}
		
	}
	static public void chkMaSV(String maSv, ArrayList<SinhVienFPT> arr) throws SinhVienException {

		for (int i = 0; i < arr.size(); i++) {
		if (arr.get(i).getMasv().equals(maSv)) {
		throw new SinhVienException("Ma sinh vien da ton tai");
		}
		}
	}
}
