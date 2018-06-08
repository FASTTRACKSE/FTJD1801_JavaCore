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
		while(so>0) {			
			quyDoi = so%10;
			so = so/10;
			dem += 1;
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
//			if(quyDoi == 0) {
//				if(dem == 1) {				
//					loiViet = "" + loiViet;
//				}else if(dem == 2) {
//					loiViet = "lẻ " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "không trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "" + loiViet;
//				}
//			}else if(quyDoi == 1) {
//				if(dem == 1) {				
//					loiViet = "một " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "mười " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "một trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "một nghìn " + loiViet;
//				}
//			}else if(quyDoi == 2) {
//				if(dem == 1) {				
//					loiViet = "hai " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "hai mươi " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "hai trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "hai nghìn " + loiViet;
//				} 
//			}else if(quyDoi == 3) {
//				if(dem == 1) {				
//					loiViet = "ba " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "ba mươi " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "ba trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "ba nghìn " + loiViet;
//				}
//			}else if(quyDoi == 4) {
//				if(dem == 1) {				
//					loiViet = "bốn " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "bốn mươi " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "bốn trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "bốn nghìn " + loiViet;
//				}
//			}else if(quyDoi == 5) {
//				if(dem == 1) {				
//					loiViet = "năm " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "năm mươi " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "năm trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "năm nghìn " + loiViet;
//				}
//			}else if(quyDoi == 6) {
//				if(dem == 1) {				
//					loiViet = "sáu " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "sáu mươi " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "sáu trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "sáu nghìn " + loiViet;
//				}
//			}else if(quyDoi == 7) {
//				if(dem == 1) {				
//					loiViet = "bảy " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "bảy mươi " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "bảy trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "bảy nghìn " + loiViet;
//				}
//			}else if(quyDoi == 8) {
//				if(dem == 1) {				
//					loiViet = "tám " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "tám mươi " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "tám trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "tám nghìn " + loiViet;
//				}
//			}else if(quyDoi == 9) {
//				if(dem == 1) {				
//					loiViet = "chín " + loiViet;
//				}else if(dem == 2) {
//					loiViet = "chín mươi " + loiViet;
//				}else if(dem == 3) {
//					loiViet = "chín trăm " + loiViet;
//				}else if(dem == 4) {
//					loiViet = "chín nghìn " + loiViet;
//				}
//			}
		}
		System.out.println("Kết quả: " + loiViet);
	}

}
