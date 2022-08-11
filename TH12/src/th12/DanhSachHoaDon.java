
package th12;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
public class DanhSachHoaDon {
    ArrayList<HoaDon> a= new ArrayList<>();
    
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
                    String maHD="",tenKhach="",ngayHD="";
                    double donGia;
                    int soGioThue,soNgayThue;
                    maHD=sc.next();
                    while(!sc.hasNextDouble()) tenKhach+=sc.next()+" ";
                    tenKhach=tenKhach.trim();
                    donGia=sc.nextDouble();
                    if(maHD.charAt(0)=='N')
                    {
                        soNgayThue=sc.nextInt();
                        ngayHD=sc.next();
                        a.add(new HoaDonTheoNgay(maHD, tenKhach, donGia, soNgayThue, new Date(ngayHD)));
                    }
                    else if(maHD.charAt(0)=='G')
                    {
                        soGioThue=sc.nextInt();
                        ngayHD=sc.next();
                        a.add(new HoaDonTheoGio(maHD, tenKhach, donGia, soGioThue, new Date(ngayHD)));
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
        boolean check= false;
        System.out.print("nhap hoa don can them:");
        Scanner sc= new Scanner(new Scanner(System.in).nextLine());
        String maHD="",tenKhach="",ngayHD="";
        double donGia;
        int soGioThue,soNgayThue;
        maHD=sc.next();
        while(!sc.hasNextDouble()) tenKhach+=sc.next()+" ";
        tenKhach=tenKhach.trim();
        donGia=sc.nextDouble();
        if(maHD.charAt(0)=='N')
        {
           soNgayThue=sc.nextInt();
           ngayHD=sc.next();
           check=themVaoDanhSach(new HoaDonTheoNgay(maHD, tenKhach, donGia, soNgayThue, new Date(ngayHD)));
        }
        else if(maHD.charAt(0)=='G')
        {
           soGioThue=sc.nextInt();
           ngayHD=sc.next();
           check=themVaoDanhSach(new HoaDonTheoGio(maHD, tenKhach, donGia, soGioThue, new Date(ngayHD)));
        }
        else System.out.println("hoa don khong hop le hoac hoa don da ton tai!!!");
        if(check) xuat("danh sach hoa don sau khi them");
    }
    public boolean themVaoDanhSach( HoaDon hd)
    {
        for(HoaDon i:a)
        {
            if(i.getMaHD().equalsIgnoreCase(hd.getMaHD())) return false;
        }
        if(hd.getMaHD().charAt(0)=='N'&&hd instanceof  HoaDonTheoNgay) a.add(hd);
        else if(hd.getMaHD().charAt(0)=='G' && hd instanceof  HoaDonTheoGio) a.add(hd);
        else return false;
        return true;
    }
    public void layDanhSachHoaDon()
    {
        System.out.println("danh sach hoa don");
        for(HoaDon i: a )
        {
            System.out.println("\t"+i);
        }
    }
    public void xuat(String nd)
    {
        System.out.println(nd);
        for(HoaDon i: a )
        {
            System.out.println("\t"+i);
        }
    }
    public boolean xoaTheoMaHoaDon(String maHD)
    {
        boolean check=false;
        maHD=maHD.trim();
        for(int i=0;i<a.size();i++ )
        {
            if(a.get(i).getMaHD().equalsIgnoreCase(maHD)) 
            {
                a.remove(a.get(i));
                i--;
                check=true;
            }
        }
        return check;
    }
    public HoaDon timHoaDon(String maHD)
    {
        for(HoaDon i:a)
        {
            if(i.getMaHD().equalsIgnoreCase(maHD)) return i;
        }
        return null;
    }
    public double tinhTongTienHoaDon()
    {
        double sum=0;
        for(HoaDon i:a)
        {
            sum+=i.tinhThanhTien();
        }
        return sum;
    }
    public void output()
    {
        Scanner sc= new Scanner(System.in);
        xuat("danh sach hoa don");
        input();
        System.out.print("nhap ma hoa don can xoa: ");
        if(xoaTheoMaHoaDon(sc.nextLine())) xuat("danh sach sau khi xoa: ");
        else System.out.println("ma khong co trong danh sach!!!");
        sc= new Scanner(System.in);
        System.out.print("nhap ma hoa don can tim: ");
        String temp=sc.nextLine();
        if(timHoaDon(temp)!=null) System.out.println("\t"+timHoaDon(temp));
        else System.out.println("ma khong co trong danh sach!!!");
        System.out.println("tong tien hoa don: "+tinhTongTienHoaDon());
    }
    public static void main(String[] args)
    {
        DanhSachHoaDon a= new DanhSachHoaDon();
        a.readfile("HOADON.txt");
        a.output();         
    }
}
