
package cs311c;

import java.util.Scanner;

public class TimSoChan 
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
            int a,b,c,d,e,max;
            max=0;
            a=n%10;
            b=(n/10)%10;
            c=(n/100)%10;
            d=(n/1000)%10;
            e=n/10000;
            if(a%2==0 &&a>max &&a!=0) max=a;
            if(b%2==0 &&b>max &&b!=0) max=b;
            if(c%2==0 &&c>max &&c!=0) max=c;
            if(d%2==0 &&d>max &&d!=0) max=d;
            if(e%2==0 &&e>max &&e!=0) max=e;
            if(max!=0) System.out.println("chu so chan lon nhat cua "+n+" la: "+max);
            else System.out.println("khong co so chan");
        }
    }
    
    public static void main(String[] args)
    {
        TimSoChan a= new TimSoChan();
        System.out.println("Bui Anh Truc");
        a.Input();
        a.Output();
    }
}
