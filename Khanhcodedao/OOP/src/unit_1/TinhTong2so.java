package unit_1;

import java.util.Scanner;
public class TinhTong2so {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int SOa, SOb, tongHAISO;
		System.out.print("   moi ban nhap vao a  : ");
		SOa = Integer.parseInt(sc.nextLine());
		System.out.print("   moi ban nhap vao b  : ");
		SOb = Integer.parseInt(sc.nextLine());
		
		tongHAISO = (SOa+SOb);
		System.out.println("   tong hai so "+SOa+" va "+SOb+" la  : "+tongHAISO);
	}
}