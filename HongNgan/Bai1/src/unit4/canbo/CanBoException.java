package unit4.canbo;

import java.util.ArrayList;

public class CanBoException extends Exception{
	String err;
	public CanBoException() {

	}
	public CanBoException(String errHoTen){
	this.err = errHoTen;
	}
	@Override
	public String toString() {
	return this.err;
	}

	static public void chkHoTen(String hoTen) throws CanBoException {
	if (hoTen.equals("")) {
	throw new CanBoException("Ho ten rong");
	}
	if (hoTen.length() > 40) 
	throw new CanBoException("Ho ten dai qua so ky tu quy dinh");
	}

	static public void chkTrinhDo(String trinhDo) throws CanBoException {
	if ((!trinhDo.equals("Cu nhan")) && (!trinhDo.equals("Thac si")) 
	&& !trinhDo.equals("Tien si") ) 
	throw new CanBoException("Nhap sai trinh do");
	}
	
	static public void chkTrinhDo2(String trinhDo) throws CanBoException {
	if ((!trinhDo.equals("Truong phong")) && (!trinhDo.equals("Pho phong")) 
	&& !trinhDo.equals("Nhan vien") ) 
	throw new CanBoException("Nhap sai trinh do");
	}
	
	static public void chkSoNguyen(int n) throws CanBoException {
	if (n < 0) throw new CanBoException("So am khong hop le"); 
	}
	static public void chkSoThuc(float n) throws CanBoException {
	if (n < 0) throw new CanBoException("So am khong hop le"); 
	}

	static public void chkMaCanBo(String maCanBo, ArrayList<CanBo> arr) throws CanBoException {

	for (int i = 0; i < arr.size(); i++) {
	if (arr.get(i).getMaCanBo().equals(maCanBo)) {
	throw new CanBoException("Ma can bo da ton tai");
	}
	}
	}
}
