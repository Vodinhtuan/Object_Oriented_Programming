package th13;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachGiaoDich {

    ArrayList<GiaoDich> a = new ArrayList<>();

    public void readfile(String nd) {
        try {
            File f = new File(nd);
            if (f.exists()) {
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner sc = new Scanner(read.nextLine());
                    String ma = "", ngay = "", loaidat = "";
                    double donGia, dientich;
                    boolean loainha;
                    ma = sc.next();
                    ngay = sc.next();
                    donGia = sc.nextDouble();
                    dientich = sc.nextDouble();
                    if (sc.hasNextBoolean()) {
                        loainha = sc.nextBoolean();
                        a.add(new GiaoDichNha(ma, new Date(ngay), donGia, dientich, loainha));
                    } else {
                        loaidat = sc.next();
                        a.add(new GiaoDichDat(ma, new Date(ngay), donGia, dientich, loaidat));
                    }
                }
            } else {
                System.out.println("khong ton tai file!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void wirtefile(String nd, ArrayList<GiaoDich> temp)
    {
        try
        {
            File f = new File(nd);
            if(!f.exists())
            {
                PrintStream out=new PrintStream(f);
                for(GiaoDich i:temp)
                {
                    out.println(i);
                }
                out.close();
            }
            else System.out.println("file file da ton tai!!!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public boolean ThemMoi(GiaoDich gd) {
        for (GiaoDich i : a) {
            if (i.getMa().equalsIgnoreCase(gd.getMa())) {
                return false;
            }
        }
        a.add(gd);
        return true;
    }

    public String layDanhSachGiaoDich() {
        String temp="";
        for (GiaoDich i : a) {
            temp+= i+"\n";
        }
        return temp;
    }

    public void xuat(String nd) {
        System.out.println(nd);
        for (GiaoDich i : a) {
            System.out.println("\t" + i);
        }
    }

    public boolean xoaTheoMaGiaoDich(String ma) {
        boolean check = false;
        ma = ma.trim();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).getMa().equalsIgnoreCase(ma)) {
                a.remove(a.get(i));
                i--;
                check = true;
            }
        }
        return check;
    }

    public GiaoDich timGiaoDich(String ma) {
        for (GiaoDich i : a) {
            if (i.getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return null;
    }
    public ArrayList giaodichdat()
    {
        ArrayList<GiaoDich> temp=new ArrayList<>();
        for (GiaoDich i : a) {
            if (i instanceof GiaoDichDat ){
                temp.add(i);
            }
        }
        return temp;
    }
    public ArrayList giaodichnha()
    {
        ArrayList<GiaoDich> temp=new ArrayList<>();
        for (GiaoDich i : a) {
            if (i instanceof GiaoDichNha ){
                temp.add(i);
            }
        }  
        return temp;
    }    
     public static void main(String[] args)
     {
         DanhSachGiaoDich a= new DanhSachGiaoDich();
         a.readfile("GIAODICH.txt");
         System.out.print(a.layDanhSachGiaoDich());
         a.wirtefile("GIAODICHDAT.txt", a.giaodichdat());
         a.wirtefile("GIAODICHNHA.txt", a.giaodichnha());
     }
}
