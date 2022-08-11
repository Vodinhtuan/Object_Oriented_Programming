/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package th11;


public class KinhTe extends SinhVien implements IXepLoai{
    private int mkt, nlkt;

    public KinhTe() {
    }

    public KinhTe(String ma, String ht, boolean gt,int mkt, int nlkt) {
        super(ma, ht, gt);
        this.mkt = mkt;
        this.nlkt = nlkt;
    }
    @Override
    public double diemtrungbinh()
    {
        return (nlkt*2+mkt)/3.0;
    }
    @Override
    public String getHocluc()
    {
        double dtb=diemtrungbinh();
        if(dtb>=9) return "xuat sac";
        if(dtb>=8) return "gioi";
        if(dtb>=6.5) return "kha";
        if(dtb>=5) return "truung binh";
        if(dtb>=3) return "yeu";
        return "kem";
    }

    @Override
    public String toString() {
        return super.toString()+getHocluc();
    }
}
