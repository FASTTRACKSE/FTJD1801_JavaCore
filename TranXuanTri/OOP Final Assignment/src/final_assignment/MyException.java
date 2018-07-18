package final_assignment;



public class MyException extends Exception {

	String err;

	public MyException() {

	}
	
	public MyException(String err) {
		this.err = err;
	}
	
	@Override
	public String toString() {
		return this.err;
	}
	static public void chkHoTen (String hoTen) throws MyException {
		if (hoTen.equals("")) {
			throw new MyException ("Ho ten rong, vui long nhap lai ");
		}
		String reHoTen = "^[a-zA-Z][a-zA-Z\\s]+";
		if (!hoTen.matches(reHoTen)) {
			throw new MyException ("Nhap sai, vui long nhap lai ");
		}
		if (hoTen.length()>40) {
			throw new MyException ("Ho ten dai qua 40 ki tu, vui long nhap lai ");
		}
	}
	static public void chkMaSoThe (String maThe) throws MyException {
		if (maThe.length()!=14) {
			throw new MyException ("Nhap du 14 ki tu");
		}
		String reMaThe = "[0-9]{14}";
		if (!maThe.matches(reMaThe)) {
			throw new MyException ("Nhap ki tu trong khoang 0 den 9");
		}
	}
	static public void chkMaPIN (String maPIN) throws MyException {
		if (maPIN.length()!=6) {
			throw new MyException ("Nhap du 6 ki tu");
		}
		String reMaPIN = "[0-9]{6}";
		if (!maPIN.matches(reMaPIN)) {
			throw new MyException ("Nhap ki tu trong khoang 0 den 9");
		}
	}
	static public void chkRutTien (double tienRut, double tienDu) throws MyException {
		if (tienRut>tienDu) {
			throw new MyException ("Nhap sai so tien");
		}
	}
}
