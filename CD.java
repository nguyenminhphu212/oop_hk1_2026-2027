import java.text.MessageFormat;

public class CD {
    private String maCD;
    private String tuaCD;
    private String caSi;
    private int soBaiHat;
    private float giaThanh;

    public CD(String maCD, String tuaCD, String caSi, int soBaiHat, float giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSi = caSi;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public void setcaSi(String caSi) {
        this.caSi = caSi;
    }

    public void setSoBaiHat(int soBaiHat) {
        if (soBaiHat > 0) {
            this.soBaiHat = soBaiHat;
        } else {
            throw new IllegalArgumentException("Du lieu khong hop le");
        }
    }

    public void setGiaThanh(float giaThanh) {
        if (giaThanh > 0) {
            this.giaThanh = giaThanh;
        } else {
            throw new IllegalArgumentException("Du lieu nhap bao khong hop le");
        }
    }

    public String getMaCD() {
        return maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public String getcaSi() {
        return caSi;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public float getGiaThanh() {
        return soBaiHat * giaThanh;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
            "{0} | {1} | {2} | {3} | {4}",
            maCD, tuaCD, caSi, soBaiHat, giaThanh
        );
    }
}