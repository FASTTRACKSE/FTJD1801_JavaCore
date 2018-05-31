package BT1;
import java.util.Scanner; 
public class BT1 {

	public static void main(String[] args) {
    Scanner sc = new Scanner (System. in);
     
		int soA, soB, tongHaiSo ;
	  System.out.print("Nhap soA");
	 soA = sc.nextInt();
	 System.out.print("Nhap soB");
	 soB = sc.nextInt();
	 tongHaiSo = soA + soB ;
	 System.out.print("tong hai so la :" +tongHaiSo);
	}

}