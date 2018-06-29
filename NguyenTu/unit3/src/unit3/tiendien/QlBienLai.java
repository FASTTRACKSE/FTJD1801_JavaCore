package unit3.tiendien;

import java.util.ArrayList;
import java.util.Scanner;

public class QlBienLai  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("1. Nhập thông tin cho hộc sử dụng");
			System.out.println("2. Hiển thị thông tin");
			System.out.println("3. Tính số tiền điện");
			System.out.println("4. Tìm biên lai có tiền thu nhiều nhất");
			System.out.println("5. Sắp xếp biên lai tắng dần theo số tiền phải trả");
			System.out.println("6. Tìm hộ sử dụng điện nhiều nhất.");
			System.out.println("0. Kết thúc chương trình");
			System.out.print("Chọn thao tác");
			Scanner sc = new Scanner(System.in);
			int choice = Integer.parseInt(sc.nextLine());

			ArrayList<BienLai> listBl = new ArrayList<BienLai>();
			switch (choice) {
			case 1:
				Scanner input = new Scanner(System.in);
				System.out.println("Nhập số hộ sử dụng điện: ");
				int soHo = input.nextInt();
				for (int i = 0; i < soHo; i++) {
					BienLai bienlai = new BienLai();
					bienlai.nhap();
					listBl.add(bienlai);
				}
				break;
			case 2:
				for (BienLai list : listBl) {
					list.xuat();
					listBl.add(list);
				}
				break;
			case 3:
				for (int i = 0; i < listBl.size(); i++) {
					System.out.print("Số tiền điện phải trả: " + listBl.get(i).getSoTien());
				}
				break;
			case 4:
				BienLai max = listBl.get(0);
				for (int i = 1; i < listBl.size(); i++) {
					if (listBl.get(i).getSoTien() > max.getSoTien()) {
						max = listBl.get(i);
					}
				}
				max.xuat();
				break;
			case 5:
				BienLai bll = new BienLai();
				for (int i = 0; i < listBl.size() - 1; i++) {
					for (int j = 0; j < listBl.size(); j++) {
						if (listBl.get(i).getSoTien() > listBl.get(j).getSoTien()) {
							bll = listBl.get(i);
							listBl.set(i, listBl.get(j));
							listBl.set(j, bll);
						}
					}
				}
				break;
			}

		}

	}
}
