
package th18;

public class Nguoi {
    protected String ten,diachi,ngaysinh;
    protected boolean gioitinh;

    public Nguoi() {
        
    }

    public Nguoi(String ten, boolean gioitinh, String diachi ,String ngaysinh) {
        this.ten = ten;
        this.diachi = diachi;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNgáyinh() {
        return ngaysinh;
    }

    public void setNgáyinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return ten + " " + (gioitinh?"Nam":"Nu") +" " +diachi + " "  + ngaysinh;
    }

   
    

 
    
}
