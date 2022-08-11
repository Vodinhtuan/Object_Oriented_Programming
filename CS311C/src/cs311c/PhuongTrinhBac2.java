/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs311c;
import java.util.Scanner;

public class PhuongTrinhBac2 
{
    

    double a,b,c;
    
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap a: ");
        a=sc.nextDouble();
        System.out.print("nhap b: ");
        b=sc.nextDouble();
        System.out.print("nhap c: ");
        c=sc.nextDouble();
    }
    void Output()
    {
        if (a==0)
        {
            if(b==0)
            {
                if(c==0) System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": vo so nghiem");
                else System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": vo nghiem");
            }
            else System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": co 1 nghiem la:"+(-c/b));
        }
        else
        {
            double d=b*b-4*a*c;
            if (d<0)  System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": vo nghiem");
            else if (d==0) System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": co 1 nghiem la:"+(-b/(2*a)));
            else if(d>0) System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": co nghiem la: x1= "+
                ((-b+Math.sqrt(d))/(2*a))+" x2= "+((-b-Math.sqrt(d))/(2*a)));
        }
    }
    
    public static void main(String[] args) 
    {
      PhuongTrinhBac2 a=new PhuongTrinhBac2();
      a.Input();
      a.Output();
    }
}
