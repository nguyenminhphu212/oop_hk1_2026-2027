import java.time.LocalDate;
import java.util.UUID;

public class HangThucPham {
    private String maHang;
    private String tenHang;
    private double donGia;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    public HangThucPham(String maHang, String tenHang, double donGia, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
        this.maHang = UUID.randomUUID().toString();
        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySanXuat(ngaySanXuat);
        setNgayHetHan(ngayHetHan);  
    }
    public void setTenHang(String tenHang) {
        if(tenHang != null || !tenHang.isEmpty()) {
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
        if(ngaySanXuat.isBefore(ngayHetHan)) {
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
}