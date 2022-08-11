
package kt;


public class BENHNHANBAOHIEMXAHOI extends BENHNHAN {

    @Override
    public double Tinhhoadonvienphi() {
       if(super.phongyeucau)
       {
           return (super.SoNgayNhapVien()*dongiaphong*200000);
       }
       return (super.SoNgayNhapVien()*dongiaphong);
    }

    public BENHNHANBAOHIEMXAHOI() {
    }

    public BENHNHANBAOHIEMXAHOI(String ma, String hoten, NgayThang ngaynhap, NgayThang ngayxuat, boolean phongyeucau) {
        super(ma, hoten, ngaynhap, ngayxuat, phongyeucau);
    }
    
    @Override
    public String toString() {
        return super.toString()+" "+Tinhhoadonvienphi();
    }
    
}
