
package th12;


public abstract class HoaDon implements IHoaDon {
    protected String maHD,tenKhach;
    protected Date ngayHD;
    protected double donGia;

    public HoaDon() {
    }
    
    
    public HoaDon(String maHD, String tenKhach, double donGia, Date ngayHD) {
        this.maHD = maHD;
        this.tenKhach = tenKhach;
        this.ngayHD = ngayHD;
        this.donGia = donGia;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenKhach() {
        return tenKhach;
    }

    public void setTenKhach(String tenKhach) {
        this.tenKhach = tenKhach;
    }

    public Date getNgayHD() {
        return ngayHD;
    }

    public void setNgayHD(Date ngayHD) {
        this.ngayHD = ngayHD;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }
    
    @Override
    public abstract double tinhThanhTien();

    @Override
    public String toString() {
        return this.getClass().getName()+" "+ maHD + " " + tenKhach + " " + donGia ;
    }
    
    
}
