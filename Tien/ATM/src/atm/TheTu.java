package atm;

import java.io.Serializable;
import java.util.Scanner;

public class TheTu {
	private String maSo;
	private String maPin;

	public TheTu() {
		super();
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getMaPin() {
		return maPin;
	}

	public void setMaPin(String maPin) {
		this.maPin = maPin;
	}

	boolean dangNhap(String ms, String maPin) {
		if (ms.equals(this.maSo) && maPin.equals(this.maPin)) {
			return true;
		}
		return false;

	}

	public void nhap() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhap ma PIN: ");
		this.maPin = sc.nextLine();
		
	}
	
	public void xuat() {
		System.out.println(this.maPin + "||" + this.maSo);
	}
}