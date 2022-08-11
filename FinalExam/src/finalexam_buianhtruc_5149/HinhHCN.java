
package finalexam_buianhtruc_5149;


public class HinhHCN implements IHinh {
    private double a,b,h;

    public HinhHCN() {
    }

    public HinhHCN(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    @Override
    public double DienTich() {
        return 2*h*(a+b)+2*a*b;
    }

    @Override
    public String toString() {
        return a + " " + b + " " + h;
    }
    
}
