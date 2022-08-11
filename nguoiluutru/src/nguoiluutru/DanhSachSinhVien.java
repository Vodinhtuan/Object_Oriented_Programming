/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nguoiluutru;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


    public class DanhSachSinhVien {
        private ArrayList<Nguoiluutru> a=new ArrayList<Nguoiluutru>();
    public void docFile(String tenFile){
        try{
            File f=new File(tenFile);
            if(f.exists()){
                Scanner read=new Scanner(f);
                while (read.hasNext()) {
                    Scanner line=new Scanner(read.nextLine());
                    String ma, ten, ns, dc, mail;
                    boolean gt;
                    double diem;
                    ma= line.next();
                    ten=" ";
                    while(!line.hasNextBoolean())
                    ten = ten + line.next()+" ";
                    ten=ten.trim();
                    gt=line.nextBoolean();
                    mail=line.next();
                    ns =line.next();
                    ns=ns.trim();
                    dc=" ";
                    while(!line.hasNextDouble())
                    dc=dc+line.next()+" ";
                    dc=dc.trim();
                    diem=line.nextDouble();
                    SinhVien x=new SinhVien(ten, dc, ns, gt, ma, mail, diem);
                    a.add(x);
                }
            }else System.out.println("Khong ton tai file");
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public void xuatDS(String noiDung){
        System.out.println(noiDung);
        for(Nguoiluutru x:a)
            System.out.println(x);
    }
    public String diemMax(){
        SinhVien x=null;
        int i=0;
        for(i=0;i<a.size();i++)
        {
            if(a.get(i) instanceof SinhVien)
            {
                x=(SinhVien)a.get(i); break;
            }
        }
        for(i=i+1;i<a.size();i++)
        {
            if(a.get(i) instanceof SinhVien)
                if(x.getDiemTB()<((SinhVien)a.get(i)).getDiemTB())
                {
                    x=((SinhVien)a.get(i));
                }
        }
        return x.getTen()+" - "+x.getDiemTB();
    }    
    public void loaiSVKem(){                 
        for(int i=0;i<a.size();i++){
            if(a.get(i) instanceof SinhVien)
            {                
                if(((SinhVien)a.get(i)).getDiemTB()<3)  
                    a.remove(((SinhVien)a.get(i)));                 
            }
        }
        xuatDS("d.Loai nhung sinh vien có học lực kém: ");
    }
    public double DTBChung(){
        double s = 0;
        for (int i=0; i<a.size(); i++)
            if(a.get(i) instanceof SinhVien){
                s = s + ((SinhVien)a.get(i)).getDiemTB();
        }
          return s/a.size();
    }
    public void hocBong(){  
        int dem=0;
        for(int i=0;i<a.size();i++){            
            if(a.get(i) instanceof SinhVien)
            {                
                if(((SinhVien)a.get(i)).getDiemTB()>8)                      
                    dem++;
                //else  a.remove(((SinhVien)a.get(i)));     
            }
        }
        System.out.println("f.Có "+dem+" sinh viên đạt được học bổng");
        
    }
    public void sapXep(){
          for (int i=0; i<a.size()-1; i++)
            for (int j=i+1; j<a.size(); j++)
                if(a.get(i) instanceof SinhVien){
                if (((SinhVien)a.get(i)).getDiemTB()< ((SinhVien)a.get(j)).getDiemTB()){
                   SinhVien t = (SinhVien)a.get(i);
                   a.set(i,a.get(j));
                   a.set(j,t);
               }
            }    
        xuatDS("g.Sap xep cac sinh vien giam dan theo diem:");  
    }
    public void viThu(){
        for (int i=0; i<a.size(); i++){
            int dem=0;
            for(int j=0;j<a.size();j++){
                if(a.get(i) instanceof SinhVien){
                    if(i!=j){
                        if(((SinhVien)a.get(i)).getDiemTB()<((SinhVien)a.get(j)).getDiemTB()) 
                            dem++;
                }
            }
        }        
            System.out.println(((SinhVien)a.get(i)).getTen()+" "+": Vi thu "+(dem+1));        
    } 
}        
    public void output(){
        xuatDS("b.DSSV vua doc tu file ");
        System.out.println("c.Sinh viên có điểm cao nhất: "+diemMax()); 
        loaiSVKem();
        System.out.println("e.Điểm trung bình chung:"+DTBChung()); 
        hocBong();        
        sapXep();        
        System.out.println("g.Vị thứ của mỗi sinh viên:");
        viThu();
    }
        public static void main(String[] args) {
            DanhSachSinhVien a = new DanhSachSinhVien();
            a.docFile("SV1.txt");
            a.output();
        }
    }


