package MT_1_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QLSV {
	private String name;
	private String id;
	private String address;
	private double gpa;
	
	Scanner sc = new Scanner(System.in);  // khai bao ten sc
	
	public QLSV() {

	}

	public QLSV(String name, String id, String address, double gpa) {
		this.name = name;
		this.id = id;
		this.address = address;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	

	public void nhap() {
		System.out.print(" nhap ten sinh vien : ");
		name = sc.nextLine();
		System.out.print(" nhap id sinh vien : ");
		id = sc.nextLine();
		System.out.print(" nhap dia chi sinh vien :");
		address = sc.nextLine();
		System.out.print(" nhap diem trung binh : ");
		gpa = Double.parseDouble(sc.nextLine());
	}
	
	public void xuat() {
			System.out.printf("\n\t\t %-20s %-10s %-20s %-10s",name ,id ,address,gpa );
	}
	
	public static void main(String[] args) {
		ArrayList <QLSV> danhsachsv = new ArrayList();   // khai bao ArrayList
		int [] Array;      // khai bao ten bien dem
		
				Scanner sc = new Scanner(System.in);
				System.out.println(" 1 : nhap thong tin sinh vien .");
				System.out.println(" 2 : cap nhat thong tim sinh vien theo ID .");
				System.out.println(" 3 : xoa sinh vien theo ID");
				System.out.println(" 4 : hien thi toan bo sinh vien co trong danh sach .");
				System.out.println(" 5 : thoat chuong trinh .");
				
			int luachon;
			do {
				System.out.println("---------------------------------");
				System.out.print(" moi ban nhap lua chon : ");
				luachon = Integer.parseInt(sc.nextLine());
				
				switch(luachon) {
				
				case 1 :{
					System.out.print(" nhap vao so luong sinh vien : ");
					int n = Integer.parseInt(sc.nextLine());
					Array = new int[n];
					for(int i =0; i<Array.length; i++){    
						QLSV sv = new QLSV();      // 1 vong lap se tao ra 1 o nho
						System.out.println(" thong tin sinh vien thu : "+(i+1));
						sv.nhap();                            // doi tuong do se duoc phuong thuc nhapTT tiep don
						danhsachsv.add(sv);                      // sau khi da co thong tin roi thi phai luu lai
					}
					break;
				}
				case 2 :{
					int dem=0;
					String sua;
					System.out.println(" Nhap vao ma so sinh vien can sua : ");
					sua = sc.nextLine();
					
					for(int i =0; i<danhsachsv.size(); i++) {
						if(sua.equalsIgnoreCase(danhsachsv.get(i).getId())) {   // neu thoa dk moi cho chay
							dem++;
							danhsachsv.get(i).nhap();     //  sau khi tim duoc cho nguoi dung nhap lai
							
							System.out.printf("\t\t====DANH SACH SINH VIEN SAU KHI DA SUA====");
							System.out.printf("\n\t\t%-20s %-10s %-20s %-10s ","Ten sinh vien","ID","Dia Chi","DiemTB");
							for(int j=0; j<danhsachsv.size(); j++) {
								danhsachsv.get(j).xuat();	
							}
						}
					}
					if(dem ==0) {
						System.out.println(" khong co sinh vien theo tim kiem cua ban .");
					}
					
					
					System.out.println("");
					break;
				}
				case 3 :{
					int dem=0;
					System.out.println(" Nhap vao ma so sinh vien can xoa : ");
					String xoa = sc.nextLine();
					
					for(int i =0; i<danhsachsv.size(); i++) {
						if(xoa.equalsIgnoreCase(danhsachsv.get(i).getId())) {   // neu thoa dk moi cho chay
							dem++;
							danhsachsv.remove(i);     //  sau khi tim duoc xoa luôn
							
							System.out.printf("\t\t====DANH SACH SINH VIEN SAU KHI DA SUA====");
							System.out.printf("\n\t\t%-20s %-10s %-20s %-10s ","Ten sinh vien","ID","Dia Chi","DiemTB");
							for(int j=0; j<danhsachsv.size(); j++) {
								danhsachsv.get(j).xuat();	
							}
						}
					}
					if(dem ==0) {
						System.out.println(" khong co sinh vien theo tim kiem cua ban .");
					}
					
					break;
				}
				case 4 :{  // sap xep theo trinh tu diem giam dan
					Collections.sort(danhsachsv, (QLSV sv1 , QLSV sv2) ->{  // collection.sprt  la cau lenh thuc hien thao tac sap xep theo 1 trinh tu nao do
						if(sv1.getGpa() > sv2.getGpa()){
							return -1;
						}
						else {
							if(sv1.getGpa()==sv2.getGpa()) {
								return 0;
							}
							else {
								return 1;
							}
						}
					});
					System.out.printf("\t\t====DANH SACH SINH VIEN SAU KHI DA SAP XEP====");
					System.out.printf("\n\t\t%-20s %-10s %-20s %-10s ","Ten sinh vien","ID","Dia Chi","DiemTB");
					for(int i =0; i < danhsachsv.size(); i++) {
						danhsachsv.get(i).xuat();
						System.out.println("");
					}
					break;
				}
				case 5 :{
					System.out.println(" ban da thoat chuong trinh .");
					break;
				}
				default :{
					System.out.println(" ban nhap khong dung vui long nhap lai .");
				}
				
				}
		
		}while(luachon != 5);
	}

}
