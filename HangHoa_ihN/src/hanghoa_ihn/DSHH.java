/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hanghoa_ihn;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DSHH {
    private ArrayList<HangHoa> a = new ArrayList<HangHoa>();
    
    public ArrayList<HangHoa> getA(){
        return a;
    }
    public void setA(ArrayList<HangHoa> a){
        this.a=a;
    }
    public void docFile(String tenFile)
    {
        try
        {
            File f= new File(tenFile);
            if(f.exists())
            {
                Scanner read= new Scanner(f);
                while(read.hasNext())
                {                   
                    Scanner line=new Scanner(read.nextLine());
                    String ma,ngay,nsx;
                    double sl,dg;
                    ma=line.next();
                    ngay=line.next();
                    dg=line.nextDouble();
                    sl=line.nextDouble();
                    nsx=line.nextLine().trim();
                    if(nsx.equalsIgnoreCase("TN")||nsx.equalsIgnoreCase("NK"))
                         a.add(new HangDienMay(nsx,ma,ngay,sl,dg));
                    else a.add(new HangThuCong(nsx,ma,ngay,sl,dg));
                }
            }else System.out.println("File ko ton tai");
        }
    catch( Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void ghiFile(String tenFile)
    {
        try
        {
            File f= new File(tenFile);
            if(!f.exists()){
                PrintStream out = new PrintStream(f);
                // out.print(...) or out.println(...) nhu S.O.P
                for(HangHoa x:a)
                    if(x instanceof HangDienMay){
                        out.println(x.getMaHang()+" "+x.getNgayNhap()+" "
                        +x.getDonGia()+" "+x.getSoLuong()+" "
                        +((HangDienMay)x).getNoiSanXuat());
                    }else out.println(x.getMaHang()+" "+x.getNgayNhap()+" "
                        +x.getDonGia()+" "+x.getSoLuong()+" "
                        +((HangThuCong)x).getNhaSX());
                out.close();
            }else System.out.println("file da ton tai.");
        }catch( Exception e){
            System.out.println(e.getMessage());
        }
    }
    public boolean themMoi(HangHoa y){
       for(HangHoa x:a)
           if(x.getMaHang().equalsIgnoreCase(y.getMaHang()))
                return false; // Không thêm được
       a.add(y);
       return true;
    }
    public boolean xoaTheoMa(String ma){
        for(HangHoa x: a)
            if(x.getMaHang().equalsIgnoreCase(ma)){
                a.remove(x);
                return true;
            }
        return false;
    }
    
    public HangHoa kiemTheoMa(String ma){
        for(HangHoa x: a)
            if (x.getMaHang().equalsIgnoreCase(ma))
                    return x;
        return null;
    }
    
    public double tongTienHangDienMay(){
        double s=0;
        for(HangHoa x:a)
            if(x instanceof HangDienMay)
                s=s+((HangDienMay)x).tinhThanhTien();
        return s;
    }
    
    public double tongTienHangThuCong(){
        double s=0;
        for(HangHoa x:a)
            if(x instanceof HangThuCong)
                s=s+((HangThuCong)x).tinhThanhTien();
        return s;
    }
    
    public void xuat(String noiDung){
        System.out.println(noiDung);
        for(HangHoa x:a)
            System.out.println(x);
    }
    public void output(){
        xuat("Danh sach vưa doc tu file: ");
        System.out.println("Tổng tiền điện máy là: "+tongTienHangDienMay());
        System.out.println("Tổng tiền Thủ Công là: "+tongTienHangThuCong());
    }
    public static void main(String[] args) {
        DSHH a = new DSHH();
        a.docFile("TH.txt");
        a.ghiFile("HangHoa_X.txt");
    }
}
