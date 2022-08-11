/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguoiSV;

/**
 *
 * @author Admin
 */
public class Nguoi {
    private String ma, hoTen,ngaySinh;
    private boolean GioiTinh;

    public Nguoi() {
    }

    public Nguoi(String ma, String hoTen, String ngaySinh, boolean GioiTinh) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.GioiTinh = GioiTinh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    @Override
    public String toString() {
        return ma+" "+hoTen+" "+ngaySinh+" "+(GioiTinh?"Nam":"Nữ");
    }
    public static void main(String[] args) {
        Nguoi a = new Nguoi("001","Võ Đình Tuấn","17/IV/2002",true);
        System.out.println(a);
                
    }
}
