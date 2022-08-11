
package cs311c;

import java.util.Scanner;

public class th1 
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
        switch (dau)
        {
            case '+':System.out.println("tong 2 phan so: "+((a*d+c*b)+"/"+(b*d))); break;
            case '-':System.out.println("hieu 2 phan so: "+((a*d-c*b)+"/"+(b*d)));break;
            case '*':System.out.println("tich 2 phan so: "+((a*c)+"/"+(b*d))); break;
            case '/':if (c==0) System.out.println("khong chia cho 0");
                        else System.out.println("thuong 2 phan so: "+((a*b)+"/"+(c*b))); break;
                     
            default:System.out.println("Khong tinh");
            
        }
    }
    
    public static void main(String[] args)
    {
        th1 a=new th1();
        a.Input();
        a.Output();
    }
}
