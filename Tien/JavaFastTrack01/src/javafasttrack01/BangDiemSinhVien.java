package javafasttrack01;

import java.util.Scanner;

public class BangDiemSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		String tenSV[] = new String[] {}, tenTG;
		double diemSV[] = new double[] {}, diemTG;		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Nhập vào sinh viên thứ "+(i+1)+" :");
			tenSV[i] = input.nextLine();
			System.out.println("Nhập vào điểm: ");
			diemSV[i] = input.nextDouble();			
			System.out.println("Nhập 'Stop' để dừng!!!");
			if(tenSV[i]=="Stop") {
				break;
			}
			i++;
		}
		for(int j = 0; j <= tenSV.length-1; j++) {
			for(int k = j + 1; k <= tenSV.length; k++) {
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
		for(int l = 0; l <= tenSV.length; l++) {
			System.out.println("Tên sinh viên: "+tenSV[l]+"   |   Điểm sinh viên: "+diemSV[l]);
		}
	}

}
