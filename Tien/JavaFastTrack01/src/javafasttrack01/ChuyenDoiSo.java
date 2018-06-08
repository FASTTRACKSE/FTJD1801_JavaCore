package javafasttrack01;

import java.util.Scanner;

public class ChuyenDoiSo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int so, dem = 0, quyDoi;
		String loiViet = "";		
		Scanner input = new Scanner(System.in);
		System.out.println("Nhập số cần chuyển: ");
		so = input.nextInt();
		while(so > 9999) {
			System.out.println("Số nhập vào phải nhỏ hơn 9999! \nMời bạn nhập lại: ");
			so = input.nextInt();
		}
		int kiemTra = so%10;		
		while(so>0) {			
			quyDoi = so%10;
			so = so/10;
			dem += 1;
			if(dem == 2 && quyDoi >= 2 && kiemTra == 4) {
				loiViet = "tư ";
			}
			if(dem == 2 && quyDoi >= 1 && kiemTra == 5) {
				loiViet = "lăm "; 
			}
			if(dem == 2 && quyDoi >=2 && kiemTra == 1) {
				loiViet = "mốt ";
			}
			switch(quyDoi) {
				case 0: if(dem == 1) {				
							loiViet = "" + loiViet;
						}else if(dem == 2) {
							loiViet = "lẻ " + loiViet;
						}else if(dem == 3) {
							loiViet = "không trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "" + loiViet;
						} break;
				case 1: if(dem == 1) {				
							loiViet = "một " + loiViet;
						}else if(dem == 2) {
							loiViet = "mười " + loiViet;
						}else if(dem == 3) {
							loiViet = "một trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "một nghìn " + loiViet;
						} break;
				case 2: if(dem == 1) {				
							loiViet = "hai " + loiViet;
						}else if(dem == 2) {
							loiViet = "hai mươi " + loiViet;
						}else if(dem == 3) {
							loiViet = "hai trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "hai nghìn " + loiViet;
						} break;
				case 3: if(dem == 1) {				
							loiViet = "hai " + loiViet;
						}else if(dem == 2) {
							loiViet = "hai mươi " + loiViet;
						}else if(dem == 3) {
							loiViet = "hai trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "hai nghìn " + loiViet;
						} break;
				case 4: if(dem == 1) {				
							loiViet = "bốn " + loiViet;
						}else if(dem == 2) {
							loiViet = "bốn mươi " + loiViet;
						}else if(dem == 3) {
							loiViet = "bốn trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "bốn nghìn " + loiViet;
						} break;
				case 5: if(dem == 1) {				
							loiViet = "năm " + loiViet;
						}else if(dem == 2) {
							loiViet = "năm mươi " + loiViet;
						}else if(dem == 3) {
							loiViet = "năm trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "năm nghìn " + loiViet;
						} break;
				case 6: if(dem == 1) {				
							loiViet = "sáu " + loiViet;
						}else if(dem == 2) {
							loiViet = "sáu mươi " + loiViet;
						}else if(dem == 3) {
							loiViet = "sáu trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "sáu nghìn " + loiViet;
						} break;
				case 7: if(dem == 1) {				
							loiViet = "bảy " + loiViet;
						}else if(dem == 2) {
							loiViet = "bảy mươi " + loiViet;
						}else if(dem == 3) {
							loiViet = "bảy trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "bảy nghìn " + loiViet;
						} break;
				case 8: if(dem == 1) {				
							loiViet = "tám " + loiViet;
						}else if(dem == 2) {
							loiViet = "tám mươi " + loiViet;
						}else if(dem == 3) {
							loiViet = "tám trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "tám nghìn " + loiViet;
						} break;
				case 9: if(dem == 1) {				
							loiViet = "chín " + loiViet;
						}else if(dem == 2) {
							loiViet = "chín mươi " + loiViet;
						}else if(dem == 3) {
							loiViet = "chín trăm " + loiViet;
						}else if(dem == 4) {
							loiViet = "chín nghìn " + loiViet;
						} break;
			}
		}
		System.out.println("Kết quả: " + loiViet);
	}

}
