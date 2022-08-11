
package th8;

public class Nguoi {
    protected String ma, ht, ns;
    protected boolean gt;

    public Nguoi() {
        
    }

    public Nguoi(String ma, String ht, String ns, boolean gt) {
        this.ma = ma;
        this.ht = ht;
        this.ns = ns;
        this.gt = gt;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHt() {
        return ht;
    }

    public void setHt(String ht) {
        this.ht = ht;
    }

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    public boolean isGt() {
        return gt;
    }

    public void setGt(boolean gt) {
        this.gt = gt;
    }
    

    public String toString() {
        return  ma + " " + ht + " " + ns + " " + (gt ? "Nam" : "Nu" ) ;
    }

    
    
}
