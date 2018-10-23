package atm;

import java.io.Serializable;
import java.util.Scanner;

public class TheTu implements Serializable {

	String maThe;
	String maPIN;

	public TheTu() {

	}
	
	public String getMaThe() {
		return maThe;
	}

	public void setMaThe(String maThe) {
		this.maThe = maThe;
	}

	public String getMaPIN() {
		return maPIN;
	}

	public void setMaPIN(String maPIN) {
		this.maPIN = maPIN;
	}


	public void nhapTheTu() {
		Scanner sc = new Scanner(System.in);
		for (;;) {
		System.out.println("Nhap ma PIN: ");
		this.maPIN = sc.nextLine();
		try {
			MyException.chkMaPIN(maPIN);
			break;
		} catch (MyException e) {
			System.err.println(e);
			System.out.println();
		}
		}
	}

	public void xuat() {
		System.out.println(this.maPIN + "||" + this.maThe);
	}

	public boolean dangNhap(String maThe, String maPIN)  {
		if ((maThe.equals(getMaThe()) && (maPIN.equals(getMaPIN())))) {
			return true;
		}else return false;
	}
}
