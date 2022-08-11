/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dinhtuan;

/**
 *
 * @author Admin
 */
public class sinhvien {
    private String maSv, hoTen, ngaySinh, queQuan;
    private boolean gioiTinh;
    private double diem;

    public sinhvien() {
    }

    public sinhvien(String maSv, String hoTen, String ngaySinh, String queQuan, boolean gioiTinh, double diem) {
        this.maSv = maSv;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.queQuan = queQuan;
        this.gioiTinh = gioiTinh;
        this.diem = diem;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
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

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public double getDiem() {
        return diem;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "sinhvien{" + "maSv=" + maSv + ", hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", queQuan=" + queQuan + ", gioiTinh=" + (gioiTinh?"Nam":"Nu") + ", diem=" + diem + '}';
    }
    public String xepLoai(){
        if(diem<3.5) return "Kem";
        if(diem<5) return "Yeu";
        if(diem<6.5) return "Trung binh";
        if(diem<8) return "Kha";
        if(diem<9) return "Gioi";
        return "Xuat sac";
    }
    //String maSv, String hoTen, String ngaySinh, String queQuan, boolean gioiTinh, double diem
    public static void main(String[] args) {
        sinhvien a = new sinhvien("001","Vó Đình Tuấn","17/IV/2002","Đà Nẵng",true,9.0);
        System.out.println(a);
    }
}
