
package cs311c;

import java.util.Scanner;

public class while2 
{
    int n=0;
    
    void tong()
    {
        int s=0;
        while(n>0)
        {
            System.out.print(n%10+"+");
            s+=n%10;
            n/=10;
        }
        System.out.println("\b="+s);
    }
    
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        do
        {
            System.out.print("nhap n: ");
            n=sc.nextInt(); 
            if(n==0) System.out.println("nhap lai ");
        } while(n<=0);
    }
     void Output()
     {
         System.out.println("tong cac chi so cua "+n+" la: ");
         tong();
     }
     
     public static void main(String[] args)
     {
         while2 a= new while2();
         a.Input();
         a.Output();
     }
}
