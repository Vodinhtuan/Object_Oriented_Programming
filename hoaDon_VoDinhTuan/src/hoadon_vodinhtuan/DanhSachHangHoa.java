/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadon_vodinhtuan;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Administrator
 */
public class DanhSachHangHoa {
    ArrayList<HangHoa> a= new ArrayList<HangHoa>();
    
    public void readfile(String nd)
    {
        try
        {
            File f= new File(nd);
            if(f.exists())
            {
                Scanner read=new Scanner(f);
                while(read.hasNext())
                {
                    Scanner sc= new Scanner(read.nextLine());
                    String maHD="",ngayHD="",sx="";
                    double donGia;
                    int soluong;
                    maHD=sc.next();
                    ngayHD=sc.next()+" ";
                    donGia=sc.nextDouble();
                    soluong=sc.nextInt();
                    if (sc.hasNext()) {
                        sx=sx+sc.next();
                        HangThuCong x=new HangThuCong(sx, maHD, ngayHD, donGia, soluong);
                        a.add(x);
                                 
                    }else{
                        HangDienMay x=new HangDienMay(sx, maHD, ngayHD, donGia, soluong);
                        a.add(x);
                    }
                }
            }
            else System.out.println("khong ton tai file!!!");
        }
        catch (Exception e )
        {
            System.out.println(e.getMessage());
        }
    }
    public void input()
    {
        
    }
    public void xuat(String nd)
    {
        System.out.println(nd);
        for(HangHoa i: a )
        {
            System.out.println("\t"+i);
        }
    }
    public void output(){
        xuat("");
    }
    public static void main(String[] args)
    {
        DanhSachHangHoa a=new DanhSachHangHoa();
        a.readfile("D:\\vodinhtuan\\hoaDon_VoDinhTuan\\HoaDon.txt");
        a.output();
            
    }
}
