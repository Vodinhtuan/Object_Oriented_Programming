
package th13;


public abstract class GiaoDich implements IGiaoDich {
    protected String ma;
    protected Date ngaythang;
    protected double dongia,dientich;
    
    public GiaoDich() {
    }

    public GiaoDich(String ma, Date ngaythang, double dongia, double dientich) {
        this.ma = ma;
        this.ngaythang = ngaythang;
        this.dongia = dongia;
        this.dientich = dientich;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgaythang() {
        return ngaythang;
    }

    public void setNgaythang(Date ngaythang) {
        this.ngaythang = ngaythang;
    }

    public double getDongia() {
        return dongia;
    }

    public void setDongia(double dongia) {
        this.dongia = dongia;
    }

    public double getDientich() {
        return dientich;
    }

    public void setDientich(double dientich) {
        this.dientich = dientich;
    }

    
    @Override
    public abstract double ThanhTien();

    @Override
    public String toString() {
        return this.getClass().getName() + " " + ma + " "+ngaythang+" " + dongia + " " + dientich;
    }
    
    
    
}
