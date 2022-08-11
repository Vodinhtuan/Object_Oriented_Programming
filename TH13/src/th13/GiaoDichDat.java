
package th13;


public class GiaoDichDat extends GiaoDich {

    private String loaidat;

    public GiaoDichDat() {
    }

    public GiaoDichDat( String ma, Date ngaythang, double dongia, double dientich, String loaidat) {
        super(ma, ngaythang, dongia, dientich);
        this.loaidat = loaidat;
    }

    public String getLoaidat() {
        return loaidat;
    }

    public void setLoaidat(String loaidat) {
        this.loaidat = loaidat;
    }
    
    
    @Override
    public double ThanhTien() {
       if(loaidat.equalsIgnoreCase("A")) return dientich*dongia*1.5;
       return dientich*dongia*1.0;
    }

    @Override
    public String toString() {
        return super.toString() + " " + loaidat+" " + ThanhTien();
    }
    
}
