
package quanlybenhvien;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class DSTaiKhoan {
    ArrayList<TaiKhoan> a= new ArrayList();
    public void readfile(String nd) {
        a = new ArrayList<>();
        try {
            File f = new File(nd);
            if (f.exists()) {
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner sc = new Scanner(read.nextLine());
                    String ten = "", mk="";
                    ten=sc.next();
                    mk=sc.next();
                    a.add(new TaiKhoan(ten,mk));       
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
     public ArrayList<TaiKhoan> getDanhSach() {
        return a;
    }

    public void setDanhSach(ArrayList<TaiKhoan> a) {
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
                for(TaiKhoan i:a)
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
        for (TaiKhoan i : a) {
            if (i.getTentk().equals(ma)) {
                return a.indexOf(i);
            }
        }
        return -1;
    }
    public boolean ThemMoi(TaiKhoan bn) {
        for (TaiKhoan i : a) {
            if (i.getTentk().equals(bn.getTentk())) {
                return false;
            }
        }
        a.add(bn);
        return true;
    } 
}
