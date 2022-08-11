/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311x_vodinhtuan_quanlybaigiuxe;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class DSVX {
    private ArrayList<LoaiXe> a = new ArrayList<LoaiXe>();
    
    public ArrayList<LoaiXe> getA(){
        return a;
    }
    public void setA(ArrayList<LoaiXe> a){
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
                    String ma,ngay,xe;
                    double sl,dg;
                    ma=line.next();
                    ngay=line.next();
                    dg=line.nextDouble();
                    sl=line.nextDouble();
                    xe=line.nextLine().trim();
                    if(xe.equalsIgnoreCase("VN")||xe.equalsIgnoreCase("VT"))
                         a.add(new XeOto(xe,ma,ngay,sl,dg));
                    else a.add(new XeMay(xe,ma,ngay,sl,dg));
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
                for(LoaiXe x:a)
                    if(x instanceof XeOto){
                        out.println(x.getMaVe()+" "+x.getNgayGui()+" "
                        +x.getDonGia()+" "+x.getSoLuong()+" "
                        +((XeOto)x).getLoaiVe());
                    }else out.println(x.getMaVe()+" "+x.getNgayGui()+" "
                        +x.getDonGia()+" "+x.getSoLuong()+" "
                        +((XeMay)x).getKhuVuc());
                out.close();
            }else System.out.println("file da ton tai.");
        }catch( Exception e){
            System.out.println(e.getMessage());
        }
    }
    public boolean themMoi(LoaiXe y){
       for(LoaiXe x:a)
           if(x.getMaVe().equalsIgnoreCase(y.getMaVe()))
                return false; // Không thêm được
       a.add(y);
       return true;
    }
    public boolean xoaTheoMa(String ma){
        for(LoaiXe x: a)
            if(x.getMaVe().equalsIgnoreCase(ma)){
                a.remove(x);
                return true;
            }
        return false;
    }
    
    public LoaiXe kiemTheoMa(String ma){
        for(LoaiXe x: a)
            if (x.getMaVe().equalsIgnoreCase(ma))
                    return x;
        return null;
    }
    public ArrayList<LoaiXe>layDSVX(){
        return a;
    }
    public double tongTienXeOto(){
        double s=0;
        for(LoaiXe x:a)
            if(x instanceof XeOto)
                s=s+((XeOto)x).tinhThanhTien();
        return s;
    }
    
    public double tongTienXeMay(){
        double s=0;
        for(LoaiXe x:a)
            if(x instanceof XeMay)
                s=s+((XeMay)x).tinhThanhTien();
        return s;
    }
    
    public void xuat(String noiDung){
        System.out.println(noiDung);
        for(LoaiXe x:a)
            System.out.println(x);
    }
    public void output(){
        xuat("Danh sách vừa đọc từ file: ");
        System.out.println("Tổng tiền xe otô là: "+tongTienXeOto());
        System.out.println("Tổng tiền xe máy là: "+tongTienXeMay());
        System.out.println(" Danh sách vé xe " + layDSVX());
    }
    public static void main(String[] args) {
        DSVX a = new DSVX();
        a.docFile("QUAN_LY_VE.txt");
        a.ghiFile("GHI_VE.txt");
        a.output();
    }
}
