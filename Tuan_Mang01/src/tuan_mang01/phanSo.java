/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_mang01;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class phanSo {
    private int tu,mau;
    //contructor

    public phanSo(int tu, int mau) {
        this.tu = tu;
        this.mau = mau;
    }

    public phanSo(int tu) {
        this.tu = tu;
        mau=1;
    }

    public int getTu() {
        return tu;
    }

    public void setTu(int tu) {
        this.tu = tu;
    }

    public int getMau() {
        return mau;
    }

    public void setMau(int mau) {
        this.mau = mau;
    }
    
    public phanSo() {
        mau=1;
    }
    public double getgiatri(){
        return 1.0*tu/mau;
    }
    public int ucln(int x,int y){
        while(x!=y)
            if(x>y) x=x-y;
            else y=y-x;
        return x;
    }
    public void rutgon(){
        if(tu*mau!=0){
            int t= ucln(Math.abs(tu),Math.abs(mau));
            tu = tu / t;mau = mau / t;  
        }
        
    }
     public phanSo cong(phanSo b) {
        phanSo c = new phanSo();
        c.tu = tu*b.mau + mau * b.tu;
        c.mau= mau * b.mau;
        c.rutgon();
        return c;
        
    }
     public phanSo tru(phanSo b) {
        phanSo c = new phanSo();
        c.tu = tu*b.mau - mau* b.tu;
        c.mau= mau * b.mau;
        c.rutgon();
        return c;       
    }
     public phanSo nhan(phanSo b) {
        phanSo c = new phanSo();
        c.tu = tu* b.tu;
        c.mau= mau * b.mau;
        c.rutgon();
        return c;   
    }
     public phanSo chia(phanSo b) {
        phanSo c = new phanSo();
        c.tu = tu*b.mau;
        c.mau= mau * b.tu;
        c.rutgon();
        return c;
        
    }
    public String toString(){
        return tu+"/"+mau;
    }
    public static void main(String []arg){
        phanSo a =new phanSo(2,3);
        phanSo b =new phanSo(-2,4);
        System.out.println(a + "+"+ b+ "=" +a.cong(b));
        System.out.println(a + "-"+ b+ "=" +a.tru(b));
        System.out.println(a + "*"+ b+ "=" +a.nhan(b));
        System.out.println(a + "/"+ b+ "=" +a.chia(b));
    }  
}  

