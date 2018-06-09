package Unit2;

public class TinhDiemTb {

	public static void main(String[] args) {
		String [] SinhVien = new String[]{"Nguyễn Văn A","Trần Văn B","Huỳnh Ngọc C","Trần Văn V","Đỗ M"};
		double [] Diem =  {4, 6.5, 5, 9.5, 8};
		double tam;
		int i;
		for ( i= 0;i<Diem.length;i++) {
			if(Diem[i]<5) {
				System.out.println("Họ Tên   : "+SinhVien[i]);
				System.out.println("Điểm     : "+Diem[i]);
				System.out.println("Học Lực  : Xếp Loại Yếu  ");
				System.out.println("-------------------------");
			}
			
			else if (5<=Diem[i]&& Diem[i]<6.5) {
				System.out.println("Họ Tên   : "+SinhVien[i]);
				System.out.println("Điểm     : "+Diem[i]);
				System.out.println("Học Lực  : Xếp Loại Trung Bình  ");
				System.out.println("-------------------------");
			}
			else if (6.5<=Diem[i]&& Diem[i]<7.5) {
				System.out.println("Họ Tên   : "+SinhVien[i]);
				System.out.println("Điểm     : "+Diem[i]);
				System.out.println("Học Lực  : Xếp Loại Khá  ");
				System.out.println("-------------------------");
			}
			else if (7.5<=Diem[i]&& Diem[i]<9) {
				System.out.println("Họ Tên   : "+SinhVien[i]);
				System.out.println("Điểm     : "+Diem[i]);
				System.out.println("Học Lực  : Xếp Loại Giỏi  ");
				System.out.println("-------------------------");
			}
			else if (Diem[i]>=9 && Diem[i]<=10) {
				System.out.println("Họ Tên   : "+SinhVien[i]);
				System.out.println("Điểm     : "+Diem[i]);
				System.out.println("Học Lực  : Xếp Loại Xuất Sắc  ");
				System.out.println("-------------------------");
			}
		}
		for ( i=0;i<Diem.length-1;i++) {
			for(int j =i+1;j<Diem.length;j++) {
				if(Diem[i]>Diem[j]) {
					tam = Diem[i];
					Diem[i]=Diem[j];
					Diem[j]=tam;
				}
			
			}
			
			
		}
		System.out.println(" Điểm tăng dần là: ");
		for (i=0;i<Diem.length;i++)
			   System.out.print(SinhVien[i]+"\t"+ Diem[i] + "\t");
		

}
}
