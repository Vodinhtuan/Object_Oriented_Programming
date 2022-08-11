
package kt;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintStream;
public class DSBENHNHAN {
    ArrayList<BENHNHAN> a = new ArrayList<>();
    public void readfile(String nd) {
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
                System.out.println("khong ton tai file!!!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
     public ArrayList<BENHNHAN> getDanhSach() {
        return a;
    }

    public void setDanhSach(ArrayList<BENHNHAN> a) {
        this.a = a;
    }
    public void wirtefile(String nd, ArrayList<BENHNHAN> temp)
    {
        try
        {
            File f = new File(nd);
            if(!f.exists())
            {
                PrintStream out=new PrintStream(f);
                for(BENHNHAN i:temp)
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
    public BENHNHAN TimKIem(String ma) {
        for (BENHNHAN i : a) {
            if (i.getMa().equalsIgnoreCase(ma)) {
                return i;
            }
        }
        return null;
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
    public boolean CapNhap(BENHNHAN bn) {
        for (BENHNHAN i : a) {
            if (i.getMa().equalsIgnoreCase(bn.getMa())) {
                return false;
            }
        }
        a.add(bn);
        return true;
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
   
   
}
