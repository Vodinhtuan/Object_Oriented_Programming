
package th10;


public class HangDienMay extends HangHoa {

    public HangDienMay() {
    }

    public HangDienMay(String ma, NgayThangNam ngaythang, int soluong, int dongia, String ns) {
        super(ma, ngaythang, soluong, dongia, ns);
    }
    
    @Override
    public double thanhtien() 
    {
       if(ns.equals("TN")) return soluong*dongia;
       return soluong*dongia*1.2;
    }
    
    
}
