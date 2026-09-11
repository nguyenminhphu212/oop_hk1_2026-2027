
import java.util.Scanner;

public class TestCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so luong CD: ");
        int n = sc.nextInt();
        ListCD ds = new ListCD(n); 

        int choice;
        do { 
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Them CD");
            System.out.println("2. Hien thi danh sach CD");
            System.out.println("3. Hien thi so luong CD");
            System.out.println("4. Tinh tong gia thanh");
            System.out.println("5. Sap xep giam dan theo gia thanh");
            System.out.println("6. Sap xep tang dan theo tua CD");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
                case 1:
                    System.out.print("Nhap ma CD: ");
                    String maCD = sc.nextLine();

                    System.out.print("Nhap tua CD: ");
                    String tuaCD = sc.nextLine();

                    System.out.print("Nhap ca si: ");
                    String caSi = sc.nextLine();

                    System.out.print("Nhap so bai hat: ");
                    int soBaiHat = sc.nextInt();

                    System.out.print("Nhap gia thanh: ");
                    float giaThanh = sc.nextFloat();

                    CD cd = new CD(maCD, tuaCD, caSi, soBaiHat, giaThanh);

                    if (ds.themCD(cd)) {
                        System.out.println("Them CD thanh cong!");
                    } else {
                        System.out.println("Them CD that bai!");
                    }
                    break;
                     case 2:
                    System.out.println("\n===== DANH SACH CD =====");
                    System.out.println(ds);
                    break;

                case 3:
                    System.out.println("So luong CD: " + ds.soLuongCD());
                    break;

                case 4:
                    System.out.println("Tong gia thanh: " + ds.tongGiaThanh());
                    break;

                case 5:
                    ds.xepTheoGia();
                    System.out.println("Da sap xep giam dan theo gia thanh.");
                    System.out.println(ds);
                    break;

                case 6:
                    ds.xepTheoTuaDe();
                    System.out.println("Da sap xep tang dan theo tua CD.");
                    System.out.println(ds);
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
        }
    }
    while(choice != 0);
}
}