
package cs311c;

import java.util.Scanner;

public class GiaiThua 
{
    int n;
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap n: ");
        n=sc.nextInt();
    }
    double giaithua(int a)
    {
        double s=1;
        for(int i=1;i<=a;i++)
        {
            s*=i;
        } 
        return s;
    }
    double tong()
    {
        double s=1;
        for(int i=1;i<=n;i++)
        {

                if(i%2==0)
                {
                    s+=i/giaithua(i+1);
                }
                 else
                {
                    s-=i/giaithua(i+1);
                } 
        } 
        return s;
    }
    void Output()
    {
        System.out.print("s("+n+")= 1 -");
        for(int i=1;i<=n;i++)
        {
            
                if(i%2==0)
                {
                    System.out.print(i+"/"+(i+1)+"! -");
                }
                else
                {
                    System.out.print(i+"/"+(i+1)+"! +");
                } 
        }
        System.out.println("\b= "+tong());
    }
    public static void main(String[] args)
    {
        GiaiThua a=new GiaiThua();
        a.Input();
        a.Output();
    }
}
