/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_mang01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MangDiem {
    private ArrayList<DiemOxy> a= new ArrayList<DiemOxy>();
    
    public void input(){
        Scanner kb = new Scanner(System.in);
        int n;
        do{
            System.out.print("Nhập số điểm >0:");
            n=kb.nextInt();
           }while (n<=0);
        for(int i=1;i<=n;i++){
            System.out.print("Nhập điểm thứ " +i+ ":");
            int x=kb.nextInt();
            int y=kb.nextInt();
            a.add(new DiemOxy (x,y));
        }
    }  
    void xuatMangDiem(String noiDung){
        System.out.println("Các Điểm");
        for(DiemOxy x:a)
            System.out.print(x);
        System.out.println(" ");
    }
    void output(){
        xuatMangDiem("Các điểm vừa đọc: ");
    }
     public DiemOxy min(DiemOxy a[], int n){
        DiemOxy min =a[0];
        for(int i=1; i<n; i++)
            if(modul(min)>modul(a[i]))
                min = a[i];
        return min;
    }
     void maxkhoangCach (DiemOxy a[],int n){
    DiemOxy x = a[0], y=a[1];
    for(int i=0; i<n-1; i++)
        for(int j=i+1; i<n; j++)
            if(khoangCach(x,y)<khoangCach(a[i],a[j])){
                x = a[i], y=[j];
            }
    public static void main(String[] args) {
        MangDiem a=new MangDiem();
        a.input();
        a.output();
    }
}

// void xuatMangDiem(char nd[], DiemOxy a[], int n){
//    printf(%s, nd);
//    for(int i=0; i<n; i++)
//    xuat1Diem (a[i]);
//}
//float khoangCach(DiemOxy x, DiemOxy y){
//    return sprt(pow(x.ox-y.ox,2)+pow(x.oy-y.oy,2));
//}
//float modul(DiemOxy x){
//    return sprt(x.ox*x.ox+x.oy*x.oy);
//}
//1.
//DiemOxy min(DiemOxy a[], int n){
//    DiemOxy min =a[0];
//    for(int i=1; i<n; i++)
//        if(modul(min)>modul(a[i]))
//            min = a[i];
//        return min;
//}
//void maxkhoangCach (DiemOxy a[],int n){
//    DiemOxy x = a[0], y=a[1];
//    for(int i=0; i<n-1; i++)
//        for(int j=i+1; i<n; j++)
//            if(khoangCach(x,y)<khoangCach(a[i],a[j])){
//                x = a[i], y=[j];
//            }
//}
//    printf("\n Max khoang cach: "); xuat1Diem(x); xuat1Diem(y);
//    printf("= %4f",khoangCach(x,y));
//int laTamGiac(float a,float b, float c){
//    if(a+b>c && a+c>b && b+c>a) return 1;
//    return 0;
//}
//float dienTich(DiemOxy a, DiemOxy b, DiemOxy c){
//    float ab,ac,bc;
//    ab=khoangCach(a,b);
//    ac=khoangCach(a,c);
//    bc=khoangCach(b,c);
//    if(laTamGiac(ab,bc,ac)){
//        float s,p;
//        p=(ab+bc+ac)/2;
//        s= sqrt(p*(p-ab)*(p-bc)*(p-ac));    
//        return s;
//    }else return 0;
//}
//void maxTG(DiemOxy a[], int n){
//    DiemOxy x=a[0], y=a[1], z=a[2];
//    for(int i=0; i<n-2; i++)
//        for(int j=i+1; j<n-1; j++)
//            for(int k=j+1; k<n; k++)
//                if(dienTich(x,y,z)<dienTich(a[i],a[j],a[k])){
//                    x = a[i]; y=a[j]; z=a[k];
//                }
//    printf("\n Max Tam Giac: ");xuat1Diem(x); xuat1Diem(y); xuat1Diem(z);
//    printf(" = %4f",dienTich(x,y,z));
//}
//main(){
//    DiemOxy a[100];
//    int n;
//    n = nhap1SoDuong();
//    nhapMangDiem(a,n);
//    xuatMangDiem("Cac diem: ", a, n);
//    DiemOxy y= min(a,n);
//    printf("\n diem gan tam nhat: "); xuat1Diem(y); printf("=: %4f,",modul(y));
//    maxkhoangCach(a,n);
//    maxTG(a,n);
//}