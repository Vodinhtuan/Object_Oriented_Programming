
package PhanSo;

import java.util.Scanner; 
import java.util.ArrayList;

public class MangPhanSo 
{
    ArrayList<PhanSo> a=new ArrayList<>();
    void Input()
    {
        int n=0;
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap so phan tu: ");
        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            a.add(nhap1phanso(i));
            a.get(i).rutgon();
        }
    }
     PhanSo max(ArrayList<PhanSo> b)
    {
        int index=0;
        double max=b.get(0).giatri();
        for(int i=1;i<b.size();i++)
        {
            if(max<b.get(i).giatri())
            {
                max=b.get(i).giatri();
                index=i;
            }
        }
        return b.get(index);
    }
    PhanSo nhap1phanso(int index)
    {
        PhanSo a=new PhanSo();
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap phan so "+(index+1));
        System.out.print("nhap tu:");
        a.setTu(sc.nextInt());
        do
        {
            System.out.print("nhap mau #0:");
            a.setMau(sc.nextInt());
        }   while(a.getMau()==0);
        return a;
    }
    void xuatmang(String nd)
    {
        System.out.print(nd);
        for (int i=0;i<a.size();i++)
            System.out.print(a.get(i)+" ");
        System.out.println();
    }
    
    void max2PS()
    {
        ArrayList<PhanSo> temp=new ArrayList<>(a);
        PhanSo max1=max(temp);
        temp.remove(max1);
        PhanSo max2=max(temp);
        System.out.println("tong lon 2 phan so : " +max1+"+"+max2+"="+max1.cong(max2));
    }
    void loaiPS()
    {
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i).giatri()<0.5) 
            {
                a.remove(i);
                i--;
            }
            
        }
        xuatmang("mang sau khi loai <1/2: ");
    }
    
    void sapXep()
    {
        PhanSo temp ;
        for (int i=0;i<a.size();i++)
        {
            for (int j=i+1;j<a.size();j++)
            {
                if (a.get(i).giatri()> a.get(j).giatri())
                {
                   temp = a.get(i);
                   a.set(i,a.get(j));
                   a.set(j,temp);
               }
            }  
        }
        xuatmang("mang sau khi sap xep: ");   
    }
    
    void Output()
    {
        xuatmang("mang vua tao: ");
        System.out.println("max: "+max(a));
        max2PS();
        loaiPS();
        sapXep();
    }
     public static void main(String[] args)
    {
        MangPhanSo a = new MangPhanSo();
        a.Input();
        a.Output();
    }
}
