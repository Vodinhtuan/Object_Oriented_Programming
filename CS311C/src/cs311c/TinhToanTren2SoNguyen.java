
package cs311c;

import java.util.Scanner;

public class TinhToanTren2SoNguyen 
{
    char dau;
    int a,b;
    
    void Input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("nhap a: ");
        a=sc.nextInt();
        System.out.print("nhap a: ");
        b=sc.nextInt();
        System.out.print("nhap phep tinh: ");
        dau=sc.next().charAt(0);
    }
    
    void Output()
    {
        if (dau=='+')
        {
            System.out.println(a+" + "+b+" = "+(a+b));
        }
        else if (dau=='-')
        {
            System.out.println(a+" - "+b+" = "+(a-b));
        }
        else if (dau=='*')
        {
            System.out.println(a+" * "+b+" = "+(a*b));
        }
        else if (dau=='/')
        {
            if(b!=0) System.out.println(a+" / "+b+" = "+(a/b));
            else System.out.println("error");
        }
        else 
        {
            System.out.println("Khong tinh");
        }
    }
    
    public static void main(String[] args)
    {
        TinhToanTren2SoNguyen a=new TinhToanTren2SoNguyen();
        a.Input();
        a.Output();
    }
}
