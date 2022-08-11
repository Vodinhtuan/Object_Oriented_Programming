/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311x_vodinhtuan_quanlybaigiuxe;

/**
 *
 * @author Admin
 */
public abstract class LoaiXe {
    protected String maVe, ngayGui;
    protected double donGia, soLuong;

    public LoaiXe() {
    }

    public LoaiXe(String maVe, String ngayGui, double donGia, double soLuong) {
        this.maVe = maVe;
        this.ngayGui = ngayGui;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(double soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return maVe + " " + ngayGui + " " + donGia + " " + soLuong ;
    }
}
