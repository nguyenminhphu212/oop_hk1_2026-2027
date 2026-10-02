public class HinhTron {
    private double banKinh;
    private ToaDo tam;
    
    public HinhTron(double banKinh, ToaDo tam) {
        this.banKinh = banKinh;
        this.tam = tam;
    }
    public double getBanKinh() {
        return banKinh;
    }
    public void setBanKinh(double banKinh) {
        this.banKinh = banKinh;
    }
    public ToaDo getTam() {
        return tam;
    }
    public void setTam(ToaDo tam) {
        this.tam = tam;
    }
    public double tinhDienTich() {
        return Math.PI * banKinh * banKinh;
    }
    public double tinhChuVi() {
        return 2 * Math.PI * banKinh;
    }
    public static void main(String[] args) {
        ToaDo tam = new ToaDo(3, 4);
        HinhTron hinhTron = new HinhTron(5.0, tam);
        System.out.println("Ban kinh: " + hinhTron.getBanKinh());
        System.out.println("Toa đo tam: (" + hinhTron.getTam().getX() + ", " + hinhTron.getTam().getY() + ")");
        System.out.println("Dien tich: " + hinhTron.tinhDienTich());
        System.out.println("Chu vi: " + hinhTron.tinhChuVi());
    }
}