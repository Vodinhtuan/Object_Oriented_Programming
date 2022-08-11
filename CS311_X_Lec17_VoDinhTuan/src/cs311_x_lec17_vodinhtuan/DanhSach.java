/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311_x_lec17_vodinhtuan;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
//import java.io.LineNumberReader;

/**
 *
 * @author Admin
 */
public class DanhSach {
    private ArrayList<Nguoi> a = new ArrayList<Nguoi>();
    public void docFile(String tenFile){
        try {
            File f= new File(tenFile);
            if (f.exists()){
                Scanner read = new Scanner(f);
                while(read.hasNext()){
                    Scanner line = new Scanner(read.nextLine());
                    String ma, ht="",ns;
                    boolean gt;
                    double c1, c2;
                    ma= line.next();
                    while(!line.hasNextBoolean())
                        ht=ht+line.next();
                    gt=line.nextBoolean();
                    ns=line.next();
                    c1=line.nextDouble();
                    c2=line.nextDouble();
                    if(line.hasNextDouble()){
                        double c3=line.nextDouble();
                        SinhVien x=new SinhVien(c1,c2,c3,ma,ht,ns,gt); a.add(x);
                    }else {
                        String mon=line.nextLine();
                        GiangVien x = new GiangVien(mon,c1,c2,ma,ht,ns,gt); a.add(x);
                    }
                }
            }else System.out.println("Không tồn tại file");
        } catch (Exception e) {
        }
    }
        public void xuatDS(String noiDung){
        System.out.println(noiDung);
        for(Nguoi x:a){                 
            System.out.println(x);    
        }
    }
    public void demSV()
    {
        int demGV=0;
        for (Nguoi x :a){    //for(int i=0;i<a.size();i++)
            if (x instanceof GiangVien) //System.out.println(a.get(i)); 
            {
                demGV++;
            }
        }
        System.out.println("Giang Vien:"+demGV);
        System.out.println("Sinh Vien:"+(a.size()-demGV));
    }
    public void maxDTB(){
        double maxDTB = 0;
        Nguoi diem = null;
        for (Nguoi x : a){
            if(x instanceof SinhVien)
                if (maxDTB < ((SinhVien) x).tinhdtb()){
                    maxDTB = ((SinhVien) x).tinhdtb();
                    diem = x;
            }
        }
        System.out.println("Sinh vien co diem trung binh cao nhat:"+diem);
    }
    public double tongThanhTien(){
        double s=0;
        for (Nguoi x : a){
            if(x instanceof GiangVien)
            s = s + ((GiangVien)x).tinhThanhTien();        
        }
        return s;
    }
    public void sapXepSV(){
          for (int i=0; i<a.size()-1; i++)
            for (int j=i+1; j<a.size(); j++)
                if(a.get(i) instanceof SinhVien)
                if (((SinhVien) a.get(i)).tinhdtb()>((SinhVien) a.get(i)).tinhdtb()){
                   SinhVien t = ((SinhVien) a.get(i));
                   a.set(i,a.get(j));
                   a.set(j,t);
               }
        xuatDS("f.Sap xep cac sinh vien tang dan theo diem:");  
    }
    public void sapXepGV(){
          for (int i=0; i<a.size()-1; i++)
            for (int j=i+1; j<a.size(); j++)
                if(a.get(i) instanceof GiangVien)
                if (((GiangVien) a.get(i)).tinhThanhTien()<((GiangVien) a.get(i)).tinhThanhTien()){
                   GiangVien t = ((GiangVien) a.get(i));
                   a.set(i,a.get(j));
                   a.set(j,t);
               }
        xuatDS("f.Sap xep cac giang vien giam dan theo diem:");  
    }
    public void output(){
        xuatDS("Noi dung File:");
        demSV();
        maxDTB();
        System.out.println("Tong thanh tien cua giang vien:"+tongThanhTien());
        sapXepSV();
        sapXepGV();
    }
//    public void demSV()
//    {
//        int demGV=0;
//         for (Nguoi x : a) {
//            if (x instanceof GiangVien) 
//            {
//                demGV++;
//            }
//        }
//        System.out.println("Giang Vien: "+demGV);
//        System.out.println("Sinh Vien: "+(a.size()-demGV));
//    }
//    public void xuat(String noiDung){
//        System.out.println(noiDung);
//        for(Nguoi x: a)
//            System.out.println(x);
//    }
//    public void output(){
//        xuat("DS vua doc tu file: ");
//        demSV();
//    }
    public static void main(String[] args) {
        DanhSach a= new DanhSach();
        a.docFile("SV_GV.txt");
        a.output();
    }
}
