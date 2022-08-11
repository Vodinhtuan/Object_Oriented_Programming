
package th12;


public class Date {
 
    private int ngay,thang,nam;
    private String chuoi;

    public Date() {
    }

    public Date(String chuoi) {
        this.chuoi = chuoi;
        //tachchuoi();
        tachchuoi();
    }
    
    public Date(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }

    public String getChuoi() {
        return chuoi;
    }

    public void setChuoi(String chuoi) {
        this.chuoi = chuoi;
    }
    
    public int getNgay() {
        return ngay;
    }

    public void setNgay(int ngay) {
        this.ngay = ngay;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    
    public void tachchuoi()
    {
        chuoi=chuoi.trim();
        String[] temp=chuoi.split("/");
        ngay=Integer.parseInt(temp[0]);
        thang=Integer.parseInt(temp[1]);
        nam=Integer.parseInt(temp[2]);
    }
    @Override
    public String toString() {
        return ngay + "/" + thang + "/" + nam;
    }
    
}
