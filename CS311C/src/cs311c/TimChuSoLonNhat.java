/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs311c;

import java.util.Scanner;

public class TimChuSoLonNhat 
{
    int n;
    void Input()
    {
        System.out.print("nhap so: ");
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
    }
    void Output()
    {
        if(n<=9999 || n>=100000) System.out.println("Khong tim.");
        else
        {
            int a,b,c,d,e,max;
            a=n%10;
            b=(n/10)%10;
            c=(n/100)%10;
            d=(n/1000)%10;
            e=n/10000;
            max=a;
            if(b>max) max=b;
            if(c>max) max=c;
            if(d>max) max=d;
            if(e>max) max=e;
            System.out.println("chu so lon nhat cua: "+n+" la: "+max);
        }
    }
    public static void main(String[] args)
    {
        TimChuSoLonNhat a =new TimChuSoLonNhat();
        a.Input();
        a.Output();
    }
}
