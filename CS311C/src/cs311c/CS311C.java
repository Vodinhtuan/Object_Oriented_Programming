
package cs311c;

import java.util.Scanner;

public class CS311C 
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
        
        double d=b*b-4*a*c;
        if (d<0)  System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": vo nghiem");
        else if (d==0) System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": co 1 nghiem la:"+(-b/(2*a)));
        else if(d>0) System.out.println("phuong trinh "+a+"x^2 + "+b+"x + "+c+": co nghiem la: x1= "+
                ((-b+Math.sqrt(d))/(2*a))+" x2= "+((-b-Math.sqrt(d))/(2*a)));

    }
    
    public static void main(String[] args) 
    {
      CS311C a=new CS311C();
      a.Input();
      a.Output();
    }
        
    
}
