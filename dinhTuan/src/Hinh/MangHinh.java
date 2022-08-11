/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hinh;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MangHinh {
    private ArrayList<HinhVuong>a= new ArrayList<HinhVuong>();
    public void docFile(String tenFile){
        try {
            File f =new File(tenFile);
            if(f.exists()){                   // tồn tại file.
                Scanner read = new Scanner(f);
                while(read.hasNext()){        // chưa đọc hết.
                    Scanner line = new Scanner(read.nextLine()); // đọc 1 dòng.
                    double c1,c2;
                    c1=line.nextDouble();
                    if(line.hasNext()){
                        c2=line.nextDouble();
                        a.add(new HInhChuNhat(c1,c2));
                    }else a.add(new HinhVuong(c1));
                }
            }else System.out.println("Không tồn tại File");
        } catch (Exception e) {
        }
    }
    public HinhVuong maxdienTich(){
        HinhVuong x=a.get(0);
        for(int i=1; i<a.size();i++)
            if(x.dienTich()<a.get(i).dienTich())
                x=a.get(i);
        return x;
    }
    public HInhChuNhat maxDienTichHCN(){
        HInhChuNhat x=null;
        int i=0;
        for(i=0; i<a.size();i++)
            if(a.get(i)instanceof HInhChuNhat){
                x=(HInhChuNhat)a.get(i); break;
            }
        for(i=i+1;i<a.size();i++)
            if(a.get(i)instanceof HInhChuNhat)
                if(x.dienTich()<((HInhChuNhat)a.get(i)).dienTich())
                    x=(HInhChuNhat)a.get(i);
        return x;
    }
    public int demVuong(){
        int demCN=0;
        for(int i=0;i<a.size();i++)
            if(a.get(i)instanceof HInhChuNhat)demCN++;
        return a.size()-demCN;
    }
    public void tangDienTich(){
        for(int i=0; i<a.size()-1;i++)
            for(int j=i+1; j<a.size();j++)
                if(a.get(i).dienTich()>a.get(i).dienTich()){
                    HinhVuong x=a.get(i);
                    a.set(i, a.get(j));
                    a.set(j, x);
                }
    }
    public void xuat(){
        for(HinhVuong x:a)
            System.out.println(x);
    }
    public void output(){
        System.out.println("Nội Dung file: ");
        xuat();
    }
    public static void main(String[] args) {
        MangHinh a = new MangHinh();
        a.docFile("Hinh.txt");
        a.output();
    }
}
