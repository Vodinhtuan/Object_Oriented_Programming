/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hinh;

/**
 *
 * @author Admin
 */
public class HInhChuNhat extends HinhVuong{
    private double canh2;

    public HInhChuNhat() {
    }

    public HInhChuNhat(double canh2) {
        this.canh2 = canh2;
    }

    public HInhChuNhat(double canh2, double canh) {
        super(canh);
        this.canh2 = canh2;
    }

    public double getCanh2() {
        return canh2;
    }

    public void setCanh2(double canh2) {
        this.canh2 = canh2;
    }

    
    
    @Override
    public String toString() {
        return "HInhChuNhat{canh= "+canh + "canh2= " + canh2 + '}'+" S= "+dienTich()+" P= "+chuVi();
    }
    public double dienTich(){
        return canh*canh2;
    }
    public double chuVi(){
        return (canh+canh2)*2;
    }
    public static void main(String[] args) {
        HInhChuNhat a =new HInhChuNhat(2,4);
        System.out.println(a);
    }
}
