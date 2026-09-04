
import java.util.Scanner;

public class Vehicle {
    private String chuXe;
    private String loaiXe;
    private double triGia;
    private double dungTichXylanh;
    public Vehicle() {

    }
    public Vehicle(String chuXe, String loaiXe, double triGia, double dungTichXyLanh) {
          this.chuXe = chuXe;
          this.loaiXe = loaiXe;
          this.triGia = triGia;
          this.dungTichXylanh = dungTichXyLanh;
    }
    public void setChuXe(String chuXe) {
          this.chuXe = chuXe;
    }
    public void setLoaiXe(String loaiXe) {
        this.loaiXe = loaiXe;
    }
    public void setTriGia(double triGia) {
        if(triGia >= 0) {
            this.triGia = triGia;
        }
        else {
            throw new IllegalArgumentException("Khong hop le");
        }
    }
    public void setDungTichXyLanh(double dungTichXyLanh) {
        if(dungTichXyLanh >= 0) {
            this.dungTichXylanh = dungTichXyLanh;
        }
        else {
            throw new IllegalArgumentException("Khong hop le");
        }
    }
    public String getChuXe() {
        return chuXe;
    }
    public String getLoaiXe() {
        return loaiXe;
    }
    public double getTriGia() {
        return triGia;
    }
    public double getDungTichXyLanh() {
        return dungTichXylanh;
    }
    public double getThue() {
        if(this.dungTichXylanh < 100) {
            return this.triGia * 0.01;
        }
        else if(this.dungTichXylanh >= 100 && this.dungTichXylanh <= 200) {
            return this.triGia * 0.03;
        }
        else {
            return this.triGia * 0.05;
        }
    }
    @Override
    public String toString() {
        return String.format("Chu xe: %s, Loai xe: %s, Tri gia: %.2f, Dung tich: %.2f, Thue: %.2f",chuXe, loaiXe, triGia, dungTichXylanh, getThue());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle xe1 = new Vehicle("Nguyen Thu Loan", "Toyota", 50000, 900);
        Vehicle xe2 = new Vehicle("Nguyen Thi Thanh Thuy", "Mercedes", 100000, 250);
        Vehicle xe3 = new Vehicle();
        System.out.println("Nhap ten chu xe: ");
        String chuXe = sc.nextLine();
        System.out.println("Nhap ten loai xe: ");
        String loaiXe = sc.nextLine();
        System.out.println("Nhap tri gia: ");
        double triGia = sc.nextDouble();
        System.out.println("Nhap dung tich: ");
        double dungTichXyLanh = sc.nextDouble();
        xe3.setChuXe(chuXe);
        xe3.setLoaiXe(loaiXe);
        xe3.setTriGia(triGia);
        xe3.setDungTichXyLanh(dungTichXyLanh);
        System.out.println("Chu xe: %s, Loai xe: %s, Tri gia: %.2f, Dung tich: %.2f, Thue: %.2f");
        System.out.println(xe1);
        System.out.println(xe2);
        System.out.println(xe3);
    }
}