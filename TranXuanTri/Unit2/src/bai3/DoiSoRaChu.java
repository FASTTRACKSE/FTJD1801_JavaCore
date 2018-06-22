package bai3;

import java.util.Scanner;

public class DoiSoRaChu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("-----------------------------");
		System.out.println("Chuong trinh doi so sang chu");
		System.out.println("Nhap so muon chuyen sang chu");
		System.out.println("Nhap 0 de thoat");
		System.out.println("-----------------------------");
		while (true) {
			System.out.println("Nhap so ");
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			int ngan = number / 1000;
			int tram = (number % 1000) / 100;
			int chuc = (number % 100) / 10;
			int donvi = number % 10;
			if (number >= 10000) {
				System.out.println("Vui long nhap so nho hon 9999");
			} else if (number == 0) {
				break;
			} else {
				switch (ngan) {
				case 1: {
					System.out.print("mot ngan ");
					break;
				}
				case 2: {
					System.out.print("hai ngan ");
					break;
				}
				case 3: {
					System.out.print("ba ngan ");
					break;
				}
				case 4: {
					System.out.print("bon ngan ");
					break;
				}
				case 5: {
					System.out.print("nam ngan ");
					break;
				}
				case 6: {
					System.out.print("sau ngan ");
					break;
				}
				case 7: {
					System.out.print("bay ngan ");
					break;
				}
				case 8: {
					System.out.print("tam ngan ");
					break;
				}
				case 9: {
					System.out.print("chin ngan ");
					break;
				}
				}
				switch (tram) {
				case 0: {
					if (ngan != 0 && (chuc != 0 || donvi !=0)) {
						System.out.print("khong tram ");
					}
					break;
				}
				case 1: {
					System.out.print("mot tram ");
					break;
				}
				case 2: {
					System.out.print("hai tram ");
					break;
				}
				case 3: {
					System.out.print("ba tram ");
					break;
				}
				case 4: {
					System.out.print("bon tram ");
					break;
				}
				case 5: {
					System.out.print("nam tram ");
					break;
				}
				case 6: {
					System.out.print("sau tram ");
					break;
				}
				case 7: {
					System.out.print("bay tram ");
					break;
				}
				case 8: {
					System.out.print("tam tram ");
					break;
				}
				case 9: {
					System.out.print("chin tram ");
					break;
				}
				}
				switch (chuc) {
				case 0: {
					if (ngan != 0 && donvi !=0) {
						System.out.print("le ");
					} else if (tram != 0 && donvi !=0) {
						System.out.print("le ");
					}
					break;
				}
				case 1: {
					System.out.print("muoi ");
					break;
				}
				case 2: {
					System.out.print("hai muoi ");
					break;
				}
				case 3: {
					System.out.print("ba muoi ");
					break;
				}
				case 4: {
					System.out.print("bon muoi ");
					break;
				}
				case 5: {
					System.out.print("nam muoi ");
					break;
				}
				case 6: {
					System.out.print("sau muoi ");
					break;
				}
				case 7: {
					System.out.print("bay muoi ");
					break;
				}
				case 8: {
					System.out.print("tam muoi ");
					break;
				}
				case 9: {
					System.out.print("chin muoi ");
					break;
				}
				}
				switch (donvi) {
				case 0: {
					System.out.println();
					break;
				}
				case 1: {
					System.out.println("mot ");
					break;
				}
				case 2: {
					System.out.println("hai");
					break;
				}
				case 3: {
					System.out.println("ba");
					break;
				}
				case 4: {
					if (chuc < 2) {
						System.out.println("bon");
					} else {
						System.out.println("tu");
					}
					break;
				}
				case 5: {
					if (chuc < 1) {
						System.out.println("nam");
					} else {
						System.out.println("lam");
					}
					break;
				}
				case 6: {
					System.out.println("sau");
					break;
				}
				case 7: {
					System.out.println("bay");
					break;
				}
				case 8: {
					System.out.println("tam");
					break;
				}
				case 9: {
					System.out.println("chin");
					break;
				}
				}
			}
		}
	}
}
