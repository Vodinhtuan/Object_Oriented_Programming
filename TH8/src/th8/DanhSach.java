
package th8;

import java.util.Scanner; 
import java.util.ArrayList;
import java.io.File;
public class DanhSach {
    ArrayList<Nguoi> a =new ArrayList<>();
    void readfile(String nd)
    {
        try
        {
            File f= new File(nd);
            if(f.exists())
            {
                Scanner read= new Scanner(f);
                while(read.hasNext())
                {
                    Scanner sc=new Scanner(read.nextLine());
                    String ma="",ht="",ns="",mon="";
                    boolean gt;
                    int d1,d2,d3;
                    ma=sc.next();
                    while(!sc.hasNextBoolean()) ht+=sc.next()+" ";
                    ht=ht.trim();
                    gt=sc.nextBoolean();
                    ns=sc.next();
                    d1=sc.nextInt();
                    d2=sc.nextInt();
                    if(sc.hasNextInt())
                    {
                        d3=sc.nextInt();
                        a.add(new SinhVien(ma,ht,ns,gt,d1,d2,d3));
                    }
                    else
                    {
                        mon=sc.nextLine();
                        a.add(new GiangVien(ma,ht,ns,gt,mon,d1,d2));
                    }
                }
            }
            else System.out.println("khong ton tai file");
        }
        catch( Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public void xuat(String nd)
    {
        System.out.println(nd);
        for(Nguoi i:a)
        {
            System.out.print("\t"+i+"\n"); 
        }
        System.out.println();
    }
    public void Count()
    {
        int countsv =0;
        for( Nguoi i:a)
        {
            if(i instanceof SinhVien) countsv++;
        }
        System.out.println("So sinh vien co trong danh sach: "+countsv);
        System.out.println("So giang vien co trong danh sach: "+(a.size()-countsv));
    }
    public SinhVien findaxdtb()
    {
        double max=0;
        int local=0;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i) instanceof SinhVien)
            {
                if(((SinhVien)a.get(i)).diemtrungbinh()>max)
                {
                    max=((SinhVien)a.get(i)).diemtrungbinh();
                    local=i;
                }
            }
        }
        return (SinhVien)a.get(local);
    }
    public int summoney()
    {
        int sum=0;
        for(Nguoi i:a)
        {
            if(i instanceof GiangVien) sum+=((GiangVien) i).thanhtien();
        }
        return sum;
    }
    public void sapxep()
    {
        SinhVien temp1;
        GiangVien temp2;
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
                {
                    if(a.get(i) instanceof SinhVien  && a.get(j) instanceof SinhVien )
                    {
                        if(((SinhVien) a.get(i)).diemtrungbinh()>((SinhVien) a.get(j)).diemtrungbinh())
                        {
                            temp1 =(SinhVien) a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp1);
                        }
                    }
                    if(a.get(i) instanceof GiangVien  && a.get(j) instanceof GiangVien )
                    {
                        if(((GiangVien) a.get(i)).thanhtien()<((GiangVien) a.get(j)).thanhtien())
                        {
                            temp2 =(GiangVien) a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp2);
                        }
                    }
                } 
                
        }
        xuat("Danh sach sau khi sap xep kieu 1:");
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
                {
                    if(a.get(i) instanceof SinhVien )
                    {
                        
                            temp1 =(SinhVien) a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp1);
                        
                    }
                }
        }
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
                {
                    if(a.get(i) instanceof SinhVien  && a.get(j) instanceof SinhVien )
                    {
                        if(((SinhVien) a.get(i)).diemtrungbinh()>((SinhVien) a.get(j)).diemtrungbinh())
                        {
                            temp1 =(SinhVien) a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp1);
                        }
                    }
                    if(a.get(i) instanceof GiangVien  && a.get(j) instanceof GiangVien )
                    {
                        if(((GiangVien) a.get(i)).thanhtien()<((GiangVien) a.get(j)).thanhtien())
                        {
                            temp2 =(GiangVien) a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp2);
                        }
                    }
                } 
                
        }
        xuat("Danh sach sau khi sap xep kieu 2:");
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
                {
                    if(a.get(i) instanceof GiangVien )
                    {
                        
                            temp2 =(GiangVien) a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp2);
                        
                    }
                }
        }
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
                {
                    if(a.get(i) instanceof SinhVien  && a.get(j) instanceof SinhVien )
                    {
                        if(((SinhVien) a.get(i)).diemtrungbinh()>((SinhVien) a.get(j)).diemtrungbinh())
                        {
                            temp1 =(SinhVien) a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp1);
                        }
                    }
                    if(a.get(i) instanceof GiangVien  && a.get(j) instanceof GiangVien )
                    {
                        if(((GiangVien) a.get(i)).thanhtien()<((GiangVien) a.get(j)).thanhtien())
                        {
                            temp2 =(GiangVien) a.get(i);
                            a.set(i,a.get(j));
                            a.set(j,temp2);
                        }
                    }
                } 
                
        }
        xuat("Danh sach sau khi sap xep kieu 3 (dung):");
    }
    public void output()
    {
        xuat("Danh sach vua nhap:");
        Count();
        System.out.println("Sinh vien co diem trung binh cao nhat: "+findaxdtb());
        System.out.println("tong thanh tien cua tat ca giang vien trong danh sach: "+summoney());
        sapxep();
    }
    
    public static void main(String[] args)
    {
        DanhSach a=new DanhSach();
        a.readfile("TH.txt");
        a.output();
    }
            
}
