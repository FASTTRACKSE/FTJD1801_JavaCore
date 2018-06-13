package bai3;

import java.util.Scanner;

public class ChuyenSoThanhChu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mangso[] = {"khong", "mot ", "hai ", "ba ", "bon ", "nam ", "sau ", "bay ", "tam ", "chin "};
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int hang_ngan = -1;
		try {
			if (number.length()<4) {
				hang_ngan = -2;
			}
			else if (number.length()==4)  {
				hang_ngan = Integer.parseInt(number.substring(0, 1));
			}
		} catch (Exception ex) {
		}
		int hang_tram = -1;
		try {
			if (number.length()<3) {
				hang_tram=-2;
			}
			else if (number.length()==3)  {
				hang_tram = Integer.parseInt(number.substring(1, 2));
			}
		} catch (Exception ex) {
		}
		int hang_chuc = -1;
		try {
			if (number.substring(2, 3) != "0")
				hang_chuc = Integer.parseInt(number.substring(2, 3));
		} catch (Exception ex) {
		}
		int hang_dv = -1;
		try {
			if (number.substring(3, 4) != "0")
				hang_dv = Integer.parseInt(number.substring(3, 4));
		} catch (Exception ex) {
		}
		if (hang_ngan != -1) {
			switch (hang_ngan) {
			case -2:
				break;
			default: {
				System.out.print(mangso[hang_ngan]);
				System.out.print("ngan ");
			}
			}
		}
		switch (hang_tram) {
		case 0: {
			if ((hang_ngan != 0) && ((hang_chuc != 0) || (hang_dv != 0)))
				System.out.print("khong tram ");
			break;
		}
		default: {
			System.out.print(mangso[hang_tram]);
			System.out.print("tram ");
			break;
		}
		}
		switch (hang_chuc) {
		case 1: {
			System.out.print("muoif ");
			break;
		}
		case 0: {
			if (hang_dv != 0) {
				System.out.print("le ");
			}
			break;
		}
		default: {
			System.out.print(mangso[hang_chuc]);
			System.out.print("muoi ");
			break;
		}
		}
		switch (hang_dv) {
		case 0:
			break;
		case 5: {
			if (hang_chuc < 1) {
				System.out.print("nam");
			} else
				System.out.print("lam");
		}
		case 4: {
			if (hang_chuc < 2) {
				System.out.print("bon");
			} else {
				System.out.print("tu");
			}
			break;
		}
		default: {
			System.out.print(mangso[hang_dv]);
			break;
		}
		}
	}

}
