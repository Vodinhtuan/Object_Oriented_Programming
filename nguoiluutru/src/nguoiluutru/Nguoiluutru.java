/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package nguoiluutru;

/**
 *
 * @author Admin
 */
public class Nguoiluutru {

    String ten;
    private String diaChi, ngaySinh;
    private boolean gioiTinh;
    public Nguoiluutru(){
    }
    public Nguoiluutru(String ten, String diaChi, String ngaySinh, boolean gioiTinh){
        this.ten=ten;
        this.diaChi= diaChi;
        this.ngaySinh= ngaySinh;
        this.gioiTinh= gioiTinh;
    }

    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public boolean isGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return ten+" "+ngaySinh+" "+diaChi+" "+((gioiTinh)?"Nam":"Nu");
    }
    public static void main(String[] args) {
        Nguoiluutru a= new Nguoiluutru("Le Loi","Nui Lam Son","11/11/1200",true);
        System.out.println(a);
    }
}
    /**
     * @param args the command line arguments
     */
  

