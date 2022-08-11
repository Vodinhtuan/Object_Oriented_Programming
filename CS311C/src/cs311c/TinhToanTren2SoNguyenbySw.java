/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs311c;

import java.util.Scanner;

public class TinhToanTren2SoNguyenbySw 
{
    char dau;
    int a,b,c,d;
    
    void Input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("nhap tu phan so 1: ");
        a=sc.nextInt();
        System.out.print("nhap mau phan so 1: ");
        b=sc.nextInt();
        System.out.print("nhap tu phan so 2: ");
        c=sc.nextInt();
        System.out.print("nhap mau phan so 3: ");
        d=sc.nextInt();
        System.out.print("nhap phep tinh: ");
        dau=sc.next().charAt(0);
    }
    
    void Output()
    {
        switch (dau)
        {
            case '+':System.out.println(a+" + "+b+" = "+(a+b)); break;
            case '-':System.out.println(a+" - "+b+" = "+(a-b)); break;
            case '*':System.out.println(a+" * "+b+" = "+(a*b)); break;
            case '/':if(b!=0) System.out.println(a+" / "+b+" = "+(a/b));
                     else System.out.println("error"); break;
            default:System.out.println("Khong tinh");
            
        }
    }
    
    public static void main(String[] args)
    {
        TinhToanTren2SoNguyenbySw a=new TinhToanTren2SoNguyenbySw();
        a.Input();
        a.Output();
    }
}
