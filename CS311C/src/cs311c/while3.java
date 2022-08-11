
package cs311c;

import java.util.Scanner;

public class while3 
{
    int n=0;
    
    boolean ladoixung(int i,int sodao)
    {
        return !(i!=sodao || i<10);
    }
    
    int daoso(int i)
    {
        int s=0;
        while(i>0)
        {
            s+=i%10;
            i/=10;
            if(i>0) s*=10;
        }
        return s;
        
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
         System.out.println("cac so doi xung tu 1 toi "+n+" la: ");
         for(int i=1;i<=n;i++)
         {
             if(ladoixung(i,daoso(i))==true) System.out.print(i+", ");
         }
     }
     
     public static void main(String[] args)
     {
         while3 a= new while3();
         a.Input();
         a.Output();
     }
    
}
