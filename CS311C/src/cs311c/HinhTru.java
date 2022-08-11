
package cs311c;

import java.util.Scanner;

public class HinhTru 
{
    int r,h;

    void input()
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("nhap ban kinh day: ");
        r=sc.nextInt();
        System.out.print("nhap ban chieu cao: ");
        h=sc.nextInt();
    }
    
    void output()
    {
        
        System.out.println("Sd hinh tru: "+3.1415*r*r);
        System.out.println("Sxq hinh tru: "+2*3.1415*r*h);
        System.out.println("Stp hinh tru: "+(2*3.1415*r*h+2*3.1415*r*r));
        System.out.println("V hinh tru: "+3.1415*r*r*h);
    }
    
    public static void main(String args[])
    {
        HinhTru h1=new HinhTru();
        h1.input();
        h1.output();
    }
}
