/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_gd;

/**
 *
 * @author Admin
 */
public class Bac1 {
    protected double b, c;

    public Bac1() {
    }

    public Bac1(double b, double c) {
        this.b = b;
        this.c = c;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    public String giai(){
        if(b==0){
            if (c==0) {
                return " vo so nghiem. ";
            }else {
                return "vo no";
            }
        }else {
            return "x="+-c/b;
        }
    }
    @Override
    public String toString() {
        return b+" x"+((c>=0)?"+":"-")+c+"=0,  "+giai();
    }    
    public static void main(String[] args) {
        Bac1 a=new Bac1(1, 2);
        System.out.println(a);
    }
    
}
