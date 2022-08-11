
package cs311c;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class th2 
{
    ArrayList<Integer> a=new ArrayList<>();
    void Input()
    {
        int n=0;
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap so phan tu: ");
        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            a.add((int)(Math.random()*100));
        }
    }
  
    void xuatmang(String nd)
    {
        System.out.print(nd);
        for (int i=0;i<a.size();i++)
            System.out.print(a.get(i)+" ");
        System.out.println();
    }
    
    // cau 1
    void tongchan()
    { 
        System.out.println("tong cac so chan trong mang: ");
        int s=0;
        for(int i =0;i<a.size();i++)
        {
            if(a.get(i)%2==0) 
            {
                System.out.print(a.get(i)+" +");
                s+=a.get(i);
            }
        }
        System.out.println("\b= "+s);
    }
    
    // cau 2
    boolean checknt(int n)
    {
        if(n<2) return false;
        for (int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
    void tongnguyento()
    {
        System.out.println("tong cac so nguyen to trong mang: ");
        int s=0;
        for(int i=0;i<a.size();i++)
        {
            if(checknt(a.get(i))==true) 
            {
                System.out.print(a.get(i)+" +");
                s+=a.get(i);
            }
        }
        System.out.println("\b= "+s);
    }
    // cau 3
    boolean chexkdx(int n)
    {
        int temp=n;
        int sodao=0;
        while(n>0)
        {
            sodao=sodao*10+n%10;
            n/=10;
        }
        return !(temp-sodao!=0 || temp<10);
    }
    
    void sodoixung()
    {
        System.out.print("cac so doi xung trong mang ");
        for(int i=0;i<a.size();i++)
        {
            if(chexkdx(a.get(i))==true) System.out.print(a.get(i)+", ");
        }
        System.out.println();
    }
    //cau 4
    int Max(ArrayList<Integer> mang)
    {
        int max=mang.get(0);
        for(int i=1;i<mang.size();i++)
        {
            if(max<mang.get(i)) max=mang.get(i);
        }
        return max;
    }
    //cau 5
    void tong2sltmax()
    {
        int max = 0, x = 0, y = 0;
        for(int i=0; i<a.size()-1; i++)
        {
            if (max < a.get(i)+a.get(i+1))
            {
                max = a.get(i)+a.get(i+1);
                x = a.get(i);
                y = a.get(i+1);
            }
        }
        System.out.println("tong lon nhat cua 2 so lien tiep: "+x+" + "+y+" = "+max);
    }
    //cau 6
    void tong2max()
    {
        ArrayList<Integer> temp=a;
        int max1=Max(temp);
        temp.remove((Object)max1);
        int max2=Max(a);
        System.out.println("tong 2 so lon nhat : " +max1+"+"+max2+"="+(max1 +max2));
    }
    //cau 7
    void chen()
    {
        System.out.print("nhap so can chen: ");
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        System.out.print("nhap chi so can chen: ");
        int i=0;
        do
        {
            i=sc.nextInt(); 
            if(i<0) System.out.println("nhap lai");
        } while(i<0);
        a.add(i,x);
        xuatmang("mang sau khi chen: ");
    }
    //cau 8
    void xoa()
    {
        System.out.print("nhap chi so can xoa: ");
        Scanner sc= new Scanner(System.in);
        int i=0;
        do
        {
            i=sc.nextInt(); 
            if(i<0||i>a.size()) System.out.println("nhap lai");
        } while(i<0||i>a.size());
        a.remove((Object)a.get(i));
        xuatmang("mang sau khi xoa: ");
    }
    //cau 9
    void mangtang()
    {
      Collections.sort(a);
      xuatmang("mang sau khi sap xep tang dan: ");  
    }
    void Output()
    {
        xuatmang("mang vua tao: ");
        tongchan();
        tongnguyento();
        sodoixung();
        System.out.println("Max: "+Max(a));
        tong2sltmax();
        tong2max();
        chen();
        xoa();
        mangtang();
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        th2 a=new th2();
        a.Input();
        a.Output();
      
    }
}
