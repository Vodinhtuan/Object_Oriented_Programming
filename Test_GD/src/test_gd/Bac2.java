/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test_gd;

/**
 *
 * @author Admin
 */
public class Bac2 extends Bac1{
    protected double a;

    public Bac2() {
    }

    public Bac2(double a, double b, double c) {
        super(b, c);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }
    


    @Override
    public String giai() {
        if (a==0) {
            return super.giai();
        }else {
            double d=b*b-4*a*c;
            if(d<0)return "vo no";
            if(d==0) return "x1=x2: "+-b/2/a;
            double x1=(-b-Math.sqrt(d))/2/a;
            double x2=(-b+Math.sqrt(d))/2/a;
            return "x1="+x1+", x2="+x2;
        }
    }

    @Override
    public String toString() {
        return a+"X^2 "+((b>0)?"+":"")+b+"x "+((c>=0)?"+":"")+c+" =0 , "+giai();
    }
    
    public static void main(String[] args) {
        Bac2 a = new Bac2(1, -3, 2);
        System.out.println(a);
    }
}
