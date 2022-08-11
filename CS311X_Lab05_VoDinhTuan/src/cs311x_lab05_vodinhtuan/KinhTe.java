/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311x_lab05_vodinhtuan;

/**
 *
 * @author Admin
 */
public class KinhTe extends SV{
    private double nlkt, mkt;

    public KinhTe() {
    }

    public KinhTe(double nlkt, double mkt, String ma, String hoTen, boolean gioiTinh) {
        super(ma, hoTen, gioiTinh);
        this.nlkt = nlkt;
        this.mkt = mkt;
    }

    public double getNlkt() {
        return nlkt;
    }

    public void setNlkt(double nlkt) {
        this.nlkt = nlkt;
    }

    public double getMkt() {
        return mkt;
    }

    public void setMkt(double mkt) {
        this.mkt = mkt;
    }

    @Override
    public String toString() {
        return super.toString()+" " + " " + nlkt + " " + mkt ;
    }

    @Override
    public double tinhDTB() {
        return (nlkt*2+mkt)/3; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    public static void main(String[] args) {
        KinhTe a=new KinhTe(9, 9,"001","Vo Dinh Tuan",true);
        System.out.println(a);
    }
}
