package baitap1;

import java.util.Scanner;

public class TinhTong {

	public static void main(String[] args) {
		int soA , soB , tongHaiSo;
		Scanner s = new Scanner(System.in);
		System.out.println("Nhập vào số A: ");
		soA = s.nextInt();
		System.out.println("Nhập vào số B: ");
		soB = s.nextInt();
		tongHaiSo = soA + soB;
		System.out.println("Kết quả : tổng hai số "+ soA   + " và "  + soB  + " là "  + tongHaiSo);

	}

}
