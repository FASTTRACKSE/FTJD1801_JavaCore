package baitap9;

import java.util.Scanner;

public class BangCuuChuong {
	 public BangCuuChuong() {
	    }

	public static void main(String[] args) {
		 Scanner nc=new Scanner(System.in);
	       
	        System.out.println("hãy nhập vào một số của bảng cửu chương:");
	        int i=nc.nextInt();
	       int num=1;
	        while(num<=10){
	            System.out.printf("\n%d * "+i+" = %d",num,(num * i));
	            num++;
	        }
		

	}

}
