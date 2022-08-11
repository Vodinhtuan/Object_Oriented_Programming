/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hanghoa_ihn02;

/**
 *
 * @author Admin
 */
public class HangThuCong extends HangHoa implements IHangHoa{
    
    private String nhaSX;

    public HangThuCong() {
    }

    public HangThuCong(String nhaSX, String maHang, String ngayNhap, double donGia, double soLuong) {
        super(maHang, ngayNhap, donGia, soLuong);
        this.nhaSX = nhaSX;
    }

    public String getNhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    @Override
    public String toString() {
        return "HangThuCong{" + super.toString() + "nhaSX=" + nhaSX + tinhThanhTien()+'}';
    }
    
    @Override
    public double tinhThanhTien() {
        return soLuong*donGia;
    }
}
