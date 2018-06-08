package MT_1_OOP;

public class XepdanhSachHocSinh {
	public static void main(String[] args) {
		String [] HocSinh = new String[]{"a","b","c","d","e"};
		double [] Diem =  {1, 9, 5.5, 4, 8};
	
		
		for(int i =0; i<HocSinh.length;i++) {
			if(Diem[i]<5) {
				System.out.println(" hoc sinh : "+HocSinh[i]);
				System.out.println(" diem :"+Diem[i]);
				System.out.println(" xep loai yeu");
				System.out.println("-------------------------");
			}
			else if(Diem[i]>=5 && Diem[i]<6.5) {
				System.out.println(" hoc sinh : "+HocSinh[i]);
				System.out.println(" diem :"+Diem[i]);
				System.out.println(" xep loai trung binh ");
				System.out.println("-----------------------------");
			}
			else if(Diem[i]>=6.5 && Diem[i]<7.5) {
				System.out.println(" hoc sinh : "+HocSinh[i]);
				System.out.println(" diem :"+Diem[i]);
				System.out.println(" xep loai kha ");
				System.out.println("-----------------------------");
			}
			else if(Diem[i]>=7.5 && Diem[i]<9) {
				System.out.println(" hoc sinh : "+HocSinh[i]);
				System.out.println(" diem :"+Diem[i]);
				System.out.println(" xep loai gioi ");
				System.out.println("-----------------------------");
			}
			else if(Diem[i]>=9 && Diem[i]<=10) {
				System.out.println(" hoc sinh : "+HocSinh[i]);
				System.out.println(" diem :"+Diem[i]);
				System.out.println(" xep loai xuat sac ");
				System.out.println("-----------------------------");
			}
		}
		
		//   xep hoc sinh theo diem tang dan thi chiu 
	}
}
