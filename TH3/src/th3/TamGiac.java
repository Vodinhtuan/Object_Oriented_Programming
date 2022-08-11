
package th3;


public class TamGiac 
{
    private DiemOxy a ,b, c; 

    public TamGiac() 
    {
    }
    
    public TamGiac(DiemOxy a, DiemOxy b, DiemOxy c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public boolean laTamGiac()
    {
        double ab, ac, bc;
        ab=a.khoangcach(b);
        ac=a.khoangcach(c);
        bc=b.khoangcach(c);
        if(ab+ac>bc && ab+bc>ac && bc+ac>ab) return true;
        return false;
    }
    double dienTich()
    {
        double ab, ac, bc;
        ab=a.khoangcach(b);
        ac=a.khoangcach(c);
        bc=b.khoangcach(c);
        double p=(ab+ac+bc)/2;
        return Math.sqrt(p*(p-ab)*(p-bc)*(p-ac));
    }
    double chuVi()
    {
        double ab, ac, bc;
        ab=a.khoangcach(b);
        ac=a.khoangcach(c);
        bc=b.khoangcach(c);
        return (ab+ac+bc);
    }
}
