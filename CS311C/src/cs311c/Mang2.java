package cs311c;

import java.util.Scanner;
public class Mang2 
{
    int n;
    int a[] = new int[100];
    boolean ktdoixung(int a)
    {
        int temp=a;
        int sodao=0;
        while(a>0)
        {
            sodao=sodao*10+a%10;
            a/=10;
        }
        return !(temp-sodao!=0 || temp<10);
    }
    
    void input()
    {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("nhap vao n>0 :");
            n = sc.nextInt();
        } while (n<=0);
        for (int i=0; i<n;i++)
        {
           a[i]=(int)(Math.random()*100);
        } 
    }
    void sodoixung(String nd)
    {
        System.out.println(nd);
        for(int i=0;i<n;i++)
        {
            if(ktdoixung(a[i])==true) System.out.print(a[i]+", ");
        }
        System.out.println();
    }
    void xuatmang(String nd){
        System.out.print(nd);
        for (int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    void output()
    {
        xuatmang(n+"so vua tao: ");
        sodoixung("so doi xung co trong mang: ");

    }
    public static void main(String[] args) {
        Mang2 a = new Mang2();
        a.input();
        a.output();
    }
}
