package final_assignment;

import java.io.*;
import java.util.ArrayList;

public class KhoiTaoTaiKhoan implements Serializable {
	ArrayList<TaiKhoan> theTuList = new ArrayList<TaiKhoan>();
	ArrayList<TaiKhoan> idList = new ArrayList<TaiKhoan>();
	ArrayList<TaiKhoan> tkList = new ArrayList<TaiKhoan>();
	
	public void theTu() throws IOException {
			FileOutputStream fos = new FileOutputStream("theTu.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			TaiKhoan tk = new TaiKhoan();
			tk.taoTheTu();
			theTuList.add(tk);
			oos.writeObject(theTuList);
			oos.close();
			fos.close();
	}

	public void ID() throws IOException {
			FileOutputStream fos1 = new FileOutputStream("ID.dat");
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			TaiKhoan tk = new TaiKhoan();
			tk.taoID();
			idList.add(tk);
			oos1.writeObject(idList);
			oos1.close();
			fos1.close();
	}
	public void xuat() throws IOException, ClassNotFoundException {	
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("ID.dat");
			ois = new ObjectInputStream(fis);
			TaiKhoan tk = (TaiKhoan) ois.readObject();
			tk.xuat();
			ois.close();
			fis.close();

	}
	public boolean dangNhap()  {
		System.out.println("Dang nhap vao tai khoan");
		TaiKhoan tk1 = new TaiKhoan();
		tk1.nhap();
		FileInputStream fis = null;
		ObjectInputStream ois = null;

		try {
			fis = new FileInputStream("ID.dat");
			ois = new ObjectInputStream(fis);
			TaiKhoan tk = (TaiKhoan) ois.readObject();
			System.out.println(tk.tenTaiKhoan);
			ois.close();
			fis.close();
			
		if ((tk.tenTaiKhoan.equals(tk1.tenTaiKhoan)) && (tk.maThe.equals(tk1.maThe))) {
			System.out.println("Dung");
			return true;
		} else {
			System.out.println("sai");
			return false;
		}
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public double rutTien(double tienRut, double tienTK) {
		return tienTK - tienRut;
	}
}