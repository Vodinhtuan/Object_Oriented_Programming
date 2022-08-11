
package finalexam_buianhtruc_5149;

public class HinhCN implements IHinh{
    
    private double a,b;

    public HinhCN() {
    }

    public HinhCN(double a, double b) {
        this.a = a;
        this.b = b;
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

    @Override
    public double DienTich() {
        return a*b;
    }

    @Override
    public String toString() {
        return a +" "+ b;
    }
    
}
