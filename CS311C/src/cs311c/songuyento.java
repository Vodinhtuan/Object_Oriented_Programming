package cs311c;

import java.util.Scanner;

public class songuyento 
{
    int n;
    
    boolean KT(int n)
    {
        if(n<2) return false;
        for (int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) return false;
        }
        return true;
    }
    
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap n: ");
        n=sc.nextInt();
    }
    
    void Output()
    {
        System.out.println("Cac so nguyen to <="+n);
        for (int i=2;i<=n;i++)
        {
            if(KT(i)==true) System.out.print(i+", ");
        }
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        songuyento a =new songuyento();
        a.Input();
        a.Output();
    }
}
