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
public abstract class HangHoa {
    protected String maHang, ngayNhap;
    protected double donGia;
    protected int soLuong;

    public HangHoa() {
    }

    public HangHoa(String maHang, String ngayNhap, double donGia, int soLuong) {
        this.maHang = maHang;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
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
        return maHang + " " + ngayNhap + " " + donGia + " " + soLuong +" ";
    }
    public static void main(String[] args) {
        
    }
}
