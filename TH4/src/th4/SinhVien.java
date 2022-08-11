
package th4;


public class SinhVien {

private String maSV,hoTen,ngaySinh,queQuan;
    private boolean gioiTinh;
    private double diemTB;
    public SinhVien(){
    }
    public SinhVien(String maSV, String hoTen, String ngaySinh, String queQuan, boolean gioiTinh, double diemTB){
        this.maSV= maSV;
        this.hoTen= hoTen;
        this.ngaySinh= ngaySinh;
        this.queQuan= queQuan;
        this.gioiTinh= gioiTinh;
        this.diemTB= diemTB;
    }
    public String getMaSV() {
        return maSV;
    }
    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }
    public String getHoTen() {
        return hoTen;
    }
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getQueQuan() {
        return queQuan;
    }
    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }
    public boolean isGioiTinh() {
        return gioiTinh;
    }
    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
    public double getDiemTB() {
        return diemTB;
    }
    public void setDiemTB(double diemTB) {
        this.diemTB = diemTB;
    }    
    public String xeploai(){
        if(diemTB<3.5) return "kem";
        if(diemTB<5) return "Yeu";
        if(diemTB<6.5) return "Trung Binh";
        if(diemTB<8) return "Kha";
        if(diemTB<9) return "Gioi";
        return "Xuat Sac";
    }
    public String toString() {
        return maSV +" "+hoTen +" "+ngaySinh+" "+queQuan+" "+ (gioiTinh?" Nam ":" Nu ")+diemTB+" "+xeploai();
    }
    public static void main(String[] args){
        SinhVien a=new SinhVien("001","Võ Đình Tuấn","17/04/2002","Đà Nẵng",true,7.8);
        System.out.println(a);
    }
}
