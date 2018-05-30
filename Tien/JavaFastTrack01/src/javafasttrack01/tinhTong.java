package javafasttrack01;

import java.util.Scanner;

public class tinhTong {

	public static void main(String[] args) {
		int soA, soB, tongHaiSo;
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số A: ");
			soA = sc.nextInt();
		System.out.print("Nhập số B: ");
			soB = sc.nextInt();
		tongHaiSo = soA + soB;
		System.out.println("---Kết quả: Tổng 2 số "+soA+" và  "+soB+" là  "+tongHaiSo);
	}

}
