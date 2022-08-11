/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311x_vodinhtuan_quanlybaigiuxe;

/**
 *
 * @author Admin
 */
public class XeOto extends LoaiXe implements IBaiGiuXe {

    private String loaiVe;

    public XeOto() {
    }

    public XeOto(String loaiVe, String maVe, String ngayGui, double donGia, double soLuong) {
        super(maVe, ngayGui, donGia, soLuong);
        this.loaiVe = loaiVe;
    }

    public String getLoaiVe() {
        return loaiVe;
    }

    public void setLoaiVe(String loaiVe) {
        this.loaiVe = loaiVe;
    }

    @Override
    public String toString() {
        return "XeOto " + super.toString() + " loaiVe: " + loaiVe + " Thành tiền: " + tinhThanhTien();
    }
    
    @Override
    public double tinhThanhTien() {
        if (loaiVe.equalsIgnoreCase("VT")) {
            return soLuong * donGia;
        } else {
            return soLuong * donGia * 1.5;
        }
    }
}
