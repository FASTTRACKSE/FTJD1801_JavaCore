package javafasttrack01;

import java.util.Scanner;

public class BangDiemSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int phanTu;		
		String tenSV[] = new String[]{"Trần Tài A" , "Trần Tài B" , "Trần Tài C" , "Trần Tài D" , "Trần Tài E"};
		String tenTG,hocLuc;
		double diemSV[] = new double[]{5.8 , 8.2 , 4.5 , 9.1 , 6.7};
		double diemTG;		
		for(int j = 0; j < tenSV.length-1; j++) {
			for(int k = j + 1; k < tenSV.length; k++) {
				if(diemSV[j]>diemSV[k]) {
					diemTG = diemSV[j];
					diemSV[j] = diemSV[k];
					diemSV[k] = diemTG;
					tenTG = tenSV[j];
					tenSV[j] = tenSV[k];
					tenSV[k] = tenTG;
				}
			}
		}
		for(int l = 0; l <= tenSV.length-1; l++) {
			if(diemSV[l]<5) {
				hocLuc = "Yếu";
			}else if(diemSV[l]<6.5){
				hocLuc = "Trung Bình";
			}else if(diemSV[l]<7.5) {
				hocLuc = "Khá";
			}else if(diemSV[l]<9) {
				hocLuc = "Giỏi";
			}else {
				hocLuc = "Xuất sắc";
			}
			System.out.println("Tên sinh viên: "+tenSV[l]+"   |   Điểm sinh viên: "+diemSV[l]+"   |   Học lực: "+hocLuc);
		}
	}
}
