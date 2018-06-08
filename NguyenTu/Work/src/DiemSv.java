
public class DiemSv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hoTen[] = new String[] {"Nguyễn văn tú","Trần văn a","Nguyễn văn b"}, ten;
		double diem[] = new double[] {8.6,5.6,9.0}, tg;
		String hocLuc=null;
		for (int i = 0; i < diem.length-1; i++) {
			for(int j = i + 1; j < diem.length; j++) {
				if(diem[i] > diem[j]) {
					tg=diem[i];
					diem[i]=diem[j];
					diem[j]=tg;
					ten=hoTen[i];
					hoTen[i]=hoTen[j];
					hoTen[j]=ten;
				}
				
			}
		
		}
		for(int i=0; i < diem.length; i++) {
			if(diem[i] < 5){
				hocLuc= "Yếu";
			}
			else if(diem[i] < 6.5) {
				hocLuc="Trung bình";
				} else if(diem[i] < 7.5) {
					hocLuc="Khá";
					} else if(diem[i] <= 10) {
						hocLuc="Giỏi";
					}
			
			System.out.println("Họ tên SV:  " +hoTen[i]+ "  Điểm: " +diem[i]+ "  Học lực: " +hocLuc);
			
		}
		
	}
}
