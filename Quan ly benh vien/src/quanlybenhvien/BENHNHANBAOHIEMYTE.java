
package quanlybenhvien;


public class BENHNHANBAOHIEMYTE extends BENHNHAN{
    @Override
    public double Tinhhoadonvienphi() {
       if(super.phongyeucau)
       {
           return (super.SoNgayNhapVien()*dongiaphong+super.SoNgayNhapVien()*200000)-((super.SoNgayNhapVien()*dongiaphong)*70/100);
       }
       return (super.SoNgayNhapVien()*dongiaphong)-((super.SoNgayNhapVien()*dongiaphong)*70/100);
    }

    public BENHNHANBAOHIEMYTE() {
        
    }

    public BENHNHANBAOHIEMYTE(String ma, String hoten, NgayThang ngaynhap, NgayThang ngayxuat, boolean phongyeucau) {
        super(ma, hoten, ngaynhap, ngayxuat, phongyeucau);
    }
    
    @Override
    public String toString() {
        return super.toString()+" "+true;
    }
    
}
