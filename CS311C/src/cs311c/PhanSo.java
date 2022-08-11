public class Phanso {
    private int tu, mau;

    //Constructors
    public Phanso() {
        tu = 0;
        mau = 1;
    }

    public Phanso(int m) {
        tu = 1;
        mau = m;
    }

    public Phanso(int t, int m) {
        tu = t;
        mau = m;
    }

    //gets/sets
    public int getTu() {
        return tu;
    }

    public void setTu(int t) {
        tu = t;
    }

    public int getMau() {
        return mau;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }

    public String toString() {
        return tu + "/" + mau;
    }

    public double giatri() {
        return 1.0 * tu / mau;
    }

    int ucln(int a, int b) {
        while (a != b)
            if (a > b) a -= b;
            else b -= a;
        return a;
    }

    public void rutgon() {
        if (tu * mau != 0) {
            int t = ucln(Math.abs(tu), Math.abs(mau));
            tu = tu / t;
            mau = mau / t;
        }
    }

    public Phanso cong(Phanso b) 
    {
        Phanso c = new Phanso();
        c.tu = tu * b.mau + mau * b.tu;
        c.mau = mau * b.mau;
        c.rutgon();
        return c;
    }

    public Phanso tru(Phanso b)
    {
        Phanso d = new Phanso();
        d.tu =tu *b.mau -mau *b.tu;
        d.mau =mau *b.mau;
        d.rutgon();
        return d;
    }
    public Phanso nhan(Phanso b)
    {
        Phanso e = new Phanso();
        e.tu =tu*b.tu;
        e.mau =mau *b.mau;
        e.rutgon();
        return e;
    }
    public Phanso nhan(Phanso b)
    {
        Phanso e = new Phanso();
        e.tu =tu*b.tu;
        e.mau =mau *b.mau;
        e.rutgon();
        return e;
    }
        
    public static void main(String []arg){
        Phanso x = new Phanso(1,4);
        Phanso y = new Phanso(2,6);
        System.out.println(x+" + "+y+" = "+x.cong(y));
        System.out.println(x+" - "+y+" = "+x.tru(y));
    }
}