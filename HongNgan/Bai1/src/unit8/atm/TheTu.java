package unit8.atm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class TheTu implements Serializable {
	private String id;
	private String maPin;
	
	public TheTu() {
		super();
		
	}
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getMaPin() {
		return maPin;
	}

	
	
	public void setMaPin(String maPin) {
		this.maPin = maPin;
	}
	boolean dangNhap(String id,String maPin) {
		if(id.equals(this.id)&& maPin.equals(this.maPin)) {
			return true;
		}
		return false;
		
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		for (;;) {
			System.out.println("Nhap ma PIN: ");
			this.maPin = sc.nextLine();
			try {
				MyException.chkMaPIN(maPin);
				break;
			} catch (MyException e) {
				System.err.println(e);
				System.out.println();
			}
			}
		}
}
	
	

