package baitapStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLiSinhVien {
	public String maSV;
	public String tenSv;
	public int tuoiSV;
	public String diaChi;
	public double diemTB;
	ArrayList<QuanLiSinhVien> list = new ArrayList<QuanLiSinhVien>();
	public QuanLiSinhVien() {
		super();
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getTenSv() {
		return tenSv;
	}

	public void setTenSv(String tenSv) {
		this.tenSv = tenSv;
	}

	public int getTuoiSV() {
		return tuoiSV;
	}

	public void setTuoiSV(int tuoiSV) {
		this.tuoiSV = tuoiSV;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public double getDiemTB() {
		return diemTB;
	}

	public void setDiemTB(double diemTB) {
		this.diemTB = diemTB;
	}

	public QuanLiSinhVien(String maSV, String tenSv, int tuoiSV, String diaChi, double diemTB) {
		super();
		this.maSV = maSV;
		this.tenSv = tenSv;
		this.tuoiSV = tuoiSV;
		this.diaChi = diaChi;
		this.diemTB = diemTB;
	}
	public void input() {
		Scanner sc= new Scanner(System.in);
		QuanLiSinhVien sv = new QuanLiSinhVien();
		System.out.println("Nhập số lượng sinh viên:");
		int sl = sc.nextInt();
		for(int i = 0; i< sl; i++) {
			System.out.println("Vui lòng nhập mã sinh viên thứ:" +(i+1)+ ":");
			sv.maSV = sc.nextLine();
			System.out.println("Vui lòng nhập tên sinh viên: ");
			sv.tenSv = sc.nextLine();
			System.out.println("Vui lòng nhập tuổi sinh viên: ");
			sv.tuoiSV = Integer.parseInt(sc.nextLine()) ;
			System.out.println("Vui lòng nhập địa chỉ sinh viên: ");
			sv.diaChi = sc.nextLine();
			System.out.println("Vui lòng nhập điểm trung bình: ");
			sv.diemTB = Double.parseDouble(sc.nextLine());
		}
	}
		public void updateQuanLiSinhVien(){
			QuanLiSinhVien sv = new QuanLiSinhVien();
			Scanner sc= new Scanner(System.in);
			System.out.println("Vui lòng nhập mã sinh viên: ");
			String maSV = sc.nextLine();
			for(int i=0;i < list.size(); i++) {
				if(list.get(i).getMaSV().equals(maSV)) {
					sv = list.get(i);
					System.out.println("Họ và tên: ");
					tenSv = sc.nextLine();
					sv.setTenSv(tenSv);
					System.out.println("Tuổi: ");
					tuoiSV = Integer.parseInt(sc.nextLine());
					sv.setTuoiSV(tuoiSV);
					System.out.println("Địa chỉ: ");
					diaChi = sc.nextLine();
					sv.setDiaChi(diaChi);
					System.out.println("Điểm trung bình: ");
					diemTB = Double.parseDouble(sc.nextLine());
					sv.setDiemTB(diemTB);
				}
				
			}
		}
		public void remove () {
			QuanLiSinhVien sv= new QuanLiSinhVien();
			Scanner sc= new Scanner(System.in);
			System.out.println("Vui lòng nhập  sinh viên cần xóa: ");
			String maSV = sc.nextLine();
			for(int i=0;i < list.size(); i++) {
				if(list.get(i).getMaSV().equals(maSV)) {
					sv = list.get(i);
					list.remove(sv);
				}
			}
		}
		public void sapXep() {
			Collections.sort(list, new Comparator<QuanLiSinhVien>() {
				public int compare(QuanLiSinhVien sv1, QuanLiSinhVien sv2) {
					return sv1.getTenSv().compareTo(sv2.getTenSv());
				}
			});
		}
	public void output() {
		QuanLiSinhVien sv= new QuanLiSinhVien();
		for(int i=0;i < list.size(); i++) {
			sv = list.get(i);
		
		System.out.println("mã sinh viên: "+sv.getMaSV()+ "      tên sinh viên:"+sv.getTenSv()+"     tuổi sinh viên:"+sv.getTuoiSV()+  "địa chỉ:"+sv.getDiaChi()+  "     điểm trung bình:"+sv.getDiemTB());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		QuanLiSinhVien sv = new QuanLiSinhVien();
		Scanner sc= new Scanner(System.in);
		while(true) {
			int mC;
			System.out.println("----------");
			System.out.println("QUẢN LÍ SINH VIÊN");
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Cập nhật sinh viên theo id");
			System.out.println("3. Xóa sinh viên theo id");
			System.out.println("4. Sắp Xếp sinh viên theo tên");
			System.out.println("5. Hiển thị danh sách sinh viên");
			System.out.println("0.Kết thúc chương trình");
			System.out.println("----------");
			System.out.println("Mời bạn chọn: ");
			mC = sc.nextInt();
			switch(mC) {
			case 1: sv.input();break;
			case 2: sv.updateQuanLiSinhVien();break;
			case 3: sv.remove();break;
			case 4: sv.sapXep();break;
			case 5: sv.output();break;
			case 0: System.out.println("kết thúc!");break;
			}
				
			}
				
		
		}
	}

	


