
package th10;

public class NgayThangNam {
    private int ngay,thang,nam;
    private String chuoi;

    public NgayThangNam() {
    }

    public NgayThangNam(String chuoi) {
        this.chuoi = chuoi;
        //tachchuoi();
        tachchuoi2();
    }
    
    public NgayThangNam(int ngay, int thang, int nam) {
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
        int dem=1;
       for(int i=0;i<chuoi.length();i++)
       {
           String temp="";
           if(chuoi.charAt(i)==47)
           {
               temp=chuoi.substring(0, i);
               chuoi=chuoi.substring(i+1,chuoi.length());
               if(dem==1) ngay=Integer.parseInt(temp);
               if(dem==2) thang=Integer.parseInt(temp);
               dem++;
               i=0;
           }
           if(dem==3)
           {
               nam=Integer.parseInt(chuoi);
               break;
           }
       }    
    }
    public void tachchuoi2()
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
