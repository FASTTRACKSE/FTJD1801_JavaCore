package unit_2;

import java.util.Scanner;

public class InSoraChu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int so =0;
		while(true) {
			try {
				System.out.print("m�?i bạn nhập vào số : ");
				so = Integer.parseInt(sc.nextLine());
				if(so<0) {
					throw new NumberFormatException();
				}
			}catch(NumberFormatException e) {
				System.out.println(" lưu ý : bạn cần nhập vào số nguyên dương ");
			}
			
		System.out.println("----------------------");

		int ngan = so / 1000;
		int tram = (so % 1000) / 100;
		int chuc = (so % 100) / 10;
		int donvi = so % 10;
		
		if(so !=0 && so <= 9999) {
		switch(ngan) {
			case 1: {
				System.out.print(" một ngàn ");
				break ;
			}
			case 2: {
				System.out.print(" hai ngàn ");
				break ;
			}
			case 3: {
				System.out.print(" ba ngàn ");
				break ;
			}
			case 4: {
				System.out.print(" bốn ngàn ");
				break ;
			}
			case 5: {
				System.out.print(" năm ngàn");
				break ;
			}
			case 6: {
				System.out.print(" sáu ngàn ");
				break ;
			}
			case 7: {
				System.out.print(" bảy ngàn ");
				break ;
			}
			case 8: {
				System.out.print(" tám ngàn ");
				break ;
			}
			case 9: {
				System.out.print(" chín ngàn ");
				break ;
			}
		}
		switch(tram) {
		
			case 0:{
				System.out.print("không trăm ");
				break;
			}
			case 1:{
				System.out.print("một trăm ");
				break;
			}
			case 2:{
				System.out.print("hai trăm ");
				break;
			}
			case 3:{
				System.out.print("ba trăm ");
				break;
			}
			case 4:{
				System.out.print("bốn trăm ");
				break;
			}
			case 5:{
				System.out.print("năm trăm ");
				break;
			}
			case 6:{
				System.out.print("sáu trăm ");
				break;
			}
			case 7:{
				System.out.print("bảy trăm ");
				break;
			}
			case 8:{
				System.out.print("tám trăm ");
				break;
			}
			case 9:{
				System.out.print("chín trăm ");
				break;
			}
		}
		
		switch(chuc) {
			case 0:{
				System.out.print("lẻ ");
				break;
			}
			case 1:{
				System.out.print("mư�?i ");
				break;
			}
			case 2:{
				System.out.print("hai mươi ");
				break;
			}
			case 3:{
				System.out.print("ba mươi ");
				break;
			}
			case 4:{
				System.out.print("bốn mươi ");
				break;
			}
			case 5:{
				System.out.print("năm mươi ");
				break;
			}
			case 6:{
				System.out.print("sáu mươi ");
				break;
			}
			case 7:{
				System.out.print("bảy mươi ");
				break;
			}
			case 8:{
				System.out.print("tám mươi ");
				break;
			}
			case 9:{
				System.out.print("chín mươi ");
				break;
			}
		}
		
		switch(donvi){
			case 0 :{
				break;
			}
			case 1 :{
				if(chuc == 1){
					System.out.print("một ");
					break;
				}
				else {
					System.out.println("mốt ");
					break;
				}
			}
			case 2 :{
				System.out.print("hai ");
				break;
			}
			case 3 :{
				System.out.print("ba ");
				break;
			}
			case 4 :{
				if(chuc >=2) {
					System.out.print("tư ");
					break;
				}
				else {
					System.out.println("bốn ");
					break;
				}
			}
			case 5 :{
				if(chuc ==1) {
					System.out.print("năm ");
					break;
				}
				else {
					System.out.println("lăm ");
					break;
				}
			}
			case 6 :{
				System.out.print("sáu ");
				break;
			}
			case 7 :{
				System.out.print("bảy ");
				break;
			}
			case 8 :{
				System.out.print("tám ");
				break;
			}
			case 9 :{
				System.out.print("chín ");
				break;
			}
		}
		}
		else {
			System.out.println(" lưu ý : bạn cần nhập vào số >0 và <= 9999");
		}
		System.out.printf("\n");
		System.out.println("----------------------------");
		}
		
		}
}
