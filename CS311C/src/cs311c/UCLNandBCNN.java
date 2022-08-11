package cs311c;

import java.util.Scanner;

public class UCLNandBCNN 
{
    int a,b;
    
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        do
        {
            System.out.print("nhap a>0: ");
            a=sc.nextInt();
            if (a<=0) System.out.println("nhap lai");
        }   while (a<=0);
        do
        {
            System.out.print("nhap b>0: ");
            b=sc.nextInt();
            if (b<=0) System.out.println("nhap lai");
        }   while (b<=0);
    }
    
    int UCLN( int a, int b)
    {
        do
        {
            if (a<b) 
            {
                int temp=a;
                a=b;
                b=temp;
            }
            else a-=b;
        }   while(a!=b);
        return a;
    }
    int BCNN(int a,int b, int c)
    {
        return (a*b)/c;
    }
    
    void Output()
    {
        System.out.println("UCLN("+a+","+b+")= "+UCLN(a,b));
        System.out.println("BCNN("+a+","+b+")= "+BCNN(a,b,UCLN(a,b)));
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        UCLNandBCNN a=new UCLNandBCNN();
        a.Input();
        a.Output();
    }
}
