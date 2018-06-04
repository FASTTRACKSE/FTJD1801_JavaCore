package bai2;

public class DanhSachSinhVien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sinhVien = new String [] {"A","B","C","D"};
		double[] diem = {2.8,5,9,6.5};
		System.out.println("Thong tin sinh vien");
		for (int i=0;i<sinhVien.length;i++) {
			if (diem[i]<5) {
				System.out.print(sinhVien[i]+"\t");
				System.out.print(diem[i]+"\t");
				System.out.println("Yeu");
			}
			else if (5<=diem[i]&&diem[i]<6.5) {
				System.out.print(sinhVien[i]+"\t");
				System.out.print(diem[i]+"\t");
				System.out.println("Trung binh");
			}
			else if (6.5<=diem[i]&&diem[i]<7.5) {
				System.out.print(sinhVien[i]+"\t");
				System.out.print(diem[i]+"\t");
				System.out.println("Kha");
			}
			else if (7.5<=diem[i]&&diem[i]<9) {
				System.out.print(sinhVien[i]+"\t");
				System.out.print(diem[i]+"\t");
				System.out.println("Gioi");
			}
			else if (9<=diem[i]) {
				System.out.print(sinhVien[i]+"\t");
				System.out.print(diem[i]+"\t");
				System.out.println("Xuat sac");
			}
		}
		System.out.println("Danh sach sinh vien theo thu tu tang dan diem");
		double tam=diem[0];
		String svtam=sinhVien[0];
			for (int a=0;a<sinhVien.length;a++) {
				for (int j=a+1;j<diem.length;j++) {
					if (diem[a]>diem[j]) {
						tam = diem[a];
						diem[a]=diem[j];
						diem[j]=tam;
						svtam = sinhVien[a];
						sinhVien[a]=sinhVien[j];
						sinhVien[j]=svtam;
					}
				}
				System.out.print(sinhVien[a]+"\t");
				System.out.println(diem[a]);
			}
			//Sap xep mang theo pp noi bot (bubble sort)
//			for (int a=0; a<sinhVien.length-1; a++) {
//				for (int j=diem.length-1; j>=1; j--) {
//					if (diem[j-1]>diem[j]) {
//						tam = diem[j];
//						diem[j]=diem[j-1];
//						diem[j-1]=tam;
//						svtam = sinhVien[j];
//						sinhVien[j]=sinhVien[j-1];
//						sinhVien[j-1]=svtam;
//					}
//				}
//				System.out.print(sinhVien[a]+"\t");
//				System.out.println(diem[a]);
//			}
		}
	}
