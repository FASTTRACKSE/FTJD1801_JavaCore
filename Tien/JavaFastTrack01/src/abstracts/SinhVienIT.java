package abstracts;

public class SinhVienIT extends SinhVienFpt{
	
	private double diemJava;
	private double diemHtml;
	private double diemCss;
	
	
	public SinhVienIT() {
		super();
	}

	
	public SinhVienIT(double diemJava, double diemHtml, double diemCss) {
		super();
		this.diemJava = diemJava;
		this.diemHtml = diemHtml;
		this.diemCss = diemCss;
	}

	
	public double getDiemJava() {
		return diemJava;
	}


	public void setDiemJava(double diemJava) {
		this.diemJava = diemJava;
	}


	public double getDiemHtml() {
		return diemHtml;
	}


	public void setDiemHtml(double diemHtml) {
		this.diemHtml = diemHtml;
	}


	public double getDiemCss() {
		return diemCss;
	}


	public void setDiemCss(double diemCss) {
		this.diemCss = diemCss;
	}


	@Override
	public double getDiem() {
		// TODO Auto-generated method stub
		return (2*diemJava+diemHtml+diemCss)/4;
	}
	
}
