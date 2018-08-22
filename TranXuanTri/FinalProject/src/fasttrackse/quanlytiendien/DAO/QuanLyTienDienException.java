package fasttrackse.quanlytiendien.DAO;

import java.util.ArrayList;

import fasttrackse.quanlytiendien.entity.KhachHangEntity;

public class QuanLyTienDienException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String err;

	public QuanLyTienDienException() {
		
	}
	public QuanLyTienDienException(String err) {
		this.err = err;
	}
	
	@Override
	public String toString() {
		return this.err;
	}

	static public void chckTien (double tienDien) throws QuanLyTienDienException {
		if (tienDien == 0) {
			throw new QuanLyTienDienException ("Nhập sai chỉ số công tơ điện");
		}
	}
	static public void chckText (String text) throws QuanLyTienDienException {
		if (text.equals("")) {
			throw new QuanLyTienDienException ("Vui lòng nhập đầy đủ thông tin");
		}
	}
	static public void chckComboBox (int choice) throws QuanLyTienDienException {
		if (choice == 0) {
			throw new QuanLyTienDienException ("Vui lòng lựa chọn");
		}
	}
	static public void chckMaKH (String maKH) throws QuanLyTienDienException {
		ThongKeDAO kh = new ThongKeDAO();
		ArrayList<KhachHangEntity> khList =kh.taoListKH();
		for (KhachHangEntity kh1:khList) {
			if (kh1.getMaKhachHang().equals(maKH)) {
				throw new QuanLyTienDienException ("Vui lòng nhập mã khách hàng khác");
			}
		}
	}
}
