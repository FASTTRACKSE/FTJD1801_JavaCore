package sapxepsinhvien;
import java.util.Scanner;
public class SapXepSinhVien {
 
	public static void main(String[] args) {
		 SinhVien a[] = new SinhVien[3];
	        String ten; 
	        int diem;
	        Scanner sc = new Scanner(System.in);
	        for(int i = 0 ; i <3 ; i ++){
	             a[i] = new SinhVien();
	            System.out.println("Moi ban nhap ten sinh vien");
	            ten = sc.nextLine();
	            a[i].setTen(ten);
	            System.out.println("Moi ban nhap diem cho sinh vien");
                diem = sc.nextInt();
	            a[i].setDiem(diem);
	            sc.nextLine();
	        }
	        for(int i = 0; i < 3; i ++){
	            for(int j = i + 1; j < 3 ; j ++){
	                if(a[i].getDiem() > a[j].getDiem()){
	                    SinhVien temp = new SinhVien();
	                    temp = a[i];
	                    a[i] = a[j];
	                    a[j] = temp;
	                }
	            }
	        }
	        System.out.println("Thong tinh sinh vien sau khi sap xep la : ");
	           for(int i = 0; i < 3; i ++){
	        	   System.out.println("Ten cua sv la : " +a[i].getTen());
	        	   if( 5 > a[i].getDiem()) {
	        		   System.out.println("hoc luc yeu " );
	   
	        	   }else if( 5 <= a[i].getDiem() && a[i].getDiem() < 6.5) {
	        		   System.out.println("hoc luc trungbinh " );
	        	   }else if( 6.5 <= a[i].getDiem() && a[i].getDiem() < 7.5) {
	        		   System.out.println("hoc luc kha " );
	        	   }else if( 7.5 <= a[i].getDiem() && a[i].getDiem() < 9) {
	        		   System.out.println("hoc luc gioi " );
	        	   }else if(a[i].getDiem() > 9) {
	        		   System.out.println("hoc luc xuat sac " );
	                   }
	        }
	    }
	    
	}
	class SinhVien{
	    private String ten;
	    private int diem;
	    public void setTen ( String ten) {
	        this.ten = ten;
	    }
	    public String getTen(){
	        return ten;
	    }

	    public void setDiem(int diem){
	        this.diem= diem;
	    }
	    public int getDiem (){
	        return diem;
	    }
	        }
	
		
	
