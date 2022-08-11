
package th17;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.PrintStream;

public class MangSinhVien 
{
    ArrayList<SinhVien> a=new ArrayList<>();

    public ArrayList<SinhVien> getDanhSach() {
        return a;
    }

    public void setDanhSach(ArrayList<SinhVien> a) {
        this.a = a;
    }
    
    void docfile(String nd)
    {
       
        try
        {        
            File f= new File(nd);
            if(f.exists())
            {
                Scanner read=new Scanner(f);
                while(read.hasNext())
                {
                    double dtb;
                    boolean gioitinh;
                    String masv="",hoten = "",ngaysinh="",quequan = "";
                    Scanner sc=new Scanner(read.nextLine());
                    masv=sc.next();
                    while (!sc.hasNextBoolean()) hoten=hoten+sc.next()+" ";
                    hoten=hoten.trim();
                    gioitinh=sc.nextBoolean();
                    while (!sc.hasNextDouble()) quequan=quequan+sc.next()+" ";
                    quequan=quequan.trim();
                    dtb=sc.nextDouble();
                    ngaysinh=sc.nextLine();
                    ngaysinh=ngaysinh.trim();
                    SinhVien temp=new SinhVien( dtb,  gioitinh,  masv,  hoten,  ngaysinh,  quequan);
                    a.add(temp);
                }
            }
            else System.out.println("khong ton tai file");    
        } 
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
      public void wirtefile(String nd, ArrayList<SinhVien> temp)
    {
        try
        {
            File f = new File(nd);
            if(!f.exists())
            {
                PrintStream out=new PrintStream(f);
                for(SinhVien i:temp)
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
    boolean ThemMoi(SinhVien sinhvien)
    {
        for(SinhVien i:a)
        {
            if(i.getMasv().equals(sinhvien.getMasv())) return false;
        }
        a.add(sinhvien);
        return true;
    }
            
     void xuatMang(String nd)
    {
        System.out.println(nd);
        for(SinhVien i:a)
        {
            System.out.print(i+"\n"); 
        }
        System.out.println();
    }
     double dtbchung()
     {
        double sum = 0;
        for (int i=0;i<a.size();i++){
            sum += a.get(i).getDtb();
        }
        return (sum/a.size());
     }
     void dtbtheogt()
     {
        double sum1 = 0, sum2 = 0;
        int count1 = 0, count2 = 0;
        for (int i=0;i<a.size();i++){
            if (a.get(i).isGioitinh() == true){
                sum1 += a.get(i).getDtb();
                count1++;
            }
            else{
                sum2 += a.get(i).getDtb();
                count2++; 
            }
        }
        System.out.println("c diem trung binh(nam): "+(double)sum1/count1);
        System.out.println("diem trung binh(nu): "+(double)sum2/count2);
     }
     void congdiem()
     {
         for(SinhVien i:a)
         {
             if(i.getQuequan().compareTo("Nghe An")==0) i.setDtb(i.getDtb()+0.5);
             if(i.getDtb()>10) i.setDtb(10);
         }
         xuatMang("d Sinh vien sau khi cong diem");
     }
      void loaisv()
     {
         double dtb=dtbchung();
         for(int i=0;i<a.size();i++)
         {
             if(a.get(i).getDtb()<dtb) 
             {
                 a.remove(a.get(i));
                 i--;
             }
         }
         xuatMang("e Sinh vien sau khi loai sinh vien co diem thap hon diem trung binh chung:"+dtb);
     }
      void sapxep()
      {
          SinhVien temp;
          for (int i=0;i<a.size();i++)
        {
            for (int j=i+1;j<a.size();j++)
            {
                if (a.get(i).getDtb()< a.get(j).getDtb())
                {
                   temp = a.get(i);
                   a.set(i,a.get(j));
                   a.set(j,temp);
               }
            }  
        }
         xuatMang("f Sinh vien sau khi loai sap xep:");  
      }
      void vithu()
      {
          int vithu=0;
          for (int i=0;i<a.size();i++)
          {
              vithu=0;
              for(int j=0;j<a.size();j++)
              {
                  if(j!=i)
                  {
                      if(a.get(i).getDtb()<a.get(j).getDtb()) vithu++;
                  }
              }
              System.out.println(a.get(i).getMasv()+" "+a.get(i).getHoten()+" "+"vi thu "+(vithu+1));
          }
      }
     
}
