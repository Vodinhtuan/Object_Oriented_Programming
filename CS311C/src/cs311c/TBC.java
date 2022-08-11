
package cs311c;

import java.util.Scanner;

public class TBC 
{
    int n;
    
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap n(9999<n<100000): ");
        n=sc.nextInt();
    }
    
    void Output()
    {
        if(n<=9999||n>=100000) System.out.println("Khong tim.");
        else
        {
            int a,b,c,d,e, dem;
            double tb;
            tb=0;
            dem =0;
            a=n%10;
            b=(n/10)%10;
            c=(n/100)%10;
            d=(n/1000)%10;
            e=n/10000;
            if(a%2==0) 
            {
                tb+=a;
                dem++;
            }
            if(b%2==0 ) 
            {
                tb+=b;
                dem++;
            }
            if(c%2==0) 
            {
                tb+=c;
                dem++;
            }
            if(d%2==0) 
            {
                tb+=d;
                dem++;
            }
            if(e%2==0) 
            {
                tb+=e;
                dem++;
            }
            if(dem!=0) System.out.println("trung binh cac chu so chan cua "+n+" la: "+tb/dem);
            else System.out.println("trung binh cac chu so chan cua "+n+" la: "+tb);
            
        }
    }
    
    public static void main(String[] args)
    {
        TBC a= new TBC();
        System.out.println("Bui Anh Truc");
        a.Input();
        a.Output();
    }
}
