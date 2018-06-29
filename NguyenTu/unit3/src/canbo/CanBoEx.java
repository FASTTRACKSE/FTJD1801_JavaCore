package canbo;
import java.util.ArrayList;

public class CanBoEx extends Exception {
	
	String err;

	public CanBoEx() {
		super();
	}

	public CanBoEx(String err) {
		super();
		this.err = err;
	}
	@Override
	public String toString() {
		return this.err;
	}
	static public void chkhoTen(String hoTen) throws CanBoEx{
		if(hoTen.equals("")) {
			throw new CanBoEx("Họ tên rỗng!!!");
		}
		if(hoTen.length() > 40) {
			throw new CanBoEx("Họ tên dài quá kí tự quy định!!!");
		}
	}
	static public void chkTrinhDo(String trinhDo) throws CanBoEx {
		if ((!trinhDo.equals("Cu nhan")) && (!trinhDo.equals("Thac si")) 
		&& !trinhDo.equals("Tien si") ) 
		throw new CanBoEx("Nhap sai trinh do");
		}
	static public void chkChucVu(String chucVu) throws CanBoEx {
		if ((!chucVu.equals("Nhân viên")) && (!chucVu.equals("Phó phòng")) 
		&& !chucVu.equals("Trưởng phòng") ) 
		throw new CanBoEx("Nhập sai chức vụ");
		}
	static public void chkSoNguyen(int n) throws CanBoEx {
		if (n < 0) throw new CanBoEx("So am khong hop le"); 
		}
		static public void chkSoThuc(float n) throws CanBoEx {
		if (n < 0) throw new CanBoEx("So am khong hop le"); 
		}

		static public void chkMaCanBo(String maCanBo, ArrayList<CanBo> arr) throws CanBoEx {

		for (int i = 0; i < arr.size(); i++) {
		if (arr.get(i).getHoTen().equals(maCanBo)) {
		throw new CanBoEx("Ma can bo da ton tai");
		}
		}
}
}
