package test.write.file;

import java.util.Scanner;

public class HelloWord {
	
	public void hello(String ten) {
		System.out.println("Chao ban "+ten);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ten cua ban: ");
		String ten = sc.nextLine();
		HelloWord hl = new HelloWord();
		hl.hello(ten);
	}

}
