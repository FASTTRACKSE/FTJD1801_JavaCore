package unit_7;

import java.util.Scanner;

public class ATM {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int pass = 0000;
        int dem =0;
        int mk;
        Scanner scanner = new Scanner(System.in);
        
         while(true) {
             System.out.print(" Nhap mat khau : ");
             mk = Integer.parseInt(sc.nextLine());
            
             if(pass == mk) {
            	System.out.println("=-=-=-=-=-=-=-=-=");
		     	System.out.println(" wellcome admin ");
		     	break;
		     	}
             else if(dem==2) {
		          System.out.println(" ban da nhap sai qua so lan quy dinh .");
		          break;
		       }
             else {
		          System.out.println(" ban da nhap sai vui long nhap lai .");
		          System.out.println("------------------------------------");
		          dem++;
		       }
         }
         if(dem ==2) {
        	 while(true) {
        		 
        	 }
         }
         System.out.println(" lenh tiep theo ");
	}
}
