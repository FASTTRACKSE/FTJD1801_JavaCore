// tinh tong tu 1 den N . voi N lagiatri nhap tu ban phim
// s = 1+2+3+4+....+n
package MT_1_OOP;

import java.util.Scanner;
public class tinhtongtu1denN {
	static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n, Tong =0;
		System.out.println(" moi ban nhap vao n :");
		n = Integer.parseInt(sc.nextLine());
		
		
		for(int i=0;i<=n; i++) {
			Tong = (Tong+i);
		}
		System.out.println(" tong cac so nho hon "+n+" la : "+Tong);

	}
}