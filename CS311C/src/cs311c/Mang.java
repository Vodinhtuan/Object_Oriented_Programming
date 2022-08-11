package cs311c;

import java.util.Scanner;
public class Mang 
{
    int n;
    int a[] = new int[100];
     boolean KT(int n)
    {
        if(n<2) return false;
        for (int i=2;i<=Math.sqrt(n);i++)
        {
            if(n%i==0) return false;
        }
        return true;
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
    void songuyento(String nd)
    {
        System.out.println(nd);
        for(int i=0;i<n;i++)
        {
            if(KT(a[i])==true) System.out.print(a[i]+", ");
        }
        System.out.println();
    }
    void xuatmang(String nd)
    {
        System.out.print(nd);
        for (int i=0;i<n;i++)
            System.out.print(a[i]+" ");
        System.out.println();
    }
    void output()
    {
        xuatmang(n+"so vua tao: ");
        songuyento("so nguyen to co trong mang: ");
    }
    public static void main(String[] args) {
        Mang a = new Mang();
        a.input();
        a.output();
    }
}
