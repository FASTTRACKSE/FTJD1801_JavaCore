package service;

import java.sql.ResultSet;
import java.sql.Statement;
import object.KhachHang;
import ui.QuanLyKhachHangUi;
public class ThongTinService extends Connect {
	ResultSet rs = null;
	Statement stmt;
	
	public void KhachHang(int id, String hoTen, String diaChi, String phuong, String quan, int dienThoai, int soThe,
			String email, int soTaiKhoan) {

		
	}	
		
 public void ThongTinService() {
			// TODO Auto-generated method stub

		try {
				stmt = con.createStatement();
				rs = stmt.executeQuery("select * from khachhang");
			
			
		
			

		} catch (Exception ex) {
			System.out.println(ex);
		}
		}
}


