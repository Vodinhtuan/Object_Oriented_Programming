
package quanlybenhvien;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
import javax.swing.JOptionPane;
public class DSBENHNHAN {
    ArrayList<BENHNHAN> a = new ArrayList<>();
    public void readfile(String nd) {
        a = new ArrayList<>();
        try {
            File f = new File(nd);
            if (f.exists()) {
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner sc = new Scanner(read.nextLine());
                    String ma = "", hoten="";
                    String nn,nx;
                    boolean phong;
                    ma = sc.next();
                    while(!sc.hasNextBoolean()) hoten += sc.next()+" ";
                    hoten = hoten.trim();
                    phong=sc.nextBoolean();
                    nn = sc.next();
                    nx = sc.next();

                    if (sc.nextBoolean()==true) {
                       
                        a.add(new BENHNHANBAOHIEMYTE(ma,hoten, new NgayThang(nn),new NgayThang(nx), phong));
                    } else {
                        a.add(new BENHNHANBAOHIEMXAHOI(ma,hoten, new NgayThang(nn),new NgayThang(nx), phong));
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
     public ArrayList<BENHNHAN> getDanhSach() {
        return a;
    }

    public void setDanhSach(ArrayList<BENHNHAN> a) {
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
                for(BENHNHAN i:a)
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
        for (BENHNHAN i : a) {
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
    public boolean ThemMoi(BENHNHAN bn) {
        for (BENHNHAN i : a) {
            if (i.getMa().equalsIgnoreCase(bn.getMa())) {
                return false;
            }
        }
        a.add(bn);
        return true;
    } 
    public boolean CapNhat(BENHNHAN bn) {
        for (BENHNHAN i : a) {
            if (i.getMa().equalsIgnoreCase(bn.getMa())) {
                a.set(a.indexOf(i),bn);
                return true;
            }
        }
        return false;
    }
    public void SapXepTang()
    {
        BENHNHAN temp;
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
            {
                    if(a.get(i).Tinhhoadonvienphi()>a.get(j).Tinhhoadonvienphi())
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
        BENHNHAN temp;
        for(int i=0;i<a.size();i++)
        {
           for(int j=i+1;j<a.size();j++)
            {
                    if(a.get(i).Tinhhoadonvienphi()<a.get(j).Tinhhoadonvienphi())
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
        BENHNHAN temp;
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
    double tongBHYT()
    {
        double sum=0;
        for(BENHNHAN i:a)
        {
            if(i instanceof BENHNHANBAOHIEMYTE) sum+=((BENHNHANBAOHIEMYTE)i).Tinhhoadonvienphi();
        }
        return sum;
    }
    double tongBHXH()
    {
        double sum=0;
        for(BENHNHAN i:a)
        {
            if(i instanceof BENHNHANBAOHIEMXAHOI) sum+=((BENHNHANBAOHIEMXAHOI)i).Tinhhoadonvienphi();
        }
        return sum;
    }
    double tongPYC()
    {
        double sum=0;
        for(BENHNHAN i:a)
        {
            if(i.isPhongyeucau()) sum+=i.Tinhhoadonvienphi();
        }
        return sum;
    }
    double tongKPYU()
    {
        double sum=0;
        for(BENHNHAN i:a)
        {
            if(i.isPhongyeucau()==false) sum+=i.Tinhhoadonvienphi();
        }
        return sum;
    }
} 
