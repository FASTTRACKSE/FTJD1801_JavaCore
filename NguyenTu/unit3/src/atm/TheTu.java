package atm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class TheTu {
	private String maTK,maPin;

	public TheTu() {
		super();
	}

	public TheTu(String maTK, String maPin) {
		super();
		this.maTK = maTK;
		this.maPin = maPin;
	}

	public String getMaTK() {
		return maTK;
	}

	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}

	public String getMaPin() {
		return maPin;
	}

	public void setMaPin(String maPin) {
		this.maPin = maPin;
	}
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		for(;;) {
			System.out.println("Nhập mã tài khoản: ");
			this.maTK = sc.nextLine();
			try {
				ATMExceptions.chkMaSoThe(maTK);
				break;
			} catch (ATMExceptions e) {
				System.err.println(e);
				System.out.println();
			}
			}
		
		for(;;) {
		System.out.println("Nhập mã Pin: ");
		this.maPin = sc.nextLine();
		try {
			ATMExceptions.chkMaPIN(maPin);
			break;
		} catch (ATMExceptions e) {
			System.err.println(e);
			System.out.println();
		}
		}
	}
	
	public void xuat() {
		System.out.println("Mã TK: "+this.maTK+"  | Mã Pin: "+this.maPin);
	}
	public boolean login(String maTK, String maPin) {
		if((maTK.equals(getMaTK())&&(maPin.equals(getMaPin())))){
			return true;
		}else return false;
	}
	
}
