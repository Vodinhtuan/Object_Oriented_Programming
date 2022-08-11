/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs311x_lab05_vodinhtuan;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public abstract class DanhSachSinhVien {
    private ArrayList<SV> a = new ArrayList<SV>();
    public void docFile(String tenFile) {
        try {
            File f = new File(tenFile);
            if(f.exists()){
                Scanner read = new Scanner(f);
                while (read.hasNext()) {
                    Scanner line = new Scanner(read.nextLine());
                    String ma, ht="";
                    boolean gt;
                    double c1,c2;
                    ma=line.next();
                    while(!line.hasNextBoolean())
                        ht=ht+line.next()+" ";
                    gt = line.nextBoolean();
                    c1=line.nextDouble();
                    c2=line.nextDouble();
                    if(line.hasNextDouble()){
                        double c3=line.nextDouble();
                        CNTT x =new CNTT(c1,c2,c3,ma,ht,gt) {};
                        a.add(x);
                    }else{
                        KinhTe x = new KinhTe(c1,c2,ma,ht,gt) {};
                        a.add(x);
                    }
                }
            }else System.out.println("File khong ton tai");
        } catch (Exception e) {
        }
    }
    public void xuat(String nd){
        System.out.println(nd);
        for (SV x:a){
            System.out.println(x);
        }
    }
    public void xuatCNTT(){
        for (SV x:a)
            if(x instanceof CNTT)
                System.out.println(x);
    }
    public void xuatKT(){
        for (SV x:a)
            if(x instanceof KinhTe)
                System.out.println(x);
    }
    public void demSV(){
        double demSV=0;
        for (SV x:a){
            if(x instanceof CNTT)
                demSV++;
        }
        System.out.println("SinhVien CNTT:"+demSV);
        System.out.println("SinhVien Kinh te:"+(a.size()-demSV));
    }
    public double tinhDTBchung(){
    	double tong=0;
        for(SV x:a){
          tong=tong+x.tinhDTB();
        }
     	return tong/a.size();
    }
    public void DTBinhMax() {
    	double max1=0;
    	for (SV x:a)
    		if(x instanceof CNTT) {
    			if(((CNTT) x).tinhDTB()> max1) {
    				max1=((CNTT) x).tinhDTB();
    			}
    	}
    	double max2=0;
    	for (SV x:a)
    		if(x instanceof KinhTe) {
    			if(((KinhTe) x).tinhDTB()> max2) {
    				max2=((KinhTe) x).tinhDTB();
    			}
    	}
    	if(max1>max2) {
    		for (SV x:a)
                if(x instanceof CNTT)
                	if(((CNTT) x).tinhDTB()== max1) {
                		System.out.println(x);
                	}    	
    	}else {
    		for (SV x:a)
                if(x instanceof KinhTe)
                	if(((KinhTe) x).tinhDTB()== max2) {
                		System.out.println(x);
                	}    	
    	}   	
    }
    public int SVGioi() {
		int dem=0;
     	for (SV x:a)
    		if(x instanceof CNTT) {
    			if(((CNTT) x).tinhDTB()>=8.0 && ((CNTT) x).tinhDTB()<9.0) {
    				dem++;
    			}  			
                        else{
    			(((KinhTe) x).tinhDTB()>=8.0 && ((KinhTe) x).tinhDTB()<9.0 {
    				dem++;
    			}	
    	}
     	return dem;
    }
    public void output(){
        xuat("1.Danh sach SV: ");
        System.out.println("\n2.Sinh Vien CNTT :");
        xuatCNTT();
        System.out.println("  Sinh Vien KT :");
        xuatKT();
        demSV();
        System.out.println("\n4.Diem trung binh chung : "+tinhDTBchung());
        System.out.println("\n5.Sinh vien co diem trung binh lon nhat: ");
        DTBinhMax();
        System.out.println("\n6.So sinh vien co hoc luc gioi: "+SVGioi());
        
    }
    public static void main(String[] args) {
        DanhSachSinhVien a = new DanhSachSinhVien() {};
        a.docFile("CNTT_KT.txt");
        a.output();
    }
          
}
