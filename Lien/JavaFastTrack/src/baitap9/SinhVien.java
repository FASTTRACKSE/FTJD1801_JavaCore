package baitap9;
import java.util.Scanner;
public class SinhVien {

	public static void main(String[] args) {
		
		String tenTrungGian , hocLuc;
		String tenSV[] =  {"Trương Thị Mỹ Liên" , "Trần Thị Mỹ Châu" , "Nguyễn Thị Lan Hương" , "Hồ Thị Ngọc Giàu"};
		double[] Diem = {7.6 , 8.5 , 9.2 , 5.3};
		double diemTrungGian;
		for(int i = 0; i< tenSV.length-1; i++) {
			for(int j = i + 1 ; j < tenSV.length; j++) {
				if(Diem[i]>Diem[j]) {
					diemTrungGian  = Diem[i];
					Diem[i] = Diem[j];
					Diem[j] = diemTrungGian;
					tenTrungGian = tenSV[j];
					tenSV[j] = tenTrungGian;
					
				}
			}
		}
		for(int t=0;t<=tenSV.length-1; t++) {
			if(Diem[t]<5) {
				hocLuc = "Yếu";
				
			}
			else if(Diem[t]<6.5) {
				hocLuc = "Trung Bình";
			}
			else if(Diem[t]<8.5) {
				hocLuc = "Khá";
		}
			else if(Diem[t]<9) {
				hocLuc = "Giỏi";
		
			}
			else {
				hocLuc = "Xuất Sắc";
			}
			System.out.println("Tên sinh viên: "+tenSV[t]+"         Điểm sinh viên:" +Diem[t]+"         Học Lực:"+hocLuc);
		}

	}

}
