
package kt;

import java.util.Calendar;


public abstract class BENHNHAN implements IVIENPHI{
    
    protected String ma,hoten;
    protected NgayThang ngaynhap,ngayxuat;
    protected boolean phongyeucau;

    public BENHNHAN(String ma, String hoten, NgayThang ngaynhap, NgayThang ngayxuat, boolean phongyeucau) {
        this.ma = ma;
        this.hoten = hoten;
        this.ngaynhap = ngaynhap;
        this.ngayxuat = ngayxuat;
        this.phongyeucau = phongyeucau;
    }

    public BENHNHAN() {
    }
    
    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public NgayThang getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(NgayThang ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public NgayThang getNgayxuat() {
        return ngayxuat;
    }

    public void setNgayxuat(NgayThang ngayxuat) {
        this.ngayxuat = ngayxuat;
    }

    public boolean isPhongyeucau() {
        return phongyeucau;
    }

    //phương thức tính số ngày nhập viện(ngày nhập viện – trừ ngày ra viện) và phương thức toString().
    public void setPhongyeucau(boolean phongyeucau) {
        this.phongyeucau = phongyeucau;
    }
    
    public long SoNgayNhapVien()
    {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        c1.set(ngaynhap.getNam(),ngaynhap.getThang(),ngaynhap.getNgay());
        c2.set(ngayxuat.getNam(),ngayxuat.getThang(),ngayxuat.getNgay());
        if(((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000))==0) return 1;
        return ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));
    }
    @Override
    public abstract double Tinhhoadonvienphi();

    @Override
    public String toString() {
        return this.getClass().getName() + " " + ma + " " + hoten + " " + ngaynhap + " " + ngayxuat + " " + (phongyeucau?"yeu cau":"khong yeu cau")+" "+SoNgayNhapVien();
    }
    
    
}
