/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hanghoa_ihn02;

/**
 *
 * @author Admin
 */
public class HangDienMay extends HangHoa implements IHangHoa{
    
    private String noiSX;

    public HangDienMay() {
    }

    public HangDienMay(String noiSX, String maHang, String ngayNhap, double donGia, double soLuong) {
        super(maHang, ngayNhap, donGia, soLuong);
        this.noiSX = noiSX;
    }

    public String getNoiSX() {
        return noiSX;
    }

    public void setNoiSX(String noiSX) {
        this.noiSX = noiSX;
    }

    @Override
    public String toString() {
        return "HangDienMay{" + super.toString()+ noiSX + tinhThanhTien()+'}';
    }
    

    @Override
    public double tinhThanhTien() {
        if(noiSX.equalsIgnoreCase("TN")){
            return soLuong*donGia;
        }else {
            return soLuong*donGia*1.2;
        }
    }
    
}
