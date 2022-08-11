
package th12;

public class HoaDonTheoNgay extends HoaDon {
    private int soNgayThue;

    public HoaDonTheoNgay(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }

    public HoaDonTheoNgay(String maHD, String tenKhach, double donGia, int soNgayThue, Date ngayHD) {
        super(maHD, tenKhach, donGia, ngayHD);
        this.soNgayThue = soNgayThue;
    }

    public int getSoNgayThue() {
        return soNgayThue;
    }

    public void setSoNgayThue(int soNgayThue) {
        this.soNgayThue = soNgayThue;
    }
    
    @Override
    public double tinhThanhTien() {
       if(soNgayThue>7) return (donGia*0.8)*soNgayThue;
       return donGia*soNgayThue;
    }

    @Override
    public String toString() {
        return super.toString()+" " + soNgayThue +" " + super.getNgayHD()+" "+tinhThanhTien();
    }
    
    
}
