
package quanlybenhvien;

import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class DSNHANVIEN {
    ArrayList<NHANVIEN> a= new ArrayList();
    public void readfile(String nd) {
        a = new ArrayList<>();
        try {
            File f = new File(nd);
            if (f.exists()) {
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner sc = new Scanner(read.nextLine());
                    String ma = "", hoten="";
                    String nkhd;
                    boolean gt;
                    double tt;
                    int cv;
                    ma = sc.next();
                    while(!sc.hasNextBoolean()) hoten += sc.next()+" ";
                    hoten = hoten.trim();
                    gt=sc.nextBoolean();
                    nkhd = sc.next();
                    tt=sc.nextDouble();
                    cv=sc.nextInt();
                    a.add(new NHANVIEN(ma,hoten,gt,new NgayThang(nkhd),tt,cv));       
                }
            } else {
                JOptionPane.showMessageDialog(null, "Không tồn tại file!!!","!!!WARNING!!!",JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"!!!WARNING!!!",JOptionPane.WARNING_MESSAGE);
        }
    }
    public boolean CheckDL()
    {
        if(a.size()==0) return false;
        return true;
    }
     public ArrayList<NHANVIEN> getDanhSach() {
        return a;
    }

    public void setDanhSach(ArrayList<NHANVIEN> a) {
        this.a = a;
    }
    public void wirtefile(String nd)
    {
        try
        {
            File f = new File(nd);
            //if(!f.exists())
            {
                PrintStream out=new PrintStream(f);
                for(NHANVIEN i:a)
                {
                    out.println(i);
                }
                out.close();
            }
            //else System.out.println("file file da ton tai!!!");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e,"!!!WARNING!!!",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public int TimKIem(String ma) {
        for (NHANVIEN i : a) {
            if (i.getMa().equalsIgnoreCase(ma)) {
                return a.indexOf(i);
            }
        }
        return -1;
    }
    public boolean Xoa(String ma) {
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
    public boolean ThemMoi(NHANVIEN bn) {
        for (NHANVIEN i : a) {
            if (i.getMa().equalsIgnoreCase(bn.getMa())) {
                return false;
            }
        }
        a.add(bn);
        return true;
    } 
    public boolean CapNhat(NHANVIEN bn) {
        for (NHANVIEN i : a) {
            if (i.getMa().equalsIgnoreCase(bn.getMa())) {
                a.set(a.indexOf(i),bn);
                return true;
            }
        }
        return false;
    }
    public void SapXepTang()
    {
        NHANVIEN temp;
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
            {
                    if(a.get(i).TinhTienLuong()>a.get(j).TinhTienLuong())
                        {
                            temp = a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp);
                        }
                    
            } 
                
        }
    }
    public void SapXepGiam()
    {
        NHANVIEN temp;
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
            {
                    if(a.get(i).TinhTienLuong()<a.get(j).TinhTienLuong())
                        {
                            temp = a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp);
                        }
                    
            } 
                
        }
    }
     public void SapXepMacDinh()
    {
        NHANVIEN temp;
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
            {
                    if(Integer.parseInt(a.get(i).getMa())>Integer.parseInt(a.get(j).getMa()))
                        {
                            temp = a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp);
                        }
                    
            } 
                
        }
    }
    double tongYT()
    {
        double sum=0;
        for(NHANVIEN i:a)
        {
            if(i.getChucvu()==0) sum+=i.TinhTienLuong();
        }
        return sum;
    }
    double tongBS()
    {
        double sum=0;
        for(NHANVIEN i:a)
        {
            if(i.getChucvu()==1) sum+=i.TinhTienLuong();
        }
        return sum;
    }
    double tongPK()
    {
        double sum=0;
        for(NHANVIEN i:a)
        {
            if(i.getChucvu()==2) sum+=i.TinhTienLuong();
        }
        return sum;
    }
    double tongTK()
    {
        double sum=0;
        for(NHANVIEN i:a)
        {
            if(i.getChucvu()==3) sum+=i.TinhTienLuong();
        }
        return sum;
    }
}
