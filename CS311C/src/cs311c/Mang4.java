
package cs311c;

import java.util.Scanner;
import java.util.ArrayList;

public class Mang4 
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
    void tongchiahet3()
    {
        System.out.print("tong cac so chia het cho 3= ");
        int s=0;
        for(int i=0;i<a.size();i++)
        {
            if (a.get(i)%3==0) 
            {
                s+=a.get(i);
                System.out.print(a.get(i)+" +");
            }
        }
        System.out.println("\b= "+s);
    }
    int Max(ArrayList<Integer> b)
    {
        int max=b.get(0);
        for(int i=1;i<b.size();i++)
        {
            if(max<b.get(i)) max=b.get(i);
        }
        return max;
    }
    int tongmaxlt()
    {
        ArrayList<Integer> temp=new ArrayList<>();
        for(int i=0;i<a.size()-1;i++)
        {
            temp.add(a.get(i)+a.get(i+1));
        }
        return Max(temp);
        
    }
    int tong2ln()
    {
        int a1=Max(a);
        a.remove(a.indexOf(a1));
        int a2=Max(a);
        return a1+a2;
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
        tongchiahet3();
        System.out.println("Max: "+Max(a));
        System.out.println("tong lon nhat cua 2 so lien tiep: "+tongmaxlt());
        System.out.println("tong 2 so lon nhat : "+tong2ln());
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        Mang4 a=new Mang4();
        a.Input();
        a.Output();
      
    }
}
