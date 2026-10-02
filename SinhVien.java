
import java.util.Scanner;



public class SinhVien {
    private int maSV;
    private String hoTen;
    private double diemLT;
    private double diemTH;
    public SinhVien() {
        this.maSV = 1;
        this.hoTen = "";
        this.diemLT = 0.0;
        this.diemTH = 0.0;
    }
    public SinhVien(int maSV, String hoTen, double diemLT, double diemTH) {
        setmaSV(maSV);
        setHoten(hoTen);
        setdiemLT(diemLT);
        setdiemTH(diemTH);
    }
    public void setmaSV(int maSV) {
        if(maSV > 0) {
            this.maSV = maSV;
        }
        else {
            this.maSV = 0;
        }
    }
    public void setdiemLT(double diemLT) {
        if(diemLT >= 0 && diemLT <= 10) {
            this.diemLT = diemLT;
        }
        else {
            this.diemLT = 0;
        }
    }
     public void setdiemTH(double diemTH) {
        if(diemTH >= 0 && diemTH <= 10) {
            this.diemTH = diemTH;
        }
        else {
            this.diemTH = 0;
        }
    }
    public void setHoten(String hoTen) {
        this.hoTen = hoTen;
    }
    public int getMaSV() {
        return maSV;
    }
    public String getHoTen() {
        return hoTen;
    }
    public double getDiemLT() {
        return diemLT;
    }
    public double getDiemTH() {
        return diemTH;
    }
    public double diemTB() {
        return (diemLT + diemTH)/2;
    }
    @Override
    public String toString() {
        return String.format("%-5s  %-30s  %10.2f  %10.2f  %10.2f", maSV, hoTen, diemLT, diemTH, diemTB());
    }
    public static final void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinhVien sv1 = new SinhVien(1111, "Nguyen Thanh An", 8.5, 8);
        SinhVien sv2 = new SinhVien(1112, "Tran Thanh Sang", 10, 7);
        SinhVien sv3 = new SinhVien();
        System.out.println("Nhap ma sinh vien: ");
        int maSV = sc.nextInt();
        sc.nextLine();
        System.out.println("Nhap ho va ten sinh vien: ");
        String hoTen = sc.nextLine();
        System.out.println("Nhap diem ly thuyet: ");
        double diemLT = sc.nextDouble();
        System.out.println("Nhap diem thuc hanh: ");
        double diemTH = sc.nextDouble();

        sv3.setmaSV(maSV);
        sv3.setHoten(hoTen);
        sv3.setdiemLT(diemLT);
        sv3.setdiemTH(diemTH);
        System.out.println(String.format("%-5s %-30s %10s %10s %10s", "masv", "hoten", "diemlt", "diemth", "diemtb"));
        System.out.println(sv1);
        System.out.println(sv2);
        System.out.println(sv3);
    }
}
