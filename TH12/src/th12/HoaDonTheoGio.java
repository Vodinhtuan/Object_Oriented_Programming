
package th12;


public class HoaDonTheoGio extends HoaDon {

    private int soGioThue;

    public HoaDonTheoGio() {
    }

    public HoaDonTheoGio( String maHD, String tenKhach, double donGia, int soGioThue, Date ngayHD) {
        super(maHD, tenKhach, donGia, ngayHD);
        this.soGioThue = soGioThue;
    }

    public int getSoGioThue() {
        return soGioThue;
    }

    public void setSoGioThue(int soGioThue) {
        this.soGioThue = soGioThue;
    }

    
    
    @Override
    public double tinhThanhTien() {
        return soGioThue*donGia;
    }

    @Override
    public String toString() {
        return super.toString()+" " + soGioThue +" " + super.getNgayHD()+" "+tinhThanhTien();
    }
    
}
