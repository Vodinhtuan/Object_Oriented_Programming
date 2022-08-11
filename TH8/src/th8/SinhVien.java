
package th8;


public class SinhVien extends Nguoi{
    private double d1, d2, d3;

    public SinhVien() {
        super();
    }

    public SinhVien(String ma, String ht, String ns, boolean gt, double d1, double d2, double d3) {
        super(ma, ht, ns, gt);
        this.d1 = d1;
        this.d2 = d2;
        this.d3 = d3;
    }

    public double getD1() {
        return d1;
    }

    public void setD1(double d1) {
        this.d1 = d1;
    }

    public double getD2() {
        return d2;
    }

    public void setD2(double d2) {
        this.d2 = d2;
    }

    public double getD3() {
        return d3;
    }

    public void setD3(double d3) {
        this.d3 = d3;
    }

    public String toString() {
        return  super.toString() + " " + d1 + " " + d2 + " " + d3 + " " + diemtrungbinh();
    }

    public double diemtrungbinh(){
        return (d1+d2+d3)/3;
    }
    
}