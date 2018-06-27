package lopsinhvien;

import java.util.ArrayList;

public class SinhVienException extends 	Exception{
	 String err;
	 
	public SinhVienException() {
		super();
	}
	
	public SinhVienException(String errhoTen) {
		super();
		this.err = err;		
 }
	@Override
	public String toString() {
		return this.err;
	}
	
	static public void chkTrinhDo(String hoTen) throws SinhVienException{
		
		if (hoTen.equals("")) {
				throw new SinhVienException(" Ho ten rong");
 }

		 String expression = "^[a-zA-Z\\s]+";	
		 
		  if (!hoTen.matches(expression)){
        throw new SinhVienException("Nhap sai dinh dang")  ;
}   
	}

	static public void idSinhVien(String id, ArrayList<SinhVienFpt> a) throws SinhVienException {
		if (id.equals("")) {
			throw new SinhVienException("Nhap sai moi nhap lai");
		}
	}
	
		static public void ktDiem (double diem) throws SinhVienException {
			if ((diem<0.0)||(diem>10.0)) {
				throw new SinhVienException("nhap sai, nhap lai");
			}
		
	
	
	}	
}