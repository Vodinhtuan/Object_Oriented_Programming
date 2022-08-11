
package th14;


public class PhuongTrinhBac2 extends PhuongTrinhBac1 {
    private double a;

    public PhuongTrinhBac2() {
    }

    public PhuongTrinhBac2(double a, double b, double c) {
        super(b, c);
        this.a = a;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    
    String Giai()
    {
        if (a==0)
        {
            return super.Giai();
        }
        else
        {
            double d=b*b-4*a*c;
            if (d<0) return " vo nghiem";
            else if (d==0) return " co 1 nghiem la:"+(-b/(2*a));
            else if(d>0) return " co nghiem la: x1= "+
               ((-b+Math.sqrt(d))/(2*a))+" x2= "+((-b-Math.sqrt(d))/(2*a));
        }
        return "";
    }
    @Override
    public String toString() {
        return "Phuong trinh bac 2: " + a + "x^2 "+((b>=0)?"+ ":" ")  + b + "x "+((c>=0)?"+ ":" ")+ c +" "+ Giai();
    }
    
}
