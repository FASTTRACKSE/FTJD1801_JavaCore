package baitapatm;
import java.io.Serializable;
import java.util.Scanner;
public class TheTu  implements Serializable{
	private String id;
	private String PIN;
	
	public TheTu() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getPIN() {
		return PIN;
	}
	public void setPIN(String pIN) {
		PIN = pIN;
	}
	
	boolean dangNhap(String id, String PIN) {
		if(id.equals(this.getId()) && PIN.equals(this.PIN)) {
			return true;
		}
		return false;
	}
	public void nhap() {
		//nhap ma pin
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap ma pin");
		this.PIN = sc.nextLine();
				
		
}

	
}
