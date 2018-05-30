package sochan;
import java.util.Scanner;
public class soChan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int n,i,S=1,Tong=0;
		System.out.println("Nhập giá trị n ");
		n=sc.nextInt();
		for(i=0;i<=n;i++) {
			S=S+S*i;
			if(i%2==0) {
				Tong=Tong+S;
			}
			
		}
		System.out.println("Tổng là: " +Tong);
	}

}
