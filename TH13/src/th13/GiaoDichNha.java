
package th13;

public class GiaoDichNha extends GiaoDich {
    private boolean loainha;

    public GiaoDichNha() {
    }

    public GiaoDichNha( String ma, Date ngaythang, double dongia, double dientich, boolean loainha) {
        super(ma, ngaythang, dongia, dientich);
        this.loainha = loainha;
    }

    public boolean isLoainha() {
        return loainha;
    }

    public void setLoainha(boolean loainha) {
        this.loainha = loainha;
    }
    
    
    @Override
    public double ThanhTien() {
       if(loainha) return dientich*dongia*1.0;
       return dientich*dongia*0.9;
    }

    @Override
    public String toString() {
        return super.toString() + " " + (loainha?"nha mat pho":"nha trong kiet") + " "+ThanhTien();
    }
    
}
