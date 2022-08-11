package cs311c;

import java.util.Scanner;

public class While 
{
    double n=0,x=0;
    int giaithua(int n)
    {
        if (n==1) return 1;
        return n*giaithua(n-1);     
    }
    
    double tong()
    {
        double s=1;
        int i=1;
        while(i<=n)
        {
            s+=Math.pow(x, i)/giaithua(i);
            i++;
        }
        return s;
    }
    
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap x: ");
        x=sc.nextDouble(); 
        do
        {
            System.out.print("nhap n: ");
            n=sc.nextDouble(); 
            if(n==0) System.out.println("nhap lai ");
        } while(n<=0);
        
        
    }
     void Output()
     {
         System.out.println("E^"+x+" = "+tong());
     }
     
     public static void main(String[] args)
     {
         While a= new While();
         a.Input();
         a.Output();
     }
}
