package unit8.atm;

import unit4.canbo.CanBoException;

public class MyException extends Exception {
	String err;
	public MyException() {

	}
	public MyException(String errHoTen){
	this.err = errHoTen;
	}
	@Override
	public String toString() {
	return this.err;
	}

	static public void chkHoTen(String hoTen) throws MyException {
	if (hoTen.equals("")) {
	throw new MyException("Ho ten rong");
	}
	if (hoTen.length() > 40) 
	throw new MyException("Ho ten dai qua so ky tu quy dinh");
	}
	static public void chkMaSoThe (String maThe) throws MyException {
		if (maThe.length()!=7) {
			throw new MyException ("Nhap du 7ki tu");
		}
		String reMaThe = "[0-9]{7}";
		if (!maThe.matches(reMaThe)) {
			throw new MyException ("Nhap  khoang 0 den 9");
		}
	}
	static public void chkMaPIN (String maPIN) throws MyException {
		if (maPIN.length()!=4) {
			throw new MyException ("Nhap du 4 ki tu");
		}
		String reMaPIN = "[0-9]{4}";
		if (!maPIN.matches(reMaPIN)) {
			throw new MyException ("Nhap  khoang 0 den 9");
		}
	}
	
}
