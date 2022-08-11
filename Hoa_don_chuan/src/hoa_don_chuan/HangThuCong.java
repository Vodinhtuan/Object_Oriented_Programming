/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoa_don_chuan;

/**
 *
 * @author Administrator
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
        return "HangThuCong{" +super.toString() + "nhaSX=" + nhaSX + tinhThanhTien()+'}';
    }
    
    
    @Override
    public double tinhThanhTien() {
        return soLuong*donGia;
    }
    
}
