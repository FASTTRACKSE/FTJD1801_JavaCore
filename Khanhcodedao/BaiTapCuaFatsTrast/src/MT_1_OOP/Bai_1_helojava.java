package MT_1_OOP;

import java.util.Scanner;
public class Bai_1_helojava {     // helo phiem ban 1.1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int luachon;
		System.out.println(" ----------MENU----------");
		System.out.println(" 1 : chi in nhung dong le .");
		System.out.println(" 2 : chi in nhung dong chan .");
		System.out.println(" 3 : thoat chuong trinh ");
		System.out.println("============================ ");
		
		do {
		System.out.println(" moi ban nhap vao lua chon . ");
		luachon = Integer.parseInt(sc.nextLine());
		
		switch(luachon) {
			case 1 :{
					for(int i =0; i<10; i++){
						while(i%2==1) {
							System.out.println((i)+"  abc xyz  .....  blabla");
							break;
						}
					}	
					break;
			}
			
			
			case 2 :{
				for(int i =0; i<10; i++){
					while(i%2==1) {
						System.out.println((i+1)+"  abc xyz  .....  blabla");
						break;
					}
				}
				break;
			
			}
			
			case 3 :{
				System.out.println(" ban da thoat chuong trinh . ");
				break;
			}
			
				default :{
					System.out.println(" ban da nhap sai vui long nhap lai .");
					System.out.println("------------------------------------");
				}
		}
		
		}while(luachon!=3);
	}
}


