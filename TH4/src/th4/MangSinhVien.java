
package th4;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class MangSinhVien 
{
private ArrayList<SinhVien> a=new ArrayList<SinhVien>();
    public void docFile(String tenFile){
        try{
            File f=new File(tenFile);
            if(f.exists()){
                Scanner read=new Scanner(f);
                while (read.hasNext()) {
                    Scanner line=new Scanner(read.nextLine());
                    String ma, ht, ns, qq;
                    boolean gt;
                    double diem;
                    ma= line.next();
                    ht="";
                    while (!line.hasNextBoolean())
                        ht = ht + line.next()+" ";
                    ht=ht.trim();
                    gt=line.nextBoolean();
                    ns=line.next();
                    qq="";
                    while(!line.hasNextDouble())
                        qq = qq + line.next()+" ";
                    qq=qq.trim();
                    diem=line.nextDouble();
                    SinhVien x=new SinhVien(ma, ht, ma, qq, gt, diem);
                    a.add(x);
                }
            }else System.out.println("Khong ton tai file");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void xuatDS(String noiDung){
        System.out.println(noiDung);
        for(SinhVien x:a)
            System.out.println(x);
    }
    double DTBChung(){
        double s = 0;
        for (int i=0; i<a.size(); i++)
            s = s + a.get(i).getDiemTB();
        return s/a.size();
    }
    void DTBTheoGT(){
        double s1=0, s2=0;
        int d1=0, d2=0;
        for (int i=0; i<a.size(); i++){
            if (a.get(i).isGioiTinh() == true){
                s1 = s1 + a.get(i).getDiemTB();
                d1++;
            }else{
                s2 = s2 + a.get(i).getDiemTB();
                d2++; 
            }
        }
        System.out.println("c. Diem trung binh (Nam): "+s1/d1);
        System.out.println("Diem trung binh (Nu): "+s2/d2);
     }
     void congDiem(){
         for(SinhVien i:a){
             if(i.getQueQuan().compareTo("Nghe An")==0)
                i.setDiemTB(i.getDiemTB()+0.5);
             if(i.getDiemTB()>10) 
                i.setDiemTB(10);
         }
         xuatDS("d. Cong 0.5 diem cho nhung sinh vien que Nghe An: ");
     }
      void loaiSV(){
         double dtb=DTBChung();
         for(int i=0;i<a.size();i++){
             if(a.get(i).getDiemTB()<dtb)
                 a.remove(a.get(i));
         }
         xuatDS("e. Loai nhung sinh vien co diem trung binh nho hon diem trung binh chung:");
     }
      void sapXep(){
          for (int i=0; i<a.size()-1; i++)
            for (int j=i+1; j<a.size(); j++)
                if (a.get(i).getDiemTB()< a.get(j).getDiemTB()){
                   SinhVien t = a.get(i);
                   a.set(i,a.get(j));
                   a.set(j,t);
               }
         xuatDS("f. Sap xep cac sinh vien giam dan theo diem:");  
      }
      void viThu(){
          int viThu = 0;
          for (int i=0; i<a.size(); i++){
              viThu = 0;
              for(int j=0;j<a.size();j++){
                  if(j!=i){
                      if(a.get(i).getDiemTB()<a.get(j).getDiemTB()) viThu++;
                  }
              }
              System.out.println(a.get(i).getHoTen()+" "+": Vi thu "+(viThu+1));
          }
      }
    public void output(){
        xuatDS("DS SV vua doc tu file ");
        //xuatDS("a. Sinh vien vua nhap: ");
        System.out.println("");
        System.out.println("b. Diem trung binh chung: "+DTBChung());
        System.out.println("");
        DTBTheoGT();
        System.out.print("");
        congDiem();
        System.out.print("");
        loaiSV();
        System.out.print("");
        sapXep();
        System.out.println(" g. Vi thu cua moi sinh vien: ");
        viThu();
    }
    public static void main(String[] args){
        MangSinhVien a=new MangSinhVien();
        a.docFile("SV.txt");
        //a.input();
        a.output();
    }
}
/*
void input()
    {
        int n=0;
        Scanner sc= new Scanner(System.in);
        do
        {
            System.out.print("nhap so sinh vien>0: ");
            n=sc.nextInt();
        }   while(n<=0);
        
        for(int i=0;i<n;i++)
        {
            SinhVien temp=new SinhVien();
            System.out.println("sinh vien "+(i+1)+": ");
            do
            {
                System.out.print("nhap ma sinh vien: ");
                sc= new Scanner(System.in);
                temp.setMasv(sc.nextLine());
                if(a.size()>0)
                {
                    boolean check =true;
                    for(int j=0;j<a.size();j++)
                    {
                        if(temp.getMasv().compareTo(a.get(j).getMasv())==0) 
                        {
                            check=false;
                            continue;
                        }
                    }
                    if(check==true) break;
                }
                else break;
            }   while (true);
            sc= new Scanner(System.in);
            System.out.print("nhap ho ten: ");
            temp.setHoten(sc.nextLine());
            sc= new Scanner(System.in);
            System.out.print("nhap giotinh(true=nam false=nu: ");
            temp.setGioitinh(sc.nextBoolean());
            sc= new Scanner(System.in);
            System.out.print("nhap ngay sinh: ");
            temp.setNgaysinh(sc.nextLine());
            System.out.print("nhap que quan: ");
            temp.setQuequan(sc.nextLine());
            sc= new Scanner(System.in);
            do
            {
                System.out.print("nhap diem trung binh (0-10): ");
                temp.setDtb(sc.nextDouble());
            } while(temp.getDtb()<0||temp.getDtb()>10);
            sc= new Scanner(System.in);
            a.add(temp);
        }
    }
*/