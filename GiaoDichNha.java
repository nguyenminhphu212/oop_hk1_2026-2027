
import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich {
    protected String loaiNha;
    protected String diaChi;

    public GiaoDichNha(String diaChi, String loaiNha, String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.diaChi = diaChi;
        this.loaiNha = loaiNha;
    }
    @Override
    public double thanhTien() {
        if(loaiNha.equalsIgnoreCase("cao cap")) {
            return dienTich * donGia;
        }
        return dienTich* donGia * 0.9;
    }
}