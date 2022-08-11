
package th9;


public class KinhTe extends SinhVien{
    private int mkt, nlkt;

    public KinhTe() {
    }

    public KinhTe(String ma, String ht, boolean gt,int mkt, int nlkt) {
        super(ma, ht, gt);
        this.mkt = mkt;
        this.nlkt = nlkt;
    }
    @Override
    public double diemtrungbinh()
    {
        return (nlkt*2+mkt)/3.0;
    }
    
   
}
