
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<GiaoDich> ds = new ArrayList<>();

        ds.add(new GiaoDichDat("GD01", LocalDate.of(2013, 9, 15), 10000000, 100, "A"));
        ds.add(new GiaoDichDat("GD02", LocalDate.of(2013, 10, 20), 8000000, 200, "C"));


        ds.add(new GiaoDichNha("Quan 1", "cao cap", "GN01", LocalDate.of(2013, 9, 15), 15000000, 80));
        ds.add(new GiaoDichNha("Go Vap", "thuong", "GN02", LocalDate.of(2013, 8, 5), 12000000, 100));

        //Dem so luong
        int soLuongDat = 0, soLuongNha = 0;
        for (GiaoDich gd: ds) {
            if(gd instanceof GiaoDichDat) {
                soLuongDat++;
            }
            else if(gd instanceof GiaoDichNha) {
                soLuongNha++;
            }
        }
        System.out.println("So luong dat co trong danh sach: " + soLuongDat);
        System.out.println("So luong nha co trong danh sach: " +soLuongNha);

        //Tinh trung binh thanh tien cua giao dich dat
        double tongThanhTien = 0;
        for (GiaoDich gd : ds) {
            if(gd instanceof GiaoDichDat) {
                tongThanhTien += gd.thanhTien();
            }
        }
        System.out.println("Tong thanh tien co trong giao dich dat: " +tongThanhTien);

        //Xuat ra cac giao dich vao thang 9/2013
        for (GiaoDich gd : ds) {
            if(gd.getNgayGiaoDich().getMonthValue() == 9 && gd.getNgayGiaoDich().getYear() == 2013) {
                System.out.println(gd);
            }
        }
    }
}