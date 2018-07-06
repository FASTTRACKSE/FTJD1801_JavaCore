package final_assignment;

import java.io.*;
import java.io.Serializable;
import java.util.Scanner;
import java.util.ArrayList;

public class TheTu implements Serializable {

	String maThe;
	String maPIN;
	ArrayList<TheTu> theTuList = new ArrayList<TheTu>();

	public TheTu() {

	}
	public void taoTheTu() {
		Scanner sc = new Scanner(System.in);
		for (;;) {
		System.out.println("Nhap ma so the: ");
		this.maThe = sc.nextLine();	
		try {
			MyException.chkMaSoThe(maThe);
			break;
		} catch (MyException e) {
			System.err.println(e);
			System.out.println();
		}
		}
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
	
	public void theTu() throws IOException {
	FileOutputStream fos = new FileOutputStream("theTu.dat");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	TheTu the = new TheTu();
	the.taoTheTu();
	theTuList.add(the);
	oos.writeObject(theTuList);
	oos.close();
	fos.close();
}
}
