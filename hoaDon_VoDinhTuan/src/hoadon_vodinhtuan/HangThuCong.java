/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadon_vodinhtuan;

/**
 *
 * @author Administrator
 */
public class HangThuCong extends HangHoa implements IHangHoa{
    private String nhaSanXuat;
    public HangThuCong() {
    }

    public HangThuCong(String nhaSanXuat, String maHang, String ngayNhap, double donGia, int soLuong) {
        super(maHang, ngayNhap, donGia, soLuong);
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "HangThuCong{" +super.toString()+ "nhaSanXuat=" + nhaSanXuat + tinhThanhTien()+'}';
    }

    @Override
    public double tinhThanhTien() {
        return soLuong*donGia;
    }
    public static void main(String[] args) {
        HangThuCong a = new HangThuCong("DienLuc", "3454", "3/5/333", 9000, 50);
        System.out.println(a);
    }
}