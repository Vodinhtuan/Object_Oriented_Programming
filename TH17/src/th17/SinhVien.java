
package th17;


public class SinhVien {

    private double dtb;
    private boolean gioitinh;
    private String masv,hoten,ngaysinh,quequan;

    public String xeploai()
    {
        if(dtb<3.5) return "kem";
        else if(dtb>=3.5&&dtb<5) return "yeu";
        else if(dtb>=5&&dtb<6.5) return "trung binh";
        else if(dtb>=6.5&&dtb<8) return "kha";
        else if(dtb>=8&&dtb<9) return "gioi";
        else if(dtb>=9) return "xuat sac";
        return "khong xep loai";
    }

    public SinhVien() 
    {
    }
    
    public SinhVien(double dtb, boolean gioitinh, String masv, String hoten, String ngaysinh, String quequan) {
        this.dtb = dtb;
        this.gioitinh = gioitinh;
        this.masv = masv;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.quequan = quequan;
    }

    public double getDtb() {
        return dtb;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public String getMasv() {
        return masv;
    }

    public String getHoten() {
        return hoten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
    
    @Override
    public String toString() {
        return masv + " "+hoten +" "+ (gioitinh?"nam":"nu")+" "+ngaysinh+" "+quequan+" "+dtb+" "+xeploai();
    }
    
}
