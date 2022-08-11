/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs311c;

import java.util.Scanner;

public class PhuongTrinhBac4 
{
    double a,b,c;
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap a #0: ");
        a=sc.nextDouble();
        System.out.print("nhap b #0: ");
        b=sc.nextDouble();
        System.out.print("nhap c #0: ");
        c=sc.nextDouble();
    }
    
    void Output()
    {
        double d=b*b-4*a*c;
        
        if (d<0)  System.out.println("phuong trinh "+a+"x^4 + "+b+"x^2 + "+c+": vo nghiem");
        if (d==0)
        {
            double t=-b/(2*a);
            if (t>0)  System.out.println("phuong trinh "+a+"x^4 + "+b+"x^2 + "+c+": co nghiem la: x1= "+
                (+Math.sqrt(t))+" x2= "+(-Math.sqrt(t)));
            if (t<0) System.out.println("phuong trinh "+a+"x^4 + "+b+"x^2 + "+c+": vo nghiem");
        }
        if (d>0)
        {
            double t1=(-b+Math.sqrt(d))/(2*a);
            double t2=(-b-Math.sqrt(d))/(2*a);
            if (t1>0&&t2>0)
            {
                System.out.println("phuong trinh "+a+"x^4 + "+b+"x^2 + "+c+": co nghiem la: x1= "+
                (+Math.sqrt(t1))+" x2= "+(-Math.sqrt(t1))+" x3= "+(-Math.sqrt(t2))+" x4= "+(-Math.sqrt(t2)));
            }
            if(t1>0&&t2<0)
            {
                 System.out.println("phuong trinh "+a+"x^4 + "+b+"x^2 + "+c+": co nghiem la: x1= "+
                (+Math.sqrt(t1))+" x2= "+(-Math.sqrt(t1)));
            }
            if(t1<0&&t2>0)
            {
                 System.out.println("phuong trinh "+a+"x^4 + "+b+"x^2 + "+c+": co nghiem la: x1= "+
                (+Math.sqrt(t2))+" x2= "+(-Math.sqrt(t2)));
            }
            if(t1<0&&t2<0)
            {
                 System.out.println("phuong trinh "+a+"x^4 + "+b+"x^2 + "+c+": vo nghiem");
            }
        }
    }
    
    public static void main(String[] args)
    {
        PhuongTrinhBac4 a=new PhuongTrinhBac4();
        a.Input();
        a.Output();
    }
}
