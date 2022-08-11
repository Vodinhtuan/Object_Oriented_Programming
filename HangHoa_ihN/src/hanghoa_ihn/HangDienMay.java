/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hanghoa_ihn;

/**
 *
 * @author Admin
 */
public class HangDienMay extends HangHoa implements IHangHoa{
    private String noiSanXuat;
    @Override
    public double tinhThanhTien() {
        if(noiSanXuat.equalsIgnoreCase("TN"))
            return soLuong*donGia;
        else return soLuong*donGia*1.2;
    }

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
        return "HangDienMay " + super.toString()+ " " + noiSanXuat + ' ' +tinhThanhTien();
    }
    
    
}
