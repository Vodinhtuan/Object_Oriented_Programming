/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_mang01;

/**
 *
 * @author Admin
 */
public class lec10_PhanSo {
    private int tu,mau;
    //constructors
    public lec10_PhanSo(){  //0/1
        tu=0; mau=1;
    }
    public lec10_PhanSo(int x){ //1/x
        tu=1; mau=x;
    }
    public lec10_PhanSo(int t, int m){  //t/m
        tu=t; mau=m;
    }
    public int getTu(){
        return tu;
    }
    public void setTu(int tu){
        this.tu=tu;
    }
    public int getMau(){
        return mau;
    }
    public void setMau(int mau){
        this.mau=mau;
    }
    public String  toString(){
        return tu+"/"+mau;
    }
    public void rutGon(){
        if(tu*mau!=0){
            int a = Math.abs(tu);
            int b = Math.abs(mau);
            while(a!=b)
                if(a>b)a=a-b;
                else b=b-a;
            tu = tu/a; mau= mau/a;
        }
    }
    lec10_PhanSo cong(lec10_PhanSo b){
        lec10_PhanSo c = new lec10_PhanSo();
        c.tu = tu *b.mau + mau * b. tu;
        c.mau = mau * b.mau;
        c.rutGon();
        return c;
    }
    lec10_PhanSo tru(lec10_PhanSo b){
        lec10_PhanSo c = new lec10_PhanSo();
        c.tu = tu *b.mau - mau * b. tu;
        c.mau = mau * b.mau;
        c.rutGon();
        return c;
    }
    lec10_PhanSo nhan(lec10_PhanSo b){
        lec10_PhanSo c = new lec10_PhanSo();
        c.tu = tu * b. tu;
        c.mau = mau * b.mau;
        c.rutGon();
        return c;
    }
    lec10_PhanSo chia(lec10_PhanSo b){
        lec10_PhanSo c = new lec10_PhanSo();
        c.tu = tu *b.mau;
        c.mau = mau * b.tu;
        c.rutGon();
        return c;
    }
    public static void main (String[] args){
        lec10_PhanSo a = new lec10_PhanSo();
        System.out.println("a="+a.tu+"/"+a.mau);
        lec10_PhanSo b = new lec10_PhanSo(3);  //b=1/3
        System.out.println("b="+b.tu+"/"+b.mau);
        lec10_PhanSo c = new lec10_PhanSo(2,5);
        System.out.println("c="+c.tu+"/"+c.mau);
        System.out.println(b + "+" +c+"="+b.cong(c));
        System.out.println(b + "-" +c+"="+b.tru(c));
        System.out.println(b + "*" +c+"="+b.nhan(c));
        System.out.println(b + "/" +c+"="+b.chia(c));
    }

}
