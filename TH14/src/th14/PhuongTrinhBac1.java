
package th14;

public class PhuongTrinhBac1 {

    protected double b,c;

    public PhuongTrinhBac1() {
    }

    public PhuongTrinhBac1(double b, double c) {
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
    
   
    String Giai()
    {
        if (b==0)
        {
            if(c==0) return "vo so nghiem";
            else return "vo nghiem";
        }
        else return "co 1 nghiem la:"+(-c/b);
    }
    @Override
    public String toString() {
        return "Phuong trinh bac 1: " + b + "x "+((c>=0)?"+ ":" ") + c + " "+ Giai();
    }
    
    
}
