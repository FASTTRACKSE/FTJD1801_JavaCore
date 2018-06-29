
package unit3;

import sinhvienFPT.SinhVienFPT;

import java.util.ArrayList;

public class SinhVienException extends Exception {

	String err;

	public SinhVienException() {
		super();
	}

	public SinhVienException(String errname) {
		this.err = errname;
	}

	@Override
	public String toString() {
		return this.err;
	}

	static public void chkName(String Name) throws SinhVienException {
		if (Name.equals("")) {
			throw new SinhVienException("Họ tên rỗng!!");
		}
	}

	static public void chkMasvr(String id) throws SinhVienException {
		if (id.equals("")) {
			throw new SinhVienException("Mã sinh viên rỗng!!");
		}
	}

	static public void chkMasv(String Masv, ArrayList<SinhVienFPT> arr) throws SinhVienException {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getMaSv().equals(Masv)) {
				throw new SinhVienException("Mã sinh viên đã tồn tại@@");
			}
		}
	
		}
	static public void chkDiem(double diem) throws SinhVienException{
		if(diem > 10.0) {
			throw new SinhVienException("Vui lòng nhập điểm nhỏ hơn 10");
	}
		}
	static public void chkDiem0(double diem) throws SinhVienException{
		if(diem < 0) {
			throw new SinhVienException("Vui lòng nhập điểm lớn hơn 0");
		}
	}

	// public static void main(String[] args) {
	// // TODO Auto-generated method stub
	// for(;;) {
	// Scanner sc = new Scanner(System.in);
	// System.out.println("Nhập họ tên: ");
	// String Name = sc.nextLine();
	//
	// System.out.println("Nhập mã Sv: ");
	// String Masv = sc.nextLine();
	//
	// try {
	// SinhVienException.chkName(Name);
	// break;
	//
	// }catch (SinhVienException e) {
	// System.err.println(e);
	// System.out.println();
	// }
	// for(;;){
	// try{
	// SinhVienException.chkMasv(Masv, arr);
	// break;
	// } catch(SinhVienException ex){
	// System.err.println(ex);
	// System.out.println();
	// }
	// }
	//
	// }
	// }

}
