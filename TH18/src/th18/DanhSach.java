
package th18;

import java.util.Scanner; 
import java.util.ArrayList;
import java.io.File;
import java.io.PrintStream;
public class DanhSach {
    ArrayList<Nguoi> a =new ArrayList<>();
    
    void Nhap()
    {
        int n=0;
        Scanner sc=new Scanner(System.in);
        do
        {
            System.out.print("nhap so luong sinh vien >0: ");
            n=sc.nextInt();
        }while(n<=0);
        
        for(int i=0;i<n;i++)
        {
            a.add(new SinhVien().nhap1SV());
        }
    }
    public double DTBchung()
    {
        double sum=0;
        double dem=0;
        for(Nguoi i:a)
        {
            sum+=((SinhVien)i).getDtb();
            dem++;
        }
        return sum/dem;
    }
    public void xuat(String nd)
    {
        System.out.println(nd);
        for(Nguoi i:a)
        {
            System.out.println("\t"+i); 
        }
        System.out.println();
    }
    
     public void wirtefile(String nd)
    {
        try
        {
            File f = new File(nd);
            //if(!f.exists())
            {
                PrintStream out=new PrintStream(f);
                for(Nguoi i:a)
                {
                    out.println(i);
                }
                out.close();
            }
            //else System.out.println("file file da ton tai!!!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public SinhVien findaxdtb()
    {
        double max=0;
        int local=0;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i) instanceof SinhVien)
            {
                if(((SinhVien)a.get(i)).getDtb()>max)
                {
                    max=((SinhVien)a.get(i)).getDtb();
                    local=i;
                }
            }
        }
        return (SinhVien)a.get(local);
    }
    void loai()
    {
        for(int i=0;i<a.size();i++)
        {
            if(((SinhVien)a.get(i)).xeploai().equals("kem"))
            {
                a.remove(a.get(i));
                i--;
            }
        }
        xuat("danh sach sau khi loai: ");
    }
    public void output()
    {
        xuat("Danh sach vua nhap:");
        wirtefile("SV.txt");
        System.out.println("Sinh vien co diem trung binh cao nhat: "+findaxdtb());
        System.out.println("diem trung binh chung: "+DTBchung());
        loai();
    }
    
    public static void main(String[] args)
    {
        DanhSach a=new DanhSach();
        a.Nhap();
        a.output();
    }
            
}
