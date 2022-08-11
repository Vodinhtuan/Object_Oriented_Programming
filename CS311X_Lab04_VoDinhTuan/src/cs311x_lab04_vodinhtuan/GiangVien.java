/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311_x_lec17_vodinhtuan;

/**
 *
 * @author Admin
 */
public class GiangVien extends Nguoi{
    private String monDay;
    private double soGio, donGia;

    public GiangVien() {
    }

    public GiangVien(String monDay, double soGio, double donGia, String ma, String hoTen, String ngaySinh, boolean gioiTinh) {
        super(ma, hoTen, ngaySinh, gioiTinh);
        this.monDay = monDay;
        this.soGio = soGio;
        this.donGia = donGia;
    }

    public String getMonDay() {
        return monDay;
    }

    public void setMonDay(String monDay) {
        this.monDay = monDay;
    }

    public double getSoGio() {
        return soGio;
    }

    public void setSoGio(double soGio) {
        this.soGio = soGio;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "GiangVien" +super.toString() + soGio + " " + donGia + " Tính Thành Tiền: "+tinhThanhTien()+ monDay;
    }
    public double tinhThanhTien(){
        return soGio*donGia;
    }//String monDay, double soGio, double donGia, String ma, String hoTen, String ngaySinh, boolean gioiTinh
    public static void main(String[] args) {
        GiangVien a = new GiangVien(" Trí Tuệ Nhân Tạo",14,20,"011 ","Võ Đình Tuấn ","17.IV.02 ",true);
        System.out.println(a);
    }
}

