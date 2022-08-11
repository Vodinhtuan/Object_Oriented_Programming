
package finalexam_buianhtruc_5149;


public class HinhTron implements IHinh{

    private double r;

    public HinhTron() {
    }

    public HinhTron(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }
    
    @Override
    public double DienTich() {
       return Math.PI*r*r;
    }

    @Override
    public String toString() {
        return ""+r;
    }
    
    
}
