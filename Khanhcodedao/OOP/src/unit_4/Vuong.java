package unit_4;

public class Vuong extends ChuNhat{
	public int canh ;
	
	public Vuong() {
	
	}

	public Vuong(int canh) {
		this.canh = canh;
	}
	@Override
	public void nhap() {
		System.out.println(" nhap do dai canh : ");
		canh = Integer.parseInt(sc.nextLine());
		chieurong = canh;
		chieudai = canh;
	}
	@Override
	public void xuat() {
		System.out.println(" chu vi hinh vuong canh "+canh +" = "+chuvi+" (dvdd)");
		System.out.println(" dien tich hinh vuong canh "+canh+" = "+dientich+" (dvdt)" );
	}
	
	public static void main(String[] args) {
		Vuong  v = new Vuong();
		v.nhap();
		v.getchuvi();
		v.getdientich();
		v.xuat();
		
	}

}
