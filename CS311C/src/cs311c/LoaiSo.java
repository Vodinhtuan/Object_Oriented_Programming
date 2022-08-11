package cs311c;

import java.util.Scanner;

public class LoaiSo 
{
    int a;
    
    void Input()
    {
        Scanner sc= new Scanner(System.in);
        do
        {
            System.out.print("nhap a>0: ");
            a=sc.nextInt();
            if (a<=0) System.out.println("nhap lai");
        }   while (a<=0);
    }
    
    int loaiso(int a)
    {
        int temp=0;
        do
        {
            if(a%10!=0 && a%10!=5) 
            {
                temp+=a%10;
                if(a>9) temp*=10;
                a/=10;
            }
            else a/=10;
        }   while(a>0);
        do
        {
            a+=temp%10;
            if(temp>9) a*=10;
            temp/=10;
        }   while(temp>0);
        
        return a;
    }
   
    void Output()
    {
        System.out.println(a+" sau khi loai so: "+loaiso(a));
    }
    public static void main(String[] args)
    {
        System.out.println("Bui Anh Truc");
        LoaiSo a=new LoaiSo();
        a.Input();
        a.Output();
    }
}

