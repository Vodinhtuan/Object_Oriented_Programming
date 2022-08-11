package cs311c;

import java.util.Scanner;

public class TBnguyento 
{
    int n;
    
    boolean KT(int n)
    {
        if(n<2) return false;
        for (int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
    
    double TB(int n)
    {
        double tb=0;
        int dem=0;
         for (int i=2;i<=n;i++)
        {
            if(KT(i)==true) 
            {
                dem++;
                tb+=i;
            }
        }
         return tb/dem;
    }
    
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap n: ");
        n=sc.nextInt();
    }
    
    void Output()
    {
        System.out.println("Trung binh cong cacc so nguyen to <="+n+" : "+TB(n));
       
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        TBnguyento a =new TBnguyento();
        a.Input();
        a.Output();
    }
}