/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311x_vodinhtuan_quanlybaigiuxe;

/**
 *
 * @author Admin
 */
public class XeMay extends LoaiXe implements IBaiGiuXe{
    
    private String khuVuc;

    public XeMay() {
    }

    public XeMay(String khuVuc, String maVe, String ngayGui, double donGia, double soLuong) {
        super(maVe, ngayGui, donGia, soLuong);
        this.khuVuc = khuVuc;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    @Override
    public String toString() {
        return "XeMay " + super.toString() + " khuVuc: " + khuVuc + " Thành tiền: " + tinhThanhTien();
    }
    
    @Override
    public double tinhThanhTien() {
        return soLuong * donGia;
    }
    
}
