package lab8;

public class CanBoException extends Exception {
	String err;

	public CanBoException() {
		
	}
	public CanBoException(String err) {
		this.err = err;
	}
	
	@Override
	public String toString() {
		return this.err;
	}
	
	static public void chkHoTen (String hoTen) throws CanBoException {
		if (hoTen.equals("")) {
			throw new CanBoException ("Ho ten rong, vui long nhap lai ");
		}
		String reHoTen = "^[a-zA-Z][a-zA-Z\\s]+";
		if (!hoTen.matches(reHoTen)) {
			throw new CanBoException ("Nhap sai, vui long nhap lai ");
		}
		if (hoTen.length()>40) {
			throw new CanBoException ("Ho ten dai qua 40 ki tu, vui long nhap lai ");
		}
	}
	static public void chkSo (double so) throws CanBoException {
		if (so<0) {
			throw new CanBoException ("Vui long nhap so duong");
		}
	}
	static public void chkSo (int so) throws CanBoException {
		if (so<0) {
			throw new CanBoException ("Vui long nhap so duong");
		}
	}
	static public void chkTrinhDo (String trinhDo) throws CanBoException {
		if (!((trinhDo.equals("cu nhan")) || (trinhDo.equals("thac si")) || (trinhDo.equals("tien si")))) {
			throw new CanBoException ("nhap lai trinh do: cu nhan hoac thac si hoac tien si");
		}
	}
	static public void chkChucVu (String chucVu) throws CanBoException {
		if (!((chucVu.equals("truong phong")) || (chucVu.equals("pho phong")) || (chucVu.equals("nhan vien")))) {
			throw new CanBoException ("nhap lai chuc vu: truong phong hoac pho phong hoac nhan vien");
		}
	}
}