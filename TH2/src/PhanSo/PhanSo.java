
package PhanSo;

public class PhanSo {
    private int tu, mau;

    //Constructors
    public PhanSo() {
        tu = 0;
        mau = 1;
    }

    public PhanSo(int m) {
        tu = 1;
        mau = m;
    }

    public PhanSo(int t, int m) {
        tu = t;
        mau = m;
    }

    //gets/sets
    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
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

    public PhanSo cong(PhanSo b) 
    {
        PhanSo c = new PhanSo();
        c.tu = tu * b.mau + mau * b.tu;
        c.mau = mau * b.mau;
        c.rutgon();
        return c;
    }

    public PhanSo tru(PhanSo b)
    {
        PhanSo d = new PhanSo();
        d.tu =tu *b.mau -mau *b.tu;
        d.mau =mau *b.mau;
        d.rutgon();
        return d;
    }
    public PhanSo nhan(PhanSo b)
    {
        PhanSo e = new PhanSo();
        e.tu =tu*b.tu;
        e.mau =mau *b.mau;
        e.rutgon();
        return e;
    }
    public PhanSo chia(PhanSo b)
    {
        PhanSo e = new PhanSo();
        if(b.tu==0)
        {
            System.out.println("khong tinh");
            e.tu=0;
            e.mau=0;
        }
        else
        {
             e.tu =tu*b.mau;
             e.mau =mau *b.tu;
             e.rutgon();
        }
       
        return e;
    }
    public static void main(String []arg){
        PhanSo x = new PhanSo(1,4);
        PhanSo y = new PhanSo(2,6);
        System.out.println(x+" + "+y+" = "+x.cong(y));
        System.out.println(x+" - "+y+" = "+x.tru(y));
        System.out.println(x+" * "+y+" = "+x.nhan(y));
        System.out.println(x+" / "+y+" = "+x.chia(y));
    }
}