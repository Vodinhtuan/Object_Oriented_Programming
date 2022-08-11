
package th10;


public abstract class HangHoa {
    protected String ma,ns;
    protected NgayThangNam ngaythang;
    protected int soluong,dongia;

    public HangHoa() {
    }

    public HangHoa(String ma, NgayThangNam ngaythang, int soluong, int dongia,String ns) {
        this.ma = ma;
        this.ngaythang = ngaythang;
        this.soluong = soluong;
        this.dongia = dongia;
        this.ns =ns;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }
    
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public NgayThangNam getNgaythang() {
        return ngaythang;
    }

    public void setNgaythang(NgayThangNam ngaythang) {
        this.ngaythang = ngaythang;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getDongia() {
        return dongia;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }
    public abstract double thanhtien();
    @Override
    public String toString() {
        return this.getClass().getName() +" "+ma + " " + ngaythang + " " + soluong + " " + dongia + " "+ns+" "+thanhtien();
    }
    
    
}
