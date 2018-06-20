package abstracts;

public class SinhVienBiz extends SinhVienFpt{
	private double diemMarketing;
	private double diemSales;
	
	public SinhVienBiz() {
		super();
	}
		
	public SinhVienBiz(double diemMarketing, double diemSales) {
		super();
		this.diemMarketing = diemMarketing;
		this.diemSales = diemSales;
	}

	
	public double getDiemMarketing() {
		return diemMarketing;
	}

	public void setDiemMarketing(double diemMarketing) {
		this.diemMarketing = diemMarketing;
	}

	public double getDiemSales() {
		return diemSales;
	}

	public void setDiemSales(double diemSales) {
		this.diemSales = diemSales;
	}

	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return 	(2*diemMarketing+diemSales)/3;
	}
	
}
