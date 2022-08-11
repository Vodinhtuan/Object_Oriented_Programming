
package th10;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachHangHoa {
    ArrayList<HangHoa> a =new ArrayList<>();
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
                    String ma="",ngaythang="",ns="";
                    int dongia,soluong;
                    ma=sc.next();
                    ngaythang=sc.next();
                    ngaythang=ngaythang.trim();
                    dongia=sc.nextInt();
                    soluong=sc.nextInt();
                    ns=sc.next();
                    if(sc.hasNext())
                    {
                        ns=ns+" "+sc.next();
                        a.add(new HangThuCong(ma,new NgayThangNam(ngaythang),dongia,soluong,ns));
                    }
                    else
                    {
                       a.add(new HangDienMay(ma,new NgayThangNam(ngaythang),dongia,soluong,ns));
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
        for(HangHoa i:a)
        {
            System.out.print("\t"+i+"\n"); 
        }
        System.out.println();
    }
     public void phanloai()
    {
        double sum1=0,sum2=0,sum3=0;
        System.out.println("Hang dien may trong nuoc:");
        for(HangHoa i : a)
        {
            if(i instanceof HangDienMay &&  i.getNs().equals("TN"))
            {
                System.out.println("\t"+i);
                sum1+=i.thanhtien();
            }
        }
        System.out.println("Hang dien may nhap khau:");
        for(HangHoa i : a)
        {
            if(i instanceof HangDienMay && i.getNs().equals("NK"))
            {
                System.out.println("\t"+i);
                sum2+=i.thanhtien();
            }
        }
        System.out.println("Hang thu cong:");
        for(HangHoa i : a)
        {
            if(i instanceof HangThuCong )
            {
                System.out.println("\t"+i);
                sum3+=i.thanhtien();
            }
        }
        System.out.println("Tong thanh tien cua Hang dien may trong nuoc: "+sum1);
        System.out.println("Tong thanh tien cua Hang dien may nhap khau: "+sum2);
        System.out.println("Tong thanh tien cua Hang thu cong: "+sum3);
    }
    public void find()
    {
        String ma="";
        System.out.print("nhap ma can tim: ");
        Scanner sc=new Scanner(System.in);
        ma=sc.nextLine();
        ma=ma.trim();
        boolean check=false;
        for(HangHoa i:a)
        {
            if(i.getMa().equals(ma))
            {
                System.out.println(i);
                check=true;
            }
        }
        if(check==false) System.err.println("Khong co ma "+ ma +" trong danh sach");
    }
    public void xoa()
    {
        String ma="";
        System.out.print("nhap ma can xoa: ");
        Scanner sc=new Scanner(System.in);
        ma=sc.nextLine();
        ma=ma.trim();
        boolean check=false;
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).getMa().equals(ma))
            {
                a.remove(a.get(i));
                check=true;
                i--;
            }
        }
        if(check) xuat("danh sach sau khi xoa ma "+ma);
        else System.err.println("Khong co ma "+ ma +" trong danh sach");
    }
    public void findmaxthanhtien()
    {
        int temp=0;
        double max=a.get(0).thanhtien();
        for(int i=0;i<a.size();i++)
        {
            if(max<a.get(i).thanhtien())
            {
                max=a.get(i).thanhtien();
                temp=i;
            }
        }
         System.out.println("Hoa don co tong thanh tien lon nhat: "+a.get(temp));
    }
    public void sumday()
    {
        System.out.println("Tong thanh tien theo ngay:");
        ArrayList<HangHoa> temp=new ArrayList<>(a);
        for(int i=0;i<temp.size();i++)
        {
            double sum=temp.get(i).thanhtien();
            for(int j=i+1;j<temp.size();j++)
            {
                if(temp.get(i).getNgaythang().getNgay()==temp.get(j).getNgaythang().getNgay() &&
                       temp.get(i).getNgaythang().getThang()==temp.get(j).getNgaythang().getThang() &&
                        temp.get(i).getNgaythang().getNam()==temp.get(j).getNgaythang().getNam())
                {
                    sum+=temp.get(j).thanhtien();
                    temp.remove(temp.get(j));
                    j--;
                }
            }
            System.out.println("\t ngay "+temp.get(i).getNgaythang() +" : "+sum);
            temp.remove(temp.get(i));
            i--;
        }
    }
    public void summonth()
    {
       System.out.println("Tong thanh tien theo thang:");
        ArrayList<HangHoa> temp=new ArrayList<>(a);
        for(int i=0;i<temp.size();i++)
        {
            double sum=temp.get(i).thanhtien();
            for(int j=i+1;j<temp.size();j++)
            {
                if(temp.get(i).getNgaythang().getThang()==temp.get(j).getNgaythang().getThang()
                        && temp.get(i).getNgaythang().getNam()==temp.get(j).getNgaythang().getNam())
                {
                    sum+=temp.get(j).thanhtien();
                    temp.remove(temp.get(j));
                    j--;
                }
            }
            System.out.println("\t thang "+temp.get(i).getNgaythang().getThang() +
                    "/" +temp.get(i).getNgaythang().getNam()+ " : "+sum);
            temp.remove(temp.get(i));
            i--;
        }
       
    }
    
    void tongtheongay()
    {
        double sum=0;
        String ngay="";
        System.out.print("nhap ngay can tinh: ");
        Scanner sc=new Scanner(System.in);
        ngay=sc.nextLine();
        ngay=ngay.trim();
        boolean check=false;
        for(HangHoa i:a)
        {
            if(i.getNgaythang().toString().equals(ngay))
            {
                sum+=i.thanhtien();
                check=true;
            }
        }
        if(check) System.out.println("Tong thanh tien theo ngay "+ngay+" : "+sum);
        else System.out.println("Khong co ngay "+ ngay +" trong danh sach");
    
    }
     void tongtheothang()
    {
        double sum=0;
        int thang,nam;
        String chuoi="";
        System.out.print("nhap thang can tinh: ");
        Scanner sc=new Scanner(System.in);
        chuoi=sc.nextLine();
        String[] temp=chuoi.split("/");
        thang=Integer.parseInt(temp[0]);
        nam=Integer.parseInt(temp[1]);
        boolean check=false;
        for(HangHoa i:a)
        {
            if(i.getNgaythang().getThang()==thang&&i.getNgaythang().getNam()==nam)
            {
                sum+=i.thanhtien();
                check=true;
            }
        }
        if(check) System.out.println("Tong thanh tien theo thang "+chuoi+" : "+sum);
        else System.out.println("Khong co thang "+ chuoi +" trong danh sach");
    
    }
    
    public void output()
    {
        xuat("danh sach: ");
        phanloai();
        //find();
        xoa();
        findmaxthanhtien();
        sumday();
        summonth();
        tongtheongay();
        tongtheothang();
    }
   
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        DanhSachHangHoa a= new DanhSachHangHoa();
        a.readfile("TH.txt");
        a.output();
    }
}
