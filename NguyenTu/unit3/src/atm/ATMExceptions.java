package atm;

public class ATMExceptions extends Exception {

	String err;

	public ATMExceptions() {

	}

	public ATMExceptions(String err) {
		this.err = err;
	}

	@Override
	public String toString() {
		return this.err;
	}

	static public void chkHoTen(String hoTen) throws ATMExceptions {
		if (hoTen.equals("")) {
			throw new ATMExceptions("Họ tên rỗng, mời nhập lại!!!");
		}
		String reHoTen = "^[a-zA-Z][a-zA-Z\\s]+";
		if (!hoTen.matches(reHoTen)) {
			throw new ATMExceptions("Bạn đã nhập sai, mời nhập lại!!!");
		}
		if (hoTen.length() > 40) {
			throw new ATMExceptions("Họ tên dài quá 40 kí tự, mời nhập lại!!!");
		}
	}

	static public void chkMaSoThe(String maThe) throws ATMExceptions {
		if (maThe.length() != 12) {
			throw new ATMExceptions("Mời nhập đủ 12 kí tự!!");
		}

	}
	static public void chkRutTien (double tienRut, double tienDu) throws ATMExceptions {
		if (tienRut>tienDu) {
			throw new ATMExceptions ("Số tiền hiện có không đủ!!!");
		}
	}
	static public void chkMaPIN (String maPIN) throws ATMExceptions {
		if (maPIN.length()!=6) {
			throw new ATMExceptions ("Mời nhập đủ 6 kí tự!!!");
		}
		
	}
}
