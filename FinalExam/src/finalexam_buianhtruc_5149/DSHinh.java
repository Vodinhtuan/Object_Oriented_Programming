
package finalexam_buianhtruc_5149;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
import javax.swing.JOptionPane;

public class DSHinh {
     ArrayList<IHinh> a = new ArrayList<>();
    public void readfile(String nd) {
        a = new ArrayList<>();
        try {
            File f = new File(nd);
            
            if (f.exists()) {
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner sc = new Scanner(read.nextLine());
                    double b,c,d;
                    b=sc.nextDouble();
                    if(sc.hasNext())
                    {
                        
                        c=sc.nextDouble();
                        if(sc.hasNext())
                        {
                            d=sc.nextDouble();
                            a.add(new HinhHCN(b,c,d));
                        }
                        else
                        {
                            a.add(new HinhCN(b,c));
                        }
                    }
                    else 
                    {
                        a.add(new HinhTron(b));
                    }
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
     public ArrayList<IHinh> getDanhSach() {
        return a;
    }

    public void setDanhSach(ArrayList<IHinh> a) {
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
                for(IHinh i:a)
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
    public void ThemMoi(IHinh bn) {
        a.add(bn);
    }
    public ArrayList<IHinh> SapXepTang()
    {
        ArrayList<IHinh> b = new ArrayList<>(a);
        IHinh temp;
        for(int i=0;i<b.size();i++)
        {
           for(int j=i+1;j<b.size();j++)
            {
                    if(b.get(i).DienTich()>b.get(j).DienTich())
                    {
                            temp = b.get(i);
                            b.set(i,b.get(j));
                            b.set(j,temp);
                    }   
            } 
                
        }
        return b;
    }
    public IHinh FindMax()
    {
        IHinh temp= a.get(0);
        for(int i=0;i<a.size();i++)
        {
                if(a.get(i) instanceof HinhCN)
                {
                    if(a.get(i).DienTich()>temp.DienTich())
                        {
                            temp = a.get(i);
                        }
                }
                    
            } 
        return temp;
    }
}
