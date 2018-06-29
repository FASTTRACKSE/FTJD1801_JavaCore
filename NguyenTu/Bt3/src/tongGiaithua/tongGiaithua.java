package tongGiaithua;

import java.util.Scanner;

public class tongGiaithua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n,i,S=1;
		int Tong=0;
		System.out.println("Nhập giá trị n ");
		n=sc.nextInt();
		for(i=1;i<=n;i++) {
			S=S*i;
			Tong=Tong+S;
		}
		System.out.println("Tổng S là: " +Tong );
	}

}
