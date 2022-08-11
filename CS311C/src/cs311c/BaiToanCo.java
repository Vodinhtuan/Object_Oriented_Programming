
package cs311c;

import java.util.Scanner;

public class BaiToanCo 
{
    int x,y,cho,ga;
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("nhap so con: ");
        x=sc.nextInt();
        System.out.print("nhap so chan: ");
        y=sc.nextInt();
    }
    
    void Output()
    {
        if (y%2!=0 || y<2*x || y>4*x) System.out.println("du lieu sai khong tinh.");
        else
        {
            cho=(y-2*x)/2;
            ga=x-cho;
            
            System.out.println("cho: "+cho+"\nga: "+ga);
        }
    }
    
    public static void main(String[] args)
    {
        BaiToanCo a=new BaiToanCo();
        a.Input();
        a.Output();
    }
}
