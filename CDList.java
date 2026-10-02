// ============================================================
// ========== File 2: CDList.java (Mảng động + Tìm kiếm gần giống) ==========
public class CDList {
    // --------- Thuộc tính ---------
    private CD[] danhSachCD;
    private int soLuong;
    private int khaNang;

    private static final int KICH_THUOC_BAN_DAU = 5;

    // --------- Constructor ---------
    public CDList() {
        khaNang = KICH_THUOC_BAN_DAU;
        danhSachCD = new CD[khaNang];
        soLuong = 0;
    }

    // --------- Getter cơ bản ---------
    public int laySoLuong() { return soLuong; }
    public CD layCDTaiViTri(int i) { return danhSachCD[i]; }

    // --------- Tự động mở rộng mảng ---------
    private void moRongMang() {
        int kichThuocMoi = khaNang * 2;
        CD[] mangMoi = new CD[kichThuocMoi];
        for (int i = 0; i < soLuong; i++)
            mangMoi[i] = danhSachCD[i];
        danhSachCD = mangMoi;
        khaNang = kichThuocMoi;
        System.out.println("↗️ Đã mở rộng mảng lên " + khaNang + " phần tử.");
    }

    // --------- Tìm vị trí theo mã ---------
    public int timViTriTheoMa(int maCD) {
        for (int i = 0; i < soLuong; i++)
            if (danhSachCD[i].getMaCD() == maCD) return i;
        return -1;
    }

    // ========== THÊM (chống trùng + tự mở rộng) ==========
    public boolean themCD(CD cd) {
        if (timViTriTheoMa(cd.getMaCD()) != -1) {
            System.out.println("❌ Lỗi: Mã CD " + cd.getMaCD() + " đã tồn tại!");
            return false;
        }
        if (soLuong == khaNang) moRongMang();
        danhSachCD[soLuong] = cd;
        soLuong++;
        return true;
    }

    // ========== XÓA ==========
    public boolean xoaCD(int maCD) {
        int viTri = timViTriTheoMa(maCD);
        if (viTri == -1) {
            System.out.println("❌ Không tìm thấy CD mã " + maCD);
            return false;
        }
        for (int i = viTri; i < soLuong - 1; i++)
            danhSachCD[i] = danhSachCD[i + 1];
        danhSachCD[soLuong - 1] = null;
        soLuong--;
        return true;
    }

    // ========== SỬA / CẬP NHẬT ==========
    public boolean capNhatCD(int maCD, String tuaMoi,
                            int soBaiMoi, double giaMoi) {
        int viTri = timViTriTheoMa(maCD);
        if (viTri == -1) {
            System.out.println("❌ Không tìm thấy CD mã " + maCD);
            return false;
        }
        CD cd = danhSachCD[viTri];
        cd.setTuaCD(tuaMoi);
        cd.setSoBaiHat(soBaiMoi);
        cd.setGiaThanh(giaMoi);
        return true;
    }

    // ========== TÌM THEO MÃ ==========
    public CD timTheoMa(int maCD) {
        int viTri = timViTriTheoMa(maCD);
        return (viTri == -1) ? null : danhSachCD[viTri];
    }

    // ========== TÌM THEO TỰA CD (3 chế độ) ==========

    /**
     * Tìm theo tiền tố (so khớp từ BÊN TRÁI).
     * Ví dụ: "Nhac" khớp "Nhạc Trịnh", "Nhạc Vàng".
     * @return CDList chứa các CD có tựa bắt đầu bằng tuKhoa.
     */
    public CDList timTheoTienTo(String tuKhoa) {
        CDList ketQua = new CDList();
        String tk = tuKhoa.toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            if (danhSachCD[i].getTuaCD().toLowerCase().startsWith(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }
        return ketQua;
    }

    /**
     * Tìm theo hậu tố (so khớp từ BÊN PHẢI).
     * Ví dụ: "Trinh" khớp "Nhạc Trịnh", "Trịnh Công Sơn".
     * @return CDList chứa các CD có tựa kết thúc bằng tuKhoa.
     */
    public CDList timTheoHauTo(String tuKhoa) {
        CDList ketQua = new CDList();
        String tk = tuKhoa.toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            if (danhSachCD[i].getTuaCD().toLowerCase().endsWith(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }
        return ketQua;
    }

    /**
     * Tìm gần giống (chứa từ khóa ở BẤT KỲ vị trí nào).
     * Đây là tìm kiếm rộng, bao trùm cả tiền tố và hậu tố.
     * @return CDList chứa các CD có tựa chứa tuKhoa.
     */
    public CDList timGanGiong(String tuKhoa) {
        CDList ketQua = new CDList();
        String tk = tuKhoa.toLowerCase();
        for (int i = 0; i < soLuong; i++) {
            if (danhSachCD[i].getTuaCD().toLowerCase().contains(tk)) {
                ketQua.themCD(danhSachCD[i]);
            }
        }
        return ketQua;
    }

    // ========== THỐNG KÊ ==========
    public int tinhSoLuongCD() { return soLuong; }

    public double tinhTongGiaThanh() {
        double tong = 0;
        for (int i = 0; i < soLuong; i++)
            tong += danhSachCD[i].getGiaThanh();
        return tong;
    }

    public double tinhGiaTrungBinh() {
        return (soLuong == 0) ? 0 : tinhTongGiaThanh() / soLuong;
    }

    public CD timCDDatNhat() {
        if (soLuong == 0) return null;
        CD max = danhSachCD[0];
        for (int i = 1; i < soLuong; i++)
            if (danhSachCD[i].getGiaThanh() > max.getGiaThanh())
                max = danhSachCD[i];
        return max;
    }

    public CD timCDReNhat() {
        if (soLuong == 0) return null;
        CD min = danhSachCD[0];
        for (int i = 1; i < soLuong; i++)
            if (danhSachCD[i].getGiaThanh() < min.getGiaThanh())
                min = danhSachCD[i];
        return min;
    }

    // ========== HIỂN THỊ ==========
    public void hienThiDanhSach() {
        if (soLuong == 0) {
            System.out.println("📭 Danh sách CD trống!");
            return;
        }
        System.out.println("\n+-----------+---------------------------+--------------+------------------+");
        System.out.println("|   Mã CD   |          Tựa CD           |  Số bài hát  |    Giá thành     |");
        System.out.println("+-----------+---------------------------+--------------+------------------+");
        for (int i = 0; i < soLuong; i++)
            System.out.println(danhSachCD[i]);
        System.out.println("+-----------+---------------------------+--------------+------------------+");
    }

    // ========== SẮP XẾP ==========
    public void sapXepGiamDanTheoGia() {
        for (int i = 0; i < soLuong - 1; i++)
            for (int j = i + 1; j < soLuong; j++)
                if (danhSachCD[i].getGiaThanh() < danhSachCD[j].getGiaThanh()) {
                    CD temp = danhSachCD[i];
                    danhSachCD[i] = danhSachCD[j];
                    danhSachCD[j] = temp;
                }
        System.out.println("✅ Đã sắp xếp giảm dần theo giá thành.");
    }

    public void sapXepTangDanTheoTua() {
        for (int i = 0; i < soLuong - 1; i++)
            for (int j = i + 1; j < soLuong; j++)
                if (danhSachCD[i].getTuaCD()
                        .compareToIgnoreCase(danhSachCD[j].getTuaCD()) > 0) {
                    CD temp = danhSachCD[i];
                    danhSachCD[i] = danhSachCD[j];
                    danhSachCD[j] = temp;
                }
        System.out.println("✅ Đã sắp xếp tăng dần theo tựa CD.");
    }
}