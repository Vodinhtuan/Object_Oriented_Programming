/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs311c;

import java.util.Scanner;

public class TinhPhansobyif 
{
    char dau;
    int a,b,c,d;
    
    void Input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap phan so 1: ");
        System.out.print("nhap tu so: ");
        a=sc.nextInt();
        System.out.print("nhap mau so: ");
        b=sc.nextInt();
        System.out.println("nhap tu phan so 2: ");
        System.out.print("nhap tu so: ");
        c=sc.nextInt();
        System.out.print("nhap mau so: ");
        d=sc.nextInt();
        System.out.print("nhap phep tinh(+,-,/*,/): ");
        dau=sc.next().charAt(0);
    }
    
    void Output()
    {
        
        if (dau=='+')
        {
            System.out.println("tong 2 phan so: "+((a*d+c*b)+"/"+(b*d)));
        }
        else if (dau=='-')
        {
            System.out.println("hieu 2 phan so: "+((a*d-c*b)+"/"+(b*d)));
        }
        else if (dau=='*')
        {
            System.out.println("tich 2 phan so: "+((a*c)+"/"+(b*d)));
        }
        else if (dau=='/')
        {
            if (c==0) System.out.println("khong chia cho 0");
            else System.out.println("thuong 2 phan so: "+((a*b)+"/"+(c*b)));
        }
        else 
        {
            System.out.println("Khong tinh");
        }
    }
    
    public static void main(String[] args)
    {
        TinhPhansobyif a=new TinhPhansobyif();
        a.Input();
        a.Output();
    }
}
