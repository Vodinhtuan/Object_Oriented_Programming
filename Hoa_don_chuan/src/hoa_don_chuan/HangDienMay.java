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
public class HangDienMay extends HangHoa implements IHangHoa{
     private String noiSanXuat;

    public HangDienMay() {
    }

    public HangDienMay(String noiSanXuat, String maHang, String ngayNhap, double donGia, double soLuong) {
        super(maHang, ngayNhap, donGia, soLuong);
        this.noiSanXuat = noiSanXuat;
    }

    public String getNoiSanXuat() {
        return noiSanXuat;
    }

    public void setNoiSanXuat(String noiSanXuat) {
        this.noiSanXuat = noiSanXuat;
    }

    @Override
    public String toString() {
        return "HangDienMay{"  +super.toString()+ "noiSanXuat=" + noiSanXuat + tinhThanhTien()+'}';
    }
     
    @Override
    public double tinhThanhTien() {
         if(noiSanXuat.equalsIgnoreCase("TN"))
             return soLuong*donGia;
         return soLuong*donGia*1.2;
    }
    
}
