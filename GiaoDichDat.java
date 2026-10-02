import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
    protected String loaiDat;
    public GiaoDichDat(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich, String loaiDat) {
        super(maGiaoDich, ngayGiaoDich, donGia, dienTich);
        this.loaiDat = loaiDat;
    }
    @Override 
    public double thanhTien() {
        if(loaiDat.equalsIgnoreCase("A")) {
            return dienTich * donGia * 1.5;
        }
        return dienTich * donGia;
    }
}