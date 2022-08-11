/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311x_lab05_vodinhtuan;

/**
 *
 * @author Admin
 */
public abstract class  SV {
    private String ma, hoTen;
    private boolean gioiTinh;

    public SV() {
    }

    public SV(String ma, String hoTen, boolean gioiTinh) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
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

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return  ma + " " + hoTen + " " + (gioiTinh?"Nam":"Nu")+ " " +tinhDTB()+" "+hocLuc();
    }
    public abstract double tinhDTB();
//    public double tinhDTB(){
//        return 0;
//    }
    public String hocLuc(){
        if(tinhDTB()<3)return "Kem";
        if(tinhDTB()<5)return "Yeu";
        if(tinhDTB()<6.5)return "Trung Binh";
        if(tinhDTB()<8)return "Kha";
        if(tinhDTB()<9)return "Gioi";
        return "xuat sac";
    }
    public static void main(String[] args) {
        
    }
         
}
// public abstract double tinhDTB()
