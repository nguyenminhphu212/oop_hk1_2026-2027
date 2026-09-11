

public class ListCD {
    private CD[] dsCD;
    int count;
    public ListCD(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("Du lieu khong hop le");
        }
            count = 0;
            dsCD = new CD[n];
    }
    public boolean themCD(CD cd) {
        if(count >= dsCD.length) {
            return false;
        }
        for(int i = 0; i < count; i++) {
            if(dsCD[i].getMaCD().equals(cd.getMaCD())) {
                return false;
            }
        }
        dsCD[count] = cd;
        count++;
        return true;
    }
    public int soLuongCD() {
        return count;
    }
    public float tongGiaThanh() {
        float tong = 0;
        for(int i = 0; i < count; i++) {
            tong += dsCD[i].getGiaThanh();
        }
        return tong;
    }
    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < count; i++) {
            s += dsCD[i] + "\n";
        }
        return s;
    }
    public void xepTheoGia() {
        for(int i = 0; i < count - 1; i++) {
            for(int j = i + 1; j < count; j++) {
                if(dsCD[i].getGiaThanh() < dsCD[j].getGiaThanh()) {
                    CD temp = dsCD[i];
                    dsCD[i] = dsCD[j];
                    dsCD[j] = temp;
                }
            }
        }
    }
    public void xepTheoTuaDe() {
        for(int i = 0; i < count - 1; i++) {
            for(int j = i + 1; j < count; j++) {
                if(dsCD[i].getTuaCD().compareTo(dsCD[j].getTuaCD()) > 0) {
                    CD temp = dsCD[i];
                    dsCD[i] = dsCD[j];
                    dsCD[j] = temp;
                }
            }
        }
    }
}