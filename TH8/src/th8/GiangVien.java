
package th8;


public class GiangVien extends Nguoi{
    private String mon;
    private int ts, dg;

    public GiangVien() {
        super();
    }

    public GiangVien(String ma, String ht, String ns, boolean gt, String mon, int ts, int dg ) {
        super(ma, ht, ns, gt);
        this.mon = mon;
        this.ts = ts;
        this.dg = dg;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public int getTs() {
        return ts;
    }

    public void setTs(int ts) {
        this.ts = ts;
    }

    public int getDg() {
        return dg;
    }

    public void setDg(int dg) {
        this.dg = dg;
    }

    @Override
    public String toString() {
        return super.toString() + " " + mon + " " + ts + " " + dg + " " + thanhtien();
    }

    public int thanhtien(){
        return ts*dg;
    }
    
    public static void main(String[] args) {

    }
}