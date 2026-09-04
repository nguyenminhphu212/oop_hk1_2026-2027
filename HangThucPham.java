import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import  java.util.UUID;
public class HangThucPham {
    private String maHang;
    private String tenHang;
    private double donGia;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    public HangThucPham(String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        this.maHang = UUID.randomUUID().toString();
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);  
    }
    public void setTenHang(String tenHang) {
        if(tenHang != null && !tenHang.isEmpty()) {
            this.tenHang = tenHang;
        }
        else {
            this.tenHang = "xxx";
        }
    }
    public void setDonGia(double donGia) {
        if(donGia >= 0) {
            this.donGia = donGia;
        }
        else {
            throw new IllegalArgumentException("Don gia phai lon hon hoac bang 0");
        }
    }
    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if(ngaySanXuat.isBefore(LocalDate.now())) {
            this.ngaySanXuat = ngaySanXuat;
        }
        else {
            throw new IllegalArgumentException("Khong hop le");
        }
    }
    public void setNgayHetHan(LocalDate ngayHetHan) {
        if(ngayHetHan.isAfter(ngaySanXuat)) {
            this.ngayHetHan = ngayHetHan;
        }
        else {
            throw new IllegalArgumentException("Khong hop le");
        }
    }
    public String getMaHang() {
        return maHang;
    }
    public String getTenHang() {
        return tenHang;
    }
    public double getDonGia() {
        return donGia;
    }
    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }
    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }
    public boolean  checkNgayHetHan() {
        if(LocalDate.now().isAfter(ngayHetHan) || LocalDate.now().isEqual(ngayHetHan)) {
            System.out.println("Da het han");
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-5s  %-30s  %,10.2f  %-15s  %-15s  %-5s", maHang, tenHang, donGia, ngaySanXuat.format(formatter), ngayHetHan.format(formatter), checkNgayHetHan());
    }
    public static void main(String[] args) {
        HangThucPham hang1 = new HangThucPham("Gao", 100000, LocalDate.of(2026, 7, 10), LocalDate.of(2027, 7, 10));
        HangThucPham hang2 = new HangThucPham("Mi", 5000, LocalDate.of(2026, 7, 10), LocalDate.of(2028, 10, 1)); 
        HangThucPham hang3 = new HangThucPham("Nuoc", 10000, LocalDate.of(2026, 3, 01), LocalDate.of(2026, 9, 04));
        System.out.println(String.format("%-40s  %-30s  %15s  %-15s  %-15s  %-15s", "Ma hang", "Ten hang", "Don gia", "Ngay san xuat", "Ngay het han", "Ghi chu"));
        System.out.println(hang1);
        System.out.println(hang2);
        System.out.print(hang3); 
    }
}