package final_assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DangNhap implements Serializable {	
	public boolean dangNhap(String maThe, String maPIN)  {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("TheTu.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<TheTu> the = (ArrayList<TheTu>) ois.readObject();
			for (TheTu the1 : the) {
		if ((maThe.equals(the1.maThe)) && (maPIN.equals(the1.maPIN))) {
//			System.out.println("Dung");
			return true;
		} else {
//			System.out.println("sai");
			return false;
		}
			}
		ois.close();
		fis.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	public double rutTien(double tienRut, String maThe) throws IOException, ClassNotFoundException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
			fis = new FileInputStream("ID.dat");
			ois = new ObjectInputStream(fis);
			ArrayList<ID> id = (ArrayList<ID>) ois.readObject();
			for (ID id1:id) {
				if (maThe.equals(id1.maThe)) {
					System.out.println(id1.soDuTaiKhoan);
					System.out.println(tienRut);
					id1.soDuTaiKhoan = id1.soDuTaiKhoan - tienRut;
					System.out.println(id1.soDuTaiKhoan);
					return id1.soDuTaiKhoan;
				}
			}
			ois.close();
			fis.close();
			return 0;
	}
	  public String showCalendar(Calendar calendar) {
	      int year = calendar.get(Calendar.YEAR);
	      int month = calendar.get(Calendar.MONTH);
	      int day = calendar.get(Calendar.DAY_OF_MONTH);
	      int hour = calendar.get(Calendar.HOUR_OF_DAY);
	      int minute = calendar.get(Calendar.MINUTE);
	      int second = calendar.get(Calendar.SECOND);
	      return  " " + year + "-" + (month + 1) + "-" + day + " "
	              + hour + ":" + minute + ":" + second;
	  }

}