
package th10;


public class HangThuCong extends HangHoa {

    public HangThuCong() {
    }

    public HangThuCong(String ma, NgayThangNam ngaythang, int soluong, int dongia, String ns) {
        super(ma, ngaythang, soluong, dongia, ns);
    }

    
    @Override
    public double thanhtien() {
        return soluong*dongia;
    }
    
}
