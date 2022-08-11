
package cs311c;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;


public class Mang5 
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
    
    void sort()
    {
        for (int i=0;i<a.size();i++)
        {
            for (int j=i+1;j<a.size();j++)
            {
                if(a.get(j)<a.get(i))
                {
                    int temp= a.get(i);
                    a.set(i,a.get(j)); 
                    a.set(j,temp);
                     
                }
            }
        }
        xuatmang("mang sau khi sap xep: ");
    }
    void insert()
    {
        System.out.print("nhap so an chen: ");
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        /*for (int i=a.size();i>=0;i--)
        {
            if(i==a.size()) a.add(0);
            if(x>a.get(i)) 
            {
                a.set(i+1,x);
                break;
            }
            if(x<=a.get(i)) 
            {
                
                a.set(i+1,a.get(i));
            }
            
            if(i==0) a.set(0,x);
        }
        xuatmang("c1 mang sau khi chen "+x+": ");*/
        for (int i=a.size();i>=0;i--)
        {
            
            if(x>a.get(i)) 
            {
                a.add(i+1,x);
                break;
            }
            if(i==0) a.add(0,x);
        }
        xuatmang("c2 mang sau khi chen "+x+": ");
    }
    
    void delete()
    {
        System.out.print("nhap so an xoa: ");
        Scanner sc= new Scanner(System.in);
        int x=sc.nextInt();
        for(int i=0;i<a.size();i++)
        {
            if(a.get(i)==x)
            {
                a.remove((Object)x);
                //a.remove(i);
                i-=1;
            }
        }
        xuatmang("mang sau khi xoa "+x+": ");
    }
    
     void xuatmang(String nd)
    {
        System.out.print(nd);
        for (int i=0;i<a.size();i++)
            System.out.print(a.get(i)+" ");
        System.out.println();
    }
    void Output()
    {
        xuatmang("mang vua tao: ");
        sort();
        insert();
        delete();
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        Mang5 a=new Mang5();
        a.Input();
        a.Output();
      
    }
}
