package bai1;

import java.util.Scanner;

public class TinhTong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int soA, soB;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("nhap so A ");
		soA = scanner.nextInt();
		
		System.out.println("nhap so B ");
		soB = scanner.nextInt();
		
		System.out.println("Tong A va B la " +(soA + soB));
	}

}
