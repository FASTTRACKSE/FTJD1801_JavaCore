import java.util.ArrayList;

public class HelloWorld {

	public static void main(String[] args) {
		String Name;
		int i;
		Name = "Trần Tài Tiên";
		System.out.println("Chào Bạn : "+Name);
		ArrayList danhSach = new ArrayList();
		danhSach.add("Trần Tài Tiên");
		danhSach.add("Trương Thị Mỹ Liên");
		danhSach.add("Nguyễn Văn Tú");
		for(i = 0;i<=danhSach.size() - 1;i++)
		System.out.println(danhSach.get(i));	
		}

}
