/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_mang01;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Admin
 */
public class arrayList {
    ArrayList<Integer> a=new ArrayList<>();
     void input(){
        Scanner kb=new Scanner(System.in);
        int n;
        do{
            System.out.print("Nhập số phần tử mảng >0:");
            n=kb.nextInt();
        }while(n<=0);
        for(int i=0;i<n;i++){
           int x=(int)(Math.random()*100);
           a.add(x);
        }
    }
     void xuat(String nd){
         System.out.print(nd); 
          for(int i=0;i<a.size();i++){
           System.out.print(a.get(i)+" ");  
        }
     }
    int timMax(){
         int x=a.get(0);
          for(int i=1;i<a.size();i++){
              if(x<a.get(i)) x=a.get(i);
        }
          return x;
     }
    int timMin(){
         int x=a.get(0);
          for(int i=1;i<a.size();i++){
              if(x>a.get(i)) x=a.get(i);
        }
          return x;
     }
    int timMaxlientiep(){
        int x=a.get(0)+a.get(1);
        for(int i=1;i<a.size()-1;i++){
              if(x<a.get(i)+a.get(i+1)) x=a.get(i)+a.get(i+1);
        }
          return x;
    }
    boolean laNguyenTo(int x){
        int dem=0;
        for (int i=1;i<=x;i++)
            if(x%i==0)dem++;
        return dem==2;
    }
    double tBCNT(){
        double s=0,d=0;
        for(Integer x:a)
            if(laNguyenTo(x)){
                s=s+x;
                d++;
            }
       if(d==0) return 0;
       else return s/d;
    }
    int daoSo(int x){
        int s=0;
        while(x>0){
            s=s*10+x%10;
            x=x/10;
        }
        return s;
    }
    boolean laDoiXung(int x){
        return x>0 && daoSo (x)==x;
    }
    int tongDX(){
        int s=0;
          for (int i=0; i<a.size();i++)
              if(laDoiXung(a.get(i))) s=s +a.get(i);
          return s;
    }
    int tongCacChuSo (int x){
        int s=0;
        while(x>0){
            s=s+x%10;
            x=x/10;
        }
        return  s;
    }
    void lietKe(){
        System.out.print("\n Các số có tổng các chữ số >0;");
        for(Integer x:a)
            if(tongCacChuSo(x)>10)
                System.out.print(x+" ");
    }
    void sapXep(){
        for(int i=0;i<a.size()-1;i++)
            for(int  j=i+1;j<a.size();j++)
                if(a.get(i)>a.get(i)){
                    int t =a.get(i);
                    a.set(i,a.get(j));
                    a.set(j, t);
                }
    }
    void chenTang(int x){
        int i;
        for(i=0;i<a.size();i++)
            if(a.get(i)>=x)break;
        a.add(i,x);
    }
    void xoaAll(int x){
        while(a.contains(x))
            a.remove((Object)x);
    }
     void output(){
          xuat("Mảng vừa tạo ngẫu nhiên: ");
          System.out.println(" ");
          System.out.println("Max-Min="+timMax()+"-"+timMin()+"="+(timMax()-timMin()));
          System.out.println("Max 2 số liên tiếp = "+timMaxlientiep());
          System.out.println("Trung bình cộng các số nguyên tố = "+tBCNT());
          System.out.println("Trung bình cộng các số nguyên tố = "+tongDX());
         lietKe();
         Collections.sort(a);
         //sắp xếp();
         int x,k;
         Scanner kb= new Scanner(System.in);
         System.out.print("\n Nhập giá trị và chỉ số cần thiết: ");
         x=kb.nextInt();
         k=kb.nextInt();
         a.add(k,x);
         chenTang(x);
         xuat("\n Mảng sau tăng là:");
         xoaAll(x);
         xuat("\n Mảng sau xóa: ");
            
;     }
     public static void main(String[] args){
        arrayList a= new arrayList();
        a.input();
        a.output();
    }   
}
