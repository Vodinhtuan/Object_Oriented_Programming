/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlybenhvien;

public class NHANVIEN implements ITIENLUONG {
    private String ma,hoten;
    private  boolean gioitinh;
    private  NgayThang ngaykyhopdong;
    private double mucthuong;
    private int chucvu;

    public NHANVIEN() {
    }
    
    public NHANVIEN(String ma, String hoten, boolean gioitinh, NgayThang ngaykyhopdong, double mucthuong, int chucvu) {
        this.ma = ma;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.ngaykyhopdong = ngaykyhopdong;
        this.mucthuong = mucthuong;
        this.chucvu = chucvu;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public NgayThang getNgaykyhopdong() {
        return ngaykyhopdong;
    }

    public void setNgaykyhopdong(NgayThang ngaykyhopdong) {
        this.ngaykyhopdong = ngaykyhopdong;
    }

    public double getMucthuong() {
        return mucthuong;
    }

    public void setMucthuong(double mucthuong) {
        this.mucthuong = mucthuong;
    }

    public int getChucvu() {
        return chucvu;
    }

    public void setChucvu(int chucvu) {
        this.chucvu = chucvu;
    }
    
    
    @Override
    public double TinhTienLuong(){
       return tienluong*(chucvu+1)+mucthuong;
    }

    @Override
    public String toString() {
        return ma + " " + hoten + " " + gioitinh + " " + ngaykyhopdong + " " + mucthuong + " " + chucvu;
    }    
}
